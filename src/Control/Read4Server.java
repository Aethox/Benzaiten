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
public class Read4Server extends SwingWorker<String, String> {

    private InputStream IS = null;
    private BufferedReader BR = null;
    private String Respuesta = null;
    private GUIChats guichats = null;

    public Read4Server(InputStream IS, GUIChats guichats) {
        this.IS = IS;
        this.guichats = guichats;
    }

    public String getRespuesta() {
        return Respuesta;
    }

    @Override
    protected String doInBackground() throws Exception {
        // define what thread will do here
        String res;
        BR = new BufferedReader(new InputStreamReader(IS));

        while ((res = BR.readLine()) != null) {
            if (res.contains("%msg")) {

                this.guichats.ActP(res);
            } else {

            }
        }
        String resp = "okay";

        return resp;
    }

    @Override
    protected void process(List<String> chunks) {
        String val = chunks.get(chunks.size() - 1);

    }

    @Override
    protected void done() {
        try {
            String statusMsg = get();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public String getValue() throws Exception {
        return this.get();
    }

}
