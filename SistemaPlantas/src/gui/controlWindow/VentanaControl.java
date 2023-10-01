package gui.controlWindow;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import cultivos.Campo;
import runner.SistemaFuncion;

public class VentanaControl extends JFrame {

	private SistemaFuncion sist;
	private ListaCultivo cultivos = new ListaCultivo(this);
	
	public VentanaControl(SistemaFuncion padre) {
		this.sist = padre;
		
		setTitle("Sistema de Plantas");
		setSize(800, 600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		setLocation(40, 60);
		
		Container panel = getContentPane();
        panel.setLayout(null);
		
		JLabel titulo = new JLabel("ZONA DE CONTROL");
		titulo.setFont(new Font("Arial", Font.BOLD, 28));
		titulo.setForeground(Color.BLUE);
		titulo.setBounds(225, 20, 600, 30);

        panel.add(titulo);
        
        Font fuenteInfo = new Font("Arial", Font.BOLD, 20);
        
        JLabel info = new JLabel(" UBICACIÓN     TIPO         LOTES      "
        						 + "ESTADO    ALERTA");
        info.setFont(fuenteInfo);
        info.setForeground(Color.RED);
        info.setBounds(120, 90, 700, 30);

        panel.add(info);
        
        cultivos.setBackground(Color.DARK_GRAY);
        cultivos.setBounds(20, 120, 750, 360);
        
        panel.add(cultivos);
	}
	
	public void ingresarCultivo(Campo cultivo) {
		Container panel = getContentPane();
		cultivos.agregarCultivo(cultivo.getTipo(), cultivo.getLugar(), cultivo.getCantidad());
		panel.revalidate();
	}
	
	public void cosechar(CultivoInfo cultivo) {
		Container panel = getContentPane();
		cultivos.eliminarCultivo(cultivo);
		panel.revalidate();
		panel.repaint();
	}

}
