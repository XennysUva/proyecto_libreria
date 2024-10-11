/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import MInterfaces.PrestamosInterface;
import Modelo.Prestamos;
import java.util.ArrayList;
import MInterfaces.Servicio;

/**
 *
 * @author leslie
 */

public class PrestamosS implements PrestamosInterface, Servicio{

    private ArrayList<Prestamos> pl = new ArrayList<>();

    // Constructor con inyección de dependencias
    private PrestamosS(ArrayList<Prestamos> prestamos) {
        this.pl = prestamos;
    }
    
    //singleton
    private static PrestamosS instancia; //instancia

    private PrestamosS() {  //se vuelve privada para que no se pueda instanciar
    }
    public static PrestamosS getInstancia() {
        if (instancia == null) {                    //metodo estatico
            instancia = new PrestamosS();
        }
        return instancia;
    }
    ///implementacion del metodo de la interfas ServiviosFactory
    @Override
    public void mostrarInformacion() {
        System.out.println("Este es el servicio de libros.");
    }

    @Override
    public ArrayList<Prestamos> listarTodo() {
        return new ArrayList<>(pl);  // Retorna una copia de la lista
    }

    @Override
    public boolean insertar(Prestamos c) {
        return pl.add(c);  // Inserta el préstamo en la lista
    }

    @Override
    public boolean eliminar(String codigo) {
        return pl.removeIf(p -> p.getCod_prestamo().equals(codigo));  // Elimina el préstamo por código
    }

    @Override
    public ArrayList<Prestamos> buscarPre(String c) {
        ArrayList<Prestamos> resultados = new ArrayList<>();
        for (Prestamos p : pl) {
            if (p.getCod_prestamo().toLowerCase().contains(c.toLowerCase())) {
                resultados.add(p);
            }
        }
        return resultados;
    }

    @Override
    public int validarCP(String cod) {
        return (int) pl.stream().filter(p -> p.getCod_prestamo().equals(cod)).count();  // Valida si existe un código
    }

    @Override
    public int buscLetraCodPre() {
        int maxCod = 0;
        for (Prestamos p : pl) {
            String codStr = p.getCod_prestamo().substring(1);  // Quita la letra 'P' del código
            int codNum = Integer.parseInt(codStr);
            if (codNum > maxCod) {
                maxCod = codNum;
            }
        }
        return maxCod;  // Retorna el mayor número de código encontrado
    }

    @Override
    public String generarID() {
        int num = (int) (Math.random() * 900) + 100;
        return "P" + String.format("%03d", num);  // Genera un código aleatorio como 'PXXX'
    }
}
