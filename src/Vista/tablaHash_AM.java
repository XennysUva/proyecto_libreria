package Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class tablaHash_AM extends javax.swing.JFrame {

    public tablaHash_AM() {
        initComponents();
        // Centrar JFrame
        this.setLocationRelativeTo(null);
        mostrarCabecerasEstu();
    }

    DefaultTableModel modelo = new DefaultTableModel();

    public void mostrarCabecerasEstu() {
        modelo.addColumn("Index");
        modelo.addColumn("Clave");
        modelo.addColumn("Editorial");
        modelo.addColumn("Numero");
        jTable1.setModel(modelo);
    }

    private boolean verificarColision(int index, DefaultTableModel modelo) {
        //bucle para recorrer las filas de la tabla
        for (int i = 0; i < modelo.getRowCount(); i++) {
            //verifica si los indices coinciden
            if ((int) modelo.getValueAt(i, 0) == index) {
                // Verifica si los campos clave, editorial y número ya tienen valores
                if (!modelo.getValueAt(i, 1).toString().isEmpty()
                        && !modelo.getValueAt(i, 2).toString().isEmpty()
                        && !modelo.getValueAt(i, 3).toString().isEmpty()) {
                    return true; // Hay colisión
                }
            }
        }
        return false; // No hay colisión
    }

    public int resCoalisionExploLineal(int index, int tamaño, DefaultTableModel modelo) {
        // Busca el siguiente índice vacío
        int newIndex = index;
        boolean found = false;
        while (!found) {
            newIndex = (newIndex + 1) % tamaño;
            if (newIndex == index) {
                JOptionPane.showMessageDialog(null, "No hay espacio disponible para insertar.",
                        "Tabla llena", JOptionPane.WARNING_MESSAGE);
                return -1; // Indica que no hay espacio disponible
            }
            boolean isEmpty = true;
            for (int i = 0; i < modelo.getRowCount(); i++) {
                if ((int) modelo.getValueAt(i, 0) == newIndex) {
                    if (!modelo.getValueAt(i, 1).toString().isEmpty()
                            && !modelo.getValueAt(i, 2).toString().isEmpty()
                            && !modelo.getValueAt(i, 3).toString().isEmpty()) {
                        isEmpty = false;
                        break;
                    }
                }
            }
            if (isEmpty) {
                index = newIndex;
                found = true;
            }
        }
        return index; // Retorna el índice encontrado
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnVolver = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        clave = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtClave = new javax.swing.JTextField();
        txtTamaño = new javax.swing.JTextField();
        txtEditorial = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnInsertar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGenerarTablaHash = new javax.swing.JButton();
        btnResolverColision = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Insertar Editorial - T.Hash Aritmetica Modular");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 51, 51))); // NOI18N

        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/volver.png"))); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.setToolTipText("");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Index", "Clave", "Editorial", "Numero"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingresar datos"));

        clave.setText("Clave");

        jLabel2.setText("Tamaño de la tabla");

        jLabel1.setText("Nombre Editorial");

        jLabel3.setText("Número");

        txtClave.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClaveActionPerformed(evt);
            }
        });

        txtTamaño.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTamaño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTamañoActionPerformed(evt);
            }
        });

        txtEditorial.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEditorialActionPerformed(evt);
            }
        });

        txtNumero.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(txtEditorial, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(clave, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTamaño)
                            .addComponent(txtClave))))
                .addGap(22, 22, 22))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clave)
                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTamaño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Botones"));

        btnInsertar.setText("Insertar");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnGenerarTablaHash.setText("Generar Tabla Hash");
        btnGenerarTablaHash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarTablaHashActionPerformed(evt);
            }
        });

        btnResolverColision.setText("Insertar resolviendo Coalision Exp.Lineal");
        btnResolverColision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResolverColisionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnGenerarTablaHash, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnResolverColision, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)))
                .addGap(24, 24, 24))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertar)
                    .addComponent(btnEliminar))
                .addGap(18, 18, 18)
                .addComponent(btnGenerarTablaHash, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnResolverColision, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(255, 255, 255))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        Elegir_THash tAM = new Elegir_THash();
        tAM.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        if (txtTamaño.getText().isEmpty() || txtClave.getText().isEmpty() || txtNumero.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos antes de insertar.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int tamaño = Integer.parseInt(txtTamaño.getText());
        int clave1 = Integer.parseInt(txtClave.getText());
        String editorial = txtEditorial.getText();
        int numero = Integer.parseInt(txtNumero.getText());

        int index = clave1 % tamaño;

        boolean colision = verificarColision(index, modelo);

        if (colision == true) {
            JOptionPane.showMessageDialog(this, "Existe colisión en el índice: " + index,
                    "Colisión detectada", JOptionPane.WARNING_MESSAGE);
        } else {
            // Si no hay colisión, inserta la fila en el índice correspondiente
            if (index < modelo.getRowCount()) {
                modelo.setValueAt(index, index, 0);
                modelo.setValueAt(clave1, index, 1);
                modelo.setValueAt(editorial, index, 2);
                modelo.setValueAt(numero, index, 3);
            } else {
                // Si el índice es mayor que el número de filas, añade filas vacías hasta llegar al índice
                while (modelo.getRowCount() <= index) {
                    modelo.addRow(new Object[]{modelo.getRowCount(), "", "", ""});
                }
                modelo.setValueAt(index, index, 0);
                modelo.setValueAt(clave1, index, 1);
                modelo.setValueAt(editorial, index, 2);
                modelo.setValueAt(numero, index, 3);
            }
        }
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void txtClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClaveActionPerformed
        txtTamaño.requestFocus();
    }//GEN-LAST:event_txtClaveActionPerformed

    private void btnResolverColisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResolverColisionActionPerformed
        if (txtTamaño.getText().isEmpty() || txtClave.getText().isEmpty() || txtNumero.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos antes de insertar.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int tamaño = Integer.parseInt(txtTamaño.getText());
        int clave1 = Integer.parseInt(txtClave.getText());
        String editorial = txtEditorial.getText();
        int numero = Integer.parseInt(txtNumero.getText());

        int index = clave1 % tamaño;

        int index1 = resCoalisionExploLineal(index, tamaño, modelo);

        // Inserta la fila en el índice correspondiente
        if (index < modelo.getRowCount()) {
            modelo.setValueAt(index1, index1, 0);
            modelo.setValueAt(clave1, index1, 1);
            modelo.setValueAt(editorial, index1, 2);
            modelo.setValueAt(numero, index1, 3);
        } else {
            // Si el índice es mayor que el número de filas, añade filas vacías hasta llegar al índice
            while (modelo.getRowCount() <= index) {
                modelo.addRow(new Object[]{modelo.getRowCount(), "", "", ""});
            }
            modelo.setValueAt(index1, index1, 0);
            modelo.setValueAt(clave1, index1, 1);
            modelo.setValueAt(editorial, index1, 2);
            modelo.setValueAt(numero, index1, 3);
        }


    }//GEN-LAST:event_btnResolverColisionActionPerformed

    private void btnGenerarTablaHashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarTablaHashActionPerformed
        int tamaño = Integer.parseInt(txtTamaño.getText());

        for (int i = 0; i < tamaño; i++) {
            Object[] row = {i, "", "", ""};
            modelo.addRow(row);
        }

        // Vincula el modelo a jTable1
        jTable1.setModel(modelo);

    }//GEN-LAST:event_btnGenerarTablaHashActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // Verifica que el campo txtClave no esté vacío
        if (txtClave.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa una clave para eliminar.",
                    "Clave vacía", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int clave1 = Integer.parseInt(txtClave.getText());

        boolean encontrado = false;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            if (!modelo.getValueAt(i, 1).toString().isEmpty()
                    && (int) modelo.getValueAt(i, 1) == clave1) {
                // Borra los campos "Clave", "Editorial" y "Número" dejando el índice intacto
                modelo.setValueAt("", i, 1);
                modelo.setValueAt("", i, 2);
                modelo.setValueAt("", i, 3);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(this, "Clave no encontrada en la tabla.",
                    "Clave no encontrada", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtTamañoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTamañoActionPerformed
        txtEditorial.requestFocus();
    }//GEN-LAST:event_txtTamañoActionPerformed

    private void txtEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEditorialActionPerformed
        txtNumero.requestFocus();
    }//GEN-LAST:event_txtEditorialActionPerformed

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
            java.util.logging.Logger.getLogger(tablaHash_AM.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tablaHash_AM.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tablaHash_AM.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tablaHash_AM.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tablaHash_AM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGenerarTablaHash;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnResolverColision;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel clave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtEditorial;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtTamaño;
    // End of variables declaration//GEN-END:variables
}
