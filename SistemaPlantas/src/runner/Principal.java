package runner;

import gui.*;
import javax.swing.SwingUtilities;

public class Principal {
	
	public static void main(String args[]) {
		SwingUtilities.invokeLater(() ->{
			VentanaControl controlador = new VentanaControl();
			controlador.setVisible(true);
			VentanaMuestra contexto = new VentanaMuestra();
			contexto.setVisible(true);
			contexto.mostrarInfo("", "", "");
			contexto.setAlerta();
			VentanaRegistro registro = new VentanaRegistro();
			registro.setVisible(true);
		});
	}
	
}
