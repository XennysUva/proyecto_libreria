package Abstractfactory;

import MInterfaces.Buscador;
import MInterfaces.CRUDInterface;
import Abstractfactory.EditorialAF;

public interface EditorialAFI extends CRUDInterface<EditorialAF>, Buscador<EditorialAF>{
    
}
