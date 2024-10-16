/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Abstractfactory;

import Modelo.Editorial;
import Abstractfactory.EditorialAF;

/**
 *
 * @author leslie
 */
public interface EditorialFactoryAbs {
    EditorialAF crearEditorial(String cod_editorial, String nom_editorial, String telefono);
}
