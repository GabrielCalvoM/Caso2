package gui.controlWindow;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import cultivos.manejo.CultivoControl;
import gui.AccionBoton;
import gui.BotonControl;
import runner.IntegraSistema;

public class VentanaControl extends JFrame {

	private ListaCultivo cultivos = new ListaCultivo(this);
	
	public VentanaControl() {
		setTitle("Sistema de Plantas");
		setSize(1000, 700);
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		setLocation(40, 60);
		
		Container panel = getContentPane();
        panel.setLayout(null);
		
		JLabel titulo = new JLabel("ZONA DE CONTROL");
		titulo.setFont(new Font("Arial", Font.BOLD, 28));
		titulo.setForeground(Color.BLUE);
		titulo.setBounds(340, 20, 600, 30);

        panel.add(titulo);
        
        Font fuenteInfo = new Font("Arial", Font.BOLD, 20);
        
        JLabel info = new JLabel("UBICACIÓN           TIPO              LOTES          "
        						 + "ESTADO         ALERTA");
        info.setFont(fuenteInfo);
        info.setForeground(Color.RED);
        info.setBounds(160, 90, 700, 30);

        panel.add(info);
        
        BotonControl bregistro = new BotonControl(AccionBoton.registrar, Color.GRAY, "Abrir Registro");
        bregistro.setBounds(800, 600, 120, 30);
        bregistro.addActionListener(e -> doAccion(bregistro.getAccion()));
        
        panel.add(bregistro);
        
        cultivos.setBackground(Color.DARK_GRAY);
        cultivos.setBounds(20, 120, 940, 460);
        
        panel.add(cultivos);
	}
	
	public void doAccion(AccionBoton accion) {
		IntegraSistema.setAccion(accion);
		new IntegraSistema().run();
	}
	
	public void ingresarCultivo(CultivoControl cultivo) {
		Container panel = getContentPane();
		cultivos.agregarCultivo(cultivo);
		panel.revalidate();
	}
	
	public void cosechar(CultivoInfo cultivo) {
		Container panel = getContentPane();
		cultivos.eliminarCultivo(cultivo);
		panel.revalidate();
		panel.repaint();
	}
	
	public void actualizarInfo(int i) {
		cultivos.actualizar(i);
	}
	
	public int cantCultivos() {
		return cultivos.cantCultivo();
	}
	
	public ArrayList<CultivoControl> getCultivos() {
		return this.cultivos.getCultivos();
	}

}
