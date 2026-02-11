package exercises02;

public class CuentaCorriente {

	String DNI;
	String nombre;
	double saldo;
	String nacionalidad;

	public CuentaCorriente(String DNI, double saldo) {
		super();
		this.DNI = DNI;
		this.saldo = saldo;

	}

	public CuentaCorriente(String DNI, String nombre, double saldo) {
		super();
		this.DNI = DNI;
		this.nombre = nombre;
		this.saldo = saldo;

	}

	public CuentaCorriente(String DNI, String nombre, double saldo, String nacionalidad) {
		super();
		this.DNI = DNI;
		this.nombre = nombre;
		this.saldo = saldo;
		this.nacionalidad = nacionalidad;
	}

	public boolean sacarDinero(double saldo, double dinero) {
		if (saldo >= dinero) {
			saldo -= dinero;
			System.out.println("Dinero sacado correctamente");
			return true;
		} else {
			System.out.println("Saldo insuficiente");
			return false;
		}
	}

	public boolean ingresarDinero(double saldo, double dinero) {
		if (dinero > 0) {
			saldo += dinero;
			System.out.println("Dinero ingresado correctamente");
			return true;
		} else {
			System.out.println("No es posible introducir saldo iguales o superiores a 0");
			return false;
		}
	}

	public void mostrarDatos() {
		
	}
}
