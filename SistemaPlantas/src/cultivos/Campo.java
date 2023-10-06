package cultivos;

import java.io.Serializable;

public class Campo implements Serializable {
	
	private Cultivo cultivo;
	private int cantidad;
	private int tiempo;
	private String ubicacion;
	
	public Campo(Cultivo pcultivo, int lotes, String lugar) {
		this.cultivo = pcultivo;
		this.cantidad = lotes;
		this.ubicacion = lugar;
		this.tiempo = 0;
	}
	
	public void incTiempo() {
		tiempo += 1;
	}
	
	public int getTiempo() {
		return tiempo;
	}
	
	public String getLugar() {
		return ubicacion;
	}
	
	public int getCantidad() {
		return cantidad;
	}

	public int getDuracion() {
		return cultivo.getDuracion();
	}
	
	public void setEstado(Crecimiento pestado) {
		cultivo.setEstado(pestado);
	}
	
	public Crecimiento getEstado() {
		return cultivo.getEstado();
	}
	
	public String getTipo() {
		return cultivo.getTipo();
	}
	
}
