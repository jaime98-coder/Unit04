package crud;

public class Articulo {
	private String nombre;
	private double precio; // Precio sin impuestos
	private int iva; // Representa el porcentaje
	private int stock;

	public Articulo(String nombre, double precio, int iva, int stock) {
		setNombre(nombre);
		setPrecio(precio);
		setIva(iva);
		setStock(stock);
	}

	public Articulo() {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		if (precio >= 0) {
			this.precio = precio;
		} else {
			this.precio = 0;
		}
	}

	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {
		if (iva >= 0 && iva <= 100) {
			this.iva = iva;
		} else {
			this.iva = 21;
		}
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
		if (stock >= 0) {
			this.stock = stock;
		} else {
			this.stock = 0;
		}
	}

	@Override
	public String toString() {
		return "Articulo [nombre=" + nombre + ", precio=" + precio + ", iva=" + iva + ", stock=" + stock + "]";
	}

}
