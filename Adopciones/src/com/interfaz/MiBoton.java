package com.interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MiBoton extends JButton {
    public MiBoton(String title) {
        this.setText(title);
        this.setBackground(new Color(103, 206, 26));
        this.setSize(200,25);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("");
            }
        });
    }
}
