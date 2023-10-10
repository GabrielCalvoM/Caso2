package runner;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import cultivos.manejo.*;
import gui.controlWindow.CultivoInfo;
import gui.controlWindow.VentanaControl;
import gui.registroWindow.*;
import runner.tasks.LectorJson;
import saver.GuardaPantalla;
import saver.Historiador;
import sistemas.enums.Sist;
import sistemas.enums.SysAccion;

public class SistemaFuncion extends Thread {
	
	private VentanaControl control;
	private VentanaRegistro registro;
	private IntegraCultivo listaCultivos;
	private Fecha tiempo;
	
	public SistemaFuncion(VentanaControl pcontrol, VentanaRegistro pregistro, IntegraCultivo pcultivo) {
		this.control = pcontrol;
		this.registro = pregistro;
		this.listaCultivos = pcultivo;
	}
	
	public void setFecha(Fecha fecha) {
		this.tiempo = fecha;
	}
	
	public Fecha getFecha() {
		return tiempo;
	}
	
	public VentanaControl getControl() {
		return control;
	}
	
	public VentanaRegistro getRegistro() {
		return registro;
	}
	
	public void registrar(CultivoControl cultivo) {
		control.ingresarCultivo(cultivo);
		listaCultivos.addCultivo(cultivo);
	}
	
	public void cosechar(CultivoInfo cultivo) {
		control.cosechar(cultivo);
		listaCultivos.rmvCultivo(cultivo.getCultivo());
	}
	
	public ArrayList<CultivoControl> getCultivos(){
		return listaCultivos.getLista();
	}
	
	public void run() {
		ArrayList<CultivoControl> cultivos;
		
		if (tiempo == null) {
			tiempo = new Fecha();
		}
		
		while(true) {
			control.actualizarHora(tiempo);
			cultivos = listaCultivos.getLista();
			ArrayList<Enum[]> tareas = new ArrayList<Enum[]>();
			
			try {
				tareas = LectorJson.getInstance().getTareas(tiempo.getHour());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			for (CultivoControl cultivo : cultivos) {
				cultivo.executeCult(CultAccion.crecer);
				cultivo.executeCult(CultAccion.alteracion);
				
				for (Enum[] tarea : tareas) {
					cultivo.executeSys((SysAccion) tarea[0], (Sist) tarea[1]);
				}
			}
			
			for (int i = 0; i < control.cantCultivos(); i++) {
				control.actualizarInfo(i);
			}
			
			if (tiempo.getHour() == 0) {
				GuardaPantalla datos = GuardaPantalla.getInstance();
				datos.setCultivos(cultivos);
				datos.setFecha(tiempo);
				
				try {
					datos.save();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
				
			try {
				tiempo.avanzarTiempo();
				Thread.sleep(3000);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}

}
