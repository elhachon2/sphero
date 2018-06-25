package Simulacion;

public class CompararPorMayorOIgual extends ComparadorAtributos {

    public CompararPorMayorOIgual(String atributo, int valor) {
        super(atributo, valor);
    }

    @Override
    public boolean Comparar(Controlador c) {
        if (c.getP().getSensor(getAtributo()).compareTo(getValorAComparar()) == 1 || c.getP().getSensor(getAtributo()).equals(getValorAComparar())) {
            return true;
        }
        return false;
    }
}

