    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory;

import MInterfaces.Libro;
import Factory.LibroDigital;
import Factory.LibroFisico;

/**
 *
 * @author mathi
 */
public class LibroFactory {

    public static Libro crearLibro(String tipo, String cod_libro, String nombre, String autor, String stock) {
        System.out.println("factory en funcionamientooo " + tipo);
        if ("digital".equalsIgnoreCase(tipo)) {
            return new LibroDigital(cod_libro, nombre, autor, stock);
        } else if ("fisico".equalsIgnoreCase(tipo)) {
            return new LibroFisico(cod_libro, nombre, autor, stock);
        }
        return null; 
    }
}