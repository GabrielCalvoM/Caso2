package gui.registroWindow;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;

public class BotonRegistro extends JButton {
	
	OpcionRegistro contenedor;
	
	public BotonRegistro(OpcionRegistro padre, Color color, String texto) {
		super(texto);
		
		contenedor = padre;
		this.setBackground(color);
		this.addActionListener(e -> accion());
	}
	
	public String getNombre() {
		return this.getText();
	}
	
	public void accion() {
		contenedor.setVisible(false);
		contenedor.seleccionar(this.getNombre());
	}

}
