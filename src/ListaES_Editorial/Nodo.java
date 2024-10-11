package ListaES_Editorial;

public class Nodo {
    private Editorial_LisE editorial;
    private Nodo sig;

    public Nodo(Editorial_LisE editorial) {
        this.editorial = editorial;
        this.sig = null;
    }

    public Nodo(Editorial_LisE editorial, Nodo sig) {
        this.editorial = editorial;
        this.sig = sig;
    }

    public Editorial_LisE getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial_LisE editorial) {
        this.editorial = editorial;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }
}
