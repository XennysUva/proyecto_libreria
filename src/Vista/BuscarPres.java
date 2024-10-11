package Vista;

import Modelo.Prestamos;
import ModeloDAO.MDO_Prestamos;
import ModeloDAO.PrestamosDAO;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BuscarPres extends javax.swing.JFrame {

    MDO_Prestamos MDO_P;

    public BuscarPres() {
        initComponents();
        //Centrar BuscarPres
        this.setLocationRelativeTo(null);
        mostrarCabecerasLib();
        mostrarTodosPrestamos();
        MDO_P = new MDO_Prestamos();
    }

    DefaultTableModel modelo7 = new DefaultTableModel();

    public void mostrarCabecerasLib() {
        modelo7.addColumn("Cod_libro");
        modelo7.addColumn("Dni");
        modelo7.addColumn("Cod_prestamo");
        modelo7.addColumn("Fec_pres");
        modelo7.addColumn("Fec_devo");
        jTable5.setModel(modelo7);
    }

    PrestamosDAO pd = new PrestamosDAO();

    public void mostrarTodosPrestamos() {
        ArrayList<Prestamos> pl = new ArrayList<>();

        pl = pd.listarTodo();
        for (int i = 0; i < pl.size(); i++) {
            Object[] data = {pl.get(i).getCod_libro(), pl.get(i).getDni(),
                pl.get(i).getCod_prestamo(), pl.get(i).getFec_pres(), pl.get(i).getFec_devo()};
            modelo7.addRow(data);
        }
    }
    private void listarPrestamos(){
    
        for(int i=0; i<MDO_P.getListaC().size();i++){
            jTable5.setValueAt(MDO_P.getListaC().get(i).getCod_libro(), i, 0);
            jTable5.setValueAt(MDO_P.getListaC().get(i).getDni(), i, 1);
            jTable5.setValueAt(MDO_P.getListaC().get(i).getCod_prestamo(), i, 2);  
            jTable5.setValueAt(MDO_P.getListaC().get(i).getFec_pres(), i, 3); 
            jTable5.setValueAt(MDO_P.getListaC().get(i).getFec_devo(), i, 4); 
            
        }
    }

    //Buscar prestamo KetReleased
    /*PrestamosDAO ld = new PrestamosDAO();
        ArrayList<Prestamos> pc = new ArrayList<>();
        int filas = modelo7.getRowCount();
        for (int i = 0; i < filas; i++) {
            modelo7.removeRow(0);
        }
        pc = ld.buscarPre(txtBuscarpre.getText());
        for (int i = 0; i < pc.size(); i++) {
            Object[] data = {pc.get(i).getCod_libro(), pc.get(i).getDni(), pc.get(i).getCod_prestamo(),
                 pc.get(i).getFec_pres(), pc.get(i).getFec_devo()};
            modelo7.addRow(data);

        }*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        btnVolverp = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnBus_Pres_Sec_CodPres = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnBusq_Bi_Pres = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Biblioteca Virtual -- Buscar Prestamos");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cod_libro", "DNI", "Cod_prestamo", "Fec_pres", "Fec_devo"
            }
        ));
        jScrollPane1.setViewportView(jTable5);

        btnVolverp.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        btnVolverp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/volver.png"))); // NOI18N
        btnVolverp.setText("Volver");
        btnVolverp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverpActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Busqueda Secuencial", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI Semibold", 3, 14))); // NOI18N

        btnBus_Pres_Sec_CodPres.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnBus_Pres_Sec_CodPres.setText("Busq por Cod_Prestamo");
        btnBus_Pres_Sec_CodPres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBus_Pres_Sec_CodPresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnBus_Pres_Sec_CodPres, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(btnBus_Pres_Sec_CodPres, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Busqueda Binaria", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI Semibold", 3, 14))); // NOI18N

        btnBusq_Bi_Pres.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnBusq_Bi_Pres.setText("Busq Por DNI");
        btnBusq_Bi_Pres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusq_Bi_PresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(btnBusq_Bi_Pres, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(btnBusq_Bi_Pres, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 102, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ordenamiento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI Semibold", 3, 14))); // NOI18N

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton3.setText("Ordenar por Fec_pres");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton4.setText("Ordenar por Cod_prestamo");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton1.setText("Ordenar por Fec_devo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton2.setText("Ordenar por Cod_Libro");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Merge Sort");

        jLabel3.setText("Inserción");

        jLabel4.setText("Shell Sort");

        jLabel5.setText("Quick Sort");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addGap(37, 37, 37)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(3, 3, 3)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imgCole__3_-removebg-preview_sinFondo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(btnVolverp, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel1)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(12, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(btnVolverp, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverpActionPerformed
        Principal pr = new Principal();
        pr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverpActionPerformed

    private void btnBusq_Bi_PresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusq_Bi_PresActionPerformed
        int redni = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el DNI del estudiante:"));

        MDO_P.ordenarPrestamosDNI();

        if (MDO_P.busquedaBinDNIPres(redni) != null) {
            JOptionPane.showMessageDialog(rootPane, "Cod_Libro:            "
                    + MDO_P.busquedaBinDNIPres(redni).getCod_libro() + "\n" + "DNI Estudiante:    "
                    + MDO_P.busquedaBinDNIPres(redni).getDni() + "\n" + "Cod_Prestamo:    "
                    + MDO_P.busquedaBinDNIPres(redni).getCod_prestamo() + "\n" + "Fec_pres:             "
                    + MDO_P.busquedaBinDNIPres(redni).getFec_pres() + "\n" + "Fex_devo:             "
                    + MDO_P.busquedaBinDNIPres(redni).getFec_devo());

        } else {
            JOptionPane.showMessageDialog(rootPane, "El estudiante no tiene prestamos pendiente o no esta registrado .....");
        }
    }//GEN-LAST:event_btnBusq_Bi_PresActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        ArrayList<Prestamos> prestamosList = pd.listarTodo();
        Prestamos[] prestamosArray = prestamosList.toArray(new Prestamos[0]);
        MDO_Prestamos MDO_P = new MDO_Prestamos();

        MDO_P.quickSort(prestamosArray, 0, prestamosArray.length - 1);

        DefaultTableModel model = (DefaultTableModel) jTable5.getModel();
        model.setRowCount(0);

        for (Prestamos prestamo : prestamosArray) {
            model.addRow(new Object[]{
                prestamo.getCod_libro(),
                prestamo.getDni(),
                prestamo.getCod_prestamo(),
                prestamo.getFec_pres(),
                prestamo.getFec_devo()
            });
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnBus_Pres_Sec_CodPresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBus_Pres_Sec_CodPresActionPerformed
        String redni = JOptionPane.showInputDialog("Ingrese el codigo de prestamo");

        Prestamos pres_cod = MDO_P.busquedaCodPres(redni);

        if (pres_cod != null) {
            JOptionPane.showMessageDialog(rootPane, "Cod_Libro:              "
                    + MDO_P.busquedaCodPres(redni).getCod_libro() + "\n" + "Dni:                         "
                    + MDO_P.busquedaCodPres(redni).getDni() + "\n" + "Cod_prestamo:      "
                    + MDO_P.busquedaCodPres(redni).getCod_prestamo() + "\n" + "Fec_pres:               "
                    + MDO_P.busquedaCodPres(redni).getFec_pres() + "\n" + "Fec_devo:              "
                    + MDO_P.busquedaCodPres(redni).getFec_devo());
        } else {
            JOptionPane.showMessageDialog(rootPane, "El codigo no existe .....");
        }
    }//GEN-LAST:event_btnBus_Pres_Sec_CodPresActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ArrayList<Prestamos> FechaDevolu2 = pd.listarTodo();
        
        MDO_Prestamos MDO_DEV = new MDO_Prestamos();
        //añado datos a mi arraylist

        //Llamar a un objeto para usar su metodo
        MDO_DEV.MetodoInserccion(FechaDevolu2);
        //MDO_P.quickSort(prestamosArray, 0, prestamosArray.length - 1);

        //mostrarlo en la tabla 
        DefaultTableModel model2 = (DefaultTableModel) jTable5.getModel();
        model2.setRowCount(0);

        //for para leer cada uno 
        for (Prestamos prestamo : FechaDevolu2) {
            model2.addRow(new Object[]{
                prestamo.getCod_libro(),
                prestamo.getDni(),
                prestamo.getCod_prestamo(),
                prestamo.getFec_pres(),
                prestamo.getFec_devo()
            });
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ArrayList<Prestamos> prestamosList = pd.listarTodo();
        Prestamos[] prestamosArray = prestamosList.toArray(new Prestamos[0]);
        int[] prestamos = new int[prestamosArray.length];
        MDO_Prestamos MDO_P = new MDO_Prestamos();

        MDO_P.shellSortCodLibro(prestamos);

        DefaultTableModel model = (DefaultTableModel) jTable5.getModel();
        model.setRowCount(0);

        for (Prestamos prestamo : prestamosArray) {
            model.addRow(new Object[]{
                prestamo.getCod_libro(),
                prestamo.getDni(),
                prestamo.getCod_prestamo(),
                prestamo.getFec_pres(),
                prestamo.getFec_devo()
            });
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ArrayList<Prestamos> prestamosList = pd.listarTodo();
        Prestamos[] prestamosArray = prestamosList.toArray(new Prestamos[0]);
        int[] codLibros = new int[prestamosArray.length];

        
        MDO_Prestamos MDO_P = new MDO_Prestamos();
        

        MDO_P.mergeSortFecPres(prestamosArray, 0 , codLibros.length-1);

        DefaultTableModel model = (DefaultTableModel) jTable5.getModel();
        model.setRowCount(0);

        for (Prestamos prestamo : prestamosArray) {
            model.addRow(new Object[]{
                prestamo.getCod_libro(),
                prestamo.getDni(),
                prestamo.getCod_prestamo(),
                prestamo.getFec_pres(),
                prestamo.getFec_devo()
            });
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(BuscarPres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarPres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarPres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarPres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarPres().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBus_Pres_Sec_CodPres;
    private javax.swing.JButton btnBusq_Bi_Pres;
    private javax.swing.JButton btnVolverp;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable5;
    // End of variables declaration//GEN-END:variables
}
