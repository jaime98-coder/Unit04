package exercisesB;

import java.util.Scanner;

public class PrincipalPersona {

	public static void main(String[] args) {
		// --- Declaración de Variables ---
		Scanner sc = new Scanner(System.in);
		String dniAux;
		String nombreAux;
		String apellidosAux;
		int edadAux;
		// Inicializamos a false por seguridad, aunque el if/else lo maneja bien
		boolean esMayorEdadAux = false;

		final int NUM_PERSONAS = 3;

		// --- Declaración del Array ---
		Persona[] listadoPersonas = new Persona[NUM_PERSONAS];

		// --- Bucle de Entrada ---
		for (int i = 0; i < listadoPersonas.length; i++) {
			// CORRECCIÓN: El mensaje debe ir DENTRO del bucle y ser dinámico
			System.out.println("\n--- Datos de Persona " + (i + 1) + " ---");

			System.out.println("Introduce el DNI:");
			dniAux = sc.nextLine();

			System.out.println("Introduce el nombre:");
			nombreAux = sc.nextLine();

			System.out.println("Introduce los apellidos:");
			apellidosAux = sc.nextLine();

			System.out.println("Introduce la edad:");
			edadAux = sc.nextInt();

			// Limpiamos el buffer tras leer un entero
			sc.nextLine();

			// Lógica de mayoría de edad correcta
			if (edadAux >= 18) {
				esMayorEdadAux = true;
			} else {
				esMayorEdadAux = false;
			}

			// Instanciamos y guardamos en el array
			listadoPersonas[i] = new Persona(dniAux, nombreAux, apellidosAux, edadAux, esMayorEdadAux);
		}

		System.out.println("\n--- RESULTADOS ---");

		// --- Bucle de Salida ---
		for (int i = 0; i < listadoPersonas.length; i++) {
			// Acceso directo a los atributos (Válido por ahora)
			System.out.println(listadoPersonas[i].nombre + " " + listadoPersonas[i].apellidos + " con DNI "
					+ listadoPersonas[i].dni + " " + "¿Es mayor de edad? " + listadoPersonas[i].esMayorEdad);
		}

		// Cerramos el scanner
		sc.close();
	}
}