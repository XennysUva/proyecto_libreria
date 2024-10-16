/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Abstractfactory;

import Abstractfactory.EditorialAFI;
import Abstractfactory.EditorialFactoryAbs;
import Abstractfactory.EditorialAF;
import Servicios.BusquedaS;
import Servicios.EditorialSExtra;
import java.util.ArrayList;


/**
 *
 * @author leslie
 */
public class EditorialSAF implements EditorialAFI {

    private static ArrayList<EditorialAF> vedAF = new ArrayList<>();
    private EditorialSExtra validador = new EditorialSExtra();
    private BusquedaS buscador = new BusquedaS();
    
    // Singleton
    private static EditorialSAF instancia;   

    private EditorialSAF() {
    }
    
    public static EditorialSAF getInstancia() {
        if (instancia == null) {
            instancia = new EditorialSAF();
        }
        return instancia;
    }
    @Override
    public ArrayList<EditorialAF> listarTodo() {
return vedAF;
    }

    @Override
    public boolean insertar(EditorialAF c) {
 return vedAF.add(c);
    }

    @Override
    public boolean eliminar(String codigo) {
        return vedAF.removeIf(e -> e.getCod_editorial().equals(codigo));
    }

    @Override
    public ArrayList<EditorialAF> buscar(String criterio) {
        return buscador.buscarEditorialAF(criterio, vedAF);
    }
    
    public int validarCodigo(String cod) {
        return validador.validarCodE(cod, vedAF);
    }

    public int validarTelefono(String telefono) {
        return validador.validarTelef(telefono, vedAF);
    }
    // Método para insertar una editorial utilizando la fábrica abstracta
    public boolean insertarEditorial(EditorialFactoryAbs factory, String cod_editorial, String nom_editorial, String telefono) {
        EditorialAF editorial = factory.crearEditorial(cod_editorial, nom_editorial, telefono);
        return vedAF.add(editorial);
    }
}
