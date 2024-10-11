package ModeloDAO;

import Confi.Conexion;
import MInterfaces.PrestamosInterface;
import Modelo.Prestamos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrestamosDAO implements PrestamosInterface {

    Conexion con = new Conexion();
    Connection conn;
    PreparedStatement ps;
    Prestamos p;
    ResultSet rs;
    Statement st;
    ArrayList<Prestamos> pl = new ArrayList<>();

    @Override
    public ArrayList<Prestamos> listarTodo() {
        pl.clear();
        try {
            String sql = "select * from prestamos";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                p = new Prestamos();
                p.setCod_libro(rs.getString("Cod_libro"));
                p.setDni(rs.getString("Dni"));
                p.setCod_prestamo(rs.getString("Cod_prestamo"));
                p.setFec_pres(rs.getString("Fec_pres"));
                p.setFec_devo(rs.getString("Fec_devo"));
                pl.add(p);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(LibrosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pl;
    }

    @Override
    public boolean insertar(Prestamos c) {
        try {
            String sql = "insert into Prestamos (cod_libro, dni, cod_prestamo, fec_pres, fec_devo) values (?, ?, ?, ?, ?)";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, c.getCod_libro());
            ps.setString(2, c.getDni());
            ps.setString(3, c.getCod_prestamo());
            ps.setString(4, c.getFec_pres());
            ps.setString(5, c.getFec_devo());
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
            String sql = "delete from prestamos where cod_prestamo = " + "'" + codigo + "'";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(LibrosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<Prestamos> buscarPre(String c) {
        try {
            String sql = "SELECT * FROM Prestamos WHERE cod_prestamo LIKE '%" + c + "%'";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Prestamos l = new Prestamos();
                l.setCod_libro(rs.getString("Cod_libro"));
                l.setDni(rs.getString("Dni"));
                l.setCod_prestamo(rs.getString("Cod_prestamo"));
                l.setFec_pres(rs.getString("Fec_pres"));
                l.setFec_devo(rs.getString("Fec_devo"));
                pl.add(l);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(LibrosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pl;
    }

    public int validarCP(String cod) {

        try {
            String sql = "select count(*) from prestamos where cod_prestamo = '" + cod + "'";
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

    public int buscLetraCodPre() {

        try {

            String sql = "SELECT MAX(RIGHT(cod_prestamo,3)) from prestamos";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(LibrosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;

    }

    public String generarID() {

        String codigo = "";
        try {
            int num = (int) (Math.random() * 900) + 100;
            codigo = "P" + String.format("%03d", num);

        } catch (Exception e) {
            Logger.getLogger(LibrosDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return codigo;

    }
    

}
