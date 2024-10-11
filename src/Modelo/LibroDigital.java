/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import MInterfaces.Libro;

/**
 *
 * @author mathi
 */
public class LibroDigital implements Libro {
    private String nombre;
    private String autor;

    public LibroDigital(String nombre, String autor) {
        this.nombre = nombre;
        this.autor = autor;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Libro Digital: " + nombre + " por " + autor);
    }
}