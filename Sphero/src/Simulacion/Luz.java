package Simulacion;

public class Luz extends Accion {
    private int r;
    private int g;
    private int b;

    public Luz(int r, int g, int b) {

        this.r = r;
        this.g = g;
        this.b = b;
    }

    @Override
    public boolean ejecutar(Controlador c) {
        if (c.getP().setRepresentacion(r, g, b)) {
            setChanged();
            notifyObservers();
            return true;
        }
        return false;
    }
}
