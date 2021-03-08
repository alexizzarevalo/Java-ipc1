package com.interfaz;

import com.adopciones.Mascota;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IntefazGrafica extends JFrame {
    JTable tablaMascotas;
    JButton agregarMascota;
    JTextField txtNombreMascota;
    MiBoton boton;

    public IntefazGrafica(Object[][] datosMascotas, String[] columnNames) {
        this.setLayout(null);
        this.setTitle("Adopciones");
        this.setBounds(500,500,500,500);

        tablaMascotas = new JTable(datosMascotas, columnNames);
        tablaMascotas.setBounds(0,0,500,200);

        agregarMascota = new JButton("Agregar mascota");
        agregarMascota.setBounds(0,230,200,25);
        agregarMascota.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(txtNombreMascota.getText());
            }
        });


        txtNombreMascota = new JTextField();
        txtNombreMascota.setBounds(0,200,200,25);
        txtNombreMascota.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("Tecla presionada: " + e.getKeyChar());
            }
        });

        this.add(agregarMascota);
        this.add(txtNombreMascota);
        this.add(tablaMascotas);
    }
}
