package cultivos;

public class Campo {
	
	private Cultivo cultivo;
	private int cantidad;
	private int duracion;
	private String ubicacion;
	
	public Campo(Cultivo pcultivo, int lotes, String lugar) {
		this.cultivo = pcultivo;
		this.cantidad = lotes;
		this.ubicacion = lugar;
		this.duracion = 0;
	}
	
	public void avanzarTiempo() {
		duracion += 1;
		int tiempo = cultivo.getTiempo();
		
		if (duracion == tiempo) {
			cultivo.crecer(Crecimiento.lista);
		} else if (duracion == tiempo*2/3) {
			cultivo.crecer(Crecimiento.floreciendo);
		} else if (duracion == tiempo/4) {
			cultivo.crecer(Crecimiento.creciendo);
		}
	}
	
	public Crecimiento getEstado() {
		return cultivo.getEstado();
	}
	
	public int getTiempo() {
		return cultivo.getTiempo();
	}
	
	public String getTipo() {
		return cultivo.getTipo();
	}
	
	public String getLugar() {
		return ubicacion;
	}
	
	public int getCantidad() {
		return cantidad;
	}

}
