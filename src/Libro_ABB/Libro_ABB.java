package Libro_ABB;

public class Libro_ABB {
    private String cod_libro;
    private String nom_libro;
    private String stock;
    private String autor;
    private String cod_editorial;

    public Libro_ABB(String cod_libro, String nom_libro, String stock, String autor, String cod_editorial) {
        this.cod_libro = cod_libro;
        this.nom_libro = nom_libro;
        this.stock = stock;
        this.autor = autor;
        this.cod_editorial = cod_editorial;
    }

    @Override
    public String toString() {
        return  cod_libro;
    }
    

    public String getCod_libro() {
        return cod_libro;
    }

    public void setCod_libro(String cod_libro) {
        this.cod_libro = cod_libro;
    }

    public String getNom_libro() {
        return nom_libro;
    }

    public void setNom_libro(String nom_libro) {
        this.nom_libro = nom_libro;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCod_editorial() {
        return cod_editorial;
    }

    public void setCod_editorial(String nom_editorial) {
        this.cod_editorial = nom_editorial;
    }
    public int compareTo(Libro_ABB otroLibro) {
        // Ignorar el primer carácter 'L' al comparar
        String thisCod = this.cod_libro.substring(1); // Ignora el primer carácter 'L'
        String otroCod = otroLibro.getCod_libro().substring(1); // Ignora el primer carácter 'L'
        return thisCod.compareTo(otroCod);
    }
}
