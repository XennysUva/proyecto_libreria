package Vista;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class tablaHash_Multi extends javax.swing.JFrame {

    public tablaHash_Multi() {
        initComponents();
        //Centar JFrame
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

    public int multiplicacion(int tamaño, int clave) {
        double R = 0.6183;
        double multiplicacion = R * clave;
        double decimal = multiplicacion - (int) multiplicacion;
        int direccion = (int) (tamaño * decimal);
        return direccion;
    }

    // Método para verificar colisión
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
             int newIndex = index;
        boolean found = false;
        while (!found) {
            newIndex = (newIndex + 2) % tamaño; // Salta un índice adicional
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
                return newIndex; // Devuelve el nuevo índice encontrado
            }
        }
        return -1; // En caso de que no se encuentre un índice vacío
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtClave = new javax.swing.JTextField();
        txtTamaño = new javax.swing.JTextField();
        txtEditorial = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnInsertar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGenerarTabla = new javax.swing.JButton();
        btnInsertarResolviendoCoalision = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingresar Datos"));

        jLabel1.setText("Clave");

        jLabel2.setText("Tamaño de la Tabla");

        jLabel3.setText("Nombre de Editorial");

        jLabel4.setText("Número");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtClave)
                    .addComponent(txtTamaño)
                    .addComponent(txtEditorial)
                    .addComponent(txtNumero, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addComponent(txtTamaño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        btnEliminar.setToolTipText("");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnGenerarTabla.setText("Generar Tabla Hash");
        btnGenerarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarTablaActionPerformed(evt);
            }
        });

        btnInsertarResolviendoCoalision.setText("Insertar resolviendo Coalision Exp.Lineal");
        btnInsertarResolviendoCoalision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarResolviendoCoalisionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGenerarTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnInsertarResolviendoCoalision, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(btnGenerarTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnInsertarResolviendoCoalision, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
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

        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/volver.png"))); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(267, 267, 267))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // Verifica que el campo txtClave no esté vacío
        if (txtClave.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa una clave para eliminar.", "Clave vacía", JOptionPane.WARNING_MESSAGE);
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

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        if (txtTamaño.getText().isEmpty() || txtClave.getText().isEmpty() || txtNumero.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos antes de insertar.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int tamaño = Integer.parseInt(txtTamaño.getText());
        int clave1 = Integer.parseInt(txtClave.getText());
        String editorial = txtEditorial.getText();
        int numero = Integer.parseInt(txtNumero.getText());

        int index = multiplicacion(tamaño, clave1);

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

    private void btnGenerarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarTablaActionPerformed
        int tamaño = Integer.parseInt(txtTamaño.getText());

        for (int i = 0; i < tamaño; i++) {
            Object[] row = {i, "", "", ""};
            modelo.addRow(row);
        }

        jTable1.setModel(modelo);
    }//GEN-LAST:event_btnGenerarTablaActionPerformed

    private void btnInsertarResolviendoCoalisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarResolviendoCoalisionActionPerformed
        if (txtTamaño.getText().isEmpty() || txtClave.getText().isEmpty() || txtNumero.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos antes de insertar.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int tamaño = Integer.parseInt(txtTamaño.getText());
        int clave1 = Integer.parseInt(txtClave.getText());
        String editorial = txtEditorial.getText();
        int numero = Integer.parseInt(txtNumero.getText());

        int index = multiplicacion(tamaño, clave1);

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
    }//GEN-LAST:event_btnInsertarResolviendoCoalisionActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        Elegir_THash tAM = new Elegir_THash();
        tAM.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

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
            java.util.logging.Logger.getLogger(tablaHash_Multi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tablaHash_Multi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tablaHash_Multi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tablaHash_Multi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tablaHash_Multi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGenerarTabla;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnInsertarResolviendoCoalision;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtEditorial;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtTamaño;
    // End of variables declaration//GEN-END:variables
}
