package Simulacion;

public class Luz extends Accion {
    private char rep;

    public Luz(char c) {
        rep = c;
    }

    @Override
    public boolean ejecutar(Controlador c) {
        if (c.getP().setRepresentacion(rep)) {
            return true;
        }
        return false;
    }
}
