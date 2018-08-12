package SpheroApp;

import Simulacion.Accion;
import Simulacion.CondicionalConElse;

public class CondicionalConElseApp extends CondicionalApp {
    private AccionApp accionElseApp;

    public CondicionalConElseApp(String atri, String comp, int val, AccionApp a, AccionApp e) {
        super(atri, comp, val, a);
        this.accionElseApp = e;
    }

    @Override
    public Accion convertirEnAcciones() {
        return new CondicionalConElse(createComparador(), accion.convertirEnAcciones(), accionElseApp.convertirEnAcciones());
    }

    @Override
    public String toSpheroApp() {
        return super.toSpheroApp() + " else { " + this.accionElseApp.toSpheroApp() + " }";
    }

    @Override
    public String toString() {
        return "If ("+atributo+" "+comparacion+" "+valor+") {"+accion.toString()+" }else {"+accionElseApp.toString()+" }";
    }
}


