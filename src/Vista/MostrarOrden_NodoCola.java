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

public class MostrarOrden_NodoCola extends javax.swing.JFrame {

    Lista_Cola lista= new Lista_Cola();

    public MostrarOrden_NodoCola() {
        initComponents();
        //Centrar el JFrame
        this.setLocationRelativeTo(null);
        mostrarElementos();
    }

    public void setLista(Lista_Cola lista) {
        this.lista = lista;
        mostrarElementos();
    }

    private void mostrarElementos() {

        if (lista == null && lista.getInicio() == null) {
            txtA.append("Lista vacía.\n");
        } else {
            Nodo_Cola elemento = lista.getInicio();

            while (elemento != null) {
                txtA.append(elemento.getDato().getCod_prestamo() + "-" + elemento.getDato().getCod_libro() + "-->");
                elemento = elemento.getSiguiente();
            }
            txtA.append("\n");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtA = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mostrar Orden - Lista Enlazada con Nodos");
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Orden", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 14), new java.awt.Color(255, 0, 51))); // NOI18N

        txtA.setColumns(20);
        txtA.setRows(5);
        jScrollPane1.setViewportView(txtA);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(MostrarOrden_NodoCola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MostrarOrden_NodoCola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MostrarOrden_NodoCola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MostrarOrden_NodoCola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MostrarOrden_NodoCola().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtA;
    // End of variables declaration//GEN-END:variables
}
