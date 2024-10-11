package Confi;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {
    public static Connection getConexion(){ 
    Connection con = null;
    try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
        String url = "jdbc:sqlserver://DESKTOP-CGVF42G\\SQLEXPRESS:58731;databaseName=Libreria";
        String usr = "lesu"; 
        String psw = "12345"; 
        con = DriverManager.getConnection(url,usr,psw);
        System.out.println("Conexión correcta.");
    } 
    catch (ClassNotFoundException ex) { 
        JOptionPane.showMessageDialog(null, "Error al conectar el driver"+ex.toString());
    } 
    catch (SQLException ex) { 
        JOptionPane.showMessageDialog(null, "Error al conectar la bd  "+ex.toString());
    }
    return con;
    }
}