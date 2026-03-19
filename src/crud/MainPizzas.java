package crud;

import java.util.Scanner;

public class MainPizzas {

	public static void main(String[] args) {
		GestorPizzas miGestor = new GestorPizzas();
		Scanner sc = new Scanner(System.in);
		char opcionElegida = ' ';
		String codigoPizza;
		String tamano; // Familiar o mediana
		String tipo; // Margarita, Cuatro Quesos o Funghi
		String estado;

		System.out.println("Bienvenidos a la pizzeria Luigi");
		do {
			System.out.println("-------------------------------------");
			System.out.println("a. Listado de pizzas ");
			System.out.println("b. Nuevo pedido ");
			System.out.println("c. Servir pizza ");
			System.out.println("d. Salir ");
			System.out.println("-------------------------------------");
			System.out.println("Elige una opción del menú: ");
			opcionElegida = sc.next().charAt(0);
			sc.nextLine();
			switch (opcionElegida) {
			case 'a': {
				System.out.println("----------LISTADO DE PIZZAS----------");
				miGestor.listadoPizzas();
				break;
			}
			case 'b': {
				boolean datosCorrectos;
				System.out.println("----------NUEVO PEDIDO----------");
				System.out.println("Introduce los siguientes datos para crear pedido: ");
				System.out.println("Introduce el código de la pizza");
				codigoPizza = sc.nextLine();
				// Comprobación de seguridad para robustez
				if (miGestor.buscarPorCodigo(codigoPizza) == null) {
					System.out.println("Introduce el tamaño de la pizza (Familiar / Mediana) ");
					tamano = sc.nextLine();
					System.out.println("Introduce el tipo de pizza (Margarita / Cuatro Quesos / Funghi): ");
					tipo = sc.nextLine();

					if ((tamano.trim().equalsIgnoreCase("Familiar") || tamano.trim().equalsIgnoreCase("Mediana"))
							&& (tipo.trim().equalsIgnoreCase("Margarita")
									|| tipo.trim().equalsIgnoreCase("Cuatro Quesos")
									|| tipo.trim().equalsIgnoreCase("Funghi"))) {
						datosCorrectos = true;
						System.out.println("Datos validados correctamente");
					} else {
						datosCorrectos = false;
						System.out.println("Datos no válidos");
					}

					// Creo usando el constructor sin estado
					if (datosCorrectos && miGestor.nuevoPedido(codigoPizza, tamano, tipo)) {
						System.out.println("¡Pedido creado correctamente! ¡Gracias!");
					}
				} else {
					System.out.println("ERROR: El código introducido ya existe en la base de datos.");
				}
				break;
			}
			case 'c': {
				System.out.println("----------PIZZA SERVIDA----------");
				System.out.println("Introduce el código para cambiar el estado de 'Pedida' a 'Servida':");
				codigoPizza = sc.nextLine();
				if (miGestor.pizzaServida(codigoPizza)) {
					System.out.println("Pizza con código [" + codigoPizza + "] cambiada a estado SERVIDA");
				} else {
					System.out.println("El código introducido no corresponde a ningun pedido o ya fue servida.");
				}
				break;
			}
			case 'd': {
				System.out.println("Saliendo del programa...");
				System.out.println("¡Hasta pronto!");
				break;
			}
			default: {
				System.out.println("Elige una de las opciones del menú (a,b,c,d)");
				break;
			}
			}
		} while (opcionElegida != 'd');
		
	}

}
