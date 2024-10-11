package NodoCola;

public class Nodo_Cola {
    private Prestamos_LisE_Cola dato;
    private Nodo_Cola siguiente;
    
    public Nodo_Cola(Prestamos_LisE_Cola dato){
        this.dato=dato;
        this.siguiente=null;
    }

    public Prestamos_LisE_Cola getDato() {
        return dato;
    }

    public void setDato(Prestamos_LisE_Cola dato) {
        this.dato = dato;
    }

    public Nodo_Cola getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo_Cola siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
