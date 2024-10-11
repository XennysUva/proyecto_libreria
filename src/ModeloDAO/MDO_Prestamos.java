package ModeloDAO;

import ModeloDAO.PrestamosDAO;
import Modelo.Prestamos;
import java.util.ArrayList;

public class MDO_Prestamos {

    private ArrayList<Prestamos> listaPrestamos;

    public MDO_Prestamos() {
        listaPrestamos = new ArrayList<>();
        PrestamosDAO pd = new PrestamosDAO();

        listaPrestamos = pd.listarTodo();
        for (int i = 0; i < listaPrestamos.size(); i++) {
            Object[] data = {listaPrestamos.get(i).getCod_libro(), listaPrestamos.get(i).getDni(),
                listaPrestamos.get(i).getCod_prestamo(), listaPrestamos.get(i).getFec_pres(), listaPrestamos.get(i).getFec_devo()};
        }
    }

    public ArrayList<Prestamos> getListaC() {
        return listaPrestamos;
    }

    //Metodo Secuencial
    public Prestamos busquedaCodPres(String cod) {
        Prestamos pres_cod = null;

        boolean estado = false;
        int i = 0;

        while (i < (listaPrestamos.size()) && estado == false) {
            if (listaPrestamos.get(i).getCod_prestamo().equals(cod)) {
                estado = true;
                pres_cod = listaPrestamos.get(i);
            } else {
                i++;
            }
        }
        return pres_cod;
    }

    //Metodo Binario
    public Prestamos busquedaBinDNIPres(int cod) {
        Prestamos estu = null;

        int izq, der, cen;
        boolean estado = false;

        izq = 0;
        der = listaPrestamos.size() - 1;

        while (izq <= der && estado == false) {
            cen = (izq + der) / 2;
            if (cod == Integer.parseInt(listaPrestamos.get(cen).getDni())) {
                estu = listaPrestamos.get(cen);
                estado = true;
            } else if (cod < Integer.parseInt(listaPrestamos.get(cen).getDni())) {
                der = cen - 1;
            } else {
                izq = cen + 1;
            }
        }
        return estu;
    }

    public void ordenarPrestamosDNI() {
        int i, j;
        Prestamos aux;

        for (i = 0; i < listaPrestamos.size() - 1; i++) {
            for (j = i + 1; j < listaPrestamos.size(); j++) {
                if (Integer.parseInt(listaPrestamos.get(i).getDni()) > Integer.parseInt(listaPrestamos.get(j).getDni())) {
                    aux = listaPrestamos.get(i);
                    listaPrestamos.set(i, listaPrestamos.get(j));
                    listaPrestamos.set(j, aux);
                }
            }
        }
    }

    //Metodo QuickSort Ordenar por Cod_prestamo
    public void quickSort(Prestamos[] datos, int primero, int ultimo) {
        int i = primero;
        int j = ultimo;

        Prestamos pivot = datos[(primero + ultimo) / 2];

        do {
            while (compararCodPrestamo(datos[i].getCod_prestamo(), pivot.getCod_prestamo()) < 0) {
                i++;
            }

            while (compararCodPrestamo(datos[j].getCod_prestamo(), pivot.getCod_prestamo()) > 0) {
                j--;
            }

            if (i <= j) {
                Prestamos temp = datos[i];
                datos[i] = datos[j];
                datos[j] = temp;
                i++;
                j--;
            }

        } while (i <= j);

        if (primero < j) {
            quickSort(datos, primero, j);
        }

        if (i < ultimo) {
            quickSort(datos, i, ultimo);
        }
    }

    private int compararCodPrestamo(String cod1, String cod2) {
        int num1 = Integer.parseInt(cod1.substring(1));
        int num2 = Integer.parseInt(cod2.substring(1));
        return Integer.compare(num1, num2);
    }

    //METODO INSERCCION ordenar Fec_devo
    public void MetodoInserccion(ArrayList<Prestamos> fechasDevolucion) {
        int izq;
        Prestamos espera;

        for (int i = 1; i < fechasDevolucion.size(); i++) {
            espera = fechasDevolucion.get(i);
            izq = i - 1;
            while (izq >= 0 && fechasDevolucion.get(izq).getFec_devo().compareTo(espera.getFec_devo()) > 0) {
                fechasDevolucion.set(izq + 1, fechasDevolucion.get(izq));
                izq--;
            }
            fechasDevolucion.set(izq + 1, espera);
        }
    }

    public void shellSortCodLibro(int[] prestamos) {
        int i, j, k, tem, salto;
        salto = (prestamos.length) / 2;

        while (salto > 0) {

            for (i = salto; i < prestamos.length; i++) {
                j = i - salto;

                while (j >= 0) {
                    k = j + salto;

                    if (prestamos[j] >= prestamos[k]) {
                        tem = prestamos[j];
                        prestamos[j] = prestamos[k];
                        tem = prestamos[k];
                        j -= salto;
                    } else {
                        j = -1;
                    }
                }
            }
            salto = salto / 2;
        }
    }

    public void merge(Prestamos[] A, int izq, int m, int der) {
        int i, j, k;
        Prestamos[] B = new Prestamos[A.length]; // Array auxiliar

        for (i = izq; i <= der; i++) { // Copia de ambas mitades en el array auxiliar
            B[i] = A[i];
        }

        i = izq;
        j = m + 1;
        k = izq;

        while (i <= m && j <= der) { // Copia el siguiente elemento más grande
            if (B[i].getFec_pres().compareTo(B[j].getFec_pres()) <= 0) {
                A[k++] = B[i++];
            } else {
                A[k++] = B[j++];
            }
        }

        while (i <= m) { // Copia los elementos que quedan de la primera mitad (si los hay)
            A[k++] = B[i++];
        }
    }

    public void mergeSortFecPres(Prestamos[] A, int izq, int der) {
        if (izq < der) {
            int m = (izq + der) / 2;
            mergeSortFecPres(A, izq, m);
            mergeSortFecPres(A, m + 1, der);
            merge(A, izq, m, der);
        }
    }
}
