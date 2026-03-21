package modeloexamengem01;

import java.util.ArrayList;

public class ListaHabitaciones {
	ArrayList<Habitacion> listaHabitaciones = new ArrayList<Habitacion>();

	public ListaHabitaciones() {
		listaHabitaciones = new ArrayList<Habitacion>();
	}

	/**
	 * Método para buscar una habitación por código
	 * 
	 * @param codigo. Para meterlo como parametro para localizar habitacion @return.
	 *                Devuelve la habitación que coincida con el código. O bien Null
	 *                si no lo hace
	 */
	public Habitacion buscarPorCodigo(String codigo) {
		Habitacion habitacionBuscada = null;

		for (Habitacion habitacion : listaHabitaciones) {
			if (habitacion.sonIguales(codigo)) {
				habitacionBuscada = habitacion;
			}
		}
		return habitacionBuscada;

	}

	/**
	 * Método para anadir habitacion.
	 * 
	 * @param codigo.          Primero para buscar si ya coincide con el codigo de
	 *                         una que esté en la listaHabitaciones
	 * @param tipo
	 * @param precioBaseNoche
	 * @param pctServicioExtra
	 * @param nochesReservadas
	 * @return True --> Habitación creada y añadida correctamente . False --> No
	 *         añadida porque el código coincida con otra
	 */
	public boolean anadirHabitacion(String codigo, String tipo, double precioBaseNoche, double pctServicioExtra,
			int nochesReservadas) {
		boolean habitacionAnadida = false;
		Habitacion habitacionAnadir = buscarPorCodigo(codigo);
		if (habitacionAnadir == null) {
			habitacionAnadir = new Habitacion(codigo, tipo, precioBaseNoche, pctServicioExtra, nochesReservadas);
			listaHabitaciones.add(habitacionAnadir);
			habitacionAnadida = true;
		}
		return habitacionAnadida;

	}

	/**
	 * Método para listar habitaciones
	 */
	public void listarTodas() {
		if (listaHabitaciones.isEmpty()) {
			System.out.println("La lista de habitaciones está vacía");
		} else {
			System.out.println("Listado completo de habitaciones: ");
			for (Habitacion habitacion : listaHabitaciones) {

				System.out.println(habitacion.toString());

			}
		}
	}

	/**
	 * Método para modificar noches reservadas
	 * 
	 * @param codigo
	 * @param noches
	 * @return
	 */
	public boolean modificarNochesReservadas(String codigo, int noches) {
		boolean nochesModificadas = false;
		Habitacion habitacionAModificar = buscarPorCodigo(codigo);
		if (habitacionAModificar != null) {
			habitacionAModificar.setNochesReservadas(noches);
			nochesModificadas = true;
		}
		return nochesModificadas;
	}

	/**
	 * Método para modificar servicios extras
	 * 
	 * @param codigo
	 * @param porcentaje
	 * @return True --> Servicios extras modificados. False --> Servicios no
	 *         modificados
	 */
	public boolean modificarServicioExtra(String codigo, double porcentaje) {
		boolean serviciosModificados = false;
		Habitacion habitacionAModificar = buscarPorCodigo(codigo);
		if (habitacionAModificar != null) {
			habitacionAModificar.setPctServicioExtra(porcentaje);
			serviciosModificados = true;
		}
		return serviciosModificados;
	}

	/**
	 * Método par aeliminar por codigo
	 * 
	 * @param codigo. Para localizar habitacion y eliminarla de la lista (!=
	 * @return True --> Se eliminó correctamente (!=null). False --> No se eliminó
	 *         porque no coincide el codigo (null)
	 */
	public boolean eliminarPorCodigo(String codigo) {
		boolean habitacionEliminada = false;
		Habitacion habitacionAEliminar = buscarPorCodigo(codigo);
		if (habitacionAEliminar != null) {
			listaHabitaciones.remove(habitacionAEliminar);
			habitacionEliminada = true;
		}

		return habitacionEliminada;
	}

	/**
	 * Método para calcular el ingreso total
	 * 
	 * @return
	 */
	public double calcularIngresoTotalServiciosExtra() {
		double sumaExtrasTodasHabitaciones = 0;
		for (Habitacion habitacion : listaHabitaciones) {
			sumaExtrasTodasHabitaciones += habitacion.importeTotalExtras();
		}
		return sumaExtrasTodasHabitaciones;
	}

	/**
	 * Método para listar todas las habitaciones VIP (más de 15% extras)
	 */
	public void listarHabitacionesVIP() {
		for (Habitacion habitacionVIP : listaHabitaciones) {
			if (habitacionVIP.serviciosExtrasMas15()) {
				System.out.println(habitacionVIP.toString());
			}
		}
	}

}
