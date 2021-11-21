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
public class Read4ServerThr extends Thread {

    private InputStream IS = null;
    private BufferedReader BR = null;
    private String Respuesta = null;
    private GUILogin guilogin = null;
    private InputStreamReader a;

    public Read4ServerThr(InputStream IS, GUILogin guilogin) {
        this.IS = IS;
        this.guilogin = guilogin;
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
                this.Respuesta = res;
                this.guilogin.setResponse(res);
                if (res.contains("%msg")) {
                    this.guilogin.getGuichats().ActP(res);
                }
            }
            String resp = "okay";
        } catch (IOException ex) {
            Logger.getLogger(Read4ServerThr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {

        this.Responder();
    }
}
