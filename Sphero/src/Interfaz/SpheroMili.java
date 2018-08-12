package Interfaz;

import SpheroApp.*;

import javax.swing.*;
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
    private Vector<AccionApp> vectorDeAcciones;

    public void ActualizarComboBox() {
        listAcciones.removeAllItems();
        accionesIf.removeAllItems();
        accionesElse.removeAllItems();
        for (AccionApp a : vectorDeAcciones) {
            listAcciones.addItem(a);
            accionesIf.addItem(a);
            accionesElse.addItem(a);
        }
    }

    public SpheroMili() {
        vectorDeAcciones = new Vector<AccionApp>();
        crearRodarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String valores = "Rodar: " + angulo.getText() + ", " + rapidez.getText() + ", " + duracion.getText() + ".";
                JOptionPane.showMessageDialog(null, valores);
                int temp = Integer.parseInt(angulo.getText());
                int temp2 = Integer.parseInt(rapidez.getText());
                int temp3 = Integer.parseInt(duracion.getText());
                vectorDeAcciones.add(new RodarAccionApp(temp, temp2, temp3));
                ActualizarComboBox();

            }
        });
        crearLuzButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = "Luz: " + r.getText() + ", " + g.getText() + ", " + b.getText() + ".";
                JOptionPane.showMessageDialog(null, value);
                int temp = Integer.parseInt(r.getText());
                int temp2 = Integer.parseInt(g.getText());
                int temp3 = Integer.parseInt(b.getText());
                vectorDeAcciones.add(new LuzApp(temp, temp2, temp3));
                ActualizarComboBox();
            }
        });
        crearCondicionalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = "If (" + atributo.getSelectedItem().toString() + " " + comparacion.getSelectedItem().toString() + " " + valor.getText() + ") {" + listAcciones.getSelectedItem().toString() + "}";
                JOptionPane.showMessageDialog(null, value);
                String temp = atributo.getSelectedItem().toString();
                String temp2 = comparacion.getSelectedItem().toString();
                int temp3 = Integer.parseInt(valor.getText());
                AccionApp temp4 = (AccionApp) listAcciones.getSelectedItem();
                vectorDeAcciones.add(new CondicionalApp(temp,temp2,temp3,temp4));
                ActualizarComboBox();
            }
        });
        crearCondicionalElseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = "If (" + atributoelse.getSelectedItem().toString() + " " + comparador2.getSelectedItem().toString() + " " + valor2.getText() + ") {" + accionesIf.getSelectedItem().toString() + "}else {" + accionesElse.getSelectedItem().toString() + " }";
                JOptionPane.showMessageDialog(null, value);
                String temp = atributoelse.getSelectedItem().toString();
                String temp2 = comparador2.getSelectedItem().toString();
                int temp3 = Integer.parseInt(valor2.getText());
                AccionApp temp4 = (AccionApp) accionesIf.getSelectedItem();
                AccionApp temp5 = (AccionApp) accionesElse.getSelectedItem();
                vectorDeAcciones.add(new CondicionalConElseApp(temp,temp2,temp3,temp4,temp5));
                ActualizarComboBox();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sphero");
        frame.setContentPane(new SpheroMili().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        listAcciones = new JComboBox<AccionApp>();

    }
}