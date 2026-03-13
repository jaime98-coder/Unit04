package exercisesC;

public class Persona {
	private String dni;
	private String nombre;
	private String apellidos;
	private int edad;
	private boolean esMayorEdad;

	public Persona(String dni, String nombre, String apellidos, int edad) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;

		if (this.edad >= 18) {
			this.esMayorEdad = true;
		} else {
			this.esMayorEdad = false;
		}

	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public boolean isEsMayorEdad() {
		return esMayorEdad;
	}



	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad
				+ ", esMayorEdad=" + esMayorEdad + "]";
	}
}
