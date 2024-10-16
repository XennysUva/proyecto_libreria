/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adapter;

import MInterfaces.Libro;
import Adapter.LibrosInterface;
import Factory.LibroDigital;
import Factory.LibroFisico;
import Modelo.Libros;
import java.util.ArrayList;

/**
 *
 * @author mathi
 */
public class LibroAdapter implements LibrosInterface {
    private Object libro; // libro fisico o digital

    public LibroAdapter(Object libro) {
        this.libro = libro;
    }

    @Override
    public void abrir() {
        if (libro instanceof LibroFisico) {
            ((LibroFisico) libro).abrir();
        } else if (libro instanceof LibroDigital) {
            ((LibroDigital) libro).abrir();
        }
    }

    @Override
    public void leer() {
        if (libro instanceof LibroFisico) {
            ((LibroFisico) libro).leer();
        } else if (libro instanceof LibroDigital) {
            ((LibroDigital) libro).leer();
        }
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

