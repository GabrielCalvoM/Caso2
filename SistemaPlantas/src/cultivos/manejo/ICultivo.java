package cultivos.manejo;

public interface ICultivo {
	
	void executeCult(CultAccion accion);
	int getInt(CultAccion accion);
	String getString(CultAccion accion);

}
