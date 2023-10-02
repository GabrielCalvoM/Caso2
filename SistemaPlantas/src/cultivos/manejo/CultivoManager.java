package cultivos.manejo;

import cultivos.Campo;
import cultivos.Crecimiento;
import sistemas.enums.Alerta;
import sistemas.enums.Alteracion;
import sistemas.enums.Sist;
import sistemas.manejo.AlertaController;

public class CultivoManager {
	
	private AlertaController alerta;
	private Campo cultivo;
	
	public CultivoManager(AlertaController palerta, Campo pcultivo) {
		this.alerta = palerta;
		this.cultivo = pcultivo;
	}
	
	public void arreglar() {
		alerta.arreglar();
	}
	
	public void comprobarAlteracion() {
		alerta.comprobarAlteracion();
	}
	
	public Alerta getAlerta() {
		return alerta.getAlerta();
	}

	public void incTiempo() {
		cultivo.incTiempo();
	}
	
	public int getTiempo() {
		return cultivo.getTiempo();
	}
	
	public String getLugar() {
		return cultivo.getLugar();
	}
	
	public int getCantidad() {
		return cultivo.getCantidad();
	}
	
	public void crecer() {
		if (cultivo.getTiempo() == cultivo.getDuracion()) {
			cultivo.setEstado(Crecimiento.lista);
		} else if (cultivo.getTiempo() == cultivo.getDuracion()*2/3) {
			cultivo.setEstado(Crecimiento.floreciendo);
		} else if (cultivo.getTiempo() == cultivo.getDuracion()/4) {
			cultivo.setEstado(Crecimiento.creciendo);
		}
	}
	
	public Crecimiento getEstado() {
		return cultivo.getEstado();
	}
	
	public int getDuracion() {
		return cultivo.getDuracion();
	}
	
	public String getTipo() {
		return cultivo.getTipo();
	}
	
}
