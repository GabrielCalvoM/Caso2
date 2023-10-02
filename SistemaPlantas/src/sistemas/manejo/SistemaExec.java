package sistemas.manejo;

import sistemas.enums.Sist;
import sistemas.enums.SysAccion;

public class SistemaExec implements ISystem {
	
	private SistemaManager sistemas;
	
	public SistemaExec(SistemaCultivo psistema) {
		this.sistemas = new SistemaManager(psistema);
	}

	@Override
	public void executeSys(SysAccion accion, Sist sistema) {
		if (accion == SysAccion.encender) {
			this.sistemas.encender(sistema);
		}
		
		if (accion == SysAccion.apagar) {
			this.sistemas.apagar(sistema);
		}
		
		if (accion == SysAccion.alterar) {
			this.sistemas.alterar(sistema);
		}
		
		if (accion == SysAccion.arreglar) {
			this.sistemas.arreglar(sistema);
		}
		
		if (accion == SysAccion.reponer) {
			this.sistemas.reponer(sistema);
		}
	}

	@Override
	public void executeSys(SysAccion accion, Sist sistema, int cant) {
		if (accion == SysAccion.encender) {
			this.sistemas.consumir(sistema, cant);
		} 
	}

}
