package Simulacion;

public class Pelota extends Pieza {
    // esto es para evitar que tablero tenga que recorrer todas las posiciones de la matriz para buscarme cuando me voy a mover
    static final int right=0;
    static final int down=1;
    static final int left=2;
    static final int up=3;

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
        direccion = right;
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
