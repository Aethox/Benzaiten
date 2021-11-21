/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package benzaiten.Servicios;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aetox
 */
public class RecopiladorServer extends Thread {

    private final int port;
    private String login;

    private ArrayList<SesionadorServidor> Sesiones = new ArrayList<>();

    RecopiladorServer(int port) {
        this.port = port;
    }

    public ArrayList<SesionadorServidor> getSesiones() {
        return Sesiones;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getPort() {
        return port;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                System.out.println("Esperando conexion...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Conexion aceptada desde: " + clientSocket);
                SesionadorServidor worker = new SesionadorServidor(this, clientSocket);
                Sesiones.add(worker);
                worker.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
