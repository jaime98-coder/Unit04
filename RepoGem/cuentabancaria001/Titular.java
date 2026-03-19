package cuentabancaria001;

public class Titular {
	private String nombre;
	private String dni;

	public Titular(String nombreInicial, String dniInicial) {

		this.nombre = nombreInicial;
		this.dni = dniInicial;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	// Si no hay Setter, el DNI nunca podrá cambiarse después de crear al Titular.
	// ¡Eso nos da un control total sobre la seguridad de nuestro objeto!
//	public void setDni(String dni) {
//		this.dni = dni;
//	}

}
