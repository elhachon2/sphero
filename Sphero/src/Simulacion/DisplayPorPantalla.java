package Simulacion;

import javax.swing.*;

public class DisplayPorPantalla extends Display {
    private JTextArea area;

    public DisplayPorPantalla(Tablero t, JTextArea a) {
        super(t);
        this.area = a;
    }

    @Override
    public void mostrarTablero() {
        String dibujo = "";
        for (int i = 0; i <= 9; i++) {
            dibujo = dibujo + "\n";
            for (int j = 0; j <= 9; j++) {
                dibujo = dibujo + getTablero().getMatriz()[i][j].dibujar();
            }
        }
        area.setText(area.getText() + "\n" + dibujo);

    }

}
