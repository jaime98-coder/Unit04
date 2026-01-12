package exercisesA;

import java.util.Scanner;

public class PrincipalPersonaEficienteArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Establezco el número de personas a introducir, por si en un futuro quiero
		// meter mas personas, solo cambio el valor de esta constante.
		final int NUM_PERSONAS = 2;
		// Declaración del Array
		Persona[] personas = new Persona[NUM_PERSONAS];
		for (int i = 0; i < personas.length; i++) {
			personas[i] = new Persona();
			System.out.println("Datos de persona " + (i + 1) + ":");
			System.out.println("Introduce el DNI:");
			personas[i].dni = sc.nextLine();
			System.out.println("Introduce el nombre:");
			personas[i].nombre = sc.nextLine();
			System.out.println("Introduce los apellidos:");
			personas[i].apellidos = sc.nextLine();
			System.out.println("Introduce la edad:");
			personas[i].edad = sc.nextInt();

			if (personas[i].edad >= 18) {
				personas[i].esMayorEdad = true;
			}
			// LIMPIEZA DE BUFFER
			// Obligatorio porque acabamos de leer un int antes del if y vamos a volver a
			// leer un String en la siguiente vuelta del bucle (o fuera de él).
			sc.nextLine();
		}
		
		System.out.println("\n ---RESULTADOS ---");
		for (int i=0; i <personas.length; i++) {
			System.out.println(personas[i].nombre+" "+personas[i].apellidos+" con DNI "+personas[i].dni+" ¿Es mayor de edad? "+personas[i].esMayorEdad);
		}

	}

}
