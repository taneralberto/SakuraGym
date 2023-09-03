package sakura.ventanas;

import clases.Config;
import clases.bdd.Conectar;
import clases.util.FiltraEntrada;
import clases.util.Helper;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class IFConfig extends javax.swing.JInternalFrame {
    
    //VARIABLES
    private Config cg = new Config();
    private int idCategoria = -1;
    private int idMembresia = -1;
    private boolean GuardarEsGuardarCambiosCategorias = false;
    private boolean GuardarEsGuardarCambiosMembresias = false;

    //COLORES
    private final static Color azul = new Color(0, 203, 255);
    private final static Color amar = new Color(255, 255, 102);
    
    //CONEXIONES
    private PreparedStatement preparedStatement;
    private Connection connection;
    private ResultSet resultSet;
    private Statement st;
    
    public IFConfig() throws AWTException {

        initComponents();
        
        setFiltroTexto();
        
        InsertarCategorias();
        InsertarFederativas();
        InsertarNoFederativas();
        InhabilitarDatosCategoria();
        InsertarCostosSakura();

        e(0,btnCancelar);
        e(0,btnGuardar);
        e(0,btnEliminar);
        e(0,btnEditar);
        v(0,pnlCategorias);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo = new elaprendiz.gui.panel.PanelImage();
        pnlCurvas = new elaprendiz.gui.panel.PanelCurves();
        pnlCategorias = new elaprendiz.gui.panel.PanelImage();
        pnlListaCategorias = new javax.swing.JPanel();
        scrollCategorias = new javax.swing.JScrollPane();
        listCategorias = new javax.swing.JList<>();
        pnlDatosCategorias = new elaprendiz.gui.panel.PanelImage();
        MENSUALIDAD = new elaprendiz.gui.label.LabelMetric();
        txtMensualidad = new elaprendiz.gui.textField.TextFieldRectIcon();
        INSCRIPCION = new elaprendiz.gui.label.LabelMetric();
        txtInscripcion = new elaprendiz.gui.textField.TextFieldRectIcon();
        NOMBRECATEGORIA = new elaprendiz.gui.label.LabelMetric();
        txtNombreCategoria = new elaprendiz.gui.textField.TextFieldRectIcon();
        INSTRUCTOR = new elaprendiz.gui.label.LabelMetric();
        txtInstructor = new elaprendiz.gui.textField.TextFieldRectIcon();
        domingo = new javax.swing.JCheckBox();
        lunes = new javax.swing.JCheckBox();
        martes = new javax.swing.JCheckBox();
        miercoles = new javax.swing.JCheckBox();
        jueves = new javax.swing.JCheckBox();
        viernes = new javax.swing.JCheckBox();
        sabado = new javax.swing.JCheckBox();
        DIASDESEMANA = new elaprendiz.gui.label.LabelMetric();
        HORARIO = new elaprendiz.gui.label.LabelMetric();
        txtHora1 = new elaprendiz.gui.textField.TextFieldRectIcon();
        cbAMPM1 = new elaprendiz.gui.comboBox.ComboBoxRectIcon();
        txtHora2 = new elaprendiz.gui.textField.TextFieldRectIcon();
        cbAMPM2 = new elaprendiz.gui.comboBox.ComboBoxRectIcon();
        jLabel1 = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        pnlDatosPersonales1 = new elaprendiz.gui.panel.PanelTranslucido();
        scrollFederativa = new javax.swing.JScrollPane();
        listFederativa = new javax.swing.JList<>();
        btnEliminar1 = new javax.swing.JButton();
        btnNuevo1 = new javax.swing.JButton();
        CATEGORIA = new elaprendiz.gui.label.LabelMetric();
        txtFederativa = new elaprendiz.gui.textField.TextFieldRectIcon();
        CATEGORIA1 = new elaprendiz.gui.label.LabelMetric();
        scrollNoFederativa = new javax.swing.JScrollPane();
        listNoFederativa = new javax.swing.JList<>();
        txtNoFederativa = new elaprendiz.gui.textField.TextFieldRectIcon();
        btnNuevo2 = new javax.swing.JButton();
        btnEliminar2 = new javax.swing.JButton();
        panelTranslucido1 = new elaprendiz.gui.panel.PanelTranslucido();
        CATEGORIA2 = new elaprendiz.gui.label.LabelMetric();
        txtCostoInscripcion = new elaprendiz.gui.textField.TextFieldRectIcon();
        CATEGORIA3 = new elaprendiz.gui.label.LabelMetric();
        txtCostoMembresia = new elaprendiz.gui.textField.TextFieldRectIcon();
        jButton2 = new javax.swing.JButton();
        progressbarBarra = new elaprendiz.gui.progressBar.ProgressBarRound();

        setClosable(true);
        setIconifiable(true);
        setTitle("Configuración");

        pnlFondo.setBackground(new java.awt.Color(255, 255, 255));
        pnlFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/fondo-abstracto-celeste_1077-3.jpg"))); // NOI18N
        pnlFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlCurvas.setBackground(new java.awt.Color(255, 0, 0));
        pnlCurvas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlCategorias.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlListaCategorias.setLayout(new java.awt.BorderLayout());

        listCategorias.setBackground(new java.awt.Color(0, 204, 255));
        listCategorias.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        listCategorias.setForeground(new java.awt.Color(255, 255, 255));
        listCategorias.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listCategorias.setLayoutOrientation(javax.swing.JList.VERTICAL_WRAP);
        listCategorias.setSelectedIndex(0);
        listCategorias.setSelectionBackground(new java.awt.Color(255, 255, 102));
        listCategorias.setVisibleRowCount(20);
        listCategorias.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listCategoriasValueChanged(evt);
            }
        });
        scrollCategorias.setViewportView(listCategorias);

        pnlListaCategorias.add(scrollCategorias, java.awt.BorderLayout.CENTER);

        pnlCategorias.add(pnlListaCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 140, 330));

        pnlDatosCategorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/fondotrans.png"))); // NOI18N
        pnlDatosCategorias.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MENSUALIDAD.setForeground(new java.awt.Color(0, 0, 0));
        MENSUALIDAD.setText("Mensualidad");
        MENSUALIDAD.setColorDeSombra(new java.awt.Color(255, 255, 51));
        MENSUALIDAD.setDistanciaDeSombra(1);
        pnlDatosCategorias.add(MENSUALIDAD, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 20));

        txtMensualidad.setEditable(false);
        txtMensualidad.setBackground(new java.awt.Color(0, 204, 255));
        txtMensualidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 102), 3));
        txtMensualidad.setAnchoDeBorde(4.0F);
        txtMensualidad.setColorDeBorde(new java.awt.Color(255, 255, 102));
        txtMensualidad.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtMensualidad.setDragEnabled(true);
        txtMensualidad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtMensualidad.setPreferredSize(new java.awt.Dimension(120, 20));
        pnlDatosCategorias.add(txtMensualidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 150, 30));

        INSCRIPCION.setForeground(new java.awt.Color(0, 0, 0));
        INSCRIPCION.setText("Inscripción");
        INSCRIPCION.setColorDeSombra(new java.awt.Color(255, 255, 51));
        INSCRIPCION.setDistanciaDeSombra(1);
        pnlDatosCategorias.add(INSCRIPCION, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 20));

        txtInscripcion.setEditable(false);
        txtInscripcion.setBackground(new java.awt.Color(0, 204, 255));
        txtInscripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 102), 3));
        txtInscripcion.setAnchoDeBorde(4.0F);
        txtInscripcion.setColorDeBorde(new java.awt.Color(255, 255, 102));
        txtInscripcion.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtInscripcion.setDragEnabled(true);
        txtInscripcion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlDatosCategorias.add(txtInscripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 150, 30));

        NOMBRECATEGORIA.setForeground(new java.awt.Color(0, 0, 0));
        NOMBRECATEGORIA.setText("Nombre");
        NOMBRECATEGORIA.setColorDeSombra(new java.awt.Color(255, 255, 51));
        NOMBRECATEGORIA.setDistanciaDeSombra(1);
        pnlDatosCategorias.add(NOMBRECATEGORIA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 20));

        txtNombreCategoria.setEditable(false);
        txtNombreCategoria.setBackground(new java.awt.Color(0, 204, 255));
        txtNombreCategoria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 102), 3));
        txtNombreCategoria.setAnchoDeBorde(4.0F);
        txtNombreCategoria.setColorDeBorde(new java.awt.Color(255, 255, 102));
        txtNombreCategoria.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNombreCategoria.setDragEnabled(true);
        txtNombreCategoria.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNombreCategoria.setPreferredSize(new java.awt.Dimension(120, 20));
        pnlDatosCategorias.add(txtNombreCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 150, 30));

        INSTRUCTOR.setForeground(new java.awt.Color(0, 0, 0));
        INSTRUCTOR.setText("Instructor");
        INSTRUCTOR.setColorDeSombra(new java.awt.Color(255, 255, 51));
        INSTRUCTOR.setDistanciaDeSombra(1);
        pnlDatosCategorias.add(INSTRUCTOR, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, 20));

        txtInstructor.setEditable(false);
        txtInstructor.setBackground(new java.awt.Color(0, 204, 255));
        txtInstructor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 102), 3));
        txtInstructor.setAnchoDeBorde(4.0F);
        txtInstructor.setColorDeBorde(new java.awt.Color(255, 255, 102));
        txtInstructor.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtInstructor.setDragEnabled(true);
        txtInstructor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtInstructor.setPreferredSize(new java.awt.Dimension(120, 20));
        pnlDatosCategorias.add(txtInstructor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 150, 30));

        domingo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        domingo.setText("Domingo");
        domingo.setContentAreaFilled(false);
        pnlDatosCategorias.add(domingo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        lunes.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lunes.setText("Lunes");
        lunes.setContentAreaFilled(false);
        lunes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lunesActionPerformed(evt);
            }
        });
        pnlDatosCategorias.add(lunes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        martes.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        martes.setText("Martes");
        martes.setContentAreaFilled(false);
        pnlDatosCategorias.add(martes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        miercoles.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        miercoles.setText("Miércoles");
        miercoles.setContentAreaFilled(false);
        pnlDatosCategorias.add(miercoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, -1, -1));

        jueves.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jueves.setText("Jueves");
        jueves.setContentAreaFilled(false);
        pnlDatosCategorias.add(jueves, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, -1, -1));

        viernes.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        viernes.setText("Viernes");
        viernes.setContentAreaFilled(false);
        pnlDatosCategorias.add(viernes, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, -1, -1));

        sabado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sabado.setText("Sábado");
        sabado.setContentAreaFilled(false);
        pnlDatosCategorias.add(sabado, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, -1, -1));

        DIASDESEMANA.setForeground(new java.awt.Color(0, 0, 0));
        DIASDESEMANA.setText("Días de semana");
        DIASDESEMANA.setColorDeSombra(new java.awt.Color(255, 255, 51));
        DIASDESEMANA.setDistanciaDeSombra(1);
        pnlDatosCategorias.add(DIASDESEMANA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, 20));

        HORARIO.setForeground(new java.awt.Color(0, 0, 0));
        HORARIO.setText("Horario");
        HORARIO.setColorDeSombra(new java.awt.Color(255, 255, 51));
        HORARIO.setDistanciaDeSombra(1);
        pnlDatosCategorias.add(HORARIO, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, 20));

        txtHora1.setEditable(false);
        txtHora1.setBackground(new java.awt.Color(0, 204, 255));
        txtHora1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 102), 3));
        txtHora1.setAnchoDeBorde(4.0F);
        txtHora1.setColorDeBorde(new java.awt.Color(255, 255, 102));
        txtHora1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtHora1.setDragEnabled(true);
        txtHora1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtHora1.setPreferredSize(new java.awt.Dimension(120, 20));
        pnlDatosCategorias.add(txtHora1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 70, 30));

        cbAMPM1.setBackground(new java.awt.Color(0, 204, 255));
        cbAMPM1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 102)));
        cbAMPM1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AM", "PM" }));
        cbAMPM1.setAnchoDeBorde(4.0F);
        cbAMPM1.setColorDeBorde(new java.awt.Color(255, 255, 102));
        cbAMPM1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbAMPM1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbAMPM1ItemStateChanged(evt);
            }
        });
        pnlDatosCategorias.add(cbAMPM1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, -1, 30));

        txtHora2.setEditable(false);
        txtHora2.setBackground(new java.awt.Color(0, 204, 255));
        txtHora2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 102), 3));
        txtHora2.setAnchoDeBorde(4.0F);
        txtHora2.setColorDeBorde(new java.awt.Color(255, 255, 102));
        txtHora2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtHora2.setDragEnabled(true);
        txtHora2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtHora2.setPreferredSize(new java.awt.Dimension(120, 20));
        pnlDatosCategorias.add(txtHora2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 70, 30));

        cbAMPM2.setBackground(new java.awt.Color(0, 204, 255));
        cbAMPM2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 102)));
        cbAMPM2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AM", "PM" }));
        cbAMPM2.setAnchoDeBorde(4.0F);
        cbAMPM2.setColorDeBorde(new java.awt.Color(255, 255, 102));
        cbAMPM2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbAMPM2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbAMPM2ItemStateChanged(evt);
            }
        });
        pnlDatosCategorias.add(cbAMPM2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, -1, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("-");
        pnlDatosCategorias.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 20, 30));

        pnlCategorias.add(pnlDatosCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 330, 340));

        btnNuevo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/btnLNuevoDoc.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setBorder(null);
        btnNuevo.setBorderPainted(false);
        btnNuevo.setContentAreaFilled(false);
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.setFocusPainted(false);
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setIconTextGap(-2);
        btnNuevo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/btnLNuevoDocRellover.png"))); // NOI18N
        btnNuevo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        pnlCategorias.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 60, 40));

        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/btnLGuardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(null);
        btnGuardar.setBorderPainted(false);
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.setFocusPainted(false);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setIconTextGap(-2);
        btnGuardar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/btnLGuardarRellover.png"))); // NOI18N
        btnGuardar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        pnlCategorias.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 360, 70, 40));

        btnEditar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/btnLEditarDoc.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setBorder(null);
        btnEditar.setBorderPainted(false);
        btnEditar.setContentAreaFilled(false);
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.setFocusPainted(false);
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditar.setIconTextGap(-2);
        btnEditar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/btnLEditarDocRellover.png"))); // NOI18N
        btnEditar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        pnlCategorias.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, 60, 40));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/btnVolver.png"))); // NOI18N
        btnCancelar.setText("Volver");
        btnCancelar.setBorder(null);
        btnCancelar.setBorderPainted(false);
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setFocusPainted(false);
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setIconTextGap(-2);
        btnCancelar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/btnVolverRellover.png"))); // NOI18N
        btnCancelar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        pnlCategorias.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, 60, 40));

        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/btnLEliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(null);
        btnEliminar.setBorderPainted(false);
        btnEliminar.setContentAreaFilled(false);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setFocusPainted(false);
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setIconTextGap(-2);
        btnEliminar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/btnLEliminarRellover.png"))); // NOI18N
        btnEliminar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        pnlCategorias.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 360, 60, 40));

        pnlCurvas.add(pnlCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 280, 180));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/ButtonEditNormal.png"))); // NOI18N
        jButton1.setText("Categorias");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setIconTextGap(-25);
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/ButtonEditPressed.png"))); // NOI18N
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/ButtonEditRellover.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pnlCurvas.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, -1, -1));

        pnlDatosPersonales1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2), "Datos de competencia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlDatosPersonales1.setTran(0.0F);
        pnlDatosPersonales1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scrollFederativa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        listFederativa.setBackground(new java.awt.Color(255, 255, 102));
        listFederativa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        listFederativa.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listFederativa.setLayoutOrientation(javax.swing.JList.VERTICAL_WRAP);
        listFederativa.setSelectedIndex(0);
        listFederativa.setSelectionBackground(new java.awt.Color(255, 255, 102));
        listFederativa.setVisibleRowCount(0);
        listFederativa.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listFederativaValueChanged(evt);
            }
        });
        scrollFederativa.setViewportView(listFederativa);

        pnlDatosPersonales1.add(scrollFederativa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 150, 130));

        btnEliminar1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEliminar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/btnLEliminar.png"))); // NOI18N
        btnEliminar1.setBorder(null);
        btnEliminar1.setBorderPainted(false);
        btnEliminar1.setContentAreaFilled(false);
        btnEliminar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar1.setFocusPainted(false);
        btnEliminar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar1.setIconTextGap(-2);
        btnEliminar1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/btnLEliminarRellover.png"))); // NOI18N
        btnEliminar1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnEliminar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar1ActionPerformed(evt);
            }
        });
        pnlDatosPersonales1.add(btnEliminar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 30, 30));

        btnNuevo1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNuevo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/btnLNuevoDoc.png"))); // NOI18N
        btnNuevo1.setBorder(null);
        btnNuevo1.setBorderPainted(false);
        btnNuevo1.setContentAreaFilled(false);
        btnNuevo1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo1.setFocusPainted(false);
        btnNuevo1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo1.setIconTextGap(-2);
        btnNuevo1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/btnLNuevoDocRellover.png"))); // NOI18N
        btnNuevo1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnNuevo1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo1ActionPerformed(evt);
            }
        });
        pnlDatosPersonales1.add(btnNuevo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 30, 30));

        CATEGORIA.setForeground(new java.awt.Color(0, 0, 0));
        CATEGORIA.setText("Federativas");
        CATEGORIA.setColorDeSombra(new java.awt.Color(255, 255, 51));
        CATEGORIA.setDistanciaDeSombra(1);
        pnlDatosPersonales1.add(CATEGORIA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 20));

        txtFederativa.setBackground(new java.awt.Color(255, 255, 102));
        txtFederativa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 102), 3));
        txtFederativa.setAnchoDeBorde(4.0F);
        txtFederativa.setColorDeBorde(new java.awt.Color(0, 0, 0));
        txtFederativa.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txtFederativa.setDragEnabled(true);
        txtFederativa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlDatosPersonales1.add(txtFederativa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 150, 30));

        CATEGORIA1.setForeground(new java.awt.Color(0, 0, 0));
        CATEGORIA1.setText("No federativas");
        CATEGORIA1.setColorDeSombra(new java.awt.Color(255, 255, 51));
        CATEGORIA1.setDistanciaDeSombra(1);
        pnlDatosPersonales1.add(CATEGORIA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, -1, 20));

        scrollNoFederativa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        listNoFederativa.setBackground(new java.awt.Color(255, 255, 102));
        listNoFederativa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        listNoFederativa.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listNoFederativa.setLayoutOrientation(javax.swing.JList.VERTICAL_WRAP);
        listNoFederativa.setSelectedIndex(0);
        listNoFederativa.setSelectionBackground(new java.awt.Color(255, 255, 102));
        listNoFederativa.setVisibleRowCount(0);
        listNoFederativa.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listNoFederativaValueChanged(evt);
            }
        });
        scrollNoFederativa.setViewportView(listNoFederativa);

        pnlDatosPersonales1.add(scrollNoFederativa, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 150, 130));

        txtNoFederativa.setBackground(new java.awt.Color(255, 255, 102));
        txtNoFederativa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 102), 3));
        txtNoFederativa.setAnchoDeBorde(4.0F);
        txtNoFederativa.setColorDeBorde(new java.awt.Color(0, 0, 0));
        txtNoFederativa.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txtNoFederativa.setDragEnabled(true);
        txtNoFederativa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlDatosPersonales1.add(txtNoFederativa, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 150, 30));

        btnNuevo2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNuevo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/btnLNuevoDoc.png"))); // NOI18N
        btnNuevo2.setBorder(null);
        btnNuevo2.setBorderPainted(false);
        btnNuevo2.setContentAreaFilled(false);
        btnNuevo2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo2.setFocusPainted(false);
        btnNuevo2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo2.setIconTextGap(-2);
        btnNuevo2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/btnLNuevoDocRellover.png"))); // NOI18N
        btnNuevo2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnNuevo2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo2ActionPerformed(evt);
            }
        });
        pnlDatosPersonales1.add(btnNuevo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 30, 30));

        btnEliminar2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEliminar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/btnLEliminar.png"))); // NOI18N
        btnEliminar2.setBorder(null);
        btnEliminar2.setBorderPainted(false);
        btnEliminar2.setContentAreaFilled(false);
        btnEliminar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar2.setFocusPainted(false);
        btnEliminar2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar2.setIconTextGap(-2);
        btnEliminar2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/btnLEliminarRellover.png"))); // NOI18N
        btnEliminar2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnEliminar2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar2ActionPerformed(evt);
            }
        });
        pnlDatosPersonales1.add(btnEliminar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 30, 30));

        pnlCurvas.add(pnlDatosPersonales1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 410, 230));

        panelTranslucido1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2), "Costos - Sakura", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), java.awt.Color.white)); // NOI18N
        panelTranslucido1.setTran(0.0F);
        panelTranslucido1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CATEGORIA2.setForeground(new java.awt.Color(0, 0, 0));
        CATEGORIA2.setText("Costo inscripción");
        CATEGORIA2.setColorDeSombra(new java.awt.Color(255, 255, 51));
        CATEGORIA2.setDistanciaDeSombra(1);
        panelTranslucido1.add(CATEGORIA2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, 20));

        txtCostoInscripcion.setBackground(new java.awt.Color(255, 255, 102));
        txtCostoInscripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 102), 3));
        txtCostoInscripcion.setAnchoDeBorde(4.0F);
        txtCostoInscripcion.setColorDeBorde(new java.awt.Color(0, 0, 0));
        txtCostoInscripcion.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txtCostoInscripcion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        panelTranslucido1.add(txtCostoInscripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 150, 30));

        CATEGORIA3.setForeground(new java.awt.Color(0, 0, 0));
        CATEGORIA3.setText("Costo membresia");
        CATEGORIA3.setColorDeSombra(new java.awt.Color(255, 255, 51));
        CATEGORIA3.setDistanciaDeSombra(1);
        panelTranslucido1.add(CATEGORIA3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, 20));

        txtCostoMembresia.setBackground(new java.awt.Color(255, 255, 102));
        txtCostoMembresia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 102), 3));
        txtCostoMembresia.setAnchoDeBorde(4.0F);
        txtCostoMembresia.setColorDeBorde(new java.awt.Color(0, 0, 0));
        txtCostoMembresia.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txtCostoMembresia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        panelTranslucido1.add(txtCostoMembresia, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 150, 30));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/btnLGuardar.png"))); // NOI18N
        jButton2.setText("Guardar");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusPainted(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setIconTextGap(-2);
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/btnLGuardarRellover.png"))); // NOI18N
        jButton2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panelTranslucido1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, -1, -1));

        pnlCurvas.add(panelTranslucido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, 260, 230));

        pnlFondo.add(pnlCurvas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 480));

        progressbarBarra.setBackground(new java.awt.Color(0, 204, 255));
        progressbarBarra.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        progressbarBarra.setForeground(new java.awt.Color(255, 255, 0));
        progressbarBarra.setToolTipText("");
        progressbarBarra.setBorde(5.0F);
        progressbarBarra.setBorderPainted(false);
        progressbarBarra.setColorDeBorde(new java.awt.Color(0, 0, 0));
        progressbarBarra.setDistanciaDeSombra(5);
        progressbarBarra.setFont(new java.awt.Font("SunnySide", 1, 36)); // NOI18N
        progressbarBarra.setString("Configuraciones");
        progressbarBarra.setStringPainted(true);
        pnlFondo.add(progressbarBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 450, 60));

        getContentPane().add(pnlFondo, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        InsertarCategorias();
        v(1,pnlCategorias);
        JOptionPane.showInternalMessageDialog(pnlFondo, pnlCategorias,"Categorias",JOptionPane.PLAIN_MESSAGE);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void listCategoriasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listCategoriasValueChanged

        e(1,btnEditar);
        e(1,btnEliminar);

        getMetadatosCategoria(listCategorias.getSelectedValue());

    }//GEN-LAST:event_listCategoriasValueChanged

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        HabilitarDatosCategoria();

        e(0,btnEditar);
        e(0,btnNuevo);
        e(1,btnGuardar);
        e(1,btnCancelar);
        
        this.listCategorias.setEnabled(false);
        
        this.GuardarEsGuardarCambiosCategorias = true;

    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        
        listCategorias.clearSelection();
        
        HabilitarDatosCategoria();
        LimpiarCajas();

        e(0,btnNuevo);
        e(0,listCategorias);
        e(0,btnEliminar);
        e(0,btnEditar);
        e(1,btnGuardar);
        e(1,btnCancelar);
        
        this.listCategorias.setSelectedIndex(-1);
        
        this.GuardarEsGuardarCambiosCategorias = false;

    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        if(GuardarEsGuardarCambiosCategorias == false){
            
            if(!txtNombreCategoria.getText().isEmpty() && !txtMensualidad.getText().isEmpty() && !txtInscripcion.getText().isEmpty()){

                try{
                    connection = Conectar.getConnection();
                    preparedStatement=connection.prepareStatement("INSERT INTO configcategoria(categoria,inscripcion,mensualidad,instructor,dias,hora1,ampm1,hora2,ampm2)VALUES(?,?,?,?,?,?,?,?,?)");
                    preparedStatement.setString(1,this.txtNombreCategoria.getText());
                    preparedStatement.setString(2,this.txtInscripcion.getText());
                    preparedStatement.setString(3,this.txtMensualidad.getText());
                    preparedStatement.setString(4,this.txtInstructor.getText());
                    preparedStatement.setString(6,this.txtHora1.getText());
                    preparedStatement.setString(7,this.cbAMPM1.getSelectedItem().toString());
                    preparedStatement.setString(8,this.txtHora2.getText());
                    preparedStatement.setString(9,this.cbAMPM2.getSelectedItem().toString());
                    
                    String dias="";
                    
                    if(domingo.isSelected()==true){
                        dias = "-do";
                    }
                    if(lunes.isSelected()==true){
                        dias +="-lu";
                    }
                    if(martes.isSelected()==true){
                        dias +="-ma";
                    }
                    if(miercoles.isSelected()==true){
                        dias +="-mi";
                    }
                    if(jueves.isSelected()==true){
                        dias +="-ju";
                    }
                    if(viernes.isSelected()==true){
                        dias +="-vi";
                    }
                    if(sabado.isSelected()==true){
                        dias +="-sa";
                    }
                    
                    preparedStatement.setString(5,dias);

                    int res = preparedStatement.executeUpdate();

                    if (res > 0) {
                        //timer.start();

                        JOptionPane.showInternalMessageDialog(pnlFondo, "Registrado con éxito","Aviso",JOptionPane.INFORMATION_MESSAGE);

                        InsertarCategorias();
                        LimpiarCajas();
                        InhabilitarDatosCategoria();

                        e(0,btnGuardar);
                        e(0,btnEditar);
                        e(0,btnCancelar);
                        e(1,btnNuevo);
                        v(1,listCategorias);

                    }else{
                        JOptionPane.showInternalMessageDialog(pnlFondo, "Error al registrar","Aviso",JOptionPane.WARNING_MESSAGE);
                        
                        LimpiarCajas();
                        InhabilitarDatosCategoria();
                        
                        e(0,btnGuardar);
                        e(0,btnEditar);
                        e(1,btnNuevo);
                    }
                    
                    connection.close();

                }catch(SQLException ex){ JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(),"Aviso",JOptionPane.ERROR_MESSAGE); }

            }else{ JOptionPane.showInternalMessageDialog(pnlFondo, "Hay campos vacios","Aviso",JOptionPane.ERROR_MESSAGE); }
        }
        
        if(GuardarEsGuardarCambiosCategorias == true){
            
            if(!txtNombreCategoria.getText().isEmpty() && !txtMensualidad.getText().isEmpty() && !txtInscripcion.getText().isEmpty()){
                
                String dias="";
                    
                    if(domingo.isSelected()==true){
                        dias = "-do";
                    }
                    if(lunes.isSelected()==true){
                        dias +="-lu";
                    }
                    if(martes.isSelected()==true){
                        dias +="-ma";
                    }
                    if(miercoles.isSelected()==true){
                        dias +="-mi";
                    }
                    if(jueves.isSelected()==true){
                        dias +="-ju";
                    }
                    if(viernes.isSelected()==true){
                        dias +="-vi";
                    }
                    if(sabado.isSelected()==true){
                        dias +="-sa";
                    }
            
                try{
                    connection = Conectar.getConnection();
                    preparedStatement = connection.prepareStatement("UPDATE configcategoria SET categoria='"+this.txtNombreCategoria.getText()+"',inscripcion='"+this.txtInscripcion.getText()
                    +"',mensualidad='"+this.txtMensualidad.getText()+"',instructor='"+this.txtInstructor.getText()+"',dias='"+dias+"',hora1='"+this.txtHora1.getText()+"'"
                    + ",ampm1='"+cbAMPM1.getSelectedItem().toString()+"',hora2='"+this.txtHora2.getText()+"',ampm2='"+cbAMPM2.getSelectedItem().toString()+"' WHERE id='"+this.idCategoria+"'");

                    int res = preparedStatement.executeUpdate();

                    if(res>0){
                        //timer.start();

                        JOptionPane.showInternalMessageDialog(pnlFondo, "Modificado con éxito","Aviso",JOptionPane.INFORMATION_MESSAGE);
                        
                        InsertarCategorias();
                        LimpiarCajas();
                        InhabilitarDatosCategoria();

                        e(0,btnGuardar);
                        e(0,btnCancelar);
                        e(0,btnEditar);
                        e(0,btnEliminar);
                        e(1,btnNuevo);
                        
                        this.listCategorias.setEnabled(true);

                }else{
                    JOptionPane.showInternalMessageDialog(pnlFondo, "Error al modificar","Aviso",JOptionPane.ERROR_MESSAGE);
                    InhabilitarDatosCategoria();
                    
                    e(0,btnGuardar);
                    e(0,btnCancelar);
                    e(0,btnEditar);
                    e(1,btnNuevo);

                }
                    
            connection.close();

        }catch(SQLException ex){  JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(),"Aviso",JOptionPane.WARNING_MESSAGE); }
            
        }else{ JOptionPane.showInternalMessageDialog(pnlFondo, "Hay campos vacios","Aviso",JOptionPane.ERROR_MESSAGE); }  
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        this.listCategorias.clearSelection();
        
        InhabilitarDatosCategoria();
        LimpiarCajas();

        e(0,btnEliminar);
        e(0,btnEditar);
        e(0,btnGuardar);
        e(0,btnCancelar);
        e(1,btnNuevo);
        e(1,listCategorias);
        v(1,pnlDatosCategorias);
        v(1,pnlListaCategorias);
        
        this.listCategorias.setSelectedIndex(-1);
        
        this.GuardarEsGuardarCambiosCategorias = false;

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        if(idCategoria != -1){
            
            int confirmar =JOptionPane.showConfirmDialog(pnlFondo,"¿Desea eliminar la categoria "+txtNombreCategoria.getText()+"? Se borraran también los estados.");

            if(JOptionPane.OK_OPTION == confirmar){
                //timer.start();

                try {
                    connection = Conectar.getConnection();
                    preparedStatement = connection.prepareStatement("DELETE FROM configcategoria WHERE id=?");
                    preparedStatement.setString(1, String.valueOf(idCategoria));
                    int res = preparedStatement.executeUpdate();
                    
                    if (res > 0) {
                        
                        PreparedStatement ps = connection.prepareStatement("DELETE FROM estadoinscripcioncategoria WHERE categoria = '"+txtNombreCategoria.getText()+"'");
                        int res1 = ps.executeUpdate();

                        if (res1 > 0) {
                        
                        }
                        
                        PreparedStatement ps1 = connection.prepareStatement("DELETE FROM estadomembresiacategoria WHERE categoria = '"+txtNombreCategoria.getText()+"'");
                        int res2 = ps1.executeUpdate();

                        if (res2 > 0) {
                        
                        }

                        JOptionPane.showMessageDialog(pnlFondo, "Categoria "+txtNombreCategoria.getText()+" eliminada. Datos de estados eliminados.","AVISO",JOptionPane.INFORMATION_MESSAGE);

                        InsertarCategorias();
                        this.listCategorias.setSelectedIndex(-1);
                        this.listCategorias.setEnabled(true);
                        LimpiarCajas();
                        InhabilitarDatosCategoria();
                        
                        
                    }else{
                        JOptionPane.showMessageDialog(pnlFondo, "Error al eliminar", "ERROR", JOptionPane.ERROR_MESSAGE);
                        LimpiarCajas();
                    }

                    connection.close();

                }catch(SQLException ex){ JOptionPane.showMessageDialog(pnlFondo, "Error: "+ex.getMessage(),"ERROR", JOptionPane.WARNING_MESSAGE); }
            }
        }else{ JOptionPane.showMessageDialog(pnlFondo,"Debe seleccionar una categoria");
        
    }
        
        e(0,btnEditar);
        e(0,btnEliminar);
        e(0,btnGuardar);
        e(0,btnCancelar);
        e(1,btnNuevo);
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void listFederativaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listFederativaValueChanged

    }//GEN-LAST:event_listFederativaValueChanged

    private void btnEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar1ActionPerformed

        if(listFederativa.getSelectedIndex() != -1){
            
            int confirmar =JOptionPane.showConfirmDialog(pnlFondo,"¿Desea eliminar el tipo de competencia "+listFederativa.getSelectedValue()+"?");

            if(JOptionPane.OK_OPTION == confirmar){
                //timer.start();

                try {
                    connection = Conectar.getConnection();
                    preparedStatement = connection.prepareStatement("DELETE FROM configcompetencia WHERE tipofederacion=?");
                    preparedStatement.setString(1, String.valueOf(listFederativa.getSelectedValue()));
                    int res = preparedStatement.executeUpdate();
                    
                    if (res > 0) {
                        JOptionPane.showMessageDialog(pnlFondo, "Tipo de competencia "+listFederativa.getSelectedValue()+" eliminada");

                        InsertarFederativas();
                        this.listFederativa.setSelectedIndex(-1);

                    }else{
                        JOptionPane.showMessageDialog(pnlFondo, "Error al eliminar");
                    }

                    connection.close();

                }catch(SQLException ex){ JOptionPane.showMessageDialog(pnlFondo, "Error: "+ex.getMessage()); }
            }
        }else{ JOptionPane.showMessageDialog(pnlFondo,"Debe seleccionar un tipo de competencia federativa");
        
    }
        
    }//GEN-LAST:event_btnEliminar1ActionPerformed

    private void btnNuevo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo1ActionPerformed

        if(!txtFederativa.getText().isEmpty()){

                try{
                    connection = Conectar.getConnection();
                    preparedStatement=connection.prepareStatement("INSERT INTO configcompetencia(tipofederacion,tipo)VALUES(?,?)");
                    preparedStatement.setString(1,this.txtFederativa.getText());
                    preparedStatement.setString(2,"federativa");

                    int res = preparedStatement.executeUpdate();

                    if (res > 0){
                        //timer.start();

                        JOptionPane.showInternalMessageDialog(pnlFondo, "Agregado exitosamente","Aviso",JOptionPane.INFORMATION_MESSAGE);

                        InsertarFederativas();
                        txtFederativa.setText("");

                    }else{ JOptionPane.showInternalMessageDialog(pnlFondo, "Error al registrar","Aviso",JOptionPane.WARNING_MESSAGE); }
                    
                    connection.close();

                }catch(SQLException ex){ JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(),"Aviso",JOptionPane.ERROR_MESSAGE); }

            }else{ JOptionPane.showInternalMessageDialog(pnlFondo, "El campo está vacio","Aviso",JOptionPane.ERROR_MESSAGE); }

    }//GEN-LAST:event_btnNuevo1ActionPerformed

    private void listNoFederativaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listNoFederativaValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_listNoFederativaValueChanged

    private void btnNuevo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo2ActionPerformed
        
        if(!txtNoFederativa.getText().isEmpty()){

                try{
                    connection = Conectar.getConnection();
                    preparedStatement=connection.prepareStatement("INSERT INTO configcompetencia(tipofederacion,tipo)VALUES(?,?)");
                    preparedStatement.setString(1,this.txtNoFederativa.getText());
                    preparedStatement.setString(2,"nofederativa");

                    int res = preparedStatement.executeUpdate();

                    if (res > 0){
                        //timer.start();

                        JOptionPane.showInternalMessageDialog(pnlFondo, "Agregado exitosamente","Aviso",JOptionPane.INFORMATION_MESSAGE);

                        InsertarNoFederativas();
                        txtNoFederativa.setText("");

                    }else{ JOptionPane.showInternalMessageDialog(pnlFondo, "Error al registrar","Aviso",JOptionPane.WARNING_MESSAGE); }
                    
                    connection.close();

                }catch(SQLException ex){ JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(),"Aviso",JOptionPane.ERROR_MESSAGE); }

            }else{ JOptionPane.showInternalMessageDialog(pnlFondo, "El campo está vacio","Aviso",JOptionPane.ERROR_MESSAGE); }
        
    }//GEN-LAST:event_btnNuevo2ActionPerformed

    private void btnEliminar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar2ActionPerformed
        
        if(listNoFederativa.getSelectedIndex() != -1){
            
            int confirmar =JOptionPane.showConfirmDialog(pnlFondo,"¿Desea eliminar el tipo de competencia "+listFederativa.getSelectedValue()+"?");

            if(JOptionPane.OK_OPTION == confirmar){
                //timer.start();

                try {
                    connection = Conectar.getConnection();
                    preparedStatement = connection.prepareStatement("DELETE FROM configcompetencia WHERE tipofederacion=?");
                    preparedStatement.setString(1, String.valueOf(listNoFederativa.getSelectedValue()));
                    int res = preparedStatement.executeUpdate();
                    
                    if (res > 0) {
                        JOptionPane.showMessageDialog(pnlFondo, "Tipo de competencia "+listNoFederativa.getSelectedValue()+" eliminada");

                        InsertarNoFederativas();
                        this.listNoFederativa.setSelectedIndex(-1);

                    }else{
                        JOptionPane.showMessageDialog(pnlFondo, "Error al eliminar");
                    }

                    connection.close();

                }catch(SQLException ex){ JOptionPane.showMessageDialog(pnlFondo, "Error: "+ex.getMessage(), "ERROR", JOptionPane.WARNING_MESSAGE); }
            }
        }else{ JOptionPane.showMessageDialog(pnlFondo,"Debe seleccionar un tipo de competencia no federativa");
        
    }
        
    }//GEN-LAST:event_btnEliminar2ActionPerformed

    private void lunesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lunesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lunesActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        try{
            connection = Conectar.getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO configsakura(inscripcion,membresia)VALUES(?,?)");
            ps.setFloat(1,!txtCostoInscripcion.getText().equals("")?Float.parseFloat(txtCostoInscripcion.getText()):0);
            ps.setFloat(2,!txtCostoMembresia.getText().equals("")?Float.parseFloat(txtCostoMembresia.getText()):0);
            int res = ps.executeUpdate();

            if (res > 0){
                InsertarCostosSakura();
                
                PreparedStatement ps1 = connection.prepareStatement("TRUNCATE configsakura");
                int res1 = ps1.executeUpdate();
                
                if(res > 0){   
                }
                
                PreparedStatement ps2 = connection.prepareStatement("INSERT INTO configsakura(inscripcion,membresia)VALUES(?,?)");
                ps2.setFloat(1,!txtCostoInscripcion.getText().equals("")?Float.parseFloat(txtCostoInscripcion.getText()):0);
                ps2.setFloat(2,!txtCostoMembresia.getText().equals("")?Float.parseFloat(txtCostoMembresia.getText()):0);
                int res2 = ps2.executeUpdate();

                if (res > 0){
                    InsertarCostosSakura();
                }else{}
                
            }else{ JOptionPane.showInternalMessageDialog(pnlFondo, "Error al registrar","Aviso",JOptionPane.WARNING_MESSAGE); }
            
        }catch(SQLException ex){ JOptionPane.showMessageDialog(pnlFondo, "Error: "+ex.getMessage(), "ERROR", JOptionPane.WARNING_MESSAGE); }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbAMPM1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbAMPM1ItemStateChanged

    }//GEN-LAST:event_cbAMPM1ItemStateChanged

    private void cbAMPM2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbAMPM2ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAMPM2ItemStateChanged

    private void HabilitarDatosCategoria(){

        e(1,txtNombreCategoria);
        e(1,txtMensualidad);
        e(1,txtInscripcion);
        e(1,txtInstructor);
        e(1,txtHora1);
        e(1,txtHora2);
        e(1,cbAMPM1);
        e(1,cbAMPM2);
        e(1,domingo);
        e(1,lunes);
        e(1,martes);
        e(1,miercoles);
        e(1,jueves);
        e(1,viernes);
        e(1,sabado);
        
        this.txtNombreCategoria.setEditable(true);
        this.txtMensualidad.setEditable(true);
        this.txtInscripcion.setEditable(true);
        this.txtInstructor.setEditable(true);
        this.txtHora1.setEditable(true);
        this.txtHora2.setEditable(true);
        this.cbAMPM1.setSelectedItem("AM");
        this.cbAMPM2.setSelectedItem("AM");
        
        this.txtNombreCategoria.setBackground(amar);
        this.txtMensualidad.setBackground(amar);
        this.txtInscripcion.setBackground(amar);
        this.txtInstructor.setBackground(amar);
        this.txtHora1.setBackground(amar);
        this.txtHora2.setBackground(amar);
        this.cbAMPM1.setBackground(amar);
        this.cbAMPM2.setBackground(amar);
        
        //LABEL'S
        this.NOMBRECATEGORIA.setColorDeSombra(azul);
        this.MENSUALIDAD.setColorDeSombra(azul);
        this.INSCRIPCION.setColorDeSombra(azul);
        this.INSTRUCTOR.setColorDeSombra(azul);
        this.HORARIO.setColorDeSombra(azul);
        //

        this.txtNombreCategoria.setColorDeBorde(new java.awt.Color(0,0,0));
        this.txtMensualidad.setColorDeBorde(new java.awt.Color(0,0,0));
        this.txtInscripcion.setColorDeBorde(new java.awt.Color(0,0,0));
        this.txtInstructor.setColorDeBorde(new java.awt.Color(0,0,0));
        this.txtHora1.setColorDeBorde(new java.awt.Color(0,0,0));
        this.txtHora2.setColorDeBorde(new java.awt.Color(0,0,0));
        this.cbAMPM1.setColorDeBorde(new java.awt.Color(0,0,0));
        this.cbAMPM2.setColorDeBorde(new java.awt.Color(0,0,0));
        
    }
    
    private void InhabilitarDatosCategoria(){

        e(0,txtNombreCategoria);
        e(0,txtMensualidad);
        e(0,txtInscripcion);
        e(0,txtInstructor);
        e(0,txtHora1);
        e(0,txtHora2);
        e(0,cbAMPM1);
        e(0,cbAMPM2);
        e(0,domingo);
        e(0,lunes);
        e(0,martes);
        e(0,miercoles);
        e(0,jueves);
        e(0,viernes);
        e(0,sabado);
        
        this.txtNombreCategoria.setEditable(false);
        this.txtMensualidad.setEditable(false);
        this.txtInscripcion.setEditable(false);
        this.txtInstructor.setEditable(false);
        this.txtHora1.setEditable(false);
        this.txtHora2.setEditable(false);
        this.cbAMPM1.setSelectedItem("AM");
        this.cbAMPM2.setSelectedItem("AM");

        this.txtNombreCategoria.setBackground(azul);
        this.txtMensualidad.setBackground(azul);
        this.txtInscripcion.setBackground(azul);
        this.txtInstructor.setBackground(azul);
        this.txtHora1.setBackground(azul);
        this.txtHora2.setBackground(azul);
        this.cbAMPM1.setBackground(azul);
        this.cbAMPM2.setBackground(azul);
        
        //LABEL'S
        this.NOMBRECATEGORIA.setColorDeSombra(amar);
        this.MENSUALIDAD.setColorDeSombra(amar);
        this.INSCRIPCION.setColorDeSombra(amar);
        this.INSTRUCTOR.setColorDeSombra(amar);
        this.HORARIO.setColorDeSombra(amar);
        //

        this.txtNombreCategoria.setColorDeBorde(new java.awt.Color(255,255,102));
        this.txtMensualidad.setColorDeBorde(new java.awt.Color(255,255,102));
        this.txtInscripcion.setColorDeBorde(new java.awt.Color(255,255,102));
        this.txtInstructor.setColorDeBorde(new java.awt.Color(255,255,102));
        this.txtHora1.setColorDeBorde(new java.awt.Color(255,255,102));
        this.txtHora2.setColorDeBorde(new java.awt.Color(255,255,102));
        this.cbAMPM1.setColorDeBorde(new java.awt.Color(255,255,102));
        this.cbAMPM2.setColorDeBorde(new java.awt.Color(255,255,102));

    }
    
    private void InsertarCategorias(){

        try{
            String cate[] = new String[cg.getCategorias().size()];
            
            for(int i=0; i < cg.getCategorias().size(); i++){
                cate[i] = cg.getCategorias().get(i).toString();
            }
            
            this.listCategorias.setListData(cate);
            this.listCategorias.setSelectedIndex(-1);
        
        }catch(Exception ex){ JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(),"Aviso",JOptionPane.WARNING_MESSAGE); }
        
    }
    
    private void InsertarMembresias(){

        try{
            String cate[] = new String[cg.getCategorias().size()];
            
            for(int i=0; i < cg.getCategorias().size(); i++){
                cate[i] = cg.getCategorias().get(i).toString();
            }
            
            this.listCategorias.setListData(cate);
            this.listCategorias.setSelectedIndex(-1);
        
        }catch(Exception ex){ JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(),"Aviso",JOptionPane.WARNING_MESSAGE); }
        
    }
    
    private void getMetadatosCategoria(String categoria){
        
        LimpiarCajas();
        
        this.cg.getMetadatosCategoria(categoria);
        this.txtNombreCategoria.setText(cg.getCategoria());
        this.txtInscripcion.setText(cg.getInscripcion());
        this.txtMensualidad.setText(cg.getMensualidad());
        this.txtInstructor.setText(cg.getInstructor());
        this.idCategoria = Integer.parseInt(cg.getId());
        this.txtHora1.setText(cg.getHora1());
        this.txtHora2.setText(cg.getHora2());
        this.cbAMPM1.setSelectedItem(cg.getAmpm1());
        this.cbAMPM2.setSelectedItem(cg.getAmpm2());
        
        for(int i=0; i<cg.getDias().length(); i++){
            
            if(cg.getDias().contains("do")){
                domingo.setSelected(true);
            }
            if(cg.getDias().contains("lu")){
                lunes.setSelected(true);
            }
            if(cg.getDias().contains("ma")){
                martes.setSelected(true);
            }
            if(cg.getDias().contains("mi")){
                miercoles.setSelected(true);
            }
            if(cg.getDias().contains("ju")){
                jueves.setSelected(true);
            }
            if(cg.getDias().contains("vi")){
                viernes.setSelected(true);
            }
            if(cg.getDias().contains("sa")){
                sabado.setSelected(true);
            }
            
        }
       
    }
    
    private void LimpiarCajas(){

            this.txtNombreCategoria.setText(null);
            this.txtMensualidad.setText(null);
            this.txtInscripcion.setText(null);
            this.txtInstructor.setText(null);
            this.txtHora1.setText(null);
            this.txtHora2.setText(null);
            this.cbAMPM1.setSelectedItem("AM");
            this.cbAMPM2.setSelectedItem("AM");
            domingo.setSelected(false);
            lunes.setSelected(false);
            martes.setSelected(false);
            miercoles.setSelected(false);
            jueves.setSelected(false);
            viernes.setSelected(false);
            sabado.setSelected(false);

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
    
    private void InsertarFederativas(){
        
        try{
            String fede[] = new String[cg.getFederativas().size()];
            
            for(int i=0; i < cg.getFederativas().size(); i++){
                fede[i] = cg.getFederativas().get(i).toString();
            }
            
            this.listFederativa.setListData(fede);
            this.listFederativa.setSelectedIndex(-1);
        
        }catch(Exception ex){ JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(),"Aviso",JOptionPane.WARNING_MESSAGE); }
        
    }
        
    private void InsertarNoFederativas(){
        
        try{
            String nofede[] = new String[cg.getNoFederativas().size()];
            
            for(int i=0; i < cg.getNoFederativas().size(); i++){
                nofede[i] = cg.getNoFederativas().get(i).toString();
            }
            
            this.listNoFederativa.setListData(nofede);
            this.listNoFederativa.setSelectedIndex(-1);
        
        }catch(Exception ex){ JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(),"Aviso",JOptionPane.WARNING_MESSAGE); }
        
    }
    
    private void InsertarCostosSakura(){
        
        txtCostoInscripcion.setText(String.valueOf(cg.getCostoSakura("inscripcion")));
        txtCostoMembresia.setText(String.valueOf(cg.getCostoSakura("membresia")));

    }
    
    public void setFiltroTexto(){
        
        Helper.setFiltraEntrada(txtInscripcion.getDocument(), FiltraEntrada.SOLO_NUMEROS, 10, false);
        Helper.setFiltraEntrada(txtMensualidad.getDocument(), FiltraEntrada.SOLO_NUMEROS, 10, false);
        Helper.setFiltraEntrada(txtInstructor.getDocument(), FiltraEntrada.SOLO_LETRAS, 30, true);
        Helper.setFiltraEntrada(txtCostoInscripcion.getDocument(), FiltraEntrada.SOLO_NUMEROS, 10, false);
        Helper.setFiltraEntrada(txtCostoMembresia.getDocument(), FiltraEntrada.SOLO_NUMEROS, 10, false);
        Helper.setFiltraEntrada(txtHora1.getDocument(), FiltraEntrada.SOLO_NUMEROS, 2, false);
        Helper.setFiltraEntrada(txtHora2.getDocument(), FiltraEntrada.SOLO_NUMEROS, 2, false);

    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private elaprendiz.gui.label.LabelMetric CATEGORIA;
    private elaprendiz.gui.label.LabelMetric CATEGORIA1;
    private elaprendiz.gui.label.LabelMetric CATEGORIA2;
    private elaprendiz.gui.label.LabelMetric CATEGORIA3;
    private elaprendiz.gui.label.LabelMetric DIASDESEMANA;
    private elaprendiz.gui.label.LabelMetric HORARIO;
    private elaprendiz.gui.label.LabelMetric INSCRIPCION;
    private elaprendiz.gui.label.LabelMetric INSTRUCTOR;
    private elaprendiz.gui.label.LabelMetric MENSUALIDAD;
    private elaprendiz.gui.label.LabelMetric NOMBRECATEGORIA;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminar1;
    private javax.swing.JButton btnEliminar2;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnNuevo1;
    private javax.swing.JButton btnNuevo2;
    private elaprendiz.gui.comboBox.ComboBoxRectIcon cbAMPM1;
    private elaprendiz.gui.comboBox.ComboBoxRectIcon cbAMPM2;
    private javax.swing.JCheckBox domingo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JCheckBox jueves;
    private javax.swing.JList<String> listCategorias;
    private javax.swing.JList<String> listFederativa;
    private javax.swing.JList<String> listNoFederativa;
    private javax.swing.JCheckBox lunes;
    private javax.swing.JCheckBox martes;
    private javax.swing.JCheckBox miercoles;
    private elaprendiz.gui.panel.PanelTranslucido panelTranslucido1;
    private elaprendiz.gui.panel.PanelImage pnlCategorias;
    private elaprendiz.gui.panel.PanelCurves pnlCurvas;
    private elaprendiz.gui.panel.PanelImage pnlDatosCategorias;
    private elaprendiz.gui.panel.PanelTranslucido pnlDatosPersonales1;
    private elaprendiz.gui.panel.PanelImage pnlFondo;
    private javax.swing.JPanel pnlListaCategorias;
    private elaprendiz.gui.progressBar.ProgressBarRound progressbarBarra;
    private javax.swing.JCheckBox sabado;
    private javax.swing.JScrollPane scrollCategorias;
    private javax.swing.JScrollPane scrollFederativa;
    private javax.swing.JScrollPane scrollNoFederativa;
    private elaprendiz.gui.textField.TextFieldRectIcon txtCostoInscripcion;
    private elaprendiz.gui.textField.TextFieldRectIcon txtCostoMembresia;
    private elaprendiz.gui.textField.TextFieldRectIcon txtFederativa;
    private elaprendiz.gui.textField.TextFieldRectIcon txtHora1;
    private elaprendiz.gui.textField.TextFieldRectIcon txtHora2;
    private elaprendiz.gui.textField.TextFieldRectIcon txtInscripcion;
    private elaprendiz.gui.textField.TextFieldRectIcon txtInstructor;
    private elaprendiz.gui.textField.TextFieldRectIcon txtMensualidad;
    private elaprendiz.gui.textField.TextFieldRectIcon txtNoFederativa;
    private elaprendiz.gui.textField.TextFieldRectIcon txtNombreCategoria;
    private javax.swing.JCheckBox viernes;
    // End of variables declaration//GEN-END:variables
}
