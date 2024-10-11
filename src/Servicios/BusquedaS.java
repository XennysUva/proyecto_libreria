/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import Modelo.Editorial;
import Modelo.Libros;
import java.util.ArrayList;

/**
 *
 * @author leslie
 */
public class BusquedaS {
    public ArrayList<Editorial> buscarEditorial(String nombre, ArrayList<Editorial> editoriales) {
        ArrayList<Editorial> resultados = new ArrayList<>();
        for (Editorial ed : editoriales) {
            if (ed.getNom_editorial().toLowerCase().contains(nombre.toLowerCase())) {
                resultados.add(ed);
            }
        }
        return resultados;
    }

    public ArrayList<Libros> buscarLibro(String nombre, ArrayList<Libros> libros) {
        ArrayList<Libros> resultados = new ArrayList<>();
        for (Libros l : libros) {
            if (l.getNom_libro().toLowerCase().contains(nombre.toLowerCase())) {
                resultados.add(l);
            }
        }
        return resultados;
    }
}
