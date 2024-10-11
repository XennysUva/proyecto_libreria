package NodoCola;

public class Lista_Cola {
    private Nodo_Cola inicio, fin;
    private int NElementos;
    
    public Lista_Cola(){
        this.inicio=null;
        this.fin=null;
        this.NElementos=0;
    }

    public Nodo_Cola getInicio() {
        return inicio;
    }

    public void setInicio(Nodo_Cola inicio) {
        this.inicio = inicio;
    }

    public Nodo_Cola getFin() {
        return fin;
    }

    public void setFin(Nodo_Cola fin) {
        this.fin = fin;
    }

    public int getNElementos() {
        return NElementos;
    }

    public void setNElementos(int NElementos) {
        this.NElementos = NElementos;
    }
    
    //insertar
    public void insertarCola(Prestamos_LisE_Cola dato){
        Nodo_Cola nuevo = new Nodo_Cola(dato);
        if(inicio == null){
            inicio = fin = nuevo;
        }else{
            fin.setSiguiente(nuevo);
            fin = fin.getSiguiente();
        }
        NElementos++;
    }
    
    //Quitar
    public void QuitardelaCola(){
        Prestamos_LisE_Cola dato = null;
        if(inicio != null){
            dato = inicio.getDato();
            inicio = inicio.getSiguiente();
            NElementos--;
        }
        System.out.println("Elemento eliminado --> "+dato.getCod_prestamo()+"\n");
    }
}
