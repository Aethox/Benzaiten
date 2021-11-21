/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Control.Read4Server;
import Control.Read4ServerThr;
import Control.Send2Server;
import java.awt.Color;
import java.awt.event.MouseEvent;

/**
 *
 * @author aetox
 */
public class GUIRegistro extends javax.swing.JFrame {

    private GUILogin guilogin;
    private Send2Server Sender;
    private Read4ServerThr Reader;
    private boolean existencia;
    private String email;
    private String password;
    private String Name;
    private String Cargo;

    /**
     * Creates new form GUIRegistro
     */
    public GUIRegistro(GUILogin guilogin) {
        initComponents();
        this.guilogin = guilogin;
        this.Reader = new Read4ServerThr(this.guilogin.getDB().getServerin(),this.guilogin);
        this.Reader.start();
    }

    public GUIRegistro() {
        initComponents();
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        HeaderRegister = new javax.swing.JLabel();
        HeaderRegisterinfo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        EmailText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TextPass = new javax.swing.JPasswordField();
        Registro = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TextName = new javax.swing.JTextField();
        TextCargo = new javax.swing.JTextField();
        RegisterBk = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Benzaiten");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(17, 17, 17));

        HeaderRegister.setFont(new java.awt.Font("URW Gothic L", 1, 14)); // NOI18N
        HeaderRegister.setForeground(new java.awt.Color(112, 112, 112));
        HeaderRegister.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HeaderRegister.setText("Registro");
        HeaderRegister.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        HeaderRegisterinfo.setFont(new java.awt.Font("Fira Sans", 0, 32)); // NOI18N
        HeaderRegisterinfo.setForeground(new java.awt.Color(255, 255, 255));
        HeaderRegisterinfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HeaderRegisterinfo.setText("Ingresa tus datos");

        jLabel1.setFont(new java.awt.Font("Fira Sans", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Email:");

        EmailText.setBackground(new java.awt.Color(39, 39, 39));
        EmailText.setForeground(new java.awt.Color(255, 255, 255));
        EmailText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        EmailText.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(112, 112, 112), 1, true));

        jLabel2.setFont(new java.awt.Font("Fira Sans", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Contraseña:");

        TextPass.setBackground(new java.awt.Color(39, 39, 39));
        TextPass.setForeground(new java.awt.Color(255, 255, 255));
        TextPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextPass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(112, 112, 112)));

        Registro.setBackground(new java.awt.Color(153, 0, 204));
        Registro.setForeground(new java.awt.Color(255, 255, 255));
        Registro.setText("Registrarse");
        Registro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 39, 39)));
        Registro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Registro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RegistroMouseClicked(evt);
            }
        });
        Registro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistroActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Cancelar?");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Fira Sans", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nombre:");

        jLabel8.setFont(new java.awt.Font("Fira Sans", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Cargo:");

        TextName.setBackground(new java.awt.Color(39, 39, 39));
        TextName.setForeground(new java.awt.Color(255, 255, 255));
        TextName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(112, 112, 112), 1, true));

        TextCargo.setBackground(new java.awt.Color(39, 39, 39));
        TextCargo.setForeground(new java.awt.Color(255, 255, 255));
        TextCargo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextCargo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(112, 112, 112), 1, true));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(HeaderRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(HeaderRegisterinfo, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TextPass, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Registro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TextName, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TextCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(EmailText, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(HeaderRegister)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(HeaderRegisterinfo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EmailText, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextPass, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(Registro, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 509, 550));

        RegisterBk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/miscelaneos/wallpaperflare.com_wallpaper.jpg"))); // NOI18N
        jPanel1.add(RegisterBk, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void RegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistroActionPerformed
        //PopUp Registro
        
        this.email = this.EmailText.getText();
        this.password = this.TextPass.getText();
        this.Name = this.TextName.getText();
        this.Cargo = this.TextCargo.getText();

        //-----------------------------------//
        //Registro base de datos
        this.existencia = false;
        String sentenciacon = "%register" + "-SELECT * FROM tbl_Registro WHERE tbl_Registro.Correo_Usu =" + "'" + email + "'";
        Send2Server S = new Send2Server(guilogin.getDB().getSocket(), sentenciacon, guilogin);
        S.start();
        
        /*Read4Server r = new Read4Server(guilogin.getDB().getServerin(),guilogin);
        r.execute();*/
    }//GEN-LAST:event_RegistroActionPerformed

    private void RegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegistroMouseClicked

        if (evt.getClickCount() == 2 && evt.getButton() == MouseEvent.BUTTON1) {
            
            int existenciaCheck = Integer.parseInt(guilogin.getResponse());
            if (existenciaCheck == 1) {
                this.existencia = true;
            } else {
                this.existencia = false;
            }
            if (existencia) {
                this.HeaderRegister.setForeground(Color.red);
                this.HeaderRegister.setText("El usuario ya existe :(");  
            } else {
                String sentenciaInt = "%insert" + "-INSERT INTO `tbl_Registro` (`Correo_Usu`, `Contra_Usuario_Registro`, `Nombre`, `Cargo`) VALUES (" + "'" + email + "'" + "," + "'" + password + "'" + "," + "'" + Name + "'" + "," + "'" + Cargo + "'" + ")";
                Send2Server S1 = new Send2Server(guilogin.getDB().getSocket(), sentenciaInt, guilogin);
                S1.start();
                this.guilogin.getHeaderWelcome().setForeground(Color.PINK);
                this.guilogin.getHeaderWelcome().setText("Registro existoso!");
                this.Reader.stop();
                this.guilogin.setVisible(true);
                this.setVisible(false);
            }
        }
    }//GEN-LAST:event_RegistroMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.Reader.stop();
        this.guilogin.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel3MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIRegistro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField EmailText;
    private javax.swing.JLabel HeaderRegister;
    private javax.swing.JLabel HeaderRegisterinfo;
    private javax.swing.JLabel RegisterBk;
    private javax.swing.JButton Registro;
    private javax.swing.JTextField TextCargo;
    private javax.swing.JTextField TextName;
    private javax.swing.JPasswordField TextPass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
