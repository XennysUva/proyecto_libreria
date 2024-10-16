package ModeloDAO;

import Confi.Conexion;
import MInterfaces.Libro;
import Adapter.LibrosInterface;
import Modelo.Libros;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LibrosDAO implements LibrosInterface {

    Conexion con = new Conexion();
    Connection conn;
    PreparedStatement ps;
    Libros l;
    ResultSet rs;
    Statement st;
    ArrayList<Libros> vl = new ArrayList<>();

    @Override
    public ArrayList<Libros> listarTodo() {
        try {
            String sql = "select * from Libros";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                l = new Libros();
                l.setCod_libro(rs.getString("cod_libro"));
                l.setNom_libro(rs.getString("nom_libro"));
                l.setStock(rs.getString("stock"));
                l.setAutor(rs.getString("autor"));
                l.setCod_editorial(rs.getString("Cod_editorial"));
                vl.add(l);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(LibrosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vl;
    }

    @Override
    public boolean insertar(Libros c) {
        try {
            String sql = "insert into Libros (cod_libro, nom_libro, stock, autor, cod_editorial) values (?, ?, ?, ?, ?)";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, c.getCod_libro());
            ps.setString(2, c.getNom_libro());
            ps.setString(3, c.getStock());
            ps.setString(4, c.getAutor());
            ps.setString(5, c.getCod_editorial());
            ps.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(LibrosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean eliminar(String codigo) {
        try {
            String sql = "delete from Libros where cod_libro = " + "'" + codigo + "'";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(LibrosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<Libros> buscarnl(String c) {
        try {
            String sql = "SELECT * FROM libros WHERE nom_libro LIKE '%" + c + "%'";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Libros l = new Libros();
                l.setCod_libro(rs.getString("Cod_libro"));
                l.setNom_libro(rs.getString("Nom_libro"));
                l.setStock(rs.getString("Stock"));
                l.setAutor(rs.getString("Autor"));
                l.setCod_editorial(rs.getString("Cod_editorial"));
                vl.add(l);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(LibrosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vl;
    }

    public ArrayList<Libros> buscarna(String c) {
        try {
            String sql = "SELECT * FROM libros WHERE autor LIKE '%" + c + "%'";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Libros l = new Libros();
                l.setCod_libro(rs.getString("Cod_libro"));
                l.setNom_libro(rs.getString("Nom_libro"));
                l.setStock(rs.getString("Stock"));
                l.setAutor(rs.getString("Autor"));
                l.setCod_editorial(rs.getString("Cod_editorial"));
                vl.add(l);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(LibrosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vl;
    }

    public int validarCol(String cod) {

        try {
            String sql = "SELECT COUNT(*) FROM libros where cod_libro = '" + cod + "'";
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

    public int valPRE_libr(String cod) {

        try {
            String sql = "select count(*) from prestamos p join libros l on p.cod_libro=l.cod_libro where p.cod_libro = '" + cod + "'";
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

    @Override
    public void abrir() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void leer() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insertar(Libro nuevoLibroDigital) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
