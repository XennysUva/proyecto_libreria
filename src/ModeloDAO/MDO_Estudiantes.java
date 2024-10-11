package ModeloDAO;

import Modelo.Estudiantes;

import java.util.ArrayList;

public class MDO_Estudiantes {

    private ArrayList<Estudiantes> listaEstudiantes;

    public MDO_Estudiantes() {
        listaEstudiantes = new ArrayList<>();
        EstudiantesDAO ed = new EstudiantesDAO();

        listaEstudiantes = ed.listarTodo();
        for (int i = 0; i < listaEstudiantes.size(); i++) {
            Object[] data = {listaEstudiantes.get(i).getDni(), listaEstudiantes.get(i).getNombres(),
                listaEstudiantes.get(i).getApellidos(), listaEstudiantes.get(i).getGrado(), listaEstudiantes.get(i).getSeccion()};
        }
    }

    public ArrayList<Estudiantes> getListaC() {
        return listaEstudiantes;
    }

    //Metodo Secuencial
    public Estudiantes busquedaSecE(int cod) {
        Estudiantes estu = null;

        boolean estado = false;
        int i = 0;

        while (i < listaEstudiantes.size() && estado == false) {
            if (Integer.parseInt(listaEstudiantes.get(i).getDni()) == cod) {
                estado = true;
                estu = listaEstudiantes.get(i);
            } else {
                i++;
            }
        }
        return estu;
    }

    //Metodo Binario
    public Estudiantes busquedaBinE(int cod) {
        Estudiantes estu = null;

        int izq, der, cen;
        boolean estado = false;

        izq = 0;
        der = listaEstudiantes.size() - 1;

        while (izq <= der && estado == false) {
            cen = (izq + der) / 2;
            if (cod == Integer.parseInt(listaEstudiantes.get(cen).getDni())) {
                estu = listaEstudiantes.get(cen);
                estado = true;
            } else if (cod < Integer.parseInt(listaEstudiantes.get(cen).getDni())) {
                der = cen - 1;
            } else {
                izq = cen + 1;
            }
        }
        return estu;
    }

    //Metodos de ordenamiento Burbuja Apellidos 
    public void ordEstuPorApellidos() {
        int i, j;
        Estudiantes aux;

        for (i = 0; i < listaEstudiantes.size() - 1; i++) {
            for (j = i + 1; j < listaEstudiantes.size(); j++) {
                if (listaEstudiantes.get(i).getApellidos().compareToIgnoreCase(listaEstudiantes.get(j).getApellidos()) > 0) {
                    aux = listaEstudiantes.get(i);
                    listaEstudiantes.set(i, listaEstudiantes.get(j));
                    listaEstudiantes.set(j, aux);
                }
            }
        }
    }

    //Metodos de ordenamiento por Seleccion Nombres
    public void ordEstuPorNombres() {
        int n = listaEstudiantes.size();

        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (listaEstudiantes.get(j).getNombres().compareToIgnoreCase(listaEstudiantes.get(min).getNombres()) < 0) {
                    min = j;
                }
            }
            if (min != i) {
                Estudiantes temp = listaEstudiantes.get(i);
                listaEstudiantes.set(i, listaEstudiantes.get(min));
                listaEstudiantes.set(min, temp);
            }
        }
    }
}
