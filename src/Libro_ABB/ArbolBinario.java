package Libro_ABB;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class ArbolBinario {
    private NArbol raiz;
    public String result;

    public String getResult() {
        return result;
    }
    
    
    public NArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NArbol raiz) {
        this.raiz = raiz;
    }
    
    
    public ArbolBinario(){
        this.raiz = null;
    }
    
   public void insertarNodoalArbol(Libro_ABB libro){
        NArbol nuevo = new NArbol(libro);
        if (this.raiz == null) { 
            raiz = nuevo;
        } else { 
            NArbol tem = raiz;
            NArbol padre;
            while (true) {                
                padre = tem;

                if (libro.getCod_libro().compareTo(tem.getLibro().getCod_libro()) < 0) {
                    tem = tem.getIzq();
                    if (tem == null) { 
                        padre.setIzq(nuevo);
                        return;
                    }
                } else {
                    tem = tem.getDer();
                    if (tem == null) {
                        padre.setDer(nuevo);
                        return;
                    }
                }
            }
        }
    }
    

 public void inOrden(NArbol r) {
        if (r == null) {
            return;
        } else {
            inOrden(r.getIzq());
            result += r.getLibro().getCod_libro() + "\n";
            inOrden(r.getDer());
        }
    }

    public void preOrden(NArbol r) {
        if (r == null) {
            return;
        } else {
            result += r.getLibro().getCod_libro() + "\n";
            preOrden(r.getIzq());
            preOrden(r.getDer());
        }
    }

    public void PostOrden(NArbol r) {
        if (r == null) {
            return;
        } else {
            PostOrden(r.getIzq());
            PostOrden(r.getDer());
            result += r.getLibro().getCod_libro() + "\n";
        }
    }
    //Buscar elemento

     public NArbol buscarElemento(Libro_ABB libro) {
        NArbol temp = raiz;
        boolean encontrado = false;
        while (!encontrado && temp != null) {
            if (libro.getCod_libro().equals(temp.getLibro().getCod_libro())) {
                return temp;
            } else if (libro.getCod_libro().compareTo(temp.getLibro().getCod_libro()) < 0) {
                temp = temp.getIzq();
            } else {
                temp = temp.getDer();
            }
        }
        return null;
    }
    //Eliminar elemento 
    //1.Metodo para encontrar el minimo valor
    private NArbol valorMin(NArbol raiz) {
        NArbol actual = raiz;
        while (actual.getIzq() != null) {
            actual = actual.getIzq();
        }
        return actual;
    }
    //metodo para encontrar el maximo valor
    private NArbol valorMax(NArbol raiz) {
        NArbol actual = raiz;
        while (actual.getDer() != null) {
            actual = actual.getDer();
        }
        return actual;
    }
    //2.Metodo para eliminar elemento
     public NArbol eliminarElemento(NArbol raiz, Libro_ABB libro) {
        if (raiz == null) {
            return null;
        }

       if (libro.getCod_libro().compareTo(raiz.getLibro().getCod_libro()) < 0) {
            raiz.setIzq(eliminarElemento(raiz.getIzq(), libro));
        } else if (libro.getCod_libro().compareTo(raiz.getLibro().getCod_libro()) > 0) {
            raiz.setDer(eliminarElemento(raiz.getDer(), libro));
        } else {
            if (raiz.getIzq() == null) {
                return raiz.getDer();
            } else if (raiz.getDer() == null) {
                return raiz.getIzq();
            }

            NArbol temp = valorMin(raiz.getDer());
            raiz.setLibro(temp.getLibro());
            raiz.setDer(eliminarElemento(raiz.getDer(), temp.getLibro()));
        }

        return raiz;
    }

    public NArbol eliminarElemento2(NArbol raiz, Libro_ABB libro) {
        if (raiz == null) {
            return raiz;
        }

       if (libro.getCod_libro().compareTo(raiz.getLibro().getCod_libro()) < 0) {
            raiz.setIzq(eliminarElemento2(raiz.getIzq(), libro));
        } else if (libro.getCod_libro().compareTo(raiz.getLibro().getCod_libro()) > 0) {
            raiz.setDer(eliminarElemento2(raiz.getDer(), libro));
        } else {
            // Nodo encontrado
            if (raiz.getIzq() == null) {
                return raiz.getDer();
            } else if (raiz.getDer() == null) {
                return raiz.getIzq();
            }

            NArbol temp = valorMax(raiz.getIzq());
            raiz.setLibro(temp.getLibro());
            raiz.setIzq(eliminarElemento2(raiz.getIzq(), temp.getLibro()));
        }

        return raiz;
    }
    
    public void eliminar(Libro_ABB libro) {
        raiz = eliminarElemento(raiz, libro);
    }
    public void eliminar2(Libro_ABB libro) {
        raiz = eliminarElemento2(raiz, libro);
    }
    
    
    //dibujar arbol
    public JPanel getdibujo() {
        return new ArbolExpresionGrafico(this);
    }
}
