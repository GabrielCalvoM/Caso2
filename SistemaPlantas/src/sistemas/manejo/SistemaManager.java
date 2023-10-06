package sistemas.manejo;

import java.io.Serializable;

import sistemas.enums.*;

public class SistemaManager implements Serializable {
	
	private SistemaCultivo sistemas;
	
	public SistemaManager() {
		sistemas = new SistemaCultivo();
	}
	
	public SistemaManager(SistemaCultivo psistema) {
		this.sistemas = psistema;
	}
	
	public void encender(Sist sistema) {
		this.sistemas.setEstado(sistema, Estado.encendido);
	}
	
	public void apagar(Sist sistema) {
		this.sistemas.setEstado(sistema, Estado.encendido);
	}
	
	public Estado getEstado(Sist sistema) {
		return this.sistemas.getEstado(sistema);
	}
	
	public void alterar(Sist sistema) {
		this.sistemas.setAlteracion(sistema, Alteracion.fallando);
	}
	
	public void arreglar(Sist sistema) {
		this.sistemas.setAlteracion(sistema, Alteracion.funcionando);
		reponer(sistema);
	}
	
	public Alteracion getAlteracion(Sist sistema) {
		return this.sistemas.getAlteracion(sistema);
	}
	
	public void consumir(Sist sistema, int cantidad) {
		this.sistemas.consumir(sistema, cantidad);
	}
	
	public void reponer(Sist sistema) {
		this.sistemas.reponer(sistema, 100);
	}

}
