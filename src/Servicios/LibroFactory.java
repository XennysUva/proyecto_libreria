/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import MInterfaces.Libro;
import Modelo.LibroDigital;
import Modelo.LibroFisico;

/**
 *
 * @author mathi
 */
public class LibroFactory {

    public static Libro crearLibro(String tipo, String nombre, String autor) {
        if ("digital".equalsIgnoreCase(tipo)) {
            return new LibroDigital(nombre, autor);
        } else if ("fisico".equalsIgnoreCase(tipo)) {
            return new LibroFisico(nombre, autor);
        }
        return null; 
    }
}