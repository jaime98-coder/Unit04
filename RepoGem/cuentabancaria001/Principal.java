package cuentabancaria001;

import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Variables de la cuenta bancaria
		double saldoInicial;
		double cantidadIngresar;
		double cantidadRetirar;
		// Variables del titular
		String nombreUsuario;
		String dniUsuario;
		String numeroCuentaUsuario;

		// ---- Recogida de datos del titular ----
		System.out.println("-----ALTA DE NUEVO CLIENTE-----");
		System.out.println("Introduce el nombre completo del titular");
		nombreUsuario = sc.nextLine();
		System.out.println("Introduce el DNI del titular");
		dniUsuario = sc.nextLine();

		// Creamos el objeto titular con los datos recogidos
		Titular cliente = new Titular(nombreUsuario, dniUsuario);

		// ---- Recogida de datos de la cuenta ----
		System.out.println("-----ALTA DE NUEVO CLIENTE-----");
		System.out.println("Introduce el nuevo número de cuenta bancaria");
		numeroCuentaUsuario = sc.nextLine();
		System.out.println("¿Con qué saldo inicial se abre la cuenta?");
		saldoInicial = sc.nextDouble();

		// Creamos el objeto cuenta bancaria con los datos recogidos;
		CuentaBancaria cuenta = new CuentaBancaria(numeroCuentaUsuario, saldoInicial, cliente);

		// ---- OPERACIONES BANCARIAS ----
		System.out.println("\n --- OPERACIONES ---");
		System.out.println("¿Cuánto dinero desea ingresar ahora mismo?");
		cantidadIngresar = sc.nextDouble();
		cuenta.ingresar(cantidadIngresar);

		System.out.println("¿Cuánto dinero desea retirar para tener en efectivo?");
		cantidadRetirar = sc.nextDouble();
		cuenta.retirar(cantidadRetirar);

		// ----- RESULTADO FINAL -----
		System.out.println("\n ------ ESTADO FINAL DE LA CUENTA ------ ");
		cuenta.mostrarInformacion();

		// Cierre Scanner
		sc.close();
	}
}
