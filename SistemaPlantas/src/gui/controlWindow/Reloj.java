package gui.controlWindow;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.*;

import runner.Fecha;
import runner.Mes;

public class Reloj extends JLabel {
	
	private JTextPane año = initTexto();
	private JTextPane mes = initTexto();
	private JTextPane dia = initTexto();
	private JTextPane hora = initTexto();
	
	public Reloj() {
		super();
		
		this.setOpaque(false);
		this.setLayout(new GridLayout(2, 5));
		this.add(dia);
		this.add(new JLabel("/"));
		this.add(mes);
		this.add(new JLabel("/"));
		this.add(año);
		this.add(hora);
		this.add(new JLabel(":"));
		this.add(new JLabel("00"));
		this.add(new JLabel(":"));
		this.add(new JLabel("00"));
	}
	
	public void actualizar(Fecha fecha) {
		this.setYear(fecha.getYear());
		this.setMonth(fecha.getMonth());
		this.setDay(fecha.getDia());
		this.setHour(fecha.getHour());
	}
	
	public void setYear(int year) {
		año.setText(String.valueOf(year));
	}

	public void setMonth(Mes month) {
		mes.setText(String.valueOf(month));
	}

	public void setDay(int day) {
		dia.setText(String.valueOf(day));
	}

	public void setHour(int hour) {
		hora.setText(String.valueOf(hour));
	}
	
	public JTextPane initTexto() {
		JTextPane texto = new JTextPane();
		texto.setForeground(Color.BLACK);
		texto.setOpaque(false);
		return texto;
	}

}
