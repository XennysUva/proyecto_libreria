package Composite;

import Vista.*;
import Abstractfactory.EditorialFactoryAbs;
import Modelo.Estudiantes;
import Modelo.Editorial;
import Abstractfactory.EditorialAF;
import Modelo.Libros;
import Modelo.Prestamos;
import Builder.Director;
import Abstractfactory.EditorialDigitalAF;
import Abstractfactory.EditorialFisicaAF;
import Servicios.EditorialS;
import Abstractfactory.EditorialSAF;
import Servicios.EstudianteS;
import Builder.LibroBuilder;
import Servicios.LibrosS;
import Servicios.PrestamosS;
import java.awt.event.KeyEvent;  
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Principal extends javax.swing.JFrame {
    
// Servicios
private final EstudianteS estudiantesService = EstudianteS.getInstancia();
private final EditorialS editorialService = EditorialS.getInstancia();
private final EditorialSAF editorialServiceAF = EditorialSAF.getInstancia();
private final PrestamosS prestamosService = PrestamosS.getInstancia();
private CategoriaLibro categoria; 


    // Modelos de Tabla
    private final DefaultTableModel modeloEstudiantes;
    private final DefaultTableModel modeloEditoriales;
    private final DefaultTableModel modeloLibros;
    private final DefaultTableModel modeloPrestamos;
    
    // Inicializa servicios y modelos SINGLETON
        EstudianteS estudiantesServiceInst =EstudianteS.getInstancia();
        EditorialS editorialServiceInst = EditorialS.getInstancia();
        ArrayList<Prestamos> listaPrestamosInst = new ArrayList<>();
        PrestamosS prestamosServiceInst = PrestamosS.getInstancia();
        
    //para inicializar
    public Principal() {
        initComponents();
        this.setLocationRelativeTo(null);

        modeloEstudiantes = new DefaultTableModel();
        modeloEditoriales = new DefaultTableModel();
        modeloLibros = new DefaultTableModel();
        modeloPrestamos = new DefaultTableModel();

        // Configura la interfaz
        configureUI();
    }
    private void configureUI() {
        mostrarCabecerasEstu();
        mostrarTodosEstudiantes();

        mostrarCabecerasEdi();
        mostrarTodosEditoriales();
        cargaComboRuc();

        mostrarCabecerasLib();

        mostrarCabecerasPres();
        mostrarTodosPrestamos();
        txtCod_prestamos.setText(prestamosService.generarID());
    }


    public void mostrarCabecerasEstu() {
        modeloEstudiantes.addColumn("DNI");
        modeloEstudiantes.addColumn("Nombres");
        modeloEstudiantes.addColumn("Apellidos");
        modeloEstudiantes.addColumn("Grado");
        modeloEstudiantes.addColumn("Seccion");
        jTable1.setModel(modeloEstudiantes);
    }
    
    private void mostrarTodosEstudiantes() {
        ArrayList<Estudiantes> estudiantes = estudiantesService.listarTodo();
        for (Estudiantes estudiante : estudiantes) {
            Object[] data = {estudiante.getDni(), estudiante.getNombres(), estudiante.getApellidos(), estudiante.getGrado(), estudiante.getSeccion()};
            modeloEstudiantes.addRow(data);
        }
    }

    private void limpiarCajas() {
        txtDni.setText(null);
        txtNombres.setText(null);
        txtApellidos.setText(null);
        txtGrado.setText(null);
        txtSeccion.setText(null);
    }


    private void mostrarCabecerasEdi() {
        modeloEditoriales.addColumn("Cod_editorial");
        modeloEditoriales.addColumn("Nom_Editorial");
        modeloEditoriales.addColumn("Telefono");
        modeloEditoriales.addColumn("Categoria");
        jTable2.setModel(modeloEditoriales);
    }

    public void limpiarCajasEdi() {
        txtCod_editorial.setText(null);
        txtNom_Editorial.setText(null);
        txtTelefono.setText(null);
    }

    private void mostrarTodosEditoriales() {
        ArrayList<Editorial> editoriales = editorialService.listarTodo();
        for (Editorial editorial : editoriales) {
            Object[] data = {editorial.getCod_editorial(), editorial.getNom_editorial(), editorial.getTelefono()};
            modeloEditoriales.addRow(data);
        }
    }

    private void cargaComboRuc() {
        cbxEditorial.removeAllItems();
        cbxEditorial.addItem("Elegir");
        for (Editorial editorial : editorialService.listarTodo()) {
            cbxEditorial.addItem(editorial.getCod_editorial() + "-" + editorial.getNom_editorial());
        }
    }


    private void mostrarCabecerasLib() {
        modeloLibros.addColumn("Cod_libro");
        modeloLibros.addColumn("Nom_libro");
        modeloLibros.addColumn("Stock");
        modeloLibros.addColumn("Autor");
        modeloLibros.addColumn("Cod_editorial");
        modeloLibros.addColumn("Categoría");
        jTable17.setModel(modeloLibros);
    }

    private void limpiarCajasLib() {
        txtCod_libro.setText(null);
        txtNom_libro.setText(null);
        txtStock.setText(null);
        txtAutor.setText(null);
    }


    //Metodos de los prestamos
    private void mostrarCabecerasPres() {
        modeloPrestamos.addColumn("Cod_libro");
        modeloPrestamos.addColumn("DNI");
        modeloPrestamos.addColumn("Cod_prestamos");
        modeloPrestamos.addColumn("Fec_pres");
        modeloPrestamos.addColumn("Fec_devo");
        jTable4.setModel(modeloPrestamos);
    }


    private void mostrarTodosPrestamos() {
        ArrayList<Prestamos> prestamos = prestamosService.listarTodo();
        for (Prestamos prestamo : prestamos) {
            Object[] data = {prestamo.getCod_libro(), prestamo.getDni(), prestamo.getCod_prestamo(), prestamo.getFec_pres(), prestamo.getFec_devo()};
            modeloPrestamos.addRow(data);
        }
    }

    private void limpiarCajaspre() {
        txtClpres.setText(null);
        txtDnipres.setText(null);
        txtCod_prestamos.setText(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlEstudiantes = new javax.swing.JPanel();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        btnAgregarEstu = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtDni = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtGrado = new javax.swing.JTextField();
        txtSeccion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Seccionxd = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnBuscarE = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        pnlEditorial = new javax.swing.JPanel();
        jDesktopPane8 = new javax.swing.JDesktopPane();
        txtCod_editorial = new javax.swing.JTextField();
        txtNom_Editorial = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        btnAgregarEditorial = new javax.swing.JButton();
        btnEliminarEditorial = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnBuscarEdi = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        cbxCategoria = new javax.swing.JComboBox<>();
        pnlLibro13 = new javax.swing.JPanel();
        jDesktopPane5 = new javax.swing.JDesktopPane();
        txtCod_libro = new javax.swing.JTextField();
        txtNom_libro = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        txtAutor = new javax.swing.JTextField();
        btnAgregar_libro = new javax.swing.JButton();
        btnEliminar_libro = new javax.swing.JButton();
        cbxEditorial = new javax.swing.JComboBox<>();
        btnAgregarExis = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btnBuscarl = new javax.swing.JButton();
        jScrollPane17 = new javax.swing.JScrollPane();
        jTable17 = new javax.swing.JTable();
        btnConstruir_libro = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        jTable18 = new javax.swing.JTable();
        cbxCategoriaL = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        cbxCategoriasF = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        btnListarLibros = new javax.swing.JButton();
        pnlPrestamos = new javax.swing.JPanel();
        jDesktopPane7 = new javax.swing.JDesktopPane();
        txtCod_prestamos = new javax.swing.JTextField();
        btnAgregar_prestamo = new javax.swing.JButton();
        btnEliminar_prestamo = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btnBuscarPre = new javax.swing.JButton();
        txtClpres = new javax.swing.JTextField();
        txtDnipres = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jclFec_pres = new com.toedter.calendar.JDateChooser();
        jclFec_devo = new com.toedter.calendar.JDateChooser();
        btnClonar_prestamo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Biblioteca Virtual -- Principal");
        setResizable(false);

        btnAgregarEstu.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnAgregarEstu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/GuardarTodo.png"))); // NOI18N
        btnAgregarEstu.setText("Agregar Estudiante");
        btnAgregarEstu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEstuActionPerformed(evt);
            }
        });
        btnAgregarEstu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAgregarEstuKeyPressed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar Estudiante");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        txtDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniActionPerformed(evt);
            }
        });
        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDniKeyPressed(evt);
            }
        });

        txtNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresActionPerformed(evt);
            }
        });
        txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombresKeyPressed(evt);
            }
        });

        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });

        txtGrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGradoActionPerformed(evt);
            }
        });

        txtSeccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSeccionActionPerformed(evt);
            }
        });
        txtSeccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSeccionKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DNI ");

        Seccionxd.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        Seccionxd.setForeground(new java.awt.Color(255, 255, 255));
        Seccionxd.setText("Sección");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Grado");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombres");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Apellidos");

        btnBuscarE.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        btnBuscarE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        btnBuscarE.setText("Buscar Estudiante");
        btnBuscarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "DNI", "Nombres", "Apellidos", "Grado", "Seccion"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jDesktopPane2.setLayer(btnAgregarEstu, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(btnEliminar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(txtDni, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(txtNombres, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(txtApellidos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(txtGrado, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(txtSeccion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(Seccionxd, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(btnBuscarE, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jDesktopPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jDesktopPane2Layout.createSequentialGroup()
                            .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Seccionxd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtGrado, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jDesktopPane2Layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jDesktopPane2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAgregarEstu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBuscarE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Seccionxd, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(btnAgregarEstu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscarE, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        javax.swing.GroupLayout pnlEstudiantesLayout = new javax.swing.GroupLayout(pnlEstudiantes);
        pnlEstudiantes.setLayout(pnlEstudiantesLayout);
        pnlEstudiantesLayout.setHorizontalGroup(
            pnlEstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEstudiantesLayout.createSequentialGroup()
                .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        pnlEstudiantesLayout.setVerticalGroup(
            pnlEstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane2)
        );

        jTabbedPane1.addTab("Estudiantes", new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Clientes.png")), pnlEstudiantes); // NOI18N

        jDesktopPane8.setForeground(new java.awt.Color(255, 255, 255));

        txtCod_editorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCod_editorialActionPerformed(evt);
            }
        });
        txtCod_editorial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCod_editorialKeyPressed(evt);
            }
        });

        txtNom_Editorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNom_EditorialActionPerformed(evt);
            }
        });

        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyPressed(evt);
            }
        });

        btnAgregarEditorial.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        btnAgregarEditorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/GuardarTodo.png"))); // NOI18N
        btnAgregarEditorial.setText("Agregar Editorial");
        btnAgregarEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEditorialActionPerformed(evt);
            }
        });

        btnEliminarEditorial.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        btnEliminarEditorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        btnEliminarEditorial.setText("Eliminar Editorial");
        btnEliminarEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEditorialActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Categoria");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Telefono");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Nom editorial");

        btnBuscarEdi.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        btnBuscarEdi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        btnBuscarEdi.setText("Buscar Editorial");
        btnBuscarEdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEdiActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel22.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Cod editorial");

        cbxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Física", "Digital" }));

        jDesktopPane8.setLayer(txtCod_editorial, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane8.setLayer(txtNom_Editorial, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane8.setLayer(txtTelefono, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane8.setLayer(btnAgregarEditorial, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane8.setLayer(btnEliminarEditorial, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane8.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane8.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane8.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane8.setLayer(btnBuscarEdi, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane8.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane8.setLayer(jLabel22, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane8.setLayer(cbxCategoria, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane8Layout = new javax.swing.GroupLayout(jDesktopPane8);
        jDesktopPane8.setLayout(jDesktopPane8Layout);
        jDesktopPane8Layout.setHorizontalGroup(
            jDesktopPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane8Layout.createSequentialGroup()
                .addGroup(jDesktopPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane8Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(jDesktopPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBuscarEdi, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminarEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregarEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jDesktopPane8Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jDesktopPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jDesktopPane8Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane8Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane8Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtNom_Editorial, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDesktopPane8Layout.createSequentialGroup()
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCod_editorial, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        jDesktopPane8Layout.setVerticalGroup(
            jDesktopPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane8Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(jDesktopPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCod_editorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNom_Editorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDesktopPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addComponent(btnAgregarEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscarEdi, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminarEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
            .addGroup(jDesktopPane8Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlEditorialLayout = new javax.swing.GroupLayout(pnlEditorial);
        pnlEditorial.setLayout(pnlEditorialLayout);
        pnlEditorialLayout.setHorizontalGroup(
            pnlEditorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane8)
        );
        pnlEditorialLayout.setVerticalGroup(
            pnlEditorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane8)
        );

        jTabbedPane1.addTab("Editorial", new javax.swing.ImageIcon(getClass().getResource("/Imagenes/proveedor.png")), pnlEditorial); // NOI18N

        txtCod_libro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCod_libroActionPerformed(evt);
            }
        });

        txtNom_libro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNom_libroActionPerformed(evt);
            }
        });

        txtStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockActionPerformed(evt);
            }
        });

        btnAgregar_libro.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        btnAgregar_libro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/GuardarTodo.png"))); // NOI18N
        btnAgregar_libro.setText("Agregar Libro");
        btnAgregar_libro.setToolTipText("");
        btnAgregar_libro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar_libroActionPerformed(evt);
            }
        });

        btnEliminar_libro.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        btnEliminar_libro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        btnEliminar_libro.setText("Eliminar Libro");
        btnEliminar_libro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar_libroActionPerformed(evt);
            }
        });

        cbxEditorial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEditorialActionPerformed(evt);
            }
        });

        btnAgregarExis.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        btnAgregarExis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nuevo.png"))); // NOI18N
        btnAgregarExis.setText("Agregar Libro Existente");
        btnAgregarExis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarExisActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Nombre libro");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Autor");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Stock");

        jLabel19.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Selec editorial");

        btnBuscarl.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        btnBuscarl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        btnBuscarl.setText("Buscar por nombre y/o Autor");
        btnBuscarl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarlActionPerformed(evt);
            }
        });

        jTable17.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane17.setViewportView(jTable17);

        btnConstruir_libro.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        btnConstruir_libro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/libros2 (1).png"))); // NOI18N
        btnConstruir_libro.setText("Crear Libro");
        btnConstruir_libro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConstruir_libroActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Codigo libro");

        jTable18.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane18.setViewportView(jTable18);

        cbxCategoriaL.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ficción", "No Ficción", "Ciencia", "Historia" }));

        jLabel21.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Categoria");

        cbxCategoriasF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ficción", "No Ficción", "Ciencia", "Historia" }));
        cbxCategoriasF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCategoriasFActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Filtrar por Categoría");

        btnListarLibros.setText("Listar Libros");
        btnListarLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarLibrosActionPerformed(evt);
            }
        });

        jDesktopPane5.setLayer(txtCod_libro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane5.setLayer(txtNom_libro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane5.setLayer(txtStock, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane5.setLayer(txtAutor, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane5.setLayer(btnAgregar_libro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane5.setLayer(btnEliminar_libro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane5.setLayer(cbxEditorial, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane5.setLayer(btnAgregarExis, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane5.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane5.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane5.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane5.setLayer(jLabel19, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane5.setLayer(btnBuscarl, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane5.setLayer(jScrollPane17, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane5.setLayer(btnConstruir_libro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane5.setLayer(jLabel18, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane5.setLayer(jScrollPane18, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane5.setLayer(cbxCategoriaL, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane5.setLayer(jLabel21, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane5.setLayer(cbxCategoriasF, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane5.setLayer(jLabel23, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane5.setLayer(btnListarLibros, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane5Layout = new javax.swing.GroupLayout(jDesktopPane5);
        jDesktopPane5.setLayout(jDesktopPane5Layout);
        jDesktopPane5Layout.setHorizontalGroup(
            jDesktopPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane5Layout.createSequentialGroup()
                .addGroup(jDesktopPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jDesktopPane5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel23)
                        .addGap(35, 35, 35)
                        .addComponent(cbxCategoriasF, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane5Layout.createSequentialGroup()
                        .addGroup(jDesktopPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane5Layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addGroup(jDesktopPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnBuscarl)
                                    .addComponent(btnEliminar_libro, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAgregarExis, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAgregar_libro, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnConstruir_libro, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jDesktopPane5Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(jDesktopPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(jDesktopPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbxEditorial, 0, 212, Short.MAX_VALUE)
                                    .addComponent(txtAutor, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                                    .addComponent(txtNom_libro, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                                    .addComponent(txtStock, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jDesktopPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(jDesktopPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCod_libro, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                                    .addComponent(cbxCategoriaL, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(jDesktopPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane5Layout.createSequentialGroup()
                                .addComponent(btnListarLibros)
                                .addGap(9, 9, 9)))))
                .addGap(76, 76, 76))
        );
        jDesktopPane5Layout.setVerticalGroup(
            jDesktopPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane5Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jDesktopPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCod_libro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxCategoriaL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(txtNom_libro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane5Layout.createSequentialGroup()
                        .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane5Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addGroup(jDesktopPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(btnAgregar_libro)
                .addGap(18, 18, 18)
                .addComponent(btnAgregarExis)
                .addGap(18, 18, 18)
                .addComponent(btnBuscarl)
                .addGap(18, 18, 18)
                .addComponent(btnConstruir_libro)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar_libro)
                .addGap(16, 16, 16))
            .addGroup(jDesktopPane5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxCategoriasF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnListarLibros)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlLibro13Layout = new javax.swing.GroupLayout(pnlLibro13);
        pnlLibro13.setLayout(pnlLibro13Layout);
        pnlLibro13Layout.setHorizontalGroup(
            pnlLibro13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLibro13Layout.createSequentialGroup()
                .addComponent(jDesktopPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlLibro13Layout.setVerticalGroup(
            pnlLibro13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane5)
        );

        jTabbedPane1.addTab("Libro", new javax.swing.ImageIcon(getClass().getResource("/Imagenes/libros2 (1).png")), pnlLibro13); // NOI18N

        txtCod_prestamos.setEditable(false);
        txtCod_prestamos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCod_prestamosActionPerformed(evt);
            }
        });

        btnAgregar_prestamo.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        btnAgregar_prestamo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/GuardarTodo.png"))); // NOI18N
        btnAgregar_prestamo.setText("Agregar Prestamo");
        btnAgregar_prestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar_prestamoActionPerformed(evt);
            }
        });

        btnEliminar_prestamo.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        btnEliminar_prestamo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        btnEliminar_prestamo.setText("Eliminar Prestamo");
        btnEliminar_prestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar_prestamoActionPerformed(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Codigo libro");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Codigo prestamo");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("DNI");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Fecha prestamo");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Fecha devolucion");

        btnBuscarPre.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        btnBuscarPre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        btnBuscarPre.setText("Buscar Prestamos");
        btnBuscarPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPreActionPerformed(evt);
            }
        });

        txtClpres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClpresActionPerformed(evt);
            }
        });

        txtDnipres.setToolTipText("");
        txtDnipres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDnipresActionPerformed(evt);
            }
        });

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cod_libro", "DNI", "Cod_presta", "Fec_pres", "Fec_devo"
            }
        ));
        jScrollPane4.setViewportView(jTable4);

        jclFec_pres.setDateFormatString("yyyy/MM/dd");

        jclFec_devo.setDateFormatString("yyyy/MM/dd");

        btnClonar_prestamo.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        btnClonar_prestamo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/GuardarTodo.png"))); // NOI18N
        btnClonar_prestamo.setText("Clonar Prestamo");
        btnClonar_prestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClonar_prestamoActionPerformed(evt);
            }
        });

        jDesktopPane7.setLayer(txtCod_prestamos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane7.setLayer(btnAgregar_prestamo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane7.setLayer(btnEliminar_prestamo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane7.setLayer(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane7.setLayer(jLabel14, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane7.setLayer(jLabel15, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane7.setLayer(jLabel16, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane7.setLayer(jLabel17, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane7.setLayer(btnBuscarPre, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane7.setLayer(txtClpres, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane7.setLayer(txtDnipres, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane7.setLayer(jScrollPane4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane7.setLayer(jclFec_pres, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane7.setLayer(jclFec_devo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane7.setLayer(btnClonar_prestamo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane7Layout = new javax.swing.GroupLayout(jDesktopPane7);
        jDesktopPane7.setLayout(jDesktopPane7Layout);
        jDesktopPane7Layout.setHorizontalGroup(
            jDesktopPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane7Layout.createSequentialGroup()
                .addGroup(jDesktopPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane7Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jDesktopPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane7Layout.createSequentialGroup()
                                .addGroup(jDesktopPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jDesktopPane7Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(jDesktopPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(26, 26, 26))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane7Layout.createSequentialGroup()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addGroup(jDesktopPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCod_prestamos, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jclFec_pres, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDnipres, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtClpres, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40))
                            .addGroup(jDesktopPane7Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jclFec_devo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(37, 37, 37))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane7Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jDesktopPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBuscarPre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAgregar_prestamo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminar_prestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnClonar_prestamo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(76, 76, 76)))
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jDesktopPane7Layout.setVerticalGroup(
            jDesktopPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane7Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(jDesktopPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtClpres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtDnipres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCod_prestamos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jclFec_pres, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(26, 26, 26)
                .addGroup(jDesktopPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jclFec_devo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(44, 44, 44)
                .addComponent(btnAgregar_prestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscarPre, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnClonar_prestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar_prestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(jDesktopPane7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlPrestamosLayout = new javax.swing.GroupLayout(pnlPrestamos);
        pnlPrestamos.setLayout(pnlPrestamosLayout);
        pnlPrestamosLayout.setHorizontalGroup(
            pnlPrestamosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane7)
        );
        pnlPrestamosLayout.setVerticalGroup(
            pnlPrestamosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane7)
        );

        jTabbedPane1.addTab("Prestamos", new javax.swing.ImageIcon(getClass().getResource("/Imagenes/prestmo (1).png")), pnlPrestamos); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1027, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniActionPerformed
        txtNombres.requestFocus();
    }//GEN-LAST:event_txtDniActionPerformed
    public boolean validarDn(String datos) {
         return datos.matches("\\d+");
    }

    private void btnAgregarEstuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEstuActionPerformed
        String dni = txtDni.getText().trim();
    String nombres = txtNombres.getText().trim();
    String apellidos = txtApellidos.getText().trim();
    String grado = txtGrado.getText().trim();
    String seccion = txtSeccion.getText().trim();

    // Validación básica
    if (dni.isEmpty() || nombres.isEmpty() || apellidos.isEmpty() || grado.isEmpty() || seccion.isEmpty()) {
        JOptionPane.showInternalMessageDialog(null, "Los campos no pueden estar vacíos.", "Campos Vacíos!!", JOptionPane.WARNING_MESSAGE);
    } else if (!validarDn(dni) || dni.length() != 8 || seccion.length() != 1) {
        JOptionPane.showInternalMessageDialog(null, "El DNI debe tener 8 dígitos y la sección un solo carácter.", "Verificar Datos!!", JOptionPane.ERROR_MESSAGE);
    } else {
        // Validar si el DNI ya existe en el modelo de estudiantes
        if (estudiantesService.validarDni(dni) > 0) {
            JOptionPane.showInternalMessageDialog(null, "El DNI ya está registrado.", "DNI Existente!!", JOptionPane.ERROR_MESSAGE);
        } else {
            // Agregar estudiante a la lista estática y al modelo
            Estudiantes est = new Estudiantes();
            est.setDni(dni);
            est.setNombres(nombres);
            est.setApellidos(apellidos);
            est.setGrado(grado);
            est.setSeccion(seccion);
            estudiantesService.insertar(est); // Agregar a la lista estática

            Object[] data = {dni, nombres, apellidos, grado, seccion};
            modeloEstudiantes.addRow(data);
            JOptionPane.showInternalMessageDialog(null, "Estudiante registrado correctamente.", "Registro Exitoso!!", JOptionPane.INFORMATION_MESSAGE);
            limpiarCajas();
        }
    }
    }//GEN-LAST:event_btnAgregarEstuActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        int fila = jTable1.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showInternalMessageDialog(null, "Seleccione un estudiante para eliminar.", "Selección Requerida!!", JOptionPane.ERROR_MESSAGE);
        } else {
            // Elimina la fila seleccionada
            modeloEstudiantes.removeRow(fila);
            JOptionPane.showInternalMessageDialog(null, "Estudiante eliminado correctamente.", "Eliminación Exitosa!!", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresActionPerformed
        txtApellidos.requestFocus();
    }//GEN-LAST:event_txtNombresActionPerformed

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        txtGrado.requestFocus();
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void txtGradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGradoActionPerformed
        txtSeccion.requestFocus();
    }//GEN-LAST:event_txtGradoActionPerformed

    private void txtSeccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSeccionActionPerformed

    }//GEN-LAST:event_txtSeccionActionPerformed

    private void txtSeccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSeccionKeyPressed
        if (evt.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
            btnAgregarEstu.requestFocus();
            btnAgregarEstu.doClick();
        }
    }//GEN-LAST:event_txtSeccionKeyPressed

    private void txtCod_editorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCod_editorialActionPerformed
        txtNom_Editorial.requestFocus();
    }//GEN-LAST:event_txtCod_editorialActionPerformed
    public boolean validartl(String datos) {
        return datos.matches("[0-9]+");
    }

    private void btnAgregarEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEditorialActionPerformed
           String cod_editorial = txtCod_editorial.getText();
        String nom_editorial = txtNom_Editorial.getText();
        String telefono = txtTelefono.getText();
        if (cod_editorial.equals("") || nom_editorial.equals("") || telefono.equals("")) {
            JOptionPane.showInternalMessageDialog(null, "Los campos no pueden estar vacíos.",
                    "Campos Vacíos!!", JOptionPane.WARNING_MESSAGE);
        } else if (!validartl(telefono.trim())) {
            JOptionPane.showInternalMessageDialog(null, "Verificar si son 9 números",
                    "Revisar el Número!!", JOptionPane.ERROR_MESSAGE);
        } else if (cod_editorial.length() != 4 || telefono.length() != 9) {
            JOptionPane.showInternalMessageDialog(null, "Verificar si el COD_EDITORIAL tiene 4 caracteres y el TELEFONO tiene 9 caracteres",
                    "Verificar COD_EDITORIAL y TELEFONO!!", JOptionPane.ERROR_MESSAGE);
        } else if (editorialService.validarCodigo(cod_editorial) > 0) {
            JOptionPane.showInternalMessageDialog(null, "El COD_EDITORIAL no puede coincidir con otro COD_EDITORIAL",
                    "Verificar COD_EDITORIAL!!", JOptionPane.ERROR_MESSAGE);
        } else if (editorialService.validarTelefono(telefono) > 0) {
            JOptionPane.showInternalMessageDialog(null, "El TELEFONO no puede coincidir con otro TELEFONO",
                    "Verificar el TELEFONO!!", JOptionPane.ERROR_MESSAGE);
        } else {
            Editorial et = new Editorial();
            et.setCod_editorial(cod_editorial);
            et.setNom_editorial(nom_editorial);
            et.setTelefono(telefono);
            editorialService.insertar(et);
            cargaComboRuc(); // Actualiza el combo box con las nuevas editoriales
            Object[] data = {cod_editorial, nom_editorial, telefono};
            modeloEditoriales.addRow(data);
            JOptionPane.showInternalMessageDialog(null, "Se registró correctamente la editorial.",
                    "Registro exitoso!!", JOptionPane.INFORMATION_MESSAGE);
            limpiarCajasEdi();
        }
    }//GEN-LAST:event_btnAgregarEditorialActionPerformed

    private void btnEliminarEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEditorialActionPerformed
        int fila = jTable2.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showInternalMessageDialog(null, "Seleccione una editorial para eliminar.", "Selección Requerida!!", JOptionPane.ERROR_MESSAGE);
        } else {
            // Elimina la fila seleccionada
            modeloEditoriales.removeRow(fila);
            JOptionPane.showInternalMessageDialog(null, "Editorial eliminada correctamente.", "Eliminación Exitosa!!", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarEditorialActionPerformed
    public boolean validarSt(String datos) {
        return datos.matches("\\d+"); // Asegura que solo contenga dígitos
    }
    private void txtDniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniKeyPressed

    private void txtNombresKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresKeyPressed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtNom_EditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNom_EditorialActionPerformed
        txtTelefono.requestFocus();
    }//GEN-LAST:event_txtNom_EditorialActionPerformed

    private void btnAgregarEstuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAgregarEstuKeyPressed

    }//GEN-LAST:event_btnAgregarEstuKeyPressed

    private void txtTelefonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyPressed
        if (evt.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
            btnAgregarEditorial.requestFocus();
            btnAgregarEditorial.doClick();
        }
    }//GEN-LAST:event_txtTelefonoKeyPressed

    private void cbxEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEditorialActionPerformed

    }//GEN-LAST:event_cbxEditorialActionPerformed

    private void btnEliminar_libroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar_libroActionPerformed
        int fila = jTable17.getSelectedRow();
    
    if (fila == -1) {
        JOptionPane.showInternalMessageDialog(null, "Seleccione un libro para borrar.", "Selección Requerida!!", JOptionPane.ERROR_MESSAGE);
    } else {
        // Verificar si el libro tiene préstamos pendientes
        String cod_libro = jTable17.getValueAt(fila, 0).toString();
        boolean tienePrestamoPendiente = false;

        for (int i = 0; i < modeloPrestamos.getRowCount(); i++) {
            if (modeloPrestamos.getValueAt(i, 0).equals(cod_libro)) {
                tienePrestamoPendiente = true;
                break;
            }
        }

        if (tienePrestamoPendiente) {
            JOptionPane.showInternalMessageDialog(null, "El libro no puede eliminarse porque tiene un préstamo pendiente.", "Error!!", JOptionPane.ERROR_MESSAGE);
        } else {
            // Eliminar el libro de la tabla
            modeloLibros.removeRow(fila);
            JOptionPane.showInternalMessageDialog(null, "Libro eliminado correctamente.", "Eliminación Exitosa!!", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    }//GEN-LAST:event_btnEliminar_libroActionPerformed
private List<LibroComponent> componentes = new ArrayList<>(); 
    private void btnAgregar_libroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar_libroActionPerformed
        String cod_libro = txtCod_libro.getText().trim();
        String nom_libro = txtNom_libro.getText().trim();
        String stock = txtStock.getText().trim();
        String autor = txtAutor.getText().trim();
        String categoriaSeleccionada = cbxCategoriaL.getSelectedItem().toString(); // Obtén la categoría seleccionada

        // Validación básica de campos vacíos
        if (cod_libro.isEmpty() || nom_libro.isEmpty() || stock.isEmpty() || autor.isEmpty()) {
            JOptionPane.showInternalMessageDialog(null, "Los campos no pueden estar vacíos.", "Campos Vacíos!!", JOptionPane.WARNING_MESSAGE);
        } else if (!validarSt(stock)) {
            JOptionPane.showInternalMessageDialog(null, "El stock debe ser un número.", "Error en el Stock!!", JOptionPane.ERROR_MESSAGE);
        } else if (cod_libro.length() != 4) {
            JOptionPane.showInternalMessageDialog(null, "El código del libro debe tener 4 caracteres.", "Error en el Código!!", JOptionPane.ERROR_MESSAGE);
        } else {
            boolean codExistente = false;
            for (int i = 0; i < modeloLibros.getRowCount(); i++) {
                if (modeloLibros.getValueAt(i, 0).equals(cod_libro)) {
                    codExistente = true;
                    break;
                }
            }

            if (codExistente) {
                JOptionPane.showInternalMessageDialog(null, "El código de libro ya está registrado.", "Código Existente!!", JOptionPane.ERROR_MESSAGE);
            } else {
                // Obtener la editorial seleccionada
                String cbxEditorial1 = cbxEditorial.getSelectedItem().toString();
                String cbxEditorialv = cbxEditorial1.substring(0, 4);

                // Crear un nuevo libro y agregarlo al Composite
            LibrosM nuevoLibro = new LibrosM(cod_libro, nom_libro, stock, autor, cbxEditorialv, categoriaSeleccionada);
            LibroHoja libroHoja = new LibroHoja(nuevoLibro);

            // Buscar la categoría en el Composite, si existe
            CategoriaLibro categoria = null;
            for (LibroComponent componente : componentes) {
                if (componente instanceof CategoriaLibro && ((CategoriaLibro) componente).getNombreCategoria().equals(categoriaSeleccionada)) {
                    categoria = (CategoriaLibro) componente;
                    break;
                }
            }

            // Si la categoría no existe, crear una nueva y agregarla al Composite
            if (categoria == null) {
                categoria = new CategoriaLibro(categoriaSeleccionada);
                componentes.add(categoria);
            }

            // Agregar el libro a la categoría correspondiente
            categoria.agregarComponente(libroHoja);

                
                // Agregar el nuevo libro con la categoría seleccionada
                Object[] data = {cod_libro, nom_libro, stock, autor, cbxEditorialv, categoriaSeleccionada};
                modeloLibros.addRow(data);
                JOptionPane.showInternalMessageDialog(null, "Libro registrado correctamente.", "Registro Exitoso!!", JOptionPane.INFORMATION_MESSAGE);
                limpiarCajasLib();
            }
        }
    }//GEN-LAST:event_btnAgregar_libroActionPerformed

    private void txtStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockActionPerformed
        txtAutor.requestFocus();
    }//GEN-LAST:event_txtStockActionPerformed

    private void txtNom_libroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNom_libroActionPerformed
        txtStock.requestFocus();
    }//GEN-LAST:event_txtNom_libroActionPerformed

    private void txtCod_libroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCod_libroActionPerformed
        txtNom_libro.requestFocus();
    }//GEN-LAST:event_txtCod_libroActionPerformed

    private void btnBuscarlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarlActionPerformed
        BuscarLA la = new BuscarLA();
        la.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBuscarlActionPerformed

    private void btnBuscarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEActionPerformed
        
        
        BuscarE be = new BuscarE();
        be.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBuscarEActionPerformed

    private void btnBuscarEdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEdiActionPerformed
        Buscaredi be = new Buscaredi();
        be.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBuscarEdiActionPerformed

    private void btnAgregar_prestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar_prestamoActionPerformed
    // Obtiene los valores ingresados en los campos de texto
    String cod_libro = txtClpres.getText().trim();
    String dni = txtDnipres.getText().trim();
    String cod_prestamo = txtCod_prestamos.getText().trim();
    SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
    String fec_pres = fecha.format(jclFec_pres.getDate());
    String fec_devo = fecha.format(jclFec_devo.getDate());

    if (cod_libro.isEmpty() || dni.isEmpty() || cod_prestamo.isEmpty()) {
        JOptionPane.showInternalMessageDialog(null, "Los campos no pueden estar vacíos.", "Campos Vacíos!!", JOptionPane.WARNING_MESSAGE);
        return;
    }

    if (cod_libro.length() != 4 || dni.length() != 8) {
        JOptionPane.showInternalMessageDialog(null, "El COD_LIBRO debe tener 4 caracteres y el DNI debe tener 8 caracteres.", "Error en la Validación!!", JOptionPane.ERROR_MESSAGE);
        return;
    }

        // Verificar si el código de libro existe en el modelo de libros
        boolean libroExiste = modeloLibros.getDataVector().stream()
                .anyMatch(row -> row.get(0).equals(cod_libro));

    if (!libroExiste) {
        JOptionPane.showInternalMessageDialog(null, "El código del libro no existe.", "Error en el Código del Libro!!", JOptionPane.ERROR_MESSAGE);
        return;
    }

 // Verificar si el DNI del estudiante existe en el sistema de estudiantes
    if (estudiantesServiceInst.validarDni(dni) == 0) {
        JOptionPane.showInternalMessageDialog(null, "El DNI del estudiante no existe.", "Error en el DNI!!", JOptionPane.ERROR_MESSAGE);
        return;
    }


        // Verificar si el código de préstamo ya está registrado
        boolean codPrestamoExiste = modeloPrestamos.getDataVector().stream()
                .anyMatch(row -> row.get(2).equals(cod_prestamo));


    if (codPrestamoExiste) {
        JOptionPane.showInternalMessageDialog(null, "El código del préstamo ya está registrado.", "Error en el Código del Préstamo!!", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Crear y agregar el nuevo préstamo
    Prestamos prestamo = new Prestamos();
    prestamo.setCod_libro(cod_libro);
    prestamo.setDni(dni);
    prestamo.setCod_prestamo(cod_prestamo);
    prestamo.setFec_pres(fec_pres);
    prestamo.setFec_devo(fec_devo);

    prestamosServiceInst.insertar(prestamo);  // Usando el servicio singleton para insertar el préstamo

    // Agregar los datos del préstamo a la tabla de préstamos en la interfaz gráfica
    Object[] data = {cod_libro, dni, cod_prestamo, fec_pres, fec_devo};
    modeloPrestamos.addRow(data);

    // Mostrar mensaje de éxito
    JOptionPane.showInternalMessageDialog(null, "Préstamo registrado correctamente.", "Registro Exitoso!!", JOptionPane.INFORMATION_MESSAGE);

    // Limpiar los campos de texto
    limpiarCajaspre();

    // Generar nuevo código de préstamo
    txtCod_prestamos.setText(prestamosServiceInst.generarID());
    }//GEN-LAST:event_btnAgregar_prestamoActionPerformed

    private void btnEliminar_prestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar_prestamoActionPerformed
        int fila = jTable4.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showInternalMessageDialog(null, "Seleccione un préstamo para borrar.", "Selección Requerida!!", JOptionPane.ERROR_MESSAGE);
        } else {
            // Eliminar el préstamo de la tabla
            modeloPrestamos.removeRow(fila);
            JOptionPane.showInternalMessageDialog(null, "Préstamo eliminado correctamente.", "Eliminación Exitosa!!", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminar_prestamoActionPerformed

    private void btnBuscarPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPreActionPerformed
        BuscarPres pa = new BuscarPres();
        pa.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBuscarPreActionPerformed

    private void txtCod_editorialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCod_editorialKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCod_editorialKeyPressed

    private void txtClpresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClpresActionPerformed
        txtDnipres.requestFocus();
    }//GEN-LAST:event_txtClpresActionPerformed

    private void txtCod_prestamosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCod_prestamosActionPerformed

    }//GEN-LAST:event_txtCod_prestamosActionPerformed

    private void txtDnipresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDnipresActionPerformed
        txtCod_prestamos.requestFocus();
    }//GEN-LAST:event_txtDnipresActionPerformed

    private void btnConstruir_libroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConstruir_libroActionPerformed
        int fila = jTable17.getSelectedRow(); // Obtener la fila seleccionada en la tabla

        if (fila != -1) {
            // Extraer datos de la fila seleccionada
            String cod_libro = (String) modeloLibros.getValueAt(fila, 0); // ID del libro
            String nom_libro = (String) modeloLibros.getValueAt(fila, 1);
            String stock = (String) modeloLibros.getValueAt(fila, 2);
            String autor = (String) modeloLibros.getValueAt(fila, 3);
            String cod_editorial = (String) modeloLibros.getValueAt(fila, 4);

            // Crear libro usando el patrón Builder
            LibroBuilder libroBuilder = new LibroBuilder();
            Director director = new Director(libroBuilder);
            director.Libropersonalizado(nom_libro, autor, stock, cod_editorial);

            Libros libroClonado = libroBuilder.getResult(); // Obtenemos el libro clonado

            // Generar un nuevo código para el libro clonado
            libroClonado.setCod_libro("L" + (int) (Math.random() * 1000));

            // Agregar libro clonado al modelo de la tabla
            Object[] data = {
                libroClonado.getCod_libro(),
                libroClonado.getNom_libro(),
                libroClonado.getStock(),
                libroClonado.getAutor(),
                libroClonado.getCod_editorial()
            };

            modeloLibros.addRow(data);
            JOptionPane.showMessageDialog(null, "Libro creado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Por favor seleccione un libro para crear.");
        }
    }//GEN-LAST:event_btnConstruir_libroActionPerformed

    private void btnAgregarExisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarExisActionPerformed
        LibroExistente le = new LibroExistente();
        le.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAgregarExisActionPerformed

    private void btnClonar_prestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClonar_prestamoActionPerformed
        int fila = jTable4.getSelectedRow(); // Obtener la fila seleccionada en la tabla

        if (fila != -1) {
            // Extraer datos de la fila seleccionada
            String cod_libro = (String) modeloPrestamos.getValueAt(fila, 0); // ID del libro
            String dni = (String) modeloPrestamos.getValueAt(fila, 1);
            String cod_prestamo_original = (String) modeloPrestamos.getValueAt(fila, 2); // Código del préstamo
            String fec_pres_original = (String) modeloPrestamos.getValueAt(fila, 3); // Fecha de préstamo original
            String fec_devo_original = (String) modeloPrestamos.getValueAt(fila, 4); // Fecha de devolución original

            Prestamos prestamoClonado = new Prestamos();
            prestamoClonado.setCod_libro(cod_libro);
            prestamoClonado.setDni(dni); // Obtenemos el libro clonado
            //nuevo codigo
            String nuevoCodPrestamo = prestamosServiceInst.generarID();
            prestamoClonado.setCod_prestamo(nuevoCodPrestamo);

            SimpleDateFormat fechaFormato = new SimpleDateFormat("dd/MM/yyyy");
            Calendar calendar = Calendar.getInstance();

            try {
                // fecha actual
                Date nuevaFechaPrestamo = new Date();
                prestamoClonado.setFec_pres(fechaFormato.format(nuevaFechaPrestamo));

                // 7dias depsues
                calendar.setTime(nuevaFechaPrestamo);
                calendar.add(Calendar.DAY_OF_MONTH, 7);
                Date nuevaFechaDevolucion = calendar.getTime();
                prestamoClonado.setFec_devo(fechaFormato.format(nuevaFechaDevolucion));
            } catch (Exception e) {
                JOptionPane.showInternalMessageDialog(null, "Error al ajustar las fechas del préstamo.", "Error de Fecha", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Insertar el préstamo clonado en el servicio de préstamos
            prestamosServiceInst.insertar(prestamoClonado);

            Object[] datosClonados = {
                prestamoClonado.getCod_libro(),
                prestamoClonado.getDni(),
                prestamoClonado.getCod_prestamo(),
                prestamoClonado.getFec_pres(),
                prestamoClonado.getFec_devo()
            };

            modeloPrestamos.addRow(datosClonados);
            JOptionPane.showInternalMessageDialog(null, "Préstamo clonado correctamente.", "Clonación Exitosa", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor seleccione un prestamo para clonar.");
        }
    }//GEN-LAST:event_btnClonar_prestamoActionPerformed


    private void cbxCategoriasFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCategoriasFActionPerformed
        String categoriaSeleccionada = cbxCategoriasF.getSelectedItem().toString(); // Obtener la categoría seleccionada

        // Filtrar la lista de libros según la categoría seleccionada
        List<LibrosM> librosFiltrados = new ArrayList<>();

        for (LibroComponent componente : componentes) { // 'componentes' es la lista de elementos del patrón Composite
            librosFiltrados.addAll(componente.filtrarPorCategoria(categoriaSeleccionada));
        }

        // Limpiar el modelo de la tabla antes de actualizar con los libros filtrados
        modeloLibros.setRowCount(0);

        // Agregar los libros filtrados al modelo de la tabla
        for (LibrosM libro : librosFiltrados) {
            Object[] data = {libro.getCod_libro(), libro.getNom_libro(), libro.getStock(), libro.getAutor(), libro.getCod_editorial(), libro.getCategoria()};
            modeloLibros.addRow(data);
        }
    }//GEN-LAST:event_cbxCategoriasFActionPerformed

    private void btnListarLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarLibrosActionPerformed
        // Limpiar el modelo de la tabla antes de agregar nuevos datos
    DefaultTableModel modelo = (DefaultTableModel) jTable18.getModel();
    modelo.setRowCount(0); // Limpia la tabla eliminando todas las filas

    // Recorrer el patrón Composite para listar todos los libros
    for (LibroComponent componente : componentes) {
        if (componente instanceof CategoriaLibro) {
            CategoriaLibro categoria = (CategoriaLibro) componente;
            for (LibroComponent libro : categoria.getComponentes()) {
                if (libro instanceof LibroHoja) {
                    LibroHoja libroHoja = (LibroHoja) libro;
                    LibrosM detallesLibro = libroHoja.getLibro();

                    // Agregar los detalles del libro al modelo de la tabla
                    Object[] data = {
                        detallesLibro.getCod_libro(),
                        detallesLibro.getNom_libro(),
                        detallesLibro.getStock(),
                        detallesLibro.getAutor(),
                        detallesLibro.getCod_editorial(),
                        detallesLibro.getCategoria()
                    };
                    modelo.addRow(data);
                }
            }
        }
    }
    }//GEN-LAST:event_btnListarLibrosActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Seccionxd;
    private javax.swing.JButton btnAgregarEditorial;
    private javax.swing.JButton btnAgregarEstu;
    private javax.swing.JButton btnAgregarExis;
    private javax.swing.JButton btnAgregar_libro;
    private javax.swing.JButton btnAgregar_prestamo;
    private javax.swing.JButton btnBuscarE;
    private javax.swing.JButton btnBuscarEdi;
    private javax.swing.JButton btnBuscarPre;
    private javax.swing.JButton btnBuscarl;
    private javax.swing.JButton btnClonar_prestamo;
    private javax.swing.JButton btnConstruir_libro;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminarEditorial;
    private javax.swing.JButton btnEliminar_libro;
    private javax.swing.JButton btnEliminar_prestamo;
    private javax.swing.JButton btnListarLibros;
    javax.swing.JComboBox<String> cbxCategoria;
    private javax.swing.JComboBox<String> cbxCategoriaL;
    private javax.swing.JComboBox<String> cbxCategoriasF;
    private javax.swing.JComboBox<String> cbxEditorial;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JDesktopPane jDesktopPane5;
    private javax.swing.JDesktopPane jDesktopPane7;
    private javax.swing.JDesktopPane jDesktopPane8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable17;
    private javax.swing.JTable jTable18;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable4;
    private com.toedter.calendar.JDateChooser jclFec_devo;
    private com.toedter.calendar.JDateChooser jclFec_pres;
    private javax.swing.JPanel pnlEditorial;
    private javax.swing.JPanel pnlEstudiantes;
    private javax.swing.JPanel pnlLibro13;
    private javax.swing.JPanel pnlPrestamos;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtClpres;
    private javax.swing.JTextField txtCod_editorial;
    private javax.swing.JTextField txtCod_libro;
    private javax.swing.JTextField txtCod_prestamos;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtDnipres;
    private javax.swing.JTextField txtGrado;
    private javax.swing.JTextField txtNom_Editorial;
    private javax.swing.JTextField txtNom_libro;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtSeccion;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables


}
