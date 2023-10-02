package sistemas.manejo;

import sistemas.enums.*;

public class SistemaManager {
	
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
	}
	
	public Alteracion getAlteracion(Sist sistema) {
		return this.sistemas.getAlteracion(sistema);
	}
	
	public void consumir(Sist sistema) {
		this.sistemas.consumir(sistema, 1);
	}
	
	public void reponer(Sist sistema) {
		this.sistemas.reponer(sistema, 100);
	}

}
