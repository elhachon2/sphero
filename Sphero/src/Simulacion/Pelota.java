package Simulacion;

import java.util.HashMap;

public class Pelota extends Pieza {
    private Coordenada posicion;
    private char representacion;
    private int direccion;
    // Se utiliza una hash porque pueden aparecer nuevos sensores.
    private HashMap<String, Integer> sensores;

    public Pelota() {
        Coordenada posicion = new Coordenada(0, 0);
        representacion = 'r';
        // 0 = right
        //TODO: crear constantes para la direccion
        direccion = 0;
        this.sensores = new HashMap<String, Integer>();
    }

    public Integer getSensor(String key) {
        // Devuelvo 0 si el atributo no fue seteado
        if (sensores.containsKey(key)) {
            return sensores.get(key);
        }
        return 0;
    }

    public void setSensor(String key, Integer valor) {
        this.sensores.put(key, valor);
    }


    public boolean setRepresentacion(int r, int g, int b) {
        // Si uno es 255, devuelvo el color correspondiente en orden.
        if (r == 255) {
            representacion = 'r';
            return true;
        }
        if (g == 255) {
            representacion = 'g';
            return true;
        }
        if (b == 255) {
            representacion = 'b';
            return true;
        }
        // e representa error, el simulador solo acepta valores si uno es 255
        representacion = 'e';
        return false;
    }

    public Coordenada getPosicion() {
        return posicion;
    }

    public void setPosicion(Coordenada posicion) {
        this.posicion = posicion;
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
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
