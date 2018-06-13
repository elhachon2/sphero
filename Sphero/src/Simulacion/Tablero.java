package Simulacion;

public class Tablero {
    private Pieza matriz[][];

    public Tablero() {
        matriz = new Pieza[10][10];
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                if (i == 0 || i == 9 || j == 0 || j == 9) {
                    //es borde
                    matriz[i][j] = new Borde();
                } else {
                    matriz[i][j] = new Vacio();
                }
            }
        }
    }

    public void setPieza(int x, int y, Pieza p) {
        this.matriz[x][y] = p;
    }

    public Pieza getPieza(int x, int y) {
        return matriz[x][y];
    }

    public void mostrarTablero() {
        String linea = "";
        for (int i = 0; i <= 9; i++) {
            linea = "";
            for (int j = 0; j <= 9; j++) {
                linea = linea + matriz[i][j].dibujar();
            }
            System.out.println(linea);
        }
    }


}
