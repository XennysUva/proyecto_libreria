package Abstractfactory;

public abstract class EditorialAF {
   private String cod_editorial;
    private String nom_editorial;
    private String telefono;

    public EditorialAF(String cod_editorial, String nom_editorial, String telefono) {
        this.cod_editorial = cod_editorial;
        this.nom_editorial = nom_editorial;
        this.telefono = telefono;
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
    
    // Método abstracto que define el tipo de editorial (física o digital)
    public abstract String getTipo();
}
