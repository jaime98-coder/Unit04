package exercisesC;

public class Articulo {
	private String nombre;
	private double precio; // Precio sin impuestos
	private int iva; // Representa el porcentaje (21)
	private int cuantosQuedan; // Stock

	public Articulo(String nombre, double precio, int iva, int cuantosQuedan) {
		if (!nombre.isBlank()) {
			this.nombre = nombre;
		}
		if (precio > 0) {
			this.precio = precio;
		}
		if (iva >= 0 && iva < 100) {
			this.iva = iva;
		}

		if (cuantosQuedan >= 0) {
			this.cuantosQuedan = cuantosQuedan;
		}
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
		}
	}

	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {

		if (iva >= 0 && iva <= 100) {
			this.iva = iva;
		}
	}

	public int getCuantosQuedan() {
		return cuantosQuedan;
	}

	public void setCuantosQuedan(int cuantosQuedan) {
		if (cuantosQuedan >= 0) {
			this.cuantosQuedan = cuantosQuedan;
		}
	}

	@Override
	public String toString() {
		return "Articulo [nombre=" + nombre + ", precio=" + precio + ", iva=" + iva + ", cuantosQuedan=" + cuantosQuedan
				+ "]";
	}




}