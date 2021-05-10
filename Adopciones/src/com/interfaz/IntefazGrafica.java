package com.interfaz;

import com.adopciones.Mascota;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IntefazGrafica extends JFrame {
    JScrollPane scrollPane;
    JTable tablaMascotas;
    JButton agregarMascota;
    JTextField txtNombreMascota;
    MiBoton boton;
    int idMascotaSeleccionada = -1;

    public IntefazGrafica(Object[][] datosMascotas, String[] columnNames) {
        this.setLayout(null);
        this.setTitle("Adopciones");
        this.setBounds(500,500,500,500);

        tablaMascotas = new JTable(datosMascotas, columnNames);
        tablaMascotas.setBounds(0,0,500,200);

        tablaMascotas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        tablaMascotas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = tablaMascotas.getSelectedRow();
                int column = tablaMascotas.getSelectedColumn();
                if (column == 1) {
                    System.out.println(column);
                    // abrir la ventana mas informacion
                }


                idMascotaSeleccionada = (int)tablaMascotas.getValueAt(row, 0);
                // Actualizar mi lista de mascotas con los valores nuevos y retornar el objeto cambiado

                Mascota mascotaActualizada = new Mascota(
                        idMascotaSeleccionada,
                        "Nuevo tipo",
                        "Nuevo nombre",
                        "Blanco",
                        5,
                        "San Marcos",
                        "No"
                );
                actualizarMascotaEnTabla(row, mascotaActualizada);
            }
        });


//
//        tablaMascotas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
//            @Override
//            public void valueChanged(ListSelectionEvent e) {
//                int row = tablaMascotas.getSelectedRow();
//                int codigo = (int)tablaMascotas.getValueAt(row, 0);
//                // Actualizar mi lista con los valores nuevos y retornar el objeto cambiado
//                Mascota mascotaActualizada = new Mascota(
//                        codigo,
//                        "Nuevo",
//                        "Valor",
//                        "Actualizado",
//                        5,
//                        "San Marcos",
//                        "No"
//                );
//                actualizarMascota(row, mascotaActualizada);
//
//            }
//        });


        agregarMascota = new JButton("Agregar mascota");
        agregarMascota.setBounds(0,230,200,25);
        agregarMascota.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(txtNombreMascota.getText());
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setBounds(0,200,500,100);

        for(int i = 0; i < datosMascotas.length; i++) {
            JButton button = new JButton(i + "");
            button.setSize(200,25);
            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    JButton button = (JButton) e.getSource();
                    System.out.println(button.getText());
                }
            });
            panel.add(button);
        }
        this.add(panel);


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

        scrollPane = new JScrollPane(tablaMascotas);
        scrollPane.setBounds(0,0,500,200);
        this.add(scrollPane);
    }


    public void actualizarMascotaEnTabla(int row, Mascota mascota) {
        tablaMascotas.setValueAt(mascota.getId(), row, 0);
        tablaMascotas.setValueAt(mascota.getNombre(), row, 1);
        tablaMascotas.setValueAt(mascota.getColor(), row, 2);
        tablaMascotas.setValueAt(mascota.getEdad(), row, 3);
        tablaMascotas.setValueAt(mascota.getTipo(), row, 4);
        tablaMascotas.setValueAt(mascota.isEstaAdoptada(), row, 5);
        tablaMascotas.setValueAt(mascota.getAlbergue(), row, 6);
    }
}
