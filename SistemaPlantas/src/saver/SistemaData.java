package saver;

import java.io.Serializable;
import java.util.ArrayList;

import cultivos.manejo.CultivoControl;
import runner.Fecha;

public class SistemaData implements Serializable {
	
	private Fecha fecha;
	private ArrayList<CultivoControl> cultivos;
	
	public SistemaData() {
		
	}

	public void setFecha(Fecha date) {
		this.fecha = date;
	}

	public Fecha getFecha() {
		return fecha;
	}

	public void setCultivos(ArrayList<CultivoControl> pcultivos) {
		this.cultivos = pcultivos;
	}

	public ArrayList<CultivoControl> getCultivos() {
		return cultivos;
	}

}
