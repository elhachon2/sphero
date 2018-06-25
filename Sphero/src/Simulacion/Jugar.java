package Simulacion;

public class Jugar {
    public static void main(String[] args) {
        Tablero t = new Tablero();
        Pelota p = new Pelota();
        Display d = new Display(t);

        Controlador c = new Controlador(t, p, d);
        c.posicionarPelota(1, 1);

        d.mostrarTablero();

        Compuesta comp = new Compuesta();
        comp.agregarAccion(new Luz(255, 0, 0));
        comp.agregarAccion(new RodarAccion(90, 10, 2));
        comp.agregarAccion(new Condicional(new CompararPorDistinto("Orientacion", 80), new Luz(0, 255, 0)));
        c.ejecutarAccion(comp);
    }
}
