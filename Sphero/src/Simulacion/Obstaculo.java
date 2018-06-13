package Simulacion;

public abstract class Obstaculo extends Pieza {
    @Override
    public boolean puedeMoverse(Pieza p) {
        return false;
    }

    @Override
    public boolean mePuedenPisar(Pelota p) {
        return false;
    }

}
