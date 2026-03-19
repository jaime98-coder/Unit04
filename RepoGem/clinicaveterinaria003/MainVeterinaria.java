package clinicaveterinaria003;

import java.util.Scanner;

public class MainVeterinaria {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		GestorClinica miGestor = new GestorClinica();
		int opcionMenu;
		String codigoPaciente;
		String nombrePaciente;
		double pesoPaciente;
		boolean estaVacunada;
		System.out.println("¡BIENVENIDOS A VETGEST!");

		do {
			System.out.println("Base de datos actual del veterinario: ");
			System.out.println("-------------------------------------------");
			System.out.println("1. Alta de Mascota");
			System.out.println("2. Baja de Mascota");
			System.out.println("3. Vacunar Mascota");
			System.out.println("4. Listar mascotas que necesitan vacuna");
			System.out.println("5. Salir");
			System.out.println("-------------------------------------------");
			System.out.println("Elige una opción del menú: ");
			opcionMenu = sc.nextInt();
			sc.nextLine();
			switch (opcionMenu) {
			case 1: {
				System.out.println("--------'ALTA DE MASCOTA'--------");
				System.out.println("Datos para el alta de la mascota: ");
				System.out.println("Código: ");
				codigoPaciente = sc.nextLine();
				if (miGestor.buscarPorChip(codigoPaciente) == null) {
					System.out.println("Nombre de la mascota: ");
					nombrePaciente = sc.nextLine();
					System.out.println("Peso de la mascota (Kg): ");
					pesoPaciente = sc.nextDouble();
					System.out.println("¿La mascota se encuentra vacunada actualmente?");
					estaVacunada = sc.nextBoolean();
					sc.nextLine();
					if (miGestor.registrarMascota(codigoPaciente, nombrePaciente, pesoPaciente, estaVacunada)) {
						System.out.println("¡Paciente (mascota) registrado correctamente en sistema!");
					}

				} else {
					System.out.println("El código introducido ya corresponde a una mascota dada de alta");
				}

				break;
			}
			case 2: {
				System.out.println("--------'BAJA DE MASCOTA'--------");
				System.out.println("Introduce el código de la mascota que deseas eliminar: ");
				codigoPaciente = sc.nextLine();

				if (miGestor.bajaMascota(codigoPaciente)) {
					System.out.println("Paciente con código " + codigoPaciente + " eliminado correctamente");
				} else {
					System.out.println("El código introducido no corresponde a ningun paciente dado de alta");
				}
				break;
			}
			case 3: {
				System.out.println("--------'VACUNAR MASCOTA'--------");
				System.out.println("Introduce el código de la mascota que deseas vacunar: ");
				codigoPaciente = sc.nextLine();

				if (miGestor.vacunarPaciente(codigoPaciente)) {
					System.out.println("¡Paciente vacunado correctamente!");
				} else {
					System.out.println("El código introducido no corresponde a ninguna mascota");
				}

				break;
			}
			case 4: {
				System.out.println("--------'MASCOTAS PENDIENTES DE VACUNA'--------");
				System.out.println("Mostrando las mascotas que necesitan vacuna: ");
				miGestor.listarPendientesVacuna();
				break;
			}
			case 5: {
				System.out.println("Saliendo del programa...");
				System.out.println("¡Hasta luego!");

				break;
			}
			}

		} while (opcionMenu != 5);
		sc.close();
	}
}
