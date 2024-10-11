package Vista;

import Modelo.Estudiantes;
import ModeloDAO.EstudiantesDAO;
import ModeloDAO.MDO_Estudiantes;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BuscarE extends javax.swing.JFrame {
    MDO_Estudiantes MDO_E;
    public BuscarE() {
        initComponents();
        //Centrar BuscarE
        this.setLocationRelativeTo(null);
        mostrarCabecerasEstu();
        mostrarTodosEstudiantes();
        MDO_E=new MDO_Estudiantes();
    }
    DefaultTableModel modelo7 = new DefaultTableModel();

    public void mostrarCabecerasEstu() {
        modelo7.addColumn("DNI");
        modelo7.addColumn("Nombres");
        modelo7.addColumn("Apellidos");
        modelo7.addColumn("Grado");
        modelo7.addColumn("Seccion");
        jTable7.setModel(modelo7);
    }

    EstudiantesDAO ed = new EstudiantesDAO();

    public void mostrarTodosEstudiantes() {
        ArrayList<Estudiantes> ve = new ArrayList<>();

        ve = ed.listarTodo();
        for (int i = 0; i < ve.size(); i++) {
            Object[] data = {ve.get(i).getDni(), ve.get(i).getNombres(),
                ve.get(i).getApellidos(), ve.get(i).getGrado(), ve.get(i).getSeccion()};
            modelo7.addRow(data);
        }
    }
    
    private void listarEstudiantes(){
    
        for(int i=0; i<MDO_E.getListaC().size();i++){
            jTable7.setValueAt(MDO_E.getListaC().get(i).getDni(), i, 0);
            jTable7.setValueAt(MDO_E.getListaC().get(i).getNombres(), i, 1);
            jTable7.setValueAt(MDO_E.getListaC().get(i).getApellidos(), i, 2);  
            jTable7.setValueAt(MDO_E.getListaC().get(i).getGrado(), i, 3); 
            jTable7.setValueAt(MDO_E.getListaC().get(i).getSeccion(), i, 4); 
            
        }
    }
    /*
        //txt key Released
        EstudiantesDAO ed = new EstudiantesDAO ();
        ArrayList<Estudiantes> vc = new ArrayList<>();
        //Borrar todos los elementos de la tabla
        int filas= modelo7.getRowCount();
        for(int i=0 ; i<filas ; i++){
            modelo7.removeRow(0);
        }
        vc=ed.buscare(txtBuscarE.getText());
        for(int i=0 ; i<vc.size(); i++){
            Object [] data = {vc.get(i).getDni(),vc.get(i).getNombres(),vc.get(i).getApellidos()
                    ,vc.get(i).getGrado(),vc.get(i).getSeccion()};
            modelo7.addRow(data);
            
        }*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnBusq_E_Sec_DNI = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        VolverE = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        Busq_E_Bin_DNI = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Biblioteca Virtual -- Buscar Estudiante");
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(153, 255, 153));

        jPanel1.setBackground(new java.awt.Color(255, 255, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Busqueda Secuencial", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI Semibold", 3, 14))); // NOI18N
        jPanel1.setToolTipText("");

        btnBusq_E_Sec_DNI.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnBusq_E_Sec_DNI.setText("Busq por DNI");
        btnBusq_E_Sec_DNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusq_E_Sec_DNIActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnBusq_E_Sec_DNI, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBusq_E_Sec_DNI, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jTable7.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable7);

        VolverE.setFont(new java.awt.Font("Yu Gothic UI Semibold", 3, 14)); // NOI18N
        VolverE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/volver.png"))); // NOI18N
        VolverE.setText("Volver");
        VolverE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverEActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Busqueda Binaria", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI Semibold", 3, 14))); // NOI18N

        Busq_E_Bin_DNI.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Busq_E_Bin_DNI.setText("Busq por DNI");
        Busq_E_Bin_DNI.setMaximumSize(new java.awt.Dimension(191, 23));
        Busq_E_Bin_DNI.setMinimumSize(new java.awt.Dimension(191, 23));
        Busq_E_Bin_DNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Busq_E_Bin_DNIActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(Busq_E_Bin_DNI, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Busq_E_Bin_DNI, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 102, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ordenamiento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI Semibold", 3, 14))); // NOI18N

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton3.setText("Ord por Apellidos");
        jButton3.setToolTipText("");
        jButton3.setMaximumSize(new java.awt.Dimension(191, 23));
        jButton3.setMinimumSize(new java.awt.Dimension(191, 23));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton4.setText("Ord por Nombres");
        jButton4.setToolTipText("");
        jButton4.setMaximumSize(new java.awt.Dimension(191, 23));
        jButton4.setMinimumSize(new java.awt.Dimension(191, 23));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel2.setText("Burbuja");

        jLabel3.setText("Seleción");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imgCole__3_-removebg-preview_sinFondo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(VolverE, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(VolverE, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VolverEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverEActionPerformed
        Principal pr = new Principal();
        pr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_VolverEActionPerformed

    private void btnBusq_E_Sec_DNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusq_E_Sec_DNIActionPerformed

        int redni=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el DNI del estudiante:"));
        
        Estudiantes estudni=MDO_E.busquedaSecE(redni);
        
        if(estudni!=null){
            JOptionPane.showMessageDialog(rootPane, MDO_E.busquedaSecE(redni).getNombres()+
                    " " + MDO_E.busquedaSecE(redni).getApellidos()+" , "+MDO_E.busquedaSecE(redni).getGrado()+"  '' "+
                    MDO_E.busquedaSecE(redni).getSeccion()+" '' ");
        }else{
            JOptionPane.showMessageDialog(rootPane, "El estudiante no esta registrado .....");
        }
        
        
    }//GEN-LAST:event_btnBusq_E_Sec_DNIActionPerformed

    private void Busq_E_Bin_DNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Busq_E_Bin_DNIActionPerformed
        int redni=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el DNI del estudiante:"));
  
        if(MDO_E.busquedaBinE(redni)!=null){
            JOptionPane.showMessageDialog(rootPane, MDO_E.busquedaBinE(redni).getNombres()+
                    " " + MDO_E.busquedaBinE(redni).getApellidos()+" , "+MDO_E.busquedaBinE(redni).getGrado()+"  '' "+
                    MDO_E.busquedaBinE(redni).getSeccion()+" '' ");
            
        }else{
            JOptionPane.showMessageDialog(rootPane, "El estudiante no esta registrado .....");
        }
        
        
        
    }//GEN-LAST:event_Busq_E_Bin_DNIActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        MDO_E.ordEstuPorApellidos();
        listarEstudiantes();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        MDO_E.ordEstuPorNombres();
        listarEstudiantes();        
    }//GEN-LAST:event_jButton4ActionPerformed
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
            java.util.logging.Logger.getLogger(BuscarE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Busq_E_Bin_DNI;
    private javax.swing.JButton VolverE;
    private javax.swing.JButton btnBusq_E_Sec_DNI;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable7;
    // End of variables declaration//GEN-END:variables
}
