package modeloexamengem02;
/**
 * Clase máquina para recoger todos los atributos y métodos relacionados con la máquina
 */

public class Maquina {
	private String codigo;
	private String tipo;
	private double precioBaseDiario;
	private double pctSeguroRiesgo;
	static private double tasaTransporteDiaria = 10;
	private int diasAlquiler;

	public Maquina(String codigo, String tipo, double precioBaseDiario, double pctSeguroRiesgo, int diasAlquiler) {

		setCodigo(codigo);
		setTipo(tipo);
		setPrecioBaseDiario(precioBaseDiario);
		setPctSeguroRiesgo(pctSeguroRiesgo);
		setDiasAlquiler(diasAlquiler);
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
		if (tipo.trim().equalsIgnoreCase("Excavadora") || tipo.trim().equalsIgnoreCase("Grua")
				|| tipo.trim().equalsIgnoreCase("Tractor") || tipo.trim().equalsIgnoreCase("Hormigonera")) {
			this.tipo = tipo;
		} else {
			this.tipo = "Tipo No Asignado";
		}
	}

	public double getPrecioBaseDiario() {
		return precioBaseDiario;
	}

	public void setPrecioBaseDiario(double precioBaseDiario) {
		if (precioBaseDiario > 0) {
			this.precioBaseDiario = precioBaseDiario;
		}
	}

	public double getPctSeguroRiesgo() {
		return pctSeguroRiesgo;
	}

	public void setPctSeguroRiesgo(double pctSeguroRiesgo) {
		if (pctSeguroRiesgo >= 0 && pctSeguroRiesgo <= 20) {
			this.pctSeguroRiesgo = pctSeguroRiesgo;
		}
	}

	public static double getTasaTransporteDiaria() {
		return tasaTransporteDiaria;
	}

	public static void setTasaTransporteDiaria(double tasaTransporteDiaria) {
		Maquina.tasaTransporteDiaria = tasaTransporteDiaria;
	}

	public int getDiasAlquiler() {
		return diasAlquiler;
	}

	public void setDiasAlquiler(int diasAlquiler) {
		if (diasAlquiler > 0) {
			this.diasAlquiler = diasAlquiler;
		}
	}

	/**
	 * Método para calcular el importe total del seguro riesgo @return. Importe
	 * total seguro riesgo en euros
	 */
	public double importeTotalSeguroRiesgo() {
		double totalSeguroRiesgo;
		totalSeguroRiesgo = (precioBaseDiario * diasAlquiler) * pctSeguroRiesgo / 100;
		return totalSeguroRiesgo;
	}

	/**
	 * Método para calcular el importe total de la tasa de transporte
	 * @return. Importe total de transporte en euros
	 */
	public double importeTotalTransporte() {
		double importeTotalTransporte;
		importeTotalTransporte = diasAlquiler * tasaTransporteDiaria;
		return importeTotalTransporte;
	}

	/**
	 * Método para calcular el ingreso total generado por la máquina
	 * 
	 * @return Importe total generado por la máquina en euros
	 */

	public double ingresoTotalGeneradoMaquina() {
		double ingresoTotalGenerado;
		ingresoTotalGenerado = (precioBaseDiario * diasAlquiler) + importeTotalSeguroRiesgo()
				+ importeTotalTransporte();
		return ingresoTotalGenerado;
	}

	@Override
	public String toString() {
		return codigo + " - " + tipo + " Precio Base/Día: " + precioBaseDiario + " | Seguro "
				+ importeTotalSeguroRiesgo() + "(" + pctSeguroRiesgo + "%)" + " Dias Alquilada: " + diasAlquiler
				+ " | Total generado: " + ingresoTotalGeneradoMaquina() + ": €";
	}

	/**
	 * Método para saber si las máquinas son iguales.
	 * 
	 * @param codigo. Lo que dictamina si son iguales o no
	 * @return True --> Son iguales (coinciden en codigo). False --> No son iguales
	 *         (codigo diferente)
	 */
	public boolean sonIguales(String codigo) {
		boolean sonIguales = false;
		if (this.codigo.trim().equalsIgnoreCase(codigo)) {
			sonIguales = true;
		}
		return sonIguales;
	}

	/**
	 * Método para saber si el riesgo es alto (Superior al 12%)
	 * 
	 * @return True --> Es riesgo alto >12%. False --> No es riesgo alto
	 */
	public boolean esRiesgoAlto() {
		boolean riesgoAlto = false;
		if (this.pctSeguroRiesgo > 12) {
			riesgoAlto = true;
		}
		return riesgoAlto;
	}
}
