package sistemas.manejo;

import java.io.Serializable;
import java.util.ArrayList;

import sistemas.*;
import sistemas.enums.*;

public class SistemaCultivo implements Serializable {
	
	private ArrayList<Sistema> sistemas = new ArrayList<Sistema>();
	
	public SistemaCultivo() {
		this.sistemas.add(new SistemaRiego());
		this.sistemas.add(new SistemaAbono());
	}
	
	public void setEstado(Sist sistema, Estado pestado) {
		if (sistema == Sist.riego) {
			sistemas.get(0).setEstado(pestado);
		} else if (sistema == Sist.abono) {
			sistemas.get(1).setEstado(pestado);
		}
	}
	
	public Estado getEstado(Sist sistema) {
		Estado estado = Estado.apagado;
		
		if (sistema == Sist.riego) {
			estado = sistemas.get(0).getEstado();
		} else if (sistema == Sist.abono) {
			estado =sistemas.get(1).getEstado();
		}
		
		return estado;
	}
	
	public void setAlteracion(Sist sistema, Alteracion palt) {
		if (sistema == Sist.riego) {
			sistemas.get(0).setAlteracion(palt);
		} else if (sistema == Sist.abono) {
			sistemas.get(1).setAlteracion(palt);
		}
	}
	
	public Alteracion getAlteracion(Sist sistema) {
		Alteracion alt = Alteracion.funcionando;
		
		if (sistema == Sist.riego) {
			alt = sistemas.get(0).getAlteracion();
		} else if (sistema == Sist.abono) {
			alt = sistemas.get(1).getAlteracion();
		}
		
		return alt;
	}
	
	public void consumir(Sist sistema, int consumo) {
		if (sistema == Sist.riego) {
			sistemas.get(0).consumir(consumo);
		} else if (sistema == Sist.abono) {
			sistemas.get(1).consumir(consumo);
		}
	}

	public void reponer(Sist sistema, int repo) {
		if (sistema == Sist.riego) {
			sistemas.get(0).reponer(repo);
		} else if (sistema == Sist.abono) {
			sistemas.get(1).reponer(repo);
		}
	}

}
