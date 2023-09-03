/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sakura.ventanas.paneles;

import clases.bdd.Conectar;
import java.awt.Color;
import java.awt.Component;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author ALBERTO
 */
public class pnlInscripcion extends javax.swing.JPanel {

    //VARIABLES
    private int cedula;
    private GregorianCalendar fechaActual = new GregorianCalendar();
    private float inscripcion;
    private float membresia;
    private Thread h1;
    
    //CONEXIONES
    private PreparedStatement ps;
    private Connection connection;
    private ResultSet resultSet;
    private Statement st;
    
    //COLORES
    private final static Color azul = new Color(0, 203, 255);
    private final static Color amar = new Color(255, 255, 102);
    
    public pnlInscripcion() { initComponents(); }
    
    public pnlInscripcion(String cedula, float inscripcion, float membresia) throws SQLException, FileNotFoundException, IOException{
        
        initComponents();
        
        /*h1 = new Thread(this);
        h1.start();*/
        
        vn(0,lblPagado);
        vn(0,lblPagado1);
        vn(0,lblPendiente);
        vn(0,lblPendiente1);
        v(0,btnSubscribir);
        v(0,btnSubscribir1);
        v(0,btnActualizar);
        v(0,btnActualizar1);
        /*v(0,ckbInscripcion);
        v(0,ckbMembresia);*/
        v(0,ckbInscripcionAct);
        v(0,ckbMembresiaAct);

        setInscripcion(inscripcion);
        setMembresia(membresia);
        
        validacionPago("inscripcion",cedula);
        validacionPago("membresia",cedula);

        InhabilitarFechasInscripcion();
        InhabilitarFechasMembresia();
        
        setCedula(Integer.parseInt(cedula));
        txtInscripcion.setText(String.valueOf(inscripcion));
        txtMembresia.setText(String.valueOf(membresia));

    }

    public void setCedula(int cedula){
        this.cedula = cedula;
    }
    
    public int getCedula(){
        return cedula;
    }
    
    public void setInscripcion(float inscripcion){
        this.inscripcion = inscripcion;
    }
    
    public float getInscripcion(){
        return inscripcion;
    }
    
    public void setMembresia(float membresia){
        this.membresia = membresia;
    }
    
    public float getMembresia(){
        return membresia;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        INSCRIPCION = new elaprendiz.gui.label.LabelMetric();
        MENSUALIDAD = new elaprendiz.gui.label.LabelMetric();
        ckbInscripcionAct = new javax.swing.JCheckBox();
        ckbMembresiaAct = new javax.swing.JCheckBox();
        ckbInscripcion = new javax.swing.JCheckBox();
        ckbMembresia = new javax.swing.JCheckBox();
        txtInscripcion = new javax.swing.JLabel();
        txtMembresia = new javax.swing.JLabel();
        lblPendiente = new javax.swing.JLabel();
        lblPendiente1 = new javax.swing.JLabel();
        lblPagado = new javax.swing.JLabel();
        lblPagado1 = new javax.swing.JLabel();
        btnSubscribir = new javax.swing.JButton();
        btnSubscribir1 = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnActualizar1 = new javax.swing.JButton();
        lblDato = new elaprendiz.gui.label.LabelMetric();
        lblDato1 = new elaprendiz.gui.label.LabelMetric();
        dcFechaMembresia = new com.toedter.calendar.JDateChooser();
        btnFechaHoyMembresia = new elaprendiz.gui.button.ButtonAeroLeft();
        HASTA = new elaprendiz.gui.label.LabelMetric();
        dcFechaVenceMembresia = new com.toedter.calendar.JDateChooser();
        cbVencimientosMembresia = new elaprendiz.gui.comboBox.ComboBoxRectIcon();
        FECHA1 = new elaprendiz.gui.label.LabelMetric();
        FECHA = new elaprendiz.gui.label.LabelMetric();
        btnFechaHoyInscripcion = new elaprendiz.gui.button.ButtonAeroLeft();
        dcFechaInscripcion = new com.toedter.calendar.JDateChooser();
        FECHA2 = new elaprendiz.gui.label.LabelMetric();
        HASTA1 = new elaprendiz.gui.label.LabelMetric();
        dcFechaVenceInscripcion = new com.toedter.calendar.JDateChooser();
        cbVencimientosInscripcion = new elaprendiz.gui.comboBox.ComboBoxRectIcon();
        FECHA3 = new elaprendiz.gui.label.LabelMetric();
        lblCategoria = new elaprendiz.gui.label.LabelMetric();
        lblFondo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        INSCRIPCION.setBackground(new java.awt.Color(255, 255, 255));
        INSCRIPCION.setForeground(new java.awt.Color(0, 0, 0));
        INSCRIPCION.setText("Inscripción");
        INSCRIPCION.setColorDeSombra(new java.awt.Color(255, 255, 51));
        INSCRIPCION.setDistanciaDeSombra(1);
        add(INSCRIPCION, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, 20));

        MENSUALIDAD.setBackground(new java.awt.Color(255, 255, 255));
        MENSUALIDAD.setForeground(new java.awt.Color(0, 0, 0));
        MENSUALIDAD.setText("Membresia");
        MENSUALIDAD.setColorDeSombra(new java.awt.Color(255, 255, 51));
        MENSUALIDAD.setDistanciaDeSombra(1);
        add(MENSUALIDAD, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, 20));

        ckbInscripcionAct.setContentAreaFilled(false);
        ckbInscripcionAct.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ckbInscripcionActItemStateChanged(evt);
            }
        });
        add(ckbInscripcionAct, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, -1, -1));

        ckbMembresiaAct.setContentAreaFilled(false);
        ckbMembresiaAct.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ckbMembresiaActItemStateChanged(evt);
            }
        });
        add(ckbMembresiaAct, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, -1, -1));

        ckbInscripcion.setContentAreaFilled(false);
        ckbInscripcion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ckbInscripcionItemStateChanged(evt);
            }
        });
        ckbInscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbInscripcionActionPerformed(evt);
            }
        });
        add(ckbInscripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 30, -1));

        ckbMembresia.setContentAreaFilled(false);
        ckbMembresia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ckbMembresiaItemStateChanged(evt);
            }
        });
        add(ckbMembresia, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 30, -1));

        txtInscripcion.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        add(txtInscripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 160, 50));

        txtMembresia.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        add(txtMembresia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 160, 50));

        lblPendiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/Pendiente.png"))); // NOI18N
        add(lblPendiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 310, 90));

        lblPendiente1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/Pendiente.png"))); // NOI18N
        add(lblPendiente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 310, 90));

        lblPagado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/Pagado.png"))); // NOI18N
        add(lblPagado, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 310, 90));

        lblPagado1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/Pagado.png"))); // NOI18N
        add(lblPagado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 310, 90));

        btnSubscribir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSubscribir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/btnLGuardar.png"))); // NOI18N
        btnSubscribir.setText("Subscribir");
        btnSubscribir.setBorder(null);
        btnSubscribir.setBorderPainted(false);
        btnSubscribir.setContentAreaFilled(false);
        btnSubscribir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSubscribir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/btnLGuardarRellover.png"))); // NOI18N
        btnSubscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubscribirActionPerformed(evt);
            }
        });
        add(btnSubscribir, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 100, -1, -1));

        btnSubscribir1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSubscribir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/btnLGuardar.png"))); // NOI18N
        btnSubscribir1.setText("Subscribir");
        btnSubscribir1.setBorder(null);
        btnSubscribir1.setBorderPainted(false);
        btnSubscribir1.setContentAreaFilled(false);
        btnSubscribir1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSubscribir1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/btnLGuardarRellover.png"))); // NOI18N
        btnSubscribir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubscribir1ActionPerformed(evt);
            }
        });
        add(btnSubscribir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 180, -1, -1));

        btnActualizar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/btnLGuardar.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.setBorder(null);
        btnActualizar.setBorderPainted(false);
        btnActualizar.setContentAreaFilled(false);
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/btnLGuardarRellover.png"))); // NOI18N
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 100, -1, -1));

        btnActualizar1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnActualizar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/btnLGuardar.png"))); // NOI18N
        btnActualizar1.setText("Actualizar");
        btnActualizar1.setBorder(null);
        btnActualizar1.setBorderPainted(false);
        btnActualizar1.setContentAreaFilled(false);
        btnActualizar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizar1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/btnLGuardarRellover.png"))); // NOI18N
        btnActualizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizar1ActionPerformed(evt);
            }
        });
        add(btnActualizar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 180, -1, -1));

        lblDato.setForeground(new java.awt.Color(255, 0, 0));
        lblDato.setDistanciaDeSombra(1);
        lblDato.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        add(lblDato, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, 180, 70));

        lblDato1.setForeground(new java.awt.Color(255, 0, 0));
        lblDato1.setDistanciaDeSombra(1);
        lblDato1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        add(lblDato1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 160, 180, 70));

        dcFechaMembresia.setBackground(new java.awt.Color(255, 255, 102));
        dcFechaMembresia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 102), 3));
        dcFechaMembresia.setDateFormatString("dd-MM-yyyy");
        dcFechaMembresia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dcFechaMembresia.setMinSelectableDate(new java.util.Date(-62135749683000L));
        dcFechaMembresia.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                dcFechaMembresiaHierarchyChanged(evt);
            }
        });
        dcFechaMembresia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dcFechaMembresiaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                dcFechaMembresiaFocusLost(evt);
            }
        });
        dcFechaMembresia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dcFechaMembresiaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dcFechaMembresiaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dcFechaMembresiaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dcFechaMembresiaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                dcFechaMembresiaMouseReleased(evt);
            }
        });
        dcFechaMembresia.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                dcFechaMembresiaInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        dcFechaMembresia.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dcFechaMembresiaPropertyChange(evt);
            }
        });
        dcFechaMembresia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dcFechaMembresiaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dcFechaMembresiaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dcFechaMembresiaKeyTyped(evt);
            }
        });
        dcFechaMembresia.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                dcFechaMembresiaVetoableChange(evt);
            }
        });
        add(dcFechaMembresia, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 150, 30));

        btnFechaHoyMembresia.setBackground(new java.awt.Color(0, 204, 255));
        btnFechaHoyMembresia.setText("HOY");
        btnFechaHoyMembresia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFechaHoyMembresiaActionPerformed(evt);
            }
        });
        add(btnFechaHoyMembresia, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 40, 30));

        HASTA.setForeground(new java.awt.Color(0, 0, 0));
        HASTA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HASTA.setText("Hasta el");
        HASTA.setColorDeSombra(new java.awt.Color(255, 255, 51));
        HASTA.setDistanciaDeSombra(1);
        add(HASTA, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 80, 30));

        dcFechaVenceMembresia.setBackground(new java.awt.Color(255, 255, 102));
        dcFechaVenceMembresia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 102), 3));
        dcFechaVenceMembresia.setDateFormatString("dd-MM-yyyy");
        dcFechaVenceMembresia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dcFechaVenceMembresia.setMinSelectableDate(new java.util.Date(-62135749683000L));
        add(dcFechaVenceMembresia, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, 150, 30));

        cbVencimientosMembresia.setBackground(new java.awt.Color(0, 204, 255));
        cbVencimientosMembresia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 102)));
        cbVencimientosMembresia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Otro", "Semanal", "Quincenal", "Mensual", "Trimestral", "Semestral", "Anual" }));
        cbVencimientosMembresia.setAnchoDeBorde(4.0F);
        cbVencimientosMembresia.setColorDeBorde(new java.awt.Color(255, 255, 102));
        cbVencimientosMembresia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbVencimientosMembresia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbVencimientosMembresiaItemStateChanged(evt);
            }
        });
        add(cbVencimientosMembresia, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, 150, 30));

        FECHA1.setForeground(new java.awt.Color(0, 0, 0));
        FECHA1.setText("Fecha de vencimiento");
        FECHA1.setColorDeSombra(new java.awt.Color(255, 255, 51));
        FECHA1.setDistanciaDeSombra(1);
        add(FECHA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, 160, 20));

        FECHA.setForeground(new java.awt.Color(0, 0, 0));
        FECHA.setText("Fecha de membresia");
        FECHA.setColorDeSombra(new java.awt.Color(255, 255, 51));
        FECHA.setDistanciaDeSombra(1);
        add(FECHA, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 160, 20));

        btnFechaHoyInscripcion.setBackground(new java.awt.Color(0, 204, 255));
        btnFechaHoyInscripcion.setText("HOY");
        btnFechaHoyInscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFechaHoyInscripcionActionPerformed(evt);
            }
        });
        add(btnFechaHoyInscripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 40, 30));

        dcFechaInscripcion.setBackground(new java.awt.Color(255, 255, 102));
        dcFechaInscripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 102), 3));
        dcFechaInscripcion.setDateFormatString("dd-MM-yyyy");
        dcFechaInscripcion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dcFechaInscripcion.setMinSelectableDate(new java.util.Date(-62135749683000L));
        dcFechaInscripcion.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                dcFechaInscripcionHierarchyChanged(evt);
            }
        });
        dcFechaInscripcion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dcFechaInscripcionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                dcFechaInscripcionFocusLost(evt);
            }
        });
        dcFechaInscripcion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dcFechaInscripcionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dcFechaInscripcionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dcFechaInscripcionMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dcFechaInscripcionMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                dcFechaInscripcionMouseReleased(evt);
            }
        });
        dcFechaInscripcion.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                dcFechaInscripcionInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        dcFechaInscripcion.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dcFechaInscripcionPropertyChange(evt);
            }
        });
        dcFechaInscripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dcFechaInscripcionKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dcFechaInscripcionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dcFechaInscripcionKeyTyped(evt);
            }
        });
        dcFechaInscripcion.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                dcFechaInscripcionVetoableChange(evt);
            }
        });
        add(dcFechaInscripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 150, 30));

        FECHA2.setForeground(new java.awt.Color(0, 0, 0));
        FECHA2.setText("Fecha de inscripción");
        FECHA2.setColorDeSombra(new java.awt.Color(255, 255, 51));
        FECHA2.setDistanciaDeSombra(1);
        add(FECHA2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 160, 20));

        HASTA1.setForeground(new java.awt.Color(0, 0, 0));
        HASTA1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HASTA1.setText("Hasta el");
        HASTA1.setColorDeSombra(new java.awt.Color(255, 255, 51));
        HASTA1.setDistanciaDeSombra(1);
        add(HASTA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 80, 30));

        dcFechaVenceInscripcion.setBackground(new java.awt.Color(255, 255, 102));
        dcFechaVenceInscripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 102), 3));
        dcFechaVenceInscripcion.setDateFormatString("dd-MM-yyyy");
        dcFechaVenceInscripcion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dcFechaVenceInscripcion.setMinSelectableDate(new java.util.Date(-62135749683000L));
        dcFechaVenceInscripcion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dcFechaVenceInscripcionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                dcFechaVenceInscripcionFocusLost(evt);
            }
        });
        dcFechaVenceInscripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dcFechaVenceInscripcionKeyTyped(evt);
            }
        });
        add(dcFechaVenceInscripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 150, 30));

        cbVencimientosInscripcion.setBackground(new java.awt.Color(0, 204, 255));
        cbVencimientosInscripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 102)));
        cbVencimientosInscripcion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Otro", "Semanal", "Quincenal", "Mensual", "Trimestral", "Semestral", "Anual", "Indefinido" }));
        cbVencimientosInscripcion.setAnchoDeBorde(4.0F);
        cbVencimientosInscripcion.setColorDeBorde(new java.awt.Color(255, 255, 102));
        cbVencimientosInscripcion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbVencimientosInscripcion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbVencimientosInscripcionItemStateChanged(evt);
            }
        });
        add(cbVencimientosInscripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 150, 30));

        FECHA3.setForeground(new java.awt.Color(0, 0, 0));
        FECHA3.setText("Fecha de vencimiento");
        FECHA3.setColorDeSombra(new java.awt.Color(255, 255, 51));
        FECHA3.setDistanciaDeSombra(1);
        add(FECHA3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 170, 20));

        lblCategoria.setBackground(new java.awt.Color(255, 255, 255));
        lblCategoria.setForeground(new java.awt.Color(0, 0, 0));
        lblCategoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCategoria.setText("Sport Center Sakura Gym");
        lblCategoria.setColorDeSombra(new java.awt.Color(255, 255, 51));
        lblCategoria.setDistanciaDeSombra(1);
        lblCategoria.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        add(lblCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 10, 800, 40));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/fonditoCates.PNG"))); // NOI18N
        add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 280));
    }// </editor-fold>//GEN-END:initComponents

    private void ckbInscripcionActItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ckbInscripcionActItemStateChanged

        if(ckbInscripcionAct.isSelected()==true){

            v(0,btnSubscribir);
            v(1,btnActualizar);
            v(0,lblPagado);
            v(0,lblPendiente);
            v(0,lblDato);
            ckbInscripcion.setSelected(false);

            e(1,cbVencimientosInscripcion);
            this.cbVencimientosInscripcion.setBackground(amar);
            this.cbVencimientosInscripcion.setColorDeBorde(Color.BLACK);

            if(!cbVencimientosInscripcion.getSelectedItem().equals("Indefinido")){
                this.dcFechaInscripcion.setBorder(javax.swing.BorderFactory.createLineBorder(amar, 3));
                this.dcFechaVenceInscripcion.setBorder(javax.swing.BorderFactory.createLineBorder(amar, 3));
            }

            if(cbVencimientosInscripcion.getSelectedItem().equals("Indefinido")){
                e(0,dcFechaInscripcion);
                e(0,dcFechaVenceInscripcion);
                e(0,btnFechaHoyInscripcion);
                btnFechaHoyInscripcion.setBackground(azul);
            }
        }

        if(ckbInscripcionAct.isSelected()==false){

            InhabilitarFechasInscripcion();

            v(1,lblPagado);
            v(1,lblDato);

            try {
                validacionPago("inscripcion",String.valueOf(getCedula()));
            } catch (SQLException ex) {
                JOptionPane.showInternalMessageDialog(lblFondo, "Error: "+ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }

            if(cbVencimientosInscripcion.getSelectedItem().equals("Indefinido")){
                v(0,lblPagado);
            }

            if(!ckbMembresiaAct.isEnabled()){
                try {
                    validacionPago("membresia",String.valueOf(getCedula()));
                    e(1,ckbMembresiaAct);
                    InhabilitarFechasMembresia();
                } catch (SQLException ex) {
                    JOptionPane.showInternalMessageDialog(lblFondo, "Error: "+ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }

            e(0,dcFechaVenceInscripcion);

            if(ckbInscripcion.isSelected()==true){
                HabilitarFechasInscripcion();
            }

            this.dcFechaInscripcion.setBorder(javax.swing.BorderFactory.createLineBorder(amar, 3));
            this.dcFechaVenceInscripcion.setBorder(javax.swing.BorderFactory.createLineBorder(amar, 3));
            this.cbVencimientosInscripcion.setColorDeBorde(amar);

            v(0,btnActualizar);

            try{

                connection = Conectar.getConnection();
                PreparedStatement ps1 = connection.prepareStatement("DELETE FROM temporalestadoinscripcionsakura WHERE cedula = '"+cedula+"'");
                int res1 = ps1.executeUpdate();

                if(res1 > 0){

                }

            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage(), "ERROR", JOptionPane.PLAIN_MESSAGE);
            }
        }

        /*if(!cbVencimientosInscripcion.getSelectedItem().equals("Otro")){
            InhabilitarFechasInscripcion();
            e(1,cbVencimientosInscripcion);
            cbVencimientosInscripcion.setBackground(amar);
            cbVencimientosInscripcion.setColorDeBorde(Color.BLACK);
        }*/

    }//GEN-LAST:event_ckbInscripcionActItemStateChanged

    private void ckbMembresiaActItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ckbMembresiaActItemStateChanged

        if(ckbMembresiaAct.isSelected()==true){

            v(0,btnSubscribir1);
            v(1,btnActualizar1);
            v(0,lblPagado1);
            v(0,lblPendiente1);
            v(0,lblDato1);
            ckbMembresia.setSelected(false);

            e(1,cbVencimientosMembresia);
            this.cbVencimientosMembresia.setBackground(amar);
            this.cbVencimientosMembresia.setColorDeBorde(Color.BLACK);

        }

        if(ckbMembresiaAct.isSelected()==false){

            InhabilitarFechasMembresia();
            v(1,lblPagado1);
            v(1,lblDato1);

            try {
                validacionPago("membresia",String.valueOf(getCedula()));
            } catch (SQLException ex) {
                JOptionPane.showInternalMessageDialog(lblFondo, "Error: "+ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }

            //e(0,dcFechaVenceInscripcion);

            v(0,btnActualizar1);

            try{

                connection = Conectar.getConnection();
                PreparedStatement ps1 = connection.prepareStatement("DELETE FROM temporalestadomembresiasakura WHERE cedula = '"+cedula+"'");
                int res1 = ps1.executeUpdate();

                if(res1 > 0){

                }

            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage(), "ERROR", JOptionPane.PLAIN_MESSAGE);
            }
        }

    }//GEN-LAST:event_ckbMembresiaActItemStateChanged

    private void ckbInscripcionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ckbInscripcionItemStateChanged

        if(ckbInscripcion.isSelected()==true){
            HabilitarFechasInscripcion();
            vn(0,lblPagado);
            vn(0,lblPendiente);
            v(0,btnActualizar);
            v(1,btnSubscribir);
            ckbInscripcionAct.setSelected(false);
        }

        if(ckbInscripcion.isSelected()==false){
            LimpiarCajasInscripcion();
            InhabilitarFechasInscripcion();
            v(0,btnSubscribir);

            if(ckbInscripcionAct.isSelected()==true)
            ckbInscripcionAct.setSelected(true);

            try{

                connection = Conectar.getConnection();
                PreparedStatement ps1 = connection.prepareStatement("DELETE FROM temporalestadoinscripcionsakura WHERE cedula = '"+cedula+"'");
                int res1 = ps1.executeUpdate();

                if(res1 > 0){

                }

            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage(), "ERROR", JOptionPane.PLAIN_MESSAGE);
            }

        }
    }//GEN-LAST:event_ckbInscripcionItemStateChanged

    private void ckbInscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbInscripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ckbInscripcionActionPerformed

    private void ckbMembresiaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ckbMembresiaItemStateChanged

        /*if(cbVencimientosInscripcion.getSelectedItem().equals("Indefinido"))
        cbVencimientosInscripcion.setSelectedItem("Otro");*/

        if(ckbMembresia.isSelected()==true){
            HabilitarFechasMembresia();
            vn(0,lblPagado1);
            vn(0,lblPendiente1);
            v(0,btnActualizar1);
            v(1,btnSubscribir1);
            InhabilitarFechasInscripcion();
            e(1,cbVencimientosInscripcion);
            cbVencimientosInscripcion.setColorDeBorde(Color.BLACK);
            cbVencimientosInscripcion.setBackground(amar);
            this.dcFechaInscripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0), 3));
            this.dcFechaVenceInscripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0), 3));

            if(!ckbInscripcion.isSelected() && !ckbInscripcionAct.isSelected()){
                InhabilitarFechasInscripcion();
            }

        }

        if(ckbMembresia.isSelected()==false){
            LimpiarCajasMembresia();
            InhabilitarFechasMembresia();
            v(0,btnSubscribir1);

            try{

                connection = Conectar.getConnection();
                PreparedStatement ps1 = connection.prepareStatement("DELETE FROM temporalestadomembresiasakura WHERE cedula = '"+cedula+"'");
                int res1 = ps1.executeUpdate();

                if(res1 > 0){

                }

            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage(), "ERROR", JOptionPane.PLAIN_MESSAGE);
            }
        }

        if(cbVencimientosInscripcion.getSelectedItem().equals("Otro")){
            e(1,dcFechaInscripcion);
            e(1,dcFechaVenceInscripcion);
            e(1,btnFechaHoyInscripcion);
            btnFechaHoyInscripcion.setBackground(amar);
        }

        connection = Conectar.getConnection();
        try {
            PreparedStatement ps1 = connection.prepareStatement("SELECT * FROM temporalestadoinscripcionsakura WHERE cedula = '"+getCedula()+"'");
            ResultSet res = ps1.executeQuery();

            if(res.next()){

                InhabilitarFechasInscripcion();
                this.dcFechaInscripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,255,255), 3));
                this.dcFechaVenceInscripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,255,255), 3));
                this.cbVencimientosInscripcion.setColorDeBorde(Color.WHITE);
            }

        } catch (SQLException ex) {
            JOptionPane.showInternalMessageDialog(lblFondo, "Error: "+ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_ckbMembresiaItemStateChanged

    private void btnSubscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubscribirActionPerformed

        java.sql.Date fechaActualSQL = new java.sql.Date(fechaActual.getTime().getYear(), fechaActual.getTime().getMonth()+1, fechaActual.getTime().getDate());

        if(ckbInscripcion.isSelected()==true){

            java.sql.Date fechaInscripcion = new java.sql.Date(dcFechaInscripcion.getDate().getYear(), dcFechaInscripcion.getDate().getMonth(), dcFechaInscripcion.getDate().getDate());
            java.sql.Date fechaVenceInscripcion = new java.sql.Date(dcFechaVenceInscripcion.getDate().getYear(), dcFechaVenceInscripcion.getDate().getMonth(), dcFechaVenceInscripcion.getDate().getDate());

            try{

                connection = Conectar.getConnection();
                PreparedStatement ps2 = connection.prepareStatement("SELECT * FROM estadoinscripcionsakura WHERE cedula='"+getCedula()+"'");
                ResultSet res = ps2.executeQuery();

                PreparedStatement ps3 = connection.prepareStatement("SELECT * FROM temporalestadoinscripcionsakura WHERE cedula='"+getCedula()+"'");
                ResultSet res2 = ps3.executeQuery();

                if(res.next() || res2.next()){

                    System.out.println("Ya existe");

                }else{

                    connection = Conectar.getConnection();
                    ps = connection.prepareStatement("INSERT INTO temporalestadoinscripcionsakura(cedula,costo,fechainscripcion,fechavenceinscripcion,fechapago,vencimiento)VALUES (?,?,?,?,?,?)");
                    ps.setInt(1,getCedula());
                    ps.setFloat(2,cbVencimientosInscripcion.getSelectedItem().equals("Anual")?getInscripcion()*12
                        :cbVencimientosInscripcion.getSelectedItem().equals("Semestral")?getInscripcion()*6
                        :cbVencimientosInscripcion.getSelectedItem().equals("Trimestral")?getInscripcion()*3
                        :cbVencimientosInscripcion.getSelectedItem().equals("Quincenal")?(getInscripcion()/30)*15
                        :cbVencimientosInscripcion.getSelectedItem().equals("Semanal")?(getInscripcion()/30)*7
                        :cbVencimientosInscripcion.getSelectedItem().equals("Indefinido")?0
                        :getInscripcion());
                    ps.setDate(3,fechaInscripcion);
                    ps.setDate(4,fechaVenceInscripcion);
                    ps.setDate(5,fechaActualSQL);
                    ps.setString(6,cbVencimientosInscripcion.getSelectedItem().toString());

                    int res1 = ps.executeUpdate();

                    if(res1 > 0){

                        InhabilitarFechasInscripcion();
                        //e(0,ckbInscripcion);
                        v(0,btnSubscribir);

                        this.dcFechaInscripcion.setBorder(javax.swing.BorderFactory.createLineBorder(Color.WHITE, 3));
                        this.dcFechaVenceInscripcion.setBorder(javax.swing.BorderFactory.createLineBorder(Color.WHITE, 3));
                        this.cbVencimientosInscripcion.setColorDeBorde(Color.WHITE);

                    }else{
                        JOptionPane.showInternalMessageDialog(lblFondo, "Error al registrar inscripcion","Aviso",JOptionPane.WARNING_MESSAGE);
                        //LimpiarCajas();
                    }
                    //validacionPago("inscripcion",String.valueOf(getCedula()),lblCategoria.getText());
                }

            }catch(SQLException ex){JOptionPane.showInternalMessageDialog(lblFondo, "Error: "+ex.getMessage(),"Problema", JOptionPane.PLAIN_MESSAGE);}
        }
    }//GEN-LAST:event_btnSubscribirActionPerformed

    private void btnSubscribir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubscribir1ActionPerformed

        java.sql.Date fechaActualSQL = new java.sql.Date(fechaActual.getTime().getYear(), fechaActual.getTime().getMonth()+1, fechaActual.getTime().getDate());

        if(ckbMembresia.isSelected()==true){

            if(dcFechaVenceInscripcion.getDate()!=null && dcFechaInscripcion.getDate()!=null && dcFechaVenceMembresia.getDate()!=null && dcFechaMembresia.getDate()!=null){

                java.sql.Date fechaMembresia = new java.sql.Date(dcFechaMembresia.getDate().getYear(), dcFechaMembresia.getDate().getMonth(), dcFechaMembresia.getDate().getDate());
                java.sql.Date fechaVenceMembresia = new java.sql.Date(dcFechaVenceMembresia.getDate().getYear(), dcFechaVenceMembresia.getDate().getMonth(), dcFechaVenceMembresia.getDate().getDate());

                java.util.Date fechaVenceInscripcion = new Date(dcFechaVenceInscripcion.getDate().getYear(), dcFechaVenceInscripcion.getDate().getMonth(), dcFechaVenceInscripcion.getDate().getDate());
                java.util.Date fechaVenceMembresia1 = new Date(dcFechaVenceMembresia.getDate().getYear(), dcFechaVenceMembresia.getDate().getMonth(), dcFechaVenceMembresia.getDate().getDate());

                if(fechaVenceInscripcion.after(fechaVenceMembresia1)==true || fechaVenceInscripcion.equals(fechaVenceMembresia1)){

                    try{
                        connection = Conectar.getConnection();
                        PreparedStatement ps4 = connection.prepareStatement("SELECT * FROM estadoinscripcionsakura WHERE cedula='"+getCedula()+"'");
                        ResultSet res4 = ps4.executeQuery();

                        PreparedStatement ps5 = connection.prepareStatement("SELECT * FROM temporalestadoinscripcionsakura WHERE cedula='"+getCedula()+"'");
                        ResultSet res5 = ps5.executeQuery();

                        if(res4.next() || res5.next()){

                            connection = Conectar.getConnection();
                            PreparedStatement ps2 = connection.prepareStatement("SELECT * FROM estadomembresiasakura WHERE cedula='"+getCedula()+"'");
                            ResultSet res = ps2.executeQuery();

                            PreparedStatement ps3 = connection.prepareStatement("SELECT * FROM temporalestadomembresiasakura WHERE cedula='"+getCedula()+"'");
                            ResultSet res2 = ps3.executeQuery();

                            if(res.next() || res2.next()){

                                System.out.println("Ya existe");

                            }else{

                                connection = Conectar.getConnection();
                                ps = connection.prepareStatement("INSERT INTO temporalestadomembresiasakura(cedula,costo,fechamembresia,fechavencemembresia,fechapago,vencimiento)VALUES (?,?,?,?,?,?)");
                                ps.setInt(1,getCedula());
                                ps.setFloat(2,cbVencimientosMembresia.getSelectedItem().equals("Anual")?getMembresia()*12
                                    :cbVencimientosMembresia.getSelectedItem().equals("Semestral")?getMembresia()*6
                                    :cbVencimientosMembresia.getSelectedItem().equals("Trimestral")?getMembresia()*3
                                    :cbVencimientosMembresia.getSelectedItem().equals("Quincenal")?(getMembresia()/30)*15
                                    :cbVencimientosMembresia.getSelectedItem().equals("Semanal")?(getMembresia()/30)*7
                                    :cbVencimientosMembresia.getSelectedItem().equals("Indefinido")?0
                                    :getMembresia());
                                ps.setDate(3,fechaMembresia);
                                ps.setDate(4,fechaVenceMembresia);
                                ps.setDate(5,fechaActualSQL);
                                ps.setString(6,cbVencimientosMembresia.getSelectedItem().toString());

                                int res3 = ps.executeUpdate();

                                if(res3 > 0){

                                    InhabilitarFechasMembresia();

                                    //e(0,ckbMembresia);
                                    v(0,btnSubscribir1);

                                    this.dcFechaMembresia.setBorder(javax.swing.BorderFactory.createLineBorder(Color.WHITE, 3));
                                    this.dcFechaVenceMembresia.setBorder(javax.swing.BorderFactory.createLineBorder(Color.WHITE, 3));
                                    this.cbVencimientosMembresia.setColorDeBorde(Color.WHITE);

                                }else{
                                    JOptionPane.showInternalMessageDialog(lblFondo, "Error al registrar inscripcion","Aviso",JOptionPane.WARNING_MESSAGE);
                                    //LimpiarCajas();
                                }
                                //validacionPago("membresia",String.valueOf(getCedula()),lblCategoria.getText());
                            }

                        }else{
                            JOptionPane.showMessageDialog(lblFondo, "Tiene que inscribir la categoria primero", "AVISO", JOptionPane.WARNING_MESSAGE);
                        }

                    }catch(SQLException ex){JOptionPane.showInternalMessageDialog(lblFondo, "Error: "+ex.getMessage(),"Problema", JOptionPane.PLAIN_MESSAGE);}

                }else{
                    JOptionPane.showMessageDialog(lblFondo, "Fecha membresia es mayor a la de inscripcion");
                }
            }else{ JOptionPane.showInternalMessageDialog(lblFondo, "Hay datos indispensables sin rellenar"); }
        }

    }//GEN-LAST:event_btnSubscribir1ActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

        java.sql.Date fechaActualSQL = new java.sql.Date(fechaActual.getTime().getYear(), fechaActual.getTime().getMonth()+1, fechaActual.getTime().getDate());

        if(ckbInscripcionAct.isSelected()==true){

            java.sql.Date fechaInscripcion = new java.sql.Date(dcFechaInscripcion.getDate().getYear(), dcFechaInscripcion.getDate().getMonth(), dcFechaInscripcion.getDate().getDate());
            java.sql.Date fechaVenceInscripcion = new java.sql.Date(dcFechaVenceInscripcion.getDate().getYear(), dcFechaVenceInscripcion.getDate().getMonth(), dcFechaVenceInscripcion.getDate().getDate());

            try{
                connection = Conectar.getConnection();
                ps = connection.prepareStatement("INSERT INTO temporalestadoinscripcionsakura(cedula,costo,fechainscripcion,fechavenceinscripcion,fechapago,vencimiento)VALUES (?,?,?,?,?,?)");
                ps.setInt(1,getCedula());
                ps.setFloat(2,cbVencimientosInscripcion.getSelectedItem().equals("Anual")?getInscripcion()*12
                    :cbVencimientosInscripcion.getSelectedItem().equals("Semestral")?getInscripcion()*6
                    :cbVencimientosInscripcion.getSelectedItem().equals("Trimestral")?getInscripcion()*3
                    :cbVencimientosInscripcion.getSelectedItem().equals("Quincenal")?(getInscripcion()/30)*15
                    :cbVencimientosInscripcion.getSelectedItem().equals("Semanal")?(getInscripcion()/30)*7
                    :cbVencimientosInscripcion.getSelectedItem().equals("Indefinido")?0
                    :getInscripcion());
                ps.setDate(3,fechaInscripcion);
                ps.setDate(4,fechaVenceInscripcion);
                ps.setDate(5,fechaActualSQL);
                ps.setString(6,cbVencimientosInscripcion.getSelectedItem().toString());

                int res1 = ps.executeUpdate();

                if(res1 > 0){

                    InhabilitarFechasInscripcion();
                    //e(0,ckbInscripcion);
                    v(0,btnActualizar);

                    this.dcFechaInscripcion.setBorder(javax.swing.BorderFactory.createLineBorder(Color.WHITE, 3));
                    this.dcFechaVenceInscripcion.setBorder(javax.swing.BorderFactory.createLineBorder(Color.WHITE, 3));
                    this.cbVencimientosInscripcion.setColorDeBorde(Color.WHITE);

                }else{
                    JOptionPane.showInternalMessageDialog(lblFondo, "Error al registrar inscripcion","Aviso",JOptionPane.WARNING_MESSAGE);
                    //LimpiarCajas();
                }

                connection.close();

            }catch(SQLException ex){ JOptionPane.showInternalMessageDialog(lblFondo, "Error: "+ex.getMessage(),"ERROR", JOptionPane.WARNING_MESSAGE); }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnActualizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizar1ActionPerformed

        java.sql.Date fechaActualSQL = new java.sql.Date(fechaActual.getTime().getYear(), fechaActual.getTime().getMonth()+1, fechaActual.getTime().getDate());

        if(ckbMembresiaAct.isSelected()==true){

            if(dcFechaVenceInscripcion.getDate()!=null && dcFechaInscripcion.getDate()!=null && dcFechaVenceMembresia.getDate()!=null && dcFechaMembresia.getDate()!=null){

                java.sql.Date fechaMembresia = new java.sql.Date(dcFechaMembresia.getDate().getYear(), dcFechaMembresia.getDate().getMonth(), dcFechaMembresia.getDate().getDate());
                java.sql.Date fechaVenceMembresia = new java.sql.Date(dcFechaVenceMembresia.getDate().getYear(), dcFechaVenceMembresia.getDate().getMonth(), dcFechaVenceMembresia.getDate().getDate());

                java.util.Date fechaVenceInscripcion = new Date(dcFechaVenceInscripcion.getDate().getYear(), dcFechaVenceInscripcion.getDate().getMonth(), dcFechaVenceInscripcion.getDate().getDate());
                java.util.Date fechaVenceMembresia1 = new Date(dcFechaVenceMembresia.getDate().getYear(), dcFechaVenceMembresia.getDate().getMonth(), dcFechaVenceMembresia.getDate().getDate());

                if(fechaVenceInscripcion.after(fechaVenceMembresia1)==true || fechaVenceInscripcion.equals(fechaVenceMembresia1)){

                    try{
                        connection = Conectar.getConnection();
                        PreparedStatement ps4 = connection.prepareStatement("SELECT * FROM estadoinscripcionsakura WHERE cedula='"+getCedula()+"'");
                        ResultSet res4 = ps4.executeQuery();

                        PreparedStatement ps5 = connection.prepareStatement("SELECT * FROM temporalestadoinscripcionsakura WHERE cedula='"+getCedula()+"'");
                        ResultSet res5 = ps5.executeQuery();

                        if(res4.next() || res5.next()){

                            connection = Conectar.getConnection();
                            ps = connection.prepareStatement("INSERT INTO temporalestadomembresiasakura(cedula,costo,fechamembresia,fechavencemembresia,fechapago,vencimiento)VALUES (?,?,?,?,?,?)");
                            ps.setInt(1,getCedula());
                            ps.setFloat(2,cbVencimientosMembresia.getSelectedItem().equals("Anual")?getMembresia()*12
                                :cbVencimientosMembresia.getSelectedItem().equals("Semestral")?getMembresia()*6
                                :cbVencimientosMembresia.getSelectedItem().equals("Trimestral")?getMembresia()*3
                                :cbVencimientosMembresia.getSelectedItem().equals("Quincenal")?(getMembresia()/30)*15
                                :cbVencimientosMembresia.getSelectedItem().equals("Semanal")?(getMembresia()/30)*7
                                :cbVencimientosMembresia.getSelectedItem().equals("Indefinido")?0
                                :getMembresia());
                            ps.setDate(3,fechaMembresia);
                            ps.setDate(4,fechaVenceMembresia);
                            ps.setDate(5,fechaActualSQL);
                            ps.setString(6,cbVencimientosMembresia.getSelectedItem().toString());

                            int res3 = ps.executeUpdate();

                            if(res3 > 0){

                                InhabilitarFechasMembresia();

                                //e(0,ckbMembresia);
                                v(0,btnActualizar1);

                                this.dcFechaMembresia.setBorder(javax.swing.BorderFactory.createLineBorder(Color.WHITE, 3));
                                this.dcFechaVenceMembresia.setBorder(javax.swing.BorderFactory.createLineBorder(Color.WHITE, 3));
                                this.cbVencimientosMembresia.setColorDeBorde(Color.WHITE);

                            }else{
                                JOptionPane.showInternalMessageDialog(lblFondo, "Error al registrar inscripcion","Aviso",JOptionPane.WARNING_MESSAGE);
                                //LimpiarCajas();
                            }
                            //validacionPago("membresia",String.valueOf(getCedula()),lblCategoria.getText());

                        }else{
                            JOptionPane.showMessageDialog(lblFondo, "Tiene que inscribir la categoria primero", "AVISO", JOptionPane.WARNING_MESSAGE);
                        }

                    }catch(SQLException ex){ JOptionPane.showInternalMessageDialog(lblFondo, "Error: "+ex.getMessage(),"Problema", JOptionPane.ERROR_MESSAGE); }

                }else{
                    JOptionPane.showMessageDialog(lblFondo, "Fecha membresia es mayor a la de inscripcion", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                }
            }else{ JOptionPane.showInternalMessageDialog(lblFondo, "Hay datos indispensables sin rellenar", "AVISO", JOptionPane.INFORMATION_MESSAGE); }
        }

    }//GEN-LAST:event_btnActualizar1ActionPerformed

    private void dcFechaMembresiaHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_dcFechaMembresiaHierarchyChanged

    }//GEN-LAST:event_dcFechaMembresiaHierarchyChanged

    private void dcFechaMembresiaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dcFechaMembresiaFocusGained

    }//GEN-LAST:event_dcFechaMembresiaFocusGained

    private void dcFechaMembresiaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dcFechaMembresiaFocusLost

    }//GEN-LAST:event_dcFechaMembresiaFocusLost

    private void dcFechaMembresiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dcFechaMembresiaMouseClicked

    }//GEN-LAST:event_dcFechaMembresiaMouseClicked

    private void dcFechaMembresiaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dcFechaMembresiaMouseEntered

    }//GEN-LAST:event_dcFechaMembresiaMouseEntered

    private void dcFechaMembresiaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dcFechaMembresiaMouseExited

    }//GEN-LAST:event_dcFechaMembresiaMouseExited

    private void dcFechaMembresiaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dcFechaMembresiaMousePressed

    }//GEN-LAST:event_dcFechaMembresiaMousePressed

    private void dcFechaMembresiaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dcFechaMembresiaMouseReleased

    }//GEN-LAST:event_dcFechaMembresiaMouseReleased

    private void dcFechaMembresiaInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_dcFechaMembresiaInputMethodTextChanged

    }//GEN-LAST:event_dcFechaMembresiaInputMethodTextChanged

    private void dcFechaMembresiaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dcFechaMembresiaPropertyChange

    }//GEN-LAST:event_dcFechaMembresiaPropertyChange

    private void dcFechaMembresiaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dcFechaMembresiaKeyPressed

    }//GEN-LAST:event_dcFechaMembresiaKeyPressed

    private void dcFechaMembresiaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dcFechaMembresiaKeyReleased

    }//GEN-LAST:event_dcFechaMembresiaKeyReleased

    private void dcFechaMembresiaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dcFechaMembresiaKeyTyped

    }//GEN-LAST:event_dcFechaMembresiaKeyTyped

    private void dcFechaMembresiaVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_dcFechaMembresiaVetoableChange

    }//GEN-LAST:event_dcFechaMembresiaVetoableChange

    private void btnFechaHoyMembresiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFechaHoyMembresiaActionPerformed

        GregorianCalendar fecha = new GregorianCalendar();

        java.util.Date fechaCompleta = fecha.getTime();

        dcFechaMembresia.setDate(fechaCompleta);
    }//GEN-LAST:event_btnFechaHoyMembresiaActionPerformed

    private void cbVencimientosMembresiaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbVencimientosMembresiaItemStateChanged

        Date fechaVencimiento = null;
        Date fechaActual1 = new Date(fechaActual.getTime().getYear(), fechaActual.getTime().getMonth(), fechaActual.getTime().getDate());
        e(1,dcFechaVenceMembresia);
        dcFechaMembresia.setDate(fechaActual1);
        e(0,dcFechaVenceMembresia);
        e(0,dcFechaMembresia);
        e(0,btnFechaHoyMembresia);
        btnFechaHoyMembresia.setBackground(azul);
        this.dcFechaMembresia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0), 3));
        this.dcFechaVenceMembresia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0), 3));

        if(cbVencimientosMembresia.getSelectedItem().equals("Semanal")){
            fechaVencimiento = new Date(dcFechaMembresia.getDate().getYear(), dcFechaMembresia.getDate().getMonth(), dcFechaMembresia.getDate().getDate()+7);
            dcFechaVenceMembresia.setDate(fechaVencimiento);
        }
        if(cbVencimientosMembresia.getSelectedItem().equals("Quincenal")){
            fechaVencimiento = new Date(dcFechaMembresia.getDate().getYear(), dcFechaMembresia.getDate().getMonth(), dcFechaMembresia.getDate().getDate()+15);
            dcFechaVenceMembresia.setDate(fechaVencimiento);
        }
        if(cbVencimientosMembresia.getSelectedItem().equals("Mensual")){
            fechaVencimiento = new Date(dcFechaMembresia.getDate().getYear(), dcFechaMembresia.getDate().getMonth()+1, dcFechaMembresia.getDate().getDate());
            dcFechaVenceMembresia.setDate(fechaVencimiento);
        }
        if(cbVencimientosMembresia.getSelectedItem().equals("Trimestral")){
            fechaVencimiento = new Date(dcFechaMembresia.getDate().getYear(), dcFechaMembresia.getDate().getMonth()+3, dcFechaMembresia.getDate().getDate());
            dcFechaVenceMembresia.setDate(fechaVencimiento);
        }
        if(cbVencimientosMembresia.getSelectedItem().equals("Semestral")){
            fechaVencimiento = new Date(dcFechaMembresia.getDate().getYear(), dcFechaMembresia.getDate().getMonth()+6, dcFechaMembresia.getDate().getDate());
            dcFechaVenceMembresia.setDate(fechaVencimiento);
        }
        if(cbVencimientosMembresia.getSelectedItem().equals("Anual")){
            fechaVencimiento = new Date(dcFechaMembresia.getDate().getYear()+1, dcFechaMembresia.getDate().getMonth(), dcFechaMembresia.getDate().getDate());
            dcFechaVenceMembresia.setDate(fechaVencimiento);
        }
        if(cbVencimientosMembresia.getSelectedItem().equals("Otro")){
            dcFechaVenceMembresia.setDate(null);
            dcFechaMembresia.setDate(null);
            e(1,dcFechaVenceMembresia);
            e(1,dcFechaMembresia);
            e(1,btnFechaHoyMembresia);
            btnFechaHoyMembresia.setBackground(amar);
        }
    }//GEN-LAST:event_cbVencimientosMembresiaItemStateChanged

    private void btnFechaHoyInscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFechaHoyInscripcionActionPerformed

        GregorianCalendar fecha = new GregorianCalendar();

        java.util.Date fechaCompleta = fecha.getTime();

        dcFechaInscripcion.setDate(fechaCompleta);

    }//GEN-LAST:event_btnFechaHoyInscripcionActionPerformed

    private void dcFechaInscripcionHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_dcFechaInscripcionHierarchyChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_dcFechaInscripcionHierarchyChanged

    private void dcFechaInscripcionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dcFechaInscripcionFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_dcFechaInscripcionFocusGained

    private void dcFechaInscripcionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dcFechaInscripcionFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_dcFechaInscripcionFocusLost

    private void dcFechaInscripcionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dcFechaInscripcionMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_dcFechaInscripcionMouseClicked

    private void dcFechaInscripcionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dcFechaInscripcionMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_dcFechaInscripcionMouseEntered

    private void dcFechaInscripcionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dcFechaInscripcionMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_dcFechaInscripcionMouseExited

    private void dcFechaInscripcionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dcFechaInscripcionMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_dcFechaInscripcionMousePressed

    private void dcFechaInscripcionMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dcFechaInscripcionMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_dcFechaInscripcionMouseReleased

    private void dcFechaInscripcionInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_dcFechaInscripcionInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_dcFechaInscripcionInputMethodTextChanged

    private void dcFechaInscripcionPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dcFechaInscripcionPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_dcFechaInscripcionPropertyChange

    private void dcFechaInscripcionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dcFechaInscripcionKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_dcFechaInscripcionKeyPressed

    private void dcFechaInscripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dcFechaInscripcionKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_dcFechaInscripcionKeyReleased

    private void dcFechaInscripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dcFechaInscripcionKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_dcFechaInscripcionKeyTyped

    private void dcFechaInscripcionVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_dcFechaInscripcionVetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_dcFechaInscripcionVetoableChange

    private void dcFechaVenceInscripcionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dcFechaVenceInscripcionFocusGained

    }//GEN-LAST:event_dcFechaVenceInscripcionFocusGained

    private void dcFechaVenceInscripcionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dcFechaVenceInscripcionFocusLost

    }//GEN-LAST:event_dcFechaVenceInscripcionFocusLost

    private void dcFechaVenceInscripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dcFechaVenceInscripcionKeyTyped

    }//GEN-LAST:event_dcFechaVenceInscripcionKeyTyped

    private void cbVencimientosInscripcionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbVencimientosInscripcionItemStateChanged

        Date fechaVencimiento = null;
        Date fechaActual1 = new Date(fechaActual.getTime().getYear(), fechaActual.getTime().getMonth(), fechaActual.getTime().getDate());
        e(1,dcFechaVenceInscripcion);
        dcFechaInscripcion.setDate(fechaActual1);
        e(0,dcFechaVenceInscripcion);
        e(0,dcFechaInscripcion);
        e(0,btnFechaHoyInscripcion);
        this.dcFechaInscripcion.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK, 3));
        this.dcFechaVenceInscripcion.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK, 3));
        btnFechaHoyInscripcion.setBackground(azul);
        e(1,ckbMembresia);

        if((ckbMembresia.isSelected() && ckbMembresiaAct.isSelected())){
            try {
                validacionPago("membresia",String.valueOf(getCedula()));
                this.dcFechaMembresia.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK, 3));
                this.dcFechaVenceMembresia.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK, 3));
            } catch (SQLException ex) {
                JOptionPane.showInternalMessageDialog(lblFondo, "Error: "+ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }

        if(!lblPagado.isVisible() && !lblPendiente.isVisible()){
            try {
                validacionPago("membresia",String.valueOf(getCedula()));
                this.dcFechaMembresia.setBorder(javax.swing.BorderFactory.createLineBorder(amar, 3));
                this.dcFechaVenceMembresia.setBorder(javax.swing.BorderFactory.createLineBorder(amar, 3));
            } catch (SQLException ex) {
                JOptionPane.showInternalMessageDialog(lblFondo, "Error: "+ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }

        if(ckbMembresiaAct.isSelected()){

            v(0,lblPendiente1);
            v(0,lblPagado1);
            v(0,lblDato1);

        }

        if(cbVencimientosInscripcion.getSelectedItem().equals("Semanal")){
            fechaVencimiento = new Date(dcFechaInscripcion.getDate().getYear(), dcFechaInscripcion.getDate().getMonth(), dcFechaInscripcion.getDate().getDate()+7);
            dcFechaVenceInscripcion.setDate(fechaVencimiento);
        }
        if(cbVencimientosInscripcion.getSelectedItem().equals("Quincenal")){
            fechaVencimiento = new Date(dcFechaInscripcion.getDate().getYear(), dcFechaInscripcion.getDate().getMonth(), dcFechaInscripcion.getDate().getDate()+15);
            dcFechaVenceInscripcion.setDate(fechaVencimiento);
        }
        if(cbVencimientosInscripcion.getSelectedItem().equals("Mensual")){
            fechaVencimiento = new Date(dcFechaInscripcion.getDate().getYear(), dcFechaInscripcion.getDate().getMonth()+1, dcFechaInscripcion.getDate().getDate());
            dcFechaVenceInscripcion.setDate(fechaVencimiento);
        }
        if(cbVencimientosInscripcion.getSelectedItem().equals("Trimestral")){
            fechaVencimiento = new Date(dcFechaInscripcion.getDate().getYear(), dcFechaInscripcion.getDate().getMonth()+3, dcFechaInscripcion.getDate().getDate());
            dcFechaVenceInscripcion.setDate(fechaVencimiento);
        }
        if(cbVencimientosInscripcion.getSelectedItem().equals("Semestral")){
            fechaVencimiento = new Date(dcFechaInscripcion.getDate().getYear(), dcFechaInscripcion.getDate().getMonth()+6, dcFechaInscripcion.getDate().getDate());
            dcFechaVenceInscripcion.setDate(fechaVencimiento);
        }
        if(cbVencimientosInscripcion.getSelectedItem().equals("Anual")){
            fechaVencimiento = new Date(dcFechaInscripcion.getDate().getYear()+1, dcFechaInscripcion.getDate().getMonth(), dcFechaInscripcion.getDate().getDate());
            dcFechaVenceInscripcion.setDate(fechaVencimiento);
        }
        if(cbVencimientosInscripcion.getSelectedItem().equals("Otro")){
            dcFechaVenceInscripcion.setDate(null);
            dcFechaInscripcion.setDate(null);
            e(1,dcFechaVenceInscripcion);
            e(1,dcFechaInscripcion);
            e(1,btnFechaHoyInscripcion);
            btnFechaHoyInscripcion.setBackground(amar);
        }
        if(cbVencimientosInscripcion.getSelectedItem().equals("Indefinido")){
            InhabilitarFechasMembresia();
            LimpiarCajasMembresia();
            dcFechaVenceInscripcion.setDate(fechaActual1);
            dcFechaInscripcion.setDate(fechaActual1);
            v(0,lblDato1);
            v(0,lblPagado1);
            v(0,lblPendiente1);
            e(0,dcFechaMembresia);
            e(0,dcFechaVenceMembresia);
            e(0,btnFechaHoyMembresia);
            btnFechaHoyMembresia.setBackground(azul);
            e(0,ckbMembresia);
            e(0,ckbMembresiaAct);
            this.dcFechaMembresia.setBorder(javax.swing.BorderFactory.createLineBorder(amar, 3));
            this.dcFechaVenceMembresia.setBorder(javax.swing.BorderFactory.createLineBorder(amar, 3));
            ckbMembresia.setSelected(false);
            ckbMembresiaAct.setSelected(false);
        }

    }//GEN-LAST:event_cbVencimientosInscripcionItemStateChanged

    /*public void run(){
        
        Thread ct = Thread.currentThread();
        
        while(ct == h1){
            calcula();

            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                JOptionPane.showMessageDialog(lblFondo,"Error: "+e.getMessage());
            }
        }
    }*/
    
    private void calcula(){
        
        Date fechaInscripcion = null;

        if(cbVencimientosInscripcion.getSelectedItem().equals("Indefinido")){
            e(0,dcFechaVenceInscripcion);
            InhabilitarFechasMembresia();
            fechaInscripcion = new Date(dcFechaInscripcion.getDate().getYear(), dcFechaInscripcion.getDate().getMonth(), dcFechaInscripcion.getDate().getDate());
            dcFechaVenceInscripcion.setDate(fechaInscripcion);
        }
        
    }
    
    private void HabilitarFechasInscripcion(){
        
        e(1,dcFechaInscripcion);
        e(1,dcFechaVenceInscripcion);
        e(1,btnFechaHoyInscripcion);
        e(1,cbVencimientosInscripcion);

        this.dcFechaInscripcion.setBackground(amar);
        this.dcFechaVenceInscripcion.setBackground(amar);
        this.cbVencimientosInscripcion.setBackground(amar);
        this.btnFechaHoyInscripcion.setBackground(amar);

        //
        /*this.FECHA2.setColorDeSombra(azul);
        this.FECHA3.setColorDeSombra(azul);
        this.HASTA1.setColorDeSombra(azul);*/

        this.dcFechaInscripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0), 3));
        this.dcFechaVenceInscripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0), 3));
        this.cbVencimientosInscripcion.setColorDeBorde(new java.awt.Color(0,0,0));
    }
    
    private void InhabilitarFechasInscripcion(){
        
        e(0,dcFechaInscripcion);
        e(0,dcFechaVenceInscripcion);
        e(0,btnFechaHoyInscripcion);
        e(0,cbVencimientosInscripcion);

        this.dcFechaInscripcion.setBackground(azul);
        this.dcFechaVenceInscripcion.setBackground(azul);
        this.cbVencimientosInscripcion.setBackground(azul);
        this.btnFechaHoyInscripcion.setBackground(azul);
        
        //
        this.FECHA2.setColorDeSombra(amar);
        this.FECHA3.setColorDeSombra(amar);
        this.HASTA1.setColorDeSombra(amar);

        this.dcFechaInscripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,255,102), 3));
        this.dcFechaVenceInscripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,255,102), 3));
        this.cbVencimientosInscripcion.setColorDeBorde(new java.awt.Color(255,255,102));
    }
    
    private void HabilitarFechasMembresia(){

        e(1,dcFechaMembresia);
        e(1,dcFechaVenceMembresia);
        e(1,btnFechaHoyMembresia);
        e(1,cbVencimientosMembresia);

        this.dcFechaMembresia.setBackground(amar);
        this.dcFechaVenceMembresia.setBackground(amar);
        this.cbVencimientosMembresia.setBackground(amar);
        this.btnFechaHoyMembresia.setBackground(amar);

        //
        /*this.FECHA.setColorDeSombra(azul);
        this.FECHA1.setColorDeSombra(azul);
        this.FECHA2.setColorDeSombra(azul);
        this.FECHA3.setColorDeSombra(azul);
        this.HASTA.setColorDeSombra(azul);
        this.HASTA1.setColorDeSombra(azul);*/

        this.dcFechaMembresia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0), 3));
        this.dcFechaVenceMembresia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0), 3));
        this.cbVencimientosMembresia.setColorDeBorde(new java.awt.Color(0,0,0));
    }
    
    private void InhabilitarFechasMembresia(){

        e(0,dcFechaMembresia);
        e(0,dcFechaVenceMembresia);
        e(0,btnFechaHoyMembresia);
        e(0,cbVencimientosMembresia);

        this.dcFechaMembresia.setBackground(azul);
        this.dcFechaVenceMembresia.setBackground(azul);
        this.cbVencimientosMembresia.setBackground(azul);
        this.btnFechaHoyMembresia.setBackground(azul);
        
        //
        this.FECHA.setColorDeSombra(amar);
        this.FECHA1.setColorDeSombra(amar);
        this.FECHA2.setColorDeSombra(amar);
        this.FECHA3.setColorDeSombra(amar);
        this.HASTA.setColorDeSombra(amar);
        this.HASTA1.setColorDeSombra(amar);

        this.dcFechaMembresia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,255,102), 3));
        this.dcFechaVenceMembresia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,255,102), 3));
        this.cbVencimientosMembresia.setColorDeBorde(new java.awt.Color(255,255,102));
        
    }
    
    private void LimpiarCajasInscripcion(){
        
        dcFechaInscripcion.setDate(null);
        dcFechaVenceInscripcion.setDate(null);
        cbVencimientosInscripcion.setSelectedItem("Otro");
        ckbInscripcion.setSelected(false);
    }
    
    private void LimpiarCajasMembresia(){
        
        dcFechaMembresia.setDate(null);
        dcFechaVenceMembresia.setDate(null);
        cbVencimientosMembresia.setSelectedItem("Otro");
        ckbMembresia.setSelected(false);
    }

    private void e(int numAcc, Component comp){
        
        if(numAcc == 0){
            comp.setEnabled(false);
            comp.setFocusable(false);  
        }
        
        if(numAcc == 1){
            comp.setEnabled(true);
            comp.setFocusable(true);
        }
    }
    
    private void v(int numAcc, Component comp){
        
         if(numAcc == 0){
            comp.setVisible(false);
            comp.setEnabled(false);
            comp.setFocusable(false);
        }
        
        if(numAcc == 1){
            comp.setVisible(true);
            comp.setEnabled(true);
            comp.setFocusable(true);
        }
    }
    
    private void vn(int numAcc, Component comp){
        
         if(numAcc == 0){
            comp.setVisible(false);
            comp.setFocusable(false);
        }
        
        if(numAcc == 1){
            comp.setVisible(true);
            comp.setFocusable(true);
        }
    }
    
    private void validacionPago(String tipo,String cedula) throws SQLException{

        GregorianCalendar fecha = new GregorianCalendar();
        
        if(tipo.equals("inscripcion")){
            
            try{

                connection = Conectar.getConnection();
                PreparedStatement ps1 = connection.prepareStatement("SELECT * FROM estadoinscripcionsakura WHERE cedula='"+cedula+"'");
                ResultSet res = ps1.executeQuery();

                while(res.next()){

                    Calendar calendarInicio = Calendar.getInstance();
                    Calendar calendarFin = Calendar.getInstance();
                    calendarInicio.setTime(res.getDate("fechainscripcion"));
                    calendarFin.setTime(res.getDate("fechavenceinscripcion"));

                    dcFechaInscripcion.setDate(res.getDate("fechainscripcion"));
                    dcFechaVenceInscripcion.setDate(res.getDate("fechavenceinscripcion"));
                    cbVencimientosInscripcion.setSelectedItem(res.getString("vencimiento"));
                    
                    
                    if(DiferenciaFechas(res.getDate("fechainscripcion"), res.getDate("fechavenceinscripcion"), 2)==0){
                        lblDato.setText("Indefinido");
                    }else if(res.getDate("fechavenceinscripcion").after(fecha.getTime())){
                        lblPagado.setVisible(true);
                        lblDato.setForeground(amar);
                        lblDato.setText("Vigente por "+DiferenciaFechas(fecha.getTime(), res.getDate("fechavenceinscripcion"), 2)+" días");
                    }else if(res.getDate("fechavenceinscripcion").before(fecha.getTime())){
                        lblPendiente.setVisible(true);
                        lblDato.setText("Expiró hace "+DiferenciaFechas(res.getDate("fechavenceinscripcion"), fecha.getTime(), 2)+" días");    
                    }else if(DiferenciaFechas(res.getDate("fechainscripcion"), res.getDate("fechavenceinscripcion"), 2)==0){
                        lblDato.setText("Afiliado inscrito indefinidamente");
                    }else{
                        lblDato.setText("Error");
                    }

                    v(0,ckbInscripcion);
                    v(1,ckbInscripcionAct);

                }
            
            }catch(SQLException ex){
                JOptionPane.showInternalMessageDialog(lblFondo, "Error: "+ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }catch(IllegalArgumentException iae){
                JOptionPane.showInternalMessageDialog(lblFondo, "Error: "+iae.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        
        if(tipo.equals("membresia")){
            
            try{

                connection = Conectar.getConnection();
                PreparedStatement ps1 = connection.prepareStatement("SELECT * FROM estadomembresiasakura WHERE cedula='"+cedula+"'");
                ResultSet res = ps1.executeQuery();

                while(res.next()){

                    Calendar calendarInicio = Calendar.getInstance();
                    Calendar calendarFin = Calendar.getInstance();
                    calendarInicio.setTime(res.getDate("fechamembresia"));
                    calendarFin.setTime(res.getDate("fechavencemembresia"));
                    
                    dcFechaMembresia.setDate(res.getDate("fechamembresia"));
                    dcFechaVenceMembresia.setDate(res.getDate("fechavencemembresia"));
                    cbVencimientosMembresia.setSelectedItem(res.getString("vencimiento"));

                    if(res.getDate("fechavencemembresia").after(fecha.getTime())){
                        lblPagado1.setVisible(true);
                        e(1,lblPagado1);
                        lblDato1.setVisible(true);
                        lblDato1.setForeground(amar);
                        lblDato1.setText("Vigente por "+DiferenciaFechas(fecha.getTime(), res.getDate("fechavencemembresia"), 2)+" días");
                    }else if(res.getDate("fechavencemembresia").before(fecha.getTime())){
                        lblPendiente1.setVisible(true);
                        e(1,lblPendiente1);
                        lblDato1.setVisible(true);
                        lblDato1.setText("Expiró hace "+DiferenciaFechas(res.getDate("fechavencemembresia"), fecha.getTime(), 2)+" días");    
                    }else{

                    }

                    v(0,ckbMembresia);
                    v(1,ckbMembresiaAct);

                }
            
            }catch(SQLException ex){
                JOptionPane.showInternalMessageDialog(lblFondo, "Error: "+ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }catch(IllegalArgumentException iae){
                JOptionPane.showInternalMessageDialog(lblFondo, "Error: "+iae.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private long DiferenciaFechas(java.util.Date fechaInicio, java.util.Date fechaFin, int tipo){
        
        //FECHA INICIO
        Calendar calendarInicio = Calendar.getInstance();
        calendarInicio.setTime(fechaInicio);
        int diaInicio = calendarInicio.get(Calendar.DAY_OF_MONTH);
        int mesInicio = calendarInicio.get(Calendar.MONTH);
        int anioInicio = calendarInicio.get(Calendar.YEAR);
        
        //FECHA FIN
        Calendar calendarFin = Calendar.getInstance();
        calendarFin.setTime(fechaFin);
        int diaFin = calendarFin.get(Calendar.DAY_OF_MONTH);
        int mesFin = calendarFin.get(Calendar.MONTH);
        int anioFin = calendarFin.get(Calendar.YEAR);
        
        int anios = 0;
        int mesesPorAnio = 0;
        int diasPorMes = 0;
        int diasTipoMes = 0;
        
        /**
         * Cálculo de dias del mes
         */
        if(mesInicio==2){
            //Febrero
            if((anioFin % 4 == 0) && ((anioFin % 100 != 0) || (anioFin % 400 == 0))){
                //Bisiestro
                diasTipoMes = 29;
            }else{
                //No bisiestro
                diasTipoMes = 28;
            }
        }else if(mesInicio <= 7){
            //De enero a julio los meses pares tienen 30 y los impares 31
            if(mesInicio % 2 == 0){
                diasTipoMes = 30;
            }else{
                diasTipoMes = 31;
            }
        }else if(mesInicio > 7){
            //De julio a diciembre los meses pares tienen 31 y los impares 30
            if(mesInicio % 2 == 0){
                diasTipoMes = 31;
            }else{
                diasTipoMes = 30;
            }
        }
        
        /**
         * Cálculo de diferencia de año, mes, dia
         */
        if((anioInicio > anioFin) || (anioInicio == anioFin && mesInicio > mesFin) || (anioInicio == anioFin && mesInicio == mesFin && diaInicio > diaFin)){
            //La fecha de inicio es posterior a la fecha fin
            return -1;
        }else{
            if(mesInicio <= mesFin){
                anios = anioFin - anioInicio;
                
                if(diaInicio <= diaFin){
                    mesesPorAnio = mesFin - mesInicio;
                    diasPorMes = diaFin - diaInicio;
                }else{
                    if(mesFin == mesInicio){
                        anios = anios -1;
                    }
                    
                    mesesPorAnio = (mesFin - mesInicio -1 +10) % 12;
                    diasPorMes = diasTipoMes - (diaInicio - diaFin);
                }
            }else{
                anios = anioFin - anioInicio - 1;
                System.out.println(anios);
                if(diaInicio > diaFin){
                    mesesPorAnio = mesFin - mesInicio -1 + 12;
                    diasPorMes = diasTipoMes - (diaInicio - diaFin);
                }else{
                    mesesPorAnio = mesFin - mesInicio + 12;
                    diasPorMes = diaFin - diaInicio;
                }
            }
        }
        
        /**
         * TOTALES
         */
        long returnValue = -1;
        
        switch(tipo){
            
            case 0:
                //Total años
                returnValue = anios;
                break;
                
            case 1:
                //Total meses
                returnValue = anios * 12 + mesesPorAnio;
                break;
                
            case 2:
                //Total dias (se calcula a partir de los milisegundos por dia)
                long millsecsPorDay = 86400000; //Milisegundos al día
                returnValue = (fechaFin.getTime() - fechaInicio.getTime()) / millsecsPorDay;
                break;
                
            case 3:
                //Meses del año
                returnValue = mesesPorAnio;
                break;
                
            case 4:
                //Dias del mes
                returnValue = diasPorMes;
                break;
                
            default:
                    break;
            
        }
        
        return returnValue;
        
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private elaprendiz.gui.label.LabelMetric FECHA;
    private elaprendiz.gui.label.LabelMetric FECHA1;
    private elaprendiz.gui.label.LabelMetric FECHA2;
    private elaprendiz.gui.label.LabelMetric FECHA3;
    private elaprendiz.gui.label.LabelMetric HASTA;
    private elaprendiz.gui.label.LabelMetric HASTA1;
    private elaprendiz.gui.label.LabelMetric INSCRIPCION;
    private elaprendiz.gui.label.LabelMetric MENSUALIDAD;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnActualizar1;
    private elaprendiz.gui.button.ButtonAeroLeft btnFechaHoyInscripcion;
    private elaprendiz.gui.button.ButtonAeroLeft btnFechaHoyMembresia;
    private javax.swing.JButton btnSubscribir;
    private javax.swing.JButton btnSubscribir1;
    private elaprendiz.gui.comboBox.ComboBoxRectIcon cbVencimientosInscripcion;
    private elaprendiz.gui.comboBox.ComboBoxRectIcon cbVencimientosMembresia;
    private javax.swing.JCheckBox ckbInscripcion;
    private javax.swing.JCheckBox ckbInscripcionAct;
    private javax.swing.JCheckBox ckbMembresia;
    private javax.swing.JCheckBox ckbMembresiaAct;
    private com.toedter.calendar.JDateChooser dcFechaInscripcion;
    private com.toedter.calendar.JDateChooser dcFechaMembresia;
    private com.toedter.calendar.JDateChooser dcFechaVenceInscripcion;
    private com.toedter.calendar.JDateChooser dcFechaVenceMembresia;
    private elaprendiz.gui.label.LabelMetric lblCategoria;
    private elaprendiz.gui.label.LabelMetric lblDato;
    private elaprendiz.gui.label.LabelMetric lblDato1;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblPagado;
    private javax.swing.JLabel lblPagado1;
    private javax.swing.JLabel lblPendiente;
    private javax.swing.JLabel lblPendiente1;
    private javax.swing.JLabel txtInscripcion;
    private javax.swing.JLabel txtMembresia;
    // End of variables declaration//GEN-END:variables
}
