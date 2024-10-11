package ListaE_Pilas;

public class NodoPL {
    private Alumno dato;
    private NodoPL siguienteAlumno;
    
    public NodoPL(Alumno dato){
        this.dato = dato;
        this.siguienteAlumno = null;
    }

    public Alumno getDato() {
        return dato;
    }

    public void setDato(Alumno dato) {
        this.dato = dato;
    }

    public NodoPL getSiguienteAlumno() {
        return siguienteAlumno;
    }

    public void setSiguienteAlumno(NodoPL siguienteAlumno) {
        this.siguienteAlumno = siguienteAlumno;
    }
    
}
