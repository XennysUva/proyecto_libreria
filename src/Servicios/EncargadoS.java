package Servicios;

import MInterfaces.EncargadoInterface;
import Modelo.Encargado;
import java.util.ArrayList;
import java.util.List;

public class EncargadoS implements EncargadoInterface {

    private static ArrayList<Encargado> ven = new ArrayList<>();

    @Override
    public ArrayList<Encargado> listarTodo() {
        return ven;
    }

    @Override
    public boolean insertar(Encargado c) {
        return ven.add(c);
    }

    @Override
    public boolean eliminar(String codigo) {
        return ven.removeIf(e -> e.getCod_encargado().equals(codigo));
    }

    public List<Encargado> lisNenca() {
        return ven;
    }
}
