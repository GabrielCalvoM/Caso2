package gui;

import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.util.ArrayList;


public class ListaAlerta extends JLabel {
	
	private JTextField msj;
	private ArrayList<JTextField> alertas = new ArrayList<JTextField>();
	private Font fuenteInfo = new Font("Arial", Font.PLAIN, 16);
	
	public ListaAlerta() {
		super();
		this.msj = new JTextField("Todo está correcto");
		GridLayout grid = new GridLayout();
		setLayout(grid);
		iniciarTexto(msj);
	}
	
	public void agregarAlerta(String sistema, String lugar) {
		if (alertas.size() == 0) {
			this.remove(msj);
		}
			
		JTextField nuevo = new JTextField("Fallo de " + sistema + " en " + lugar);
		alertas.add(nuevo);
		GridLayout grid = new GridLayout(alertas.size(), 1);
		this.setLayout(grid);
		iniciarTexto(nuevo);
	}
	
	public void iniciarTexto(JTextField texto) {
		texto.setFont(fuenteInfo);
        texto.setForeground(Color.BLACK);
        texto.setBackground(Color.GRAY);
        texto.setEditable(false);
        texto.setOpaque(true);
        texto.setHorizontalAlignment(JTextField.CENTER);
        this.add(texto);
	}

}
