package gui.controlWindow;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VentanaControl extends JFrame {
	
	private ListaCultivo cultivos = new ListaCultivo();
	
	public VentanaControl() {
		setTitle("Sistema de Plantas");
		setSize(800, 600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		setLocation(40, 60);
		
		Container panel = getContentPane();
        panel.setLayout(null);
		
		JLabel titulo = new JLabel("ZONA DE CONTROL");
		titulo.setFont(new Font("Arial", Font.BOLD, 28));
		titulo.setForeground(Color.BLUE);
		titulo.setBounds(225, 20, 600, 30);

        panel.add(titulo);
        
        Font fuenteInfo = new Font("Arial", Font.BOLD, 20);
        
        JLabel info = new JLabel(" UBICACIÓN        TIPO             LOTES         "
        						 + "ESTADO       ALERTA");
        info.setFont(fuenteInfo);
        info.setForeground(Color.RED);
        info.setBounds(20, 90, 700, 30);

        panel.add(info);
        
        cultivos.setBackground(Color.DARK_GRAY);
        cultivos.setBounds(20, 120, 750, 400);
        
        panel.add(cultivos);
        
        cultivos.agregarCultivo("Rosa", "A2", 5);
        cultivos.agregarCultivo("Rosa", "E2", 5);
        cultivos.agregarCultivo("Rosa", "B3", 5);
        cultivos.agregarCultivo("Rosa", "A7", 5);
        cultivos.agregarCultivo("Rosa", "D5", 5);
        cultivos.agregarCultivo("Rosa", "D5", 5);
        cultivos.agregarCultivo("Rosa", "D5", 5);
        cultivos.agregarCultivo("Rosa", "D5", 5);
        cultivos.agregarCultivo("Rosa", "D5", 5);
        
        /*
        
        JLabel alerta = new JLabel("ALERTA");
        alerta.setFont(new Font("Arial", Font.BOLD, 24));
        alerta.setForeground(Color.RED);
        alerta.setBounds(540, 160, 200, 20);
        
        panel.add(alerta);
        
        this.fondo1.setEditable(false);
        this.fondo1.setBackground(Color.LIGHT_GRAY);
        this.fondo1.setBounds(45, 90, 300, 350);
        
        panel.add(fondo1);
        
        this.fondo2.setEditable(false);
        this.fondo2.setBackground(Color.LIGHT_GRAY);
        this.fondo2.setBounds(440, 150, 300, 200);
        
        panel.add(fondo2);
        
        */
	}

}
