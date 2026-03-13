package crud;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcionMenu = 0;
		String nombreEntrada = "";
		double notaEntrada = 0.0;
		boolean operacionExitosa = false;

		GestorAlumnos gestor = new GestorAlumnos();
		while (opcionMenu != 5) {
			System.out.println("ALUMNOS/AS");
			System.out.println("1. Listado.");
			System.out.println("2. Nuevo Alumno");
			System.out.println("3. Modificar.");
			System.out.println("4. Borrar.");
			System.out.println("5. Salir.");
			System.out.println();

			System.out.println("Realice una acción: ");
			opcionMenu = sc.nextInt();
			sc.nextLine();

			switch (opcionMenu) {
			case 1: {
				System.out.println("--- LISTADO ---");
				gestor.mostrarListado();

				break;
			}
			case 2: {
				System.out.println("NUEVO ALUMNADO");
				System.out.println("Nombre: ");
				nombreEntrada = sc.nextLine();
				System.out.println("Nota: ");
				notaEntrada = sc.nextDouble();

				sc.nextLine();

				Alumno nuevoAlumno = new Alumno(nombreEntrada, notaEntrada);
				gestor.añadirAlumno(nuevoAlumno);
				break;
			}
			case 3: {
				System.out.println("MODIFICAR NOTA DE UN ALUMNO");
				System.out.println("Nombre del alumno a modificar: ");
				nombreEntrada = sc.nextLine();
				System.out.println("Nueva nota: ");
				notaEntrada = sc.nextDouble();

				operacionExitosa = gestor.modificarAlumno(nombreEntrada, notaEntrada);
				if (operacionExitosa) {
					System.out.println("Alumno modificado correctamente");
				} else {
					System.out.println("No se ha encontrado el alumno indicado");
				}

				break;
			}
			case 4: {
				System.out.println("BORRAR UN ALUMNO");
				System.out.println("Nombre del alumno a borrar: ");
				nombreEntrada = sc.nextLine();

				operacionExitosa = gestor.borrarAlumno(nombreEntrada);
				if (operacionExitosa) {
					System.out.println("Alumno borrado correctamente");
				} else {
					System.out.println("No se ha encontrado el alumno indicado");
				}
				break;
			}
			case 5: {
				System.out.println("Saliendo del programa...");
				break;
			}
			default: {
				System.out.println("Opción no válida, por favor elija una opción del 1 al 5");
			}
			}

		}
		sc.close();
	}
}
