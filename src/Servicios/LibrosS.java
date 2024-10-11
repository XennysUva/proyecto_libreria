/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import MInterfaces.LibrosInterface;
import Modelo.Libros;
import java.util.ArrayList;
import MInterfaces.Servicio;

/**
 *
 * @author leslie
 */


public class LibrosS implements LibrosInterface, Servicio{

 
    private static final ArrayList<Libros> vl = new ArrayList<>(); //prrivado

    //singleton
    private static LibrosS instancia; //instancia unica de la clase
    private LibrosS() {}  //contructor para que no se creen mas instancias

    public static LibrosS getInstancia() {
        if (instancia == null) {
            instancia = new LibrosS();          //metodo de la instancia
        }
        return instancia;
    }
    
    ///implementacion del metodo de la interfas ServiviosFactory
    @Override
    public void mostrarInformacion() {
        System.out.println("Este es el servicio de libros.");
    }

    @Override
    public ArrayList<Libros> listarTodo() {
        return vl;
    }

    @Override
    public boolean insertar(Libros c) {
        return vl.add(c);
    }

    @Override
    public boolean eliminar(String codigo) {
        return vl.removeIf(l -> l.getCod_libro().equals(codigo));
    }

   public ArrayList<Libros> buscarnl(String c) {
        ArrayList<Libros> resultados = new ArrayList<>();
        for (Libros l : vl) {
            if (l.getNom_libro().toLowerCase().contains(c.toLowerCase())) {
                resultados.add(l);
            }
        }
        return resultados;
    }

     public int validarCol(String cod) {
        return (int) vl.stream().filter(l -> l.getCod_libro().equals(cod)).count();
    }

    // Método para obtener un libro por su código
    public Libros getLibro(String codigo) {
        return vl.stream()
                 .filter(l -> l.getCod_libro().equals(codigo))
                 .findFirst()
                 .orElse(null); // Retorna null si no se encuentra el libro
    }
    // Método para generar un nuevo código único
    public String generarID() {
         int numero = (int) (Math.random() * 1000);
         return String.format("%03d", numero);
    }
    
}
