/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Vista.GUILogin;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aetox
 */
public class Send2Server extends Thread {

    OutputStream ServerOut = null;
    InputStream ServerIn = null;
    String Sentencia = null;
    Socket socket = null;
    Read4ServerThr Read4 = null;
    Read4Server r;

    public Send2Server(Socket socket, String Sentencia, GUILogin guilogin) {
        this.socket = socket;
        this.Sentencia = Sentencia;
        Read4 = new Read4ServerThr(guilogin.getDB().getServerin(), guilogin);
    }

    @Override
    public void run() {
        this.Enviar();
    }

    public void Enviar() {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(Sentencia);
            out.flush();
            Read4.start();

        } catch (IOException ex) {
            Logger.getLogger(Send2Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
