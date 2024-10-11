package Vista;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class tablaHash_P extends javax.swing.JFrame {

    public tablaHash_P() {
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
        jTable3.setModel(modelo);
    }

    // Método para calcular el índice
    private int calcularIndicePlegamiento(int clave, int tamaño) {
        String numberStr = String.valueOf(clave);
        String numizq = numberStr.substring(0, 3);
        String numder = numberStr.substring(3, 6);
        int izq = Integer.parseInt(numizq);
        int der = Integer.parseInt(numder);
        return (izq + der) % tamaño;
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
    // Método para manejar colisiones y encontrar el siguiente índice vacío
 private int resCualisionCuadratica(int index, int tamaño, DefaultTableModel modelo) {
    int newIndex = index;
    boolean found = false;
    int i = 1; // Número de intentos
    
    while (!found) {
        // Calcula el nuevo índice usando desplazamiento cuadrático
        newIndex = (index + i * i) % tamaño;
        
        // Verifica si el índice calculado está vacío
        boolean isEmpty = true;
        for (int row = 0; row < modelo.getRowCount(); row++) {
            if ((int) modelo.getValueAt(row, 0) == newIndex) {
                if (!modelo.getValueAt(row, 1).toString().isEmpty()
                        && !modelo.getValueAt(row, 2).toString().isEmpty()
                        && !modelo.getValueAt(row, 3).toString().isEmpty()) {
                    isEmpty = false;
                    break;
                }
            }
        }
        
        // Si se encuentra un índice vacío, devolverlo
        if (isEmpty) {
            return newIndex;
        }
        
        // Incrementar el número de intentos
        i++;
        
        // Verificar si hemos probado todas las posibles posiciones
        if (i > tamaño) {
            JOptionPane.showMessageDialog(null, "No hay espacio disponible para insertar.",
                    "Tabla llena", JOptionPane.WARNING_MESSAGE);
            return -1; // Indica que no hay espacio disponible
        }
    }
    
    return -1; // En caso de que no se encuentre un índice vacío
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtClave = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTamaño = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEditorial = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnInsertar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGenerarTabla = new javax.swing.JButton();
        btnExp_Cuadratica = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Insertar Editorial - T.Hash Plegamiento");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 0, 0))); // NOI18N

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Index", "Clave", "Editorial", "Número"
            }
        ));
        jScrollPane1.setViewportView(jTable3);

        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/volver.png"))); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingrese Datos"));

        jLabel1.setText("Clave");

        txtClave.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClaveActionPerformed(evt);
            }
        });

        jLabel2.setText("Tamaño de la tabla");

        txtTamaño.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTamaño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTamañoActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre Editorial");

        txtEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEditorialActionPerformed(evt);
            }
        });

        jLabel4.setText("Número");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTamaño)
                            .addComponent(txtEditorial)
                            .addComponent(txtClave))))
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTamaño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));
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

        btnGenerarTabla.setText("Generar Tabla Hash");
        btnGenerarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarTablaActionPerformed(evt);
            }
        });

        btnExp_Cuadratica.setText("Insertar Resolviendo Coalision Exp.Cuadratica");
        btnExp_Cuadratica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExp_CuadraticaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnGenerarTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExp_Cuadratica, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(btnGenerarTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExp_Cuadratica, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(273, Short.MAX_VALUE)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(268, 268, 268))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 32, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        Elegir_THash tAM = new Elegir_THash();
        tAM.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        if (txtTamaño.getText().isEmpty() || txtClave.getText().isEmpty() || txtNumero.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos antes de insertar.",
                    "Campos vacíos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int tamaño = Integer.parseInt(txtTamaño.getText());
        int clave1 = Integer.parseInt(txtClave.getText());
        String editorial = txtEditorial.getText();
        int numero = Integer.parseInt(txtNumero.getText());

        //Revisar si el numero tiene 6 digitos
        String numberStr = String.valueOf(clave1);
        if (numberStr.length() == 6) {

            // Calcular el índice utilizando el método
            int index = calcularIndicePlegamiento(clave1, tamaño);

            // Verifica si hay colisión en el índice calculado
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
        } else {
            JOptionPane.showMessageDialog(this, "Revisar si la clave tiene 6 digitos",
                    "Revisar clave", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnGenerarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarTablaActionPerformed
        int tamaño = Integer.parseInt(txtTamaño.getText());

        for (int i = 0; i < tamaño; i++) {
            Object[] row = {i, "", "", ""};
            modelo.addRow(row);
        }

        jTable3.setModel(modelo);
    }//GEN-LAST:event_btnGenerarTablaActionPerformed

    private void btnExp_CuadraticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExp_CuadraticaActionPerformed
        // Verifica que los campos no estén vacíos
        if (txtTamaño.getText().isEmpty() || txtClave.getText().isEmpty() || txtNumero.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos antes de insertar.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int tamaño = Integer.parseInt(txtTamaño.getText());
        int clave1 = Integer.parseInt(txtClave.getText());
        String editorial = txtEditorial.getText();
        int numero = Integer.parseInt(txtNumero.getText());

        int index = calcularIndicePlegamiento(clave1, tamaño);

        int index1 = resCualisionCuadratica(index, tamaño, modelo);

        // Inserta la fila en el índice correspondiente
        if (index1 < modelo.getRowCount()) {
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
    }//GEN-LAST:event_btnExp_CuadraticaActionPerformed

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

    private void txtTamañoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTamañoActionPerformed
        txtEditorial.requestFocus();
    }//GEN-LAST:event_txtTamañoActionPerformed

    private void txtClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClaveActionPerformed
        txtTamaño.requestFocus();
    }//GEN-LAST:event_txtClaveActionPerformed

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
            java.util.logging.Logger.getLogger(tablaHash_P.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tablaHash_P.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tablaHash_P.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tablaHash_P.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tablaHash_P().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnExp_Cuadratica;
    private javax.swing.JButton btnGenerarTabla;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtEditorial;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtTamaño;
    // End of variables declaration//GEN-END:variables
}
