package exercisesB;

public class Articulo {
	public Articulo(String nombre, double precio, int iva, int cuantosQuedan) {
		super();
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

	String nombre;
	double precio; // Precio sin impuestos
	int iva; // Representa el porcentaje (21)
	int cuantosQuedan; // Stock
}