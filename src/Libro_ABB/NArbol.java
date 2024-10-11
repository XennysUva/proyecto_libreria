/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Libro_ABB;

/**
 *
 * @author leslie
 */
public class NArbol {
    private Libro_ABB libro;
    private NArbol izq;
    private NArbol der;

    public NArbol(Libro_ABB libro) {
        this.libro = libro;
        this.izq = null;
        this.der = null;
    }

    public Libro_ABB getLibro() {
        return libro;
    }

    public void setLibro(Libro_ABB libro) {
        this.libro = libro;
    }

    public NArbol getIzq() {
        return izq;
    }

    public void setIzq(NArbol izq) {
        this.izq = izq;
    }

    public NArbol getDer() {
        return der;
    }

    public void setDer(NArbol der) {
        this.der = der;
    }
}

