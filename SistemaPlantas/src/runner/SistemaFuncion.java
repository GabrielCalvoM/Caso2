package runner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import cultivos.manejo.*;
import gui.controlWindow.CultivoInfo;
import gui.controlWindow.VentanaControl;
import gui.registroWindow.*;
import saver.GuardaPantalla;
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
		listaCultivos.addCultivo(cultivo.getCultivo());
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
			
			for (CultivoControl cultivo : cultivos) {
				cultivo.executeCult(CultAccion.crecer);
				cultivo.executeCult(CultAccion.alteracion);
				
				if (tiempo.getHour()%12 == 2) {
					cultivo.executeSys(SysAccion.encender, Sist.all);
				}
				
				if (tiempo.getHour()%12 == 4) {
					cultivo.executeSys(SysAccion.apagar, Sist.abono);
				}

				if (tiempo.getHour()%12 == 8) {
					cultivo.executeSys(SysAccion.apagar, Sist.riego);
				}
			}
			
			Random randomizer = new Random();
			int alt;
			
			for(CultivoControl cultivo : cultivos) {
				alt = randomizer.nextInt(9);
				if (alt%9 == 1) {
					cultivo.executeSys(SysAccion.alterar, Sist.abono);
				} else if (alt%9== 4) {
					cultivo.executeSys(SysAccion.alterar, Sist.riego);
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
