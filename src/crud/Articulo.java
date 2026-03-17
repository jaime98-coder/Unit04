package crud;

public class Articulo {
	private String codigo;
	private String nombre;
	private double precioVenta;
	private double precioCompra;
	private int stock;

	/**
	 * Crea un artículo con todos sus datos
	 * 
	 * @param codigo
	 * @param nombre
	 * @param precioVenta
	 * @param precioCompra
	 * @param stock
	 */
	public Articulo(String codigo, String nombre, double precioVenta, double precioCompra, int stock) {
		setCodigo(codigo);
		setNombre(nombre);
		setPrecioVenta(precioVenta);
		setPrecioCompra(precioCompra);
		setStock(stock);
	}

	/**
	 * Crea un artículo por defecto
	 */
	public Articulo() {

	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		if (precioVenta > 0) {
			this.precioVenta = precioVenta;
		}
	}

	public double getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(double precioCompra) {
		if (precioCompra > 0) {
			this.precioCompra = precioCompra;
		}
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		if (stock >= 0) {
			this.stock = stock;
		}
	}

	/**
	 * Incrementa el sotck del articulo
	 * 
	 * @param cantidad numero de articulos que se añaden
	 */
	// Desactivado para que el gestor de articulos controle el stock
//	public void entradaMercancia(int cantidad) {
//		if (cantidad > 0) {
//			this.stock += cantidad;
//		} 
//	}
//
//	public boolean salidaMercancia(int cantidad) {
//		boolean esPosible = true;
//		if (cantidad > this.stock) {
//			esPosible = false;
//		} else {
//			stock -= cantidad;
//		}
//
//		return esPosible;
//
//	}

	@Override
	public String toString() {
		return "Articulo [codigo=" + codigo + ", nombre=" + nombre + ", precioVenta=" + precioVenta + ", precioCompra="
				+ precioCompra + ", stock=" + stock + "]";
	}
}
