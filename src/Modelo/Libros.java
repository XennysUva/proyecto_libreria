package Modelo;

import MInterfaces.Prototype;

public class Libros implements Prototype<Libros> {
    private String cod_libro;
    private String nom_libro;
    private String stock;
    private String autor;
    private String cod_editorial;
    private String tipo;

    
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
     public String getTipo() {
        return tipo;
    }
     public void setTipo(String categoria) { 
        this.tipo = categoria;
    }
    

     @Override
    public Libros clone() {
        Libros cloned = new Libros();
        cloned.setCod_libro(this.cod_libro);
        cloned.setNom_libro(this.nom_libro);
        cloned.setStock(this.stock);
        cloned.setAutor(this.autor);
        cloned.setCod_editorial(this.cod_editorial);
        cloned.setTipo(this.tipo);
        return cloned;
    }
}
