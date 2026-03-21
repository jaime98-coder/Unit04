package modeloexamengem01;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ListaHabitaciones miGestor = new ListaHabitaciones();
		int opcionElegida = -1;
		String codigoHabitacion;
		String tipoHabitacion;
		double precioBaseNoche;
		double pctServicioExtra;
		int nochesReservadas;
		System.out.println("----------------------------------------------------");
		System.out.println("BIENVENIDOS AL SISTEMA DE RESERVAS DE HOTEL");
		System.out.println("----------------------------------------------------");
		do {
			boolean datoValido = false;
			System.out.println("1. Añadir habitacion ");
			System.out.println("2. Listar habitaciones ");
			System.out.println("3. Buscar habitacion por código");
			System.out.println("4. Modificar noches reservadas");
			System.out.println("5. Modificar porcentaje de servicio extra");
			System.out.println("6. Modificar tasa turística diaria ");
			System.out.println("7. Eliminar habitacion ");
			System.out.println("8. Ver estadísticas ");
			System.out.println("9. Salir");
			System.out.println("----------------------------------------------------");
			System.out.println("Elige una de las opciones: ");
			opcionElegida = sc.nextInt();
			// Reset de buffer tras int
			sc.nextLine();
			switch (opcionElegida) {
			case 1: {
				System.out.println("ENTRANDO A AÑADIR HABITACIÓN...");
				System.out.println("Datos para el alta de la habitación: ");
				System.out.println("Codigo: ");
				codigoHabitacion = sc.nextLine();
				// Comprobación extra para que el usuario no tenga que introducir todos los
				// datos si el código ya coincide con otra habitación
				if (miGestor.buscarPorCodigo(codigoHabitacion) == null) {
					System.out.println("Tipo habitacion: ");
					tipoHabitacion = sc.nextLine();
					System.out.println("Precio base por noche: ");
					precioBaseNoche = sc.nextDouble();
					System.out.println("Porcentaje de servicio extra: ");
					pctServicioExtra = sc.nextDouble();
					System.out.println("Número de noches: ");
					nochesReservadas = sc.nextInt();
					// Reset de buffer
					sc.nextLine();
					miGestor.anadirHabitacion(codigoHabitacion, tipoHabitacion, precioBaseNoche, pctServicioExtra,
							nochesReservadas);
					System.out.println("¡Habitación añadida correctamente!");
				} else {
					System.out.println(
							"ERROR. El código introducido corresponde con otra habitación, no es posible añadirla");
				}
				break;
			}
			case 2: {
				System.out.println("ENTRANDO A LISTAR HABITACIONES...");
				miGestor.listarTodas();
				break;
			}
			case 3: {
				System.out.println("ENTRANDO A BUSCAR HABITACIÓN POR CÓDIGO...");
				System.out.println("Introduce el código de la habitación que deseas buscar: ");
				codigoHabitacion = sc.nextLine();
				Habitacion habitacion = miGestor.buscarPorCodigo(codigoHabitacion);
				if (habitacion != null) {
					System.out.println("El código introducido corresponde con una habitación dada de alta");
					// Para imprimir los datos de la habitacion encontrada
					System.out.println(habitacion.toString());
				} else {
					System.out.println("El código introducido NO corresponde con ninguna habitación");
				}
				break;
			}
			case 4: {
				System.out.println("ENTRANDO A MODIFICAR NOCHES RESERVADAS...");
				System.out.println("Introduce el código de la habitación que deseas modificar: ");
				codigoHabitacion = sc.nextLine();
				if (miGestor.buscarPorCodigo(codigoHabitacion) != null) {
					System.out.println("Introduce el número de noches");
					nochesReservadas = sc.nextInt();
					// Reset de buffer
					sc.nextLine();
					if (miGestor.modificarNochesReservadas(codigoHabitacion, nochesReservadas)) {
						System.out.println("Noches modificadas correctamente a: " + nochesReservadas);
					} else {
						System.out.println("Noches no modificadas");
					}
				} else {
					System.out.println("El código introducido NO corresponde con ninguna habitación");
				}

				break;
			}
			case 5: {
				System.out.println("ENTRANDO A MODIFICAR PORCENTAJE DE SERVICIO EXTRA...");
				System.out.println("Introduce el código de la habitación que deseas modificar: ");
				codigoHabitacion = sc.nextLine();
				if (miGestor.buscarPorCodigo(codigoHabitacion) != null) {
					System.out.println("Introduce el NUEVO porcentaje (%) de servicios extras (0-25): ");
					pctServicioExtra = sc.nextDouble();
					// Reset de buffer
					sc.nextLine();
					// If-Else de seguridad (tambien valdria un while)
					if (pctServicioExtra >= 0 && pctServicioExtra <= 25) {
						if (miGestor.modificarServicioExtra(codigoHabitacion, pctServicioExtra)) {
							System.out.println(
									"Servicios extras modificados correctamente a: " + pctServicioExtra + " %");
						} else {
							System.out.println("Servicios extras no modificados");
						}
					} else {
						System.out.println("El porcentaje introducido es erróneo.");
					}

				} else {
					System.out.println("El código introducido NO corresponde con ninguna habitación");
				}
				break;
			}
			case 6: {
				System.out.println("ENTRANDO A MODIFICAR TASA TURISTICA DIARIA...");
				System.out.println("Introduce el nuevo importe de tasa turística: ");
				double nuevoImporteTasaTuristica;
				nuevoImporteTasaTuristica = sc.nextDouble();
				Habitacion.setTasaTuristica(nuevoImporteTasaTuristica);
				System.out.println(
						"Importe de la tasa turística modificada correctamente a: " + nuevoImporteTasaTuristica);
				break;
			}
			case 7: {
				System.out.println("ENTRANDO A ELIMINAR HABITACIÓN...");
				System.out.println("Introduce el código de la habitación que deseas modificar: ");
				codigoHabitacion = sc.nextLine();
				if (miGestor.eliminarPorCodigo(codigoHabitacion)) {
					System.out.println("Habitación eliminada correctamente");
				} else {
					System.out.println("ERROR. El código introducido no corresponde a ninguna habitación.");
				}
				break;
			}
			case 8: {
				System.out.println("ENTRANDO A VER ESTADÍSTICAS...");
				double ingresoTotalExtras = miGestor.calcularIngresoTotalServiciosExtra();
				System.out.println("Ingreso total obtenido de los servicios extras del hotel: " + ingresoTotalExtras);
				System.out.println("Listado de habitaciones VIP (>15% extras): ");
				miGestor.listarHabitacionesVIP();
				break;
			}
			case 9: {
				System.out.println("Saliendo del programa...");
				System.out.println("Gracias por usar el sistema de gestión hotelera. ¡Hasta pronto!");
				break;
			}
			default: {
				System.out.println("Por favor, elige una de las opciones del menú");

				break;
			}
			}

		} while (opcionElegida != 9);

		sc.close();

	}

}
