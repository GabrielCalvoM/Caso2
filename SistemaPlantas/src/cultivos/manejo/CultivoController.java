package cultivos.manejo;

import cultivos.Campo;
import cultivos.Crecimiento;
import sistemas.enums.Alerta;
import sistemas.enums.Alteracion;
import sistemas.enums.Sist;
import sistemas.manejo.AlertaController;

public class CultivoController {
	
	private AlertaController alerta;
	private Campo cultivo;
	
	public CultivoController(AlertaController palerta, Campo pcultivo) {
		this.alerta = palerta;
		this.cultivo = pcultivo;
	}
	
	public void comprobarAlteración() {
		alerta.comprobarAlteración();
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
	
	public void setEstado(Crecimiento pestado) {
		cultivo.setEstado(pestado);
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
