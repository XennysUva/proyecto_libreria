/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Builder;

import Modelo.Libros;

/**
 *
 * @author leslie
 */
public class LibroBuilder implements LibroBuilderInterface{
    
//CONCRETE
    private Libros libro;
    
    public LibroBuilder(){
        this.reset();
    }

    @Override
    public void reset() {
        this.libro = new Libros();
    }

    @Override
    public void buildCod_libro() {
       this.libro.setCod_libro("L" + (int)(Math.random() * 1000)); // Código aleatorio
    }

    @Override
    public void buildNom_libro() {
       this.libro.setNom_libro("nuevo libro");
    }

    @Override
    public void buildStock() {
        this.libro.setStock("10");
    }

    @Override
    public void buildCod_editorial() {
        this.libro.setCod_editorial("E001");
    }

    @Override
    public Libros getResult() {
        return this.libro;
    }

    @Override
    public void buildAutor() {
        this.libro.setAutor("Autor desconocido");    
    }
}
