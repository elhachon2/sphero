package Simulacion;

public class Vacio extends Pieza {

    @Override
    public boolean puedeMoverse(Pieza p) {
        return false;
    }

    @Override
    public boolean mePuedenPisar(Pelota p) {
        return true;
    }

    @Override
    public char dibujar() {
        return ' ';
    }
}
