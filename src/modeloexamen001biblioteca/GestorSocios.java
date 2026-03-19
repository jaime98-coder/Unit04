package modeloexamen001biblioteca;

import java.util.ArrayList;

public class GestorSocios {
	ArrayList<Socio> listaSocios;

	public GestorSocios(ArrayList<Socio> listaSocios) {
		this.listaSocios = listaSocios;
	}

	public GestorSocios() {
		listaSocios = new ArrayList<Socio>();
	}

	public ArrayList<Socio> getListaLibros() {
		return listaSocios;
	}

	public void setListaSocios(ArrayList<Socio> listaSocios) {
		this.listaSocios = listaSocios;
	}

	@Override
	public String toString() {
		return "GestorSocios [listaSocios=" + listaSocios + "]";
	}

	/**
	 * Método para comprobar el si el id corresponde a un socio
	 * 
	 * @param idSocio. Para introducir el ID y así localizar si el ID correspondea
	 *                 otro idSocio
	 * @return Devuelve el idSocio que corresponde con el id, o si devuelve null es
	 *         que no hay socio con ese idSocio
	 */
	public Socio buscarSocioPorId(String idSocio) {
		Socio socioBuscado = null;
		for (Socio socio : listaSocios) {
			if (socio.getIdSocio().equalsIgnoreCase(idSocio)) {
				socioBuscado = socio;
				break;
			}
		}
		return socioBuscado;

	}

	/**
	 * Método para dar de alta a un socio nuevo (previa búsqueda)
	 * 
	 * @param idSocio
	 * @return
	 */
	public boolean altaSocio(String idSocio, String nombre, int numeroTlf, int cantidadEnPrestamo) {
		boolean esDadoAlta = false;
		Socio socioAlta;
		socioAlta = buscarSocioPorId(idSocio);
		if (socioAlta == null) {
			socioAlta = new Socio(idSocio, nombre, numeroTlf, cantidadEnPrestamo);
			listaSocios.add(socioAlta);
			esDadoAlta = true;
		}
		return esDadoAlta;
	}

	/**
	 * Imprimir listado de socios si hubiese O si está vacia la lista de socios,
	 * imprimir mensaje indicandoselo al usuario
	 */
	public void consultarSocios() {
		if (listaSocios.isEmpty()) {
			System.out.println("No hay socios dados de alta");
		} else {
			for (Socio socio : listaSocios) {
				System.out.println(socio.toString());
			}
		}
	}

	/**
	 * Metodo para modificar socios
	 * 
	 * @param idSocio
	 * @param nuevoNombre
	 * @param nuevoNumeroTlf
	 * @return True --> Socio modifcado. False --> Socio no pudo modificarse
	 */
	public boolean modificarInformacion(String idSocio, String nuevoNombre, int nuevoNumeroTlf) {
		boolean fueModificado = false;
		Socio socioAModificar;
		socioAModificar = buscarSocioPorId(idSocio);

		if (socioAModificar != null) {
			socioAModificar.setNombre(nuevoNombre);
			socioAModificar.setNumeroTelefono(nuevoNumeroTlf);
			fueModificado = true;
		}
		return fueModificado;
	}

	/**
	 * Método para eliminar socios
	 * 
	 * @param idLibro. Para poder localizar el libro que queremos eliminar
	 * @return True--> El libro se pudo eliminar. False --> EL libro NO se pudo
	 *         eliminar
	 */
	public boolean eliminarSocio(String idSocio) {
		boolean fueEliminado = false;
		Socio socioAEliminar;
		socioAEliminar = buscarSocioPorId(idSocio);
		if (socioAEliminar != null) {
			listaSocios.remove(socioAEliminar);
			fueEliminado = true;
		}
		return fueEliminado;
	}

}
