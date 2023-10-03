package runner;

import java.util.Calendar;

public class Fecha {
	
	private int hora;
	private int dia;
	private int mes;
	private int año;
	
	public Fecha() {
		hora = Calendar.HOUR_OF_DAY;
		dia = Calendar.DAY_OF_MONTH;
		mes = Calendar.MONTH;
		año = Calendar.YEAR;
	}
	
	public Fecha(int hh, int dd, int mm, int yyyy) {
		hora = hh;
		dia = dd;
		mes = mm;
		año = yyyy;
	}
	
	public void avanzarTiempo() {
		hora++;
		
		if (hora >= 24) {
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
	
	public int getHour() {
		return hora;
	}
	
	public int getDia() {
		return dia;
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

}
