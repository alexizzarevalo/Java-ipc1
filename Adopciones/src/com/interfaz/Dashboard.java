package com.interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Dashboard extends JFrame {
    JButton btnAceptar;
    JTable table;
    JDialog dialog;
    JOptionPane optionPane = new JOptionPane();

    public Dashboard(Object[][] datos, String[] columns) {
        // Quitamos el layout
        this.setLayout(null);
        // Indica el tama;o de la ventana
        this.setBounds(0,0,1200,800);
        // Indica que no se puede cambiar de tama;o
        this.setResizable(false);
        // Se coloca un titulo a la venta
        this.setTitle("Adopciones de mascotas");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Se agrega una tabla
        this.table = new JTable(datos, columns);
        this.table.setBounds(10,10,500,500);
        this.add(table);

        // Se agrega un boton
        this.btnAceptar = new JButton();
        this.btnAceptar.setText("Agregar mascota");
        this.btnAceptar.setBackground(new Color(139, 68, 158));
        this.btnAceptar.setBounds(150,550,200,50);
        this.add(btnAceptar);

        this.optionPane.createDialog("Arch");

        this.btnAceptar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Press");
                optionPane.setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("Entra");
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                System.out.println("hello");
            }
        });

        this.btnAceptar.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Action");
            }
        });
    }
}
