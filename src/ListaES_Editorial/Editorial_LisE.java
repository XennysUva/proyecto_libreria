package ListaES_Editorial;

public class Editorial_LisE {
    private String cod_editorial;
    private String nom_editorial;
    private String telefono;

    public Editorial_LisE(String cod_editorial, String nom_editorial, String telefono) {
        this.cod_editorial = cod_editorial;
        this.nom_editorial = nom_editorial;
        this.telefono = telefono;
    }
    public Editorial_LisE() {
    } 
    public String getCod_editorial() {
        return cod_editorial;
    }

    public void setCod_editorial(String cod_editorial) {
        this.cod_editorial = cod_editorial;
    }

    public String getNom_editorial() {
        return nom_editorial;
    }

    public void setNom_editorial(String nom_editorial) {
        this.nom_editorial = nom_editorial;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
