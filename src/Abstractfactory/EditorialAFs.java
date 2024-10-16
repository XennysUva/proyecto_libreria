/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Abstractfactory;

/**
 *
 * @author leslie
 */
public class EditorialAFs  extends EditorialAF {
    private String cod_editorial;
    private String nom_editorial;
    private String telefono;

    public String getCod_editorial() { 
        return cod_editorial;
    }

    public void setCod_editorial(String cod_editorial) {
        this.cod_editorial = cod_editorial;
    }

    public String getNom_editorial() {
        return nom_editorial;
    }

    public void setNom_editorial(String nom_editorial) {
        this.nom_editorial = nom_editorial;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public EditorialAFs(String cod_editorial, String nom_editorial, String telefono) {
        super(cod_editorial, nom_editorial, telefono);
    }
    @Override
    public String getTipo() {
        return "Tipo específico de Editorial";
    }
}
