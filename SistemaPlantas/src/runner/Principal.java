package runner;

import javax.swing.SwingUtilities;

import gui.controlWindow.VentanaControl;
import gui.registroWindow.VentanaRegistro;

public class Principal {
	
	public static void main(String args[]) {
		VentanaControl control = new VentanaControl();
		VentanaRegistro registro = new VentanaRegistro();
		IntegraSistema.setVentanas(control, registro);
		SwingUtilities.invokeLater(() ->{
			control.setVisible(true);
			registro.setVisible(true);
		});
		SistemaFuncion sistema = new SistemaFuncion(control, registro);
		sistema.run();
	}
	
}
