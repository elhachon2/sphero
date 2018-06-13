package Simulacion;

public class Controlador {
    private Tablero t;
    private Pelota p;

    public Controlador(Tablero t, Pelota p) {
        this.t = t;
        this.p = p;
    }


    public void posicionarPelota(int x, int y) {
        t.setPieza(x, y, this.p);
        this.p.setPosicion(new Coordenada(x, y));
    }

    public Tablero getT() {
        return t;
    }

    public void setT(Tablero t) {
        this.t = t;
    }

    public Pelota getP() {
        return p;
    }

    public void setP(Pelota p) {
        this.p = p;
    }

    public boolean ejecutarAccion(Accion a) {
        return a.ejecutar(this);
    }
}
