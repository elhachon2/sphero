package Simulacion;

public class CompararPorMayor extends ComparadorAtributos {

    public CompararPorMayor(String atributo, int valor) {
        super(atributo, valor);
    }

    @Override
    public boolean Comparar(Controlador c) {
        if (c.getP().getSensor(getAtributo()).compareTo(getValorAComparar()) == 1) {
            return true;
        }
        return false;
    }
}

