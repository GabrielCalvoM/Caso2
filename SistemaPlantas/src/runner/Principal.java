package runner;

import java.io.IOException;
import javax.swing.SwingUtilities;

import cultivos.manejo.IntegraCultivo;
import gui.controlWindow.VentanaControl;
import gui.registroWindow.VentanaRegistro;
import saver.GuardaPantalla;

public class Principal {
	
	public static void main(String args[]) {
		VentanaControl control = new VentanaControl();
		VentanaRegistro registro = new VentanaRegistro();
		IntegraSistema.getInstance().setVentanas(registro);
		SwingUtilities.invokeLater(() ->{
			control.setVisible(true);
			registro.setVisible(true);
		});
		IntegraCultivo cultivos = new IntegraCultivo();
		SistemaFuncion sistema = new SistemaFuncion(control, registro, cultivos);
		IntegraSistema.getInstance().setSistema(sistema);
		GuardaPantalla saver = GuardaPantalla.getInstance();
		saver.setSistema(sistema);
		
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
