
package MInterfaces;

import java.util.ArrayList;

public interface CRUDInterface <t>{
    public ArrayList<t> listarTodo();
    public boolean insertar(t c);
    public boolean eliminar(String codigo);
}
