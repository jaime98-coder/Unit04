package exercisesA;

public class PrincipalArticulo {

	public static void main(String[] args) {

		// 1. Declaración de variables auxiliares (Buenas Prácticas)
		// Calcularemos el PVP aquí, no dentro del objeto
		double pvpCalculado;

		// 2. Instanciación y carga de datos
		Articulo articulo1 = new Articulo();

		articulo1.nombre = "Pijama";
		articulo1.precio = 12.0;
		articulo1.iva = 21; // Guardamos "21", no "1.21"
		articulo1.cuantosQuedan = 7;

		// 3. Cálculo matemático
		// Fórmula: Precio + (Precio * Porcentaje / 100)
		// Usamos 100.0 para asegurar división con decimales
		pvpCalculado = articulo1.precio + (articulo1.precio * articulo1.iva / 100.0);

		// 4. Salida por pantalla (Impresión inicial)
		System.out.println("----- ARTÍCULO (Original) -----");
		System.out.println(articulo1.nombre + " - Precio:" + articulo1.precio + "€ - IVA:" + articulo1.iva + "% - PVP:"
				+ pvpCalculado + "€");

		// 5. Modificación
		System.out.println();
		System.out.println("----- ARTÍCULO (Precio cambiado) -----");

		articulo1.precio = 18.0; // Cambiamos solo el precio base

		// ¡IMPORTANTE! Recalculamos el PVP porque el precio base ha cambiado
		pvpCalculado = articulo1.precio + (articulo1.precio * articulo1.iva / 100.0);

		System.out.println(articulo1.nombre + " - Precio:" + articulo1.precio + "€ - IVA:" + articulo1.iva + "% - PVP:"
				+ pvpCalculado + "€");
	}
}