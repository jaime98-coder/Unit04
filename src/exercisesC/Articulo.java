package exercisesC;

public class Articulo {
	private String nombre;
	private double precio; // Precio sin impuestos
	private int iva; // Representa el porcentaje (21)
	private int cuantosQuedan; // Stock

	public Articulo(String nombre, double precio, int iva, int cuantosQuedan) {
		this.setNombre(nombre);
		this.setPrecio(precio);
		this.setIva(iva);
		this.setCuantosQuedan(cuantosQuedan);

	}

	public Articulo() {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (!nombre.isBlank()) {
			this.nombre = nombre;
		} else {
			System.out.println("Nombre erróneo introducido");
			this.nombre = "Desconocido";
		}
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		if (precio >= 0) {
			this.precio = precio;
		} else {
			System.out.println("Precio erróneo");
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
			System.out.println("Impuesto erróneo");
			this.iva = 0;
		}
	}

	public int getCuantosQuedan() {
		return cuantosQuedan;
	}

	public void setCuantosQuedan(int cuantosQuedan) {
		if (cuantosQuedan >= 0) {
			this.cuantosQuedan = cuantosQuedan;
		} else {
			System.out.println("Cantidad errónea introducida");
			this.cuantosQuedan = 0;
		}
	}

	@Override
	public String toString() {
		return "Articulo [nombre=" + nombre + ", precio sin =" + precio + ", iva=" + iva + ", cuantosQuedan=" + cuantosQuedan
				+ "]";
	}

	// Añadido ejercicio C
	public double getPVP() {
		double precioConIVA;
		precioConIVA = this.precio + (this.precio * this.iva / 100.0);
		return precioConIVA;
	}

	/**
	 * Método para aplicar descuento porcentual sobre el precio
	 * 
	 * @param descuento
	 * @return precio con descuento
	 */
	public double getPVPDescuento(double descuento) {
		double precioConDescuento;
		double importeDescuento = 0;
		// Validación para que se meta un descuento mayor a 0
		if (descuento > 0) {
			importeDescuento = (getPVP() * descuento / 100);
		}

		precioConDescuento = getPVP() - importeDescuento;
		return precioConDescuento;
	}

	/**
	 * Método para vender la cantidad de productos elegida
	 * 
	 * @param cantidad. Cantidad de productos a vender
	 * @return TRUE --> Fue vendido correctamente. FALSE --> No fue posible,
	 *         cantidad a vender es superior al stock actual
	 */
	public boolean vender(int cantidad) {
		boolean fueVendido = false;
		if (cantidad > 0 && this.cuantosQuedan >= cantidad) {
			this.cuantosQuedan = this.cuantosQuedan - cantidad;
			fueVendido = true;
		}
		return fueVendido;

	}

	public void almacenar(int cantidadAlmacenar) {
		if (cantidadAlmacenar > 0) {
			this.cuantosQuedan = this.cuantosQuedan + cantidadAlmacenar;
		} else {
			System.out.println("Cantidad a almacenar errónea");
		}

	}

}