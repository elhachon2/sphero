package Simulacion;

public class CompararPorDistinto extends ComparadorAtributos {

    public CompararPorDistinto(String atributo, int valor) {
        super(atributo, valor);
    }

    @Override
    public boolean Comparar(Controlador c) {
        if (!c.getP().getSensor(getAtributo()).equals(getValorAComparar())) {
            return true;
        }
        return false;
    }
}

