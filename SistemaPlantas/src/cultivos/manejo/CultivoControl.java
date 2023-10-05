package cultivos.manejo;

import java.io.Serializable;

import cultivos.Campo;
import cultivos.Crecimiento;
import sistemas.enums.*;
import sistemas.manejo.*;

public class CultivoControl implements ICultivo, Serializable {
	
	private CultivoManager cultivo;
	private SistemaExec sistemas;
	private int arregloAlerta = 0;
	
	public CultivoControl(Campo pcultivo) {
		SistemaCultivo psistema = new SistemaCultivo();
		cultivo = new CultivoManager(new AlertaController(psistema), pcultivo);
		sistemas = new SistemaExec(psistema);
	}

	@Override
	public void executeCult(CultAccion accion) {
		if (accion == CultAccion.alteracion) {
			cultivo.comprobarAlteracion();
		} else if (accion == CultAccion.arreglar) {
			cultivo.arreglar();
		} else if (accion == CultAccion.crecer) {
			Alerta alerta = cultivo.getAlerta();
			
			if (alerta == Alerta.nada) {
				executeSys(SysAccion.consumir, Sist.all);
				cultivo.incTiempo();
				cultivo.crecer();
			} else {
				if (alerta != Alerta.pendiente) {
					if (arregloAlerta < 3) {
						arregloAlerta++;
					} else {
						executeSys(SysAccion.arreglar, Sist.all);
						arregloAlerta = 0;
					}
				}
			}
		}
	}
	
	@Override
	public int getInt(CultAccion accion) {
		int num = 0;
		
		if (accion == CultAccion.gCant) {
			num = cultivo.getCantidad();
		} else if (accion == CultAccion.gDuracion) {
			num = cultivo.getDuracion();
		}else if (accion == CultAccion.gTiempo) {
			num = cultivo.getTiempo();
		}

		return num;
	}

	@Override
	public String getString(CultAccion accion) {
		String str = "";
		
		if (accion == CultAccion.gTipo) {
			str = cultivo.getTipo();
		} else if (accion == CultAccion.gLugar) {
			str = cultivo.getLugar();
		}
		
		return str;
	}

	public Alerta getAlerta() {
		return cultivo.getAlerta();
	}
	
	public Crecimiento getCrecimiento() {
		return cultivo.getEstado();
	}

	public void executeSys(SysAccion accion, Sist sistema) {
		if (accion != SysAccion.consumir) {
			if (accion != SysAccion.alterar || cultivo.getAlerta() == Alerta.nada) {
				if (sistema != Sist.all) {
					sistemas.executeSys(accion, sistema);
				} else {
					sistemas.executeSys(accion, Sist.abono);
					sistemas.executeSys(accion, Sist.riego);
				}
			}
		} else {
			if (sistema != Sist.all) {
				sistemas.executeSys(accion, sistema, cultivo.getCantidad());
			} else {
				sistemas.executeSys(accion, Sist.abono, cultivo.getCantidad());
				sistemas.executeSys(accion, Sist.riego, cultivo.getCantidad());
			}
		}
	}

	public Estado getEstado(Sist sistema) {
		return sistemas.getEstado(sistema);
	}

	public Alteracion getAlteracion(Sist sistema) {
		return sistemas.getAlteracion(sistema);
	}


}
