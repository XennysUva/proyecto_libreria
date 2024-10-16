package Prototype;

import MInterfaces.*;
import java.util.ArrayList;

public interface PrestamosInterface extends CRUDInterface<PrestamosPrototype>{
    ArrayList<PrestamosPrototype> buscarPre(String criterio);
    int validarCP(String cod);
    int buscLetraCodPre();
    String generarID();
}
