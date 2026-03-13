package crud;

import java.util.ArrayList;

public class GestorAlumnos {
	private ArrayList<Alumno> listaAlumnos;

	public GestorAlumnos() {

		this.listaAlumnos = new ArrayList<>();
	}


	public void mostrarListado() {
		if (listaAlumnos.isEmpty()) {
			System.out.println("No hay alumnos en la lista");
		} else {
			for (int i = 0; i < this.listaAlumnos.size(); i++) {
				System.out.println(this.listaAlumnos.get(i).toString());
			}
		}
	}

	public void añadirAlumno(Alumno nuevoAlumno) {
		this.listaAlumnos.add(nuevoAlumno);
	}

	public boolean modificarAlumno(String nombreBuscado, double nuevaNota) {
		boolean modificado = false;
		for (int i = 0; i < this.listaAlumnos.size() && !modificado; i++) {
			if (this.listaAlumnos.get(i).getNombre().equalsIgnoreCase(nombreBuscado)) {
				this.listaAlumnos.get(i).setNotaMedia(nuevaNota);
				modificado = true;
			}
		}
		return modificado;
	}

	public boolean borrarAlumno(String nombreBuscado) {
		boolean borrado = false;
		for (int i = 0; i < this.listaAlumnos.size() && !borrado; i++) {
			if (this.listaAlumnos.get(i).getNombre().equalsIgnoreCase(nombreBuscado)) {
				this.listaAlumnos.remove(i);
				borrado = true;
			}
		}
		return borrado;
	}

}
