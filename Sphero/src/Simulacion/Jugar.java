package Simulacion;

public class Jugar {
    public static void main(String[] args) {
        Tablero t = new Tablero();
        Pelota p = new Pelota();
        Controlador c = new Controlador(t, p);
        c.posicionarPelota(1, 1);
        t.mostrarTablero();

        c.ejecutarAccion(new Movimiento("right"));
        t.mostrarTablero();
        c.ejecutarAccion(new Movimiento("down"));
        t.mostrarTablero();
        c.ejecutarAccion(new Movimiento("left"));
        t.mostrarTablero();
        c.ejecutarAccion(new Movimiento("left"));
        t.mostrarTablero();
        c.ejecutarAccion(new Luz('z'));
        t.mostrarTablero();
    }
}
