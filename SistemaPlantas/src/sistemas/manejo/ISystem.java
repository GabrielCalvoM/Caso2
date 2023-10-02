package sistemas.manejo;

import sistemas.enums.*;

public interface ISystem {
	
	void executeSys(SysAccion accion, Sist sistema);
	void executeSys(SysAccion accion, Sist sistema, int cant);

}
