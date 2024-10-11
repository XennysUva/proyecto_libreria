package Vista;

import MInterfaces.Libro;
import MInterfaces.Servicio;
import Modelo.Estudiantes;
import Modelo.Editorial;
import Modelo.LibroDigital;
import Modelo.Libros;
import Modelo.Prestamos;
import Servicios.EditorialS;
import Servicios.EstudianteS;
import Servicios.LibroFactory;
import Servicios.LibrosS;
import Servicios.PrestamosS;
import Servicios.PrestamosSFactory;
import Servicios.ServiciosFactory;
import java.awt.event.KeyEvent;  
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Principal extends javax.swing.JFrame {
    
// Servicios
private final EstudianteS estudiantesService = EstudianteS.getInstancia();
private final EditorialS editorialService = EditorialS.getInstancia();
private final LibrosS librosService = LibrosS.getInstancia();
private final PrestamosS prestamosService = PrestamosS.getInstancia();


    // Modelos de Tabla
    private final DefaultTableModel modeloEstudiantes;
    private final DefaultTableModel modeloEditoriales;
    private final DefaultTableModel modeloLibros;
    private final DefaultTableModel modeloPrestamos;
    
    // Inicializa servicios y modelos SINGLETON
        EstudianteS estudiantesServiceInst =EstudianteS.getInstancia();
        EditorialS editorialServiceInst = EditorialS.getInstancia();
        LibrosS librosServiceInst = LibrosS.getInstancia();
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
        mostrarTodosLibros();

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
        jTable17.setModel(modeloLibros);
    }

    private void limpiarCajasLib() {
        txtCod_libro.setText(null);
        txtNom_libro.setText(null);
        txtStock.setText(null);
        txtAutor.setText(null);
    }

    private void mostrarTodosLibros() {
        ArrayList<Libros> libros = librosService.listarTodo();
        for (Libros libro : libros) {
            Object[] data = {libro.getCod_libro(), libro.getNom_libro(), libro.getStock(), libro.getAutor(), libro.getCod_editorial()};
            modeloLibros.addRow(data);
        }
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
        jButton3 = new javax.swing.JButton();
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
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnUbicacionesGrafo = new javax.swing.JButton();
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
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btnBuscarl = new javax.swing.JButton();
        jScrollPane17 = new javax.swing.JScrollPane();
        jTable17 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        btnClonar_libro = new javax.swing.JButton();
        bnt_digital = new javax.swing.JButton();
        btn_fisico = new javax.swing.JButton();
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
        jButton1 = new javax.swing.JButton();
        jclFec_pres = new com.toedter.calendar.JDateChooser();
        jclFec_devo = new com.toedter.calendar.JDateChooser();
        jButton6 = new javax.swing.JButton();

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
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("DNI ");

        Seccionxd.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        Seccionxd.setForeground(new java.awt.Color(0, 0, 0));
        Seccionxd.setText("Sección");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Grado");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Nombres");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jButton3.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/producto.png"))); // NOI18N
        jButton3.setText("Insertar con ListaE Pila");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

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
        jDesktopPane2.setLayer(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                                .addComponent(Seccionxd, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 27, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDesktopPane2Layout.createSequentialGroup()
                                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtGrado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDesktopPane2Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32))
                    .addGroup(jDesktopPane2Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAgregarEstu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBuscarE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Seccionxd, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAgregarEstu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscarE, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout pnlEstudiantesLayout = new javax.swing.GroupLayout(pnlEstudiantes);
        pnlEstudiantes.setLayout(pnlEstudiantesLayout);
        pnlEstudiantesLayout.setHorizontalGroup(
            pnlEstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEstudiantesLayout.createSequentialGroup()
                .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlEstudiantesLayout.setVerticalGroup(
            pnlEstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEstudiantesLayout.createSequentialGroup()
                .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Cod editorial");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Telefono");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
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

        jButton2.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/producto.png"))); // NOI18N
        jButton2.setText("Insertar Lista Enlazada");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/tabla.png"))); // NOI18N
        jButton4.setText("Insertar con T.Hash");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btnUbicacionesGrafo.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnUbicacionesGrafo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ubicacion-logo.png"))); // NOI18N
        btnUbicacionesGrafo.setText("Ubicaciones");
        btnUbicacionesGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbicacionesGrafoActionPerformed(evt);
            }
        });

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
        jDesktopPane8.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane8.setLayer(jButton4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane8.setLayer(btnUbicacionesGrafo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane8Layout = new javax.swing.GroupLayout(jDesktopPane8);
        jDesktopPane8.setLayout(jDesktopPane8Layout);
        jDesktopPane8Layout.setHorizontalGroup(
            jDesktopPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane8Layout.createSequentialGroup()
                .addGroup(jDesktopPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane8Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jDesktopPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane8Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCod_editorial, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDesktopPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jDesktopPane8Layout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jDesktopPane8Layout.createSequentialGroup()
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtNom_Editorial, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jDesktopPane8Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jDesktopPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                            .addComponent(btnAgregarEditorial, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                            .addComponent(btnBuscarEdi, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                            .addComponent(btnEliminarEditorial, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                            .addComponent(btnUbicacionesGrafo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jDesktopPane8Layout.setVerticalGroup(
            jDesktopPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane8Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jDesktopPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCod_editorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNom_Editorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDesktopPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(btnAgregarEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addComponent(btnUbicacionesGrafo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscarEdi, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminarEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
            .addGroup(jDesktopPane8Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlEditorialLayout = new javax.swing.GroupLayout(pnlEditorial);
        pnlEditorial.setLayout(pnlEditorialLayout);
        pnlEditorialLayout.setHorizontalGroup(
            pnlEditorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane8)
        );
        pnlEditorialLayout.setVerticalGroup(
            pnlEditorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEditorialLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jDesktopPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        jLabel9.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Codigo libro");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Nombre libro");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Autor");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Stock");

        jLabel19.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
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

        jButton5.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/arbol_logo.png"))); // NOI18N
        jButton5.setText("ABB");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        btnClonar_libro.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        btnClonar_libro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/libros2 (1).png"))); // NOI18N
        btnClonar_libro.setText("Clonar Libro");
        btnClonar_libro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClonar_libroActionPerformed(evt);
            }
        });

        bnt_digital.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        bnt_digital.setText("Libro Digital");
        bnt_digital.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_digitalActionPerformed(evt);
            }
        });

        btn_fisico.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        btn_fisico.setText("Libro Fisico");
        btn_fisico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fisicoActionPerformed(evt);
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
        jDesktopPane5.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane5.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane5.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane5.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane5.setLayer(jLabel19, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane5.setLayer(btnBuscarl, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane5.setLayer(jScrollPane17, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane5.setLayer(jButton5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane5.setLayer(btnClonar_libro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane5.setLayer(bnt_digital, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane5.setLayer(btn_fisico, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane5Layout = new javax.swing.GroupLayout(jDesktopPane5);
        jDesktopPane5.setLayout(jDesktopPane5Layout);
        jDesktopPane5Layout.setHorizontalGroup(
            jDesktopPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane5Layout.createSequentialGroup()
                .addGroup(jDesktopPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane5Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jDesktopPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jDesktopPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCod_libro, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNom_libro, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jDesktopPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cbxEditorial, javax.swing.GroupLayout.Alignment.LEADING, 0, 212, Short.MAX_VALUE)
                                .addComponent(txtAutor, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(jDesktopPane5Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jDesktopPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscarl)
                            .addGroup(jDesktopPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnAgregar_libro, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnAgregarExis, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnClonar_libro, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar_libro, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jDesktopPane5Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(bnt_digital, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btn_fisico, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 99, Short.MAX_VALUE))
        );
        jDesktopPane5Layout.setVerticalGroup(
            jDesktopPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane5Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jDesktopPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCod_libro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDesktopPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(txtNom_libro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDesktopPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAutor))
                .addGap(9, 9, 9)
                .addGroup(jDesktopPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(btnAgregar_libro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregarExis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClonar_libro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar_libro)
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_fisico)
                    .addComponent(bnt_digital))
                .addGap(19, 19, 19))
            .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
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
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Codigo libro");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Codigo prestamo");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("DNI");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Fecha prestamo");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
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

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/producto.png"))); // NOI18N
        jButton1.setText("Insertar con Cola");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jclFec_pres.setDateFormatString("yyyy/MM/dd");

        jclFec_devo.setDateFormatString("yyyy/MM/dd");

        jButton6.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/torre-Hanoi.png"))); // NOI18N
        jButton6.setText("Torre Hanoi");

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
        jDesktopPane7.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane7.setLayer(jclFec_pres, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane7.setLayer(jclFec_devo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane7.setLayer(jButton6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane7Layout = new javax.swing.GroupLayout(jDesktopPane7);
        jDesktopPane7.setLayout(jDesktopPane7Layout);
        jDesktopPane7Layout.setHorizontalGroup(
            jDesktopPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane7Layout.createSequentialGroup()
                .addGroup(jDesktopPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane7Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jDesktopPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane7Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jclFec_devo, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel14)
                            .addGroup(jDesktopPane7Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtClpres, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDesktopPane7Layout.createSequentialGroup()
                                .addGroup(jDesktopPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jDesktopPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jDesktopPane7Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jDesktopPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtCod_prestamos, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                            .addComponent(txtDnipres)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane7Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                        .addComponent(jclFec_pres, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jDesktopPane7Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(jDesktopPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                            .addComponent(btnBuscarPre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAgregar_prestamo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminar_prestamo, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jDesktopPane7Layout.setVerticalGroup(
            jDesktopPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane7Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jDesktopPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtClpres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDnipres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jDesktopPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCod_prestamos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jDesktopPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane7Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jDesktopPane7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jclFec_pres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(jDesktopPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane7Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(22, 22, 22))
                    .addComponent(jclFec_devo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(btnAgregar_prestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscarPre, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar_prestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(jDesktopPane7Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnAgregarExisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarExisActionPerformed
        LibroExistente le = new LibroExistente();
        le.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnAgregarExisActionPerformed

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

    private void btnAgregar_libroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar_libroActionPerformed
        String cod_libro = txtCod_libro.getText().trim();
        String nom_libro = txtNom_libro.getText().trim();
        String stock = txtStock.getText().trim();
        String autor = txtAutor.getText().trim();

        // Validación básica de campos vacíos
        if (cod_libro.isEmpty() || nom_libro.isEmpty() || stock.isEmpty() || autor.isEmpty()) {
            JOptionPane.showInternalMessageDialog(null, "Los campos no pueden estar vacíos.", "Campos Vacíos!!", JOptionPane.WARNING_MESSAGE);
        } else if (!validarSt(stock)) {
            JOptionPane.showInternalMessageDialog(null, "El stock debe ser un número.", "Error en el Stock!!", JOptionPane.ERROR_MESSAGE);
        } else if (cod_libro.length() != 4) {
            JOptionPane.showInternalMessageDialog(null, "El código del libro debe tener 4 caracteres.", "Error en el Código!!", JOptionPane.ERROR_MESSAGE);
        } else {
            // Verificar si el código de libro ya existe
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

                // Agregar el nuevo libro
                Object[] data = {cod_libro, nom_libro, stock, autor, cbxEditorialv};
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

  // Verificar si el código de libro existe en el sistema de libros
    boolean libroExiste = librosServiceInst.listarTodo().stream()
            .anyMatch(libro -> libro.getCod_libro().equals(cod_libro));

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
    boolean codPrestamoExiste = prestamosServiceInst.listarTodo().stream()
            .anyMatch(prestamo -> prestamo.getCod_prestamo().equals(cod_prestamo));

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        InsPres_ListE_Cola iplc = new InsPres_ListE_Cola();
        iplc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        InsEditorial_ListaE iele = new InsEditorial_ListaE();
        iele .setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        InsAlum_LisEPILa be = new InsAlum_LisEPILa();
        be.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Elegir_THash be = new Elegir_THash();
        be.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        InsLibro_ABB be = new InsLibro_ABB();
        be.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnUbicacionesGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbicacionesGrafoActionPerformed
        UbicacionGrafos ug = new UbicacionGrafos();
        ug.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnUbicacionesGrafoActionPerformed

    private void btnClonar_libroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClonar_libroActionPerformed
        int fila = jTable17.getSelectedRow(); // Obtener la fila seleccionada en la tabla

        if (fila == -1) {
            JOptionPane.showInternalMessageDialog(null, "Por favor, selecciona un libro para clonar.", "No se seleccionó libro", JOptionPane.WARNING_MESSAGE);
            return; // Salir si no hay fila seleccionada
        }

        // Obtener los datos del libro seleccionado
        String cod_libro = (String) modeloLibros.getValueAt(fila, 0); // ID del libro
        String nom_libro = (String) modeloLibros.getValueAt(fila, 1);
        String stock = (String) modeloLibros.getValueAt(fila, 2);
        String autor = (String) modeloLibros.getValueAt(fila, 3);
        String cod_editorial = (String) modeloLibros.getValueAt(fila, 4);

        Libros libroOriginal = new Libros();
        libroOriginal.setCod_libro(cod_libro);
        libroOriginal.setNom_libro(nom_libro);
        libroOriginal.setStock(stock);
        libroOriginal.setAutor(autor);
        libroOriginal.setCod_editorial(cod_editorial);

        Libros libroClonado = libroOriginal.clone();
        String nuevoCodLibro = "L" + librosServiceInst.generarID(); // Método para generar un código nuevo
        libroClonado.setCod_libro(nuevoCodLibro);

        // Crear una nueva fila con los datos clonados
        Object[] datosClonados = {
            libroClonado.getCod_libro(),
            libroClonado.getNom_libro(),
            libroClonado.getStock(),
            libroClonado.getAutor(),
            libroClonado.getCod_editorial()
        };
        modeloLibros.addRow(datosClonados); // Agregar la nueva fila al modelo de la tabla
        JOptionPane.showInternalMessageDialog(null, "Libro clonado correctamente.", "Clonación Exitosa", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_btnClonar_libroActionPerformed

    private void bnt_digitalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_digitalActionPerformed
  String nombre = JOptionPane.showInputDialog("Ingrese el nombre del libro digital:");
    String autor = JOptionPane.showInputDialog("Ingrese el autor del libro digital:");

    if (nombre != null && autor != null) {
        // Creandooo libro usando factory
        Libro nuevoLibro = LibroFactory.crearLibro("digital", nombre, autor);

        if (LibrosS.getInstancia().insertar((Libros) nuevoLibro)) {
            JOptionPane.showMessageDialog(this, "Libro digital agregado.");
        } else {
            JOptionPane.showMessageDialog(this, "Error al agregar el libro digital.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Datos de libro inválidos.");
    }
    }//GEN-LAST:event_bnt_digitalActionPerformed

    private void btn_fisicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fisicoActionPerformed
       String nombre = JOptionPane.showInputDialog("Ingrese el nombre del libro físico:");
    String autor = JOptionPane.showInputDialog("Ingrese el autor del libro físico:");

    if (nombre != null && autor != null) {
        // Creaando libro con factory
        Libro nuevoLibro = LibroFactory.crearLibro("fisico", nombre, autor);

        if (LibrosS.getInstancia().insertar((Libros) nuevoLibro)) {
            JOptionPane.showMessageDialog(this, "Libro físico agregado.");
        } else {
            JOptionPane.showMessageDialog(this, "Error al agregar el libro físico.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Datos de libro inválidos.");
    }
    }//GEN-LAST:event_btn_fisicoActionPerformed

    public static void main(String args[]) {
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Seccionxd;
    private javax.swing.JButton bnt_digital;
    private javax.swing.JButton btnAgregarEditorial;
    private javax.swing.JButton btnAgregarEstu;
    private javax.swing.JButton btnAgregarExis;
    private javax.swing.JButton btnAgregar_libro;
    private javax.swing.JButton btnAgregar_prestamo;
    private javax.swing.JButton btnBuscarE;
    private javax.swing.JButton btnBuscarEdi;
    private javax.swing.JButton btnBuscarPre;
    private javax.swing.JButton btnBuscarl;
    private javax.swing.JButton btnClonar_libro;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminarEditorial;
    private javax.swing.JButton btnEliminar_libro;
    private javax.swing.JButton btnEliminar_prestamo;
    private javax.swing.JButton btnUbicacionesGrafo;
    private javax.swing.JButton btn_fisico;
    private javax.swing.JComboBox<String> cbxEditorial;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
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
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable17;
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
