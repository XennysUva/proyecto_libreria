
package Servicios;

import MInterfaces.EditorialInterface;
import Modelo.Editorial;
import java.util.ArrayList;

public class EditorialS  implements EditorialInterface {
    
    
         

    private static ArrayList<Editorial> ved = new ArrayList<>();
    private EditorialSExtra validador = new EditorialSExtra();
    private BusquedaS buscador = new BusquedaS();
    private EditorialS() {
    }
    
    //Singleton
    private static EditorialS instancia;   
    
     public static EditorialS getInstancia() {
        if (instancia == null) {
            instancia = new EditorialS();
        }
        return instancia;
    }
     
    @Override
    public ArrayList<Editorial> listarTodo() {
        return ved;
    }

    @Override
    public boolean insertar(Editorial t) {
        return ved.add(t);
    }

    @Override
    public boolean eliminar(String codigo) {
        return ved.removeIf(e -> e.getCod_editorial().equals(codigo));
    }

    @Override
    public ArrayList<Editorial> buscar(String criterio) {
        return buscador.buscarEditorial(criterio, ved);
    }

    public int validarCodigo(String cod) {
        return validador.validarCoden(cod, ved);
    }

    public int validarTelefono(String telefono) {
        return validador.validarTelefono(telefono, ved);
    }
    
}