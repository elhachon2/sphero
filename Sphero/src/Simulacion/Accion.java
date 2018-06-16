package Simulacion;

import java.util.Observable;

public abstract class Accion extends Observable {

    public abstract boolean ejecutar(Controlador c);

}
