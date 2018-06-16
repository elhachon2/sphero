package Simulacion;

public class Jugar {
    public static void main(String[] args) {
        Tablero t = new Tablero();
        Pelota p = new Pelota();
        Display d = new Display(t);

        Controlador c = new Controlador(t, p, d);
        c.posicionarPelota(1, 1);

        d.mostrarTablero();

        c.ejecutarAccion(new Movimiento("right"));
        c.ejecutarAccion(new Movimiento("right"));
        c.ejecutarAccion(new Movimiento("right"));
        c.ejecutarAccion(new Movimiento("right"));
        c.ejecutarAccion(new Movimiento("right"));

        Compuesta comp = new Compuesta();
        comp.agregarAccion(new Luz('m'));
        comp.agregarAccion(new Movimiento("down"));
        comp.agregarAccion(new RodarAccion(90, 10, 2));
        c.ejecutarAccion(comp);

    }
}
