/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import MInterfaces.Servicio;

/**
 *
 * @author mathi
 */
public class LibrosSFactory {

    public LibrosSFactory() {
    }
    public Servicio crearServicio() {
        return LibrosS.getInstancia();  //implenta singlee
    }
}
