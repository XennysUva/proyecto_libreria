/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory;

import MInterfaces.Libro;
import Adapter.LibrosInterface;
import Modelo.Libros;
import java.util.ArrayList;

/**
 *
 * @author mathi
 */
public class LibroDigital implements Libro, LibrosInterface{
   private String cod_libro; 
   private String nombre;   
   private String autor;     
   private String stock;     
   
    public LibroDigital(String cod_libro, String nombre, String autor, String stock) {
        this.cod_libro = cod_libro;
        this.nombre = nombre;
        this.autor = autor;
        this.stock = stock;
    }
    public String getCod_libro() {
        return cod_libro;
    }

    public String getNom_libro() {
        return nombre;
    }

    public String getAutor() {
        return autor;
    }

    public String getStock() {
        return stock;
    }


    @Override
    public void mostrarInformacion() {
        System.out.println("Libro Digital: " + nombre + " por " + autor);
    }
    // metodos añadidos por el patron adapter para unificar
    @Override
    public void abrir() {
        System.out.println("Abriendo el libro digital: " + nombre);
    }

    @Override
    public void leer() {
        System.out.println("Leyendo el libro digital: " + nombre + " por " + autor);
    }

    @Override
    public ArrayList<Libros> listarTodo() {
       
        return null;
       
    }

    @Override
    public boolean insertar(Libros c) {
        
        return false;
        
    }

    @Override
    public boolean eliminar(String codigo) {
        
        return false;
        
}

    @Override
    public boolean insertar(Libro nuevoLibroDigital) {
     
        return false;
     
    }
    }
    
