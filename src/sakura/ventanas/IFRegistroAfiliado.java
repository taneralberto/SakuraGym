package sakura.ventanas;

import clases.Config;
import clases.bdd.Conectar;
import clases.util.FiltraEntrada;
import clases.util.Helper;
import clases.util.Thumbnail;
import clases.util.filechooser.DatoArchivo;
import clases.util.filechooser.FiltraExtensionArchivos;
import clases.util.filechooser.PanelVistaPrevia;
import clases.util.filechooser.VistaArchivos;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class IFRegistroAfiliado extends javax.swing.JInternalFrame implements Serializable, Runnable{

    //VARIABLES
    private int cedula = -1;
    private Timer timer;
    private Config cg = new Config();
    private DefaultComboBoxModel mComboBoxBuscar;
    private boolean varActPnlRepresentante = false;
    private Thread h1;
    
    private int cedula1;
    private int cedular;
    private int telefono;
    private int telefonor;
    
    //IMAGEN
    private FileInputStream imagen;
    private DatoArchivo dat;
    private String URLImagen = "";

    //CONEXIONES
    private PreparedStatement preparedStatement;
    private PreparedStatement preparedStatement1;
    private Connection connection;
    private ResultSet resultSet;
    private Statement st;

    //COLORES
    private final static Color azul = new Color(0, 203, 255);
    private final static Color amar = new Color(255, 255, 102);
    
    //TABLA
    private TableRowSorter trsFiltro;
    private DefaultTableModel modelo;
    private String[]datos;

    public IFRegistroAfiliado() {
        
        initComponents();

        h1 = new Thread(this);
        h1.start();
        
        e(0,btnGuardar);
        v(0,btnEditar);
        v(0,btnGuardarCambios);
        v(0,cbBuscadorCategoria);
        v(0,btnFoto);
        v(0,pnlBuscar); 
        v(0,pnlDatosCategoria);

        timer = new Timer(10, new progreso());

        InhabilitarDatosPersonales();
        InhabilitarDatosRepresentante();
        setFiltroTexto();
        
        /**********MOSTRAR COLUMNAS EN LA TABLA**********/
       
        modelo = new DefaultTableModel();
        datos = new String [3];

        modelo.addColumn("NOMBRE");
        modelo.addColumn("APELLIDO");
        modelo.addColumn("Nº CÉDULA");
        
        tblAfiliados.setModel(modelo);
        modelo.fireTableDataChanged();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlFondo = new elaprendiz.gui.panel.PanelImage();
        pnlBuscar = new elaprendiz.gui.panel.PanelImage();
        pnlBuscador = new javax.swing.JPanel();
        txtBuscar = new elaprendiz.gui.textField.TextFieldRectIcon();
        cbBuscar = new elaprendiz.gui.comboBox.ComboBoxRectIcon();
        cbBuscadorCategoria = new elaprendiz.gui.comboBox.ComboBoxRectIcon();
        btnEliminar1 = new javax.swing.JButton();
        pnlTabla = new javax.swing.JPanel();
        scrollTabla = new javax.swing.JScrollPane();
        tblAfiliados = new javax.swing.JTable();
        pnlCurvas = new elaprendiz.gui.panel.PanelCurves();
        pnlDatosPersonales = new elaprendiz.gui.panel.PanelTranslucido();
        CEDULA = new elaprendiz.gui.label.LabelMetric();
        CORREO = new elaprendiz.gui.label.LabelMetric();
        FOTO = new elaprendiz.gui.label.LabelMetric();
        SEXO = new elaprendiz.gui.label.LabelMetric();
        DIRECCION = new elaprendiz.gui.label.LabelMetric();
        TELEFONO = new elaprendiz.gui.label.LabelMetric();
        NOMBRE = new elaprendiz.gui.label.LabelMetric();
        APELLIDO = new elaprendiz.gui.label.LabelMetric();
        EDAD = new elaprendiz.gui.label.LabelMetric();
        pnlFoto = new elaprendiz.gui.panel.PanelTranslucido();
        btnFoto = new elaprendiz.gui.button.ButtonTask();
        pnlImagenFoto = new elaprendiz.gui.panel.PanelImage();
        scrollDireccion = new javax.swing.JScrollPane();
        txtDireccion = new javax.swing.JTextArea();
        txtApellido = new elaprendiz.gui.textField.TextFieldRectIcon();
        txtCedula = new elaprendiz.gui.textField.TextFieldRectIcon();
        txtCorreo = new elaprendiz.gui.textField.TextFieldRectIcon();
        txtTelefono = new elaprendiz.gui.textField.TextFieldRectIcon();
        cbSexo = new elaprendiz.gui.comboBox.ComboBoxRectIcon();
        txtNombre = new elaprendiz.gui.textField.TextFieldRectIcon();
        txtEdad = new elaprendiz.gui.textField.TextFieldRectIcon();
        INCONVENIENTES = new elaprendiz.gui.label.LabelMetric();
        scrollInconvenientes = new javax.swing.JScrollPane();
        txtInconvenientes = new javax.swing.JTextArea();
        MEDIDAS = new elaprendiz.gui.label.LabelMetric();
        scrollMedidas = new javax.swing.JScrollPane();
        txtMedidas = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        pnlDatosRepresentante = new elaprendiz.gui.panel.PanelTranslucido();
        REPRESENTANTE = new elaprendiz.gui.label.LabelMetric();
        cbRepresentante = new elaprendiz.gui.comboBox.ComboBoxRectIcon();
        NOMBRER = new elaprendiz.gui.label.LabelMetric();
        txtNombreR = new elaprendiz.gui.textField.TextFieldRectIcon();
        APELLIDOR = new elaprendiz.gui.label.LabelMetric();
        txtApellidoR = new elaprendiz.gui.textField.TextFieldRectIcon();
        CEDULAR = new elaprendiz.gui.label.LabelMetric();
        txtCedulaR = new elaprendiz.gui.textField.TextFieldRectIcon();
        TELEFONOR = new elaprendiz.gui.label.LabelMetric();
        txtTelefonoR = new elaprendiz.gui.textField.TextFieldRectIcon();
        btnGuardarCambios = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        pnlDatosCategoria = new elaprendiz.gui.panel.PanelImage();
        txtInscripcion = new javax.swing.JTextField();
        txtMensualidad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblNombreCategoria = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        progressbarBarra = new elaprendiz.gui.progressBar.ProgressBarRound();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setTitle("Registro de afiliados");
        setMinimumSize(new java.awt.Dimension(410, 610));

        pnlFondo.setBackground(new java.awt.Color(255, 255, 255));
        pnlFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/fondo-abstracto-celeste_1077-3.jpg"))); // NOI18N
        pnlFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/Fondo-de-pantalla-Abstracto-78.jpg"))); // NOI18N
        pnlBuscar.setLayout(new java.awt.BorderLayout());

        pnlBuscador.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscador", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlBuscador.setOpaque(false);
        pnlBuscador.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlBuscadorMouseDragged(evt);
            }
        });
        pnlBuscador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlBuscadorMousePressed(evt);
            }
        });
        pnlBuscador.setLayout(new java.awt.GridBagLayout());

        txtBuscar.setBackground(new java.awt.Color(255, 255, 102));
        txtBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        txtBuscar.setAnchoDeBorde(3.0F);
        txtBuscar.setColorDeBorde(new java.awt.Color(0, 0, 0));
        txtBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/share.png"))); // NOI18N
        txtBuscar.setPreferredSize(new java.awt.Dimension(250, 25));
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        pnlBuscador.add(txtBuscar, gridBagConstraints);

        cbBuscar.setBackground(new java.awt.Color(255, 255, 102));
        cbBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        cbBuscar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre", "Apellido", "Nº Cédula", "Sexo", "Categoría", "Fechas" }));
        cbBuscar.setAnchoDeBorde(3.0F);
        cbBuscar.setColorDeBorde(new java.awt.Color(0, 0, 0));
        cbBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbBuscar.setPreferredSize(new java.awt.Dimension(130, 25));
        cbBuscar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbBuscarItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        pnlBuscador.add(cbBuscar, gridBagConstraints);

        cbBuscadorCategoria.setBackground(new java.awt.Color(255, 255, 102));
        cbBuscadorCategoria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));
        cbBuscadorCategoria.setAnchoDeBorde(4.0F);
        cbBuscadorCategoria.setColorDeBorde(new java.awt.Color(0, 204, 255));
        cbBuscadorCategoria.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbBuscadorCategoria.setPreferredSize(new java.awt.Dimension(250, 25));
        cbBuscadorCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbBuscadorCategoriaItemStateChanged(evt);
            }
        });
        cbBuscadorCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cbBuscadorCategoriaKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        pnlBuscador.add(cbBuscadorCategoria, gridBagConstraints);

        btnEliminar1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEliminar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/btnEliminar2.png"))); // NOI18N
        btnEliminar1.setBorder(null);
        btnEliminar1.setBorderPainted(false);
        btnEliminar1.setContentAreaFilled(false);
        btnEliminar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar1.setFocusPainted(false);
        btnEliminar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar1.setIconTextGap(-2);
        btnEliminar1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/btnLEliminarRellover.png"))); // NOI18N
        btnEliminar1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnEliminar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        pnlBuscador.add(btnEliminar1, gridBagConstraints);

        pnlBuscar.add(pnlBuscador, java.awt.BorderLayout.PAGE_START);

        pnlTabla.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlTabla.setOpaque(false);
        pnlTabla.setLayout(new java.awt.BorderLayout());

        scrollTabla.setPreferredSize(new java.awt.Dimension(379, 250));

        tblAfiliados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblAfiliados.setToolTipText("");
        tblAfiliados.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblAfiliados.setGridColor(new java.awt.Color(51, 51, 255));
        tblAfiliados.setSelectionForeground(new java.awt.Color(255, 0, 51));
        tblAfiliados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAfiliadosMouseClicked(evt);
            }
        });
        scrollTabla.setViewportView(tblAfiliados);

        pnlTabla.add(scrollTabla, java.awt.BorderLayout.CENTER);

        pnlBuscar.add(pnlTabla, java.awt.BorderLayout.CENTER);

        pnlFondo.add(pnlBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, 80, 50));

        pnlCurvas.setBackground(new java.awt.Color(255, 0, 0));
        pnlCurvas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlDatosPersonales.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2), "Datos de registro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlDatosPersonales.setTran(0.0F);
        pnlDatosPersonales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CEDULA.setBackground(new java.awt.Color(255, 255, 255));
        CEDULA.setForeground(new java.awt.Color(0, 0, 0));
        CEDULA.setText("Nº Cédula*");
        CEDULA.setColorDeSombra(new java.awt.Color(255, 255, 51));
        CEDULA.setDistanciaDeSombra(1);
        pnlDatosPersonales.add(CEDULA, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, -1, 20));

        CORREO.setBackground(new java.awt.Color(255, 255, 255));
        CORREO.setForeground(new java.awt.Color(0, 0, 0));
        CORREO.setText("Correo");
        CORREO.setColorDeSombra(new java.awt.Color(255, 255, 51));
        CORREO.setDistanciaDeSombra(1);
        pnlDatosPersonales.add(CORREO, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, -1, 20));

        FOTO.setBackground(new java.awt.Color(255, 255, 255));
        FOTO.setForeground(new java.awt.Color(0, 0, 0));
        FOTO.setText("Foto");
        FOTO.setColorDeSombra(new java.awt.Color(255, 255, 51));
        FOTO.setDistanciaDeSombra(1);
        pnlDatosPersonales.add(FOTO, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 20));

        SEXO.setBackground(new java.awt.Color(255, 255, 255));
        SEXO.setForeground(new java.awt.Color(0, 0, 0));
        SEXO.setText("Sexo*");
        SEXO.setColorDeSombra(new java.awt.Color(255, 255, 51));
        SEXO.setDistanciaDeSombra(1);
        pnlDatosPersonales.add(SEXO, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, -1, 20));

        DIRECCION.setBackground(new java.awt.Color(255, 255, 255));
        DIRECCION.setForeground(new java.awt.Color(0, 0, 0));
        DIRECCION.setText("Dirección");
        DIRECCION.setColorDeSombra(new java.awt.Color(255, 255, 51));
        DIRECCION.setDistanciaDeSombra(1);
        pnlDatosPersonales.add(DIRECCION, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, -1, 20));

        TELEFONO.setBackground(new java.awt.Color(255, 255, 255));
        TELEFONO.setForeground(new java.awt.Color(0, 0, 0));
        TELEFONO.setText("Nº Teléfono");
        TELEFONO.setColorDeSombra(new java.awt.Color(255, 255, 51));
        TELEFONO.setDistanciaDeSombra(1);
        pnlDatosPersonales.add(TELEFONO, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, -1, 20));

        NOMBRE.setBackground(new java.awt.Color(255, 255, 255));
        NOMBRE.setForeground(new java.awt.Color(0, 0, 0));
        NOMBRE.setText("Nombre*");
        NOMBRE.setColorDeSombra(new java.awt.Color(255, 255, 51));
        NOMBRE.setDistanciaDeSombra(1);
        pnlDatosPersonales.add(NOMBRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, 20));

        APELLIDO.setBackground(new java.awt.Color(255, 255, 255));
        APELLIDO.setForeground(new java.awt.Color(0, 0, 0));
        APELLIDO.setText("Apellido*");
        APELLIDO.setColorDeSombra(new java.awt.Color(255, 255, 51));
        APELLIDO.setDistanciaDeSombra(1);
        pnlDatosPersonales.add(APELLIDO, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, -1, 20));

        EDAD.setBackground(new java.awt.Color(255, 255, 255));
        EDAD.setForeground(new java.awt.Color(0, 0, 0));
        EDAD.setText("Edad*");
        EDAD.setColorDeSombra(new java.awt.Color(255, 255, 51));
        EDAD.setDistanciaDeSombra(1);
        pnlDatosPersonales.add(EDAD, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, -1, 20));

        pnlFoto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 102), 3, true));
        pnlFoto.setToolTipText("Clic para agregar una foto");
        pnlFoto.setColorPrimario(new java.awt.Color(255, 255, 255));
        pnlFoto.setColorSecundario(new java.awt.Color(0, 204, 255));
        pnlFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlFotoMouseClicked(evt);
            }
        });
        pnlFoto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnFoto.setBorder(javax.swing.BorderFactory.createEmptyBorder(108, 2, 100, 100));
        btnFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/foto.png"))); // NOI18N
        btnFoto.setText(" ");
        btnFoto.setAlignmentY(0.0F);
        btnFoto.setAnchoDeBorde(0.0F);
        btnFoto.setBorderPainted(false);
        btnFoto.setColorDeBorde(new java.awt.Color(255, 0, 0));
        btnFoto.setColorDeSegundoBorde(new java.awt.Color(0, 255, 51));
        btnFoto.setDescription(" ");
        btnFoto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFoto.setRolloverEnabled(false);
        btnFoto.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFotoMouseClicked(evt);
            }
        });
        btnFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFotoActionPerformed(evt);
            }
        });
        pnlFoto.add(btnFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 160));

        pnlImagenFoto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 102), 3, true));
        pnlImagenFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/foto.png"))); // NOI18N
        pnlImagenFoto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnlFoto.add(pnlImagenFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 150));

        pnlDatosPersonales.add(pnlFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 130, 160));

        scrollDireccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 102), 3));

        txtDireccion.setBackground(new java.awt.Color(0, 204, 255));
        txtDireccion.setColumns(20);
        txtDireccion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDireccion.setLineWrap(true);
        txtDireccion.setRows(5);
        txtDireccion.setBorder(null);
        txtDireccion.setCaretColor(new java.awt.Color(255, 0, 0));
        scrollDireccion.setViewportView(txtDireccion);

        pnlDatosPersonales.add(scrollDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 150, 40));

        txtApellido.setBackground(new java.awt.Color(0, 204, 255));
        txtApellido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 102), 3));
        txtApellido.setAnchoDeBorde(4.0F);
        txtApellido.setCaretColor(new java.awt.Color(255, 0, 0));
        txtApellido.setColorDeBorde(new java.awt.Color(255, 255, 102));
        txtApellido.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtApellido.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlDatosPersonales.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 150, 30));

        txtCedula.setBackground(new java.awt.Color(0, 204, 255));
        txtCedula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 102), 3));
        txtCedula.setAnchoDeBorde(4.0F);
        txtCedula.setCaretColor(new java.awt.Color(255, 0, 0));
        txtCedula.setColorDeBorde(new java.awt.Color(255, 255, 102));
        txtCedula.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCedula.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCedula.setName(""); // NOI18N
        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });
        pnlDatosPersonales.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 150, 30));

        txtCorreo.setBackground(new java.awt.Color(0, 204, 255));
        txtCorreo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 102), 3));
        txtCorreo.setAnchoDeBorde(4.0F);
        txtCorreo.setCaretColor(new java.awt.Color(255, 0, 0));
        txtCorreo.setColorDeBorde(new java.awt.Color(255, 255, 102));
        txtCorreo.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtCorreo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlDatosPersonales.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 150, 30));

        txtTelefono.setBackground(new java.awt.Color(0, 204, 255));
        txtTelefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 102), 3));
        txtTelefono.setAnchoDeBorde(4.0F);
        txtTelefono.setCaretColor(new java.awt.Color(255, 0, 0));
        txtTelefono.setColorDeBorde(new java.awt.Color(255, 255, 102));
        txtTelefono.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtTelefono.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlDatosPersonales.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 150, 30));

        cbSexo.setBackground(new java.awt.Color(0, 204, 255));
        cbSexo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 102)));
        cbSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "----------", "Masculino", "Femenino" }));
        cbSexo.setAnchoDeBorde(4.0F);
        cbSexo.setColorDeBorde(new java.awt.Color(255, 255, 102));
        cbSexo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlDatosPersonales.add(cbSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 150, 30));

        txtNombre.setBackground(new java.awt.Color(0, 204, 255));
        txtNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 102), 3));
        txtNombre.setAnchoDeBorde(4.0F);
        txtNombre.setCaretColor(new java.awt.Color(255, 0, 0));
        txtNombre.setColorDeBorde(new java.awt.Color(255, 255, 102));
        txtNombre.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txtNombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlDatosPersonales.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 150, 30));

        txtEdad.setBackground(new java.awt.Color(0, 204, 255));
        txtEdad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 102), 3));
        txtEdad.setAnchoDeBorde(4.0F);
        txtEdad.setCaretColor(new java.awt.Color(255, 0, 0));
        txtEdad.setColorDeBorde(new java.awt.Color(255, 255, 102));
        txtEdad.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtEdad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtEdad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEdadFocusLost(evt);
            }
        });
        txtEdad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEdadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEdadKeyTyped(evt);
            }
        });
        pnlDatosPersonales.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 150, 30));

        INCONVENIENTES.setForeground(new java.awt.Color(0, 0, 0));
        INCONVENIENTES.setText("Condición");
        INCONVENIENTES.setColorDeSombra(new java.awt.Color(255, 255, 51));
        INCONVENIENTES.setDistanciaDeSombra(1);
        pnlDatosPersonales.add(INCONVENIENTES, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, -1, 20));

        scrollInconvenientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 102), 3));

        txtInconvenientes.setBackground(new java.awt.Color(0, 204, 255));
        txtInconvenientes.setColumns(20);
        txtInconvenientes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtInconvenientes.setLineWrap(true);
        txtInconvenientes.setRows(5);
        txtInconvenientes.setBorder(null);
        txtInconvenientes.setCaretColor(new java.awt.Color(255, 0, 0));
        scrollInconvenientes.setViewportView(txtInconvenientes);

        pnlDatosPersonales.add(scrollInconvenientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, 150, 130));

        MEDIDAS.setForeground(new java.awt.Color(0, 0, 0));
        MEDIDAS.setText("Medidas");
        MEDIDAS.setColorDeSombra(new java.awt.Color(255, 255, 51));
        MEDIDAS.setDistanciaDeSombra(1);
        pnlDatosPersonales.add(MEDIDAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 80, 70, 20));

        scrollMedidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 102), 3));

        txtMedidas.setBackground(new java.awt.Color(0, 204, 255));
        txtMedidas.setColumns(20);
        txtMedidas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtMedidas.setLineWrap(true);
        txtMedidas.setRows(5);
        txtMedidas.setBorder(null);
        txtMedidas.setCaretColor(new java.awt.Color(255, 0, 0));
        scrollMedidas.setViewportView(txtMedidas);

        pnlDatosPersonales.add(scrollMedidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 100, 150, 130));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        pnlDatosPersonales.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, 10, 180));

        pnlDatosRepresentante.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Datos de representante", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlDatosRepresentante.setTran(0.0F);
        pnlDatosRepresentante.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        REPRESENTANTE.setForeground(new java.awt.Color(0, 0, 0));
        REPRESENTANTE.setText("Representante");
        REPRESENTANTE.setColorDeSombra(new java.awt.Color(255, 255, 51));
        REPRESENTANTE.setDistanciaDeSombra(1);
        pnlDatosRepresentante.add(REPRESENTANTE, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 20));

        cbRepresentante.setBackground(new java.awt.Color(0, 204, 255));
        cbRepresentante.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 102)));
        cbRepresentante.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "----------", "Madre", "Padre", "Herman@", "Abuel@", "Tí@", "Otr@" }));
        cbRepresentante.setAnchoDeBorde(4.0F);
        cbRepresentante.setColorDeBorde(new java.awt.Color(255, 255, 102));
        cbRepresentante.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlDatosRepresentante.add(cbRepresentante, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 150, 30));

        NOMBRER.setForeground(new java.awt.Color(0, 0, 0));
        NOMBRER.setText("Nombre");
        NOMBRER.setColorDeSombra(new java.awt.Color(255, 255, 51));
        NOMBRER.setDistanciaDeSombra(1);
        pnlDatosRepresentante.add(NOMBRER, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, -1, 20));

        txtNombreR.setBackground(new java.awt.Color(0, 204, 255));
        txtNombreR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 102), 3));
        txtNombreR.setAnchoDeBorde(4.0F);
        txtNombreR.setCaretColor(new java.awt.Color(255, 0, 0));
        txtNombreR.setColorDeBorde(new java.awt.Color(255, 255, 102));
        txtNombreR.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txtNombreR.setDragEnabled(true);
        txtNombreR.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlDatosRepresentante.add(txtNombreR, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 150, 30));

        APELLIDOR.setForeground(new java.awt.Color(0, 0, 0));
        APELLIDOR.setText("Apellido");
        APELLIDOR.setColorDeSombra(new java.awt.Color(255, 255, 51));
        APELLIDOR.setDistanciaDeSombra(1);
        pnlDatosRepresentante.add(APELLIDOR, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, -1, 20));

        txtApellidoR.setBackground(new java.awt.Color(0, 204, 255));
        txtApellidoR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 102), 3));
        txtApellidoR.setAnchoDeBorde(4.0F);
        txtApellidoR.setCaretColor(new java.awt.Color(255, 0, 0));
        txtApellidoR.setColorDeBorde(new java.awt.Color(255, 255, 102));
        txtApellidoR.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtApellidoR.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlDatosRepresentante.add(txtApellidoR, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 150, 30));

        CEDULAR.setForeground(new java.awt.Color(0, 0, 0));
        CEDULAR.setText("Nº Cédula");
        CEDULAR.setColorDeSombra(new java.awt.Color(255, 255, 51));
        CEDULAR.setDistanciaDeSombra(1);
        pnlDatosRepresentante.add(CEDULAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, 20));

        txtCedulaR.setBackground(new java.awt.Color(0, 204, 255));
        txtCedulaR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 102), 3));
        txtCedulaR.setAnchoDeBorde(4.0F);
        txtCedulaR.setCaretColor(new java.awt.Color(255, 0, 0));
        txtCedulaR.setColorDeBorde(new java.awt.Color(255, 255, 102));
        txtCedulaR.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtCedulaR.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCedulaR.setName("tdni"); // NOI18N
        txtCedulaR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaRKeyTyped(evt);
            }
        });
        pnlDatosRepresentante.add(txtCedulaR, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 150, 30));

        TELEFONOR.setForeground(new java.awt.Color(0, 0, 0));
        TELEFONOR.setText("Nº Teléfono");
        TELEFONOR.setColorDeSombra(new java.awt.Color(255, 255, 51));
        TELEFONOR.setDistanciaDeSombra(1);
        pnlDatosRepresentante.add(TELEFONOR, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, -1, 20));

        txtTelefonoR.setBackground(new java.awt.Color(0, 204, 255));
        txtTelefonoR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 102), 3));
        txtTelefonoR.setAnchoDeBorde(4.0F);
        txtTelefonoR.setCaretColor(new java.awt.Color(255, 0, 0));
        txtTelefonoR.setColorDeBorde(new java.awt.Color(255, 255, 102));
        txtTelefonoR.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtTelefonoR.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlDatosRepresentante.add(txtTelefonoR, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 150, 30));

        pnlDatosPersonales.add(pnlDatosRepresentante, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 530, 170));

        pnlCurvas.add(pnlDatosPersonales, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 860, 470));

        btnGuardarCambios.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGuardarCambios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/btnGuardar.png"))); // NOI18N
        btnGuardarCambios.setText("Guardar cambios");
        btnGuardarCambios.setBorder(null);
        btnGuardarCambios.setBorderPainted(false);
        btnGuardarCambios.setContentAreaFilled(false);
        btnGuardarCambios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarCambios.setFocusPainted(false);
        btnGuardarCambios.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/btnGuardarRellover.png"))); // NOI18N
        btnGuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCambiosActionPerformed(evt);
            }
        });
        pnlCurvas.add(btnGuardarCambios, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 550, 190, 50));

        btnEditar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/btnEditar.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setBorder(null);
        btnEditar.setBorderPainted(false);
        btnEditar.setContentAreaFilled(false);
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.setFocusPainted(false);
        btnEditar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/btnEditarRellover.png"))); // NOI18N
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        pnlCurvas.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 550, 120, 50));

        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/btnGuardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(null);
        btnGuardar.setBorderPainted(false);
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.setFocusPainted(false);
        btnGuardar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/btnGuardarRellover.png"))); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        pnlCurvas.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 550, 150, 50));

        btnNuevo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/btnNuevo.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setBorder(null);
        btnNuevo.setBorderPainted(false);
        btnNuevo.setContentAreaFilled(false);
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.setFocusPainted(false);
        btnNuevo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/btnNuevoRellover.png"))); // NOI18N
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        pnlCurvas.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 550, 120, 50));

        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/btnBuscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(null);
        btnBuscar.setBorderPainted(false);
        btnBuscar.setContentAreaFilled(false);
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.setFocusPainted(false);
        btnBuscar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/btnBuscarRellover.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        pnlCurvas.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 550, 120, 50));

        pnlDatosCategoria.setBackground(new java.awt.Color(255, 255, 255));
        pnlDatosCategoria.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnlDatosCategoria.add(txtInscripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 90, -1));
        pnlDatosCategoria.add(txtMensualidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 90, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Inscripción");
        pnlDatosCategoria.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Mensualidad");
        pnlDatosCategoria.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, -1, 20));

        lblNombreCategoria.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblNombreCategoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlDatosCategoria.add(lblNombreCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 210, 30));

        jTextField1.setText("jTextField1");
        pnlDatosCategoria.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));

        jLabel4.setText("Instructor");
        pnlDatosCategoria.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, -1, -1));

        pnlCurvas.add(pnlDatosCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 50, 40));

        pnlFondo.add(pnlCurvas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 610));

        progressbarBarra.setBackground(new java.awt.Color(0, 204, 255));
        progressbarBarra.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        progressbarBarra.setForeground(new java.awt.Color(255, 255, 0));
        progressbarBarra.setToolTipText("");
        progressbarBarra.setBorde(5.0F);
        progressbarBarra.setBorderPainted(false);
        progressbarBarra.setColorDeBorde(new java.awt.Color(0, 0, 0));
        progressbarBarra.setDistanciaDeSombra(5);
        progressbarBarra.setFont(new java.awt.Font("SunnySide", 1, 36)); // NOI18N
        progressbarBarra.setString("Registro de Afiliado");
        progressbarBarra.setStringPainted(true);
        pnlFondo.add(progressbarBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 540, 60));

        getContentPane().add(pnlFondo, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnlFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlFotoMouseClicked
        
        if(pnlFoto.isEnabled()){TVpnlFotoYbtnFotoMouseClicked();}
        
    }//GEN-LAST:event_pnlFotoMouseClicked

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        
        txtBuscar.addKeyListener(new KeyAdapter() {
            
            public void keyReleased(final KeyEvent e){
                
                String cadena = (txtBuscar.getText());
                e(1,txtBuscar);
                txtBuscar.setText(cadena);
                repaint();
                filtro();
            }
        });
        
        trsFiltro = new TableRowSorter(tblAfiliados.getModel());
        tblAfiliados.setRowSorter(trsFiltro);
        
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void tblAfiliadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAfiliadosMouseClicked
        
        TVtblAfiliadosMouseClicked();
       
    }//GEN-LAST:event_tblAfiliadosMouseClicked

    private void pnlBuscadorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBuscadorMousePressed
    }//GEN-LAST:event_pnlBuscadorMousePressed

    private void pnlBuscadorMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBuscadorMouseDragged
    }//GEN-LAST:event_pnlBuscadorMouseDragged

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        if(cedula1 != 0 && cedular != 0 && telefono != 0 && telefonor != 0){
            TVbtnGuardarActionPerformed();
        }else{
            JOptionPane.showInternalMessageDialog(pnlFondo, "Hay campos erróneos, por favor asegurese de revisar.", "AVISO", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed

        cedula = -1;
        v(1,btnGuardar);
        v(0,btnEditar);
        v(0,btnGuardarCambios);
        //e(0,btnGuardar);
        e(1,txtCedula);
    
        LimpiarCajas();
        HabilitarDatosPersonales();
        InhabilitarDatosRepresentante();
        
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        TVbtnBuscarActionPerformed();
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
         
        HabilitarDatosPersonales();

        int edad = Integer.parseInt(txtEdad.getText());
        
        if(edad < 18){ HabilitarDatosRepresentante(); }
        
        if(URLImagen.equals("")){ v(1,btnFoto); 
        }else{ v(0,btnFoto); }
        
        v(0,btnEditar);
        v(1,btnGuardarCambios);
        e(0,txtCedula);
         
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCambiosActionPerformed
        
        TVbtnGuardarCambiosActionPerformed();

    }//GEN-LAST:event_btnGuardarCambiosActionPerformed

    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped
    }//GEN-LAST:event_txtCedulaKeyTyped

    private void btnFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFotoActionPerformed
    }//GEN-LAST:event_btnFotoActionPerformed

    private void btnFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFotoMouseClicked
        
        TVpnlFotoYbtnFotoMouseClicked();

    }//GEN-LAST:event_btnFotoMouseClicked

    private void txtCedulaRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaRKeyTyped
    }//GEN-LAST:event_txtCedulaRKeyTyped

    private void txtEdadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEdadKeyTyped

        txtEdad.addKeyListener(new KeyAdapter() {

            public void keyReleased(final KeyEvent e){
                
                String cadena = (txtEdad.getText());
                txtEdad.setText(cadena);
                int edad;
                
                if(txtEdad.getText().equals("")){ edad = 0;    
                }else{ edad = Integer.parseInt(txtEdad.getText()); }
                
                if(edad < 18){ 
                    HabilitarDatosRepresentante(); 
                    varActPnlRepresentante = true; }
                
                if(edad >= 18){ 
                    InhabilitarDatosRepresentante(); 
                    varActPnlRepresentante = false; }
                
                if(txtEdad.getText().equals("")){ 
                    InhabilitarDatosRepresentante(); 
                    varActPnlRepresentante = false;}
                
                if(edad == 0){ 
                    InhabilitarDatosRepresentante(); 
                    varActPnlRepresentante = false;}
            }
        });

    }//GEN-LAST:event_txtEdadKeyTyped

    private void txtEdadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEdadKeyReleased
    }//GEN-LAST:event_txtEdadKeyReleased

    private void txtEdadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEdadFocusLost
    }//GEN-LAST:event_txtEdadFocusLost

    private void cbBuscarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbBuscarItemStateChanged
        
        if(cbBuscar.getSelectedItem().equals("Categoría")){
            mComboBoxBuscar = new DefaultComboBoxModel(cg.getCategorias().toArray());
            this.cbBuscadorCategoria.setModel(mComboBoxBuscar);
            v(0,txtBuscar);
            v(1,cbBuscadorCategoria);  
        }
        
        if(cbBuscar.getSelectedItem().equals("Sexo")){
            mComboBoxBuscar = new DefaultComboBoxModel(cg.getSexos().toArray());
            this.cbBuscadorCategoria.setModel(mComboBoxBuscar);
            v(0,txtBuscar);
            v(1,cbBuscadorCategoria);
        }
        
        if(cbBuscar.getSelectedItem().equals("Nombre") || cbBuscar.getSelectedItem().equals("Apellido") || cbBuscar.getSelectedItem().equals("Nº Cédula")){
            v(0,cbBuscadorCategoria);
            v(1,txtBuscar);
        }
        
    }//GEN-LAST:event_cbBuscarItemStateChanged

    private void cbBuscadorCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbBuscadorCategoriaItemStateChanged
/*
        cbBuscadorCategoria.addItemListener(
            new ItemListener(){
                public void itemStateChanged(ItemEvent evt){
                    String text = cbBuscadorCategoria.getSelectedItem().toString();
                    repaint();
                    trsFiltro.setRowFilter(RowFilter.regexFilter(text, 3));
                }
            }

        );
*/
        //e(1,txtBuscar);
        //txtBuscar.setText(cbBuscadorCategoria.getSelectedItem().toString());
        
    }//GEN-LAST:event_cbBuscadorCategoriaItemStateChanged

    private void cbBuscadorCategoriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbBuscadorCategoriaKeyTyped
    }//GEN-LAST:event_cbBuscadorCategoriaKeyTyped

    private void btnEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar1ActionPerformed

       if(cedula != -1){

           TVbtnEliminarActionPerformed(); 
           
        }else{ JOptionPane.showMessageDialog(pnlFondo,"Debe seleccionar un usuario"); }

        v(0,btnEditar);
        v(1,btnGuardar);

    }//GEN-LAST:event_btnEliminar1ActionPerformed

    public void run(){
        
        Thread ct = Thread.currentThread();
        
        while(ct == h1){
            calcula();

            try{
                Thread.sleep(1);
            }catch(InterruptedException e){
                JOptionPane.showMessageDialog(pnlFondo,"Error: "+e.getMessage());
            }
        }
    }
    
    private void calcula(){
        
        if(txtCedula.getText().length()<7 && txtCedula.getText().length()!=0){
            txtCedula.setColorDeBorde(Color.RED);
            cedula1 = 0;
        }else if(txtCedula.isEditable()){
            txtCedula.setColorDeBorde(Color.BLACK);
            cedula1 = 1;
        }
        
        if(txtCedulaR.getText().length()<7 && txtCedulaR.getText().length()!=0){
            txtCedulaR.setColorDeBorde(Color.RED);
            cedular = 0;
        }else if(txtCedulaR.isEditable()){
            txtCedulaR.setColorDeBorde(Color.BLACK);
            cedular = 1;
        }
        
        if((txtTelefono.getText().length()<11 && txtTelefono.getText().length()!=0)){
            txtTelefono.setColorDeBorde(Color.RED);
            telefono = 0;
        }else if(txtTelefono.isEditable()){
            txtTelefono.setColorDeBorde(Color.BLACK);
            telefono = 1;
        }
        
        if((txtTelefonoR.getText().length()<11 && txtTelefonoR.getText().length()!=0)){
            txtTelefonoR.setColorDeBorde(Color.RED);
            telefonor = 0;
        }else if(txtTelefonoR.isEditable()){
            txtTelefonoR.setColorDeBorde(Color.BLACK);
            telefonor = 1;
        }
        
    }
    
    private void HabilitarDatosPersonales(){

        this.txtNombre.setEditable(true);
        this.txtApellido.setEditable(true);
        this.txtCedula.setEditable(true);
        this.txtCorreo.setEditable(true);
        this.txtTelefono.setEditable(true);
        this.txtDireccion.setEditable(true);
        this.txtEdad.setEditable(true);
        this.txtInconvenientes.setEditable(true);
        this.txtMedidas.setEditable(true);
        e(1,cbSexo);
        e(1,pnlFoto);
        v(1,btnFoto);
        
        this.txtNombre.setBackground(amar);
        this.txtApellido.setBackground(amar);
        this.txtCedula.setBackground(amar);
        this.txtCorreo.setBackground(amar);
        this.txtTelefono.setBackground(amar);
        this.txtDireccion.setBackground(amar);
        this.txtEdad.setBackground(amar);
        this.cbSexo.setBackground(amar);
        this.pnlFoto.setBackground(amar);
        this.txtInconvenientes.setBackground(amar);
        this.txtMedidas.setBackground(amar);

        //
        this.NOMBRE.setColorDeSombra(azul);
        this.APELLIDO.setColorDeSombra(azul);
        this.CEDULA.setColorDeSombra(azul);
        this.CORREO.setColorDeSombra(azul);
        this.TELEFONO.setColorDeSombra(azul);
        this.DIRECCION.setColorDeSombra(azul);
        this.EDAD.setColorDeSombra(azul);
        this.SEXO.setColorDeSombra(azul);
        this.FOTO.setColorDeSombra(azul);
        this.INCONVENIENTES.setColorDeSombra(azul);
        this.MEDIDAS.setColorDeSombra(azul);

        this.txtNombre.setColorDeBorde(new java.awt.Color(0,0,0));
        this.txtApellido.setColorDeBorde(new java.awt.Color(0,0,0));
        this.txtCedula.setColorDeBorde(new java.awt.Color(0,0,0));
        this.txtCorreo.setColorDeBorde(new java.awt.Color(0,0,0));
        this.txtTelefono.setColorDeBorde(new java.awt.Color(0,0,0));
        this.scrollDireccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0), 3));
        this.txtEdad.setColorDeBorde(new java.awt.Color(0,0,0));
        this.cbSexo.setColorDeBorde(new java.awt.Color(0,0,0));
        this.pnlFoto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        this.pnlFoto.setColorPrimario(new java.awt.Color(255, 255, 255));
        this.pnlFoto.setColorSecundario(new java.awt.Color(255, 255, 103));
        this.pnlImagenFoto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        this.scrollInconvenientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0), 3));
        this.scrollMedidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0), 3));
        
    }
    
    private void InhabilitarDatosPersonales(){
        
        this.txtNombre.setEditable(false);
        this.txtApellido.setEditable(false);
        this.txtCedula.setEditable(false);
        this.txtCorreo.setEditable(false);
        this.txtTelefono.setEditable(false);
        this.txtDireccion.setEditable(false);
        this.txtEdad.setEditable(false);
        this.txtInconvenientes.setEditable(false);
        this.txtMedidas.setEditable(false);
        e(0,cbSexo);
        e(0,pnlFoto);
        v(0,btnFoto);

        this.txtNombre.setBackground(azul);
        this.txtApellido.setBackground(azul);
        this.txtCedula.setBackground(azul);
        this.txtCorreo.setBackground(azul);
        this.txtTelefono.setBackground(azul);
        this.txtDireccion.setBackground(azul);
        this.txtEdad.setBackground(azul);
        this.cbSexo.setBackground(azul);
        this.pnlFoto.setBackground(azul);
        this.txtInconvenientes.setBackground(azul);
        this.txtMedidas.setBackground(azul);

        //
        this.NOMBRE.setColorDeSombra(amar);
        this.APELLIDO.setColorDeSombra(amar);
        this.CEDULA.setColorDeSombra(amar);
        this.CORREO.setColorDeSombra(amar);
        this.TELEFONO.setColorDeSombra(amar);
        this.DIRECCION.setColorDeSombra(amar);
        this.EDAD.setColorDeSombra(amar);
        this.SEXO.setColorDeSombra(amar);
        this.FOTO.setColorDeSombra(amar);
        this.INCONVENIENTES.setColorDeSombra(amar);
        this.MEDIDAS.setColorDeSombra(amar);
        
        this.txtNombre.setColorDeBorde(new java.awt.Color(255,255,102));
        this.txtApellido.setColorDeBorde(new java.awt.Color(255,255,102));
        this.txtCedula.setColorDeBorde(new java.awt.Color(255,255,102));
        this.txtCorreo.setColorDeBorde(new java.awt.Color(255,255,102));
        this.txtTelefono.setColorDeBorde(new java.awt.Color(255,255,102));
        this.scrollDireccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,255,102), 3));
        this.txtEdad.setColorDeBorde(new java.awt.Color(255,255,102));
        this.cbSexo.setColorDeBorde(new java.awt.Color(255,255,102));
        this.pnlFoto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255,255,102), 3, true));
        this.pnlFoto.setColorPrimario(new java.awt.Color(255, 255, 255));
        this.pnlFoto.setColorSecundario(new java.awt.Color(0,204,255));
        this.pnlImagenFoto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255,255,102), 3, true));
        this.scrollInconvenientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,255,102), 3));
        this.scrollMedidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,255,102), 3));
  
    }

    private void HabilitarDatosRepresentante(){
        
        e(1,cbRepresentante);
        this.txtNombreR.setEditable(true);
        this.txtApellidoR.setEditable(true);
        this.txtCedulaR.setEditable(true);
        this.txtTelefonoR.setEditable(true);
        
        this.cbRepresentante.setBackground(amar);
        this.txtNombreR.setBackground(amar);
        this.txtApellidoR.setBackground(amar);
        this.txtCedulaR.setBackground(amar);
        this.txtTelefonoR.setBackground(amar);
        
        //
        this.REPRESENTANTE.setColorDeSombra(azul);
        this.NOMBRER.setColorDeSombra(azul);
        this.APELLIDOR.setColorDeSombra(azul);
        this.CEDULAR.setColorDeSombra(azul);
        this.TELEFONOR.setColorDeSombra(azul);

        this.cbRepresentante.setColorDeBorde(new java.awt.Color(0,0,0));
        this.txtNombreR.setColorDeBorde(new java.awt.Color(0,0,0));
        this.txtApellidoR.setColorDeBorde(new java.awt.Color(0,0,0));
        this.txtCedulaR.setColorDeBorde(new java.awt.Color(0,0,0));
        this.txtTelefonoR.setColorDeBorde(new java.awt.Color(0,0,0));
        
    }
    
    private void InhabilitarDatosRepresentante(){

        e(0,cbRepresentante);
        this.txtNombreR.setEditable(false);
        this.txtApellidoR.setEditable(false);
        this.txtCedulaR.setEditable(false);
        this.txtTelefonoR.setEditable(false);
        
        this.cbRepresentante.setBackground(azul);
        this.txtNombreR.setBackground(azul);
        this.txtApellidoR.setBackground(azul);
        this.txtCedulaR.setBackground(azul);
        this.txtTelefonoR.setBackground(azul);
        
        //
        this.REPRESENTANTE.setColorDeSombra(amar);
        this.NOMBRER.setColorDeSombra(amar);
        this.APELLIDOR.setColorDeSombra(amar);
        this.CEDULAR.setColorDeSombra(amar);
        this.TELEFONOR.setColorDeSombra(amar);
        
        this.cbRepresentante.setColorDeBorde(new java.awt.Color(255,255,102));
        this.txtNombreR.setColorDeBorde(new java.awt.Color(255,255,102));
        this.txtApellidoR.setColorDeBorde(new java.awt.Color(255,255,102));
        this.txtCedulaR.setColorDeBorde(new java.awt.Color(255,255,102));
        this.txtTelefonoR.setColorDeBorde(new java.awt.Color(255,255,102));
        
    }
    
    private void LimpiarCajas(){

        
        //PERSONALES
        this.txtNombre.setText(null);
        this.txtApellido.setText(null);
        this.txtCedula.setText(null);
        this.txtCorreo.setText(null);
        this.txtTelefono.setText(null);
        this.txtDireccion.setText(null);
        this.txtEdad.setText(null);
        this.cbSexo.setSelectedItem("----------");
        this.pnlImagenFoto.setIcon(new ImageIcon(System.getProperty("user.dir")+"/src/sakura/resources/botones/foto.png"));
        e(0,btnFoto);
        this.pnlImagenFoto.updateUI();
        this.txtInconvenientes.setText(null);
        this.txtMedidas.setText(null);
        URLImagen = "";

        //REPRESENTANTE
        this.cbRepresentante.setSelectedItem("----------");
        this.txtNombreR.setText(null);
        this.txtApellidoR.setText(null);
        this.txtCedulaR.setText(null);
        this.txtTelefonoR.setText(null);
            
    }

    private void filtro(){
        
        int columnaABuscar=0;

        if(cbBuscar.getSelectedItem()=="Nombre"){ columnaABuscar = 0; }
        if(cbBuscar.getSelectedItem()=="Apellido"){ columnaABuscar = 1; }
        if(cbBuscar.getSelectedItem()=="Nº Cédula"){ columnaABuscar = 2; }
        //if(cbBuscar.getSelectedItem()=="Categoría"){ columnaABuscar = 3; }
        //if(cbBuscar.getSelectedItem()=="Sexo"){ columnaABuscar = 6; }

        trsFiltro.setRowFilter(RowFilter.regexFilter("(?i)"+txtBuscar.getText(), columnaABuscar));
        
   }

    private class progreso implements ActionListener{
        
        public void actionPerformed(ActionEvent evt){
          
            int n = progressbarBarra.getValue();
            
            if(n < 100){
                n = n + 3;
                progressbarBarra.setValue(n);
       
                if(progressbarBarra.getValue() == 100){
                    JOptionPane.showInternalMessageDialog(pnlFondo, "Accion realizada con éxito","Aviso",JOptionPane.INFORMATION_MESSAGE);
                    LimpiarCajas();
                    InhabilitarDatosPersonales();
                    InhabilitarDatosRepresentante();
                }

            }else{
                timer.stop();
                progressbarBarra.setValue(0);
            }
        }
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
    
    private void TVbtnBuscarActionPerformed(){
        
        v(1,btnGuardar);
        e(0,btnGuardar);
        v(0,btnGuardarCambios);

        modelo.setRowCount(0);

        try{
            InsertDatosEnTabla();
        }catch(SQLException ex){ JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(),"Aviso",JOptionPane.ERROR_MESSAGE); }
        
        v(1,pnlBuscar);
        JOptionPane.showInternalMessageDialog(pnlFondo, pnlBuscar,"Buscador-Afiliados",JOptionPane.PLAIN_MESSAGE);
    }
    
    private void TVbtnGuardarActionPerformed(){

        connection = Conectar.getConnection();
        
        if(!txtNombre.getText().isEmpty() && !txtApellido.getText().isEmpty() && !txtCedula.getText().isEmpty() 
        && !txtEdad.getText().equals("") && !txtEdad.getText().equals("0") && !cbSexo.getSelectedItem().equals("----------")){

            try{
                if(varActPnlRepresentante == true){

                    if(!txtNombreR.getText().isEmpty() && !txtApellidoR.getText().isEmpty() && !txtCedulaR.getText().isEmpty() 
                    && !txtTelefonoR.getText().isEmpty() && !cbRepresentante.getSelectedItem().equals("----------")){
                        
                        /*if(txtTelefono.getText().equals(""))
                            txtTelefono.setText("0");
                        if(txtTelefonoR.getText().equals(""))
                            txtTelefonoR.setText("0");*/

                        InsertDatosRepresentantes();
                        InsertDatosPersonales();
                        timer.start();
                                
                    }else{JOptionPane.showInternalMessageDialog(pnlFondo, "Los datos de representante deben de ser rellenados","Aviso",JOptionPane.ERROR_MESSAGE); }
                }else{
                    
                    /*if(txtTelefono.getText().equals(""))
                        txtTelefono.setText("0");
                    if(txtTelefonoR.getText().equals(""))
                        txtTelefonoR.setText("0");*/

                    InsertDatosRepresentantes();
                    InsertDatosPersonales();
                    timer.start();
                }
                
                connection.close();

            }catch(SQLException ex){ JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(),"Aviso",JOptionPane.ERROR_MESSAGE); }

    }else{ JOptionPane.showInternalMessageDialog(pnlFondo, "Hay campos obligatorios vacios","Aviso",JOptionPane.ERROR_MESSAGE); }
    }
    
    private void TVbtnGuardarCambiosActionPerformed(){
        
        connection = Conectar.getConnection();
        
        if(!txtNombre.getText().isEmpty() && !txtApellido.getText().isEmpty() && !txtCedula.getText().isEmpty() 
        && !txtEdad.getText().equals("") && !txtEdad.getText().equals("0") && !cbSexo.getSelectedItem().equals("----------")){

            try{
                if(varActPnlRepresentante == true){

                    if(!txtNombreR.getText().isEmpty() && !txtApellidoR.getText().isEmpty() && !txtCedulaR.getText().isEmpty() 
                    && !txtTelefonoR.getText().isEmpty() && !cbRepresentante.getSelectedItem().equals("----------")){
                        
                        if(txtTelefono.getText().equals(""))
                            txtTelefono.setText("0");
                        if(txtTelefonoR.getText().equals(""))
                            txtTelefonoR.setText("0");

                        
                        UpdateDatosPersonales();
                        UpdateDatosRepresentante();
                        timer.start();
                        
                        v(0,btnGuardarCambios);
                        v(1,btnGuardar);
                        e(0,btnGuardar);

                    }else{ JOptionPane.showInternalMessageDialog(pnlFondo, "Los datos de representante deben de ser rellenados","Aviso",JOptionPane.ERROR_MESSAGE); }
                }else{
                    if(txtTelefono.getText().equals(""))
                        txtTelefono.setText("0");
                    if(txtTelefonoR.getText().equals(""))
                        txtTelefonoR.setText("0");
                    
                    UpdateDatosPersonales();
                    timer.start();
                    
                    v(0,btnGuardarCambios);
                    v(1,btnGuardar);
                    e(0,btnGuardar);
                }
 
                connection.close();

            }catch(SQLException ex){ JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(),"Aviso",JOptionPane.WARNING_MESSAGE); }
        }else{ JOptionPane.showInternalMessageDialog(pnlFondo, "Hay campos obligatorios vacios","Aviso",JOptionPane.ERROR_MESSAGE); }
    }
    
    private void TVbtnEliminarActionPerformed(){
        
        int confirmar =JOptionPane.showConfirmDialog(pnlFondo,"¿Desea eliminar al afiliado "+txtNombre.getText()+" "+txtApellido.getText()+"?. Esta operación lo borrará completamente del sistema.");

            if(JOptionPane.OK_OPTION == confirmar){

                try {
                    DeleteDatos("datospersonales");
                    DeleteDatos("datosrepresentante");
                    DeleteDatos("estadoinscripcioncategoria");
                    DeleteDatos("estadoinscripcionsakura");
                    DeleteDatos("estadomembresiacategoria");
                    DeleteDatos("estadomembresiasakura");
                    DeleteDatos("estadototalcategoria");
                    DeleteDatos("trayectodanza");
                    DeleteDatos("trayectokarate");
                    modelo.setRowCount(0);
                    InsertDatosEnTabla();
                    
                    connection.close();

                }catch(SQLException ex){ JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage()); }
            }
        
    }
    
    private void TVtblAfiliadosMouseClicked(){
        
        LimpiarCajas();
        
        try{
            int fila = tblAfiliados.getSelectedRow();
            int filaModel = tblAfiliados.convertRowIndexToModel(fila); //CONVIERTE LA FILA AL MODELO

            tblAfiliados.convertRowIndexToView(filaModel); //CONVIERTE LA FILA A LA VISTA
            modelo.fireTableDataChanged(); //POR SI HAY ALGUN ERROR, AVISA QUE LA TABLA HA CAMBIADO

            String tableClick = (tblAfiliados.getModel().getValueAt(filaModel, 2).toString());

            connection = Conectar.getConnection();
            PreparedStatement pst = connection.prepareStatement("SELECT * FROM datospersonales a, datosrepresentante c WHERE a.cedula = '"+tableClick+"' AND c.cedula = '"+tableClick+"'");
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                
                String add1 = rs.getString("a.nombre"); this.txtNombre.setText(add1);

                String add2 = rs.getString("a.apellido"); this.txtApellido.setText(add2);

                int add3 = rs.getInt("a.cedula"); this.txtCedula.setText(""+add3); cedula = add3;

                String add4 = rs.getString("a.sexo"); this.cbSexo.setSelectedItem(add4);

                String add5 = rs.getString("a.correo"); this.txtCorreo.setText(add5);

                String add6 = rs.getString("a.telefono"); this.txtTelefono.setText(add6);
                if(add6.equals("0")){ txtTelefono.setText(""); }else{ this.txtTelefono.setText(add6); }
                
                String add7 = rs.getString("a.direccion"); this.txtDireccion.setText(add7);

                String add9 = rs.getString("a.foto"); this.URLImagen = add9;
                this.pnlImagenFoto.setIcon(new ImageIcon(System.getProperty("user.dir")+"/fotos/"+add9));
                this.pnlImagenFoto.updateUI();

                String add10 = rs.getString("c.representante"); this.cbRepresentante.setSelectedItem(add10);
                
                String add11 = rs.getString("c.nombrer"); this.txtNombreR.setText(add11);
                
                String add12 = rs.getString("c.apellidor"); this.txtApellidoR.setText(add12);
                
                String add13 = rs.getString("c.telefonor");
                if(add13.equals("0")){ txtTelefonoR.setText(""); }else{ this.txtTelefonoR.setText(add13); }
                
                int add14 = rs.getInt("c.cedular");
                if(add14 == 0){ txtCedulaR.setText(""); }else{ this.txtCedulaR.setText(""+add14); }
                
                String add15 = rs.getString("a.inconvenientes"); this.txtInconvenientes.setText(add15);
                
                String add16 = rs.getString("a.medidas"); this.txtMedidas.setText(add16);
                
                int add17 = rs.getInt("a.edad"); this.txtEdad.setText(""+add17);
                
                if(txtTelefono.getText().equals("0"))
                    txtTelefono.setText("");
                if(txtTelefonoR.getText().equals("0"))
                    txtTelefonoR.setText("");
                
                if(!txtNombreR.getText().equals("")){
                    varActPnlRepresentante = true;
                }
            }

        }catch(SQLException e){ JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+e.getMessage(),"Aviso",JOptionPane.WARNING_MESSAGE); }

        if(URLImagen.equals("")){
            v(0,btnFoto);
            this.pnlImagenFoto.setIcon(new ImageIcon(System.getProperty("user.dir")+"/src/sakura/resources/botones/foto.png"));       
        }else{ v(0,btnFoto); }
        
        this.txtNombre.setEditable(false);
        this.txtApellido.setEditable(false);
        this.txtCedula.setEditable(false);
        this.txtCorreo.setEditable(false);
        this.txtTelefono.setEditable(false);
        this.txtDireccion.setEditable(false);
        e(0,cbSexo);
        e(0,pnlFoto);
        v(0,btnGuardar);
        v(0,btnGuardarCambios);
        v(1,btnEditar);
    }
    
    private void TVpnlFotoYbtnFotoMouseClicked(){
        
        JFileChooser se = new JFileChooser();
        se.setFileSelectionMode(JFileChooser.FILES_ONLY);
        se.setMultiSelectionEnabled(false);
        se.setAccessory(new PanelVistaPrevia(se));
        se.setFileFilter(new FiltraExtensionArchivos());
        se.setFileView(new VistaArchivos());
        int estado = se.showOpenDialog(null);
            
        if(estado == JFileChooser.APPROVE_OPTION){  
            try {  
                Thumbnail tn;
                imagen = new FileInputStream(se.getSelectedFile());
                Image icono = ImageIO.read(imagen).getScaledInstance(300, 200, Image.SCALE_AREA_AVERAGING);
                tn = new Thumbnail(icono,System.getProperty("user.dir")+"/fotos/"+se.getSelectedFile().getName());
                imagen = tn.generarThumbnail();
                this.pnlImagenFoto.setIcon(new ImageIcon(System.getProperty("user.dir")+"/fotos/"+se.getSelectedFile().getName()));
                this.pnlImagenFoto.updateUI();
                dat = new DatoArchivo(imagen,(int)se.getSelectedFile().length());
                this.URLImagen = se.getSelectedFile().getName();
                v(0,btnFoto);

                }catch(FileNotFoundException ex){ JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(),"Aviso",JOptionPane.WARNING_MESSAGE);
                }catch(IOException ex){ JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(),"Aviso",JOptionPane.WARNING_MESSAGE); }
        }
    }
    private void InsertDatosRepresentantes() throws SQLException{
        
        if(Integer.parseInt(txtEdad.getText()) < 18){
            preparedStatement=connection.prepareStatement("INSERT INTO datosrepresentante(cedula,representante,nombrer,apellidor,telefonor,cedular)VALUES(?,?,?,?,?,?)");
            preparedStatement.setInt(1,Integer.parseInt(this.txtCedula.getText()));
            if(!cbRepresentante.getSelectedItem().equals("----------")){ preparedStatement.setString(2,this.cbRepresentante.getSelectedItem().toString());
            }else{ preparedStatement.setString(2,""); }
            if(!txtNombreR.getText().isEmpty()){ preparedStatement.setString(3,this.txtNombreR.getText());
            }else{ preparedStatement.setString(3,""); }
            if(!txtApellidoR.getText().isEmpty()){ preparedStatement.setString(4,this.txtApellidoR.getText());
            }else{ preparedStatement.setString(4,""); }
            if(!txtTelefonoR.getText().isEmpty()){ preparedStatement.setString(5,this.txtTelefonoR.getText());
            }else{ preparedStatement.setString(5,""); }
            if(!txtCedulaR.getText().isEmpty()){ preparedStatement.setInt(6,Integer.parseInt(this.txtCedulaR.getText()));
            }else{ preparedStatement.setInt(6,0); }
            int res1 = preparedStatement.executeUpdate();

            if (res1 > 0) {
                e(0,btnGuardar);
            }else{
                JOptionPane.showInternalMessageDialog(pnlFondo, "Error al registrar","Aviso",JOptionPane.WARNING_MESSAGE);
                LimpiarCajas();
            }
        }else{ 
            preparedStatement=connection.prepareStatement("INSERT INTO datosrepresentante(cedula,representante,nombrer,apellidor,telefonor,cedular)VALUES(?,?,?,?,?,?)");
            preparedStatement.setInt(1,Integer.parseInt(this.txtCedula.getText()));
            preparedStatement.setString(2,"");
            preparedStatement.setString(3,"");
            preparedStatement.setString(4,"");
            preparedStatement.setLong(5,0);
            preparedStatement.setInt(6,0);
            int res1 = preparedStatement.executeUpdate();

            if (res1 > 0) {

            }else{
                JOptionPane.showInternalMessageDialog(pnlFondo, "Error al registrar","Aviso",JOptionPane.WARNING_MESSAGE);
                LimpiarCajas();
            }
            
        }
    }
    private void InsertDatosPersonales() throws SQLException{
                                
        preparedStatement=connection.prepareStatement("INSERT INTO datospersonales(nombre,apellido,cedula,sexo,correo,telefono,direccion,foto,inconvenientes,medidas,edad)VALUES(?,?,?,?,?,?,?,?,?,?,?)");
        preparedStatement.setString(1,this.txtNombre.getText());
        preparedStatement.setString(2,this.txtApellido.getText());
        preparedStatement.setInt(3,Integer.parseInt(this.txtCedula.getText()));
        preparedStatement.setString(4,this.cbSexo.getSelectedItem().toString());
        preparedStatement.setString(5,this.txtCorreo.getText());
        preparedStatement.setString(6,!this.txtTelefono.getText().equals("")?this.txtTelefono.getText():"");
        preparedStatement.setString(7,this.txtDireccion.getText());
        preparedStatement.setString(8,this.URLImagen);
        preparedStatement.setString(9,this.txtInconvenientes.getText());
        preparedStatement.setString(10,this.txtMedidas.getText());
        preparedStatement.setInt(11,Integer.parseInt(this.txtEdad.getText()));
        int res = preparedStatement.executeUpdate();

        if (res > 0) {
            e(0,btnGuardar);
        }else{
            JOptionPane.showInternalMessageDialog(pnlFondo, "Error al registrar","Aviso",JOptionPane.WARNING_MESSAGE);
            LimpiarCajas();
        }
    }
    
    private void InsertDatosEnTabla() throws SQLException{
        
        try{
            connection = Conectar.getConnection();
            st = connection.createStatement();
            resultSet = st.executeQuery("SELECT * FROM datospersonales");
            
            while(resultSet.next()){

                datos[2] = resultSet.getString("cedula");
                datos[0] = resultSet.getString("nombre");
                datos[1] = resultSet.getString("apellido");

                modelo.addRow(datos);
                
                InhabilitarDatosPersonales();
                InhabilitarDatosRepresentante();
            }

            tblAfiliados.setModel(modelo);
            
        }catch (SQLException ex){ JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(),"Aviso",JOptionPane.WARNING_MESSAGE); }
        
    }
    
    private void UpdateDatosPersonales() throws SQLException{
    
        preparedStatement = connection.prepareStatement("UPDATE datospersonales SET nombre='"+txtNombre.getText()+"',apellido='"+txtApellido.getText()+"',cedula='"+Integer.parseInt(txtCedula.getText())
            +"',correo='"+txtCorreo.getText()+"',telefono='"+txtTelefono.getText()+"',direccion='"+txtDireccion.getText()+"',sexo='"+cbSexo.getSelectedItem().toString()+"',foto='"+URLImagen
            +"',inconvenientes='"+txtInconvenientes.getText()+"',medidas='"+txtMedidas.getText()+"',edad='"+Integer.parseInt(txtEdad.getText())+"' WHERE cedula='"+cedula+"'");
        int res = preparedStatement.executeUpdate();

        if(res>0){
        }else{
            JOptionPane.showInternalMessageDialog(pnlFondo, "Error al modificar en la tabla Datos Personales","Aviso",JOptionPane.ERROR_MESSAGE);
            InhabilitarDatosPersonales();
            InhabilitarDatosRepresentante();
            v(0,btnGuardarCambios);
            v(1,btnEditar);
        }
    }
   
    private void UpdateDatosRepresentante() throws SQLException{

        preparedStatement = connection.prepareStatement("UPDATE datosrepresentante SET cedula=?,representante=?,nombrer=?,apellidor=?,telefonor=?,cedular=? WHERE cedula='"+cedula+"'");
        preparedStatement.setInt(1,Integer.parseInt(this.txtCedula.getText()));
        if(!cbRepresentante.getSelectedItem().equals("----------")){ preparedStatement.setString(2,this.cbRepresentante.getSelectedItem().toString());
        }else{ preparedStatement.setString(2,""); }
        if(!txtNombreR.getText().isEmpty()){ preparedStatement.setString(3,this.txtNombreR.getText());
        }else{ preparedStatement.setString(3,""); }
        if(!txtApellidoR.getText().isEmpty()){ preparedStatement.setString(4,this.txtApellidoR.getText());
        }else{ preparedStatement.setString(4,""); }
        if(!txtTelefonoR.getText().isEmpty()){ preparedStatement.setString(5,this.txtTelefonoR.getText());
        }else{ preparedStatement.setString(5,""); }
        if(!txtCedulaR.getText().isEmpty()){ preparedStatement.setInt(6,Integer.parseInt(this.txtCedulaR.getText()));
        }else{ preparedStatement.setInt(6,0); }
        int res3 = preparedStatement.executeUpdate();

        if(res3>0){
            timer.start();
            v(0,btnGuardarCambios);
            v(1,btnGuardar);
            e(0,btnGuardar);
        }else{
            JOptionPane.showInternalMessageDialog(pnlFondo, "Error al modificar en la tabla Datos Representante","Aviso",JOptionPane.ERROR_MESSAGE);
            InhabilitarDatosPersonales();
            InhabilitarDatosRepresentante();
            v(0,btnGuardarCambios);
            v(1,btnEditar);
        }
    }
    
    private void DeleteDatos(String tabla) throws SQLException{
        
        connection = Conectar.getConnection();
        preparedStatement = connection.prepareStatement("DELETE FROM "+tabla+" WHERE cedula=?");
        preparedStatement.setString(1, String.valueOf(cedula));
        int res = preparedStatement.executeUpdate();

        if(res > 0){
            if(tabla.equals("trayectokarate")){ //EL ULTIMO DELETE, PARA QUE NO APAREZCA EL MENSAJE CON CADA UNO
                JOptionPane.showMessageDialog(pnlFondo, "Usuario "+txtNombre.getText()+" "+txtApellido.getText()+" eliminado");
                LimpiarCajas();
            }
            LimpiarCajas();
        }else{
            //JOptionPane.showMessageDialog(pnlFondo, "Error al eliminar");
        }
        
    }
    
    public void setFiltroTexto(){
        //DE DATOS PERSONALES
        Helper.setFiltraEntrada(txtNombre.getDocument(), FiltraEntrada.SOLO_LETRAS, 20, false);
        Helper.setFiltraEntrada(txtApellido.getDocument(), FiltraEntrada.SOLO_LETRAS, 20, false);
        Helper.setFiltraEntrada(txtCedula.getDocument(), FiltraEntrada.SOLO_NUMEROS, 8, false);
        Helper.setFiltraEntrada(txtTelefono.getDocument(), FiltraEntrada.SOLO_NUMEROS, 11, false);
        Helper.setFiltraEntrada(txtEdad.getDocument(), FiltraEntrada.SOLO_NUMEROS, 2, false);
        
        //DE DATOS REPRESENTANTES
        Helper.setFiltraEntrada(txtNombreR.getDocument(), FiltraEntrada.SOLO_LETRAS, 20, false);
        Helper.setFiltraEntrada(txtApellidoR.getDocument(), FiltraEntrada.SOLO_LETRAS, 20, false);
        Helper.setFiltraEntrada(txtCedulaR.getDocument(), FiltraEntrada.SOLO_NUMEROS, 8, false);
        Helper.setFiltraEntrada(txtTelefonoR.getDocument(), FiltraEntrada.SOLO_NUMEROS, 11, false);

    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private elaprendiz.gui.label.LabelMetric APELLIDO;
    private elaprendiz.gui.label.LabelMetric APELLIDOR;
    private elaprendiz.gui.label.LabelMetric CEDULA;
    private elaprendiz.gui.label.LabelMetric CEDULAR;
    private elaprendiz.gui.label.LabelMetric CORREO;
    private elaprendiz.gui.label.LabelMetric DIRECCION;
    private elaprendiz.gui.label.LabelMetric EDAD;
    private elaprendiz.gui.label.LabelMetric FOTO;
    private elaprendiz.gui.label.LabelMetric INCONVENIENTES;
    private elaprendiz.gui.label.LabelMetric MEDIDAS;
    private elaprendiz.gui.label.LabelMetric NOMBRE;
    private elaprendiz.gui.label.LabelMetric NOMBRER;
    private elaprendiz.gui.label.LabelMetric REPRESENTANTE;
    private elaprendiz.gui.label.LabelMetric SEXO;
    private elaprendiz.gui.label.LabelMetric TELEFONO;
    private elaprendiz.gui.label.LabelMetric TELEFONOR;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar1;
    private elaprendiz.gui.button.ButtonTask btnFoto;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarCambios;
    private javax.swing.JButton btnNuevo;
    private elaprendiz.gui.comboBox.ComboBoxRectIcon cbBuscadorCategoria;
    private elaprendiz.gui.comboBox.ComboBoxRectIcon cbBuscar;
    private elaprendiz.gui.comboBox.ComboBoxRectIcon cbRepresentante;
    private elaprendiz.gui.comboBox.ComboBoxRectIcon cbSexo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblNombreCategoria;
    private javax.swing.JPanel pnlBuscador;
    private elaprendiz.gui.panel.PanelImage pnlBuscar;
    private elaprendiz.gui.panel.PanelCurves pnlCurvas;
    private elaprendiz.gui.panel.PanelImage pnlDatosCategoria;
    private elaprendiz.gui.panel.PanelTranslucido pnlDatosPersonales;
    private elaprendiz.gui.panel.PanelTranslucido pnlDatosRepresentante;
    private elaprendiz.gui.panel.PanelImage pnlFondo;
    private elaprendiz.gui.panel.PanelTranslucido pnlFoto;
    private elaprendiz.gui.panel.PanelImage pnlImagenFoto;
    private javax.swing.JPanel pnlTabla;
    private elaprendiz.gui.progressBar.ProgressBarRound progressbarBarra;
    private javax.swing.JScrollPane scrollDireccion;
    private javax.swing.JScrollPane scrollInconvenientes;
    private javax.swing.JScrollPane scrollMedidas;
    private javax.swing.JScrollPane scrollTabla;
    private javax.swing.JTable tblAfiliados;
    private elaprendiz.gui.textField.TextFieldRectIcon txtApellido;
    private elaprendiz.gui.textField.TextFieldRectIcon txtApellidoR;
    private elaprendiz.gui.textField.TextFieldRectIcon txtBuscar;
    private elaprendiz.gui.textField.TextFieldRectIcon txtCedula;
    private elaprendiz.gui.textField.TextFieldRectIcon txtCedulaR;
    private elaprendiz.gui.textField.TextFieldRectIcon txtCorreo;
    private javax.swing.JTextArea txtDireccion;
    private elaprendiz.gui.textField.TextFieldRectIcon txtEdad;
    private javax.swing.JTextArea txtInconvenientes;
    private javax.swing.JTextField txtInscripcion;
    private javax.swing.JTextArea txtMedidas;
    private javax.swing.JTextField txtMensualidad;
    private elaprendiz.gui.textField.TextFieldRectIcon txtNombre;
    private elaprendiz.gui.textField.TextFieldRectIcon txtNombreR;
    private elaprendiz.gui.textField.TextFieldRectIcon txtTelefono;
    private elaprendiz.gui.textField.TextFieldRectIcon txtTelefonoR;
    // End of variables declaration//GEN-END:variables
}
