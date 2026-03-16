package boletin04;

public class Fecha {
	private int dia;
	private int mes;
	private int anio;

	public Fecha(int dia, int mes, int anio) {
		setDia(dia);
		setMes(mes);
		setAnio(anio);
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		// CORRECCIÓN: Comprobamos el parámetro 'dia' que entra, no el 'this.dia'
		if (dia > 0 && dia <= 31) {
			this.dia = dia;
		}
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		// CORRECCIÓN: Los meses van del 1 al 12
		if (mes > 0 && mes <= 12) {
			this.mes = mes;
		}
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		if (anio > 0) {
			this.anio = anio;
		}
	}

	// Método para comprobar si el año es bisiesto
	public boolean esBisiesto() {
		// Lógica matemática exacta del calendario gregoriano
		if ((this.anio % 4 == 0 && this.anio % 100 != 0) || (this.anio % 400 == 0)) {
			return true;
		}
		return false;
	}

	// Método JUEZ: Solo mira y valida, no modifica nada.
	public boolean fechaCorrecta() {
		boolean esCorrecta = false;

		// Filtro rápido: si algún dato base es un disparate, devolvemos false
		// directamente
		if (this.anio < 1 || this.mes < 1 || this.mes > 12 || this.dia < 1) {
			return false;
		}

		// Validamos los límites de días según el mes que sea
		if (this.mes == 1 || this.mes == 3 || this.mes == 5 || this.mes == 7 || this.mes == 8 || this.mes == 10
				|| this.mes == 12) {
			if (this.dia <= 31)
				esCorrecta = true;

		} else if (this.mes == 4 || this.mes == 6 || this.mes == 9 || this.mes == 11) {
			if (this.dia <= 30)
				esCorrecta = true;

		} else if (this.mes == 2) {
			if (esBisiesto() && this.dia <= 29) {
				esCorrecta = true;
			} else if (!esBisiesto() && this.dia <= 28) {
				esCorrecta = true;
			}
		}

		return esCorrecta;
	}

	// Método para avanzar un día
	public void diaSiguiente() {
		// 1. Forzamos sumar un día
		this.dia++;

		// 2. Si al sumar, la fecha "explota" (ej. 32 de enero), el juez dirá que es
		// falsa
		if (!fechaCorrecta()) {
			// Como es falsa, significa que hemos cambiado de mes
			this.dia = 1;
			this.mes++;

			// 3. Y si al sumar el mes, pasamos de diciembre...
			if (this.mes > 12) {
				this.mes = 1;
				this.anio++; // ¡Feliz año nuevo!
			}
		}
	}

	@Override
	public String toString() {
		return dia + "-" + mes + "-" + anio;
	}

}