package modeloexamen001biblioteca;

import java.util.ArrayList;

/**
 * Clase para gestionar prestamos
 * 
 */
public class GestorPrestamos {
	ArrayList<Prestamo> listaPrestamos;

	public GestorPrestamos() {
		listaPrestamos = new ArrayList<Prestamo>();
	}

	public Prestamo buscarPrestamoPorId(String idPrestamo) {
		Prestamo prestamoABuscar = null;
		for (Prestamo prestamo : listaPrestamos) {
			if (prestamo.getIdPrestamo().equalsIgnoreCase(idPrestamo)) {
				prestamoABuscar = prestamo;
			}
		}
		return prestamoABuscar;
	}

	/**
	 * Método para registar prestamo
	 * 
	 * @param idPrestamo    para localizar si corresponde a un prestamo ya
	 *                      registrado
	 * @param socioPrestamo para localizar si el socio puede realizar un prestamo
	 * @param libroPrestamo para localizar si el libro está disponible para realizar
	 *                      un prestamo
	 * @return True --> Se registra el prestamo. False --> No se registra el
	 *         prestamo, ya que el ID de prestamo corresponde a otro prestamo
	 *         registrado, o el socio no puede realizar un prestamo, o el libro no
	 *         está disponible para realizar un prestamo.
	 */
	public boolean registrarPrestamo(String idPrestamo, Socio socioPrestamo, Libro libroPrestamo) {
		boolean fueRegistrado = false;
		Prestamo prestamo = buscarPrestamoPorId(idPrestamo);
		if (prestamo == null) {
			if (socioPrestamo.isPuedePrestamo() && libroPrestamo.isDisponibilidad()) {
				Prestamo nuevoPrestamo = new Prestamo(idPrestamo, socioPrestamo, libroPrestamo);
				socioPrestamo.setCantidadEnPrestamo(socioPrestamo.getCantidadEnPrestamo() + 1);
				libroPrestamo.setCantidadEjemplares(libroPrestamo.getCantidadEjemplares() - 1);
				listaPrestamos.add(nuevoPrestamo);
				fueRegistrado = true;
			}
		}

		return fueRegistrado;

	}

	/**
	 * Método para registrar devolucion
	 * 
	 * @param idPrestamo.      Para localizar el prestamo.
	 * @param socioDevolucion. Socio que devuelve
	 * @param libroDevolucion. Libro devuelto
	 * @return True--> Se devuelve prestamo. False --> No se devuelve ID no
	 *         corresponde
	 */
	public boolean registrarDevolucion(String idPrestamo, Socio socioDevolucion, Libro libroDevolucion) {
		boolean fueDevuelto = false;
		Prestamo prestamo = buscarPrestamoPorId(idPrestamo);

		if (prestamo != null && prestamo.isDevuelto() == false) {

			prestamo.setDevuelto(true);

			Socio socio = prestamo.getSocio();
			socio.setCantidadEnPrestamo(socio.getCantidadEnPrestamo() - 1);

			Libro libro = prestamo.getLibro();
			libro.setCantidadEjemplares(libro.getCantidadEjemplares() + 1);

			fueDevuelto = true;
		}

		return fueDevuelto;
	}

	public void consultarEstadoPrestamo(String idPrestamo) {
		Prestamo prestamo;
		prestamo = buscarPrestamoPorId(idPrestamo);
		if (prestamo != null) {
			if (prestamo.isDevuelto()) {
				System.out.println("El prestamo con id: " + idPrestamo + " ya fue devuelto");
			} else {
				System.out.println("El prestamo con id: " + idPrestamo + " NO fue devuelto");
			}
		} else {
			System.out.println("El id introducido no corresponde a ningún prestamo");
		}
	}

}
