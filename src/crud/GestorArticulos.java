package crud;

import java.util.ArrayList;

public class GestorArticulos {
	ArrayList<Articulo> listaArticulos = new ArrayList<>();

	public GestorArticulos(ArrayList<Articulo> listaArticulos) {
		this.listaArticulos = listaArticulos;
	}

	/**
	 * Método para mostrar lista de artículos
	 */
	public void mostrarListadoArticulos() {
		if (listaArticulos.isEmpty()) {
			System.out.println("No hay ningún artículo para mostrar");
		} else {
			for (int i = 0; i < this.listaArticulos.size(); i++) {
				System.out.println(this.listaArticulos.get(i).toString());
			}
		}
	}

	/**
	 * Método para dar de alta el articulo
	 * 
	 * @param articulo. Articulo a añadir
	 */
	public void altaArticulo(Articulo articuloNuevo) {
		
	}

	/**
	 * Método para dar de baja el articulo (eliminar)
	 * 
	 * @param articulo. Articulo a dar de baja
	 */
	public void bajaArticulo(String nombreArticulo) {
		
	}

/**
 * Método para modificar un artículo
 * @param nombre. Nombre del articulo
 * @param nuevoPrecio. Nuevo precio del articulo
 * @param nuevoIva. Nuevo iva
 */
	public void modificarArticulo(String nombre, double nuevoPrecio, int nuevoIva) {

	}

}
