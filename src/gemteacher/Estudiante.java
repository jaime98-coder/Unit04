package gemteacher;

public class Estudiante {
	String nombre;
	int edad;
	double nota;
	/**
	 * @param nombre
	 * @param edad
	 * @param nota
	 */
	public Estudiante(String nombre, int edad, double nota) {
		this.nombre = nombre;
		this.edad = edad;
		this.nota = nota;
	}
	
	public void presentarse() {
		System.out.println("Hola, soy "+nombre+" y tengo "+edad+" años, y mi nota del último examen fue "+nota);
	}
	
	
}
