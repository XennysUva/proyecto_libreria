/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prototype;

import java.util.ArrayList;


/**
 *
 * @author leslie
 */
public class PrestamosSP implements PrestamosInterface{
private ArrayList<PrestamosPrototype> pl = new ArrayList<>();

    // Constructor con inyección de dependencias
    private PrestamosSP(ArrayList<PrestamosPrototype> prestamos) {
        this.pl = prestamos;
    }
    
    //singleton
    private static PrestamosSP instancia; //instancia

    private PrestamosSP() {  //se vuelve privada para que no se pueda instanciar
    }
    public static PrestamosSP getInstancia() {
        if (instancia == null) {                    //metodo estatico
            instancia = new PrestamosSP();
        }
        return instancia;
    }

    @Override
    public ArrayList<PrestamosPrototype> buscarPre(String c) {
       ArrayList<PrestamosPrototype> resultados = new ArrayList<>();
        for (PrestamosPrototype p : pl) {
            if (p.getCod_prestamo().toLowerCase().contains(c.toLowerCase())) {
                resultados.add(p);
            }
        }
        return resultados;
    }

    @Override
    public int validarCP(String cod) {
       return (int) pl.stream().filter(p -> p.getCod_prestamo().equals(cod)).count(); 
    }

    @Override
    public int buscLetraCodPre() {
       int maxCod = 0;
        for (PrestamosPrototype p : pl) {
            String codStr = p.getCod_prestamo().substring(1);  // Quita la letra 'P' del código
            int codNum = Integer.parseInt(codStr);
            if (codNum > maxCod) {
                maxCod = codNum;
            }
        }
        return maxCod; 
    }

    @Override
    public String generarID() {
       int num = (int) (Math.random() * 900) + 100;
        return "P" + String.format("%03d", num); 
    }

    @Override
    public ArrayList<PrestamosPrototype> listarTodo() {
       return new ArrayList<>(pl); 
    }

    @Override
    public boolean insertar(PrestamosPrototype c) {
       return pl.add(c); 
    }

    @Override
    public boolean eliminar(String codigo) {
        return pl.removeIf(p -> p.getCod_prestamo().equals(codigo));  // Elimina el préstamo por código
    }    
}
