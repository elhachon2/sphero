package SpheroApp;

import Simulacion.Controlador;
import Simulacion.Pelota;
import Simulacion.Tablero;

public class JugarApp {
    public static void main(String[] args) {
        Tablero t = new Tablero();
        Pelota p = new Pelota();
        Controlador c = new Controlador(t, p);
        c.posicionarPelota(1, 1);
        Rodar r = new Rodar(0, 6, 2, "right");
        c.ejecutarAccion(r.convertirEnAcciones());
        t.mostrarTablero();
    }
}