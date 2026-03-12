package boletin04;

/**
 * Clase para representar una hora en formato 24 horas
 * 
 * Responsabilidades: - Mantener una hora válida - Permitir incrementar en
 * segundos controlando los límites
 */
public class Hora {
	private int horas;
	private int minutos;
	private int segundos;

	/**
	 * Constructor completo
	 * 
	 * @param horas
	 * @param minutos
	 * @param segundos
	 */
	public Hora(int horas, int minutos, int segundos) {
		setHoras(horas);
		setMinutos(minutos);
		setSegundos(segundos);
	}

	/**
	 * Constructor por defecto
	 * 
	 * @param horas
	 * @param minutos
	 * @param segundos
	 */
	public Hora() {
		this.horas = 0;
		this.minutos = 0;
		this.segundos = 0;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		if (horas >= 0 && horas < 24) {
			this.horas = horas;
		}

	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		if (minutos >= 0 && minutos < 60) {
			this.minutos = minutos;
		}
	}

	public int getSegundos() {
		return segundos;
	}

	public void setSegundos(int segundos) {
		if (segundos >= 0 && segundos < 60) {
			this.segundos = segundos;
		}
	}

	/**
	 * Incrementa un segundo la hora actual
	 */
	public void incrementarSegundos() {
		this.segundos++;

		if (segundos == 60) {
			segundos = 0;
			this.minutos++;

			if (minutos == 60) {
				minutos = 0;
				this.horas++;

				if (horas == 24) {
					this.horas = 0;

				}
			}
		}
	}
}
