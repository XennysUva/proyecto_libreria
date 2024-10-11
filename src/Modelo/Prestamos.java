package Modelo;

public class Prestamos {
    private String cod_libro;
    private String dni;
    private String cod_prestamo;
    private String fec_pres;
    private String fec_devo;

    public String getCod_libro() {
        return cod_libro;
    }

    public void setCod_libro(String cod_libro) {
        this.cod_libro = cod_libro;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCod_prestamo() {
        return cod_prestamo;
    }

    public void setCod_prestamo(String cod_prestamo) {
        this.cod_prestamo = cod_prestamo;
    }

    public String getFec_pres() {
        return fec_pres;
    }

    public void setFec_pres(String fec_pres) {
        this.fec_pres = fec_pres;
    }

    public String getFec_devo() {
        return fec_devo;
    }

    public void setFec_devo(String fec_devo) {
        this.fec_devo = fec_devo;
    }
}
