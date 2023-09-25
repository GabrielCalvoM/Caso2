package gui;

import javax.swing.*;
import java.awt.*;

public class VentanaAlerta extends JFrame {
	
	private ListaAlerta alertas = new ListaAlerta();
	
	public VentanaAlerta() {
		setTitle("Sistema de Plantas");
		setSize(390, 250);
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		setLocation(950, 400);

		Container panel = getContentPane();
        panel.setLayout(null);
		
		JLabel titulo = new JLabel("ZONA DE ALERTA");
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setForeground(Color.BLUE);
		titulo.setBounds(90, 20, 600, 30);

        panel.add(titulo);
        
        alertas.setBounds(20, 70, 335, 120);
        
        panel.add(alertas);
        
        alertas.agregarAlerta("riego", "A2");
        
        /*
        BotonControl bAbono = new BotonControl(AccionBoton.abono, Color.LIGHT_GRAY, "Abono");
        bAbono.setBounds(20, 80, 90, 30);
        
        panel.add(bAbono);
        
        BotonControl bRiego= new BotonControl(AccionBoton.riego, Color.LIGHT_GRAY, "Abono");
        bRiego.setBounds(140, 80, 90, 30);
        
        panel.add(bRiego);
        
        BotonControl bDesparasitar= new BotonControl(AccionBoton.desparasitar, Color.LIGHT_GRAY, "Desparasitación");
        bDesparasitar.setBounds(260, 80, 90, 30);
        
        panel.add(bDesparasitar);
        
        BotonControl bRegistrar = new BotonControl(AccionBoton.abono, Color.LIGHT_GRAY, "Registrar");
        bRegistrar.setBounds(140, 140, 90, 30);
        
        panel.add(bRegistrar);
        */
        
	}

}
