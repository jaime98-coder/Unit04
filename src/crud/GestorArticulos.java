package crud;

import java.util.ArrayList;

public class GestorArticulos {
	private ArrayList<Articulo> articulos;

	/**
	 * Crea un gestor de artículos con una lista vacía
	 */
	public GestorArticulos() {
		articulos = new ArrayList<Articulo>();
	}

	/**
	 * Devuelve listade articulos
	 * 
	 * @return lista de artículos
	 */
	public ArrayList<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(ArrayList<Articulo> articulos) {
		this.articulos = articulos;
	}

	public Articulo buscarPorCodigo(String codigo) {
		// En este caso cree un articulo de salida inicializado en null para no poner
		// mas de un return, pero realmente QUIZAS no es necesario, y se puede ponre
		// return articulo dentro del if, y return null al final
		Articulo articuloDeSalida = null;
		for (Articulo articulo : this.articulos) {
			// Uso get porque es privado el atributo, y hago equals con el codigo
			// introducido
			if (articulo.getCodigo().equalsIgnoreCase(codigo)) {
				articuloDeSalida = articulo;
			}
		}
		return articuloDeSalida;
	}

	public boolean modificarArticulo(String codigo, String nuevoNombre, double nuevoPrecioCompra,
			double nuevoPrecioVenta, int nuevoStock) {
		boolean esModificado = true;
		Articulo articulo = buscarPorCodigo(codigo);
		if (articulo == null) {
			esModificado = false;
		} else {
			articulo.setNombre(nuevoNombre);
			articulo.setPrecioCompra(nuevoPrecioCompra);
			articulo.setPrecioVenta(nuevoPrecioVenta);
			articulo.setStock(nuevoStock);
		}
		return esModificado;

	}

}
