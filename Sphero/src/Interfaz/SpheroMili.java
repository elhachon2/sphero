package Interfaz;

import Simulacion.*;
import SpheroApp.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class SpheroMili {
    private JPanel panel1;
    private JTextField rapidez;
    private JTextField angulo;
    private JTextField duracion;
    private JLabel Rodar;
    private JLabel Luz;
    private JTextField r;
    private JTextField g;
    private JTextField b;
    private JButton crearRodarButton;
    private JButton crearLuzButton;
    private JLabel Rojo;
    private JComboBox atributo;
    private JComboBox comparacion;
    private JTextField valor;
    private JComboBox<AccionApp> listAcciones;
    private JButton crearCondicionalButton;
    private JButton crearCondicionalElseButton;
    private JTextField valor2;
    private JComboBox comparador2;
    private JComboBox<AccionApp> accionesIf;
    private JComboBox<AccionApp> accionesElse;
    private JComboBox atributoelse;
    private JTextField tablero1;
    private JButton ejecutar;
    private JTextArea tablero;
    private JButton agregar;
    private JComboBox accionesAAgregar;
    private JLabel elegirAcciones;
    private JList list1;
    private JButton borrarAccion;
    private JTextArea codigoToSphero;
    private JButton codigoParaSpheroButton;
    private Vector<AccionApp> vectorDeAcciones;
    private DefaultListModel modelo;

    public void ActualizarComboBox() {
        listAcciones.removeAllItems();
        accionesIf.removeAllItems();
        accionesElse.removeAllItems();
        accionesAAgregar.removeAllItems();
        for (AccionApp a : vectorDeAcciones) {
            listAcciones.addItem(a);
            accionesIf.addItem(a);
            accionesElse.addItem(a);
            accionesAAgregar.addItem(a);
        }
    }

    public SpheroMili() {
        vectorDeAcciones = new Vector<AccionApp>();
        crearRodarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String valores = "Rodar: " + angulo.getText() + ", " + rapidez.getText() + ", " + duracion.getText() + ".";
                int temp = Integer.parseInt(angulo.getText());
                int temp2 = Integer.parseInt(rapidez.getText());
                int temp3 = Integer.parseInt(duracion.getText());
                if ((temp == 0 | temp == 90 | temp == 180 | temp == 270) && (temp2 >= temp3) && (temp3>0)) {
                    vectorDeAcciones.add(new RodarAccionApp(temp, temp2, temp3));
                    ActualizarComboBox();
                    //JOptionPane.showMessageDialog(null, valores);
                } else {
                    JOptionPane.showMessageDialog(null, " El ángulo tiene que ser 0, 90, 180, 270.\n La rapidez siempre tiene que ser mayor que la duración. \n La duración no puede ser 0. ");
                }
            }
        });
        crearLuzButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = "Luz: " + r.getText() + ", " + g.getText() + ", " + b.getText() + ".";
                int temp = Integer.parseInt(r.getText());
                int temp2 = Integer.parseInt(g.getText());
                int temp3 = Integer.parseInt(b.getText());
                if ((temp == 0 | temp == 255) && (temp2 == 0 | temp2 == 255) && (temp3 == 0 | temp3 == 255)){
                    vectorDeAcciones.add(new LuzApp(temp, temp2, temp3));
                    ActualizarComboBox();
                    //JOptionPane.showMessageDialog(null, value);
                }else {
                    JOptionPane.showMessageDialog(null, "Valores válidos: 0 o 255");
                }

            }
        });
        crearCondicionalElseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = "If (" + atributoelse.getSelectedItem().toString() + " " + comparador2.getSelectedItem().toString() + " " + valor2.getText() + ") {" + accionesIf.getSelectedItem().toString() + "}else {" + accionesElse.getSelectedItem().toString() + " }";
                String temp = atributoelse.getSelectedItem().toString();
                String temp2 = comparador2.getSelectedItem().toString();
                int temp3 = Integer.parseInt(valor2.getText());
                AccionApp temp4 = (AccionApp) accionesIf.getSelectedItem();
                AccionApp temp5 = (AccionApp) accionesElse.getSelectedItem();
                if ((temp3 == 0 | temp3 == 90 | temp3 == 180 | temp3 == 270) ) {
                    vectorDeAcciones.add(new CondicionalConElseApp(temp, temp2, temp3, temp4, temp5));
                    ActualizarComboBox();
                    //JOptionPane.showMessageDialog(null, value);
                }else{
                    JOptionPane.showMessageDialog(null, "El valor tiene que ser 0, 90, 180, 270.");
                }
            }
        });

        ejecutar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablero.setText("");
                Tablero t = new Tablero();
                Pelota p = new Pelota();
                DisplayPorPantalla d = new DisplayPorPantalla(t, tablero);
                Controlador c = new Controlador(t, p, d);
                c.posicionarPelota(1, 1);
                AccionCompuestaApp comp = new AccionCompuestaApp();
                for (Object o : modelo.toArray()) {
                    comp.agregarAcciones((AccionApp) o);
                }
                c.ejecutarAccion(comp.convertirEnAcciones());
                //JOptionPane.showMessageDialog(null, c.ejecutarAccion(comp.convertirEnAcciones()));
            }
        });
        agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccionApp temp = (AccionApp) accionesAAgregar.getSelectedItem();
                //JOptionPane.showMessageDialog(null, "Accion agregada exitosamente");
                modelo.addElement(temp);
                list1.setModel(modelo);
            }
        });
        borrarAccion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelo.remove(list1.getSelectedIndex());
                list1.setModel(modelo);
                //JOptionPane.showMessageDialog(null, "Accion borrada exitosamente");
            }
        });


        codigoParaSpheroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccionCompuestaApp comp = new AccionCompuestaApp();
                for (Object o : modelo.toArray()) {
                    comp.agregarAcciones((AccionApp) o);
                }
                codigoToSphero.setText(createSpheroProgram(comp));
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sphero");
        frame.setSize(1024,768);
        SpheroMili mili = new SpheroMili();
        mili.panel1.setSize(1024,768);
        frame.setContentPane(mili.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        listAcciones = new JComboBox<AccionApp>();
        modelo = new DefaultListModel();

    }

    public String createSpheroProgram(AccionApp a) {
        String temp = ("async function startProgram(){") + (a.toSpheroApp()) + ("}");
        return temp;
    }
}