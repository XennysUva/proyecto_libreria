/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import Abstractfactory.EditorialAF;
import Modelo.Editorial;
import java.util.ArrayList;

/**
 *
 * @author leslie
 */
public class EditorialSExtra {
    
     public int validarCoden(String cod, ArrayList<Editorial> editoriales) {
        return (int) editoriales.stream().filter(e -> e.getCod_editorial().equals(cod)).count();
    }

    public int validarTelefono(String telefono, ArrayList<Editorial> editoriales) {
        return (int) editoriales.stream().filter(e -> e.getTelefono().equals(telefono)).count();
    }
    
     public int validarCodE(String cod, ArrayList<EditorialAF> editoriales) {
        return (int) editoriales.stream().filter(e -> e.getCod_editorial().equals(cod)).count();
    }

    public int validarTelef(String telefono, ArrayList<EditorialAF> editoriales) {
        return (int) editoriales.stream().filter(e -> e.getTelefono().equals(telefono)).count();
    }
}
