/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Builder;

/**
 *
 * @author leslie
 */
public class Director {
    private LibroBuilder builder;
    
    public Director (LibroBuilder builder) {
        this.builder = builder;
    }
    
    public void cambiarLibro( LibroBuilder builder){
        this.builder = builder;
    }
    
    public void libroBasico(LibroBuilder builder){
        builder.reset();
        builder.buildCod_libro();
        builder.buildNom_libro();
        builder.buildStock();
        builder.buildAutor();
        builder.buildCod_editorial();
    }
    public void Libropersonalizado (String nombre, String autor, String stock, String editorial){
        builder.reset();
        builder.buildCod_libro();
        builder.getResult().setNom_libro(nombre);
        builder.getResult().setAutor(autor);
        builder.getResult().setStock(stock);
        builder.getResult().setCod_editorial(editorial);
    }
}
