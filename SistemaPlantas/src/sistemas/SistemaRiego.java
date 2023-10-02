package sistemas;

import sistemas.enums.*;

public class SistemaRiego extends Sistema {
	
	private int agua;
	
	public SistemaRiego() {
		super();
		this.agua = 100;
	}
	
	public void consumir(int consumo) {
		if (this.alteracion == Alteracion.funcionando && this.estado == Estado.encendido) {
			this.agua -= consumo;
		}
		
		if (agua <= 0) {
			this.alteracion = Alteracion.agotado;
		}
	}
	
	public void reponer(int repo) {
		this.agua += repo;
		if (agua > this.max) {
			agua = max;
		}
	}
	
}
