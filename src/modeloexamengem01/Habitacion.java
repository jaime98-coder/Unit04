package modeloexamengem01;

import modeloexamen003vehiculos.Vehiculo;

public class Habitacion {
	private String codigo;
	private String tipo;
	private double precioBaseNoche;
	private double pctServicioExtra;
	static private double tasaTuristica = 3;
	private int nochesReservadas;

	public Habitacion(String codigo, String tipo, double precioBaseNoche, double pctServicioExtra,
			int nochesReservadas) {
		setCodigo(codigo);
		setTipo(tipo);
		setPrecioBaseNoche(precioBaseNoche);
		setPctServicioExtra(pctServicioExtra);
		setNochesReservadas(nochesReservadas);
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPrecioBaseNoche() {
		return precioBaseNoche;
	}

	public void setPrecioBaseNoche(double precioBaseNoche) {
		if (precioBaseNoche >= 0) {
			this.precioBaseNoche = precioBaseNoche;
		}
	}

	public double getPctServicioExtra() {
		return pctServicioExtra;
	}

	public void setPctServicioExtra(double pctServicioExtra) {
		if (pctServicioExtra >= 0 && pctServicioExtra <= 25) {
			this.pctServicioExtra = pctServicioExtra;
		}
	}

	public static double getTasaTuristica() {
		return tasaTuristica;
	}

	public static void setTasaTuristica(double tasaTuristica) {
		Habitacion.tasaTuristica = tasaTuristica;
	}

	public int getNochesReservadas() {
		return nochesReservadas;
	}

	public void setNochesReservadas(int nochesReservadas) {
		if (nochesReservadas >= 0) {
			this.nochesReservadas = nochesReservadas;
		}
	}

	/**
	 * Método para calcular importe total en euros de extras
	 * 
	 * @return precioTotalExtras
	 */
	public double importeTotalExtras() {
		double precioTotalExtras;
		precioTotalExtras = (precioBaseNoche * nochesReservadas) * pctServicioExtra / 100;
		return precioTotalExtras;
	}

	/**
	 * Método para calcualr importe total tasa turistica en euros
	 * 
	 * @return precioTotalTasa
	 */
	public double importeTotalTasaTuristica() {
		double precioTotalTasa;
		precioTotalTasa = nochesReservadas * tasaTuristica;
		return precioTotalTasa;

	}

	/**
	 * Método para calcular ingreso total habitacion
	 * 
	 * @return
	 */
	public double ingresoTotalHabitacion() {
		double precioTotalhabitacion;
		precioTotalhabitacion = (precioBaseNoche * nochesReservadas) + importeTotalExtras()
				+ importeTotalTasaTuristica();
		return precioTotalhabitacion;
	}

	@Override
	public String toString() {
		return codigo + " - " + tipo + " Precio Base/Noche " + precioBaseNoche + " | Servicio Extra: "
				+ importeTotalExtras() + " (" + pctServicioExtra + "%) Noches reservadas: " + nochesReservadas
				+ " | Total generado: " + ingresoTotalHabitacion() + "€ ";
	}

	/**
	 * Método para comprobar si las habitaciones son iguales
	 * 
	 * @param codigo. Parametro de entrada para poder comparar con el codigo de la
	 *                habitacion
	 * @return True --> Si tienen mismo código. False --> Si no tienen mismo código
	 */
	public boolean sonIguales(String codigo) {
		boolean iguales = false;
		if (this.codigo.equalsIgnoreCase(codigo)) {
			iguales = true;
		}
		return iguales;
	}

	/**
	 * Método para saber si una habitación hizo uso de más de un 15% de servicios
	 * extras
	 * 
	 * @param codigo
	 * @return True --> Servicios extras mas de 15. False --> Servicios extras menos
	 *         o igual de 15
	 */
	public boolean serviciosExtrasMas15() {
		boolean serviciosExtrasMas15 = false;
		if (this.pctServicioExtra > 15) {
			serviciosExtrasMas15 = true;
		}
		return serviciosExtrasMas15;
	}
}
