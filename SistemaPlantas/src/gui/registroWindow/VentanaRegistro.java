package gui.registroWindow;

import javax.swing.*;
import java.awt.*;

import gui.*;
import runner.*;
import cultivos.*;
import cultivos.manejo.CultivoControl;

public class VentanaRegistro extends JFrame {
	
	private JTextField lugar;
	private OpcionRegistro rlugar = initLugar();
	private JTextField tipo;
	private OpcionRegistro rtipo = initTipo();
	private JTextField cantidad;
	private OpcionRegistro rcant = initCant();
	
	public VentanaRegistro() {
		setTitle("Sistema de Plantas");
		setSize(390, 340);
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		setLocation(1100, 260);
		
		Container panel = getContentPane();
        panel.setLayout(null);
		
		JLabel titulo = new JLabel("ZONA DE REGISTRO");
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setForeground(Color.BLUE);
		titulo.setBounds(93, 20, 600, 30);

        panel.add(titulo);
        
        rlugar.setBounds(20, 108, 200, 130);
        panel.add(rlugar);
        
        rtipo.setBounds(20, 168, 200, 100);
        panel.add(rtipo);
        
        rcant.setBounds(20, 228, 200, 60);
        panel.add(rcant);
        
        JLabel Ubicacion = new JLabel("Lugar del Cultivo:");
		Ubicacion.setFont(new Font("Arial", Font.BOLD, 20));
		Ubicacion.setForeground(Color.BLUE);
		Ubicacion.setBounds(20, 60, 600, 30);

        panel.add(Ubicacion);

        BotonControl blugar = new BotonControl(AccionBoton.ubicacionFlor, Color.GRAY, "v");
        blugar.setBounds(200, 90, 20, 20);
        blugar.addActionListener(e -> setAccion(blugar.getAccion()));
        
        panel.add(blugar);

        this.lugar = new JTextField();
        lugar.setEditable(false);
        lugar.setBounds(20, 90, 180, 20);
		lugar.setText("");
        
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
        tipo.setText("");
        
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
		cantidad.setText("");
        
        panel.add(cantidad);
        
        BotonControl bIngresar = new BotonControl(AccionBoton.ingresar, Color.LIGHT_GRAY, "Ingresar");
        bIngresar.setBounds(270, 250, 90, 30);
        bIngresar.addActionListener(e -> doAccion(AccionBoton.ingresar));
        
        panel.add(bIngresar);
	}
	
	public void doAccion(AccionBoton accion) {
		IntegraSistema accioner = IntegraSistema.getInstance();
		accioner.setAccion(accion);
		accioner.run();
	}
	
	public void setAccion(AccionBoton accion) {
		if (accion == AccionBoton.tipoFlor) {
			rtipo.setVisible(true);
			rcant.setVisible(false);
			rlugar.setVisible(false);
		} else if (accion == AccionBoton.cantidadFlor) {
			rtipo.setVisible(false);
			rcant.setVisible(true);
			rlugar.setVisible(false);
		} else if (accion == AccionBoton.ubicacionFlor) {
			rtipo.setVisible(false);
			rcant.setVisible(false);
			rlugar.setVisible(true);
		}
	}
	
	public void setValor(AccionBoton accion, String valor) {
		if (accion == AccionBoton.tipoFlor) {
			tipo.setText(valor);
		} else if (accion == AccionBoton.cantidadFlor) {
			cantidad.setText(valor);
		} else if (accion == AccionBoton.ubicacionFlor) {
			lugar.setText(valor);
		}
	}
	
	public CultivoControl registrar() {
		CultivoControl cultivo = null;
		
		if ((tipo.getText().length() != 0) && (cantidad.getText().length() != 0) && 
			(lugar.getText().length() != 0)) {
			cultivo = new CultivoControl(new Campo(new Cultivo(tipo.getText()),
									  Integer.parseInt(cantidad.getText()), lugar.getText()));
			
			this.tipo.setText("");
			this.cantidad.setText("");
			this.lugar.setText("");
		}
		
		return cultivo;
	}
	
	public OpcionRegistro initLugar() {
		OpcionRegistro lugares = new OpcionRegistro(this, AccionBoton.ubicacionFlor, 1);
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
		OpcionRegistro tipos = new OpcionRegistro(this, AccionBoton.tipoFlor, 1);
		tipos.AgregarBoton("Orquídeas");
		tipos.AgregarBoton("Claveles");
		tipos.AgregarBoton("Anturios");
		tipos.AgregarBoton("Rosales");
		tipos.AgregarBoton("Heliconias");
		tipos.AgregarBoton("Velo de novia");
		return tipos;
	}

	public OpcionRegistro initCant() {
		OpcionRegistro cant = new OpcionRegistro(this, AccionBoton.cantidadFlor, 2);
		cant.AgregarBoton("1");
		cant.AgregarBoton("2");
		cant.AgregarBoton("3");
		cant.AgregarBoton("4");
		cant.AgregarBoton("5");
		cant.AgregarBoton("6");
		cant.AgregarBoton("7");
		cant.AgregarBoton("8");
		return cant;
	}
	
}
