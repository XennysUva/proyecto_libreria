package ListaES_Editorial;

import ListaES_Editorial.Editorial_LisE;
import javax.swing.table.DefaultTableModel;

public class ListaEnlazada {

    private Nodo inicio, fin, x;

    public ListaEnlazada() {
        this.inicio = null;
        this.fin = null;
    }

    public Nodo getInicio() {
        return inicio;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    public Nodo getFin() {
        return fin;
    }

    public void setFin(Nodo fin) {
        this.fin = fin;
    }

    public Nodo getX() {
        return x;
    }

    public void setX(Nodo x) {
        this.x = x;
    }

    //Insertar al incio
    public void InsertarIni(Editorial_LisE editorial) {
        inicio = new Nodo(editorial, inicio);
        if (fin == null) {
            fin = inicio;
        }
    }

    //Insertar al final
    public void InsertarFin(Editorial_LisE editorial) {
        if (inicio == null) {
            inicio = fin = new Nodo(editorial);
        } else {
            fin.setSig(new Nodo(editorial));
            fin = fin.getSig();
        }
    }

    //Insertar al medio
    public void InsertarMed(Editorial_LisE editorial) {

        if (inicio == null) {
            InsertarIni(editorial);
            return;
        }
        Nodo nuevo = new Nodo(editorial);
        Nodo actual = inicio;
        Nodo siguiente = inicio.getSig();

        while (siguiente != null && siguiente.getSig() != null) {
            actual = siguiente;
            siguiente = siguiente.getSig().getSig();
        }

        nuevo.setSig(actual.getSig());
        actual.setSig(nuevo);
    }

    // Método para eliminar un nodo del inicio de la lista
    public void eliminarIni() {
        if (inicio == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        Nodo temp = inicio;
        Editorial_LisE edato = temp.getEditorial();

        if (inicio == fin) {
            inicio = null;
            fin = null;
        } else {
            inicio = temp.getSig();
        }
        System.out.println(edato.getCod_editorial() + " Elemento eliminado del inicio."); // Imprimir el código de la editorial eliminada
    }

    // Método para eliminar un nodo del final de la lista
    public void eliminarFin() {
        if (inicio == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        Nodo temp = fin;
        Editorial_LisE edato = temp.getEditorial();

        if (inicio == fin) {
            inicio = null;
            fin = null;
        } else {
            Nodo current = inicio;
            while (current.getSig() != fin) {
                current = current.getSig();
            }
            fin = current;
            fin.setSig(null);
        }
        System.out.println(edato + " Elemento eliminado del final.");
    }

    // Método para eliminar un nodo del medio de la lista
    public void eliminarMed(String cod_editorial) {
        if (inicio != null) {
            if (inicio == fin && inicio.getEditorial().getCod_editorial().equals(cod_editorial)) {
                inicio = null;
                fin = null;
            } else {
                if (inicio.getEditorial().getCod_editorial().equals(cod_editorial)) {
                    inicio = inicio.getSig();
                } else {
                    Nodo anterior = inicio;
                    Nodo temp = inicio.getSig();
                    while (temp != null && !temp.getEditorial().getCod_editorial().equals(cod_editorial)) {
                        anterior = anterior.getSig();
                        temp = temp.getSig();
                    }
                    if (temp != null) {
                        anterior.setSig(temp.getSig());
                        if (temp == fin) {
                            fin = anterior;
                        }
                    }
                }
            }
        }
    }
    //Metodo para mostrar la lista ordenada en la tabla

    public void mostrar(DefaultTableModel modelo2) {
        if (inicio == null) {
            System.out.println("Lista Vacía ");
        } else {
            // Limpiar el modelo de la tabla antes de agregar los datos
            modelo2.setRowCount(0);

            Nodo elemento = inicio;
            while (elemento != null) {
                Editorial_LisE editorial = elemento.getEditorial();
                Object[] data = {
                    editorial.getCod_editorial(),
                    editorial.getNom_editorial(),
                    editorial.getTelefono()
                };
                modelo2.addRow(data);
                elemento = elemento.getSig();
            }
        }
    }
}
