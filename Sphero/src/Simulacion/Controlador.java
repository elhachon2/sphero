package Simulacion;

public class Controlador {
    private Tablero t;
    private Pelota p;
    private Display d;

    public Controlador(Tablero t, Pelota p, Display d) {
        this.t = t;
        this.p = p;
        this.d = d;
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
        a.addObserver(d);
        return a.ejecutar(this);
    }
}
