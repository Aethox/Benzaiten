package benzaiten.Servicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author aetox
 */
public class SesionadorServidor extends Thread {

    private Socket cliente;
    private String login;
    private boolean SearchFlag, InsertFlag, MsgFlg, CloseFlag, SessionFlag = false;
    private final RecopiladorServer server;
    List<SesionadorServidor> listaSesiones = null;
    List<String> arguments = null;
    DBConnection DB = null;
    private OutputStream outputStream;
    private PrintWriter out;
    private boolean RegisterFlag;
    private int query;
    private String parts[];
    private String results[];
    private boolean LogsFlag;
    private boolean ActFlag;
    private boolean InfFlag;

    public SesionadorServidor(RecopiladorServer server, Socket cliente) {
        this.cliente = cliente;
        this.server = server;
        listaSesiones = server.getSesiones();
        String Driver = "com.mysql.cj.jdbc.Driver";
        String URL_bd = "jdbc:mysql://localhost:3306/BD_Benzaiten";
        String User = "root";
        String psw = "root";
        DB = new DBConnection(Driver, URL_bd, User, psw);
    }

    @Override
    public void run() {
        try {
            this.ObtenerCliente();
        } catch (IOException ex) {
            Logger.getLogger(SesionadorServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getLogin() {
        return login;
    }

    public void ObtenerCliente() throws IOException {
        InputStream inputStream = cliente.getInputStream();
        this.out = new PrintWriter(cliente.getOutputStream(), true);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        //System.out.println(listaSesiones);
        while ((line = reader.readLine()) != null) {
            this.FlagControl(line);
            if (this.SearchFlag) {
                ResultSet s;
                String orden = null;
                String SearchResult = null;
                orden = this.StringSep(line, 1);
                this.StringAdd();
                s = DB.consultarBD(orden);
                try {
                    while (s.next()) {
                        for (int i = 0; i < this.arguments.size(); i++) {
                            this.results[i] = s.getString(this.arguments.get(i));
                        }
                    }
                    SearchResult = String.join("-", results);
                    this.enviar(SearchResult);
                } catch (SQLException ex) {
                    Logger.getLogger(SesionadorServidor.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.SearchFlag = false;
            } else {
                if (this.InsertFlag) {
                    String orden = null;
                    orden = this.StringSep(line, 1);

                    DB.modificarBD(orden);
                    this.InsertFlag = false;
                } else {
                    if (this.CloseFlag) {
                        for (int i = 0; i < this.listaSesiones.size(); i++) {
                            if (this.listaSesiones.get(i).getLogin().equals(this.login)) {
                                this.listaSesiones.remove(i);
                            }
                        }
                        cliente.close();
                        break;
                    } else {
                        if (this.MsgFlg) {

                            String msg = this.StringSep(line, 1);
                            String Reciever = this.StringSep(line, 2);
                            this.enviarmsg(Reciever, msg);
                        } else {
                            if (this.SessionFlag) {
                                ResultSet s;
                                String orden = null;
                                String possiblelog = null;
                                String compare2 = null;
                                String SessionResult = null;
                                orden = this.StringSep(line, 1);
                                compare2 = this.StringSep(line, 2);
                                s = DB.consultarBD(orden);
                                try {
                                    while (s.next()) {
                                        SessionResult = s.getString("Contra_Usuario_Registro");
                                        possiblelog = s.getString("Nombre");
                                    }
                                } catch (SQLException ex) {
                                    Logger.getLogger(SesionadorServidor.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                if (this.Session(SessionResult, compare2)) {
                                    this.enviar("1-" + possiblelog);

                                    this.login = possiblelog;
                                    this.server.setLogin(login);
                                } else {
                                    this.enviar("0");

                                }
                                this.SessionFlag = false;
                            } else {
                                if (this.RegisterFlag) {
                                    ResultSet s;
                                    String orden = null;
                                    String SearchResult = null;
                                    boolean res = false;
                                    orden = this.StringSep(line, 1);
                                    s = DB.consultarBD(orden);
                                    try {
                                        while (s.next()) {
                                            res = true;
                                        }
                                        if (res) {
                                            this.enviar("1");
                                        } else {
                                            this.enviar("0");
                                        }
                                    } catch (SQLException ex) {
                                        Logger.getLogger(SesionadorServidor.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    this.RegisterFlag = false;
                                } else {
                                    if (this.LogsFlag) {
                                        String sesiones[] = new String[this.listaSesiones.size()];
                                        String ver = null;
                                        this.LogsObtainer();
                                        for (int i = 0; i < this.listaSesiones.size(); i++) {
                                            sesiones[i] = this.listaSesiones.get(i).getLogin();
                                        }

                                        String ses = String.join("-", sesiones);
                                        this.enviar(ses);
                                        this.LogsFlag = false;
                                    } else {
                                        if (this.ActFlag) {
                                            ResultSet s, s2;
                                            String orden1 = null;
                                            String orden2 = null;
                                            String SearchResult = null;
                                            String send2C = null;
                                            ArrayList<Integer> resultList = new ArrayList<Integer>();
                                            ArrayList<String> resultMSG = new ArrayList<String>();
                                            orden1 = "SELECT tbl_chats.ID_Chat FROM tbl_chats WHERE tbl_chats.Correo_Contacto =" + " '" + this.StringSep(line, 1) + "'" + " AND tbl_chats.Sender = " + "'" + this.StringSep(line, 2) + "'" + " OR tbl_chats.Correo_Contacto = " + "'" + this.StringSep(line, 2) + "'" + " AND tbl_chats.Sender = " + "'" + this.StringSep(line, 1) + "'" + " ORDER BY tbl_chats.ID_Chat";
                                            s = DB.consultarBD(orden1);
                                            boolean continuar = false;
                                            try {
                                                while (s.next()) {
                                                    continuar = true;
                                                    for (int i = 1; i < 2; i++) {
                                                        resultList.add(s.getInt(i));
                                                    }

                                                }
                                                if (continuar) {
                                                    SearchResult = "tbl_chats.ID_Chat = " + resultList.get(0);
                                                    for (int j = 1; j < resultList.size(); j++) {

                                                        SearchResult = SearchResult + " OR tbl_chats.ID_Chat = " + resultList.get(j);
                                                    }

                                                    orden2 = "SELECT tbl_chats.Mensaje FROM tbl_chats WHERE " + SearchResult;
                                                    s = DB.consultarBD(orden2);
                                                    while (s.next()) {
                                                        for (int c = 1; c < 2; c++) {
                                                            resultMSG.add(s.getString(c));
                                                        }
                                                    }
                                                    send2C = resultMSG.get(0);

                                                    for (int k = 1; k < resultMSG.size(); k++) {

                                                        send2C = send2C + "-" + resultMSG.get(k);
                                                    }

                                                    this.enviar(send2C);
                                                } else {

                                                    this.enviar("");
                                                }
                                            } catch (SQLException ex) {
                                                Logger.getLogger(SesionadorServidor.class.getName()).log(Level.SEVERE, null, ex);
                                            } finally {
                                                this.ActFlag = false;
                                            }

                                        } else {
                                            if (this.InfFlag) {

                                                this.InfFlag = false;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void enviarmsg(String Reciever, String msg) {
        String sendto = Reciever;
        String body = msg;

        for (SesionadorServidor worker : this.listaSesiones) {
            if (sendto.equalsIgnoreCase(worker.getLogin())) {
                String outmsg = "%msg-" + msg;
                worker.enviar(outmsg);
            }
        }
    }

    private void enviar(String msg) {
        String message = msg + "\n";
        out.println(msg);
        out.flush();
    }

    private void FlagControl(String line) {
        if (line.contains("%search")) {
            this.SearchFlag = true;
        } else {
            if (line.contains("%insert")) {
                this.InsertFlag = true;
            } else {
                if (line.contains("%quit")) {
                    this.CloseFlag = true;
                } else {
                    if (line.contains("%msg")) {
                        this.MsgFlg = true;
                    } else {
                        if (line.contains("%session")) {
                            this.SessionFlag = true;
                        } else {
                            if (line.contains("%register")) {
                                this.RegisterFlag = true;
                            } else {
                                if (line.contains("%logs")) {
                                    this.LogsFlag = true;
                                } else {
                                    if (line.contains("%act")) {
                                        this.ActFlag = true;
                                    } else {
                                        if (line.contains("%info")) {
                                            this.InfFlag = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private String StringSep(String line, int i) {
        this.parts = line.split("-");
        this.query = parts.length;
        String orden = parts[i];
        return orden;
    }

    private boolean Session(String ResultSession, String compare) {
        if (compare.equals(ResultSession)) {
            return true;
        } else {
            return false;
        }
    }

    private void StringAdd() {
        this.arguments = new ArrayList<String>();
        for (int i = 2; i < this.query; i++) {
            this.arguments.add(parts[i]);

        }

        this.results = new String[this.arguments.size()];
    }

    private void LogsObtainer() {
        this.listaSesiones = server.getSesiones();
    }

}
