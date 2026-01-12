package exercisesA;

import java.util.Scanner;

public class PrincipalPersona {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Persona 1
		Persona persona1 = new Persona();
		System.out.println("Datos de Persona 1:");
		System.out.println("Introduce el DNI:");
		persona1.dni = sc.nextLine();
		System.out.println("Introduce el nombre:");
		persona1.nombre = sc.nextLine();
		System.out.println("Introduce los apellidos:");
		persona1.apellidos = sc.nextLine();
		System.out.println("Introduce la edad:");
		persona1.edad = sc.nextInt();
		// Limpiamos el buffer tras leer un entero antes de volver a leer texto
		sc.nextLine();
		if (persona1.edad >= 18) {
			persona1.esMayorEdad = true;
		}

		// Persona 2
		Persona persona2 = new Persona();
		System.out.println("Datos de Persona 2:");
		System.out.println("Introduce el DNI:");
		persona2.dni = sc.nextLine();
		System.out.println("Introduce el nombre:");
		persona2.nombre = sc.nextLine();
		System.out.println("Introduce los apellidos:");
		persona2.apellidos = sc.nextLine();
		System.out.println("Introduce la edad:");
		persona2.edad = sc.nextInt();
		// Limpiamos el buffer tras leer un entero antes de volver a leer texto
		sc.nextLine();
		if (persona2.edad >= 18) {
			persona2.esMayorEdad = true;
		}

		System.out.println(persona1.nombre + " " + persona1.apellidos + " con DNI " + persona1.dni + " "
				+ "¿Es mayor de edad? " + persona1.esMayorEdad);
		System.out.println(persona2.nombre + " " + persona2.apellidos + " con DNI " + persona2.dni + " "
				+ "¿Es mayor de edad? " + persona2.esMayorEdad);

		sc.close();

	}

}
