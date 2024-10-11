package Libro_ABB;

import java.util.ArrayList;
import javax.swing.JPanel;

public class ImplementacionABB {
    
    ArbolBinario arbol = new ArbolBinario();
    
    public ImplementacionABB(){}
    
    public boolean insertar(Libro_ABB libro) {
        arbol.insertarNodoalArbol(libro);
        return true;
    }

    public String borrar(String cod_libro) {
        // Crear un libro temporal con el código ingresado
        Libro_ABB libroBuscado = new Libro_ABB(cod_libro, "", "", "", "");

        // Buscar el libro en el árbol y eliminarlo
        NArbol resultado = arbol.eliminarElemento(arbol.getRaiz(), libroBuscado);
        
        if (resultado == null) {
            return "No existe el libro con código " + cod_libro + " en el árbol.";
        }
        
        return "Borrado el libro con código: " + cod_libro;
    }
    public String borrar2(String cod_libro) {
        // Crear un libro temporal con el código ingresado
        Libro_ABB libroBuscado = new Libro_ABB(cod_libro, "", "", "", "");

        // Buscar el libro en el árbol y eliminarlo
        NArbol resultado = arbol.eliminarElemento2(arbol.getRaiz(), libroBuscado);
        
        if (resultado == null) {
            return "No existe el libro con código " + cod_libro + " en el árbol.";
        }
        
        return "Borrado el libro con código: " + cod_libro;
    }

    public String preOrden() {
        arbol.result = "Recorrido PreOrden - - - - - - -\n";
        arbol.preOrden(arbol.getRaiz());
        return arbol.getResult();
    }

    public String inOrden() {
        arbol.result = "Recorrido InOrden - - - - - - -\n";
        arbol.inOrden(arbol.getRaiz());
        return arbol.getResult();
    }

    public String PostOrden() {
        arbol.result = "Recorrido PosOrden - - - - - - -\n";
        arbol.PostOrden(arbol.getRaiz());
        return arbol.getResult();
    }


    public String buscarElemento(String cod_libro) {
        Libro_ABB libroBuscado = new Libro_ABB(cod_libro, "", "", "", "");
        NArbol resultado = arbol.buscarElemento(libroBuscado);
        if (resultado != null) {
            return "El libro con código " + cod_libro + " se encuentra en el árbol.";
        } else {
            return "El libro con código " + cod_libro + " no se encuentra en el árbol.";
        }
    }
    
    public JPanel getDibujo() {
        return this.arbol.getdibujo();
    }    
}
