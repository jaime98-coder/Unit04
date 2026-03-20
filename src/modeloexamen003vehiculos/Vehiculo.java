package modeloexamen003vehiculos;

public class Vehiculo {
	// Atributos clase (static)
	final static private double PRECIOSEGURO = 50;

	// Atributos objeto
	private String matricula;
	private String modelo;
	private double precioBaseDiario;
	private double pctRecargoPremium;
	private int diasAlquilados;

	public Vehiculo(String matricula, String modelo, double precioBaseDiario, double pctRecargoPremium,
			int diasAlquilados) {
		this.matricula = matricula;
		this.modelo = modelo;
		this.precioBaseDiario = precioBaseDiario;
		this.pctRecargoPremium = pctRecargoPremium;
		this.diasAlquilados = diasAlquilados;
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

	public void setPctRecargoPremium(double pctRecargoPremium) {
		this.pctRecargoPremium = pctRecargoPremium;
	}

	public int getDiasAlquilados() {
		return diasAlquilados;
	}

	public void setDiasAlquilados(int diasAlquilados) {
		this.diasAlquilados = diasAlquilados;
	}

	public static double getPrecioseguro() {
		return PRECIOSEGURO;
	}

	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", modelo=" + modelo + ", precioBaseDiario=" + precioBaseDiario
				+ ", pctRecargoPremium=" + pctRecargoPremium + ", diasAlquilados=" + diasAlquilados + "]";
	}
}
