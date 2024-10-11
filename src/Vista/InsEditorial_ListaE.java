package Vista;

import ListaES_Editorial.ListaEnlazada;
import Modelo.Editorial;
import ListaES_Editorial.Editorial_LisE;
import ListaES_Editorial.Nodo;
import ModeloDAO.EditorialDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class InsEditorial_ListaE extends javax.swing.JFrame {

    /**
     * Creates new form InsEditorial_ListaE
     */
    public InsEditorial_ListaE() {
        initComponents();
        this.setLocationRelativeTo(null);
        //Metodos Editorial
        mostrarCabecerasEdi();

    }

    //Metodos de Lista enlazada para editorial
    ListaEnlazada lista = new ListaEnlazada();

    //Metodos editorial
    Editorial et = new Editorial();
    EditorialDAO etd = new EditorialDAO();
    DefaultTableModel modelo2 = new DefaultTableModel();

    public void mostrarCabecerasEdi() {
        modelo2.addColumn("Cod_editorial");
        modelo2.addColumn("Nom_Editorial");
        modelo2.addColumn("Telefono");
        jTable1.setModel(modelo2);
    }

    public void limpiarCajasEdi() {
        txtCod_editorial.setText(null);
        txtNom_Editorial.setText(null);
        txtTelefono.setText(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCod_editorial = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNom_Editorial = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnInsertar_Inicio = new javax.swing.JButton();
        btnQuitar_Inicio = new javax.swing.JButton();
        btnMostrar_ListaE = new javax.swing.JButton();
        btnSalir_ListaE = new javax.swing.JButton();
        btnInsertar_Final = new javax.swing.JButton();
        btnInsertar_Medio = new javax.swing.JButton();
        btnQuitar_Medio = new javax.swing.JButton();
        btnQuitar_Final = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Insertar Editorial - Lista Enlazada");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Insertar Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14), new java.awt.Color(255, 0, 51))); // NOI18N

        jLabel1.setText("Cod editorial");

        txtCod_editorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCod_editorialActionPerformed(evt);
            }
        });

        jLabel2.setText("Nom editorial");

        txtNom_Editorial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNom_EditorialKeyPressed(evt);
            }
        });

        jLabel3.setText("Teléfono");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imgCole__3_-removebg-preview_sinFondo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCod_editorial, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(txtNom_Editorial)
                    .addComponent(txtTelefono))
                .addGap(58, 58, 58)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCod_editorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNom_Editorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
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

        btnInsertar_Inicio.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnInsertar_Inicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nuevo.png"))); // NOI18N
        btnInsertar_Inicio.setText("Insertar Inicio");
        btnInsertar_Inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertar_InicioActionPerformed(evt);
            }
        });

        btnQuitar_Inicio.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnQuitar_Inicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        btnQuitar_Inicio.setText("Quitar inicio");
        btnQuitar_Inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitar_InicioActionPerformed(evt);
            }
        });

        btnMostrar_ListaE.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnMostrar_ListaE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/oden_icon.png"))); // NOI18N
        btnMostrar_ListaE.setText("Mostar Orden");
        btnMostrar_ListaE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrar_ListaEActionPerformed(evt);
            }
        });

        btnSalir_ListaE.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnSalir_ListaE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/volver.png"))); // NOI18N
        btnSalir_ListaE.setText("Salir");
        btnSalir_ListaE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir_ListaEActionPerformed(evt);
            }
        });

        btnInsertar_Final.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnInsertar_Final.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nuevo.png"))); // NOI18N
        btnInsertar_Final.setText("Insertar final");
        btnInsertar_Final.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertar_FinalActionPerformed(evt);
            }
        });

        btnInsertar_Medio.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnInsertar_Medio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nuevo.png"))); // NOI18N
        btnInsertar_Medio.setText("Insertar medio");
        btnInsertar_Medio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertar_MedioActionPerformed(evt);
            }
        });

        btnQuitar_Medio.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnQuitar_Medio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        btnQuitar_Medio.setText("Quitar medio");
        btnQuitar_Medio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitar_MedioActionPerformed(evt);
            }
        });

        btnQuitar_Final.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnQuitar_Final.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        btnQuitar_Final.setText("Quitar final");
        btnQuitar_Final.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitar_FinalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnQuitar_Medio, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnQuitar_Final, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnInsertar_Medio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnInsertar_Final, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnInsertar_Inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnMostrar_ListaE, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnSalir_ListaE, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnQuitar_Inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(btnInsertar_Inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnInsertar_Final, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(btnInsertar_Medio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btnQuitar_Inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnQuitar_Final, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnQuitar_Medio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnMostrar_ListaE, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalir_ListaE, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void txtCod_editorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCod_editorialActionPerformed
        txtNom_Editorial.requestFocus();
    }//GEN-LAST:event_txtCod_editorialActionPerformed

    private void txtNom_EditorialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNom_EditorialKeyPressed

    }//GEN-LAST:event_txtNom_EditorialKeyPressed
    public boolean validartl(String datos) {
        return datos.matches("[0-9]+");
    }
    private void btnInsertar_InicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertar_InicioActionPerformed
        String cod_editorial = txtCod_editorial.getText();
        String nom_editorial = txtNom_Editorial.getText();
        String telefono = txtTelefono.getText();
        if (cod_editorial.equals("") || (nom_editorial.equals("")) || (telefono.equals(""))) {
            JOptionPane.showInternalMessageDialog(null, "Los campos no pueden estar vacios.",
                    "Campos Vacios!!", JOptionPane.WARNING_MESSAGE);
        } else if (!validartl(telefono.trim())) {
            JOptionPane.showInternalMessageDialog(null, "Verificar si son 9 números",
                    "Revisar el Número!!", JOptionPane.ERROR_MESSAGE);
        } else if (cod_editorial.length() != 4 || telefono.length() != 9) {
            JOptionPane.showInternalMessageDialog(null, "Verificar si el COD_EDITORIAL tiene 4 caracteres y el TELEFONO tiene 9 caracteres",
                    "Verificar COD_EDITORIAL y TELEFONO!!", JOptionPane.ERROR_MESSAGE);
        } else if (etd.validarCoden(cod_editorial) > 0) {
            JOptionPane.showInternalMessageDialog(null, "El COD_ENCARGADO no puede coincidir con otro COD_ENCARGADO",
                    "Verificar COD_EDITORIAL!!", JOptionPane.ERROR_MESSAGE);
        } else if (etd.validarTele(telefono) > 0) {
            JOptionPane.showInternalMessageDialog(null, "El TELEFONO no puede coincidir con otro TELEFONO",
                    "Verificar el TELEFONO!!", JOptionPane.ERROR_MESSAGE);
        } else {
            Editorial_LisE editorial = new Editorial_LisE(cod_editorial, nom_editorial, telefono);
            lista.InsertarIni(editorial);
            Object data[] = {editorial.getCod_editorial(), editorial.getNom_editorial(), editorial.getTelefono()};
            et.setCod_editorial(txtCod_editorial.getText());
            et.setNom_editorial(txtNom_Editorial.getText());
            et.setTelefono(txtTelefono.getText());
            etd.insertar(et);
            modelo2.addRow(data);
            JOptionPane.showInternalMessageDialog(null, "Se registró correctamente la editorial.",
                    "Registro exitoso!!", JOptionPane.INFORMATION_MESSAGE);
            limpiarCajasEdi();
        }
    }//GEN-LAST:event_btnInsertar_InicioActionPerformed

    private void btnQuitar_InicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitar_InicioActionPerformed
        if (lista.getInicio() == null) {
            JOptionPane.showInternalMessageDialog(null, "No hay editoriales para eliminar.",
                    "Lista Vacía", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String codEditorial = lista.getInicio().getEditorial().getCod_editorial();

        if (etd.valLI_EDI(codEditorial) > 0) {
            JOptionPane.showInternalMessageDialog(null, "La editorial no puede ser borrada porque tiene un libro registrado.",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        lista.eliminarIni();

        etd.eliminar(codEditorial);

        for (int i = 0; i < modelo2.getRowCount(); i++) {
            if (modelo2.getValueAt(i, 0).toString().equals(codEditorial)) {
                modelo2.removeRow(i);
                break;
            }
        }

        JOptionPane.showInternalMessageDialog(null, "Se eliminó correctamente la editorial.",
                "Editorial eliminada", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnQuitar_InicioActionPerformed

    private void btnMostrar_ListaEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrar_ListaEActionPerformed
        MostrarOrden_ListaE mo_le = new MostrarOrden_ListaE();
        mo_le.setLista(lista); // Establecer la lista después de crear el objeto
        mo_le.setVisible(true);
    }//GEN-LAST:event_btnMostrar_ListaEActionPerformed

    private void btnSalir_ListaEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir_ListaEActionPerformed
        Principal pr = new Principal();
        pr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalir_ListaEActionPerformed

    private void btnInsertar_FinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertar_FinalActionPerformed
        String cod_editorial = txtCod_editorial.getText();
        String nom_editorial = txtNom_Editorial.getText();
        String telefono = txtTelefono.getText();
        if (cod_editorial.equals("") || (nom_editorial.equals("")) || (telefono.equals(""))) {
            JOptionPane.showInternalMessageDialog(null, "Los campos no pueden estar vacios.",
                    "Campos Vacios!!", JOptionPane.WARNING_MESSAGE);
        } else if (!validartl(telefono.trim())) {
            JOptionPane.showInternalMessageDialog(null, "Verificar si son 9 números",
                    "Revisar el Número!!", JOptionPane.ERROR_MESSAGE);
        } else if (cod_editorial.length() != 4 || telefono.length() != 9) {
            JOptionPane.showInternalMessageDialog(null, "Verificar si el COD_EDITORIAL tiene 4 caracteres y el TELEFONO tiene 9 caracteres",
                    "Verificar COD_EDITORIAL y TELEFONO!!", JOptionPane.ERROR_MESSAGE);
        } else if (etd.validarCoden(cod_editorial) > 0) {
            JOptionPane.showInternalMessageDialog(null, "El COD_ENCARGADO no puede coincidir con otro COD_ENCARGADO",
                    "Verificar COD_EDITORIAL!!", JOptionPane.ERROR_MESSAGE);
        } else if (etd.validarTele(telefono) > 0) {
            JOptionPane.showInternalMessageDialog(null, "El TELEFONO no puede coincidir con otro TELEFONO",
                    "Verificar el TELEFONO!!", JOptionPane.ERROR_MESSAGE);
        } else {
            et.setCod_editorial(txtCod_editorial.getText());
            et.setNom_editorial(txtNom_Editorial.getText());
            et.setTelefono(txtTelefono.getText());
            Editorial_LisE editorial = new Editorial_LisE(cod_editorial, nom_editorial, telefono);
            lista.InsertarFin(editorial);
            Object data[] = {editorial.getCod_editorial(), editorial.getNom_editorial(), editorial.getTelefono()};
            etd.insertar(et);
            modelo2.addRow(data);
            JOptionPane.showInternalMessageDialog(null, "Se registró correctamente la editorial.",
                    "Registro exitoso!!", JOptionPane.INFORMATION_MESSAGE);
            limpiarCajasEdi();
        }
    }//GEN-LAST:event_btnInsertar_FinalActionPerformed

    private void btnInsertar_MedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertar_MedioActionPerformed
        String cod_editorial = txtCod_editorial.getText();
        String nom_editorial = txtNom_Editorial.getText();
        String telefono = txtTelefono.getText();
        if (cod_editorial.equals("") || (nom_editorial.equals("")) || (telefono.equals(""))) {
            JOptionPane.showInternalMessageDialog(null, "Los campos no pueden estar vacios.",
                    "Campos Vacios!!", JOptionPane.WARNING_MESSAGE);
        } else if (!validartl(telefono.trim())) {
            JOptionPane.showInternalMessageDialog(null, "Verificar si son 9 números",
                    "Revisar el Número!!", JOptionPane.ERROR_MESSAGE);
        } else if (cod_editorial.length() != 4 || telefono.length() != 9) {
            JOptionPane.showInternalMessageDialog(null, "Verificar si el COD_EDITORIAL tiene 4 caracteres y el TELEFONO tiene 9 caracteres",
                    "Verificar COD_EDITORIAL y TELEFONO!!", JOptionPane.ERROR_MESSAGE);
        } else if (etd.validarCoden(cod_editorial) > 0) {
            JOptionPane.showInternalMessageDialog(null, "El COD_ENCARGADO no puede coincidir con otro COD_ENCARGADO",
                    "Verificar COD_EDITORIAL!!", JOptionPane.ERROR_MESSAGE);
        } else if (etd.validarTele(telefono) > 0) {
            JOptionPane.showInternalMessageDialog(null, "El TELEFONO no puede coincidir con otro TELEFONO",
                    "Verificar el TELEFONO!!", JOptionPane.ERROR_MESSAGE);
        } else {
            et.setCod_editorial(txtCod_editorial.getText());
            et.setNom_editorial(txtNom_Editorial.getText());
            et.setTelefono(txtTelefono.getText());
            Editorial_LisE editorial = new Editorial_LisE(cod_editorial, nom_editorial, telefono);
            lista.InsertarMed(editorial);
            Object data[] = {editorial.getCod_editorial(), editorial.getNom_editorial(), editorial.getTelefono()};
            etd.insertar(et);
            modelo2.addRow(data);
            JOptionPane.showInternalMessageDialog(null, "Se registró correctamente la editorial.",
                    "Registro exitoso!!", JOptionPane.INFORMATION_MESSAGE);
            limpiarCajasEdi();
        }
    }//GEN-LAST:event_btnInsertar_MedioActionPerformed

    private void btnQuitar_MedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitar_MedioActionPerformed
        if (lista.getInicio() == null) {
            JOptionPane.showInternalMessageDialog(null, "No hay editoriales para eliminar.",
                    "Lista Vacía", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Nodo nodoEliminar = null;
        Nodo anterior = null;
        Nodo actual = lista.getInicio();
        Nodo siguiente = actual.getSig();

        while (siguiente != null && siguiente.getSig() != null) {
            anterior = actual;
            actual = actual.getSig();
            siguiente = siguiente.getSig().getSig();
        }

        lista.eliminarMed(actual.getEditorial().getCod_editorial());

        if (etd.valLI_EDI(actual.getEditorial().getCod_editorial()) > 0) {
            JOptionPane.showInternalMessageDialog(null, "La editorial no puede ser borrada porque tiene un libro registrado.",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String codEditorialEliminar = actual.getEditorial().getCod_editorial();

        etd.eliminar(codEditorialEliminar);

        for (int i = 0; i < modelo2.getRowCount(); i++) {
            if (modelo2.getValueAt(i, 0).toString().equals(codEditorialEliminar)) {
                modelo2.removeRow(i);
                break; // 
            }
        }
        JOptionPane.showInternalMessageDialog(null, "Se eliminó correctamente la editorial.",
                "Editorial eliminada", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnQuitar_MedioActionPerformed

    private void btnQuitar_FinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitar_FinalActionPerformed
        if (lista.getInicio() == null) {
            JOptionPane.showInternalMessageDialog(null, "No hay editoriales para eliminar.",
                    "Lista Vacía", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Nodo nodoFinal = lista.getFin();
        Editorial_LisE editorial = nodoFinal.getEditorial();

        if (etd.valLI_EDI(editorial.getCod_editorial()) > 0) {
            JOptionPane.showInternalMessageDialog(null, "La editorial no puede ser borrada porque tiene un libro registrado.",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        lista.eliminarFin();

        etd.eliminar(editorial.getCod_editorial());

        int rowIndex = -1;
        for (int i = 0; i < modelo2.getRowCount(); i++) {
            if (modelo2.getValueAt(i, 0).equals(editorial.getCod_editorial())) {
                rowIndex = i;
                break;
            }
        }

        if (rowIndex != -1) {
            modelo2.removeRow(rowIndex);
        }

        JOptionPane.showInternalMessageDialog(null, "Se eliminó correctamente la editorial.",
                "Editorial eliminada", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnQuitar_FinalActionPerformed

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
            java.util.logging.Logger.getLogger(InsEditorial_ListaE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InsEditorial_ListaE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InsEditorial_ListaE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InsEditorial_ListaE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InsEditorial_ListaE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInsertar_Final;
    private javax.swing.JButton btnInsertar_Inicio;
    private javax.swing.JButton btnInsertar_Medio;
    private javax.swing.JButton btnMostrar_ListaE;
    private javax.swing.JButton btnQuitar_Final;
    private javax.swing.JButton btnQuitar_Inicio;
    private javax.swing.JButton btnQuitar_Medio;
    private javax.swing.JButton btnSalir_ListaE;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtCod_editorial;
    private javax.swing.JTextField txtNom_Editorial;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
