package SpheroApp;

import Simulacion.*;

public class JugarApp {

    public static void createSpheroProgram(AccionApp a) {
        System.out.println("async function startProgram(){");
        System.out.println(a.toSpheroApp());
        System.out.println("}");
    }

    public static void main(String[] args) {
        Tablero t = new Tablero();
        Pelota p = new Pelota();
        Display d = new Display(t);
        Controlador c = new Controlador(t, p, d);
        c.posicionarPelota(1, 1);
        RodarApp r = new RodarApp(90, 4, 2);
        CondicionalConElseApp cond = new CondicionalConElseApp("Orientacion", "===", 180, new LuzApp(0, 0, 255), new LuzApp(0, 255, 0));
        AccionCompuestaApp comp = new AccionCompuestaApp();
        comp.agregarAcciones(r);
        comp.agregarAcciones(cond);
        c.ejecutarAccion(comp.convertirEnAcciones());
        createSpheroProgram(comp);
    }
}