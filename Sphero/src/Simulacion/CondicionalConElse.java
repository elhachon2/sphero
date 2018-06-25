package Simulacion;

public class CondicionalConElse extends Condicional {
    private Accion accionElse;

    public CondicionalConElse(ComparadorAtributos comparador, Accion a, Accion e) {
        super(comparador, a);
        this.accionElse = e;
    }

    @Override
    public boolean ejecutar(Controlador c) {
        if (comparador.Comparar(c)) {
            return c.ejecutarAccion(accion);
        } else {
            return c.ejecutarAccion(accionElse);
        }
    }
}
