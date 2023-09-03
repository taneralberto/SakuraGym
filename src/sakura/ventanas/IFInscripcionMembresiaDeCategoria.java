package sakura.ventanas;

import sakura.ventanas.*;
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
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import sakura.ventanas.paneles.pnlCategoria;
import sakura.ventanas.paneles.pnlInscripcion;

public class IFInscripcionMembresiaDeCategoria extends javax.swing.JInternalFrame implements Runnable{

    private float totalInscripcion = 0;
    private float totalMembresia = 0;
    
    //VARIABLES
    private int cedula = -1;
    private Timer timer;
    private Config cg = new Config();
    private DefaultComboBoxModel mComboBoxBuscar;
    private Vector cates = new Vector(5,2);
    private boolean varActPnlRepresentante = false;
    private int unavez = 2;
    private GregorianCalendar fechaActual = new GregorianCalendar();
    private Thread h1;
    private pnlInscripcion pnlInscripcion;
    private pnlCategoria pnlCategoria;

    //IMAGEN
    private FileInputStream imagen;
    private DatoArchivo dat;
    private String URLImagen = "";

    //CONEXIONES
    private Connection connection;

    //COLORES
    private final static Color azul = new Color(0, 203, 255);
    private final static Color amar = new Color(255, 255, 102);
    
    //TABLA BUSCAR
    private TableRowSorter trsFiltro;
    private DefaultTableModel modelo;
    private String[]datos;

    public IFInscripcionMembresiaDeCategoria() throws FileNotFoundException, IOException, SQLException {
        
        initComponents();
        
        h1 = new Thread(this);
        h1.start();

        tbbPaneles.add("Sakura", tbbSakura);
        tbbPaneles.add("Categorias", tbbCategorias);

        //AGREGA LAS CATEGORIAS EN LOS COMBOBOX
        mComboBoxBuscar = new DefaultComboBoxModel(cg.getCategorias().toArray());
        this.cbCategoria.setModel(mComboBoxBuscar); 

        v(0,cbBuscadorCategoria);
        v(0,btnFoto);
        v(0,pnlBuscar);
        vn(0,tbbCategorias);
        //vn(0,tbbSakura);

        timer = new Timer(10, new progreso());

        InhabilitarDatosPersonales();
        InhabilitarDatosInscripcion();
        LimpiarTablasTemporales();
        setFiltroTexto();
        
        /**********MOSTRAR COLUMNAS EN LA TABLA BUSCAR**********/
       
        modelo = new DefaultTableModel();
        datos = new String [4];

        modelo.addColumn("NOMBRE");
        modelo.addColumn("APELLIDO");
        modelo.addColumn("Nº CÉDULA");
        modelo.addColumn("CATEGORIA");
        
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
        pnlTabla = new javax.swing.JPanel();
        scrollTabla = new javax.swing.JScrollPane();
        tblAfiliados = new javax.swing.JTable();
        pnlCurvas = new elaprendiz.gui.panel.PanelCurves();
        pnlDatosPersonales = new elaprendiz.gui.panel.PanelTranslucido();
        FOTO = new elaprendiz.gui.label.LabelMetric();
        NOMBRE = new elaprendiz.gui.label.LabelMetric();
        APELLIDO = new elaprendiz.gui.label.LabelMetric();
        pnlFoto = new elaprendiz.gui.panel.PanelTranslucido();
        btnFoto = new elaprendiz.gui.button.ButtonTask();
        pnlImagenFoto = new elaprendiz.gui.panel.PanelImage();
        txtApellido = new elaprendiz.gui.textField.TextFieldRectIcon();
        txtCedula = new elaprendiz.gui.textField.TextFieldRectIcon();
        txtNombre = new elaprendiz.gui.textField.TextFieldRectIcon();
        btnBuscar = new javax.swing.JButton();
        CEDULA1 = new elaprendiz.gui.label.LabelMetric();
        pnlCalculadora = new elaprendiz.gui.panel.PanelTranslucido();
        TOTAL2 = new elaprendiz.gui.label.LabelMetric();
        txtTotal = new elaprendiz.gui.textField.TextFieldRectIcon();
        TOTAL = new elaprendiz.gui.label.LabelMetric();
        txtInscripcion = new elaprendiz.gui.textField.TextFieldRectIcon();
        TOTAL1 = new elaprendiz.gui.label.LabelMetric();
        txtMembresia = new elaprendiz.gui.textField.TextFieldRectIcon();
        btnGuardar = new javax.swing.JButton();
        TOTAL3 = new elaprendiz.gui.label.LabelMetric();
        cbTipoPago = new elaprendiz.gui.comboBox.ComboBoxRectIcon();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tbbPaneles = new elaprendiz.gui.tabbedPane.TabbedSelector2();
        cbCategoria = new elaprendiz.gui.comboBox.ComboBoxRectIcon();
        tbbSakura = new elaprendiz.gui.tabbedPane.TabbedPaneRound();
        tbbCategorias = new elaprendiz.gui.tabbedPane.TabbedPaneRound();
        btnEliminarCategoria = new javax.swing.JButton();
        btnRecuperarTablas = new elaprendiz.gui.button.ButtonIpod();
        CEDULA = new elaprendiz.gui.label.LabelMetric();
        progressbarBarra = new elaprendiz.gui.progressBar.ProgressBarRound();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setTitle("Inscripción - Membresía");
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

        pnlFondo.add(pnlBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, 70, 50));

        pnlCurvas.setBackground(new java.awt.Color(255, 0, 0));
        pnlCurvas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlDatosPersonales.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true), "Datos de personales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlDatosPersonales.setTran(0.0F);
        pnlDatosPersonales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        FOTO.setBackground(new java.awt.Color(255, 255, 255));
        FOTO.setForeground(new java.awt.Color(0, 0, 0));
        FOTO.setText("Foto");
        FOTO.setColorDeSombra(new java.awt.Color(255, 255, 51));
        FOTO.setDistanciaDeSombra(1);
        pnlDatosPersonales.add(FOTO, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 20));

        NOMBRE.setBackground(new java.awt.Color(255, 255, 255));
        NOMBRE.setForeground(new java.awt.Color(0, 0, 0));
        NOMBRE.setText("Nombre");
        NOMBRE.setColorDeSombra(new java.awt.Color(255, 255, 51));
        NOMBRE.setDistanciaDeSombra(1);
        pnlDatosPersonales.add(NOMBRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, 20));

        APELLIDO.setBackground(new java.awt.Color(255, 255, 255));
        APELLIDO.setForeground(new java.awt.Color(0, 0, 0));
        APELLIDO.setText("Apellido");
        APELLIDO.setColorDeSombra(new java.awt.Color(255, 255, 51));
        APELLIDO.setDistanciaDeSombra(1);
        pnlDatosPersonales.add(APELLIDO, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, -1, 20));

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

        txtApellido.setBackground(new java.awt.Color(0, 204, 255));
        txtApellido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 102), 3));
        txtApellido.setAnchoDeBorde(4.0F);
        txtApellido.setColorDeBorde(new java.awt.Color(255, 255, 102));
        txtApellido.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtApellido.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlDatosPersonales.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 150, 30));

        txtCedula.setBackground(new java.awt.Color(0, 204, 255));
        txtCedula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 102), 3));
        txtCedula.setAnchoDeBorde(4.0F);
        txtCedula.setColorDeBorde(new java.awt.Color(255, 255, 102));
        txtCedula.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtCedula.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCedula.setName(""); // NOI18N
        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });
        pnlDatosPersonales.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 150, 30));

        txtNombre.setBackground(new java.awt.Color(0, 204, 255));
        txtNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 102), 3));
        txtNombre.setAnchoDeBorde(4.0F);
        txtNombre.setColorDeBorde(new java.awt.Color(255, 255, 102));
        txtNombre.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txtNombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlDatosPersonales.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 150, 30));

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
        pnlDatosPersonales.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 130, 50));

        CEDULA1.setBackground(new java.awt.Color(255, 255, 255));
        CEDULA1.setForeground(new java.awt.Color(0, 0, 0));
        CEDULA1.setText("Nº Cédula");
        CEDULA1.setColorDeSombra(new java.awt.Color(255, 255, 51));
        CEDULA1.setDistanciaDeSombra(1);
        pnlDatosPersonales.add(CEDULA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, -1, 20));

        pnlCurvas.add(pnlDatosPersonales, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 340, 240));

        pnlCalculadora.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true), "Calculadora", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlCalculadora.setTran(0.0F);
        pnlCalculadora.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TOTAL2.setBackground(new java.awt.Color(255, 255, 255));
        TOTAL2.setForeground(new java.awt.Color(0, 0, 0));
        TOTAL2.setText("Forma de pago");
        TOTAL2.setColorDeSombra(new java.awt.Color(255, 255, 51));
        TOTAL2.setDistanciaDeSombra(1);
        pnlCalculadora.add(TOTAL2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 130, 20));

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(0, 204, 255));
        txtTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 102), 3));
        txtTotal.setAnchoDeBorde(4.0F);
        txtTotal.setColorDeBorde(new java.awt.Color(255, 255, 102));
        txtTotal.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTotal.setName(""); // NOI18N
        txtTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTotalKeyTyped(evt);
            }
        });
        pnlCalculadora.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 120, 30));

        TOTAL.setBackground(new java.awt.Color(255, 255, 255));
        TOTAL.setForeground(new java.awt.Color(0, 0, 0));
        TOTAL.setText("Inscripcion");
        TOTAL.setColorDeSombra(new java.awt.Color(255, 255, 51));
        TOTAL.setDistanciaDeSombra(1);
        pnlCalculadora.add(TOTAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 30, 130, 20));

        txtInscripcion.setEditable(false);
        txtInscripcion.setBackground(new java.awt.Color(0, 204, 255));
        txtInscripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 102), 3));
        txtInscripcion.setAnchoDeBorde(4.0F);
        txtInscripcion.setColorDeBorde(new java.awt.Color(255, 255, 102));
        txtInscripcion.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtInscripcion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtInscripcion.setName(""); // NOI18N
        txtInscripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtInscripcionKeyTyped(evt);
            }
        });
        pnlCalculadora.add(txtInscripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 120, 30));

        TOTAL1.setBackground(new java.awt.Color(255, 255, 255));
        TOTAL1.setForeground(new java.awt.Color(0, 0, 0));
        TOTAL1.setText("Membresia");
        TOTAL1.setColorDeSombra(new java.awt.Color(255, 255, 51));
        TOTAL1.setDistanciaDeSombra(1);
        pnlCalculadora.add(TOTAL1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 130, 20));

        txtMembresia.setEditable(false);
        txtMembresia.setBackground(new java.awt.Color(0, 204, 255));
        txtMembresia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 102), 3));
        txtMembresia.setAnchoDeBorde(4.0F);
        txtMembresia.setColorDeBorde(new java.awt.Color(255, 255, 102));
        txtMembresia.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtMembresia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtMembresia.setName(""); // NOI18N
        txtMembresia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMembresiaKeyTyped(evt);
            }
        });
        pnlCalculadora.add(txtMembresia, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 120, 30));

        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/btnGuardar.png"))); // NOI18N
        btnGuardar.setText("Pagar");
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
        pnlCalculadora.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 130, 60));

        TOTAL3.setBackground(new java.awt.Color(255, 255, 255));
        TOTAL3.setForeground(new java.awt.Color(0, 0, 0));
        TOTAL3.setText("Total");
        TOTAL3.setColorDeSombra(new java.awt.Color(255, 255, 51));
        TOTAL3.setDistanciaDeSombra(1);
        pnlCalculadora.add(TOTAL3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 130, 20));

        cbTipoPago.setBackground(new java.awt.Color(0, 204, 255));
        cbTipoPago.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 102), 2));
        cbTipoPago.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "----------", "Efectivo", "Debito", "Credito" }));
        cbTipoPago.setAnchoDeBorde(4.0F);
        cbTipoPago.setColorDeBorde(new java.awt.Color(255, 255, 102));
        pnlCalculadora.add(cbTipoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 130, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("=");
        pnlCalculadora.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 20, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("+");
        pnlCalculadora.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 20, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("+");
        pnlCalculadora.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 20, 30));

        pnlCurvas.add(pnlCalculadora, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 570, 190));

        tbbPaneles.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        tbbPaneles.setColorBackGround(new java.awt.Color(51, 204, 255));
        tbbPaneles.setColorDeBorde(new java.awt.Color(255, 255, 102));
        tbbPaneles.setColorDeSegundoBorde(new java.awt.Color(255, 255, 102));
        tbbPaneles.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        pnlCurvas.add(tbbPaneles, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 910, 330));

        cbCategoria.setBackground(new java.awt.Color(0, 204, 255));
        cbCategoria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 102)));
        cbCategoria.setAnchoDeBorde(4.0F);
        cbCategoria.setColorDeBorde(new java.awt.Color(255, 255, 102));
        cbCategoria.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCategoriaItemStateChanged(evt);
            }
        });
        pnlCurvas.add(cbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, 160, 30));
        pnlCurvas.add(tbbSakura, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 260, 60, 30));
        pnlCurvas.add(tbbCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 260, 60, 30));

        btnEliminarCategoria.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEliminarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/btnLEliminar.png"))); // NOI18N
        btnEliminarCategoria.setText("Eliminar categoria");
        btnEliminarCategoria.setBorder(null);
        btnEliminarCategoria.setBorderPainted(false);
        btnEliminarCategoria.setContentAreaFilled(false);
        btnEliminarCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarCategoria.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/btnLEliminarRellover.png"))); // NOI18N
        btnEliminarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCategoriaActionPerformed(evt);
            }
        });
        pnlCurvas.add(btnEliminarCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 270, -1, -1));

        btnRecuperarTablas.setBorder(null);
        btnRecuperarTablas.setForeground(new java.awt.Color(0, 0, 0));
        btnRecuperarTablas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/ButtonRefrescarNormal.png"))); // NOI18N
        btnRecuperarTablas.setText("Recuperar");
        btnRecuperarTablas.setColorDeSombra(new java.awt.Color(255, 255, 255));
        btnRecuperarTablas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnRecuperarTablas.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnRecuperarTablas.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnRecuperarTablas.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnRecuperarTablas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecuperarTablasActionPerformed(evt);
            }
        });
        pnlCurvas.add(btnRecuperarTablas, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 250, 80, 60));

        CEDULA.setBackground(new java.awt.Color(255, 255, 255));
        CEDULA.setForeground(new java.awt.Color(0, 0, 0));
        CEDULA.setText("Agregar categoria");
        CEDULA.setColorDeSombra(new java.awt.Color(255, 255, 51));
        CEDULA.setDistanciaDeSombra(1);
        pnlCurvas.add(CEDULA, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, -1, 20));

        pnlFondo.add(pnlCurvas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 670));

        progressbarBarra.setBackground(new java.awt.Color(0, 204, 255));
        progressbarBarra.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        progressbarBarra.setForeground(new java.awt.Color(255, 255, 0));
        progressbarBarra.setToolTipText("");
        progressbarBarra.setBorde(5.0F);
        progressbarBarra.setBorderPainted(false);
        progressbarBarra.setColorDeBorde(new java.awt.Color(0, 0, 0));
        progressbarBarra.setDistanciaDeSombra(5);
        progressbarBarra.setFont(new java.awt.Font("SunnySide", 1, 36)); // NOI18N
        progressbarBarra.setString("Inscripción - Membresía");
        progressbarBarra.setStringPainted(true);
        pnlFondo.add(progressbarBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 520, 60));

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

        try {
            TVtblAfiliadosMouseClicked();
        } catch (SQLException ex) {
            JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
        }
       
    }//GEN-LAST:event_tblAfiliadosMouseClicked

    private void pnlBuscadorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBuscadorMousePressed
    }//GEN-LAST:event_pnlBuscadorMousePressed

    private void pnlBuscadorMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBuscadorMouseDragged
    }//GEN-LAST:event_pnlBuscadorMouseDragged

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        //******************************CATEGORÍA******************************//
        
        //*****INSCRIPCIÓN*****//
        
        try{
            connection = Conectar.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM temporalestadoinscripcioncategoria WHERE cedula='"+cedula+"'");
            ResultSet res = ps.executeQuery();

            while(res.next()){
                connection = Conectar.getConnection();
                PreparedStatement ps3 = connection.prepareStatement("SELECT * FROM estadoinscripcioncategoria WHERE cedula='"+cedula+"' AND categoria='"+res.getString("categoria")+"'");
                ResultSet res3 = ps3.executeQuery();

                if(!res3.next()){
                    PreparedStatement ps1 = connection.prepareStatement("INSERT INTO estadoinscripcioncategoria(cedula,costo,categoria,fechainscripcion,fechavenceinscripcion,fechapago,vencimiento)VALUES (?,?,?,?,?,?,?)");
                    ps1.setInt(1, res.getInt("cedula"));
                    ps1.setFloat(2, res.getFloat("costo"));
                    ps1.setString(3, res.getString("categoria"));
                    ps1.setDate(4, res.getDate("fechainscripcion"));
                    ps1.setDate(5, res.getDate("fechavenceinscripcion"));
                    ps1.setDate(6, res.getDate("fechapago"));
                    ps1.setString(7, res.getString("vencimiento"));
                    int res1 = ps1.executeUpdate();

                    if(res1 > 0){
                        tbbCategorias.removeAll();
                        InsertarCategorias();
                        //InhabilitarDatosInscripcion();

                    }else{ 
                        JOptionPane.showInternalMessageDialog(pnlFondo, "Error al registrar","Aviso",JOptionPane.ERROR_MESSAGE);
                    }
                    
                    if(res.getString("vencimiento").equals("Indefinido")){
                            
                        PreparedStatement ps4 = connection.prepareStatement("DELETE FROM estadomembresiacategoria WHERE cedula = '"+res.getInt("cedula")+"' AND categoria = '"+res.getString("categoria")+"'");
                        int res4 = ps4.executeUpdate();

                        if(res4 > 0){

                        }
                    }

                }else{
                    PreparedStatement ps2 = connection.prepareStatement("UPDATE estadoinscripcioncategoria SET costo=?,categoria=?,fechainscripcion=?,fechavenceinscripcion=?,fechapago=?,vencimiento=? WHERE cedula='"+res.getInt("cedula")+"' AND categoria='"+res.getString("categoria")+"'");
                    ps2.setFloat(1, res.getFloat("costo"));
                    ps2.setString(2, res.getString("categoria"));
                    ps2.setDate(3, res.getDate("fechainscripcion"));
                    ps2.setDate(4, res.getDate("fechavenceinscripcion"));
                    ps2.setDate(5, res.getDate("fechapago"));
                    ps2.setString(6, res.getString("vencimiento"));
                    int res2 = ps2.executeUpdate();

                    if(res2>0){
                        tbbCategorias.removeAll();
                        InsertarCategorias();
                        //InhabilitarDatosInscripcion();
                        JOptionPane.showInternalMessageDialog(pnlFondo, "Renovado con éxito","Aviso",JOptionPane.INFORMATION_MESSAGE);
       
                    }else{
                        JOptionPane.showInternalMessageDialog(pnlFondo, "Error al modificar","Aviso",JOptionPane.ERROR_MESSAGE);
                    }
                    
                    if(res.getString("vencimiento").equals("Indefinido")){
                            
                        PreparedStatement ps4 = connection.prepareStatement("DELETE FROM estadomembresiacategoria WHERE cedula = '"+res.getInt("cedula")+"' AND categoria = '"+res.getString("categoria")+"'");
                        int res4 = ps4.executeUpdate();

                        if(res4 > 0){
                            tbbCategorias.removeAll();
                            InsertarCategorias();
                        }
                    }
                }
            }

        }catch(SQLException ex){ JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE); 
        }catch (IOException ex) { JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE); }

        //*****MEMBRESIA*****//
        
        try{
            connection = Conectar.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM temporalestadomembresiacategoria WHERE cedula='"+cedula+"'");
            ResultSet res = ps.executeQuery();

            while(res.next()){
                connection = Conectar.getConnection();
                PreparedStatement ps3 = connection.prepareStatement("SELECT * FROM estadomembresiacategoria WHERE cedula='"+cedula+"' AND categoria='"+res.getString("categoria")+"'");
                ResultSet res3 = ps3.executeQuery();

                if(!res3.next()){
                    PreparedStatement ps1 = connection.prepareStatement("INSERT INTO estadomembresiacategoria(cedula,costo,categoria,fechamembresia,fechavencemembresia,fechapago,vencimiento)VALUES (?,?,?,?,?,?,?)");
                    ps1.setInt(1, res.getInt("cedula"));
                    ps1.setFloat(2, res.getFloat("costo"));
                    ps1.setString(3, res.getString("categoria"));
                    ps1.setDate(4, res.getDate("fechamembresia"));
                    ps1.setDate(5, res.getDate("fechavencemembresia"));
                    ps1.setDate(6, res.getDate("fechapago"));
                    ps1.setString(7, res.getString("vencimiento"));
                    int res1 = ps1.executeUpdate();

                    if(res1 > 0){
                        tbbCategorias.removeAll();
                        InsertarCategorias();
                        //InhabilitarDatosInscripcion();

                    }else{ 
                        JOptionPane.showInternalMessageDialog(pnlFondo, "Error al registrar","Aviso",JOptionPane.ERROR_MESSAGE);
                    }

                }else{
                    PreparedStatement ps2 = connection.prepareStatement("UPDATE estadomembresiacategoria SET costo=?,categoria=?,fechamembresia=?,fechavencemembresia=?,fechapago=?,vencimiento=? WHERE cedula='"+res.getInt("cedula")+"' AND categoria='"+res.getString("categoria")+"'");
                    ps2.setFloat(1, res.getFloat("costo"));
                    ps2.setString(2, res.getString("categoria"));
                    ps2.setDate(3, res.getDate("fechamembresia"));
                    ps2.setDate(4, res.getDate("fechavencemembresia"));
                    ps2.setDate(5, res.getDate("fechapago"));
                    ps2.setString(6, res.getString("vencimiento"));
                    int res2 = ps2.executeUpdate();

                    if(res2>0){
                        tbbCategorias.removeAll();
                        InsertarCategorias();
                        //InhabilitarDatosInscripcion();
                        JOptionPane.showInternalMessageDialog(pnlFondo, "Renovado con éxito","Aviso",JOptionPane.INFORMATION_MESSAGE);

                    }else{
                        JOptionPane.showInternalMessageDialog(pnlFondo, "Error al modificar","Aviso",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

        }catch(SQLException ex){ JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE); 
        }catch (IOException ex) { JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE); }

        /*try {
            LimpiarTablasTemporales();
        } catch (SQLException ex) {
            JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(),"ERROR", JOptionPane.PLAIN_MESSAGE);
        }*/
        
        //******************************SAKURA******************************//
        
        //*****INSCRIPCIÓN*****//
        
        try{
            connection = Conectar.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM temporalestadoinscripcionsakura WHERE cedula='"+cedula+"'");
            ResultSet res = ps.executeQuery();

            while(res.next()){
                connection = Conectar.getConnection();
                PreparedStatement ps3 = connection.prepareStatement("SELECT * FROM estadoinscripcionsakura WHERE cedula='"+cedula+"'");
                ResultSet res3 = ps3.executeQuery();

                if(!res3.next()){
                    PreparedStatement ps1 = connection.prepareStatement("INSERT INTO estadoinscripcionsakura(cedula,costo,fechainscripcion,fechavenceinscripcion,fechapago,vencimiento)VALUES(?,?,?,?,?,?)");
                    ps1.setInt(1, res.getInt("cedula"));
                    ps1.setFloat(2, res.getFloat("costo"));
                    ps1.setDate(3, res.getDate("fechainscripcion"));
                    ps1.setDate(4, res.getDate("fechavenceinscripcion"));
                    ps1.setDate(5, res.getDate("fechapago"));
                    ps1.setString(6, res.getString("vencimiento"));
                    int res1 = ps1.executeUpdate();

                    if(res1 > 0){
                        tbbSakura.removeAll();
                        InsertarSakura();
                        //InhabilitarDatosInscripcion();

                    }else{ 
                        JOptionPane.showInternalMessageDialog(pnlFondo, "Error al registrar","Aviso",JOptionPane.ERROR_MESSAGE);
                    }
                    
                    if(res.getString("vencimiento").equals("Indefinido")){
                            
                        PreparedStatement ps4 = connection.prepareStatement("DELETE FROM estadomembresiasakura WHERE cedula = '"+res.getInt("cedula")+"'");
                        int res4 = ps4.executeUpdate();

                        if(res4 > 0){

                        }
                    }

                }else{
                    PreparedStatement ps2 = connection.prepareStatement("UPDATE estadoinscripcionsakura SET costo=?,fechainscripcion=?,fechavenceinscripcion=?,fechapago=?,vencimiento=? WHERE cedula='"+res.getInt("cedula")+"'");
                    ps2.setFloat(1, res.getFloat("costo"));
                    ps2.setDate(2, res.getDate("fechainscripcion"));
                    ps2.setDate(3, res.getDate("fechavenceinscripcion"));
                    ps2.setDate(4, res.getDate("fechapago"));
                    ps2.setString(5, res.getString("vencimiento"));
                    int res2 = ps2.executeUpdate();

                    if(res2>0){
                        tbbSakura.removeAll();
                        InsertarSakura();
                        //InhabilitarDatosInscripcion();
                        JOptionPane.showInternalMessageDialog(pnlFondo, "Renovado con éxito","Aviso",JOptionPane.INFORMATION_MESSAGE);
       
                    }else{
                        JOptionPane.showInternalMessageDialog(pnlFondo, "Error al modificar","Aviso",JOptionPane.ERROR_MESSAGE);
                    }
                    
                    if(res.getString("vencimiento").equals("Indefinido")){
                            
                        PreparedStatement ps4 = connection.prepareStatement("DELETE FROM estadomembresiasakura WHERE cedula = '"+res.getInt("cedula")+"'");
                        int res4 = ps4.executeUpdate();

                        if(res4 > 0){
                            tbbSakura.removeAll();
                            InsertarSakura();
                        }
                    }
                }
            }

        }catch(SQLException ex){ JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE); 
        }catch (IOException ex) { JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE); }

        //*****MEMBRESIA*****//
        
        try{
            connection = Conectar.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM temporalestadomembresiasakura WHERE cedula='"+cedula+"'");
            ResultSet res = ps.executeQuery();

            while(res.next()){
                connection = Conectar.getConnection();
                PreparedStatement ps3 = connection.prepareStatement("SELECT * FROM estadomembresiasakura WHERE cedula='"+cedula+"'");
                ResultSet res3 = ps3.executeQuery();

                if(!res3.next()){
                    PreparedStatement ps1 = connection.prepareStatement("INSERT INTO estadomembresiasakura(cedula,costo,fechamembresia,fechavencemembresia,fechapago,vencimiento)VALUES (?,?,?,?,?,?)");
                    ps1.setInt(1, res.getInt("cedula"));
                    ps1.setFloat(2, res.getFloat("costo"));
                    ps1.setDate(3, res.getDate("fechamembresia"));
                    ps1.setDate(4, res.getDate("fechavencemembresia"));
                    ps1.setDate(5, res.getDate("fechapago"));
                    ps1.setString(6, res.getString("vencimiento"));
                    int res1 = ps1.executeUpdate();

                    if(res1 > 0){
                        tbbSakura.removeAll();
                        InsertarSakura();
                        //InhabilitarDatosInscripcion();

                    }else{ 
                        JOptionPane.showInternalMessageDialog(pnlFondo, "Error al registrar","Aviso",JOptionPane.ERROR_MESSAGE);
                    }

                }else{
                    PreparedStatement ps2 = connection.prepareStatement("UPDATE estadomembresiasakura SET costo=?,fechamembresia=?,fechavencemembresia=?,fechapago=?,vencimiento=? WHERE cedula='"+res.getInt("cedula")+"'");
                    ps2.setFloat(1, res.getFloat("costo"));
                    ps2.setDate(2, res.getDate("fechamembresia"));
                    ps2.setDate(3, res.getDate("fechavencemembresia"));
                    ps2.setDate(4, res.getDate("fechapago"));
                    ps2.setString(5, res.getString("vencimiento"));
                    int res2 = ps2.executeUpdate();

                    if(res2>0){
                        tbbSakura.removeAll();
                        InsertarSakura();
                        //InhabilitarDatosInscripcion();
                        JOptionPane.showInternalMessageDialog(pnlFondo, "Renovado con éxito","Aviso",JOptionPane.INFORMATION_MESSAGE);

                    }else{
                        JOptionPane.showInternalMessageDialog(pnlFondo, "Error al modificar","Aviso",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

        }catch(SQLException ex){ JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE); 
        }catch (IOException ex) { JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE); }

        try {
            LimpiarTablasTemporales();
        } catch (SQLException ex) {
            JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(),"ERROR", JOptionPane.PLAIN_MESSAGE);
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        TVbtnBuscarActionPerformed();
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped
    }//GEN-LAST:event_txtCedulaKeyTyped

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

    private void cbCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCategoriaItemStateChanged
    
    if(unavez % 2 == 0){
        
        String cateSeleccionada = cbCategoria.getSelectedItem().toString();
        cates.addElement(cateSeleccionada);

        for(int i=0; i<cates.size(); i++){
            for(int j=0; j<cates.size()-1; j++){
                if(i != j){
                    if(cates.elementAt(i) == cates.elementAt(j)){
                        cates.remove(i);
                    }
                }
            }
        }

        try{
            connection = Conectar.getConnection();
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM configcategoria WHERE categoria='"+cbCategoria.getSelectedItem().toString()+"'");
            
            while(resultSet.next()){

                pnlCategoria = new pnlCategoria(txtCedula.getText(),resultSet.getString("categoria"), resultSet.getFloat("inscripcion"), resultSet.getFloat("mensualidad"), resultSet.getString("instructor"), resultSet.getString("dias"));
                tbbCategorias.add(resultSet.getString("categoria"),pnlCategoria);

                for(int j=0; j<tbbCategorias.getTabCount(); j++){
                    for(int k=0; k<tbbCategorias.getTabCount()-1; k++){
                        if(j != k){
                            if(tbbCategorias.getTitleAt(j).equals(tbbCategorias.getTitleAt(k))){
                                tbbCategorias.remove(j);
                            }
                        }
                    }
                }
            }
            
        }catch(SQLException ex){ JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(),"Aviso",JOptionPane.ERROR_MESSAGE); 
        }catch (IOException ex) { JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(),"Aviso",JOptionPane.ERROR_MESSAGE); }

        unavez = unavez + 1;

    }else{
        System.out.println("NO "+unavez);
        unavez = unavez - 1;
    }

        
    }//GEN-LAST:event_cbCategoriaItemStateChanged

    private void txtInscripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtInscripcionKeyTyped
    }//GEN-LAST:event_txtInscripcionKeyTyped

    private void txtMembresiaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMembresiaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMembresiaKeyTyped

    private void txtTotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalKeyTyped

    private void btnFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFotoActionPerformed

    }//GEN-LAST:event_btnFotoActionPerformed

    private void btnFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFotoMouseClicked

        TVpnlFotoYbtnFotoMouseClicked();
    }//GEN-LAST:event_btnFotoMouseClicked

    private void btnEliminarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCategoriaActionPerformed

        int confirmar =JOptionPane.showConfirmDialog(pnlFondo,"¿Desea eliminar la categoria?");

        if(JOptionPane.OK_OPTION == confirmar){

            try{
                connection = Conectar.getConnection();
                PreparedStatement ps = connection.prepareStatement("DELETE FROM estadoinscripcioncategoria WHERE cedula = '"+cedula+"' AND categoria = '"+tbbCategorias.getTitleAt(tbbCategorias.getModel().getSelectedIndex())+"'");
                int res = ps.executeUpdate();

                if(res > 0){
                    
                }
                
                connection = Conectar.getConnection();
                PreparedStatement ps3 = connection.prepareStatement("DELETE FROM estadomembresiacategoria WHERE cedula = '"+cedula+"' AND categoria = '"+tbbCategorias.getTitleAt(tbbCategorias.getModel().getSelectedIndex())+"'");
                int res3 = ps3.executeUpdate();

                if(res3 > 0){
                    
                }
                
                connection = Conectar.getConnection();
                PreparedStatement ps2 = connection.prepareStatement("DELETE FROM temporalestadoinscripcioncategoria WHERE cedula = '"+cedula+"' AND categoria = '"+tbbCategorias.getTitleAt(tbbCategorias.getModel().getSelectedIndex())+"'");
                int res2 = ps2.executeUpdate();

                if(res2 > 0){
                    
                }
                
                connection = Conectar.getConnection();
                PreparedStatement ps4 = connection.prepareStatement("DELETE FROM temporalestadomembresiacategoria WHERE cedula = '"+cedula+"' AND categoria = '"+tbbCategorias.getTitleAt(tbbCategorias.getModel().getSelectedIndex())+"'");
                int res4 = ps4.executeUpdate();

                if(res4 > 0){
                    
                }
                
                tbbCategorias.removeAll();
                InsertarCategorias();
                
            }catch(SQLException ex){ JOptionPane.showInternalMessageDialog(pnlFondo, "Error SQL: "+ex.getMessage(),"ERROR SQL", JOptionPane.PLAIN_MESSAGE); 
            }catch (IOException ex){ JOptionPane.showInternalMessageDialog(pnlFondo, "Error IO: "+ex.getMessage(),"ERROR IO", JOptionPane.PLAIN_MESSAGE); }
        }
    }//GEN-LAST:event_btnEliminarCategoriaActionPerformed

    private void btnRecuperarTablasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecuperarTablasActionPerformed
        
        try {
            tbbCategorias.removeAll();
            cbCategoria.setSelectedItem("----------");
            InsertarCategorias();
            LimpiarTablasTemporales();
            cates.removeAllElements();
        }catch(SQLException ex){
            JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(),"ERROR", JOptionPane.PLAIN_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(),"ERROR", JOptionPane.PLAIN_MESSAGE);
        }
        
    }//GEN-LAST:event_btnRecuperarTablasActionPerformed

    public void run(){
        
        Thread ct = Thread.currentThread();
        
        while(ct == h1){
            calculaCategorias();

            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                JOptionPane.showMessageDialog(pnlFondo,"Error: "+e.getMessage());
            }
        }
    }
    
    private void calculaCategorias(){
        
        float inscripcion = 0;
        float membresia = 0;
        totalInscripcion = 0;
        totalMembresia = 0;
        
        try{
            connection = Conectar.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM temporalestadoinscripcioncategoria");
            ResultSet res = ps.executeQuery();
                
            while(res.next()){
                inscripcion = res.getFloat("costo");
                totalInscripcion = totalInscripcion + inscripcion;
            }
            txtInscripcion.setText(totalInscripcion+" Bs.");

        }catch(SQLException ex){ JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(), "ERROR", JOptionPane.PLAIN_MESSAGE); }
        
        try{
            connection = Conectar.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM temporalestadoinscripcionsakura");
            ResultSet res = ps.executeQuery();
                
            while(res.next()){
                inscripcion = res.getFloat("costo");
                totalInscripcion = totalInscripcion + inscripcion;
            }
            txtInscripcion.setText(totalInscripcion+" Bs.");

        }catch(SQLException ex){ JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(), "ERROR", JOptionPane.PLAIN_MESSAGE); }
            
        try{
            connection = Conectar.getConnection();
            PreparedStatement ps1 = connection.prepareStatement("SELECT * FROM temporalestadomembresiacategoria");
            ResultSet res1 = ps1.executeQuery();
                
            while(res1.next()){
                membresia = res1.getFloat("costo");
                totalMembresia = totalMembresia + membresia;
            }
            txtMembresia.setText(totalMembresia+" Bs.");
            
        }catch(SQLException ex){ JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(), "ERROR", JOptionPane.PLAIN_MESSAGE); }
        
        try{
            connection = Conectar.getConnection();
            PreparedStatement ps1 = connection.prepareStatement("SELECT * FROM temporalestadomembresiasakura");
            ResultSet res1 = ps1.executeQuery();
                
            while(res1.next()){
                membresia = res1.getFloat("costo");
                totalMembresia = totalMembresia + membresia;
            }
            txtMembresia.setText(totalMembresia+" Bs.");
            
        }catch(SQLException ex){ JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(), "ERROR", JOptionPane.PLAIN_MESSAGE); }
                
        txtTotal.setText(String.valueOf(cbTipoPago.getSelectedItem().toString().equals("Debito")||cbTipoPago.getSelectedItem().toString().equals("Credito")?((totalInscripcion + totalMembresia)-(totalInscripcion + totalMembresia)*0.05)+" Bs.":totalInscripcion+totalMembresia+" Bs."));
        
    }
    
    /*private void calculaCategorias(){
        
        float inscripcion = 0;
        float membresia = 0;
        totalInscripcion = 0;
        totalMembresia = 0;
        
        try{
            connection = Conectar.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM temporalestadoinscripcioncategoria");
            ResultSet res = ps.executeQuery();
                
            while(res.next()){
                inscripcion = res.getFloat("costo");
                totalInscripcion = totalInscripcion + inscripcion;
            }
            txtInscripcion.setText(totalInscripcion+" Bs.");

        }catch(SQLException ex){ JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(), "ERROR", JOptionPane.PLAIN_MESSAGE); }
            
        try{
            connection = Conectar.getConnection();
            PreparedStatement ps1 = connection.prepareStatement("SELECT * FROM temporalestadomembresiacategoria");
            ResultSet res1 = ps1.executeQuery();
                
            while(res1.next()){
                membresia = res1.getFloat("costo");
                totalMembresia = totalMembresia + membresia;
            }
            txtMembresia.setText(totalMembresia+" Bs.");
            
        }catch(SQLException ex){ JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(), "ERROR", JOptionPane.PLAIN_MESSAGE); }
                
        txtTotal.setText(String.valueOf(cbTipoPago.getSelectedItem().toString().equals("Debito")||cbTipoPago.getSelectedItem().toString().equals("Credito")?((totalInscripcion + totalMembresia)-(totalInscripcion + totalMembresia)*0.05)+" Bs.":totalInscripcion+totalMembresia+" Bs."));
        
    }*/
    
    public void HabilitarDatosPersonales(){

        this.txtNombre.setEditable(true);
        this.txtApellido.setEditable(true);
        this.txtCedula.setEditable(true);
        e(1,pnlFoto);
        v(1,btnFoto);
        
        this.txtNombre.setBackground(amar);
        this.txtApellido.setBackground(amar);
        this.txtCedula.setBackground(amar);
        this.pnlFoto.setBackground(amar);

        //
        this.NOMBRE.setColorDeSombra(azul);
        this.APELLIDO.setColorDeSombra(azul);
        this.CEDULA.setColorDeSombra(azul);
        this.FOTO.setColorDeSombra(azul);
        
        this.txtNombre.setAnchoDeBorde(3.0F);
        this.txtApellido.setAnchoDeBorde(3.0F);
        this.txtCedula.setAnchoDeBorde(3.0F);
        
        this.txtNombre.setColorDeBorde(new java.awt.Color(0,0,0));
        this.txtApellido.setColorDeBorde(new java.awt.Color(0,0,0));
        this.txtCedula.setColorDeBorde(new java.awt.Color(0,0,0));
        this.pnlFoto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        this.pnlFoto.setColorPrimario(new java.awt.Color(255, 255, 255));
        this.pnlFoto.setColorSecundario(new java.awt.Color(255, 255, 103));
        this.pnlImagenFoto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        
    }
    
    private void InhabilitarDatosPersonales(){
        
        this.txtNombre.setEditable(false);
        this.txtApellido.setEditable(false);
        this.txtCedula.setEditable(false);
        e(0,pnlFoto);
        v(0,btnFoto);

        this.txtNombre.setBackground(azul);
        this.txtApellido.setBackground(azul);
        this.txtCedula.setBackground(azul);
        this.pnlFoto.setBackground(azul);

        //
        this.NOMBRE.setColorDeSombra(amar);
        this.APELLIDO.setColorDeSombra(amar);
        this.CEDULA.setColorDeSombra(amar);
        this.FOTO.setColorDeSombra(amar);
        
        this.txtNombre.setAnchoDeBorde(4.0F);
        this.txtApellido.setAnchoDeBorde(4.0F);
        this.txtCedula.setAnchoDeBorde(4.0F);
        
        this.txtNombre.setColorDeBorde(new java.awt.Color(255,255,102));
        this.txtApellido.setColorDeBorde(new java.awt.Color(255,255,102));
        this.txtCedula.setColorDeBorde(new java.awt.Color(255,255,102));
        this.pnlFoto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255,255,102), 3, true));
        this.pnlFoto.setColorPrimario(new java.awt.Color(255, 255, 255));
        this.pnlFoto.setColorSecundario(new java.awt.Color(0,204,255));
        this.pnlImagenFoto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255,255,102), 3, true));
  
    }
    
    private void HabilitarDatosInscripcion(){

        e(1,cbCategoria);
        
        this.cbCategoria.setBackground(amar);

        //this.HASTA1.setColorDeSombra(azul);

        this.cbCategoria.setAnchoDeBorde(3.0F);

        this.cbCategoria.setColorDeBorde(new java.awt.Color(0,0,0));   
    }
    
    private void InhabilitarDatosInscripcion(){

        e(0,cbCategoria);

        this.cbCategoria.setBackground(azul);

        //this.FECHA2.setColorDeSombra(amar);

        this.cbCategoria.setAnchoDeBorde((4.0F));

        this.cbCategoria.setColorDeBorde(new java.awt.Color(255,255,102));
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
                n++;
                progressbarBarra.setValue(n);
       
                if(progressbarBarra.getValue() == 100){
                    JOptionPane.showInternalMessageDialog(pnlFondo, "Accion realizada con éxito","Aviso",JOptionPane.INFORMATION_MESSAGE);

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
    
    private void TVtblAfiliadosMouseClicked() throws SQLException{

        tbbCategorias.removeAll();
        tbbSakura.removeAll();
        LimpiarTablasTemporales();
        txtCedula.setText(null);

        try{
            //InsertarCategorias();
            
            int fila = tblAfiliados.getSelectedRow();
            int filaModel = tblAfiliados.convertRowIndexToModel(fila); //CONVIERTE LA FILA AL MODELO

            tblAfiliados.convertRowIndexToView(filaModel); //CONVIERTE LA FILA A LA VISTA
            modelo.fireTableDataChanged(); //POR SI HAY ALGUN ERROR, AVISA QUE LA TABLA HA CAMBIADO

            String tableClick = (tblAfiliados.getModel().getValueAt(filaModel, 2).toString());

            connection = Conectar.getConnection();
            PreparedStatement pst = connection.prepareStatement("SELECT * FROM datospersonales WHERE cedula = '"+tableClick+"'");
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                
                String add1 = rs.getString("nombre"); this.txtNombre.setText(add1);

                String add2 = rs.getString("apellido"); this.txtApellido.setText(add2);

                String add3 = rs.getString("cedula"); this.txtCedula.setText(add3); cedula = Integer.parseInt(add3);

                String add4 = rs.getString("foto"); this.URLImagen = add4;
                this.pnlImagenFoto.setIcon(new ImageIcon(System.getProperty("user.dir")+"/fotos/"+add4));
                this.pnlImagenFoto.updateUI();
                                
                HabilitarDatosInscripcion();
                
                //tbbPaneles.removeAll();
                //tbbSakura.removeAll();
                
                //tbbPaneles.add("Sakura", tbbSakura);
                //tbbPaneles.add("Categorias", tbbCategorias);
                //pnlInscripcion = null;
                InsertarSakura();
                
                                
                /*pnlInscripcion = new pnlInscripcion(String.valueOf(add3));
                tbbSakura.add("Sakura Gym",pnlInscripcion);*/
            }
            
            PreparedStatement pst1 = connection.prepareStatement("SELECT * FROM estadoinscripcioncategoria WHERE cedula = '"+tableClick+"'");
            ResultSet rs1 = pst1.executeQuery();

            while(rs1.next()){
                
                String add1 = rs1.getString("categoria");
                //cates.add(add1);
                
                PreparedStatement pst2 = connection.prepareStatement("SELECT * FROM configcategoria WHERE categoria = '"+add1+"'");
                ResultSet rs2 = pst2.executeQuery();
                
                while(rs2.next()){
                    
                    pnlCategoria = new pnlCategoria(txtCedula.getText(),rs1.getString("categoria"), rs2.getFloat("inscripcion"), rs2.getFloat("mensualidad"), rs2.getString("instructor"), rs2.getString("dias"));
                    tbbCategorias.add(rs2.getString("categoria"),pnlCategoria);
                }

            }
            
            

        }catch(SQLException e){ JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+e.getMessage(),"Aviso",JOptionPane.WARNING_MESSAGE); 
        }catch (IOException ex){ JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(),"Aviso",JOptionPane.WARNING_MESSAGE); }

        if(URLImagen.equals("")){
            v(0,btnFoto);
            this.pnlImagenFoto.setIcon(new ImageIcon(System.getProperty("user.dir")+"/src/sakura/resources/botones/foto.png"));       
        }else{ v(0,btnFoto); }

        v(1,tbbCategorias);
        //v(1,tbbSakura);
    }
        
    
    private void TVbtnBuscarActionPerformed(){

        modelo.setRowCount(0);

        try{
            InsertDatosEnTablaBuscar();
            cbCategoria.setSelectedItem("----------");
        }catch(SQLException ex){ JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(),"Aviso",JOptionPane.ERROR_MESSAGE); }
        
        v(1,pnlBuscar);
        JOptionPane.showInternalMessageDialog(pnlFondo, pnlBuscar,"Buscador-Afiliados",JOptionPane.PLAIN_MESSAGE);
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
    
    private void InsertDatosEnTablaBuscar() throws SQLException{
        
        try{
            connection = Conectar.getConnection();
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM datospersonales");
            
            while(resultSet.next()){
                
                datos[2] = resultSet.getString("cedula");
                datos[0] = resultSet.getString("nombre");
                datos[1] = resultSet.getString("apellido");
                
                modelo.addRow(datos);
                
                InhabilitarDatosPersonales();
                InhabilitarDatosInscripcion();
            }

            tblAfiliados.setModel(modelo);
            
        }catch (SQLException ex){ JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(),"Aviso",JOptionPane.WARNING_MESSAGE); }
        
    }
    
    public void setFiltroTexto(){
        //DE DATOS PERSONALES
        Helper.setFiltraEntrada(txtNombre.getDocument(), FiltraEntrada.SOLO_LETRAS, 20, false);
        Helper.setFiltraEntrada(txtApellido.getDocument(), FiltraEntrada.SOLO_LETRAS, 20, false);
        Helper.setFiltraEntrada(txtCedula.getDocument(), FiltraEntrada.SOLO_NUMEROS, 8, false);

        //DE DATOS INSCRIPCIÓN
        
    }
    
    private void LimpiarTablasTemporales() throws SQLException{
        
        try{
            
            connection = Conectar.getConnection();
            PreparedStatement ps = connection.prepareStatement("TRUNCATE temporalestadoinscripcioncategoria");
            int res = ps.executeUpdate();
            
            if(res > 0){
                
            }
            
        }catch(SQLException ex){ JOptionPane.showMessageDialog(pnlFondo, "Error: "+ex.getMessage(), "ERROR", JOptionPane.PLAIN_MESSAGE); }
        
        try{
            
            connection = Conectar.getConnection();
            PreparedStatement ps = connection.prepareStatement("TRUNCATE temporalestadomembresiacategoria");
            int res = ps.executeUpdate();
            
            if(res > 0){
                
            }
            
        }catch(SQLException ex){ JOptionPane.showMessageDialog(pnlFondo, "Error: "+ex.getMessage(), "ERROR", JOptionPane.PLAIN_MESSAGE); }
        
        try{
            
            connection = Conectar.getConnection();
            PreparedStatement ps = connection.prepareStatement("TRUNCATE temporalestadoinscripcionsakura");
            int res = ps.executeUpdate();
            
            if(res > 0){
                
            }
            
        }catch(SQLException ex){ JOptionPane.showMessageDialog(pnlFondo, "Error: "+ex.getMessage(), "ERROR", JOptionPane.PLAIN_MESSAGE); }
        
        try{
            
            connection = Conectar.getConnection();
            PreparedStatement ps = connection.prepareStatement("TRUNCATE temporalestadomembresiasakura");
            int res = ps.executeUpdate();
            
            if(res > 0){
                
            }
            
        }catch(SQLException ex){ JOptionPane.showMessageDialog(pnlFondo, "Error: "+ex.getMessage(), "ERROR", JOptionPane.PLAIN_MESSAGE); }
        
    }
    
    private void InsertarCategorias() throws SQLException, IOException{
        
        pnlCategoria = null;
        cates.removeAllElements();
        
        try{
        
            PreparedStatement pst1 = connection.prepareStatement("SELECT * FROM estadoinscripcioncategoria WHERE cedula = '"+cedula+"'");
            ResultSet rs1 = pst1.executeQuery();

            while(rs1.next()){

                String add1 = rs1.getString("categoria");
                //cates.add(add1);

                PreparedStatement pst2 = connection.prepareStatement("SELECT * FROM configcategoria WHERE categoria = '"+add1+"'");
                ResultSet rs2 = pst2.executeQuery();

                while(rs2.next()){

                    pnlCategoria = new pnlCategoria(txtCedula.getText(),rs1.getString("categoria"), rs2.getFloat("inscripcion"), rs2.getFloat("mensualidad"), rs2.getString("instructor"), rs2.getString("dias"));
                    tbbCategorias.add(rs2.getString("categoria"),pnlCategoria);
                }
            }
            
        }catch(SQLException ex){
            JOptionPane.showInternalMessageDialog(pnlFondo,"Error: "+ex.getMessage(), "ERROR", JOptionPane.PLAIN_MESSAGE);
        }
        
    }
    
    private void InsertarSakura() throws SQLException, IOException{
        
        pnlInscripcion = null;
        //tbbSakura.removeAll();
        
        try{
        
            PreparedStatement pst1 = connection.prepareStatement("SELECT * FROM estadoinscripcionsakura WHERE cedula = '"+cedula+"'");
            ResultSet rs1 = pst1.executeQuery();

            if(rs1.next()){

                PreparedStatement pst2 = connection.prepareStatement("SELECT * FROM configsakura");
                ResultSet rs2 = pst2.executeQuery();

                while(rs2.next()){

                    pnlInscripcion = new pnlInscripcion(rs1.getString("cedula"),rs2.getFloat("inscripcion"), rs2.getFloat("membresia"));
                    tbbSakura.add("Sakura",pnlInscripcion);
                }
            }else{
                PreparedStatement pst2 = connection.prepareStatement("SELECT * FROM configsakura");
                ResultSet rs2 = pst2.executeQuery();

                while(rs2.next()){

                    pnlInscripcion = new pnlInscripcion(String.valueOf(cedula),rs2.getFloat("inscripcion"), rs2.getFloat("membresia"));
                    tbbSakura.add("Sakura",pnlInscripcion);
                }
            }
               
        }catch(SQLException ex){
            JOptionPane.showInternalMessageDialog(pnlFondo,"Error: "+ex.getMessage(), "ERROR", JOptionPane.PLAIN_MESSAGE);
        }
        
        /*
        pnlInscripcion = null;
        
        try{
            connection = Conectar.getConnection();
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM configsakura");

            while(resultSet.next()){

                pnlInscripcion = new pnlInscripcion(txtCedula.getText(), resultSet.getFloat("inscripcion"), resultSet.getFloat("membresia"));
                tbbSakura.add("Sakura",pnlInscripcion);
            }
        }catch(SQLException ex){
            JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);   
        }*/
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private elaprendiz.gui.label.LabelMetric APELLIDO;
    private elaprendiz.gui.label.LabelMetric CEDULA;
    private elaprendiz.gui.label.LabelMetric CEDULA1;
    private elaprendiz.gui.label.LabelMetric FOTO;
    private elaprendiz.gui.label.LabelMetric NOMBRE;
    private elaprendiz.gui.label.LabelMetric TOTAL;
    private elaprendiz.gui.label.LabelMetric TOTAL1;
    private elaprendiz.gui.label.LabelMetric TOTAL2;
    private elaprendiz.gui.label.LabelMetric TOTAL3;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminarCategoria;
    private elaprendiz.gui.button.ButtonTask btnFoto;
    private javax.swing.JButton btnGuardar;
    private elaprendiz.gui.button.ButtonIpod btnRecuperarTablas;
    private elaprendiz.gui.comboBox.ComboBoxRectIcon cbBuscadorCategoria;
    private elaprendiz.gui.comboBox.ComboBoxRectIcon cbBuscar;
    private elaprendiz.gui.comboBox.ComboBoxRectIcon cbCategoria;
    private elaprendiz.gui.comboBox.ComboBoxRectIcon cbTipoPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel pnlBuscador;
    private elaprendiz.gui.panel.PanelImage pnlBuscar;
    private elaprendiz.gui.panel.PanelTranslucido pnlCalculadora;
    private elaprendiz.gui.panel.PanelCurves pnlCurvas;
    private elaprendiz.gui.panel.PanelTranslucido pnlDatosPersonales;
    private elaprendiz.gui.panel.PanelImage pnlFondo;
    private elaprendiz.gui.panel.PanelTranslucido pnlFoto;
    private elaprendiz.gui.panel.PanelImage pnlImagenFoto;
    private javax.swing.JPanel pnlTabla;
    private elaprendiz.gui.progressBar.ProgressBarRound progressbarBarra;
    private javax.swing.JScrollPane scrollTabla;
    private elaprendiz.gui.tabbedPane.TabbedPaneRound tbbCategorias;
    private elaprendiz.gui.tabbedPane.TabbedSelector2 tbbPaneles;
    private elaprendiz.gui.tabbedPane.TabbedPaneRound tbbSakura;
    private javax.swing.JTable tblAfiliados;
    private elaprendiz.gui.textField.TextFieldRectIcon txtApellido;
    private elaprendiz.gui.textField.TextFieldRectIcon txtBuscar;
    private elaprendiz.gui.textField.TextFieldRectIcon txtCedula;
    private elaprendiz.gui.textField.TextFieldRectIcon txtInscripcion;
    private elaprendiz.gui.textField.TextFieldRectIcon txtMembresia;
    private elaprendiz.gui.textField.TextFieldRectIcon txtNombre;
    private elaprendiz.gui.textField.TextFieldRectIcon txtTotal;
    // End of variables declaration//GEN-END:variables
}
