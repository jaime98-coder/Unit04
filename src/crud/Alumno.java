package crud;

public class Alumno {
	// Atributos
	private String nombre;

	private double notaMedia;

	// Constructor
	public Alumno(String nombre, double notaMedia) {

		this.nombre = nombre;

		this.notaMedia = notaMedia;
	}

	// Getters and Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getNotaMedia() {
		return notaMedia;
	}

	public void setNotaMedia(double notaMedia) {
		this.notaMedia = notaMedia;
	}

	public void añadirAlumno() {

	}

	public void imprimirLista() {

	}

}
