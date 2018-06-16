package SpheroApp;

import Simulacion.Accion;
import Simulacion.RodarAccion;

public class Rodar {
    private int angulo;
    private int rapidez;
    private int duracion;

    public Rodar(int ang, int rap, int dur) {
        this.angulo = ang;
        this.rapidez = rap;
        this.duracion = dur;
    }

    public Accion convertirEnAcciones() {
        return new RodarAccion(angulo, rapidez, duracion);
    }
}
