package Simulacion;

public class CompararPorIgual extends ComparadorAtributos {

    public CompararPorIgual(String atributo, int valor) {
        super(atributo, valor);
    }

    @Override
    public boolean Comparar(Controlador c) {
        if (c.getP().getSensor(getAtributo()).equals(getValorAComparar())) {
            return true;
        }
        return false;
    }
}
