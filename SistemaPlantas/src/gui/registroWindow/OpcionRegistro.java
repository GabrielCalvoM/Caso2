package gui.registroWindow;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JLabel;

import gui.AccionBoton;

public class OpcionRegistro extends JLabel {
	
	private AccionBoton registro;
	private VentanaRegistro ventana;
	private ArrayList<BotonRegistro> opciones = new ArrayList<BotonRegistro>();
	
	public OpcionRegistro(VentanaRegistro padre, AccionBoton accion) {
		super();

		this.ventana = padre;
		this.registro = accion;
		this.setVisible(false);
	}
	
	public void AgregarBoton(String nombre) {
		BotonRegistro boton = new BotonRegistro(this, Color.LIGHT_GRAY, nombre);
		opciones.add(boton);
		GridLayout grid = new GridLayout(opciones.size(), 1);
		this.setLayout(grid);
		this.add(boton);
	}
	
	public void seleccionar(String nombre) {
		ventana.setValor(registro, nombre);
	}

}
