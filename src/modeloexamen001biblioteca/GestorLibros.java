package modeloexamen001biblioteca;

import java.util.ArrayList;

public class GestorLibros {
	ArrayList<Libro> listaLibros;

	public GestorLibros(ArrayList<Libro> listaLibros) {
		this.listaLibros = listaLibros;
	}

	public GestorLibros() {
		listaLibros = new ArrayList<Libro>();
	}

	public ArrayList<Libro> getListaLibros() {
		return listaLibros;
	}

	public void setListaLibros(ArrayList<Libro> listaLibros) {
		this.listaLibros = listaLibros;
	}

	@Override
	public String toString() {
		return "GestorLibros [listaLibros=" + listaLibros + "]";
	}

	/**
	 * Método para comprobar el libro
	 * 
	 * @param idLibro. Para introducir el ID y así localizar si el ID correspondea
	 *                 otro libro
	 * @return Devuelve el libro que corresponde con el id, o si devuelve null es
	 *         que no hay libro con ese idLibro
	 */
	public Libro buscarLibroPorId(String idLibro) {
		Libro libroBuscado = null;
		for (Libro libro : listaLibros) {
			if (libro.getIdLibro().equalsIgnoreCase(idLibro)) {
				libroBuscado = libro;
				break;
			}
		}
		return libroBuscado;

	}

	/**
	 * Método para dar de alta libro (previa búsqueda)
	 * 
	 * @param idLibro
	 * @return
	 */
	public boolean altaLibro(String idLibro, String nombre, int cantidadEjemplares) {
		boolean esDadoAlta = false;
		Libro libroAlta;
		libroAlta = buscarLibroPorId(idLibro);
		if (libroAlta == null) {
			libroAlta = new Libro(idLibro, nombre, cantidadEjemplares);
			listaLibros.add(libroAlta);
			esDadoAlta = true;
		}
		return esDadoAlta;
	}

	/**
	 * Imprimir listado de libros si hubiese O si está vacia la lista de libros,
	 * imprimir mensaje indicandoselo al usuario
	 */
	public void consultarLibros() {
		if (listaLibros.isEmpty()) {
			System.out.println("No hay libros existentes");
		} else {
			for (Libro libro : listaLibros) {
				System.out.println(libro.toString());
			}
		}
	}

	/**
	 * Método para modificar información de los libros
	 * 
	 * @param idLibro.                 Para localizar el libro (ya que el id es
	 *                                 unico=
	 * @param nuevoNombre.             Para modificar mediante entrada el nombre.
	 * @param nuevaCantidadEjemplares. Para modificar mediante entrada la cantidad
	 * @return True --> Se pudo modificar. False --> No se pudo modificar
	 */
	public boolean modificarInformacion(String idLibro, String nuevoNombre, int nuevaCantidadEjemplares) {
		boolean fueModificado = false;
		Libro libroAModificar;
		libroAModificar = buscarLibroPorId(idLibro);
		if (libroAModificar != null) {
			libroAModificar.setNombre(nuevoNombre);
			libroAModificar.setCantidadEjemplares(nuevaCantidadEjemplares);
			fueModificado = true;
		}
		return fueModificado;
	}

	/**
	 * Método para eliminar el libro
	 * 
	 * @param idLibro. Para poder localizar el libro que queremos eliminar
	 * @return True--> El libro se pudo eliminar. False --> EL libro NO se pudo
	 *         eliminar
	 */
	public boolean eliminarLibro(String idLibro) {
		boolean fueEliminado = false;
		Libro libroAEliminar;
		libroAEliminar = buscarLibroPorId(idLibro);
		if (libroAEliminar != null) {
			listaLibros.remove(libroAEliminar);
			fueEliminado = true;
		}
		return fueEliminado;
	}

}
