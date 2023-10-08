package cultivos.manejo;

import java.util.ArrayList;

public class IntegraCultivo {
	
	private ArrayList<CultivoControl> cultivos;
	
	public IntegraCultivo() {
		cultivos = new ArrayList<CultivoControl>();
	}
	
	public void addCultivo(CultivoControl pcultivo) {
		cultivos.add(pcultivo);
	}
	
	public void rmvCultivo(CultivoControl pcultivo) {
		cultivos.remove(pcultivo);
	}
	
	public CultivoControl getCultivo(int i) {
		return cultivos.get(i);
	}
	
	public ArrayList<CultivoControl> getLista() {
		return cultivos;
	}

}
