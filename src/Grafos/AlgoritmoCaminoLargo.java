/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafos;

import static Vista.UbicacionGrafos.jPanel3;
import java.awt.Color;

/**
 *
 * @author leslie
 */
public class AlgoritmoCaminoLargo {
   private final DatosGraficos arboles;
    private int subTope;
    private Nodo Nodoauxiliar = null;
    private double auxiliarAumulado; // es un acumulado auxiliar
    private double subtotalAcomulado;
    private final Nodo nodo[];
    private final int tope;
    private int Origen;
    private final int nodoFinal;

    public AlgoritmoCaminoLargo(DatosGraficos arboles, int tope, int permanente, int nodoFin) {
        this.arboles = arboles;
        this.tope = tope;
        this.nodo = new Nodo[tope];
        this.Origen = permanente;
        this.nodoFinal = nodoFin;
    }

    public double getAcumulado() {
        return nodo[nodoFinal].getAcumulado();
    }

    public int getNombre() {
        return nodo[nodoFinal].getNombre();
    }

    public void caminoLargo() {
        for (int i = 0; i < tope; i++) { 
            nodo[i] = new Nodo();
        }
        
        nodo[Origen].setVisitado(true);
        nodo[Origen].setNombre(Origen);

        do {
            subtotalAcomulado = 0;
            auxiliarAumulado = -2000000000; // inicializamos con un valor muy pequeño
            nodo[Origen].setEtiqueta(true);
            for (int j = 0; j < tope; j++) {
                if (arboles.getmAdyacencia(j, Origen) == 1) {
                    subtotalAcomulado = nodo[Origen].getAcumulado() + arboles.getmCoeficiente(j, Origen);
                    
                    if (subtotalAcomulado >= nodo[j].getAcumulado() && nodo[j].isVisitado() == true && nodo[j].isEtiqueta() == false) {
                        nodo[j].setAcumulado(subtotalAcomulado);
                        nodo[j].setVisitado(true);
                        nodo[j].setNombre(j);
                        nodo[j].setPredecesor(nodo[Origen]);
                    } else if (nodo[j].isVisitado() == false) {
                        nodo[j].setAcumulado(subtotalAcomulado);
                        nodo[j].setVisitado(true);
                        nodo[j].setNombre(j);
                        nodo[j].setPredecesor(nodo[Origen]);
                    }
                }
            }
            
            //Encontrando Camino mas largo
            for (int i = 0; i < tope; i++) { 
                if (nodo[i].isVisitado() == true && nodo[i].isEtiqueta() == false) {
                    if (nodo[i].getAcumulado() >= auxiliarAumulado) {
                        Origen = nodo[i].getNombre();
                        auxiliarAumulado = nodo[i].getAcumulado();
                    }
                }
            }
            subTope++;
        } while (subTope < tope + 1);

        Nodoauxiliar = nodo[nodoFinal];
        
        //Pintando caminos recorridos
        while (Nodoauxiliar.getPredecesor()!= null) {
            PintanrDibujos.pinta_Camino(jPanel3.getGraphics(), 
                    arboles.getCordeX(Nodoauxiliar.getNombre()),
                    arboles.getCordeY(Nodoauxiliar.getNombre()),
                    arboles.getCordeX(Nodoauxiliar.getPredecesor().getNombre()), 
                    arboles.getCordeY(Nodoauxiliar.getPredecesor().getNombre()), Color.RED);
            
            PintanrDibujos.seleccionNodo(jPanel3.getGraphics(), 
                    arboles.getCordeX(Nodoauxiliar.getNombre()), 
                    arboles.getCordeY(Nodoauxiliar.getNombre()), null, Color.RED);
            Nodoauxiliar = Nodoauxiliar.getPredecesor();
        }//fin de while Recorriendo caminos
        
        PintanrDibujos.seleccionNodo(jPanel3.getGraphics(), 
                arboles.getCordeX(nodoFinal), 
                arboles.getCordeY(nodoFinal), null, Color.RED);//Pintando Nodo del destino
    }
}
