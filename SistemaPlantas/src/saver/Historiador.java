package saver;

import java.io.*;
import java.util.*;
import javax.json.*;
import javax.json.stream.JsonGenerator;

import cultivos.manejo.CultAccion;
import cultivos.manejo.CultivoControl;
import runner.Fecha;

public class Historiador {
	
	private static Historiador instancia;
	private JsonWriterFactory writer;
	
	private Historiador() {
		Map<String, Boolean> config = new HashMap<>();
        config.put(JsonGenerator.PRETTY_PRINTING, true);
        writer = Json.createWriterFactory(config);
	}
	
	public static Historiador getInstance() {
		if (instancia == null) {
			instancia = new Historiador();
		}
		
		return instancia;
	}
	
	public void guardar(CultivoControl pcultivo, Fecha fecha, Boolean plantado) {
		char separador = File.separatorChar;
		String dir = System.getProperty("user.dir") + separador + "src" + separador + "saver";
		File carpeta = new File(dir + separador + "DatosDeGuardado");
		carpeta.mkdir();
		JsonReader source;
		JsonObject json = null;
		
		try {
			source = Json.createReader(new FileReader(carpeta.getAbsolutePath() + separador + "Historial.json"));
			json = source.readObject();
			source.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		if (json == null) {
			json = Json.createObjectBuilder()
				.add("Plantación", Json.createArrayBuilder().build())
				.add("Cosecha", Json.createArrayBuilder().build())
				.build();
		}
		
		JsonObjectBuilder cultivo = Json.createObjectBuilder();
		cultivo.add("Ubicación", pcultivo.getString(CultAccion.gLugar));
		cultivo.add("Nombre", pcultivo.getString(CultAccion.gTipo));
		cultivo.add("Cantidad", String.valueOf(pcultivo.getInt(CultAccion.gCant)));
		cultivo.add("Fecha", Json.createArrayBuilder()
								.add(String.valueOf(fecha.getYear()))
								.add(String.valueOf(fecha.getMonth()))
								.add(String.valueOf(fecha.getDay()))
								.add(String.valueOf(fecha.getHour()))
								.build());
		
		JsonObjectBuilder historial = Json.createObjectBuilder(json);
		JsonArrayBuilder plantacion = Json.createArrayBuilder(json.getJsonArray("Plantación"));
		JsonArrayBuilder cosecha = Json.createArrayBuilder(json.getJsonArray("Cosecha"));
		
		if (plantado) {
			plantacion.add(cultivo.build());
		} else {
			cosecha.add(cultivo.build());
		}
		
		historial.add("Plantación", plantacion.build());
		historial.add("Cosecha", cosecha.build());
		
		JsonWriter destino;
		try {
			destino = writer.createWriter(new FileWriter(carpeta.getAbsolutePath() + separador + "Historial.json"));
			destino.writeObject(historial.build());
			destino.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
