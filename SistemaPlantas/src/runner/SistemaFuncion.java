package runner;

import java.util.ArrayList;

import cultivos.Campo;
import gui.controlWindow.VentanaControl;
import gui.registroWindow.*;

public class SistemaFuncion {
	
	private VentanaControl control;
	private VentanaRegistro registro;
	private ArrayList<Campo> cultivos;
	
	public SistemaFuncion() {
		control = new VentanaControl(this);
		control.setVisible(true);
		registro = new VentanaRegistro(this);
		registro.setVisible(true);
		
		cultivos = new ArrayList<Campo>();
	}
	
	public void registrar(Campo cultivo) {
		cultivos.add(cultivo);
		control.ingresarCultivo(cultivo);
	}

}
