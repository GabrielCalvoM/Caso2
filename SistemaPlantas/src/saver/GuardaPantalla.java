package saver;

import java.io.*;
import java.util.ArrayList;

import cultivos.manejo.CultivoControl;
import gui.controlWindow.VentanaControl;
import runner.*;

public class GuardaPantalla {
	
	private static GuardaPantalla instancia;
	private SistemaFuncion sistema;
	private SistemaData datos;
	
	private GuardaPantalla() {
		datos = new SistemaData();
	}
	
	public static GuardaPantalla getInstance() {
		if (instancia == null) {
			instancia = new GuardaPantalla();
		}
		
		return instancia;
	}
	
	public void setSistema(SistemaFuncion psistema) {
		this.sistema = psistema;
	}
	
	public void setFecha(Fecha date) {
		datos.setFecha(date);
	}
	
	public Fecha getFecha() {
		return datos.getFecha();
	}
	
	public void setCultivos(ArrayList<CultivoControl> cultivos) {
		datos.setCultivos(cultivos);
	}
	
	public ArrayList<CultivoControl> getCultivos() {
		return datos.getCultivos();
	}
	
	public void save() throws IOException {
		setFecha(sistema.getFecha());
		setCultivos(sistema.getCultivos());
		
		char separador = File.separatorChar;
		String dir = System.getProperty("user.dir") + separador + "src" + separador + "saver" + separador + "DatosDeGuardado";
		FileOutputStream destino = new FileOutputStream(dir + separador + "Cultivos.txt");
		ObjectOutputStream guardado = new ObjectOutputStream(destino);
		guardado.writeObject(this.datos);
		guardado.close();
	}

	public void load() throws IOException, ClassNotFoundException {
		char separador = File.separatorChar;
		String dir = System.getProperty("user.dir") + separador + "src" + separador + "saver";
		File carpeta = new File(dir + separador + "DatosDeGuardado");
		carpeta.mkdir();
		
		FileInputStream fuente = new FileInputStream(carpeta.getAbsolutePath() + separador + "Cultivos.txt");
		ObjectInputStream guardado = new ObjectInputStream(fuente);
		this.datos = (SistemaData) guardado.readObject();
		guardado.close();
		
		if (datos != null) {
			ArrayList<CultivoControl> cultivos = datos.getCultivos();
			
			if (cultivos != null) {
				for (CultivoControl cultivo : cultivos) {
					this.sistema.registrar(cultivo);
				}
			}
	
			System.out.println(22222222);
			Fecha fecha = datos.getFecha();
			this.sistema.setFecha(fecha);
		}
	}
	
}
