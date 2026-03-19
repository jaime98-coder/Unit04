package cuentabancaria001;

public class CuentaBancaria {

	private String numeroCuenta;
	private double saldoActual;
	private Titular propietario;

	public CuentaBancaria(String numeroCuenta, double saldoActual, Titular propietario) {
		super();
		this.numeroCuenta = numeroCuenta;
		this.saldoActual = saldoActual;
		this.propietario = propietario;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public double getSaldoActual() {
		return saldoActual;
	}

	public void setSaldoActual(double saldoActual) {
		this.saldoActual = saldoActual;
	}

	public Titular getPropietario() {
		return propietario;
	}

	public void setPropietario(Titular propietario) {
		this.propietario = propietario;
	}

	/**
	 * Método para retirar saldo de la cuenta bancaria
	 * 
	 * @param cantidadRetiro
	 */
	public void retirar(double cantidadRetiro) {
		if (saldoActual < cantidadRetiro) {
			System.out.println("Operación denegada: Saldo insuficiente");

		} else {
			saldoActual = saldoActual - cantidadRetiro;
			System.out.println("Saldo retirasdo correctamente( -" + cantidadRetiro + "€ )");
		}
	}

	public void ingresar(double cantidadIngreso) {
		if (cantidadIngreso <= 0) {
			System.out.println("Por favor, ingrese una cantidad positiva");

		} else {
			saldoActual += cantidadIngreso;
			System.out.println("Saldo ingresado correctamente ( +" + cantidadIngreso + "€ )");
		}
	}

	public void mostrarInformacion() {
		System.out.println("Titular: " + propietario.getNombre());
		System.out.println("Número de cuenta: " + numeroCuenta);
		System.out.println("Saldo actual: " + saldoActual + " euros.");

	}

}
