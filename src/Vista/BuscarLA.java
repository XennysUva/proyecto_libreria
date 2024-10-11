
package Vista;

import Modelo.Libros;
import ModeloDAO.LibrosDAO;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class BuscarLA extends javax.swing.JFrame {

    /**
     * Creates new form BuscarLA
     */
    public BuscarLA() {
        initComponents();
        //Centrar el BuscarLA
        this.setLocationRelativeTo(null);
        mostrarCabecerasLib();
    }
    DefaultTableModel modelo6 = new DefaultTableModel();
    public void mostrarCabecerasLib(){
        modelo6.addColumn("Cod_libro");
        modelo6.addColumn("Nom_libro");
        modelo6.addColumn("Stock");
        modelo6.addColumn("Autor");
        modelo6.addColumn("Cod_editorial");
        jTable6.setModel(modelo6);
    } 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtBuscarl = new javax.swing.JTextField();
        txtBuscara = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        btnVolver2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Biblioteca Virtual -- Buscar por Libro o Autor");

        jLabel1.setText("Buscar por nombre del libro");

        jLabel2.setText("Buscar por el autor del libro");

        txtBuscarl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarlActionPerformed(evt);
            }
        });
        txtBuscarl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarlKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarlKeyReleased(evt);
            }
        });

        txtBuscara.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscaraKeyReleased(evt);
            }
        });

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cod_libro", "Nom_libro", "Stock", "Autor", "Cod_editorial"
            }
        ));
        jScrollPane1.setViewportView(jTable6);

        btnVolver2.setFont(new java.awt.Font("Times New Roman", 3, 15)); // NOI18N
        btnVolver2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/volver.png"))); // NOI18N
        btnVolver2.setText("Volver ");
        btnVolver2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolver2ActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtBuscarl, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtBuscara, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnVolver2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtBuscarl))
                        .addGap(162, 162, 162)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                            .addComponent(txtBuscara)))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(btnVolver2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(30, 30, 30)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVolver2)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarlKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarlKeyReleased
        LibrosDAO ld = new LibrosDAO();
        ArrayList<Libros> vc = new ArrayList<>();
        int filas= modelo6.getRowCount();
        for(int i=0 ; i<filas ; i++){
            modelo6.removeRow(0);
        }
        vc=ld.buscarnl(txtBuscarl.getText());
        for(int i=0 ; i<vc.size(); i++){
            Object [] data = {vc.get(i).getCod_libro(),vc.get(i).getNom_libro(),vc.get(i).getStock()
                    ,vc.get(i).getAutor(),vc.get(i).getCod_editorial()};
            modelo6.addRow(data);
            
        }
        
    }//GEN-LAST:event_txtBuscarlKeyReleased

    private void txtBuscarlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarlActionPerformed

    private void btnVolver2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolver2ActionPerformed
        Principal pr=new Principal();
        pr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolver2ActionPerformed

    private void txtBuscaraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaraKeyReleased
       LibrosDAO ld = new LibrosDAO();
        ArrayList<Libros> vc = new ArrayList<>();
        int filas= modelo6.getRowCount();
        for(int i=0 ; i<filas ; i++){
            modelo6.removeRow(0);
        }
        vc=ld.buscarna(txtBuscara.getText());
        for(int i=0 ; i<vc.size(); i++){
            Object [] data = {vc.get(i).getCod_libro(),vc.get(i).getNom_libro(),vc.get(i).getStock()
                    ,vc.get(i).getAutor(),vc.get(i).getCod_editorial()};
            modelo6.addRow(data);
            
        }
    }//GEN-LAST:event_txtBuscaraKeyReleased

    private void txtBuscarlKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarlKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarlKeyPressed

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
            java.util.logging.Logger.getLogger(BuscarLA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarLA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarLA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarLA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarLA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolver2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable6;
    private javax.swing.JTextField txtBuscara;
    private javax.swing.JTextField txtBuscarl;
    // End of variables declaration//GEN-END:variables
}
