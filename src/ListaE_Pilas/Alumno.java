package ListaE_Pilas;

public class Alumno {
    private String dni;
    private String nombre;
    private String apellidos;
    private String grado;
    private String seccion;
    
    public Alumno(String dni,String nombre,String apellidos,String grado,String seccion){
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.grado = grado;
        this.seccion = seccion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }
    
}
