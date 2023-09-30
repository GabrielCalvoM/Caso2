package gui.controlWindow;

import java.awt.*;

import javax.swing.JLabel;
import java.util.ArrayList;

public class ListaCultivo extends JLabel {
	
	private ArrayList<CultivoInfo> cultivos = new ArrayList<CultivoInfo>();
	
	public ListaCultivo() {
		super();
        this.setBackground(Color.GRAY);
	}
	
	public void agregarCultivo(String tipo, String ubicacion, int cantidad) {
		CultivoInfo nuevo = new CultivoInfo(tipo, ubicacion, cantidad);
		cultivos.add(nuevo);
		GridLayout grid = new GridLayout(cultivos.size(), 1);
		this.setLayout(grid);
		this.add(nuevo);
	}

}
