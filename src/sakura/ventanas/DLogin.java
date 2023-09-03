/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sakura.ventanas;

import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author elaprendiz <http://www.elaprendiz.net63.net>
 */
public class DLogin extends javax.swing.JDialog {

    /**
     * Creates new form DLogin
     */

    public DLogin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        this.txtUsuario.requestFocus();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelImage1 = new elaprendiz.gui.panel.PanelImage();
        panelCurves1 = new elaprendiz.gui.panel.PanelCurves();
        pnlLogin = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtUsuario = new elaprendiz.gui.textField.TextFieldRectIcon();
        ptxtPass = new elaprendiz.gui.passwordField.PasswordFieldRectIcon();
        bntCancelar = new javax.swing.JButton();
        bntIngresar = new javax.swing.JButton();
        panelImage2 = new elaprendiz.gui.panel.PanelImage();
        lblLogo = new elaprendiz.gui.label.LabelHeader();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inicio de sesión");
        setModal(true);
        setResizable(false);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        panelImage1.setBackground(new java.awt.Color(0, 153, 204));
        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/fondo azul.jpg"))); // NOI18N
        panelImage1.setLayout(new java.awt.BorderLayout());

        panelCurves1.setBackground(new java.awt.Color(255, 255, 255));
        panelCurves1.setForeground(new java.awt.Color(255, 255, 255));

        pnlLogin.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inicio de sesión", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlLogin.setOpaque(false);
        pnlLogin.setLayout(new java.awt.GridBagLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Usuario:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 6, 1, 4);
        pnlLogin.add(jLabel6, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Contraseña:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 6, 4, 4);
        pnlLogin.add(jLabel7, gridBagConstraints);

        txtUsuario.setText("sakura");
        txtUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/user.png"))); // NOI18N
        txtUsuario.setPreferredSize(new java.awt.Dimension(150, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 3, 1, 7);
        pnlLogin.add(txtUsuario, gridBagConstraints);

        ptxtPass.setText("sakura");
        ptxtPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/pass.png"))); // NOI18N
        ptxtPass.setPreferredSize(new java.awt.Dimension(150, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 3, 4, 7);
        pnlLogin.add(ptxtPass, gridBagConstraints);

        bntCancelar.setBackground(new java.awt.Color(255, 255, 102));
        bntCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bntCancelar.setText("Cancelar");
        bntCancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bntCancelar.setPreferredSize(new java.awt.Dimension(80, 25));
        bntCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCancelarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        pnlLogin.add(bntCancelar, gridBagConstraints);

        bntIngresar.setBackground(new java.awt.Color(255, 255, 102));
        bntIngresar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bntIngresar.setText("Ingresar");
        bntIngresar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bntIngresar.setPreferredSize(new java.awt.Dimension(80, 25));
        bntIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntIngresarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        pnlLogin.add(bntIngresar, gridBagConstraints);

        panelCurves1.add(pnlLogin, java.awt.BorderLayout.CENTER);

        panelImage2.setLayout(new java.awt.BorderLayout());

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setText("SPORT CENTER SAKURA GYM");
        lblLogo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        panelImage2.add(lblLogo, java.awt.BorderLayout.CENTER);

        panelCurves1.add(panelImage2, java.awt.BorderLayout.PAGE_START);

        panelImage1.add(panelCurves1, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelImage1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntIngresarActionPerformed

        if(txtUsuario.getText().equals("sakura") && ptxtPass.getText().equals("sakura")){
            initMainWindow();
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Usuario/Contraseña incorrecto.","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        
        
                    
    }//GEN-LAST:event_bntIngresarActionPerformed

    private void bntCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCancelarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_bntCancelarActionPerformed

    
    
    private void initMainWindow()
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Main mw = new Main();
                mw.setVisible(true);
                mw.requestFocus();
            }
        });
    }
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntCancelar;
    private javax.swing.JButton bntIngresar;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private elaprendiz.gui.label.LabelHeader lblLogo;
    private elaprendiz.gui.panel.PanelCurves panelCurves1;
    private elaprendiz.gui.panel.PanelImage panelImage1;
    private elaprendiz.gui.panel.PanelImage panelImage2;
    private javax.swing.JPanel pnlLogin;
    private elaprendiz.gui.passwordField.PasswordFieldRectIcon ptxtPass;
    private elaprendiz.gui.textField.TextFieldRectIcon txtUsuario;
    // End of variables declaration//GEN-END:variables
}
