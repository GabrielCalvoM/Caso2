package sistemas;

import java.io.Serializable;

import sistemas.enums.*;

public abstract class Sistema implements Serializable {
	
	protected Estado estado;
	protected Alteracion alteracion;
	protected final int max;
	
	public Sistema() {
		this.estado = Estado.apagado;
		this.alteracion = Alteracion.funcionando;
		this.max = 100;
	}
	
	public abstract void consumir(int consumo);
	public abstract void reponer(int repo); 
	
	public void setEstado(Estado pestado) {
		this.estado = pestado;
	}
	
	public Estado getEstado() {
		return estado;
	}
	
	public void setAlteracion(Alteracion palt) {
		this.alteracion = palt;
	}

	public Alteracion getAlteracion() {
		return alteracion;
	}
	
}
