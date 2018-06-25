package Simulacion;

public class Condicional extends Accion {
    protected ComparadorAtributos comparador;
    protected Accion accion;

    public Condicional (ComparadorAtributos comparador, Accion a){
        this.comparador=comparador;
        this.accion=a;
    }

    @Override
    public boolean ejecutar(Controlador c) {
        if (comparador.Comparar(c)) {
            return c.ejecutarAccion(accion);
        }
        return true;
    }
}
