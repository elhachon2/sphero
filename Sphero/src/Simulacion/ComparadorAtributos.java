package Simulacion;

// Se definen todos los comparar porque no apareceran nuevos.
// Sino se podria haber realizado el And y Or y armar los mayores e iguales con estas clases.

public abstract class ComparadorAtributos {
    private String atributo;
    private int valorAComparar;

    public ComparadorAtributos(String atri, int valor) {
        this.atributo = atri;
        this.valorAComparar = valor;
    }

    public abstract boolean Comparar(Controlador c);

    public String getAtributo() {
        return atributo;
    }

    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }

    public int getValorAComparar() {
        return valorAComparar;
    }

    public void setValorAComparar(int valorAComparar) {
        this.valorAComparar = valorAComparar;
    }

}
