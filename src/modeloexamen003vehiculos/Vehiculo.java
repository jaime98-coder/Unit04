package modeloexamen003vehiculos;

public class Vehiculo {
	// Atributos clase (static) (deeria ser minusculas)
	static private double PRECIO_SEGURO = 5;

	public static void setPRECIO_SEGURO(double pRECIO_SEGURO) {
		PRECIO_SEGURO = pRECIO_SEGURO;
	}

	// Atributos objeto
	private String matricula;
	private String modelo;
	private double precioBaseDiario;
	private double pctRecargoPremium;
	private int diasAlquilados;

	public Vehiculo(String matricula, String modelo, double precioBaseDiario, double pctRecargoPremium,
			int diasAlquilados) {
		setMatricula(matricula);
		setModelo(modelo);
		setPrecioBaseDiario(precioBaseDiario);
		setPctRecargoPremium(pctRecargoPremium);
		setDiasAlquilados(diasAlquilados);
	}

	public Vehiculo() {

	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getPrecioBaseDiario() {
		return precioBaseDiario;
	}

	public void setPrecioBaseDiario(double precioBaseDiario) {
		this.precioBaseDiario = precioBaseDiario;
	}

	public double getPctRecargoPremium() {
		return pctRecargoPremium;
	}

	/**
	 * En porcentaje. 0.0 - 25.0 (0% - 25%)
	 * 
	 * @param pctRecargoPremium
	 */
	public void setPctRecargoPremium(double pctRecargoPremium) {
		if (pctRecargoPremium >= 0.0 && pctRecargoPremium <= 25.0) {
			this.pctRecargoPremium = pctRecargoPremium;
		}
	}

	public int getDiasAlquilados() {
		return diasAlquilados;
	}

	public void setDiasAlquilados(int diasAlquilados) {
		if (diasAlquilados > 0) {
			this.diasAlquilados = diasAlquilados;
		}
	}

	public static double getPrecioseguro() {
		return PRECIO_SEGURO;
	}

	/**
	 * Metodo para calcular la cantidad de recargo en euros
	 * 
	 * @param matricula.  Para identificar coche (revisar si necesario)
	 * @param pctRecargo. % que se le añadirá para hacer el calculo
	 * @return cantidad de recargo en euros y centimos
	 */
	public double recargoPremiumEuros(double pctRecargo) {
		double cantidadRecargo;
		cantidadRecargo = getPrecioBaseDiario() * pctRecargo / 100;
		return cantidadRecargo;
	}

	/**
	 * Método para calcular el importe del seguro en euros (según los días
	 * alquilados)
	 * 
	 * @param matricula. Para identificar coche (revisar si necesario=
	 * @return cantidad de importe del seguro en euros y centimos
	 */
	public double importeSeguroEuros() {
		double cantidadSeguro;
		cantidadSeguro = getDiasAlquilados() * PRECIO_SEGURO;
		return cantidadSeguro;
	}

	/**
	 * Método para calcular la cantidad de dinero que generara el alquiler del coche
	 * 
	 * @return ingreso total generado en euros
	 */
	public double ingresoTotalGenerado() {
		double ingresoTotalGenerado;
		ingresoTotalGenerado = getPrecioBaseDiario()
				+ recargoPremiumEuros(getPctRecargoPremium() + importeSeguroEuros());
		return ingresoTotalGenerado;

	}

	@Override
	public String toString() {
		return "\n" + matricula + " - " + modelo + "\nPrecio Base/Día: " + precioBaseDiario + "| Recargo Premium:"
				+ recargoPremiumEuros(pctRecargoPremium) + "(" + pctRecargoPremium + "%)" + "\nDiasAlquilados: "
				+ diasAlquilados + " | Total generado: " + ingresoTotalGenerado();
	}

	/**
	 *  Método para calcular si la matrícula introducida es igual a la matrícula del coche
	 *  (revisar si es necesario el parametro matricula)
	 * @param matricula
	 * @return
	 */
	public boolean sonIguales(String matricula) {
		boolean sonIguales = false;
		if (this.matricula.equalsIgnoreCase(matricula)) {
			sonIguales = true;
		}

		return sonIguales;
	}

	/**
	 * Método para calcular si el recargo es superior a 12
	 * 
	 * @return True --> lo es. False --> No lo es
	 */
	public boolean recargoSuperior12() {
		boolean recargoSuperior12 = false;
		if (this.pctRecargoPremium >= 12) {
			recargoSuperior12 = true;
		}

		return recargoSuperior12;
	}

}
