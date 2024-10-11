package Vista;

import Modelo.Editorial;
import ModeloDAO.EditorialDAO;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Buscaredi extends javax.swing.JFrame {

    public Buscaredi() {
        initComponents();
        //Centrar el Buscaredi
        this.setLocationRelativeTo(null);
        mostrarCabecerasEdi();
    }

    DefaultTableModel modelo8 = new DefaultTableModel();
    
    public void mostrarCabecerasEdi(){
        modelo8.addColumn("Nom_editorial");
        modelo8.addColumn("Nom_Editorial");
        modelo8.addColumn("Telefono");
        jTable8.setModel(modelo8);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        txtBuscarEdi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        btnVolverEdi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Biblioteca Virtual -- Buscar Editorial");
        setResizable(false);

        jLabel1.setText("Buscar por el nombre la editorial");

        txtBuscarEdi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarEdiKeyReleased(evt);
            }
        });

        jTable8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Cod_editorial", "Nom_editorial", "Telefono"
            }
        ));
        jScrollPane1.setViewportView(jTable8);

        btnVolverEdi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/volver.png"))); // NOI18N
        btnVolverEdi.setText("Volver");
        btnVolverEdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverEdiActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtBuscarEdi, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnVolverEdi, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(txtBuscarEdi, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(btnVolverEdi, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtBuscarEdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnVolverEdi)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarEdiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarEdiKeyReleased
        EditorialDAO ed = new EditorialDAO();
        ArrayList<Editorial> vc = new ArrayList<>();
        int filas= modelo8.getRowCount();
        for(int i=0 ; i<filas ; i++){
            modelo8.removeRow(0);
        }
        vc=ed.buscaredi(txtBuscarEdi.getText());
        for(int i=0 ; i<vc.size(); i++){
            Object [] data = {vc.get(i).getCod_editorial(),vc.get(i).getNom_editorial(),vc.get(i).getTelefono()};
            modelo8.addRow(data);
            
        }
    }//GEN-LAST:event_txtBuscarEdiKeyReleased

    private void btnVolverEdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverEdiActionPerformed
       Principal pr=new Principal();
        pr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverEdiActionPerformed

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
            java.util.logging.Logger.getLogger(Buscaredi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Buscaredi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Buscaredi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Buscaredi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Buscaredi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolverEdi;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable8;
    private javax.swing.JTextField txtBuscarEdi;
    // End of variables declaration//GEN-END:variables
}
