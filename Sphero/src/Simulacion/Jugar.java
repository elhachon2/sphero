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

        Tablero t1 = new Tablero();
        Pelota p1 = new Pelota();
        Controlador c1 = new Controlador(t1, p1);
        c1.posicionarPelota(1, 1);
        t1.mostrarTablero();
        Compuesta comp = new Compuesta();
        comp.agregarAccion(new Luz('m'));
        comp.agregarAccion(new Movimiento("down"));
        comp.agregarAccion(new Movimiento("right"));
        comp.ejecutar(c1);
        t1.mostrarTablero();
    }
}
