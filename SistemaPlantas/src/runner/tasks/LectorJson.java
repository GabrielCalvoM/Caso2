package runner.tasks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import javax.json.*;

import sistemas.enums.Sist;
import sistemas.enums.SysAccion;

public class LectorJson {
	
	private static LectorJson instancia;
	
	private LectorJson() {
		
	}
	
	public static LectorJson getInstance() {
		if (instancia == null) {
			instancia = new LectorJson();
		}
		
		return instancia;
	}
	
	public ArrayList<Enum[]> getTareas(int hora) throws FileNotFoundException {
		ArrayList<Enum[]> tasks = new ArrayList<Enum[]>();
		String clave = String.valueOf(hora) + ":00";
		char separador = File.separatorChar;
		String dir = System.getProperty("user.dir") + separador + "src" + separador + "runner" + separador + "tasks";
		JsonReader reader = Json.createReader(new FileReader(dir + separador + "Tareas.json"));
		JsonObject json = reader.readObject();
		reader.close();
		
		String acciones[] = new String[] {"encender", "apagar", "alterar"};
		JsonObject lista = json.getJsonObject(clave);
		
		if (lista != null) {
			for (String act : acciones) {
				String sist = lista.getString(act);
				SysAccion accion = SysAccion.valueOf(act);
				Sist sistema = Sist.valueOf(sist);
				
				if (sistema != Sist.none) {
					tasks.add(new Enum[] {accion, sistema});
				}
			}
		}
		
		return tasks;
	}

}
