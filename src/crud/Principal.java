package crud;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcionMenu;
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
				break;
			}
			// case 3:{
			//
			// break;
			// }
			// case 4:{
			//
			// break;
			// }
			// case 5:{
			// System.out.println("Saliendo del programa...");
			// break;
			// }
			}
		}
		sc.close();
	}

}
