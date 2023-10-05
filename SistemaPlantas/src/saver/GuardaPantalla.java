package saver;

import java.io.*;
import java.util.ArrayList;

import cultivos.manejo.CultivoControl;
import gui.controlWindow.VentanaControl;
import runner.*;

public class GuardaPantalla {
	
	private static GuardaPantalla instancia;
	private SistemaFuncion sistema;
	private VentanaControl ventana;
	private SistemaData datos;
	
	
	private GuardaPantalla() {
		
	}
	
	public static GuardaPantalla getInstance() {
		if (instancia == null) {
			instancia = new GuardaPantalla();
		}
		
		return instancia;
	}
	
	public void setSistema(SistemaFuncion psistema, VentanaControl pventana) {
		this.sistema = psistema;
		this.ventana = pventana;
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
	
	public File existeArchivo(String nameCarpeta, String arch) {
		File carpeta = existeCarpeta(nameCarpeta);
		File existe = null;
		
		if (carpeta != null) {
			String dir = System.getProperty("use.dir");
			File[] archivos = new File(dir).listFiles();
			
			for(File archivo : archivos) {
				if (existe == null) {
					if (archivo.isDirectory()) {
						existe = existeArchivo(nameCarpeta, arch);
					} else {
						if (archivo.getName() == arch) {
							existe = archivo;
						}
					}
				}
			}
		}
		
		return existe;
	}
	
	public File existeCarpeta(String arch) {
		File[] carpeta = new File("user.dir").listFiles();
		File existe = null;
		
		for(File archivo : carpeta) {
			if (existe == null) {
				if (archivo.isDirectory()) {
					if (archivo.getName() == arch) {
						existe = archivo;
					} else {
						existe = existeCarpeta(arch);
					}
				}
			}
		}
		
		return existe;
	}
	
	public void save() throws IOException {
		File carpeta = existeCarpeta("DatosDeGuardado");
		
		if (carpeta == null) {
			carpeta = new File(System.getProperty("use.dir") + "/DatosDeGuardado");
			carpeta.mkdir();
		}
		
		File archivo = existeArchivo("DatosDeGuardado", "/Cultivos.txt");
		
		if (archivo == null) {
			archivo = new File(carpeta.getPath() + "/Cultivos.txt");
			archivo.createNewFile();
		}
		
		FileOutputStream destino = new FileOutputStream(archivo);
		ObjectOutputStream guardado = new ObjectOutputStream(destino);
		guardado.writeObject(this.datos);
		guardado.close();
	}

	public void load() throws IOException, ClassNotFoundException {
		File archivo = existeArchivo("DatosDeGuardado", "Cultivos.txt");
		
		if (archivo != null) {
			FileInputStream destino = new FileInputStream(archivo);
			ObjectInputStream guardado = new ObjectInputStream(destino);
			this.datos = (SistemaData) guardado.readObject();
			guardado.close();
			
			ArrayList<CultivoControl> cultivos = datos.getCultivos();
			
			for (CultivoControl cultivo : cultivos) {
				this.ventana.ingresarCultivo(cultivo);
			}
			
			Fecha fecha = datos.getFecha();
			this.sistema.setFecha(fecha);
		}
		
	}
	
}
