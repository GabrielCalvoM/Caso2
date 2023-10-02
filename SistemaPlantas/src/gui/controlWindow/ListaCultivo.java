package gui.controlWindow;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.JLabel;

import cultivos.manejo.CultivoControl;

public class ListaCultivo extends JLabel {

	private ArrayList<CultivoInfo> info = new ArrayList<CultivoInfo>();
	private ArrayList<CultivoControl> cultivos = new ArrayList<CultivoControl>();
	
	public ListaCultivo(VentanaControl padre) {
		super();
        this.setBackground(Color.GRAY);
        this.setText("            No hay cultivos tabajando");
        this.setFont(new Font("Arial", Font.BOLD, 50));
	}
	
	public void agregarCultivo(CultivoControl cultivo) {
		CultivoInfo nuevo = new CultivoInfo(cultivo);
		info.add(nuevo);
		cultivos.add(cultivo);
		GridLayout grid = new GridLayout(info.size(), 1);
		this.setLayout(grid);
		this.add(nuevo);
	}
	
	public void eliminarCultivo(CultivoInfo cultivo) {
		cultivos.remove(cultivo.getCultivo());
		info.remove(cultivo);
		this.remove(cultivo);
		if (info.size() != 0) {
			GridLayout grid = new GridLayout(info.size(), 1);
			this.setLayout(grid);
		}
	}
	
	public int cantCultivo() {
		return info.size();
	}

	public ArrayList<CultivoControl> getCultivos() {
		return cultivos;
	}

	public void actualizar(int i) {
		info.get(i).showAlerta();
		info.get(i).showEstado();
	}

}
