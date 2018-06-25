package SpheroApp;

import Simulacion.Accion;
import Simulacion.Luz;

public class LuzApp extends AccionApp {
    private int r;
    private int g;
    private int b;

    public LuzApp(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public Accion convertirEnAcciones() {
        return new Luz(r, g, b);
    }

    public String toSpheroApp() {
        return "setMainLed({ r: " + r + ", g: " + g + ", b: " + b + " });";
    }
}
