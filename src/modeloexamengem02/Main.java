package modeloexamengem02;

import java.util.Scanner;

/**
 * Método main para interactuar con el usuario y mostrar la información por
 * consola
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ListaMaquinaria miGestor = new ListaMaquinaria();
		int opcionMenu = -1;
		String codigoMaquina;
		String tipoMaquina = "";
		double precioBaseDiario;
		double pctSeguroRiesgo = 0;
		int diasAlquiler;
		boolean pctSeguroRiesgoValido;
		System.out.println("----------------------------------------------------------");
		System.out.println("BIENVENIDOS AL SISTEMA DE ALQUILER DE MAQUINARIAS PESADA");
		System.out.println("----------------------------------------------------------");

		do {
			boolean opcionValida = false;
			System.out.println("1. Añadir maquina ");
			System.out.println("2. Listar maquinas ");
			System.out.println("3. Buscar maquina por código");
			System.out.println("4. Modificar días alquilados");
			System.out.println("5. Modificar porcentaje de seguro");
			System.out.println("6. Modificar tasa de transporte diaria ");
			System.out.println("7. Eliminar máquina ");
			System.out.println("8. Ver estadísticas ");
			System.out.println("9. Salir");
			while (!opcionValida) {
				System.out.println("----------------------------------------------------");
				try {
					System.out.print("Seleccione una de las opciones del menú: ");
					opcionMenu = sc.nextInt();
					sc.nextLine();
				} catch (Exception e) {
					System.out.println("ERROR. Introduce un número para elegir una opción del menú");
					sc.nextLine();
				}
				opcionValida = true;
			}
			switch (opcionMenu) {
			case 1: {
				boolean tipoValido = false;
				pctSeguroRiesgoValido = false;
				System.out.println("-------AÑADIR MÁQUINA-------");
				System.out.println("Introduce los siguientes datos para añadir la máquina: ");
				System.out.println("Código: ");
				codigoMaquina = sc.nextLine();
				// If-else para comprobar con buscar por código maquina para evitar que el
				// usuario
				// introduzca todos los datos necesarios para añadirla, si ya hay una máquina
				// con ese código,
				if (miGestor.buscarPorCodigo(codigoMaquina) == null) {
					// Bucle while para que hasta que no elija una de los tipos válido siga
					// pdiiendosleo
					while (!tipoValido) {
						System.out.println("Introduce tipo (Excavadora, Grua, Tractor, Hormigonera): ");
						tipoMaquina = sc.nextLine();
						if (tipoMaquina.trim().equalsIgnoreCase("Excavadora")
								|| tipoMaquina.trim().equalsIgnoreCase("Grua")
								|| tipoMaquina.trim().equalsIgnoreCase("Tractor")
								|| tipoMaquina.trim().equalsIgnoreCase("Hormigonera")) {
							tipoValido = true;
						} else {
							System.out.println("ERROR. Introduce un tipo válido");
						}
					}
					System.out.println("Precio base diario:");
					precioBaseDiario = sc.nextDouble();
					sc.nextLine();
					while (!pctSeguroRiesgoValido) {
						System.out.println("Introduce porcentaje de seguro de riesgo (0-20)");
						pctSeguroRiesgo = sc.nextDouble();
						sc.nextLine();
						if (pctSeguroRiesgo >= 0 && pctSeguroRiesgo <= 20) {
							pctSeguroRiesgoValido = true;
						} else {
							System.out.println("ERROR. Introduce un porcentaje válido");
						}
					}
					System.out.println("Días de alquiler: ");
					diasAlquiler = sc.nextInt();
					sc.nextLine();
					if (miGestor.anadirMaquina(codigoMaquina, tipoMaquina, precioBaseDiario, pctSeguroRiesgo,
							diasAlquiler)) {
						System.out.println("Máquina añadida correctamente a la lista");
					}
				} else {
					System.out.println("ERROR. El código introducido ya coincide con una máquina añadida previamente");
				}
				break;
			}
			case 2: {
				System.out.println("-------LISTAR MÁQUINAS-------");
				System.out.println("Listado de máquinas dadas de alta:");
				miGestor.listarTodas();
				break;
			}
			case 3: {

				System.out.println("-------BUSCAR MÁQUINA POR CÓDIGO-------");
				System.out.println("Introduce el código de la máquina que deseas buscar:");
				codigoMaquina = sc.nextLine();
				Maquina maquinaBuscada = miGestor.buscarPorCodigo(codigoMaquina);
				if (maquinaBuscada != null) {
					System.out.println(maquinaBuscada.toString());
				} else {
					System.out.println("ERROR. El código introducido no corresponde con ninguna máquina");
				}
				break;
			}
			case 4: {
				System.out.println("-------MODIFICAR DÍAS DE ALQUILER-------");
				System.out.println("Introduce el código de la máquina que deseas modificar los días:");
				codigoMaquina = sc.nextLine();
				Maquina maquinaBuscada = miGestor.buscarPorCodigo(codigoMaquina);
				if (maquinaBuscada != null) {
					System.out.println("Introduce número de días a modificar: ");
					diasAlquiler = sc.nextInt();
					if (miGestor.modificarDiasAlquiler(codigoMaquina, diasAlquiler)) {
						System.out.println("Días modificados correctamente a " + diasAlquiler);
					}
				} else {
					System.out.println("ERROR. El código introducido no corresponde con ninguna máquina");
				}
				break;
			}
			case 5: {
				pctSeguroRiesgoValido = false;
				System.out.println("-------MODIFICAR PORCENTAJE DE SEGURO-------");
				System.out
						.println("Introduce el código de la máquina que deseas modificar los el porcentaje de seguro:");
				codigoMaquina = sc.nextLine();
				Maquina maquinaBuscada = miGestor.buscarPorCodigo(codigoMaquina);
				if (maquinaBuscada != null) {
					while (!pctSeguroRiesgoValido) {
						System.out.println("Introduce porcentaje de seguro de riesgo (0-20)");
						pctSeguroRiesgo = sc.nextDouble();
						sc.nextLine();
						if (pctSeguroRiesgo >= 0 && pctSeguroRiesgo <= 20) {
							pctSeguroRiesgoValido = true;
							if (miGestor.modificarSeguroRiesgo(codigoMaquina, pctSeguroRiesgo)) {
								System.out.println("Seguro de riesgo modificado correctamente a: " + pctSeguroRiesgo);
							}
						} else {
							System.out.println("ERROR. Introduce un porcentaje válido");
						}
					}
				} else {
					System.out.println("ERROR. El código introducido no corresponde con ninguna máquina");
				}
				break;
			}
			case 6: {
				System.out.println("-------MODIFICAR TASA DE TRANSPORTE DIARIA-------");
				System.out.println("Introduce el nuevo importe de tasa de transporte:");
				double importeTasaTransporte = sc.nextDouble();
				sc.nextLine();
				Maquina.setTasaTransporteDiaria(importeTasaTransporte);
				System.out.println("Tasa de transporte diaria modificada correctamente a: " + importeTasaTransporte);
				break;
			}
			case 7: {
				System.out.println("-------ELIMINAR MÁQUINA-------");
				System.out.println("Introduce el código de la máquina que deseas eliminar");
				codigoMaquina = sc.nextLine();
				if (miGestor.eliminarPorCodigo(codigoMaquina)) {
					System.out.println("Máquina eliminada correctamente");
				} else {
					System.out.println("ERROR. El código introducido no correponde con ninguna máquina");
				}
				break;
			}
			case 8: {
				double ingresoTotalSeguros = 0;
				System.out.println("-------VER ESTADÍSTICAS-------");

				ingresoTotalSeguros = miGestor.calcularIngresoTotalSeguros();
				System.out.println("Total ingresado por los seguros: " + ingresoTotalSeguros);
				System.out.println("Mostrando listado de máquinas de riesgo alto: ");
				miGestor.listarMaquinasRiesgoAlto();

				break;
			}
			case 9: {
				System.out.println("Saliendo del programa...");
				System.out.println("Gracias por usar el programa de alquiler de máquinas pesadas");
				break;
			}
			}

		} while (opcionMenu != 9);

		sc.close();
	}

}
