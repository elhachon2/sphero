package Simulacion;

public abstract class Pieza {

    public abstract boolean puedeMoverse(Pieza p);

    public abstract boolean mePuedenPisar(Pelota p);

    public abstract char dibujar();
}
