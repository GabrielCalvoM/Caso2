package runner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.swing.SwingUtilities;

import cultivos.manejo.CultAccion;
import cultivos.manejo.CultivoControl;
import gui.AccionBoton;
import gui.controlWindow.VentanaControl;
import gui.registroWindow.*;
import saver.GuardaPantalla;
import sistemas.enums.Sist;
import sistemas.enums.SysAccion;

public class SistemaFuncion extends Thread {
	
	private VentanaControl control;
	private VentanaRegistro registro;
	private Fecha tiempo;
	
	public SistemaFuncion(VentanaControl pcontrol, VentanaRegistro pregistro) {
		control = pcontrol;
		registro = pregistro;
		tiempo = new Fecha();
	}
	
	public void setFecha(Fecha fecha) {
		this.tiempo = fecha;
	}
	
	public void registrar(CultivoControl cultivo) {
		control.ingresarCultivo(cultivo);
	}
	
	public ArrayList<CultivoControl> getCultivos(){
		return control.getCultivos();
	}
	
	public void run() {
		ArrayList<CultivoControl> cultivos;
		
		while(true) {
			control.actualizarHora(tiempo);
			cultivos = control.getCultivos();
			
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
			
			try {
				GuardaPantalla.getInstance().save();
				Thread.sleep(3000);
				tiempo.avanzarTiempo();
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

}
