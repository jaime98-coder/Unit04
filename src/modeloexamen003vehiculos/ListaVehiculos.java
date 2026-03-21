package modeloexamen003vehiculos;

import java.util.ArrayList;

public class ListaVehiculos {
	ArrayList<Vehiculo> listaVehiculos;

	/**
	 * Constructor para crear una lista de vehiculos (gestor de vehiculos)
	 */
	public ListaVehiculos() {
		listaVehiculos = new ArrayList<Vehiculo>();
	}

	@Override
	public String toString() {
		return "ListaVehiculos [listaVehiculos=" + listaVehiculos + "]";
	}

	/**
	 * Método para buscar por matrícula
	 * 
	 * @param matricula
	 * @return
	 */
	public Vehiculo buscarPorMatricula(String matricula) {
		Vehiculo vehiculoBuscado = null;
		for (Vehiculo vehiculo : listaVehiculos) {
			// Le pregunte al objeto si él mismo coincide con esa matricula
			if (vehiculo.sonIguales(matricula)) {
				vehiculoBuscado = vehiculo;
				break;
			}
		}
		return vehiculoBuscado;
	}

	/**
	 * Método para añadir un vehiculo a la lista
	 * 
	 * @param vehiculo
	 * @return
	 */
	public boolean anadirVehiculo(String matricula, String modelo, double precioBasePorDia, double pctRecargoPremium,
			int diasAlquiler) {
		boolean vehiculoAñadido = false;
		Vehiculo vehiculoAAñadir = buscarPorMatricula(matricula);
		if (vehiculoAAñadir == null) {
			vehiculoAAñadir = new Vehiculo(matricula, modelo, precioBasePorDia, pctRecargoPremium, diasAlquiler);
			listaVehiculos.add(vehiculoAAñadir);
			vehiculoAñadido = true;
		}

		return vehiculoAñadido;

	}

	/**
	 * Método para listar todos los vehiculos
	 */
	public void listarTodos() {
		if (listaVehiculos.isEmpty()) {
			System.out.println("La lista está vacía");
		} else {
			for (Vehiculo vehiculo : listaVehiculos) {
				System.out.println(vehiculo.toString());
			}
		}
	}

	/**
	 * 
	 * @param matricula
	 * @param dias
	 * @return
	 */
	public boolean modificarDiasAlquilados(String matricula, int dias) {
		boolean fueModificado = false;
		Vehiculo vehiculoAModificar = buscarPorMatricula(matricula);
		if (vehiculoAModificar != null) {
			vehiculoAModificar.setDiasAlquilados(dias);
			fueModificado = true;
		}
		return fueModificado;
	}

	/**
	 * Método para modificar porcentaje (%) recargo premium
	 * 
	 * @param matricula.  Para localizar el coche
	 * @param porcentaje. Nuevo porcentaje
	 * @return True --> Recargo modificado. False --> Recargo no modificado
	 */
	public boolean modificarRecargoPremium(String matricula, double porcentaje) {
		boolean fueModificado = false;
		Vehiculo vehiculoAModificar = buscarPorMatricula(matricula);
		if (vehiculoAModificar != null) {
			vehiculoAModificar.setPctRecargoPremium(porcentaje);
			fueModificado = true;
		}

		return fueModificado;
	}

	/**
	 * Método para eliminar vehículo por matrícula
	 * 
	 * @param matricula. Para localizar el coche y poder eliminarlo
	 * @return True --> Vehiculo eliminado. False --> Vehiculo no eliminado
	 *         (matricula no corresponde)
	 */
	public boolean eliminarPorMatricula(String matricula) {
		boolean fueEliminado = false;
		Vehiculo vehiculo = buscarPorMatricula(matricula);
		if (vehiculo != null) {
			listaVehiculos.remove(vehiculo);
			fueEliminado = true;
		}

		return fueEliminado;
	}

	/**
	 * Método para calcular el ingreso total de los recargos premium de todos los
	 * vehículos contenidos en la listaVehiculo
	 * 
	 * @return cantidad en euros de ingreso total
	 */
	public double calcularIngresoTotalRecargos() {
		double sumaTotalRecargos = 0;

		for (Vehiculo vehiculo : listaVehiculos) {
			sumaTotalRecargos += vehiculo.recargoPremiumEuros(vehiculo.getPctRecargoPremium())
					+ vehiculo.importeSeguroEuros();
		}

		return sumaTotalRecargos;

	}

	/**
	 * Método para mostar listaso de vehículos premium
	 */
	public void listarVehiculosPremium() {

		for (Vehiculo vehiculo : listaVehiculos) {
			if (vehiculo.recargoSuperior12()) {
				System.out.println(vehiculo.toString());
			}
		}
	}

}
