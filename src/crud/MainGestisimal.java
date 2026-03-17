package crud;

import java.util.ArrayList;
import java.util.Scanner;

public class MainGestisimal {
	public static void main(String[] args) {
		GestorArticulos miGestor = new GestorArticulos();
		Scanner sc = new Scanner(System.in);
		int opcionMenu;
		String codigo;
		String nombreArticulo;
		double precioVenta;
		double precioCompra;
		int stock;
		do {
			System.out.println("Bienvenido al GESTISIMAL");
			miGestor.mostrarMenu();
			System.out.println("Selecciona una opción del menú: ");
			opcionMenu = sc.nextInt();
			sc.nextLine();
			switch (opcionMenu) {
			case 1: {
				System.out.println("---------------Accediendo a 'Alta de artículo'--------------- ");
				System.out.println("Introduce código de articulo: ");
				codigo = sc.nextLine();
				if (miGestor.buscarPorCodigo(codigo) == null) {
					System.out.println("Introduce nombre de articulo: ");
					nombreArticulo = sc.nextLine();
					System.out.println("Introduce precio de venta: ");
					precioVenta = sc.nextDouble();
					System.out.println("Introduce precio de compra: ");
					precioCompra = sc.nextDouble();
					System.out.println("Introduce stock inicial del articulo: ");
					stock = sc.nextInt();
					if (miGestor.altaArticulo(codigo, nombreArticulo, precioVenta, precioCompra, stock)) {
						System.out.println("Articulo creado correctamente y almacenado en el almacen (lista)");
					}
				} else {
					System.out.println("El código del artículo ya existe en el almacen");
				}
				break;
			}
			case 2: {
				System.out.println("---------------Accediendo a 'Baja de artículo'---------------");
				System.out.println("Introduce el código del artículo que deseas eliminar: ");
				codigo = sc.nextLine();
				if (miGestor.buscarPorCodigo(codigo) != null && miGestor.bajaArticulo(codigo)) {
					System.out.println("Artículo localizado y eliminado correctamente");
				} else {
					System.out.println("El código del artículo no existe en el almacen");
				}
				break;
			}
			case 3: {
				System.out.println("---------------Accediendo a 'Modificación de artículo'---------------");
				System.out.println("Introduce el código del artículo que deseas modificar: ");
				codigo = sc.nextLine();
				if (miGestor.buscarPorCodigo(codigo) != null) {
					System.out.println("Introduce nuevo nombre de articulo: ");
					nombreArticulo = sc.nextLine();
					System.out.println("Introduce nuevo precio de venta: ");
					precioVenta = sc.nextDouble();
					System.out.println("Introduce nuevo precio de compra: ");
					precioCompra = sc.nextDouble();
					System.out.println("Introduce stock actual del artículo: ");
					stock = sc.nextInt();
					if (miGestor.modificarArticulo(codigo, nombreArticulo, precioVenta, precioCompra, stock)) {
						System.out.println("Artículo modificado correctamente");
					} else {
						System.out.println("El artículo no se pudo modificar");
					}
				} else {
					System.out.println("El código de artículo introducido no existe en el almacen");
				}
				break;
			}
			case 4: {
				System.out.println("---------------Accediendo a 'Entrada de Mercancia'---------------");
				System.out.println("Introduce el código del artículo al que deseas ingresar stock");
				codigo = sc.nextLine();
				if (miGestor.buscarPorCodigo(codigo) != null) {
					System.out.println("Artículo localizado");
					System.out.println("Introduce la cantidad de stock a añadir: ");
					stock = sc.nextInt();
					if (miGestor.entradaMercancia(codigo, stock)) {
						System.out.println("Stock añadido correctamente");
					} else {
						System.out.println("El stock no se pudo añadir");
					}

				} else {
					System.out.println("El código introducido no corresponde a ningún artículo");
				}
				break;
			}
			case 5: {
				System.out.println("---------------Accediendo a 'Salida de Mercancia'---------------");
				System.out.println("Introduce el código del artículo al que deseas retirar stock");
				codigo = sc.nextLine();
				if (miGestor.buscarPorCodigo(codigo) != null) {
					System.out.println("Artículo localizado");
					System.out.println("Introduce la cantidad de stock a retirar: ");
					stock = sc.nextInt();
					if (miGestor.salidaMercancia(codigo, stock)) {
						System.out.println("Stock retirado correctamente");
					} else {
						System.out.println("El stock no se pudo retirar");
					}

				} else {
					System.out.println("El código introducido no corresponde a ningún artículo");
				}
				break;
			}
			case 6: {
				System.out.println("---------------Accediendo a 'Listado de Articulos'---------------");
				System.out.println(miGestor.toString());
				break;
			}
			case 7: {
				System.out.println("Saliendo del programa...");
				System.out.println("¡Hasta pronto!");
				break;

			}
			default: {
				System.out.println("Por favor, introduce una opción válida (1-7)");
			}
			}
		} while (opcionMenu != 7);
		System.out.println("Fin");

	}
}
