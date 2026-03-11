package gemteacher;

import java.util.Scanner;

public class PrincipalEstudiante {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca nombre:");
		String nombreIntroducida = sc.nextLine();
		System.out.println("Introduzca edad:");

		int edadIntroducida = sc.nextInt();
		System.out.println("Introduzca nota:");

		double notaIntroducida = sc.nextDouble();
		Estudiante alumno = new Estudiante(nombreIntroducida, edadIntroducida, notaIntroducida);
		alumno.presentarse();

		sc.close();
	}

}
