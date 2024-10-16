
package Adapter;

import MInterfaces.CRUDInterface;
import MInterfaces.Libro;
import Modelo.Libros;

public interface LibrosInterface extends CRUDInterface<Libros>{
    void abrir();
    void leer();

    public boolean insertar(Libro nuevoLibroDigital);
}


