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
		if (notaMedia >= 0 && notaMedia <= 10) {
			this.notaMedia = notaMedia;
		}
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", notaMedia=" + notaMedia + "]";
	}

}
