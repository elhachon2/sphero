package Simulacion;


import java.util.Observable;
import java.util.Observer;

public class Display implements Observer {
    private Tablero tablero;

    public Display(Tablero t) {
        this.tablero = t;
    }

    public void mostrarTablero() {
        String linea = "";
        for (int i = 0; i <= 9; i++) {
            linea = "";
            for (int j = 0; j <= 9; j++) {
                linea = linea + tablero.getMatriz()[i][j].dibujar();
            }
            System.out.println(linea);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        mostrarTablero();
    }
}
