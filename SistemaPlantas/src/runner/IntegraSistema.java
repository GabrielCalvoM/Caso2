package runner;

import java.util.ArrayList;

import cultivos.Crecimiento;
import cultivos.manejo.CultAccion;
import cultivos.manejo.CultivoControl;
import gui.AccionBoton;
import gui.controlWindow.*;
import gui.registroWindow.VentanaRegistro;
import sistemas.enums.Alerta;

public class IntegraSistema extends Thread {
	
	private static VentanaControl control;
	private static VentanaRegistro registro;
	private static CultivoInfo cultivo = null;
	private static AccionBoton accion = AccionBoton.nada;
	
	public IntegraSistema() {
		
	}
	
	public static void setVentanas(VentanaControl pcontrol, VentanaRegistro pregistro) {
		control = pcontrol;
		registro = pregistro;
	}
	
	public static void setAccion(AccionBoton paccion) {
		accion = paccion;
	}

	public static void setCultivo(CultivoInfo pcultivo) {
		cultivo = pcultivo;
	}
	
	public void run() {
		if (accion == AccionBoton.ingresar) {
			CultivoControl cultivo = registro.registrar();
			
			if (cultivo != null) {
				control.ingresarCultivo(cultivo);
			}
		} else if (accion == AccionBoton.alerta) {
			if (cultivo.getCultivo().getAlerta() == Alerta.pendiente) {
				cultivo.getCultivo().executeCult(CultAccion.arreglar);
				cultivo.showAlerta();
			}
		} else if (accion == AccionBoton.cosecha) {
			if (cultivo.getCultivo().getCrecimiento() == Crecimiento.lista) {
				control.cosechar(cultivo);
			}
		} else if (accion == AccionBoton.registrar) {
			registro.setVisible(true);
		}
		
		cultivo = null;
		accion = AccionBoton.nada;
	}

}
