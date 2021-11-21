/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Vista.GUIChats;
import Vista.GUILogin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;

/**
 *
 * @author aetox
 */
public class Read4ServerMSG extends Thread {

    private InputStream IS = null;
    private BufferedReader BR = null;
    private String Respuesta = null;
    private GUIChats guichats = null;
    private InputStreamReader a;

    public Read4ServerMSG(InputStream IS, GUIChats guichats) {
        this.IS = IS;
        this.guichats = guichats;
    }

    public String getRespuesta() {
        return Respuesta;
    }

    private String StringSep(String line, int i) {
        String parts[] = line.split("-");
        return parts[i];
    }

    public void Responder() {
        try {
            String res;
            BR = new BufferedReader(new InputStreamReader(IS));
            while ((res = BR.readLine()) != null) {
                if (res.contains("%msg")) {
                    this.guichats.setMsga(res);
                    this.guichats.ActP(res);
                }
            }
            String resp = "okay";
        } catch (IOException ex) {
            Logger.getLogger(Read4ServerMSG.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void run() {

        this.Responder();
    }
}
