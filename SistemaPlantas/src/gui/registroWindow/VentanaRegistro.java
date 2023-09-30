package gui.registroWindow;

import gui.*;
import javax.swing.*;
import java.awt.*;

public class VentanaRegistro extends JFrame {
	
	private JTextField lugar;
	private OpcionRegistro rlugar = initLugar();
	private JTextField tipo;
	private OpcionRegistro rtipo = initTipo();
	private JTextField cantidad;
	private OpcionRegistro rcant;
	
	public VentanaRegistro() {
		setTitle("Sistema de Plantas");
		setSize(390, 340);
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		setLocation(950, 60);
		
		Container panel = getContentPane();
        panel.setLayout(null);
		
		JLabel titulo = new JLabel("ZONA DE REGISTRO");
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setForeground(Color.BLUE);
		titulo.setBounds(93, 20, 600, 30);

        panel.add(titulo);
        
        rlugar.setBounds(20, 108, 200, 150);
        panel.add(rlugar);
        
        rtipo.setBounds(20, 168, 200, 100);
        panel.add(rtipo);
        
        JLabel Ubicacion = new JLabel("Lugar del Cultivo:");
		Ubicacion.setFont(new Font("Arial", Font.BOLD, 20));
		Ubicacion.setForeground(Color.BLUE);
		Ubicacion.setBounds(20, 60, 600, 30);

        panel.add(Ubicacion);

        BotonControl blugar = new BotonControl(AccionBoton.ubicaciónFlor, Color.GRAY, "v");
        blugar.setBounds(200, 90, 20, 20);
        blugar.addActionListener(e -> setAccion(blugar.getAccion()));
        
        panel.add(blugar);

        this.lugar = new JTextField();
        lugar.setEditable(false);
        lugar.setBounds(20, 90, 180, 20);
        
        panel.add(lugar);
        
		JLabel tipoPlanta = new JLabel("Tipo de Planta:");
		tipoPlanta.setFont(new Font("Arial", Font.BOLD, 20));
		tipoPlanta.setForeground(Color.BLUE);
		tipoPlanta.setBounds(20, 120, 600, 30);

        panel.add(tipoPlanta);

        BotonControl btipo= new BotonControl(AccionBoton.tipoFlor, Color.GRAY, "v");
        btipo.setBounds(200, 150, 20, 20);
        btipo.addActionListener(e -> setAccion(btipo.getAccion()));
        
        panel.add(btipo);
        
        this.tipo = new JTextField();
        tipo.setEditable(false);
        tipo.setBounds(20, 150, 180, 20);
        
        panel.add(tipo);

		JLabel cantidadLotes = new JLabel("Cantidad de lotes");
		cantidadLotes.setFont(new Font("Arial", Font.BOLD, 20));
		cantidadLotes.setForeground(Color.BLUE);
		cantidadLotes.setBounds(20, 180, 600, 30);

        panel.add(cantidadLotes);

        BotonControl bcantidad= new BotonControl(AccionBoton.cantidadFlor, Color.GRAY, "v");
        bcantidad.setBounds(200, 210, 20, 20);
        bcantidad.addActionListener(e -> setAccion(bcantidad.getAccion()));
        
        panel.add(bcantidad);
        
        this.cantidad = new JTextField();
        cantidad.setEditable(false);
        cantidad.setBounds(20, 210, 180, 20);
        
        panel.add(cantidad);
        
        BotonControl bIngresar = new BotonControl(AccionBoton.ingresar, Color.LIGHT_GRAY, "Ingresar");
        bIngresar.setBounds(270, 250, 90, 30);
        
        panel.add(bIngresar);
	}
	
	public void setAccion(AccionBoton accion) {
		if (accion == AccionBoton.tipoFlor) {
			rtipo.setVisible(true);
		} else if (accion == AccionBoton.cantidadFlor) {
			
		} else if (accion == AccionBoton.ubicaciónFlor) {
			rlugar.setVisible(true);
		}
	}
	
	public void setValor(AccionBoton accion, String valor) {
		if (accion == AccionBoton.tipoFlor) {
			tipo.setText(valor);
		} else if (accion == AccionBoton.cantidadFlor) {
			
		} else if (accion == AccionBoton.ubicaciónFlor) {
			lugar.setText(valor);
		}
	}
	
	public OpcionRegistro initLugar() {
		OpcionRegistro lugares = new OpcionRegistro(this, AccionBoton.tipoFlor);
		lugares.AgregarBoton("A1");
		lugares.AgregarBoton("A2");
		lugares.AgregarBoton("A3");
		lugares.AgregarBoton("B1");
		lugares.AgregarBoton("B2");
		lugares.AgregarBoton("C1");
		lugares.AgregarBoton("C2");
		lugares.AgregarBoton("D1");
		return lugares;
	}
	
	public OpcionRegistro initTipo() {
		OpcionRegistro tipos = new OpcionRegistro(this, AccionBoton.ubicaciónFlor);
		tipos.AgregarBoton("Orquídeas");
		tipos.AgregarBoton("Lirios");
		tipos.AgregarBoton("A1");
		tipos.AgregarBoton("A1");
		tipos.AgregarBoton("A1");
		tipos.AgregarBoton("A1");
		return tipos;
	}
	
}
