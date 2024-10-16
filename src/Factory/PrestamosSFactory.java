/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory;

import MInterfaces.Servicio;
import Servicios.PrestamosS;

/**
 *
 * @author mathi
 */
public class PrestamosSFactory {
    public Servicio crearServicio() {
        return PrestamosS.getInstancia();  // singleton
    }
}
