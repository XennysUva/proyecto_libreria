/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Abstractfactory;

import Abstractfactory.EditorialAF;
import Abstractfactory.EditorialFactoryAbs;

/**
 *
 * @author leslie
 */
public class EditorialDigitalAF implements EditorialFactoryAbs{

    @Override
    public EditorialAF crearEditorial(String cod_editorial, String nom_editorial, String telefono) {
       return new EditorialDigital(cod_editorial, nom_editorial, telefono);
    }
    
}
