/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import MInterfaces.EstudianteInterface;
import Modelo.Estudiantes;
import java.util.ArrayList;

/**
 *
 * @author leslie
 */
public class EstudianteS implements EstudianteInterface {
    
    private static ArrayList<Estudiantes> ve = new ArrayList<>();
    
    //singleton
    private static EstudianteS instancia;
    
    private EstudianteS(){}
    
    public static EstudianteS getInstancia(){
        if (instancia == null){
            instancia = new EstudianteS();
            
        }
        return instancia;
    }
    

    @Override
    public ArrayList<Estudiantes> listarTodo() {
        return ve;
    }

    @Override
    public boolean insertar(Estudiantes e) {
        return ve.add(e);
    }

    @Override
    public boolean eliminar(String codigo) {
        return ve.removeIf(e -> e.getDni().equals(codigo));
    }

    public ArrayList<Estudiantes> buscare(String c) {
        ArrayList<Estudiantes> resultados = new ArrayList<>();
        for (Estudiantes e : ve) {
            if ((e.getNombres() + " " + e.getApellidos()).toLowerCase().contains(c.toLowerCase())) {
                resultados.add(e);
            }
        }
        return resultados;
    }

    public int validarDni(String cod) {
        return (int) ve.stream().filter(e -> e.getDni().equals(cod)).count();
    }
}
