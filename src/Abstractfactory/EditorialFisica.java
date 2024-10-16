/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Abstractfactory;

import Abstractfactory.EditorialAF;

/**
 *
 * @author leslie
 */
public class EditorialFisica extends EditorialAF {
    public EditorialFisica(String cod_editorial, String nom_editorial, String telefono) {
        super(cod_editorial, nom_editorial, telefono);
    }

    @Override
    public String getTipo() {
        return "Física";
    }
}
