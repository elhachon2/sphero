package Simulacion;

public class Pelota extends Pieza {
    private Coordenada posicion;
    private char representacion;
    private int direccion;

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    public Pelota() {
        Coordenada posicion = new Coordenada(0, 0);
        representacion = 'p';
        // 0 = right
        //TODO: crear constantes para la direccion
        direccion = 0;
    }

    public boolean setRepresentacion(char c) {
        if (c == 'p' || c == 'z' || c == 'm') {
            representacion = c;
            return true;
        }
        return false;
    }

    public Coordenada getPosicion() {
        return posicion;
    }

    public void setPosicion(Coordenada posicion) {
        this.posicion = posicion;
    }

    @Override
    public boolean puedeMoverse(Pieza pieza) {
        return pieza.mePuedenPisar(this);
    }

    @Override
    public boolean mePuedenPisar(Pelota p) {
        return false;
    }

    @Override
    public char dibujar() {
        return representacion;
    }


}
