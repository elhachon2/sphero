package SpheroApp;

import Simulacion.Compuesta;
import Simulacion.Movimiento;

public class Rodar {
    private int angulo;
    private int rapidez;
    private int duracion;
    private String direccion;

    public Rodar(int ang, int rap, int dur, String dire) {
        this.angulo = ang;
        this.rapidez = rap;
        this.duracion = dur;
        this.direccion = dire;
    }

    public int distancia() {
        // devuelvo entero porque la simulacion se mueve con unidades enteras.
        return (rapidez / duracion);
    }


    public Compuesta convertirEnAcciones() {
        Compuesta comp = new Compuesta();
        for (int i = 0; i <= this.distancia() - 1; i++) {
            comp.agregarAccion(new Movimiento("right"));
        }
        return comp;
    }


}
