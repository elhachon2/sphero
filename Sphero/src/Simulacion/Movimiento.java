package Simulacion;

public class Movimiento extends Accion {
    private String direccion;


    public Movimiento(String d) {
        direccion = d;
    }

    public boolean ejecutarMovimiento(int x, int y, int destinox, int destinoy, Controlador c) {
        if (c.getP().puedeMoverse(c.getT().getPieza(destinox, destinoy))) {
            c.getT().setPieza(destinox, destinoy, c.getP());
            c.getT().setPieza(x, y, new Vacio());
            c.getP().setPosicion(new Coordenada(destinox, destinoy));
            return true;
        }
        return false;
    }

    public boolean ejecutar(Controlador c) {
        int x = c.getP().getPosicion().getX();
        int y = c.getP().getPosicion().getY();
        // Derecha
        int destinox = x;
        int destinoy = y + 1;
        if (direccion.equals("left")) {
            destinox = x;
            destinoy = y - 1;
        } else if (direccion.equals("up")) {
            destinox = x - 1;
            destinoy = y;
        } else if (direccion.equals("down")) {
            destinox = x + 1;
            destinoy = y;
        }
        return (ejecutarMovimiento(x, y, destinox, destinoy, c));

    }

}
