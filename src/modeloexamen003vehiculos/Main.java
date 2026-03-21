package modeloexamen003vehiculos;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Creación del gestor de vehículos (ListaVehiculos)
		ListaVehiculos miGestor = new ListaVehiculos();
		Scanner sc = new Scanner(System.in);
		int opcionElegida = -1;
		String matricula;
		String modelo;
		double precioBaseDiario;
		double pctRecargoPremium = 0;
		int diasAlquiler;
		double precioSeguro;
		System.out.println("----------------------------------------------------");
		System.out.println("BIENVENIDOS AL SISTEMA DE ALQUILER DE VEHÍCULO");
		System.out.println("----------------------------------------------------");
		do {
			boolean datoValido=false;
			System.out.println("1. Añadir vehículo ");
			System.out.println("2. Listar vehículos ");
			System.out.println("3. Buscar vehículo por matrícula");
			System.out.println("4. Modificar días alquilados");
			System.out.println("5. Modificar recargo premium ");
			System.out.println("6. Modificar precio seguro diario ");
			System.out.println("7. Eliminar vehículo ");
			System.out.println("8. Ver estadísticas ");
			System.out.println("9. Salir");
			System.out.println("----------------------------------------------------");
			while (!datoValido) {
				try {
					System.out.println("Selecciona una de las opciones mostradas: ");
					opcionElegida = sc.nextInt();
				} catch (Exception e) {
					System.out.println("DATO INVÁLIDO");
				}
				datoValido=true;
				sc.nextLine();
			}
			boolean datoNoValido = true;
			switch (opcionElegida) {
			case 1: {
				System.out.println("SELECCIÓN: Añadir vehículo ");
				System.out.println("Introduce los siguientes datos del vehículo a añadir:");
				System.out.println("Matricula");
				matricula = sc.nextLine();
				// Comprobacion adicional para que el usuario no introduzca todos los datos para
				// nada
				if (miGestor.buscarPorMatricula(matricula) == null) {
					System.out.println("Modelo: ");
					modelo = sc.nextLine();
					System.out.println("Precio base por día: ");
					precioBaseDiario = sc.nextDouble();
					sc.nextLine();
					// Bucle por si el pct de recargo no esta en el rango
					datoNoValido = true;
					while (datoNoValido) {
						System.out.println("Introduce un porcentaje de recargo Premium (0% - 25%)");
						pctRecargoPremium = sc.nextDouble();
						if (pctRecargoPremium < 0 || pctRecargoPremium > 25) {
							datoNoValido = true;
						} else {
							datoNoValido = false;
						}
					}
					System.out.println("Introduce el número de dias de alquiler: ");
					diasAlquiler = sc.nextInt();
					sc.nextLine();
					if (miGestor.anadirVehiculo(matricula, modelo, precioBaseDiario, pctRecargoPremium, diasAlquiler)) {
						System.out.println("Vehículo añadido correctamente e insertado en la lista");
					} else {
						System.out.println("ERROR: El vehículo no se pudo añadir");
					}

				} else {
					System.out.println("ERROR: La matrícula introducida corresponde a un vehículo ya dado de alta");
				}
				break;
			}
			case 2: {
				System.out.println("SELECCIÓN: Listar vehículos");
				miGestor.listarTodos();
				break;
			}
			case 3: {
				Vehiculo vehiculoBuscado;
				
				System.out.println("SELECCIÓN: Buscar vehículo por matrícula");
				System.out.println("Introduce la matrícula que deseas buscar: ");
				matricula = sc.nextLine();
				vehiculoBuscado=miGestor.buscarPorMatricula(matricula);
				if (vehiculoBuscado != null) {
					System.out.println("La matrícula introducida corresponde a: " + vehiculoBuscado.toString());
				} else {
					System.out.println("La matricula introducida no corresponde a ningún vehículo");
				}
				break;
			}
			case 4: {
				System.out.println("SELECCIÓN: Modificar días alquilados");
				System.out.println("Introduce la matrícula del coche que deseas modificar:");
				matricula = sc.nextLine();
				System.out.println("Introduce la cantidad de días a la que quieres modificar (dias totales)");
				diasAlquiler = sc.nextInt();
				if (miGestor.modificarDiasAlquilados(matricula, diasAlquiler)) {
					System.out.println("Nuevos días alquilados modificados");
				} else {
					System.out.println("La matrícula introducida no corresponde a ningún vehículo");
				}
				break;
			}
			case 5: {
				System.out.println("SELECCIÓN: Modificar recargo premium");
				System.out.println("Introduce la matrícula del coche que deseas modificar:");
				matricula = sc.nextLine();
				if (miGestor.buscarPorMatricula(matricula) != null) {
					while (datoNoValido) {
						System.out.println("Introduce el nuevo porcentaje de recargo Premium (0% - 25%)");
						pctRecargoPremium = sc.nextDouble();
						if (pctRecargoPremium < 0 || pctRecargoPremium > 25) {
							datoNoValido = true;
						} else {
							datoNoValido = false;
						}
					}
					if (miGestor.modificarRecargoPremium(matricula, pctRecargoPremium)) {
						System.out.println("¡Recargo premium modificado correctamente!");
					} else {
						System.out.println("El recargo premium no se pudo modificar");
					}
				} else {
					System.out.println("La matrícula introducida no corresponde a ningún vehículo");
				}

				break;
			}
			case 6: {
				//
				System.out.println("SELECCIÓN: Modificar precio seguro diario");
				System.out.println("Introduce el nuevo precio diario del seguro: ");
				precioSeguro = sc.nextDouble();
				// Set precio seguro con el static poniendo Vehiculo (como clase, no como
				// objeto)
				Vehiculo.setPRECIO_SEGURO(precioSeguro);
				System.out.println("Precio del seguro modificado correctamente a: " + precioSeguro);
				break;
			}
			case 7: {
				System.out.println("SELECCIÓN: Eliminar vehículo");
				System.out.println("Introduce la matrícula del vehículo que deseas eliminar ");
				matricula = sc.nextLine();
				if (miGestor.buscarPorMatricula(matricula) != null) {
					if (miGestor.eliminarPorMatricula(matricula)) {
						System.out.println("Vehículo eliminado correctamente");
					}
				} else {
					System.out.println("La matrícula introducida no corresponde a ningún vehículo");
				}
				break;
			}
			case 8: {
				System.out.println("SELECCIÓN: Ver estadísticas");
				System.out.println("Mostrando listado de vehículos premium: ");
				miGestor.listarVehiculosPremium();
				System.out.println("Ingresos Totales generados por recargos premium: " + miGestor.calcularIngresoTotalRecargos());
				break;
			}
			case 9: {
				System.out.println("SALIENDO DEL SISTEMA...");
				System.out.println("Gracias por usar el sistema. ¡Hasta pronto!");
				break;
			}
			default:
				System.out.println("Elige una de las opciones (1-9)");
			}
		} while (opcionElegida != 9);

		sc.close();
	}

}
