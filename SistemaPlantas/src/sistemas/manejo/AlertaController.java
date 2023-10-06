package sistemas.manejo;

import java.io.Serializable;

import sistemas.enums.*;

public class AlertaController implements Serializable {
	
	private SistemaCultivo sistemas;
	private Alerta alerta = Alerta.nada;
	
	public AlertaController() {
		sistemas = new SistemaCultivo();
	}
	
	public AlertaController(SistemaCultivo psistema) {
		this.sistemas = psistema;
	}
	
	public void arreglar() {
		if (alerta == Alerta.pendiente) {
			alerta = Alerta.nada;
		}
	}
	
	public void comprobarAlteracion() {
		if (sistemas.getAlteracion(Sist.riego) != Alteracion.funcionando) {
			alerta = Alerta.riego;
		} else if (sistemas.getAlteracion(Sist.abono) != Alteracion.funcionando) {
			alerta = Alerta.abono;
		} else {
			if (alerta != Alerta.nada) {
				alerta = Alerta.pendiente;
			}
		}
	}
	
	public Alerta getAlerta() {
		return alerta;
	}

}
