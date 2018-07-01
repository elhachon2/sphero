package Simulacion;

public class RodarAccion extends Accion {
    private int angulo;
    private int rapidez;
    private int duracion;


    public RodarAccion(int ang, int rap, int dur) {
        this.angulo = ang;
        this.rapidez = rap;
        this.duracion = dur;
    }

    public int distancia() {
        return (rapidez / duracion);
    }

    public String direccionToString(int dir) {
        switch (dir) {
            case 0:
                return "right";
            case 1:
                return "down";
            case 2:
                return "left";
            case 3:
                return "up";
            default:
                // Error.
                return "right";
        }
    }


    public int sumarSinPasarme(int valor, int suma) {
        int temp = valor;
        temp = temp + suma;

        while (temp > 3) {
            temp = temp - 4;
        }
        return temp;
    }


    @Override
    public boolean ejecutar(Controlador c) {
        String direccion = direccionToString(c.getP().getDireccion());
        c.getP().setSensor("Orientacion", angulo);

        switch (angulo) {
            case 0:
                direccion = direccionToString(c.getP().getDireccion());
                break;
            case 90:
                direccion = direccionToString(sumarSinPasarme(c.getP().getDireccion(), 1));
                break;
            case 180:
                direccion = direccionToString(sumarSinPasarme(c.getP().getDireccion(), 2));
                break;
            case 270:
                direccion = direccionToString(sumarSinPasarme(c.getP().getDireccion(), 3));
                break;
            default:
                // Error.
                break;
        }
        for (int i = 0; i <= distancia() - 1; i++) {
            Movimiento temp = new Movimiento(direccion);
            if (!temp.ejecutar(c)) {
                return false;
            }
            setChanged();
            notifyObservers();
        }
        return true;
    }
}