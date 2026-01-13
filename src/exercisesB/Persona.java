package exercisesB;

public class Persona {
	String dni;
	String nombre;
	String apellidos;
	int edad;
	boolean esMayorEdad;

	Persona(String dni, String nombre, String apellidos, int edad, boolean esMayorEdad) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.esMayorEdad = esMayorEdad;
	}
}
