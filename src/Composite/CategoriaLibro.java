/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Composite;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leslie
 */
public class CategoriaLibro implements LibroComponent {
  private String nombreCategoria;
  
    private List<LibroComponent> componentes = new ArrayList<>();

    public List<LibroComponent> getComponentes() {
        return componentes;
    }

    public void setComponentes(List<LibroComponent> componentes) {
        this.componentes = componentes;
    }

    public CategoriaLibro(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public void agregarComponente(LibroComponent componente) {
        componentes.add(componente);
    }

    public void removerComponente(LibroComponent componente) {
        componentes.remove(componente);
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Categoría: " + nombreCategoria);
        for (LibroComponent componente : componentes) {
            componente.mostrarDetalles();
        }
    }

    @Override
    public List<LibrosM> filtrarPorCategoria(String categoria) {
        List<LibrosM> resultado = new ArrayList<>();
        for (LibroComponent componente : componentes) {
            resultado.addAll(componente.filtrarPorCategoria(categoria));
        }
        return resultado;
    }
}
