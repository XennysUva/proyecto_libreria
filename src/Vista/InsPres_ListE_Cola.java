package Vista;

import Modelo.Prestamos;
import ModeloDAO.EstudiantesDAO;
import ModeloDAO.LibrosDAO;
import ModeloDAO.PrestamosDAO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import NodoCola.Prestamos_LisE_Cola;
import NodoCola.Lista_Cola;
import NodoCola.Nodo_Cola;
import javax.swing.JOptionPane;

public class InsPres_ListE_Cola extends javax.swing.JFrame {

    Lista_Cola lista = new Lista_Cola();

    public InsPres_ListE_Cola() {
        initComponents();
        //Centrar el JFrame
        this.setLocationRelativeTo(null);
        mostrarCabecerasPres();
        txtCodPrestamo_Cola.setText(pd.generarID());
    }

    Prestamos p = new Prestamos();
    PrestamosDAO pd = new PrestamosDAO();
    DefaultTableModel modeloCola = new DefaultTableModel();
    LibrosDAO ld = new LibrosDAO();
    EstudiantesDAO ed = new EstudiantesDAO();

    public void mostrarCabecerasPres() {
        modeloCola.addColumn("Cod_libro");
        modeloCola.addColumn("DNI");
        modeloCola.addColumn("Cod_prestamos");
        modeloCola.addColumn("Fec_pres");
        modeloCola.addColumn("Fec_devo");
        jTable1.setModel(modeloCola);
    }

    void limpiarCajas() {
        txtCod_Libro_Cola.setText(null);
        txtDni_Cola.setText(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCod_Libro_Cola = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDni_Cola = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCodPrestamo_Cola = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jcFec_Pres_Cola = new com.toedter.calendar.JDateChooser();
        jcFec_Devo_Cola = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCont = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnInsertar_Cola = new javax.swing.JButton();
        btnQuitar_Cola = new javax.swing.JButton();
        btnSalir_Cola = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Insertar Prestamos -  Lista Enlazada con Colas");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Insertar Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14), new java.awt.Color(255, 0, 51))); // NOI18N

        jLabel1.setText("Cod_Libro");

        txtCod_Libro_Cola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCod_Libro_ColaActionPerformed(evt);
            }
        });

        jLabel2.setText("DNI");

        txtDni_Cola.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDni_ColaKeyPressed(evt);
            }
        });

        jLabel3.setText("Cod_Prestamo");

        jLabel4.setText("Fec_Pres");

        jLabel5.setText("Fec_Devo");

        jcFec_Pres_Cola.setDateFormatString("yy/MM/dd ");

        jcFec_Devo_Cola.setDateFormatString("yy/MM/dd ");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imgCole__3_-removebg-preview_sinFondo.png"))); // NOI18N

        jLabel7.setText("Cantidad de ");

        txtCont.setEditable(false);
        txtCont.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel8.setText("Libros Prestados");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCod_Libro_Cola, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(txtDni_Cola)
                    .addComponent(txtCodPrestamo_Cola))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcFec_Devo_Cola, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                            .addComponent(jcFec_Pres_Cola, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCont))))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(txtCod_Libro_Cola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))
                            .addComponent(jcFec_Pres_Cola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(txtDni_Cola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                            .addComponent(jcFec_Devo_Cola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(txtCodPrestamo_Cola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(txtCont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        btnInsertar_Cola.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnInsertar_Cola.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nuevo.png"))); // NOI18N
        btnInsertar_Cola.setText("Insertar");
        btnInsertar_Cola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertar_ColaActionPerformed(evt);
            }
        });

        btnQuitar_Cola.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnQuitar_Cola.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        btnQuitar_Cola.setText("Quitar");
        btnQuitar_Cola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitar_ColaActionPerformed(evt);
            }
        });

        btnSalir_Cola.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnSalir_Cola.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/volver.png"))); // NOI18N
        btnSalir_Cola.setText("Salir");
        btnSalir_Cola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir_ColaActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/oden_icon.png"))); // NOI18N
        jButton1.setText("Mostrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnInsertar_Cola, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                        .addGap(98, 98, 98)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnQuitar_Cola, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalir_Cola, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertar_Cola, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuitar_Cola, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSalir_Cola, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(41, 41, 41))
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

    private void btnInsertar_ColaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertar_ColaActionPerformed

        //Igualar a variables
        String cod_libro = txtCod_Libro_Cola.getText();
        String dni = txtDni_Cola.getText();
        String cod_prestamos = txtCodPrestamo_Cola.getText();
        //Formato de la fecha(Jcalendar)
        SimpleDateFormat fecha = new SimpleDateFormat("yyyy/MM/dd");
        String fec_pres = fecha.format(jcFec_Pres_Cola.getDate());
        String fec_devo = fecha.format(jcFec_Devo_Cola.getDate());

        if (cod_libro.equals("") || dni.equals("") || cod_prestamos.equals("")) {
            JOptionPane.showInternalMessageDialog(null, "Los campos no pueden estar vacios.",
                    "Campos Vacios!!", JOptionPane.WARNING_MESSAGE);
        } else if (cod_libro.length() != 4 || dni.length() != 8) {
            JOptionPane.showInternalMessageDialog(null, "Verificar si el COD_LIBRO tiene 4 caracteres el DNI tiene 8 caracteres",
                    "Verificar COD_LIBRO y DNI!!", JOptionPane.ERROR_MESSAGE);
        } else if (ld.validarCol(cod_libro) == 0) {
            JOptionPane.showInternalMessageDialog(null, "El COD_LIBRO no existe",
                    "Verificar COD_LIBRO!!", JOptionPane.ERROR_MESSAGE);
        } else if (ed.validarDni(dni) == 0) {
            JOptionPane.showInternalMessageDialog(null, "El DNI no existe",
                    "Verificar el DNI!!", JOptionPane.ERROR_MESSAGE);
        } else if (pd.validarCP(cod_prestamos) > 0) {
            JOptionPane.showInternalMessageDialog(null, "El COD_PRESTAMO no puede coincidir con otro COD_PRESTAMO",
                    "Verificar el COD_PRESTAMO!!", JOptionPane.ERROR_MESSAGE);
        } else {

            //Insertar con algoritmo
            Prestamos_LisE_Cola prestamo = new Prestamos_LisE_Cola(cod_libro, dni, cod_prestamos, fec_pres, fec_devo);
            lista.insertarCola(prestamo);
            //Insertar en la base de datos
            p.setCod_libro(cod_libro);
            p.setDni(dni);
            p.setCod_prestamo(cod_prestamos);
            p.setFec_pres(fec_pres);
            p.setFec_devo(fec_devo);
            pd.insertar(p);
            //Insertar en tabla
            Object data[] = {p.getCod_libro(), p.getDni(), p.getCod_prestamo(), p.getFec_pres(), p.getFec_devo()};
            modeloCola.addRow(data);

            JOptionPane.showInternalMessageDialog(null, "Se registro correctamente el prestamo.",
                    "Registro exitoso!!", JOptionPane.INFORMATION_MESSAGE);

            //Metodo de Limpiar Cajas
            limpiarCajas();

        }

        txtCodPrestamo_Cola.setText(pd.generarID());
        //Para ejecutar el metodo una sola vez

        //aumenta el contador de alumnos en la cola
        int cont = lista.getNElementos();
        txtCont.setText("" + cont);


    }//GEN-LAST:event_btnInsertar_ColaActionPerformed

    private void btnSalir_ColaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir_ColaActionPerformed
        Principal pr = new Principal();
        pr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalir_ColaActionPerformed

    private void btnQuitar_ColaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitar_ColaActionPerformed
        Nodo_Cola elemento = lista.getInicio();
        if (lista.getInicio() == null) {
            JOptionPane.showInternalMessageDialog(null, "Lista Vacia......!!!",
                    "Lista vacía", JOptionPane.ERROR_MESSAGE);
        } else {
            lista.QuitardelaCola();
            JOptionPane.showInternalMessageDialog(null, "Se elimino correctamente el prestamo.",
                    "Prestamo Eliminado", JOptionPane.INFORMATION_MESSAGE);
            pd.eliminar(jTable1.getValueAt(0, 2).toString());
            modeloCola.removeRow(0);
        }

        //disminuye el contador de alumnos en la cola
        int cont = lista.getNElementos();
        if (cont >= 0) {
            txtCont.setText("" + cont);
        } else {
            cont = 0;
            txtCont.setText("" + cont);
        }
    }//GEN-LAST:event_btnQuitar_ColaActionPerformed

    private void txtCod_Libro_ColaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCod_Libro_ColaActionPerformed
        txtDni_Cola.requestFocus();
    }//GEN-LAST:event_txtCod_Libro_ColaActionPerformed

    private void txtDni_ColaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDni_ColaKeyPressed

    }//GEN-LAST:event_txtDni_ColaKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MostrarOrden_NodoCola mo_nc = new MostrarOrden_NodoCola();
        mo_nc.setLista(lista); // Establecer la lista después de crear el objeto
        mo_nc.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(InsPres_ListE_Cola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InsPres_ListE_Cola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InsPres_ListE_Cola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InsPres_ListE_Cola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InsPres_ListE_Cola().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInsertar_Cola;
    private javax.swing.JButton btnQuitar_Cola;
    private javax.swing.JButton btnSalir_Cola;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private com.toedter.calendar.JDateChooser jcFec_Devo_Cola;
    private com.toedter.calendar.JDateChooser jcFec_Pres_Cola;
    private javax.swing.JTextField txtCodPrestamo_Cola;
    private javax.swing.JTextField txtCod_Libro_Cola;
    private javax.swing.JTextField txtCont;
    private javax.swing.JTextField txtDni_Cola;
    // End of variables declaration//GEN-END:variables
}
