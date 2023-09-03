package sakura.ventanas;

import clases.util.AdminIFrame;
import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sakura.ventanas.paneles.pnlOpciones;

public class Main extends javax.swing.JFrame {

    private static IFRegistroAfiliado vtnRegistroAfiliado = null;
    private static IFTrayectoriaKarate vtnTrayectoriaKarate = null;
    private static IFTrayectoriaDanza vtnTrayectoriaDanza = null;
    private static IFConfig vtnConfig = null;
    private static IFInscripcionMembresiaDeCategoria vtnPago = null;
    private static IFEstado vtnEstado = null;

    public Main() {
        
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dp = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem8 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sport Center Sakura Gym");
        setBackground(new java.awt.Color(51, 204, 255));
        setMinimumSize(new java.awt.Dimension(1400, 640));
        setPreferredSize(new java.awt.Dimension(920, 850));

        dp.setMinimumSize(new java.awt.Dimension(700, 700));
        dp.setPreferredSize(new java.awt.Dimension(1000, 1000));
        getContentPane().add(dp, java.awt.BorderLayout.CENTER);

        jMenu2.setBackground(new java.awt.Color(255, 255, 255));
        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/user.png"))); // NOI18N
        jMenu2.setText("Afiliados");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jMenuItem1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem1.setText("Alta (Registro)");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);
        jMenu2.add(jSeparator1);

        jMenuItem4.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem4.setText("Inscripciones - Membresias");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);
        jMenu2.add(jSeparator2);

        jMenuItem8.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem8.setText("Consultas");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);
        jMenu2.add(jSeparator5);

        jMenuBar1.add(jMenu2);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/Trayecto.png"))); // NOI18N
        jMenu4.setText("Trayectoria");
        jMenu4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jMenuItem2.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem2.setText("Karate");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);
        jMenu4.add(jSeparator9);

        jMenuItem7.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem7.setText("Danza");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        jMenuBar1.add(jMenu4);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/Config.png"))); // NOI18N
        jMenu3.setText("Opciones");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jMenuItem3.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem3.setText("Configuraciones");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        vtnTrayectoriaKarate = new IFTrayectoriaKarate();
        AdminIFrame.mostrarVentanaFactura(dp, vtnTrayectoriaKarate);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        try {
            vtnConfig = new IFConfig();
        } catch (AWTException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        AdminIFrame.mostrarVentanaFactura(dp, vtnConfig);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        vtnTrayectoriaDanza = new IFTrayectoriaDanza();
        AdminIFrame.mostrarVentanaFactura(dp, vtnTrayectoriaDanza);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        try {
            vtnEstado = new IFEstado();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        AdminIFrame.mostrarVentanaFactura(dp, vtnEstado);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed

        try {
            vtnPago = new IFInscripcionMembresiaDeCategoria();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        AdminIFrame.mostrarVentanaFactura(dp, vtnPago);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        vtnRegistroAfiliado = new IFRegistroAfiliado();
        AdminIFrame.mostrarVentanaFactura(dp, vtnRegistroAfiliado);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dp;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    // End of variables declaration//GEN-END:variables
}
