package runner;

import java.io.IOException;
import java.util.ArrayList;

import cultivos.Crecimiento;
import cultivos.manejo.CultAccion;
import cultivos.manejo.CultivoControl;
import gui.AccionBoton;
import gui.controlWindow.*;
import gui.registroWindow.VentanaRegistro;
import saver.GuardaPantalla;
import sistemas.enums.Alerta;

public class IntegraSistema extends Thread {
	
	private static IntegraSistema instancia;
	private VentanaControl control;
	private VentanaRegistro registro;
	private CultivoInfo cultivo = null;
	private AccionBoton accion = AccionBoton.nada;
	
	private IntegraSistema() {
		
	}
	
	public static IntegraSistema getInstance() {
		if (instancia == null) {
			instancia = new IntegraSistema();
		}
		
		return instancia;
	}
	
	public void setVentanas(VentanaControl pcontrol, VentanaRegistro pregistro) {
		control = pcontrol;
		registro = pregistro;
	}
	
	public void setAccion(AccionBoton paccion) {
		accion = paccion;
	}

	public void setCultivo(CultivoInfo pcultivo) {
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
		} else if (accion == AccionBoton.guardar) {
			try {
				GuardaPantalla.getInstance().save();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		cultivo = null;
		accion = AccionBoton.nada;
	}

}
