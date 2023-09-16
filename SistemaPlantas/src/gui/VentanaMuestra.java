package gui;

import javax.swing.*;
import java.awt.*;

public class VentanaMuestra extends JFrame {
	
	private JTextArea fondo1 = new JTextArea();
	private JTextArea fondo2 = new JTextArea();
	private JTextArea info1;
	private JTextArea info2;
	private JTextArea info3;
	private JTextArea msjAlerta;
	
	public VentanaMuestra() {
		setTitle("Sistema de Plantas");
		setSize(800, 600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		setLocation(40, 60);
		
		Container panel = getContentPane();
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);
		
		JLabel titulo = new JLabel("ZONA DE OBSERVACIÓN");
		titulo.setFont(new Font("Arial", Font.BOLD, 28));
		titulo.setForeground(Color.BLUE);
		titulo.setBounds(225, 20, 600, 30);

        panel.add(titulo);
        
        Font fuenteCultivo = new Font("Arial", Font.BOLD, 20);
        
        JLabel cultivo1 = new JLabel("Cultivo 1:");
        cultivo1.setFont(fuenteCultivo);
        cultivo1.setForeground(Color.BLUE);
        cultivo1.setBounds(50, 100, 200, 20);
        
        panel.add(cultivo1);

        JLabel cultivo2 = new JLabel("Cultivo 2:");
        cultivo2.setFont(fuenteCultivo);
        cultivo2.setForeground(Color.BLUE);
        cultivo2.setBounds(50, 200, 200, 20);
        
        panel.add(cultivo2);

        JLabel cultivo3 = new JLabel("Cultivo 3:");
        cultivo3.setFont(fuenteCultivo);
        cultivo3.setForeground(Color.BLUE);
        cultivo3.setBounds(50, 300, 200, 20);
        
        panel.add(cultivo3);
        
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
	}
	
	public void mostrarInfo(String plantas1, String plantas2, String plantas3) {
		Font fuenteInfo = new Font("Arial", Font.PLAIN, 16);
		Container panel = getContentPane();
		
		panel.remove(this.fondo1);
		
		this.info1 = new JTextArea("Tipo de Planta:\n" + "Número de Lotes:\n" + "Estado:");
        this.info1.setFont(fuenteInfo);
        this.info1.setForeground(Color.BLACK);
        this.info1.setEditable(false);
        this.info1.setOpaque(false);
        this.info1.setBounds(70, 130, 200, 60);
        
        this.info2 = new JTextArea("Tipo de Planta:\n" + "Número de Lotes:\n" + "Estado:");
        this.info2.setFont(fuenteInfo);
        this.info2.setForeground(Color.BLACK);
        this.info2.setEditable(false);
        this.info2.setOpaque(false);
        this.info2.setBounds(70, 230, 200, 60);
        
        this.info3 = new JTextArea("Tipo de Planta: \n" + "Número de Lotes: \n" + "Estado:");
        this.info3.setFont(fuenteInfo);
        this.info3.setForeground(Color.BLACK);
        this.info3.setEditable(false);
        this.info3.setOpaque(false);
        this.info3.setBounds(70, 330, 200, 60);
        
        panel.add(info1);
        panel.add(info2);
        panel.add(info3);
        panel.add(this.fondo1);
	}
	
	public void setAlerta() {
		Font fuenteAlerta = new Font("Arial", Font.PLAIN, 20);
		Container panel = getContentPane();
		
		panel.remove(this.fondo2);
		
		this.msjAlerta = new JTextArea("No hay problemas en \n" + "         el sistema");
        this.msjAlerta.setFont(fuenteAlerta);
        this.msjAlerta.setForeground(Color.BLACK);
        this.msjAlerta.setEditable(false);
        this.msjAlerta.setOpaque(false);
        this.msjAlerta.setBounds(485, 190, 400, 200);
        
        panel.add(this.msjAlerta);
        panel.add(this.fondo2);
	}

}
