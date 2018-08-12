package SpheroApp;

import Simulacion.Accion;
import Simulacion.Compuesta;

import java.util.Vector;

public class AccionCompuestaApp extends AccionApp {
    private Vector<AccionApp> accionesApp;

    public AccionCompuestaApp() {
        accionesApp = new Vector<AccionApp>();
    }

    public void agregarAcciones(AccionApp a) {
        accionesApp.add(a);
    }

    @Override
    public Accion convertirEnAcciones() {
        Compuesta temp = new Compuesta();
        for (AccionApp a : accionesApp) {
            temp.agregarAccion(a.convertirEnAcciones());
        }
        return temp;
    }

    @Override
    public String toSpheroApp() {
        String codigo = " ";
        for (AccionApp a : accionesApp) {
            codigo = codigo + a.toSpheroApp();
        }
        return codigo;
    }

    @Override
    public String toString() {
        return "";
    }
}
