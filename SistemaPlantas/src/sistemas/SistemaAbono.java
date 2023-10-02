package sistemas;

import sistemas.enums.*;

public class SistemaAbono extends Sistema {

	private int alimento;
	
	public SistemaAbono() {
		super();
		this.alimento = 100;
	}
	
	public void consumir(int consumo) {
		if (this.alteracion == Alteracion.funcionando && this.estado == Estado.encendido) {
			this.alimento -= consumo;
		}
		
		if (alimento <= 0) {
			this.alteracion = Alteracion.agotado;
		}
	}
	
	public void reponer(int repo) {
		this.alimento += repo;
		if (alimento > this.max) {
			alimento = max;
		}
	}
	
}
