package modeloexamen001biblioteca;

import java.util.Scanner;

public class MainBiblioteca {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		GestorLibros miGestorLibros = new GestorLibros();
		GestorSocios miGestorSocio = new GestorSocios();
		GestorPrestamos miGestorPrestamos = new GestorPrestamos();
		//		// Variables libros
//				String idLibro;
//				String nombreLibro;
//				int cantidadEjemplares;
//				boolean disponibilidad;
		// Variables socio
		String idSocio;
		String nombreSocio;
		int numeroTelefono;

		metodoMenu(miGestorLibros, miGestorSocio);
		metodoMenu(miGestorLibros, miGestorSocio);
		sc.close();
	}

	public static void metodoMenu(GestorLibros miGestorLibros, GestorSocios miGestorSocio) {
		int opcionMenu;
		int opcionSubMenu;
		do {
			System.out.println("BIENVENIDOS A LA BIBLIOTECA");
			System.out.println("-------------------------");
			System.out.println("1. Gestión de libros");
			System.out.println("2. Gestión de socios");
			System.out.println("3. Gestión de préstamos");
			System.out.println("4. Salir");
			System.out.println("-------------------------");
			System.out.println("Selecciona una opción: ");
			opcionMenu = sc.nextInt();
			sc.nextLine();
			switch (opcionMenu) {
			// MENÚ LIBROS
			case 1: {
				System.out.println("----------GESTIÓN DE LIBROS----------");
				System.out.println("Elige una de las opciones sobre los libros:");
				System.out.println("1. Dar de alta nuevos libros");
				System.out.println("2. Consultar libros existentes");
				System.out.println("3. Modificar información");
				System.out.println("4. Eliminar libros");
				System.out.println("5. Salir");
				System.out.println("Selecciona una opción: ");
				opcionSubMenu = sc.nextInt();
				sc.nextLine();
				opcionesMenuLibro(opcionSubMenu, miGestorLibros);

				break;
			}
			// MENÚ SOCIOS
			case 2: {
				System.out.println("----------GESTIÓN DE SOCIOS----------");
				System.out.println("Elige una de las opciones sobre los socios:");
				System.out.println("1. Dar de alta nuevo socio");
				System.out.println("2. Consultar socios");
				System.out.println("3. Modificar información");
				System.out.println("4. Eliminar socio");
				System.out.println("5. Salir");
				System.out.println("Selecciona una opción: ");
				opcionSubMenu = sc.nextInt();
				sc.nextLine();
				opcionesMenuSocio(opcionSubMenu, miGestorSocio);

				break;
			}
			// MENÚ PRESTAMOS
			case 3: {
				System.out.println("----------GESTIÓN DE PRESTAMO----------");
				System.out.println("Elige una de las opciones sobre los prestamos:");
				System.out.println("1. Registrar prestamo");
				System.out.println("2. Registrar devolucion");
				System.out.println("3. Consultar estado de prestamos");
				System.out.println("4. Salir");
				System.out.println("Selecciona una opción: ");
				opcionSubMenu = sc.nextInt();
				sc.nextLine();
				opcionesMenuPrestamos(opcionSubMenu, miGestorLibros);

				break;
			}
			// SALIR
			case 4: {
				System.out.println("Saliendo del programa...");
				System.out.println("¡Que la lectura te acompañe!");

				break;
			}
			default: {
				System.out.println("Elige una de las 4 opciones (1-4)");
			}

			}
		} while (opcionMenu != 4);
	}

	public static void opcionesMenuLibro(int opcionSubMenu, GestorLibros miGestorLibros) {
		// Variables libros
		String idLibro;
		String nombreLibro;
		int cantidadEjemplares;
		switch (opcionSubMenu) {
		case 1: {
			System.out.println("----------ALTA LIBRO----------");
			System.out.println("Datos de libros a dar de alta: ");
			System.out.println("ID libro:");
			idLibro = sc.nextLine();
			if (miGestorLibros.buscarLibroPorId(idLibro) == null) {
				System.out.println("Nombre:");
				nombreLibro = sc.nextLine();
				System.out.println("Cantidad Ejemplares inicial:");
				cantidadEjemplares = sc.nextInt();
				sc.nextLine();
				// Creacion del libro
				if (miGestorLibros.altaLibro(idLibro, nombreLibro, cantidadEjemplares)) {
					System.out.println("Libro dado de alta correctamente");
				}
			} else {
				System.out.println("El ID introducido ya corresponde a un libro dado de alta");
			}
			break;
		}
		case 2: {
			System.out.println("----------CONSULTAR LIBROS EXISTENTES----------");
			miGestorLibros.consultarLibros();
			break;
		}
		case 3: {
			System.out.println("----------MODIFICAR INFORMACIÓN DE LIBROS----------");
			System.out.println("Datos de libros a modificar: ");
			System.out.println("ID libro:");
			idLibro = sc.nextLine();
			if (miGestorLibros.buscarLibroPorId(idLibro) != null) {
				System.out.println("Nuevo Nombre:");
				nombreLibro = sc.nextLine();
				System.out.println("Cantidad Ejemplares a modificar:");
				cantidadEjemplares = sc.nextInt();
				sc.nextLine();
				// Creacion del libro
				if (miGestorLibros.modificarInformacion(idLibro, nombreLibro, cantidadEjemplares)) {
					System.out.println("Libro modificado correctamente");
				}
			} else {
				System.out.println("El ID introducido NO corresponde a ningun libro");
			}
			break;
		}
		case 4: {
			System.out.println("----------ELIMINAR LIBROS----------");
			System.out.println("ID del libro que quieres eliminar:");
			idLibro = sc.nextLine();
			if (miGestorLibros.eliminarLibro(idLibro)) {
				System.out.println("Libro eliminado correctamente");
			} else {
				System.out.println("El ID introducido no corresponde a ningún libro registrado");
			}
			break;
		}
		case 5: {
			System.out.println("Saliendo al menú general");
			break;
		}
		default: {
			System.out.println("Elige una de las 5 opciones (1-5)");
		}

		}
	}

	public static void opcionesMenuSocio(int opcionSubMenu, GestorSocios miGestorSocios) {
		// Variables socios
		String idSocio;
		String nombreSocio;
		int numeroTelefono;
		int cantidadPrestamo;
		switch (opcionSubMenu) {
		case 1: {
			System.out.println("----------ALTA SOCIO----------");
			System.out.println("Datos del socio a dar de alta: ");
			System.out.println("ID socio:");
			idSocio = sc.nextLine();
			if (miGestorSocios.buscarSocioPorId(idSocio) == null) {
				System.out.println("Nombre:");
				nombreSocio = sc.nextLine();
				System.out.println("Número de teléfono:");
				numeroTelefono = sc.nextInt();
				sc.nextLine();
				System.out.println("Cantidad en prestamo:");
				cantidadPrestamo = sc.nextInt();
				sc.nextLine();
				// Creacion del libro
				if (miGestorSocios.altaSocio(idSocio, nombreSocio, numeroTelefono, cantidadPrestamo)) {
					System.out.println("Socio dado de alta correctamente");
				}
			} else {
				System.out.println("El ID introducido ya corresponde a un socio dado de alta");
			}
			break;
		}
		case 2: {
			System.out.println("----------CONSULTAR SOCIOS EXISTENTES----------");
			miGestorSocios.consultarSocios();

			break;
		}
		case 3: {
			System.out.println("----------MODIFICAR INFORMACIÓN DE SOCIOS----------");
			System.out.println("Datos del socio a modificar:");
			System.out.println("ID del socio:");
			idSocio = sc.nextLine();
			if (miGestorSocios.buscarSocioPorId(idSocio) != null) {
				System.out.println("Nombre nuevo: ");
				nombreSocio = sc.nextLine();
				System.out.println("Número de telefono nuevo: ");
				numeroTelefono = sc.nextInt();
				System.out.println("Cantidad en prestamo nueva: ");
				cantidadPrestamo = sc.nextInt();

			} else {
				System.out.println("El ID no corresponde a ningún socio registrado");
			}
			break;
		}
		case 4: {
			System.out.println("----------ELIMINAR SOCIOS----------");
			System.out.println("Datos del socio a modificar:");
			System.out.println("ID del socio:");
			idSocio = sc.nextLine();
			if (miGestorSocios.buscarSocioPorId(idSocio) != null) {
				miGestorSocios.eliminarSocio(idSocio);
			} else {
				System.out.println("El ID no corresponde a ningún socio registrado");
			}
			break;
		}
		case 5: {
			System.out.println("Saliendo al menú general...");
			break;
		}
		default: {
			System.out.println("Elige una de las 5 opciones (1-5)");
		}

		}
	}

	public static void opcionesMenuPrestamos(int opcionSubMenu, GestorLibros miGestorLibros) {
		switch (opcionSubMenu) {
		case 1: {
			System.out.println("----------REGISTRAR PRESTAMO----------");

			break;
		}
		case 2: {
			System.out.println("----------REGISTRAR UNA DEVOLUCIÓN----------");

			break;
		}
		case 3: {
			System.out.println("----------CONSULTAR EL ESTADO DE LOS PRESTAMOS----------");

			break;
		}
		case 4: {
			System.out.println("Saliendo al menú general");

			break;
		}
		default: {
			System.out.println("Elige una de las 5 opciones (1-5)");
		}

		}
	}
}
