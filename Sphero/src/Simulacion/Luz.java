package Simulacion;

public class Luz extends Accion {
    private char rep;

    public Luz(char c) {
        rep = c;
    }

    @Override
    public boolean ejecutar(Controlador c) {
        if (c.getP().setRepresentacion(rep)) {
            setChanged();
            notifyObservers();
            return true;
        }
        return false;
    }
}
