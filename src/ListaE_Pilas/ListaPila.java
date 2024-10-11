package ListaE_Pilas;

public class ListaPila {
    private NodoPL inicioAlum;
    private int nElementosAlum;
    
    public ListaPila(){
        this.inicioAlum = null;
        this.nElementosAlum = 0;
    }

    public NodoPL getInicioAlum() {
        return inicioAlum;
    }

    public void setInicioAlum(NodoPL inicioAlum) {
        this.inicioAlum = inicioAlum;
    }

    public int getnElementosAlum() {
        return nElementosAlum;
    }

    public void setnElementosAlum(int nElementosAlum) {
        this.nElementosAlum = nElementosAlum;
    }
    
    //------------INSERTAR DATO----------------
    public void InsertarDato(Alumno dato){
        NodoPL datoNuevo = new NodoPL(dato);
        datoNuevo.setSiguienteAlumno(inicioAlum);
        inicioAlum = datoNuevo;
        nElementosAlum++;
    }
    //-------------ELIMINAR DATO-------------
    public void EliminarDato(){
        if (inicioAlum == null) {
            System.out.println("LA LISTA ESTA VACIA");
        } else {
            inicioAlum = inicioAlum.getSiguienteAlumno();
            nElementosAlum--;
            System.out.println("EL DATO HA SIDO ELIMINADO");
        }
    }

}
