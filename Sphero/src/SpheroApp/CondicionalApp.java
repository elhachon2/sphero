package SpheroApp;

import Simulacion.*;

public class CondicionalApp extends AccionApp {
    protected String atributo;
    protected String comparacion; //Puede representarse como ===, <, <=, >, >=, !==
    protected int valor;
    protected AccionApp accion;

    public CondicionalApp(String atri, String comp, int val, AccionApp a) {
        this.atributo = atri;
        this.comparacion = comp;
        this.valor = val;
        this.accion = a;
    }

    public String atributoToSphero() {
        if (this.atributo.equals("Orientacion")) {
            return "getHeading()";
        }
        return " ";
    }

    public ComparadorAtributos createComparador() {
        switch (comparacion) {
            case "===":
                return new CompararPorIgual(atributo, valor);
            case "<":
                return new CompararPorMenor(atributo, valor);
            case ">":
                return new CompararPorMayor(atributo, valor);
            case "<=":
                return new CompararPorMenorOIgual(atributo, valor);
            case ">=":
                return new CompararPorMayorOIgual(atributo, valor);
            case "!==":
                return new CompararPorDistinto(atributo, valor);
            default:
                // Error.
                return new CompararPorIgual(atributo, 99999);
        }
    }

    @Override
    public Accion convertirEnAcciones() {
        return new Condicional(createComparador(), accion.convertirEnAcciones());
    }

    @Override
    public String toSpheroApp() {
        return "if (" + this.atributoToSphero() + " " + this.comparacion + " " + this.valor + ") {" + this.accion.toSpheroApp() + " }";
    }

    @Override
    public String toString() {
        return "If ("+atributo+" "+comparacion+" "+valor+") {"+accion.toString()+" }";
    }
}
