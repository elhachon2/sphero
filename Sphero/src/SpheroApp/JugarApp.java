package SpheroApp;

import Simulacion.Controlador;
import Simulacion.Display;
import Simulacion.Pelota;
import Simulacion.Tablero;

public class JugarApp {
    public static void main(String[] args) {
        Tablero t = new Tablero();
        Pelota p = new Pelota();
        Display d = new Display(t);
        Controlador c = new Controlador(t, p, d);
        c.posicionarPelota(1, 1);
        Rodar r = new Rodar(90, 6, 2);
        c.ejecutarAccion(r.convertirEnAcciones());
        Rodar r1 = new Rodar(270, 6, 2);
        c.ejecutarAccion(r1.convertirEnAcciones());
    }
}