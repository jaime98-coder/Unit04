package modeloexamengem02;

import java.util.ArrayList;

/**
 * Clase ListaMaquinaria gestora de la lista de máquinas (clase Maquina) la cual
 * creará los ArrayList y hará todo lo relacionado con la gestión de las
 * máquinas
 */
public class ListaMaquinaria {
	private ArrayList<Maquina> listaMaquinaria;

	/**
	 * Constructor sin parametros de entrada para crear el ArrayList
	 */
	public ListaMaquinaria() {
		listaMaquinaria = new ArrayList<Maquina>();
	}

	/**
	 * Método para buscar la máquina por código
	 * 
	 * @param codigo. Parametro para comprobar si son iguales o no
	 * @return Si coincide el código con una de la lista, devuelve la máquinan
	 *         buscada, sino devuelve NULL
	 */
	public Maquina buscarPorCodigo(String codigo) {
		Maquina maquinaBuscada = null;
		for (Maquina maquina : listaMaquinaria) {
			if (maquina.sonIguales(codigo)) {
				maquinaBuscada = maquina;
				break;
			}
		}

		return maquinaBuscada;
	}

	/**
	 * Método para añadir la máquina si no existe ya (coincide el código con uno de
	 * la listaMaquinaria;
	 * 
	 * @param codigo.           Parametro para comprobar si son iguales
	 * @param tipo.             Tipo de máquina (de las permitidas dentro del set)
	 * @param precioBaseDiario.
	 * @param pctSeguroRiesgo.  (0 - 20)
	 * @param diasAlquiler      (>0)
	 * @return True --> La máquina fue creada y añadida a la listaMaquinaria. False
	 *         --> Si no fue añadida
	 */
	public boolean anadirMaquina(String codigo, String tipo, double precioBaseDiario, double pctSeguroRiesgo,
			int diasAlquiler) {
		boolean maquinaAnadida = false;
		Maquina maquinaAAñadir = buscarPorCodigo(codigo);
		if (maquinaAAñadir == null) {
			maquinaAAñadir = new Maquina(codigo, tipo, precioBaseDiario, pctSeguroRiesgo, diasAlquiler);
			listaMaquinaria.add(maquinaAAñadir);
			maquinaAnadida = true;
		}
		return maquinaAnadida;

	}

	/**
	 * Método para listar todas las máquinas
	 */
	public void listarTodas() {
		if (listaMaquinaria.isEmpty()) {
			System.out.println("La lista está VACIA");
		} else {
			for (Maquina maquina : listaMaquinaria) {
				System.out.println(maquina.toString());
			}
		}
	}

	/**
	 * Método para modificar los dias del alquiler
	 * 
	 * @param codigo.     Para localizar si la máquina existe.
	 * @param nuevosDias. Nuevos dias que tendrá @return. True --> Dias modificados
	 *                    (el codigo de la maquina coincide). False --> No se
	 *                    modificó, porque el codigo no coincide y devuelve null la
	 *                    busqueda
	 */
	public boolean modificarDiasAlquiler(String codigo, int nuevosDias) {
		boolean diasModificados = false;
		Maquina maquinaAModificarDias = buscarPorCodigo(codigo);
		if (maquinaAModificarDias != null) {
			maquinaAModificarDias.setDiasAlquiler(nuevosDias);
			diasModificados = true;
		}
		return diasModificados;
	}

	/**
	 * Método para modificar el seguro de riesgo
	 * 
	 * @param codigo.               Parametro para localizar la máquina
	 * @param nuevoPctSeguroRiesgo. Nuevo porcentaje que tendrá la máquina
	 * @return True --> Seguro modificado (código coincide). False --> Código no
	 *         coincide con ninguna máquina
	 */
	public boolean modificarSeguroRiesgo(String codigo, double nuevoPctSeguroRiesgo) {
		boolean seguroModificado = false;
		Maquina maquinaAModificarSeguro = buscarPorCodigo(codigo);
		if (maquinaAModificarSeguro != null) {
			maquinaAModificarSeguro.setPctSeguroRiesgo(nuevoPctSeguroRiesgo);
			seguroModificado = true;
		}
		return seguroModificado;
	}

	/**
	 * Método para eliminar la máquina por código
	 * 
	 * @param codigo @return. True --> Si el código introducido coincide con el de
	 *               alguna maquina de la lista, la elimina. False --> Si el código
	 *               NO coincide con alguna maquina de la lista, no hace nada
	 */
	public boolean eliminarPorCodigo(String codigo) {
		boolean maquinaEliminada = false;
		Maquina maquinaAEliminar = buscarPorCodigo(codigo);
		if (maquinaAEliminar != null) {
			listaMaquinaria.remove(maquinaAEliminar);
			maquinaEliminada = true;
		}
		return maquinaEliminada;
	}

	/**
	 * Método para calcular el ingreso total de los SEGUROS exclusivamente en euros
	 * 
	 * @return totalIngresoSeguros. El total en euros
	 */
	public double calcularIngresoTotalSeguros() {
		double totalIngresoSeguros = 0;
		for (Maquina maquina : listaMaquinaria) {
			totalIngresoSeguros += maquina.importeTotalSeguroRiesgo();
		}
		return totalIngresoSeguros;
	}

	/**
	 * Método para listar las máquinas de riesgo alto (superior al 12%)
	 * Si no hay ninguna, mostrará un mensaje indicand que no las hay
	 */
	public void listarMaquinasRiesgoAlto() {
		boolean hayAlgunaRiesgoAlto = false;
		for (Maquina maquinaRiesgoAlto : listaMaquinaria) {
			if (maquinaRiesgoAlto.esRiesgoAlto()) {
				System.out.println(maquinaRiesgoAlto.toString());
				hayAlgunaRiesgoAlto = true;
			}
			
			if (!hayAlgunaRiesgoAlto) {
				System.out.println("No hay máquinas de riesgo alto (superior al 12%)");
			}
		}
	}

}
