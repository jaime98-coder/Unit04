package exercisesC;

import java.util.Scanner;

public class PrincipalArticulo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Articulo articulo1 = new Articulo("Pijama", 10.0, 21, 50);
		System.out.println(articulo1.toString());

		Articulo articulo2 = new Articulo("Zapatillas", 4.0, 210, 34);
		System.out.println(articulo2.toString());

		Articulo articulo3 = new Articulo();
		articulo3.setNombre(" ");
		articulo3.setPrecio(7.3);
		articulo3.setIva(10);
		articulo3.setCuantosQuedan(73);
		System.out.println(articulo3.toString());

		Articulo articulo4 = new Articulo("Chaquetón", 72, 21, 42);
		System.out.println(articulo4.toString());

		// Ejercicio C para crear un método getPVP y asignarlo a una variable para
		// sumarle el IVA al precio del producto
		double precioConIVA;
		precioConIVA = articulo1.getPVP();
		System.out.println(precioConIVA);

		// Uso del método getPVPDescuento
		double precioConDescuento;
		int descuento = -1;
		while (descuento < 0 || descuento > 100) {
			System.out.println("Introduce el % de descuento que deseas aplicarle al producto:");
			descuento = sc.nextInt();

			if (descuento < 0 || descuento > 100) {
				System.out.println("Error: Introduce un descuento positivo");
			}
		}
		precioConDescuento = articulo1.getPVPDescuento(descuento);
		System.out.println("Precio del articulo 1 antes del descuento: " + precioConIVA);
		System.out.println("Precio del articulo 1 con descuento aplicado: " + precioConDescuento);

		// Uso del método vender
		int cantidadVenta = 0;
		while (cantidadVenta <= 0) {
			System.out.println("Introduce el número de articulo que quieres vender");
			cantidadVenta = sc.nextInt();
			if (cantidadVenta <= 0) {
				System.out.println("Error: Introduce un número de artículos positivo");
			}
		}
		if (articulo1.vender(cantidadVenta)) {
			System.out.println(cantidadVenta + " articulos vendidos correctamente ");
			System.out.println("Stock restante: " + articulo1.getCuantosQuedan());
		} else {
			System.out.println("No es posible vender la cantidad de productos elegida, stock insuficiente");
		}

		// Uso del método almacenar
		int cantidadAlmacenada = 0;
		while (cantidadAlmacenada <= 0) {
			System.out.println("Introduce el número de articulo que quieres almacenar");
			cantidadAlmacenada = sc.nextInt();
			if (cantidadAlmacenada <= 0) {
				System.out.println("Error: Introduce un número de artículos positivo");
			}
		}
		// Stock antes de almacenar
		System.out.println("Stock antes de almacenar: " + articulo1.getCuantosQuedan());
		// Almacenamos la cantidad introducida
		articulo1.almacenar(cantidadAlmacenada);
		// Stock después de almacenar
		System.out.println("Stock después de almacenar: " + articulo1.getCuantosQuedan());

		// Imprimimos el artículo para comprobar que se han actualizado los datos
		// correctamente
		System.out.println(articulo1.toString());

		sc.close();
	}

}