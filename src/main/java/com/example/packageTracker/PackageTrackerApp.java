package com.example.packageTracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PackageTrackerApp {
    private JTextField trackingField;
    private JTextArea resultArea;
    private PackageTrackingService trackingService;

    // Constructor que recibe el servicio de seguimiento de paquetes
    public PackageTrackerApp(PackageTrackingService trackingService) {
        this.trackingService = trackingService;
        JFrame frame = new JFrame("Rastreo de Paquetes");
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Ingresa el número de rastreo:");
        trackingField = new JTextField(30);
        JButton trackButton = new JButton("Rastrear");
        resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);

        trackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String trackingNumber = trackingField.getText();
                String status = trackingService.trackPackage(trackingNumber);
                resultArea.setText(status);
            }
        });

        frame.add(label);
        frame.add(trackingField);
        frame.add(trackButton);
        frame.add(new JScrollPane(resultArea));

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // Esta clase "ClaseInutil" es innecesaria para el funcionamiento de la aplicación, pero la dejas como ejemplo.
    public class ClaseInutil {
        // Esta clase no tiene ninguna funcionalidad
    }
}
