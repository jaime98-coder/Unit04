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
				break;
			}
		}
		return articuloDeSalida;
	}

	public boolean altaArticulo(String codigo, String nombre, double nuevoPrecioVenta, double nuevoPrecioCompra,
			int stock) {
		Articulo articulo = buscarPorCodigo(codigo);
		boolean esAlta = false;
		if (articulo == null) {
			articulo = new Articulo();
			articulo.setCodigo(codigo);
			articulo.setNombre(nombre);
			articulo.setPrecioVenta(nuevoPrecioVenta);
			articulo.setPrecioCompra(nuevoPrecioCompra);
			articulo.setStock(stock);
			esAlta = true;
			articulos.add(articulo);
		}
		return esAlta;
	}

	public boolean bajaArticulo(String codigo) {
		boolean esBaja = true;
		Articulo articulo = buscarPorCodigo(codigo);
		if (articulo == null) {
			esBaja = false;
		} else {
			articulos.remove(articulo);
		}
		return esBaja;
	}

	public boolean modificarArticulo(String codigo, String nuevoNombre, double nuevoPrecioVenta,
			double nuevoPrecioCompra, int nuevoStock) {
		boolean esModificado = true;
		Articulo articulo = buscarPorCodigo(codigo);
		if (articulo == null) {
			esModificado = false;
		} else {
			articulo.setNombre(nuevoNombre);
			articulo.setPrecioVenta(nuevoPrecioVenta);
			articulo.setPrecioCompra(nuevoPrecioCompra);
			articulo.setStock(nuevoStock);
		}
		return esModificado;

	}

	public boolean entradaMercancia(String codigo, int cantidadEntrada) {
		boolean entradaExitosa = false;
		Articulo articulo = buscarPorCodigo(codigo);
		if (articulo != null && cantidadEntrada > 0) {
			articulo.setStock(articulo.getStock() + cantidadEntrada);
			entradaExitosa = true;
		}
		return entradaExitosa;
	}

	public boolean salidaMercancia(String codigo, int cantidadSalida) {
		boolean salidaExitosa = false;
		Articulo articulo = buscarPorCodigo(codigo);
		if (articulo != null && cantidadSalida > 0 && articulo.getStock() >= cantidadSalida) {
			articulo.setStock(articulo.getStock() - cantidadSalida);
			// articulo.salidaMercancia(cantidadSalida); // Si hubieramos hecho el metodo
			// salidaMercancia en Articulo, lo podriamos usar aqui
			salidaExitosa = true;
		}
		return salidaExitosa;
	}

	public void mostrarMenu() {
		System.out.println("1. Alta de artículo");
		System.out.println("2. Baja de artículo");
		System.out.println("3. Modificación de artículo");
		System.out.println("4. Entrada de mercancía");
		System.out.println("5. Salida de mercancía");
		System.out.println("6. Listado de artículos");
		System.out.println("7. Salir");

	}

	@Override
	public String toString() {
		return "GestorArticulos [articulos=" + articulos + "]";
	}

}
