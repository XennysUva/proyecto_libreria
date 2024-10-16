/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Builder;

import Modelo.Libros;

/**
 *
 * @author leslie
 */
public interface LibroBuilderInterface {
    void reset();
    void buildCod_libro();
    void buildNom_libro();
    void buildStock();
    void buildAutor();
    void buildCod_editorial();
    Libros getResult();
}
