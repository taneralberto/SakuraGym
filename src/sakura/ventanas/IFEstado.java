/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sakura.ventanas;

import clases.bdd.Conectar;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ALBERTO
 */
public class IFEstado extends javax.swing.JInternalFrame {

    //VARIABLES
    private DefaultComboBoxModel mComboBoxBuscar;
    private Vector vectorTipo;
    private int cedula = -1;
    
    //CONEXIONES
    private PreparedStatement preparedStatement;
    private Connection connection;
    private ResultSet resultSet;
    private Statement st;
    
    //TABLA
    private TableRowSorter trsFiltro;
    private DefaultTableModel modelo;
    private String[]datos;
    
    private TableRowSorter trsFiltro1;
    private DefaultTableModel modelo1;
    private String[]datos1;
    
          //ESTADOS DE PAGOS
    
    private TableRowSorter trsFiltro2;
    private DefaultTableModel modelo2;
    private String[]datos2;
    
    private TableRowSorter trsFiltro3;
    private DefaultTableModel modelo3;
    private String[]datos3;
    
    private TableRowSorter trsFiltro4;
    private DefaultTableModel modelo4;
    private String[]datos4;
    
    private TableRowSorter trsFiltro5;
    private DefaultTableModel modelo5;
    private String[]datos5;
    
    private TableRowSorter trsFiltro6;
    private DefaultTableModel modelo6;
    private String[]datos6;
    
    private TableRowSorter trsFiltro7;
    private DefaultTableModel modelo7;
    private String[]datos7;
    
    private TableRowSorter trsFiltro8;
    private DefaultTableModel modelo8;
    private String[]datos8;
    
    public IFEstado() throws SQLException {
        initComponents();
        
        v(0,pnlBuscar);
        v(0,pnlBuscar1);
        v(0,pnlBuscar2);
 
        /**********TABLA AFILIADOS**********/
       
        modelo = new DefaultTableModel();
        datos = new String [3];
        modelo.addColumn("NOMBRE");
        modelo.addColumn("APELLIDO");
        modelo.addColumn("Nº CÉDULA");
        tblAfiliados.setModel(modelo);
        modelo.fireTableDataChanged();
        
        /**********TABLA ESTADO**********/
       
        modelo1 = new DefaultTableModel();
        datos1 = new String [4];
        modelo1.addColumn("CATEGORÍA");
        modelo1.addColumn("FECHA INICIO");
        modelo1.addColumn("FECHA VENCIMIENTO");
        modelo1.addColumn("ESTADO");
        tblEstado.setModel(modelo1);
        modelo1.fireTableDataChanged();
        
        /**********ESTADOS DE PAGOS**********/
       
        modelo2 = new DefaultTableModel();
        datos2 = new String [7];
        modelo2.addColumn("NOMBRE");
        modelo2.addColumn("APELLIDO");
        modelo2.addColumn("CÉDULA");
        modelo2.addColumn("PAGADO");
        modelo2.addColumn("FECHA INICIO");
        modelo2.addColumn("FECHA VENCIMIENTO");
        modelo2.addColumn("ESTADO");
        tblEstadosInscripcionesS.setModel(modelo2);
        modelo2.fireTableDataChanged();
        
        modelo3 = new DefaultTableModel();
        datos3 = new String [7];
        modelo3.addColumn("NOMBRE");
        modelo3.addColumn("APELLIDO");
        modelo3.addColumn("CÉDULA");
        modelo3.addColumn("PAGADO");
        modelo3.addColumn("FECHA INICIO");
        modelo3.addColumn("FECHA VENCIMIENTO");
        modelo3.addColumn("ESTADO");
        tblEstadosMembresiasS.setModel(modelo3);
        modelo3.fireTableDataChanged();
        
        modelo4 = new DefaultTableModel();
        datos4 = new String [8];
        modelo4.addColumn("NOMBRE");
        modelo4.addColumn("APELLIDO");
        modelo4.addColumn("CÉDULA");
        modelo4.addColumn("CATEGORÍA");
        modelo4.addColumn("PAGADO");
        modelo4.addColumn("FECHA INICIO");
        modelo4.addColumn("FECHA VENCIMIENTO");
        modelo4.addColumn("ESTADO");
        tblEstadosInscripcionesC.setModel(modelo4);
        modelo4.fireTableDataChanged();
        
        modelo5 = new DefaultTableModel();
        datos5 = new String [8];
        modelo5.addColumn("NOMBRE");
        modelo5.addColumn("APELLIDO");
        modelo5.addColumn("CÉDULA");
        modelo5.addColumn("CATEGORÍA");
        modelo5.addColumn("PAGADO");
        modelo5.addColumn("FECHA INICIO");
        modelo5.addColumn("FECHA VENCIMIENTO");
        modelo5.addColumn("ESTADO");
        tblEstadosMembresiasC.setModel(modelo5);
        modelo5.fireTableDataChanged();
        
        /**********TRAYECTORIA**********/
       
        modelo6 = new DefaultTableModel();
        datos6 = new String [3];
        modelo6.addColumn("NOMBRE");
        modelo6.addColumn("APELLIDO");
        modelo6.addColumn("CÉDULA");
        tblKarate.setModel(modelo6);
        modelo6.fireTableDataChanged();
        
        modelo7 = new DefaultTableModel();
        datos7 = new String [3];
        modelo7.addColumn("NOMBRE");
        modelo7.addColumn("APELLIDO");
        modelo7.addColumn("CÉDULA");
        tblDanza.setModel(modelo7);
        modelo7.fireTableDataChanged();
        
        modelo8 = new DefaultTableModel();
        datos8 = new String [8];
        modelo8.addColumn("Nº COMPETENCIA");
        modelo8.addColumn("NOMBRE");
        modelo8.addColumn("CATEGORIA");
        modelo8.addColumn("LUGAR");
        tblCompetencias.setModel(modelo8);
        modelo8.fireTableDataChanged();
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

        pnlFondo = new elaprendiz.gui.panel.PanelImage();
        pnlBuscar = new elaprendiz.gui.panel.PanelImage();
        jSeparator1 = new javax.swing.JSeparator();
        pnlBuscadorCompetidor = new javax.swing.JPanel();
        txtBuscar = new elaprendiz.gui.textField.TextFieldRectIcon();
        cbBuscar = new elaprendiz.gui.comboBox.ComboBoxRectIcon();
        pnlTablaCompetidor = new javax.swing.JPanel();
        scrollTabla = new javax.swing.JScrollPane();
        tblAfiliados = new javax.swing.JTable();
        pnlTablaCompetencia = new javax.swing.JPanel();
        scrollTabla2 = new javax.swing.JScrollPane();
        tblEstado = new javax.swing.JTable();
        pnlBuscadorCompetencia = new javax.swing.JPanel();
        cbBuscar1 = new elaprendiz.gui.comboBox.ComboBoxRectIcon();
        pnlBuscar1 = new elaprendiz.gui.panel.PanelImage();
        pnlBuscador = new javax.swing.JPanel();
        txtBuscar2 = new elaprendiz.gui.textField.TextFieldRectIcon();
        cbBuscar2 = new elaprendiz.gui.comboBox.ComboBoxRectIcon();
        pnlTabla = new javax.swing.JPanel();
        tbbEstados = new elaprendiz.gui.tabbedPane.TabbedSelector2();
        tabbedPaneRound1 = new elaprendiz.gui.tabbedPane.TabbedPaneRound();
        scrollTabla3 = new javax.swing.JScrollPane();
        tblEstadosInscripcionesS = new javax.swing.JTable();
        scrollTabla1 = new javax.swing.JScrollPane();
        tblEstadosMembresiasS = new javax.swing.JTable();
        tabbedPaneRound2 = new elaprendiz.gui.tabbedPane.TabbedPaneRound();
        scrollTabla4 = new javax.swing.JScrollPane();
        tblEstadosInscripcionesC = new javax.swing.JTable();
        scrollTabla5 = new javax.swing.JScrollPane();
        tblEstadosMembresiasC = new javax.swing.JTable();
        pnlBuscar2 = new elaprendiz.gui.panel.PanelImage();
        jSeparator2 = new javax.swing.JSeparator();
        pnlBuscadorCompetidor1 = new javax.swing.JPanel();
        txtBuscar3 = new elaprendiz.gui.textField.TextFieldRectIcon();
        cbBuscar3 = new elaprendiz.gui.comboBox.ComboBoxRectIcon();
        pnlTablaCompetencia1 = new javax.swing.JPanel();
        scrollTabla7 = new javax.swing.JScrollPane();
        tblCompetencias = new javax.swing.JTable();
        tbbEstados1 = new elaprendiz.gui.tabbedPane.TabbedSelector2();
        pnlTablaCompetidor1 = new javax.swing.JPanel();
        scrollTabla6 = new javax.swing.JScrollPane();
        tblKarate = new javax.swing.JTable();
        pnlTablaCompetidor2 = new javax.swing.JPanel();
        scrollTabla8 = new javax.swing.JScrollPane();
        tblDanza = new javax.swing.JTable();
        pnlCurvas = new elaprendiz.gui.panel.PanelCurves();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        progressbarBarra = new elaprendiz.gui.progressBar.ProgressBarRound();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setTitle("Consultas");

        pnlFondo.setBackground(new java.awt.Color(255, 255, 255));
        pnlFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/fondo azul.jpg"))); // NOI18N
        pnlFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/Fondo-de-pantalla-Abstracto-78.jpg"))); // NOI18N
        pnlBuscar.setLayout(new java.awt.GridBagLayout());

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setPreferredSize(new java.awt.Dimension(10, 200));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        pnlBuscar.add(jSeparator1, gridBagConstraints);

        pnlBuscadorCompetidor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscador", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlBuscadorCompetidor.setOpaque(false);
        pnlBuscadorCompetidor.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlBuscadorCompetidorCompetidorMouseDragged(evt);
            }
        });
        pnlBuscadorCompetidor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlBuscadorCompetidorCompetidorMousePressed(evt);
            }
        });
        pnlBuscadorCompetidor.setLayout(new java.awt.GridBagLayout());

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
        pnlBuscadorCompetidor.add(txtBuscar, gridBagConstraints);

        cbBuscar.setBackground(new java.awt.Color(255, 255, 102));
        cbBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        cbBuscar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre", "Apellido", "Nº Cédula" }));
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
        pnlBuscadorCompetidor.add(cbBuscar, gridBagConstraints);

        pnlBuscar.add(pnlBuscadorCompetidor, new java.awt.GridBagConstraints());

        pnlTablaCompetidor.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlTablaCompetidor.setOpaque(false);
        pnlTablaCompetidor.setLayout(new java.awt.BorderLayout());

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

        pnlTablaCompetidor.add(scrollTabla, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        pnlBuscar.add(pnlTablaCompetidor, gridBagConstraints);

        pnlTablaCompetencia.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlTablaCompetencia.setOpaque(false);
        pnlTablaCompetencia.setLayout(new java.awt.BorderLayout());

        scrollTabla2.setPreferredSize(new java.awt.Dimension(500, 250));

        tblEstado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblEstado.setToolTipText("");
        tblEstado.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblEstado.setGridColor(new java.awt.Color(51, 51, 255));
        tblEstado.setSelectionForeground(new java.awt.Color(255, 0, 51));
        tblEstado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEstadoMouseClicked(evt);
            }
        });
        scrollTabla2.setViewportView(tblEstado);

        pnlTablaCompetencia.add(scrollTabla2, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        pnlBuscar.add(pnlTablaCompetencia, gridBagConstraints);

        pnlBuscadorCompetencia.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscador", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlBuscadorCompetencia.setOpaque(false);
        pnlBuscadorCompetencia.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlBuscadorCompetenciaCompetidorMouseDragged(evt);
            }
        });
        pnlBuscadorCompetencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlBuscadorCompetenciaCompetidorMousePressed(evt);
            }
        });
        pnlBuscadorCompetencia.setLayout(new java.awt.GridBagLayout());

        cbBuscar1.setBackground(new java.awt.Color(255, 255, 102));
        cbBuscar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        cbBuscar1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Inscripcion", "Membresia" }));
        cbBuscar1.setAnchoDeBorde(3.0F);
        cbBuscar1.setColorDeBorde(new java.awt.Color(0, 0, 0));
        cbBuscar1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbBuscar1.setPreferredSize(new java.awt.Dimension(130, 25));
        cbBuscar1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbBuscar1ItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        pnlBuscadorCompetencia.add(cbBuscar1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        pnlBuscar.add(pnlBuscadorCompetencia, gridBagConstraints);

        pnlFondo.add(pnlBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 60));

        pnlBuscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/Fondo-de-pantalla-Abstracto-78.jpg"))); // NOI18N
        pnlBuscar1.setLayout(new java.awt.BorderLayout());

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

        txtBuscar2.setBackground(new java.awt.Color(255, 255, 102));
        txtBuscar2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        txtBuscar2.setAnchoDeBorde(3.0F);
        txtBuscar2.setColorDeBorde(new java.awt.Color(0, 0, 0));
        txtBuscar2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtBuscar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/share.png"))); // NOI18N
        txtBuscar2.setPreferredSize(new java.awt.Dimension(250, 25));
        txtBuscar2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscar2KeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        pnlBuscador.add(txtBuscar2, gridBagConstraints);

        cbBuscar2.setBackground(new java.awt.Color(255, 255, 102));
        cbBuscar2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        cbBuscar2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre", "Apellido", "Nº Cédula", "Categoria", "Estado" }));
        cbBuscar2.setAnchoDeBorde(3.0F);
        cbBuscar2.setColorDeBorde(new java.awt.Color(0, 0, 0));
        cbBuscar2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbBuscar2.setPreferredSize(new java.awt.Dimension(130, 25));
        cbBuscar2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbBuscar2ItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        pnlBuscador.add(cbBuscar2, gridBagConstraints);

        pnlBuscar1.add(pnlBuscador, java.awt.BorderLayout.PAGE_START);

        pnlTabla.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlTabla.setOpaque(false);
        pnlTabla.setLayout(new java.awt.BorderLayout());

        tbbEstados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        tbbEstados.setColorBackGround(new java.awt.Color(51, 204, 255));
        tbbEstados.setColorDeBorde(new java.awt.Color(255, 255, 102));
        tbbEstados.setColorDeSegundoBorde(new java.awt.Color(255, 255, 102));
        tbbEstados.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tbbEstados.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tbbEstadosStateChanged(evt);
            }
        });

        scrollTabla3.setPreferredSize(new java.awt.Dimension(700, 250));

        tblEstadosInscripcionesS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblEstadosInscripcionesS.setToolTipText("");
        tblEstadosInscripcionesS.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblEstadosInscripcionesS.setGridColor(new java.awt.Color(51, 51, 255));
        tblEstadosInscripcionesS.setSelectionForeground(new java.awt.Color(255, 0, 51));
        tblEstadosInscripcionesS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEstadosInscripcionesSMouseClicked(evt);
            }
        });
        scrollTabla3.setViewportView(tblEstadosInscripcionesS);

        tabbedPaneRound1.addTab("Inscripciones", scrollTabla3);

        scrollTabla1.setPreferredSize(new java.awt.Dimension(379, 250));

        tblEstadosMembresiasS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblEstadosMembresiasS.setToolTipText("");
        tblEstadosMembresiasS.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblEstadosMembresiasS.setGridColor(new java.awt.Color(51, 51, 255));
        tblEstadosMembresiasS.setSelectionForeground(new java.awt.Color(255, 0, 51));
        tblEstadosMembresiasS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEstadosMembresiasSMouseClicked(evt);
            }
        });
        scrollTabla1.setViewportView(tblEstadosMembresiasS);

        tabbedPaneRound1.addTab("Membresias", scrollTabla1);

        tbbEstados.addTab("Sakura", tabbedPaneRound1);

        scrollTabla4.setPreferredSize(new java.awt.Dimension(379, 250));

        tblEstadosInscripcionesC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblEstadosInscripcionesC.setToolTipText("");
        tblEstadosInscripcionesC.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblEstadosInscripcionesC.setGridColor(new java.awt.Color(51, 51, 255));
        tblEstadosInscripcionesC.setSelectionForeground(new java.awt.Color(255, 0, 51));
        tblEstadosInscripcionesC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEstadosInscripcionesCMouseClicked(evt);
            }
        });
        scrollTabla4.setViewportView(tblEstadosInscripcionesC);

        tabbedPaneRound2.addTab("Inscripciones", scrollTabla4);

        scrollTabla5.setPreferredSize(new java.awt.Dimension(379, 250));

        tblEstadosMembresiasC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblEstadosMembresiasC.setToolTipText("");
        tblEstadosMembresiasC.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblEstadosMembresiasC.setGridColor(new java.awt.Color(51, 51, 255));
        tblEstadosMembresiasC.setSelectionForeground(new java.awt.Color(255, 0, 51));
        tblEstadosMembresiasC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEstadosMembresiasCMouseClicked(evt);
            }
        });
        scrollTabla5.setViewportView(tblEstadosMembresiasC);

        tabbedPaneRound2.addTab("Membresias", scrollTabla5);

        tbbEstados.addTab("Categorias", tabbedPaneRound2);

        pnlTabla.add(tbbEstados, java.awt.BorderLayout.LINE_START);

        pnlBuscar1.add(pnlTabla, java.awt.BorderLayout.CENTER);

        pnlFondo.add(pnlBuscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 75, 100, 80));

        pnlBuscar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/Fondo-de-pantalla-Abstracto-78.jpg"))); // NOI18N
        pnlBuscar2.setLayout(new java.awt.GridBagLayout());

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setPreferredSize(new java.awt.Dimension(10, 200));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        pnlBuscar2.add(jSeparator2, gridBagConstraints);

        pnlBuscadorCompetidor1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscador", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlBuscadorCompetidor1.setOpaque(false);
        pnlBuscadorCompetidor1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlBuscadorCompetidor1CompetidorMouseDragged(evt);
            }
        });
        pnlBuscadorCompetidor1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlBuscadorCompetidor1CompetidorMousePressed(evt);
            }
        });
        pnlBuscadorCompetidor1.setLayout(new java.awt.GridBagLayout());

        txtBuscar3.setBackground(new java.awt.Color(255, 255, 102));
        txtBuscar3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        txtBuscar3.setAnchoDeBorde(3.0F);
        txtBuscar3.setColorDeBorde(new java.awt.Color(0, 0, 0));
        txtBuscar3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtBuscar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/botones/share.png"))); // NOI18N
        txtBuscar3.setPreferredSize(new java.awt.Dimension(250, 25));
        txtBuscar3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscar3KeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        pnlBuscadorCompetidor1.add(txtBuscar3, gridBagConstraints);

        cbBuscar3.setBackground(new java.awt.Color(255, 255, 102));
        cbBuscar3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        cbBuscar3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre", "Apellido", "Nº Cédula" }));
        cbBuscar3.setAnchoDeBorde(3.0F);
        cbBuscar3.setColorDeBorde(new java.awt.Color(0, 0, 0));
        cbBuscar3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbBuscar3.setPreferredSize(new java.awt.Dimension(130, 25));
        cbBuscar3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbBuscar3ItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        pnlBuscadorCompetidor1.add(cbBuscar3, gridBagConstraints);

        pnlBuscar2.add(pnlBuscadorCompetidor1, new java.awt.GridBagConstraints());

        pnlTablaCompetencia1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlTablaCompetencia1.setOpaque(false);
        pnlTablaCompetencia1.setLayout(new java.awt.BorderLayout());

        scrollTabla7.setPreferredSize(new java.awt.Dimension(379, 250));

        tblCompetencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblCompetencias.setToolTipText("");
        tblCompetencias.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblCompetencias.setGridColor(new java.awt.Color(51, 51, 255));
        tblCompetencias.setSelectionForeground(new java.awt.Color(255, 0, 51));
        tblCompetencias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCompetenciasMouseClicked(evt);
            }
        });
        scrollTabla7.setViewportView(tblCompetencias);

        pnlTablaCompetencia1.add(scrollTabla7, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        pnlBuscar2.add(pnlTablaCompetencia1, gridBagConstraints);

        tbbEstados1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        tbbEstados1.setColorBackGround(new java.awt.Color(51, 204, 255));
        tbbEstados1.setColorDeBorde(new java.awt.Color(255, 255, 102));
        tbbEstados1.setColorDeSegundoBorde(new java.awt.Color(255, 255, 102));
        tbbEstados1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tbbEstados1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tbbEstados1StateChanged(evt);
            }
        });

        pnlTablaCompetidor1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlTablaCompetidor1.setOpaque(false);
        pnlTablaCompetidor1.setLayout(new java.awt.BorderLayout());

        scrollTabla6.setPreferredSize(new java.awt.Dimension(379, 250));

        tblKarate.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblKarate.setToolTipText("");
        tblKarate.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblKarate.setGridColor(new java.awt.Color(51, 51, 255));
        tblKarate.setSelectionForeground(new java.awt.Color(255, 0, 51));
        tblKarate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKarateMouseClicked(evt);
            }
        });
        scrollTabla6.setViewportView(tblKarate);

        pnlTablaCompetidor1.add(scrollTabla6, java.awt.BorderLayout.CENTER);

        tbbEstados1.addTab("Karate", pnlTablaCompetidor1);

        pnlTablaCompetidor2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlTablaCompetidor2.setOpaque(false);
        pnlTablaCompetidor2.setLayout(new java.awt.BorderLayout());

        scrollTabla8.setPreferredSize(new java.awt.Dimension(379, 250));

        tblDanza.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblDanza.setToolTipText("");
        tblDanza.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblDanza.setGridColor(new java.awt.Color(51, 51, 255));
        tblDanza.setSelectionForeground(new java.awt.Color(255, 0, 51));
        tblDanza.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanzaMouseClicked(evt);
            }
        });
        scrollTabla8.setViewportView(tblDanza);

        pnlTablaCompetidor2.add(scrollTabla8, java.awt.BorderLayout.CENTER);

        tbbEstados1.addTab("Danza", pnlTablaCompetidor2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        pnlBuscar2.add(tbbEstados1, gridBagConstraints);

        pnlFondo.add(pnlBuscar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 120, 120));

        pnlCurvas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(255, 255, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Estados de afiliados");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setIconTextGap(-5);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pnlCurvas.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 210, 30));

        jButton3.setBackground(new java.awt.Color(255, 255, 102));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("Trayectoria competitva");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setIconTextGap(-5);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        pnlCurvas.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, -1, 30));

        jButton4.setBackground(new java.awt.Color(255, 255, 102));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setText("Estados de pagos");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setIconTextGap(-5);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        pnlCurvas.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 210, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sakura/resources/share.png"))); // NOI18N
        pnlCurvas.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        pnlFondo.add(pnlCurvas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 350));

        progressbarBarra.setBackground(new java.awt.Color(0, 204, 255));
        progressbarBarra.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        progressbarBarra.setForeground(new java.awt.Color(255, 255, 0));
        progressbarBarra.setToolTipText("");
        progressbarBarra.setBorde(5.0F);
        progressbarBarra.setBorderPainted(false);
        progressbarBarra.setColorDeBorde(new java.awt.Color(0, 0, 0));
        progressbarBarra.setDistanciaDeSombra(5);
        progressbarBarra.setFocusable(false);
        progressbarBarra.setFont(new java.awt.Font("SunnySide", 1, 36)); // NOI18N
        progressbarBarra.setString("Consultas");
        progressbarBarra.setStringPainted(true);
        pnlFondo.add(progressbarBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 330, 60));

        getContentPane().add(pnlFondo, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        try{
            InsertarDatosAfiliados();
        }catch(SQLException ex){ JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(),"Aviso",JOptionPane.ERROR_MESSAGE); }
        
        v(1,pnlBuscar);
        JOptionPane.showInternalMessageDialog(pnlFondo, pnlBuscar,"Estados de afiliados",JOptionPane.PLAIN_MESSAGE);
        
    }//GEN-LAST:event_jButton1ActionPerformed

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

    private void cbBuscarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbBuscarItemStateChanged

    }//GEN-LAST:event_cbBuscarItemStateChanged

    private void pnlBuscadorCompetidorCompetidorMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBuscadorCompetidorCompetidorMouseDragged

    }//GEN-LAST:event_pnlBuscadorCompetidorCompetidorMouseDragged

    private void pnlBuscadorCompetidorCompetidorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBuscadorCompetidorCompetidorMousePressed

    }//GEN-LAST:event_pnlBuscadorCompetidorCompetidorMousePressed

    private void tblAfiliadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAfiliadosMouseClicked

        TVtblAfiliadosMouseClicked();
                
    }//GEN-LAST:event_tblAfiliadosMouseClicked

    private void tblEstadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEstadoMouseClicked

        //TVtblCompetenciasMouseClicked();
    }//GEN-LAST:event_tblEstadoMouseClicked

    private void cbBuscar1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbBuscar1ItemStateChanged

        try{
            
            if(cbBuscar1.getSelectedItem().equals("Inscripcion")){
            InsertarDatosCategoria("inscripcion",cedula);
            }

            if(cbBuscar1.getSelectedItem().equals("Membresia")){
                InsertarDatosCategoria("membresia",cedula);
            }
            
        }catch(SQLException ex){
            JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
        
        
    }//GEN-LAST:event_cbBuscar1ItemStateChanged

    private void pnlBuscadorCompetenciaCompetidorMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBuscadorCompetenciaCompetidorMouseDragged

    }//GEN-LAST:event_pnlBuscadorCompetenciaCompetidorMouseDragged

    private void pnlBuscadorCompetenciaCompetidorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBuscadorCompetenciaCompetidorMousePressed

    }//GEN-LAST:event_pnlBuscadorCompetenciaCompetidorMousePressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        try{
            InsertarDatosEstados();
        }catch(SQLException ex){ JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(),"Aviso",JOptionPane.ERROR_MESSAGE); }
        
        v(1,pnlBuscar1);
        JOptionPane.showInternalMessageDialog(pnlFondo, pnlBuscar1,"Estados de pagos",JOptionPane.PLAIN_MESSAGE);
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtBuscar2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscar2KeyTyped

        txtBuscar2.addKeyListener(new KeyAdapter() {

            public void keyReleased(final KeyEvent e){

                String cadena = (txtBuscar2.getText());
                e(1,txtBuscar2);
                txtBuscar2.setText(cadena);
                repaint();
                filtroEstados();
            }
        });

        trsFiltro2 = new TableRowSorter(tblEstadosInscripcionesC.getModel());
        tblEstadosInscripcionesC.setRowSorter(trsFiltro2);
        
        trsFiltro3 = new TableRowSorter(tblEstadosMembresiasC.getModel());
        tblEstadosMembresiasC.setRowSorter(trsFiltro3);
        
        trsFiltro4 = new TableRowSorter(tblEstadosInscripcionesS.getModel());
        tblEstadosInscripcionesS.setRowSorter(trsFiltro4);
        
        trsFiltro5 = new TableRowSorter(tblEstadosMembresiasS.getModel());
        tblEstadosMembresiasS.setRowSorter(trsFiltro5);

    }//GEN-LAST:event_txtBuscar2KeyTyped

    private void cbBuscar2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbBuscar2ItemStateChanged

    }//GEN-LAST:event_cbBuscar2ItemStateChanged

    private void pnlBuscadorMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBuscadorMouseDragged

    }//GEN-LAST:event_pnlBuscadorMouseDragged

    private void pnlBuscadorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBuscadorMousePressed

    }//GEN-LAST:event_pnlBuscadorMousePressed

    private void tblEstadosMembresiasSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEstadosMembresiasSMouseClicked

    }//GEN-LAST:event_tblEstadosMembresiasSMouseClicked

    private void tblEstadosInscripcionesSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEstadosInscripcionesSMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblEstadosInscripcionesSMouseClicked

    private void tblEstadosInscripcionesCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEstadosInscripcionesCMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblEstadosInscripcionesCMouseClicked

    private void tblEstadosMembresiasCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEstadosMembresiasCMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblEstadosMembresiasCMouseClicked

    private void tbbEstadosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tbbEstadosStateChanged
        filtroEstados();
    }//GEN-LAST:event_tbbEstadosStateChanged

    private void txtBuscar3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscar3KeyTyped

        txtBuscar3.addKeyListener(new KeyAdapter() {

            public void keyReleased(final KeyEvent e){

                String cadena = (txtBuscar3.getText());
                e(1,txtBuscar3);
                txtBuscar3.setText(cadena);
                repaint();
                filtroTrayectoria();
            }
        });

        trsFiltro6 = new TableRowSorter(tblKarate.getModel());
        tblKarate.setRowSorter(trsFiltro6);
        
        trsFiltro7 = new TableRowSorter(tblDanza.getModel());
        tblDanza.setRowSorter(trsFiltro7);
        
    }//GEN-LAST:event_txtBuscar3KeyTyped

    private void cbBuscar3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbBuscar3ItemStateChanged

    }//GEN-LAST:event_cbBuscar3ItemStateChanged

    private void pnlBuscadorCompetidor1CompetidorMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBuscadorCompetidor1CompetidorMouseDragged

    }//GEN-LAST:event_pnlBuscadorCompetidor1CompetidorMouseDragged

    private void pnlBuscadorCompetidor1CompetidorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBuscadorCompetidor1CompetidorMousePressed

    }//GEN-LAST:event_pnlBuscadorCompetidor1CompetidorMousePressed

    private void tblKarateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKarateMouseClicked

        TVtblKarateMouseClicked();
        
    }//GEN-LAST:event_tblKarateMouseClicked

    private void tblCompetenciasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCompetenciasMouseClicked

    
    }//GEN-LAST:event_tblCompetenciasMouseClicked

    private void tbbEstados1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tbbEstados1StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_tbbEstados1StateChanged

    private void tblDanzaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanzaMouseClicked
        
        TVtblDanzaMouseClicked();
        
    }//GEN-LAST:event_tblDanzaMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        try{
            InsertDatosEnTablaKaratecas();
            InsertDatosEnTablaDanzinas();
        }catch(SQLException ex){ JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(),"Aviso",JOptionPane.ERROR_MESSAGE); }
        
        v(1,pnlBuscar2);
        JOptionPane.showInternalMessageDialog(pnlFondo, pnlBuscar2,"Trayectorias",JOptionPane.PLAIN_MESSAGE);
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void filtro(){
        
        int columnaABuscar=0;

        if(cbBuscar.getSelectedItem()=="Nombre"){ columnaABuscar = 0; }
        if(cbBuscar.getSelectedItem()=="Apellido"){ columnaABuscar = 1; }
        if(cbBuscar.getSelectedItem()=="Nº Cédula"){ columnaABuscar = 2; }
        //if(cbBuscar.getSelectedItem()=="Categoría"){ columnaABuscar = 3; }
        //if(cbBuscar.getSelectedItem()=="Sexo"){ columnaABuscar = 6; }

        trsFiltro.setRowFilter(RowFilter.regexFilter("(?i)"+txtBuscar.getText(), columnaABuscar));
    }
    
    private void filtroEstados(){
        
        int columnaABuscar=0;

        if(cbBuscar2.getSelectedItem()=="Nombre"){ columnaABuscar = 0; }
        if(cbBuscar2.getSelectedItem()=="Apellido"){ columnaABuscar = 1; }
        if(cbBuscar2.getSelectedItem()=="Nº Cédula"){ columnaABuscar = 2; }
        if(cbBuscar2.getSelectedItem()=="Categoria"){ columnaABuscar = 3; }
        if(cbBuscar2.getSelectedItem()=="Estado"){ columnaABuscar = 7; }
        
        if(tbbEstados.getTitleAt(tbbEstados.getModel().getSelectedIndex()).equals("Sakura")){
            if(cbBuscar2.getSelectedItem()=="Estado"){ columnaABuscar = 6; }
        }
        if(txtBuscar2.getText().length()>0){
        trsFiltro2.setRowFilter(RowFilter.regexFilter("(?i)"+txtBuscar2.getText(), columnaABuscar));
        trsFiltro3.setRowFilter(RowFilter.regexFilter("(?i)"+txtBuscar2.getText(), columnaABuscar));
        trsFiltro4.setRowFilter(RowFilter.regexFilter("(?i)"+txtBuscar2.getText(), columnaABuscar));
        trsFiltro5.setRowFilter(RowFilter.regexFilter("(?i)"+txtBuscar2.getText(), columnaABuscar));
        }
    }
    
    private void filtroTrayectoria(){
        
        int columnaABuscar=0;

        if(cbBuscar3.getSelectedItem()=="Nombre"){ columnaABuscar = 0; }
        if(cbBuscar3.getSelectedItem()=="Apellido"){ columnaABuscar = 1; }
        if(cbBuscar3.getSelectedItem()=="Nº Cédula"){ columnaABuscar = 2; }
        //if(cbBuscar.getSelectedItem()=="Categoría"){ columnaABuscar = 3; }
        //if(cbBuscar.getSelectedItem()=="Sexo"){ columnaABuscar = 6; }

        trsFiltro6.setRowFilter(RowFilter.regexFilter("(?i)"+txtBuscar3.getText(), columnaABuscar));
        trsFiltro7.setRowFilter(RowFilter.regexFilter("(?i)"+txtBuscar3.getText(), columnaABuscar));
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
    
    private void TVtblAfiliadosMouseClicked(){
        
        modelo1.setRowCount(0);
        
        try{
            int fila = tblAfiliados.getSelectedRow();
            int filaModel = tblAfiliados.convertRowIndexToModel(fila); //CONVIERTE LA FILA AL MODELO

            tblAfiliados.convertRowIndexToView(filaModel); //CONVIERTE LA FILA A LA VISTA
            modelo.fireTableDataChanged(); //POR SI HAY ALGUN ERROR, AVISA QUE LA TABLA HA CAMBIADO

            String tableClick = (tblAfiliados.getModel().getValueAt(filaModel, 2).toString());
            cedula = Integer.parseInt(tableClick);

            connection = Conectar.getConnection();
            PreparedStatement pst = connection.prepareStatement("SELECT * FROM estadoinscripcioncategoria WHERE cedula = '"+tableClick+"'");
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                
                InsertarDatosCategoria("inscripcion",Integer.parseInt(tableClick));
                
                cbBuscar1.setSelectedItem("Inscripcion");

                /*vectorTipo.add("Categoria");
                vectorTipo.add("Membresia");*/
                
                /*String[] array = null;
                array[0] = "Categoria";
                array[1] = "Membresia";
                
                mComboBoxBuscar = new DefaultComboBoxModel(array);
                this.cbBuscar1.setModel(mComboBoxBuscar);*/

            }

        }catch(SQLException e){ JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+e.getMessage(),"Aviso",JOptionPane.WARNING_MESSAGE); }

    }
    
    private void InsertarDatosAfiliados() throws SQLException{
        
        modelo.setRowCount(0);
        modelo1.setRowCount(0);
        
        try{
            connection = Conectar.getConnection();
            st = connection.createStatement();
            resultSet = st.executeQuery("SELECT * FROM datospersonales");
            
            while(resultSet.next()){

                datos[0] = resultSet.getString("nombre");
                datos[1] = resultSet.getString("apellido");
                datos[2] = String.valueOf(resultSet.getInt("cedula"));

                modelo.addRow(datos);
            }

            tblAfiliados.setModel(modelo);
            
        }catch (SQLException ex){ JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(),"Aviso",JOptionPane.WARNING_MESSAGE); }
    }
    
    private void InsertarDatosCategoria(String tipo, int cedula) throws SQLException{
        
        if(tipo.equals("inscripcion")){
        
            modelo1.setRowCount(0);

            GregorianCalendar fecha = new GregorianCalendar();

            try{
                connection = Conectar.getConnection();
                st = connection.createStatement();
                resultSet = st.executeQuery("SELECT * FROM estadoinscripcioncategoria WHERE cedula = '"+cedula+"'");

                while(resultSet.next()){

                    datos1[0] = resultSet.getString("categoria");
                    datos1[1] = String.valueOf(resultSet.getDate("fechainscripcion"));
                    datos1[2] = String.valueOf(resultSet.getDate("fechavenceinscripcion"));

                    if(resultSet.getDate("fechavenceinscripcion").before(fecha.getTime())){
                        datos1[3] = "*Pendiente "+DiferenciaFechas(resultSet.getDate("fechavenceinscripcion"),fecha.getTime(),2)+" días.";

                        if(resultSet.getString("vencimiento").equals("Indefinido")){
                            datos1[3] = "Indefinido";
                        }

                    }else{
                        datos1[3] = "Vigente "+DiferenciaFechas(fecha.getTime(),resultSet.getDate("fechavenceinscripcion"),2)+" días.";
                     }

                    modelo1.addRow(datos1);
                }

                tblEstado.setModel(modelo1);

            }catch (SQLException ex){ JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(),"Aviso",JOptionPane.WARNING_MESSAGE); }
        }
        
        if(tipo.equals("membresia")){
            
            modelo1.setRowCount(0);

            GregorianCalendar fecha = new GregorianCalendar();

            try{
                connection = Conectar.getConnection();
                st = connection.createStatement();
                resultSet = st.executeQuery("SELECT * FROM estadomembresiacategoria WHERE cedula = '"+cedula+"'");

                while(resultSet.next()){

                    datos1[0] = resultSet.getString("categoria");
                    datos1[1] = String.valueOf(resultSet.getDate("fechamembresia"));
                    datos1[2] = String.valueOf(resultSet.getDate("fechavencemembresia"));

                    if(resultSet.getDate("fechavencemembresia").before(fecha.getTime())){
                        datos1[3] = "*Pendiente "+DiferenciaFechas(resultSet.getDate("fechavencemembresia"),fecha.getTime(),2)+" días.";

                        if(resultSet.getString("vencimiento").equals("Indefinido")){
                            datos1[3] = "Indefinido";
                        }

                    }else{
                        datos1[3] = "Vigente "+DiferenciaFechas(fecha.getTime(),resultSet.getDate("fechavencemembresia"),2)+" días.";
                     }

                    modelo1.addRow(datos1);
                }

                tblEstado.setModel(modelo1);

            }catch (SQLException ex){ JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(),"Aviso",JOptionPane.WARNING_MESSAGE); }
        }
    }
    
    /*private void getDatosAfiliado(int cedula, String[] datos, DefaultTableModel modelo, JTable tabla) throws SQLException{
        
        modelo.setRowCount(0);
        
        try{
            connection = Conectar.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM datospersonales WHERE cedula = '"+cedula+"'");
            ResultSet res = ps.executeQuery();
            
            while(res.next()){

                datos[0] = res.getString("nombre");
                datos[1] = res.getString("apellido");
                datos[2] = res.getString("cedula");
            }
            
        }catch (SQLException ex){ JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(),"Aviso",JOptionPane.ERROR_MESSAGE); }
    }*/
    
    private void InsertarDatosEstados() throws SQLException{
        
        GregorianCalendar fecha = new GregorianCalendar();
        
        modelo2.setRowCount(0);
        modelo3.setRowCount(0);
        modelo4.setRowCount(0);
        modelo5.setRowCount(0);
        
        try{
            connection = Conectar.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM estadoinscripcionsakura b, datospersonales a WHERE a.cedula = b.cedula");
            ResultSet res = ps.executeQuery();
            
            while(res.next()){
                
                //getDatosAfiliado(res.getInt("cedula"), datos2, modelo2, tblEstadosInscripcionesS);
                
                datos2[0] = res.getString("a.nombre");
                datos2[1] = res.getString("a.apellido");
                datos2[2] = res.getString("a.cedula");
                datos2[3] = res.getString("b.costo");
                datos2[4] = res.getString("b.fechainscripcion");
                datos2[5] = res.getString("b.fechavenceinscripcion");

                if(res.getDate("b.fechavenceinscripcion").before(fecha.getTime())){ 
                    datos2[6] = "*Pendiente "+DiferenciaFechas(res.getDate("b.fechavenceinscripcion"),fecha.getTime(),2)+" días.";

                    if(res.getString("vencimiento").equals("Indefinido")){
                        datos2[6] = "Indefinido";
                    }
                }else{
                    datos2[6] = "Vigente "+DiferenciaFechas(fecha.getTime(),res.getDate("b.fechavenceinscripcion"),2)+" días.";
                }
                
                modelo2.addRow(datos2);
            }
            
            connection = Conectar.getConnection();
            PreparedStatement ps1 = connection.prepareStatement("SELECT * FROM estadoinscripcioncategoria b, datospersonales a WHERE a.cedula = b.cedula");
            ResultSet res1 = ps1.executeQuery();
            
            while(res1.next()){
                
                //getDatosAfiliado(res1.getInt("cedula"), datos4, modelo4, tblEstadosInscripcionesC);
                datos4[0] = res1.getString("a.nombre");
                datos4[1] = res1.getString("a.apellido");
                datos4[2] = res1.getString("a.cedula");
                datos4[3] = res1.getString("b.categoria");
                datos4[4] = res1.getString("b.costo");
                datos4[5] = res1.getString("b.fechainscripcion");
                datos4[6] = res1.getString("b.fechavenceinscripcion");
                
                if(res1.getDate("b.fechavenceinscripcion").before(fecha.getTime())){ 
                    datos4[7] = "*Pendiente "+DiferenciaFechas(res1.getDate("b.fechavenceinscripcion"),fecha.getTime(),2)+" días.";

                    if(res1.getString("vencimiento").equals("Indefinido")){
                        datos4[7] = "Indefinido";
                    }
                }else{
                    datos4[7] = "Vigente "+DiferenciaFechas(fecha.getTime(),res1.getDate("b.fechavenceinscripcion"),2)+" días.";
                }

                modelo4.addRow(datos4);
            }
            
            connection = Conectar.getConnection();
            PreparedStatement ps2 = connection.prepareStatement("SELECT * FROM estadomembresiasakura b, datospersonales a WHERE a.cedula = b.cedula");
            ResultSet res2 = ps2.executeQuery();
            
            while(res2.next()){
                
                //getDatosAfiliado(res2.getInt("cedula"), datos3, modelo3, tblEstadosMembresiasS);
                datos3[0] = res2.getString("a.nombre");
                datos3[1] = res2.getString("a.apellido");
                datos3[2] = res2.getString("a.cedula");
                datos3[3] = res2.getString("b.costo");
                datos3[4] = res2.getString("b.fechamembresia");
                datos3[5] = res2.getString("b.fechavencemembresia");
                
                if(res2.getDate("b.fechavencemembresia").before(fecha.getTime())){ 
                    datos3[6] = "*Pendiente "+DiferenciaFechas(res2.getDate("b.fechavencemembresia"),fecha.getTime(),2)+" días.";

                    if(res2.getString("vencimiento").equals("Indefinido")){
                        datos3[6] = "Indefinido";
                    }
                }else{
                    datos3[6]= "Vigente "+DiferenciaFechas(fecha.getTime(),res2.getDate("b.fechavencemembresia"),2)+" días.";
                }

                modelo3.addRow(datos3);
            }
            
            connection = Conectar.getConnection();
            PreparedStatement ps3 = connection.prepareStatement("SELECT * FROM estadomembresiacategoria b, datospersonales a WHERE a.cedula = b.cedula");
            ResultSet res3 = ps3.executeQuery();
            
            while(res3.next()){
                
                //getDatosAfiliado(res3.getInt("cedula"), datos5, modelo5, tblEstadosMembresiasC);
                datos5[0] = res3.getString("a.nombre");
                datos5[1] = res3.getString("a.apellido");
                datos5[2] = res3.getString("a.cedula");
                datos5[3] = res3.getString("b.categoria");
                datos5[4] = res3.getString("b.costo");
                datos5[5] = res3.getString("b.fechamembresia");
                datos5[6] = res3.getString("b.fechavencemembresia");
                
                if(res3.getDate("b.fechavencemembresia").before(fecha.getTime())){ 
                    datos5[7] = "*Pendiente "+DiferenciaFechas(res3.getDate("b.fechavencemembresia"),fecha.getTime(),2)+" días.";

                    if(res3.getString("vencimiento").equals("Indefinido")){
                        datos5[7] = "Indefinido";
                    }
                }else{
                    datos5[7] = "Vigente "+DiferenciaFechas(fecha.getTime(),res3.getDate("b.fechavencemembresia"),2)+" días.";
                }

                modelo5.addRow(datos5);
            }

            tblEstadosInscripcionesS.setModel(modelo2);
            tblEstadosMembresiasS.setModel(modelo3);
            tblEstadosInscripcionesC.setModel(modelo4);
            tblEstadosMembresiasC.setModel(modelo5);
            
        }catch (SQLException ex){ JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(),"Aviso",JOptionPane.WARNING_MESSAGE); }
    }

    private void InsertDatosEnTablaKaratecas() throws SQLException{
        
        modelo6.setRowCount(0);
        
        try{
            connection = Conectar.getConnection();
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM estadoinscripcioncategoria WHERE categoria = 'Karate'");
            
            while(res.next()){
                
                Statement st1 = connection.createStatement();
                ResultSet res1 = st1.executeQuery("SELECT * FROM datospersonales WHERE cedula = '"+res.getString("cedula")+"'");

                while(res1.next()){

                    datos6[2] = res1.getString("cedula");
                    datos6[0] = res1.getString("nombre");
                    datos6[1] = res1.getString("apellido");

                    modelo6.addRow(datos6);

                    /*InhabilitarDatosPersonales();
                    InhabilitarDatosInscripcion();*/
                }
                
            }

            tblKarate.setModel(modelo6);
            
        }catch (SQLException ex){ JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(),"Aviso",JOptionPane.WARNING_MESSAGE); }
    }
    
    private void InsertDatosEnTablaDanzinas() throws SQLException{
        
        modelo7.setRowCount(0);
        
        try{
            connection = Conectar.getConnection();
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM estadoinscripcioncategoria WHERE categoria = 'Danza'");
            
            while(res.next()){
                
                Statement st1 = connection.createStatement();
                ResultSet res1 = st1.executeQuery("SELECT * FROM datospersonales WHERE cedula = '"+res.getString("cedula")+"'");

                while(res1.next()){

                    datos7[2] = res1.getString("cedula");
                    datos7[0] = res1.getString("nombre");
                    datos7[1] = res1.getString("apellido");

                    modelo7.addRow(datos7);
                }
                
            }

            tblDanza.setModel(modelo7);
            
        }catch (SQLException ex){ JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(),"Aviso",JOptionPane.WARNING_MESSAGE); }
    }
    
    private void TVtblKarateMouseClicked(){

        try{
            int fila = tblKarate.getSelectedRow();
            int filaModel = tblKarate.convertRowIndexToModel(fila); //CONVIERTE LA FILA AL MODELO

            tblKarate.convertRowIndexToView(filaModel); //CONVIERTE LA FILA A LA VISTA
            modelo6.fireTableDataChanged(); //POR SI HAY ALGUN ERROR, AVISA QUE LA TABLA HA CAMBIADO

            String tableClick = (tblKarate.getModel().getValueAt(filaModel, 2).toString());

            connection = Conectar.getConnection();
            PreparedStatement pst = connection.prepareStatement("SELECT * FROM datospersonales WHERE cedula = '"+tableClick+"'");
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                
                InsertDatosEnTablaCompetencias("karate",rs.getInt("cedula"));

            }

        }catch(SQLException e){ JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+e.getMessage(),"Aviso",JOptionPane.WARNING_MESSAGE); }
    }
    
    private void TVtblDanzaMouseClicked(){

        try{
            int fila = tblDanza.getSelectedRow();
            int filaModel = tblDanza.convertRowIndexToModel(fila); //CONVIERTE LA FILA AL MODELO

            tblDanza.convertRowIndexToView(filaModel); //CONVIERTE LA FILA A LA VISTA
            modelo7.fireTableDataChanged(); //POR SI HAY ALGUN ERROR, AVISA QUE LA TABLA HA CAMBIADO

            String tableClick = (tblDanza.getModel().getValueAt(filaModel, 2).toString());

            connection = Conectar.getConnection();
            PreparedStatement pst = connection.prepareStatement("SELECT * FROM datospersonales WHERE cedula = '"+tableClick+"'");
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                
                InsertDatosEnTablaCompetencias("danza",rs.getInt("cedula"));

            }

        }catch(SQLException e){ JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+e.getMessage(),"Aviso",JOptionPane.WARNING_MESSAGE); }
    }
    
    private void InsertDatosEnTablaCompetencias(String tipo, int cedula) throws SQLException{
        
        modelo8.setRowCount(0);
        
        if(tipo.equals("karate")){
            
            try{
                connection = Conectar.getConnection();
                Statement st = connection.createStatement();
                ResultSet res = st.executeQuery("SELECT * FROM trayectokarate WHERE cedula = '"+cedula+"'");

                while(res.next()){

                    datos8[1] = res.getString("nombrecompetencia");
                    datos8[2] = res.getString("categoria");
                    datos8[3] = res.getString("lugar");
                    datos8[0] = res.getString("id");

                    modelo8.addRow(datos8);

                    /*InhabilitarDatosPersonales();
                    InhabilitarDatosInscripcion();*/
                }

                tblCompetencias.setModel(modelo8);
            
            }catch (SQLException ex){ JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(),"Aviso",JOptionPane.WARNING_MESSAGE); }
        }
        
        if(tipo.equals("danza")){
            
            try{
                connection = Conectar.getConnection();
                Statement st = connection.createStatement();
                ResultSet res = st.executeQuery("SELECT * FROM trayectodanza WHERE cedula = '"+cedula+"'");

                while(res.next()){

                    datos8[1] = res.getString("nombrecompetencia");
                    datos8[2] = res.getString("categoria");
                    datos8[3] = res.getString("lugar");
                    datos8[0] = res.getString("id");

                    modelo8.addRow(datos8);

                    /*InhabilitarDatosPersonales();
                    InhabilitarDatosInscripcion();*/
                }

                tblCompetencias.setModel(modelo8);
            
        }catch (SQLException ex){ JOptionPane.showInternalMessageDialog(pnlFondo, "Error: "+ex.getMessage(),"Aviso",JOptionPane.WARNING_MESSAGE); }
        }
        
    }
    
    public long DiferenciaFechas(Date fechaInicio, Date fechaFin, int tipo){
        
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
    private elaprendiz.gui.comboBox.ComboBoxRectIcon cbBuscar;
    private elaprendiz.gui.comboBox.ComboBoxRectIcon cbBuscar1;
    private elaprendiz.gui.comboBox.ComboBoxRectIcon cbBuscar2;
    private elaprendiz.gui.comboBox.ComboBoxRectIcon cbBuscar3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel pnlBuscador;
    private javax.swing.JPanel pnlBuscadorCompetencia;
    private javax.swing.JPanel pnlBuscadorCompetidor;
    private javax.swing.JPanel pnlBuscadorCompetidor1;
    private elaprendiz.gui.panel.PanelImage pnlBuscar;
    private elaprendiz.gui.panel.PanelImage pnlBuscar1;
    private elaprendiz.gui.panel.PanelImage pnlBuscar2;
    private elaprendiz.gui.panel.PanelCurves pnlCurvas;
    private elaprendiz.gui.panel.PanelImage pnlFondo;
    private javax.swing.JPanel pnlTabla;
    private javax.swing.JPanel pnlTablaCompetencia;
    private javax.swing.JPanel pnlTablaCompetencia1;
    private javax.swing.JPanel pnlTablaCompetidor;
    private javax.swing.JPanel pnlTablaCompetidor1;
    private javax.swing.JPanel pnlTablaCompetidor2;
    private elaprendiz.gui.progressBar.ProgressBarRound progressbarBarra;
    private javax.swing.JScrollPane scrollTabla;
    private javax.swing.JScrollPane scrollTabla1;
    private javax.swing.JScrollPane scrollTabla2;
    private javax.swing.JScrollPane scrollTabla3;
    private javax.swing.JScrollPane scrollTabla4;
    private javax.swing.JScrollPane scrollTabla5;
    private javax.swing.JScrollPane scrollTabla6;
    private javax.swing.JScrollPane scrollTabla7;
    private javax.swing.JScrollPane scrollTabla8;
    private elaprendiz.gui.tabbedPane.TabbedPaneRound tabbedPaneRound1;
    private elaprendiz.gui.tabbedPane.TabbedPaneRound tabbedPaneRound2;
    private elaprendiz.gui.tabbedPane.TabbedSelector2 tbbEstados;
    private elaprendiz.gui.tabbedPane.TabbedSelector2 tbbEstados1;
    private javax.swing.JTable tblAfiliados;
    private javax.swing.JTable tblCompetencias;
    private javax.swing.JTable tblDanza;
    private javax.swing.JTable tblEstado;
    private javax.swing.JTable tblEstadosInscripcionesC;
    private javax.swing.JTable tblEstadosInscripcionesS;
    private javax.swing.JTable tblEstadosMembresiasC;
    private javax.swing.JTable tblEstadosMembresiasS;
    private javax.swing.JTable tblKarate;
    private elaprendiz.gui.textField.TextFieldRectIcon txtBuscar;
    private elaprendiz.gui.textField.TextFieldRectIcon txtBuscar2;
    private elaprendiz.gui.textField.TextFieldRectIcon txtBuscar3;
    // End of variables declaration//GEN-END:variables
}
