package gui;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;

public class BotonControl extends JButton {
	
	private AccionBoton accion;
	
	public BotonControl(AccionBoton paccion, Color color, String texto) {
		super(texto);
		
		this.accion = paccion;
		this.setBackground(color);
		this.setPreferredSize(new Dimension(50, 20));
	}
	
	public AccionBoton getAccion() {
		return accion;
	}

}
