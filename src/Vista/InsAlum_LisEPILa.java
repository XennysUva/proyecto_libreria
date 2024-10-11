package Vista;

import ListaE_Pilas.Alumno;
import ListaE_Pilas.ListaPila;
import ListaE_Pilas.NodoPL;
import ModeloDAO.EstudiantesDAO;
import Modelo.Estudiantes;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class InsAlum_LisEPILa extends javax.swing.JFrame {

    public InsAlum_LisEPILa() {
        initComponents();
        //Centrar Principal
        this.setLocationRelativeTo(null);
        //le damos los titulos al model "tmodelo"
        mostrarCabecerasEstu();
    }

    Estudiantes AlumnE = new Estudiantes();
    EstudiantesDAO DaoAlumno = new EstudiantesDAO();
    DefaultTableModel tmodelo = new DefaultTableModel();
    //crear un objeto para una lista que herede los atributos y metodos de la lista pila
    ListaPila ListaAlumno = new ListaPila();

    //VALIDAR EL DNI 
    public boolean validarDNI(String datos) {
        return datos.matches("[0-9]+");
    }

    public void LimpiarCasillas() {
        txtDni.setText("");
        txtNombre.setText("");
        txtApellidos.setText("");
        txtGrado.setText("");
        txtSeccion.setText("");
    }
    
    public void mostrarCabecerasEstu() {
        tmodelo.addColumn("DNI");
        tmodelo.addColumn("Nombres");
        tmodelo.addColumn("Apellidos");
        tmodelo.addColumn("Grado");
        tmodelo.addColumn("Seccion");
        tblAlumnos.setModel(tmodelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtGrado = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAlumnos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtSeccion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbxGrado = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Insertar Alumnos - Listas Enlazadas con Pila");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        tblAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane1.setViewportView(tblAlumnos);

        jButton1.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/GuardarTodo.png"))); // NOI18N
        jButton1.setText("Insertar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/oden_icon.png"))); // NOI18N
        jButton2.setText("Mostrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        jButton3.setText("Quitar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/volver.png"))); // NOI18N
        jButton5.setText("Salir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Insertar Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 14), new java.awt.Color(255, 0, 51))); // NOI18N

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("DNI");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setText("Apellidos");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setText("Grado");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setText("Sección");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imgCole__3_-removebg-preview_sinFondo.png"))); // NOI18N

        cbxGrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1° Secundaria", "2° Secundaria", "3° Secundaria", "4° Secundaria", "5° Secundaria" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtApellidos))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(46, 46, 46)
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxGrado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSeccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(jLabel6)
                .addGap(16, 16, 16))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cbxGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 27, Short.MAX_VALUE))
        );

        txtArea.setColumns(20);
        txtArea.setRows(5);
        jScrollPane2.setViewportView(txtArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(179, 179, 179)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(89, 89, 89)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Principal pr = new Principal();
        pr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String dni = txtDni.getText();
        String nombre = txtNombre.getText();
        String apellido = txtApellidos.getText();
        String grado = (String) cbxGrado.getSelectedItem();
        String seccion = txtSeccion.getText();
        
        //Exepciones
        if (dni.equals("") || nombre.equals("") || apellido.equals("") || grado.equals("") || seccion.equals("")) {
            JOptionPane.showInternalMessageDialog(null, "Debe rellenar todos los campos", "CAMPOS VACIOS", JOptionPane.WARNING_MESSAGE);
        } else if (!validarDNI(dni.trim())) {
            JOptionPane.showInternalMessageDialog(null, "Verificar si son 8  números", "Revisar dni!!", JOptionPane.ERROR_MESSAGE);
        } else if (dni.length() != 8 || seccion.length() != 1) {
            JOptionPane.showInternalMessageDialog(null, "Verificar si el DNI tiene 8 caracteres y revisar tambien la sección que tenga 1 caracter.",
                    "Verificar DNI y Sección!!", JOptionPane.ERROR_MESSAGE);
        } else if (DaoAlumno.validarDni(dni) > 0) {
            JOptionPane.showInternalMessageDialog(null, "El DNI no puede coincidir con otro DNI",
                    "Verificar DNI!!", JOptionPane.ERROR_MESSAGE);
        } else {
            //Insertar en algoritmo
            Alumno alu = new Alumno(dni, nombre, apellido, grado, seccion);
            ListaAlumno.InsertarDato(alu);

            txtArea.append("\n DNI: " + alu.getDni() + " \n Nombre: " + alu.getNombre() + "\n Apellido: " + alu.getApellidos() + "\n Grado: " + alu.getGrado() + "\n Seccion: " + alu.getSeccion() + "\n");
            tmodelo.addRow(new Object[]{alu.getDni(), alu.getNombre(), alu.getApellidos(), alu.getGrado(), alu.getSeccion()});

            //insertar en sql
            AlumnE.setDni(dni);
            AlumnE.setNombres(nombre);
            AlumnE.setApellidos(apellido);
            AlumnE.setGrado(grado);
            AlumnE.setSeccion(seccion);
            Object data[] = {AlumnE.getDni(), AlumnE.getNombres(), AlumnE.getApellidos(),
                AlumnE.getGrado(), AlumnE.getSeccion()};
            DaoAlumno.insertar(AlumnE);
            
            //limpiar casillas
            LimpiarCasillas();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        NodoPL dato = ListaAlumno.getInicioAlum();
        int ultimaFila = tmodelo.getRowCount()-1;
        if (ListaAlumno.getInicioAlum() == null) {
            txtArea.append("La pila esta vacia");
        } else {
            txtArea.append("\n ALUMNO(A):  " + "\n" + dato.getDato().getDni() + "\n" + dato.getDato().getNombre() + "\n" + dato.getDato().getApellidos() + "\n" + dato.getDato().getGrado() + "\n" + dato.getDato().getSeccion() + "\n" + "ha sido eliminado \n");
            ListaAlumno.EliminarDato();
            //Eliminar en la base de datos
            DaoAlumno.eliminar(tmodelo.getValueAt(ultimaFila, 0).toString());
            //Para la tabla
            tmodelo.removeRow(ultimaFila);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(ListaAlumno.getInicioAlum() == null){
            txtArea.append("Lista vacía.....\n");
        }else{
            NodoPL elemento = ListaAlumno.getInicioAlum();
            while(elemento != null){
                txtArea.append( elemento.getDato().getDni()+
                                elemento.getDato().getNombre()
                                +" --> ");
                
                elemento = elemento.getSiguienteAlumno();
            }
            txtArea.append("\n");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(InsAlum_LisEPILa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InsAlum_LisEPILa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InsAlum_LisEPILa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InsAlum_LisEPILa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InsAlum_LisEPILa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxGrado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblAlumnos;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtGrado;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSeccion;
    // End of variables declaration//GEN-END:variables
}
