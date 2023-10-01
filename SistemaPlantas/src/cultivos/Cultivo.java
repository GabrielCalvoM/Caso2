package cultivos;

public class Cultivo {
	
	private String tipo;
	private Crecimiento estado;
	private int tiempo;
	
	public Cultivo(String ptipo) {
		this.tipo = ptipo;
		this.estado = Crecimiento.brotando;
		this.tiempo = 36;
	}
	
	public void crecer(Crecimiento pestado) {
		this.estado = pestado;
	}
	
	public Crecimiento getEstado() {
		return estado;
	}
	
	public int getTiempo() {
		return tiempo;
	}

	public String getTipo() {
		return tipo;
	}
	
}
