package ModeloDAO;

import Confi.Conexion;
import MInterfaces.EncargadoInterface;
import Modelo.Encargado;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class EncargadoDAO implements EncargadoInterface{
    Conexion con = new Conexion();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    ArrayList<Encargado> ven = new ArrayList<>();
    @Override
    public ArrayList<Encargado> listarTodo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insertar(Encargado c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
      public List<Encargado> lisNenca(){
      conn = con.getConexion();
      List<Encargado> lista=new ArrayList();
      try{
        String sql="select cod_encargado, nom_encargado from Encargado";
        CallableStatement st=conn.prepareCall(sql);
        ResultSet rst=st.executeQuery();
        while(rst.next()){
            Encargado xd = new Encargado();
            xd.setCod_encargado(rst.getString(1));
            xd.setNom_encargado(rst.getString(2));
            lista.add(xd);
        }
        conn.close();
      }catch(Exception ex){
            Logger.getLogger(EncargadoDAO.class.getName()).log(Level.SEVERE, null, ex);      
      }
        
       return lista; 
    }
      
      
    

}
