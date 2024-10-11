package ModeloDAO;

import Confi.Conexion;
import MInterfaces.EditorialInterface;
import Modelo.Editorial;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EditorialDAO implements EditorialInterface {

    Conexion con = new Conexion();
    Connection conn;
    PreparedStatement ps;
    Editorial et;
    ResultSet rs;
    ArrayList<Editorial> ved = new ArrayList<>();

    @Override
    public ArrayList<Editorial> listarTodo() {
        try {
            String sql = "select * from Editorial";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                et = new Editorial();
                et.setCod_editorial(rs.getString("Cod_editorial"));
                et.setNom_editorial(rs.getString("Nom_editorial"));
                et.setTelefono(rs.getString("Telefono"));
                ved.add(et);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(EditorialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ved;
    }

    @Override
    public boolean insertar(Editorial t) {
        try {
            String sql = "insert into Editorial (cod_editorial, nom_editorial, telefono) values (?, ?, ?)";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, t.getCod_editorial());
            ps.setString(2, t.getNom_editorial());
            ps.setString(3, t.getTelefono());
            ps.executeUpdate();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(EditorialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean eliminar(String codigo) {
        try {
            String sql = "delete from editorial where cod_editorial = " + "'" + codigo + "'";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(EditorialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<Editorial> lisEdi() {
        conn = con.getConexion();
        List<Editorial> lista = new ArrayList();
        try {
            String sql = "select cod_editorial, nom_editorial from Editorial";
            CallableStatement st = conn.prepareCall(sql);
            ResultSet rst = st.executeQuery();
            while (rst.next()) {
                Editorial po = new Editorial();
                po.setCod_editorial(rst.getString(1));
                po.setNom_editorial(rst.getString(2));
                lista.add(po);
            }
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(EditorialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public ArrayList<Editorial> buscaredi(String c) {
        try {
            String sql = "SELECT * FROM Editorial WHERE nom_editorial LIKE '%" + c + "%'";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Editorial et = new Editorial();
                et = new Editorial();
                et.setCod_editorial(rs.getString("Cod_editorial"));
                et.setNom_editorial(rs.getString("Nom_editorial"));
                et.setTelefono(rs.getString("Telefono"));
                ved.add(et);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(LibrosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ved;
    }

    public int validarCoden(String cod) {

        try {

            String sql = "SELECT COUNT(*) FROM editorial where cod_editorial = '" + cod + "'";
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

    public int validarTele(String cod) {

        try {

            String sql = "SELECT COUNT(*) FROM editorial where telefono = '" + cod + "'";
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

    public int valLI_EDI(String cod) {

        try {
            String sql = "select count(*) from libros l join editorial e on l.cod_editorial=e.cod_editorial where l.cod_editorial = '" + cod + "'";
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
    public ArrayList<Editorial> buscar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
