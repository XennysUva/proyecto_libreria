package Vista;

import Confi.Conexion;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        //Centrar el Login
        this.setLocationRelativeTo(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        Icandado = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        Icolegio = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Biblioteca Virtual -- Login");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        Icandado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iniciar.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Usuario");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Contraseña");

        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

        txtContraseña.setText("jPasswordField1");
        txtContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseñaActionPerformed(evt);
            }
        });
        txtContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContraseñaKeyPressed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(51, 153, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(96, 96, 96))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(Icandado, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(Icandado, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addGap(27, 27, 27)
                .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 320, 390));

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));

        Icolegio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imgCole__3_-removebg-preview_sinFondo.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("I.E. Carlos Pareja Paz Soldán");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(209, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Icolegio, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(226, 226, 226))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(Icolegio, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(255, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 460));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pexels_libreria (1).jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 330, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        txtContraseña.requestFocus();
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String u=txtUsuario.getText();
        String p=txtContraseña.getText();
        Conexion con = new Conexion();
        Connection conn;
        PreparedStatement ps;
        ResultSet rs;
        if ((u.equals("")) || (p.equals(""))){
                JOptionPane.showInternalMessageDialog(null, "Los campos no pueden estar vacios.",
                        "Campos Vacios!!", JOptionPane.WARNING_MESSAGE);
        }else if (u.length()!=4){
                JOptionPane.showInternalMessageDialog(null, "Verificar si el COD_ENCARGADO tiene 4 caracteres"
                        ,"Verificar COD_ENCARGADO!", JOptionPane.ERROR_MESSAGE);
        } else {  
            try {
                    String sqlSelect = "SELECT cod_encargado, contraseña FROM encargado WHERE cod_encargado = ? AND contraseña = ?";
                    conn = con.getConexion();
                    ps = conn.prepareStatement(sqlSelect); 
                    ps.setString(1, u);
                    ps.setString(2, p);
                    rs = ps.executeQuery();

                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Bienvenido.",
                                "Registro exitoso!!", JOptionPane.INFORMATION_MESSAGE);
                        Principal pp = new Principal();
                        pp.setVisible(true);
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrectos",
                                "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException | NumberFormatException ex) {
                         ex.printStackTrace(); 
            }     
        }
        
        
  
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseñaActionPerformed
        
    }//GEN-LAST:event_txtContraseñaActionPerformed

    private void txtContraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseñaKeyPressed
        if (evt.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
            jButton1.requestFocus();
            jButton1.doClick();
        }
    }//GEN-LAST:event_txtContraseñaKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Icandado;
    private javax.swing.JLabel Icolegio;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
