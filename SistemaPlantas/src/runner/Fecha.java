package runner;

import java.io.Serializable;
import java.util.Calendar;

public class Fecha implements Serializable {
	
	private int año;
	private int mes;
	private int dia;
	private int hora;
	
	public Fecha() {
		Calendar calendario = Calendar.getInstance();
		año = calendario.get(Calendar.YEAR);
		mes = calendario.get(Calendar.MONTH) + 1;
		dia = calendario.get(Calendar.DAY_OF_MONTH);
		hora = calendario.get(Calendar.HOUR_OF_DAY);
	}
	
	public Fecha(int hh, int dd, int mm, int yyyy) {
		año = yyyy;
		mes = mm;
		dia = dd;
		hora = hh;
	}
	
	public void avanzarTiempo() {
		hora++;
		
		if (hora >= 24) {
			hora = 0;
			dia++;
		}
		
		if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
			if (dia > 31) {
				dia = 1;
				mes++;
			}
		} else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
			if (dia > 30) {
				dia = 1;
				mes++;
			}
		} else if (mes == 2) {
			if (año % 4 == 0) {
				if (dia > 29) {
					dia = 1;
					mes++;
				}
			} else {
				if (dia > 28) {
					dia = 1;
					mes++;
				}
			}
		}
		
		if (mes > 12) {
			mes = 1;
			año++;
		}
	}

	public int getYear() {
		return año;
	}

	public Mes getMonth() {
		Mes mm;
		
		if (mes == 1) {
			mm = Mes.enero;
		} else if (mes == 2) {
			mm = Mes.febrero;
		} else if (mes == 3) {
			mm = Mes.marzo;
		} else if (mes == 4) {
			mm = Mes.abril;
		} else if (mes == 5) {
			mm = Mes.mayo;
		} else if (mes == 6) {
			mm = Mes.junio;
		} else if (mes == 7) {
			mm = Mes.julio;
		} else if (mes == 8) {
			mm = Mes.agosto;
		} else if (mes == 9) {
			mm = Mes.setiembre;
		} else if (mes == 10) {
			mm = Mes.octubre;
		} else if (mes == 11) {
			mm = Mes.noviembre;
		} else {
			mm = Mes.diciembre;
		}
		
		return mm;
	}

	public int getDia() {
		return dia;
	}
	
	public int getHour() {
		return hora;
	}
	
}
