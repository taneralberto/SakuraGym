/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sakura.ventanas.paneles;

/**
 *
 * @author ALBERTO
 */
public class pnlOpciones extends javax.swing.JInternalFrame {

    /**
     * Creates new form pnlOpciones
     */
    public pnlOpciones() {
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

        pnlFondo = new elaprendiz.gui.panel.PanelImage();
        pnlCurvas = new elaprendiz.gui.panel.PanelCurves();
        buttonTask3 = new elaprendiz.gui.button.ButtonTask();
        buttonTask2 = new elaprendiz.gui.button.ButtonTask();
        buttonTask1 = new elaprendiz.gui.button.ButtonTask();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/fondo-abstracto-celeste_1077-3.jpg"))); // NOI18N
        pnlFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlCurvas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonTask3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/btnGuardar.png"))); // NOI18N
        buttonTask3.setText("Pago");
        buttonTask3.setColorDeBorde(new java.awt.Color(0, 0, 0));
        buttonTask3.setColorDeSegundoBorde(new java.awt.Color(0, 0, 0));
        buttonTask3.setDescription("diversos pagos");
        pnlCurvas.add(buttonTask3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, -1, -1));

        buttonTask2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/btnBuscar.png"))); // NOI18N
        buttonTask2.setText("Inscripción");
        buttonTask2.setColorDeBorde(new java.awt.Color(0, 0, 0));
        buttonTask2.setColorDeSegundoBorde(new java.awt.Color(0, 0, 0));
        buttonTask2.setDescription("registro");
        pnlCurvas.add(buttonTask2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        buttonTask1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/btnEditarDoc.png"))); // NOI18N
        buttonTask1.setText("Datos de afiliados");
        buttonTask1.setColorDeBorde(new java.awt.Color(0, 0, 0));
        buttonTask1.setColorDeSegundoBorde(new java.awt.Color(0, 0, 0));
        buttonTask1.setDescription("consultar, eliminar, modificar");
        pnlCurvas.add(buttonTask1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 260, -1));

        pnlFondo.add(pnlCurvas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 220));

        getContentPane().add(pnlFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 220));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private elaprendiz.gui.button.ButtonTask buttonTask1;
    private elaprendiz.gui.button.ButtonTask buttonTask2;
    private elaprendiz.gui.button.ButtonTask buttonTask3;
    private elaprendiz.gui.panel.PanelCurves pnlCurvas;
    private elaprendiz.gui.panel.PanelImage pnlFondo;
    // End of variables declaration//GEN-END:variables
}
