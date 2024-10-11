package Libro_ABB;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.HashMap;
import javax.swing.JPanel;

/**
 *
 * @author leslie
 */
public class ArbolExpresionGrafico extends JPanel {
    private ArbolBinario arbol;
    private HashMap posicionNodos = null;
    private HashMap subtreeSizes = null;
    private boolean dirty = true;
    private int parent2child = 20, child2child = 30;
    private Dimension empty = new Dimension(0,0);
    private FontMetrics fm = null;

    public ArbolExpresionGrafico(ArbolBinario arbol) {
        this.arbol = arbol;
        this.setBackground(Color.WHITE);
        posicionNodos = new HashMap();
        subtreeSizes = new HashMap();
        dirty = true;
        repaint();
    }

    private void calcularPosiciones() {
        posicionNodos.clear();
        subtreeSizes.clear();
        NArbol raiz = this.arbol.getRaiz();
        if (raiz != null) {
            calcularTamañoSubarbol(raiz);
            calcularPosicion(raiz, Integer.MAX_VALUE, Integer.MAX_VALUE, 0);
        }
    }

    private Dimension calcularTamañoSubarbol(NArbol n) {
        if (n == null)
            return new Dimension(0,0);

        Dimension ld = calcularTamañoSubarbol(n.getIzq());
        Dimension rd = calcularTamañoSubarbol(n.getDer());

        int h = fm.getHeight() + parent2child + Math.max(ld.height, rd.height);
        int w = ld.width + child2child + rd.width;

        Dimension d = new Dimension(w, h);
        subtreeSizes.put(n, d);

        return d;
    }

    private void calcularPosicion(NArbol n, int izq, int der, int top) {
        if (n == null)
            return;

        Dimension ld = (Dimension) subtreeSizes.get(n.getIzq());
        if (ld == null)
            ld = empty;

        Dimension rd = (Dimension) subtreeSizes.get(n.getDer());
        if (rd == null)
            rd = empty;

        int center = 0;

        if (der != Integer.MAX_VALUE)
            center = der - rd.width - child2child/2;
        else if (izq != Integer.MAX_VALUE)
            center = izq + ld.width + child2child/2;
        int width = fm.stringWidth(n.getLibro()+"");

        posicionNodos.put(n, new Rectangle(center - width/2 - 3, top, width + 6, fm.getHeight()));

        calcularPosicion(n.getIzq(), Integer.MAX_VALUE, center - child2child/2, top + fm.getHeight() + parent2child);
        calcularPosicion(n.getDer(), center + child2child/2, Integer.MAX_VALUE, top + fm.getHeight() + parent2child);
    }

    private void dibujarArbol(Graphics2D g, NArbol n, int puntox, int puntoy, int yoffs, boolean esDerecho) {
        if (n == null)
            return;

        Rectangle r = (Rectangle) posicionNodos.get(n);

        // Cambiar el color según la dirección
        if (puntox != Integer.MAX_VALUE) {
            if (esDerecho) {
                g.setColor(Color.BLUE); // Derecha
            } else {
                g.setColor(Color.GREEN); // Izquierda
            }
        } else {
            g.setColor(Color.BLACK); // Raíz
        }

        g.draw(r);
        g.drawString(n.getLibro()+"", r.x + 3, r.y + yoffs);

        if (puntox != Integer.MAX_VALUE)
            g.drawLine(puntox, puntoy, (int)(r.x + r.width/2), r.y);

        dibujarArbol(g, n.getIzq(), (int)(r.x + r.width/2), r.y + r.height, yoffs, false);
        dibujarArbol(g, n.getDer(), (int)(r.x + r.width/2), r.y + r.height, yoffs, true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        fm = g.getFontMetrics();

        if (dirty) {
            calcularPosiciones();
            dirty = false;
        }

        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(getWidth() / 2, parent2child);
        dibujarArbol(g2d, this.arbol.getRaiz(), Integer.MAX_VALUE, Integer.MAX_VALUE, fm.getLeading() + fm.getAscent(), false);
        fm = null;
    }
}


