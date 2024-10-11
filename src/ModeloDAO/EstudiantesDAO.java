package ModeloDAO;

import Confi.Conexion;
import MInterfaces.EstudianteInterface;
import Modelo.Estudiantes;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class EstudiantesDAO implements EstudianteInterface{
    
    Conexion con = new Conexion();
    Connection conn;
    PreparedStatement ps;
    Estudiantes e;
    ResultSet rs;
    Statement st = null;
    ArrayList<Estudiantes> ve = new ArrayList<>();
    
    public ArrayList<Estudiantes> listarTodo() {
        try {
            String sql = "select * from Estudiantes";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                e = new Estudiantes();
                e.setDni(rs.getString("dni"));
                e.setNombres(rs.getString("nombres"));
                e.setApellidos(rs.getString("apellidos"));
                e.setGrado(rs.getString("grado"));
                e.setSeccion(rs.getString("seccion"));
                ve.add(e);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(EstudiantesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ve;
    }
    @Override
    public boolean insertar(Estudiantes e) {
        try {
            String sql = "insert into Estudiantes (dni, nombres, apellidos, grado, seccion) values (?, ?, ?, ?, ?)";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1,e.getDni());
            ps.setString(2, e.getNombres());
            ps.setString(3, e.getApellidos());
            ps.setString(4, e.getGrado());
            ps.setString(5, e.getSeccion());
            ps.executeUpdate();
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(EstudiantesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean eliminar(String codigo) {
        try {
            String sql = "delete from Estudiantes where dni = "+"'"+codigo+"'";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql); 
            ps.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(EstudiantesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<Estudiantes> buscare(String c){
        try{
            String sql="SELECT * FROM Estudiantes WHERE concat(nombres, apellidos)LIKE '%"+c+"%'";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql); 
            rs=ps.executeQuery();
            while(rs.next()){
                Estudiantes e = new Estudiantes();
                e.setDni(rs.getString("Dni"));
                e.setNombres(rs.getString("Nombres"));
                e.setApellidos(rs.getString("Apellidos"));
                e.setGrado(rs.getString("Grado"));
                e.setSeccion(rs.getString("Seccion"));
                ve.add(e);
            }
            conn.close();
        }catch(SQLException ex){
            Logger.getLogger(LibrosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ve;
    }
    
    public int validarDni(String cod) {
        try {
            String sql = "SELECT COUNT(*) FROM estudiantes where dni = '" + cod + "'";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }
            conn.close();

        } catch (Exception e) {
        }
        return 0;

    }
    
        public int valPRE_ES(String cod) {

        try {
            String sql = "select count(*) from prestamos p join Estudiantes e on p.dni=e.dni where p.dni = '"+cod+"'";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            conn.close();
        } catch (Exception e) {
        }
        return 0;

    }
    
}
