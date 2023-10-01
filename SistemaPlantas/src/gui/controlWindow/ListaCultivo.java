package gui.controlWindow;

import java.awt.*;

import javax.swing.JLabel;
import java.util.ArrayList;

public class ListaCultivo extends JLabel {

	private VentanaControl ventana;
	private ArrayList<CultivoInfo> cultivos = new ArrayList<CultivoInfo>();
	
	public ListaCultivo(VentanaControl padre) {
		super();
        this.setBackground(Color.GRAY);
        this.setText("    No hay cultivos tabajando");
        this.setFont(new Font("Arial", Font.BOLD, 50));
        
		this.ventana = padre;
	}
	
	public void agregarCultivo(String tipo, String ubicacion, int cantidad) {
		CultivoInfo nuevo = new CultivoInfo(tipo, ubicacion, cantidad, ventana);
		cultivos.add(nuevo);
		GridLayout grid = new GridLayout(cultivos.size(), 1);
		this.setLayout(grid);
		this.add(nuevo);
	}
	
	public void eliminarCultivo(CultivoInfo cultivo) {
		cultivos.remove(cultivo);
		this.remove(cultivo);
		if (cultivos.size() != 0) {
			GridLayout grid = new GridLayout(cultivos.size(), 1);
			this.setLayout(grid);
		}
	}

}
