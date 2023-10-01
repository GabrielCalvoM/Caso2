package gui.controlWindow;

import javax.swing.JLabel;
import javax.swing.JTextField;

import gui.AccionBoton;
import gui.BotonControl;

import java.awt.*;

public class CultivoInfo extends JLabel {
	
	private VentanaControl ventana;
	private BotonControl cosechar;
	private JTextField tipo;
	private JTextField ubicacion;
	private JTextField cantidad;
	private JTextField estado;
	private JTextField alerta;
	private BotonControl apagarAlerta;
	private Font fuenteInfo = new Font("Arial", Font.PLAIN, 16);
	
	public CultivoInfo(String ptipo, String pubicacion, int pcantidad, VentanaControl padre) {
		super();
        this.setBackground(Color.GRAY);
		this.setLayout(new GridLayout());
		
		this.ventana = padre;
		this.tipo = new JTextField(ptipo);
		this.ubicacion = new JTextField(pubicacion);
		this.cantidad = new JTextField(String.valueOf(pcantidad));
		this.estado = new JTextField("Brotando");
		this.alerta = new JTextField("Sin problemas");
		this.apagarAlerta = new BotonControl(AccionBoton.alerta, Color.LIGHT_GRAY, "Apagar Alerta");
		this.cosechar = new BotonControl(AccionBoton.cosecha, Color.LIGHT_GRAY, "Cosechar");
		cosechar.addActionListener(e -> cosechar());
		
		this.add(cosechar);
		iniciarTexto(ubicacion);
		iniciarTexto(tipo);
		iniciarTexto(cantidad);
		iniciarTexto(estado);
		iniciarTexto(alerta);
        this.add(apagarAlerta);
	}
	
	public void iniciarTexto(JTextField texto) {
		texto.setFont(fuenteInfo);
        texto.setForeground(Color.BLACK);
        texto.setBackground(Color.GRAY);
        texto.setEditable(false);
        texto.setOpaque(true);
        texto.setHorizontalAlignment(JTextField.CENTER);
        this.add(texto);
	}
	
	public void cosechar() {
		ventana.cosechar(this);
	}

}
