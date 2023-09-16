package gui;

import javax.swing.*;
import java.awt.*;

public class VentanaRegistro extends JFrame {
	
	public VentanaRegistro() {
		setTitle("Sistema de Plantas");
		setSize(390, 300);
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		setLocation(950, 100);
		
		Container panel = getContentPane();
        panel.setLayout(null);
		
		JLabel titulo = new JLabel("ZONA DE REGISTRO");
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setForeground(Color.BLUE);
		titulo.setBounds(93, 20, 600, 30);

        panel.add(titulo);

		JLabel tipoPlanta = new JLabel("Tipo de Planta:");
		tipoPlanta.setFont(new Font("Arial", Font.BOLD, 20));
		tipoPlanta.setForeground(Color.BLUE);
		tipoPlanta.setBounds(20, 60, 600, 30);

        panel.add(tipoPlanta);
        
        JTextField tipo = new JTextField();
        tipo.setBounds(20, 90, 200, 20);
        
        panel.add(tipo);

		JLabel cantidadLotes = new JLabel("Cantidad de lotes");
		cantidadLotes.setFont(new Font("Arial", Font.BOLD, 20));
		cantidadLotes.setForeground(Color.BLUE);
		cantidadLotes.setBounds(20, 140, 600, 30);

        panel.add(cantidadLotes);

        JTextField cantidad = new JTextField();
        cantidad.setBounds(20, 170, 200, 20);
        
        panel.add(cantidad);
        
        BotonControl bIngresar = new BotonControl(AccionBoton.ingresar, Color.LIGHT_GRAY, "Ingresar");
        bIngresar.setBounds(270, 210, 90, 30);
        
        panel.add(bIngresar);
	}
	
}
