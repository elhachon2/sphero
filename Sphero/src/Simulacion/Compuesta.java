package Simulacion;

import java.util.Observer;
import java.util.Vector;

public class Compuesta extends Accion {
    private Vector<Accion> acciones;

    public Compuesta() {
        this.acciones = new Vector<Accion>();
    }

    public void agregarAccion(Accion a) {
        acciones.add(a);
    }

    @Override
    public synchronized void addObserver(Observer o) {
        for (Accion a : acciones) {
            a.addObserver(o);
        }
    }

    @Override
    public boolean ejecutar(Controlador c) {
        //ejecuto todas las acciones. Si aparece un error, finalizo.
        for (Accion a : acciones) {
            if (!a.ejecutar(c)) {
                return false;
            }
        }
        return true;
    }
}
