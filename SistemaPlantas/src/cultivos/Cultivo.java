package cultivos;

public class Cultivo {
	
	private String tipo;
	private Crecimiento estado;
	private int duracion;
	
	public Cultivo(String ptipo) {
		this.tipo = ptipo;
		this.estado = Crecimiento.brotando;
		this.duracion = 36;
	}
	
	public void setEstado(Crecimiento pestado) {
		this.estado = pestado;
	}
	
	public Crecimiento getEstado() {
		return estado;
	}
	
	public int getDuracion() {
		return duracion;
	}

	public String getTipo() {
		return tipo;
	}
	
}
