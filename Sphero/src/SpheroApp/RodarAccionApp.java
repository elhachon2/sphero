package SpheroApp;

import Simulacion.Accion;
import Simulacion.RodarAccion;

public class RodarAccionApp extends AccionApp {
    private int angulo;
    private int rapidez;
    private int duracion;

    public RodarAccionApp(int ang, int rap, int dur) {
        this.angulo = ang;
        this.rapidez = rap;
        this.duracion = dur;
    }

    public Accion convertirEnAcciones() {
        return new RodarAccion(angulo, rapidez, duracion);
    }

    public String toSpheroApp() {
        return "await roll(" + angulo + "," + rapidez + "," + duracion + ");";
    }

    @Override
    public String toString() {
        return "Rodar("+angulo+", "+rapidez+", "+duracion+")";
    }
}
