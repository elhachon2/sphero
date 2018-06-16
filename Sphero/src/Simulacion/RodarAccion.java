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
        // TODO: pasar a un case
        if (dir == 0) {
            return "right";
        } else {
            if (dir == 1) {
                return "down";
            } else {
                if (dir == 2) {
                    return "left";
                } else {
                    if (dir == 3) {
                        return "up";
                    }
                }
            }
        }
        return "right";
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

        if (angulo == 0) {
            direccion = direccionToString(c.getP().getDireccion());
        } else if (angulo == 90) {
            direccion = direccionToString(sumarSinPasarme(c.getP().getDireccion(), 1));
        } else if (angulo == 180) {
            direccion = direccionToString(sumarSinPasarme(c.getP().getDireccion(), 2));
        } else if (angulo == 270) {
            direccion = direccionToString(sumarSinPasarme(c.getP().getDireccion(), 3));
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