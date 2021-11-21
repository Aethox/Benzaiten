/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aetox
 */
public class Cliente extends Thread{
    private final String NombreServer;
    private final int PuertoServer;
    private OutputStream Serverout;
    private InputStream Serverin;
    private Socket socket;

    public OutputStream getServerout() {
        return Serverout;
    }

    public InputStream getServerin() {
        return Serverin;
    }

    public Socket getSocket() {
        return socket;
    }
    
    
    public Cliente(String NombreServer, int PuertoServer){
        this.NombreServer = NombreServer;
        this.PuertoServer = PuertoServer;
        
        
    }
    
    @Override
    public void run(){
        this.connect();
    }
    private void connect(){
        try {
            this.socket = new Socket(NombreServer,PuertoServer);
            this.Serverout = socket.getOutputStream();
            this.Serverin = socket.getInputStream();
            //Enviar("%msg");
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void Enviar(String Sentencia){
        try {
            Serverout.write(Sentencia.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(Send2Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    public static void main(String[] args) {
//        Cliente DB = new Cliente("localhost",5555);
//        
//    }
    
}
