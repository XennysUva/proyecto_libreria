package MInterfaces;

import Modelo.Prestamos;
import java.util.ArrayList;

public interface PrestamosInterface extends CRUDInterface<Prestamos>{
    ArrayList<Prestamos> buscarPre(String criterio);
    int validarCP(String cod);
    int buscLetraCodPre();
    String generarID();
}
