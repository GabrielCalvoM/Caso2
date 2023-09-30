package runner;

import gui.controlWindow.VentanaControl;
import gui.registroWindow.VentanaRegistro;

import javax.swing.SwingUtilities;

public class Principal {
	
	public static void main(String args[]) {
		SwingUtilities.invokeLater(() ->{
			VentanaControl contexto = new VentanaControl();
			contexto.setVisible(true);
			VentanaRegistro registro = new VentanaRegistro();
			registro.setVisible(true);
		});
	}
	
}
