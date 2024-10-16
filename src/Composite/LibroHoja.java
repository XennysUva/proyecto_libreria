/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Composite;
import Adapter.LibrosInterface;
import Modelo.Libros;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leslie
 */


public class LibroHoja implements LibroComponent {
 private LibrosM libro;

    public LibroHoja(LibrosM libro) {
        this.libro = libro;
    }

    public LibrosM getLibro() {
        return libro;
    }

    public void setLibro(LibrosM libro) {
        this.libro = libro;
    }
    
    

    @Override
    public void mostrarDetalles() {
        System.out.println("Libro: " + libro.getNom_libro() + " | Autor: " + libro.getAutor());
    }

    @Override
    public List<LibrosM> filtrarPorCategoria(String categoria) {
        List<LibrosM> resultado = new ArrayList<>();
        if (libro.getCategoria().equalsIgnoreCase(categoria)) {
            resultado.add(libro);
        }
        return resultado;
    }
}
