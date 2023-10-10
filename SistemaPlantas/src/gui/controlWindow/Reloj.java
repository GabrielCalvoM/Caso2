package gui.controlWindow;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.*;

import runner.Fecha;
import runner.Mes;

public class Reloj extends JLabel {
	
	private JTextField año = initTexto();
	private JTextField mes = initTexto();
	private JTextField dia = initTexto();
	private JTextField hora = initTexto();
	
	public Reloj() {
		super();
		
		this.setOpaque(false);
		this.setLayout(new GridLayout(2, 3));
		this.add(dia);
		dia.setHorizontalAlignment(JTextField.RIGHT);
		this.add(mes);
		this.add(año);
		this.add(hora);
		hora.setHorizontalAlignment(JTextField.RIGHT);
		this.add(new JLabel(": 00 : 00"));
	}
	
	public void actualizar(Fecha fecha) {
		this.setYear(fecha.getYear());
		this.setMonth(fecha.getMonth());
		this.setDay(fecha.getDay());
		this.setHour(fecha.getHour());
	}
	
	public void setYear(int year) {
		año.setText(" / " + String.valueOf(year));
	}

	public void setMonth(Mes month) {
		mes.setText(" / " + String.valueOf(month));
	}

	public void setDay(int day) {
		dia.setText(String.valueOf(day));
	}

	public void setHour(int hour) {
		hora.setText(String.valueOf(hour));
	}
	
	public JTextField initTexto() {
		JTextField texto = new JTextField();
		texto.setForeground(Color.BLACK);
		texto.setOpaque(false);
		texto.setBorder(null);
		return texto;
	}

}
