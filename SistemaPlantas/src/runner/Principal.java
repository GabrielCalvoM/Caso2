package runner;

import java.io.IOException;

import javax.swing.SwingUtilities;

import gui.controlWindow.VentanaControl;
import gui.registroWindow.VentanaRegistro;
import saver.GuardaPantalla;

public class Principal {
	
	public static void main(String args[]) {
		VentanaControl control = new VentanaControl();
		VentanaRegistro registro = new VentanaRegistro();
		IntegraSistema.getInstance().setVentanas(control, registro);
		SwingUtilities.invokeLater(() ->{
			control.setVisible(true);
			registro.setVisible(true);
		});
		SistemaFuncion sistema = new SistemaFuncion(control, registro);
		GuardaPantalla saver = GuardaPantalla.getInstance();
		saver.setSistema(sistema, control);
		
		try {
			saver.load();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sistema.run();
	}
	
}
