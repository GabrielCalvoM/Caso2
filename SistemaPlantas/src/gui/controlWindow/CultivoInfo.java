package gui.controlWindow;

import javax.swing.JLabel;
import javax.swing.JTextField;

import cultivos.Crecimiento;
import cultivos.manejo.CultAccion;
import cultivos.manejo.CultivoControl;
import gui.AccionBoton;
import gui.BotonControl;
import runner.IntegraSistema;
import sistemas.enums.Alerta;

import java.awt.*;

public class CultivoInfo extends JLabel {
	
	private CultivoControl cultivo;
	private BotonControl cosechar;
	private JTextField tipo;
	private JTextField ubicacion;
	private JTextField cantidad;
	private JTextField estado;
	private JTextField alerta;
	private BotonControl apagarAlerta;
	private Font fuenteInfo = new Font("Arial", Font.PLAIN, 16);
	
	public CultivoInfo(CultivoControl pcultivo) {
		super();
        this.setBackground(Color.GRAY);
		this.setLayout(new GridLayout());
		
		this.cultivo = pcultivo;
		this.tipo = new JTextField(cultivo.getString(CultAccion.gTipo));
		this.ubicacion = new JTextField(cultivo.getString(CultAccion.gLugar));
		this.cantidad = new JTextField(String.valueOf(cultivo.getInt(CultAccion.gCant)));
		this.estado = new JTextField("Brotando");
		this.alerta = new JTextField("Sin Problemas");
		this.apagarAlerta = new BotonControl(AccionBoton.alerta, Color.LIGHT_GRAY, "Apagar Alerta");
		this.cosechar = new BotonControl(AccionBoton.cosecha, Color.LIGHT_GRAY, "Cosechar");
		apagarAlerta.addActionListener(e -> doAccion(apagarAlerta.getAccion()));
		cosechar.addActionListener(e -> doAccion(cosechar.getAccion()));
		
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
	
	public void doAccion(AccionBoton accion) {
		IntegraSistema accioner = IntegraSistema.getInstance();
		accioner.setCultivo(this);
		accioner.setAccion(accion);
		accioner.run();
	}
	
	public void showEstado() {
		Crecimiento estado = cultivo.getCrecimiento();
		
		if (estado == Crecimiento.creciendo) {
			this.estado.setText("Creciendo");
		} else if (estado == Crecimiento.floreciendo) {
			this.estado.setText("Floreciendo");
		}else if (estado == Crecimiento.lista) {
			this.estado.setText("Lista");
		}
	}
	
	public void showAlerta() {
		Alerta alerta = cultivo.getAlerta();
		
		if (alerta == Alerta.abono) {
			this.alerta.setText("Abono");
			this.alerta.setForeground(Color.RED);
		} else if (alerta == Alerta.riego) {
			this.alerta.setText("Riego");
			this.alerta.setForeground(Color.RED);
		} else if (alerta == Alerta.pendiente) {
			this.alerta.setText("Arreglado");
			this.alerta.setForeground(Color.GREEN);
		}else if (alerta == Alerta.nada) {
			this.alerta.setText("Sin Problemas");
			this.alerta.setForeground(Color.BLACK);
		}
	}
	
	public CultivoControl getCultivo() {
		return cultivo;
	}
	
}
