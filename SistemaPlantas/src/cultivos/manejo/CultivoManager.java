package cultivos.manejo;

import cultivos.Campo;
import sistemas.manejo.*;

public class CultivoManager {
	
	private CultivoController cultivo;
	private SistemaExec sistemas;
	
	public CultivoManager(Campo pcultivo) {
		SistemaCultivo psistema = new SistemaCultivo();
		cultivo = new CultivoController(new AlertaController(psistema), pcultivo);
		sistemas = new SistemaExec(psistema);
	}
	
	

}
