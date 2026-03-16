package boletin04;

public class Principal {

	public static void main(String[] args) {
		// Ejercicio contador
		Contador contadorDePrueba = new Contador();
		contadorDePrueba.incrementar(35);
		contadorDePrueba.incrementar();
		System.out.println(contadorDePrueba.toString());

		// Ejercicio Fracciones
		// 1. Instanciamos los objetos
		Fraccion f1 = new Fraccion(6, 9); // Equivale a 2/3
		Fraccion f2 = new Fraccion(8, 4); // Equivale a 2/1 (o simplemente 2)

		System.out.println("--- FRACCIONES ORIGINALES ---");
		System.out.println("F1: " + f1);
		System.out.println("F2: " + f2);

		System.out.println("\n--- OPERACIONES MATEMÁTICAS ---");

		// SUMA: f1 llama al método, f2 entra como parámetro.
		// El método devuelve un TERCER objeto nuevo, que guardamos en 'resultadoSuma'
		Fraccion resultadoSuma = f1.suma(f2);
		System.out.println("Suma (F1 + F2): " + resultadoSuma);

		// RESTA
		Fraccion resultadoResta = f1.resta(f2);
		System.out.println("Resta (F1 - F2): " + resultadoResta);

		// MULTIPLICACIÓN
		Fraccion resultadoMultiplica = f1.multiplica(f2);
		System.out.println("Multiplicación (F1 * F2): " + resultadoMultiplica);

		// DIVISIÓN
		Fraccion resultadoDivide = f1.division(f2);
		System.out.println("División (F1 / F2): " + resultadoDivide);

		System.out.println("\n--- ESTADO DE F1 TRAS LAS OPERACIONES ---");
		// Si te fijas, f1 sigue siendo 6/9. Los métodos anteriores no la han tocado,
		// solo la han usado para hacer cálculos y devolver resultados nuevos.
		System.out.println("F1 actual: " + f1);

		System.out.println("\n--- USO DEL MÉTODO SIMPLIFICAR ---");
		// SIMPLIFICAR: Este método es diferente. Es un 'void'. No devuelve nada nuevo,
		// sino que entra dentro de f1 y altera sus propios atributos.
		f1.simplificar();
		System.out.println("F1 después de llamar a f1.simplificar(): " + f1);

		
		
		// Ejercicio Fecha
		// Prueba 1: Fecha normal
				Fecha fecha1 = new Fecha(3, 8, 1998);
				System.out.println("Fecha inicial: " + fecha1.toString());
				System.out.println("¿Es correcta?: " + fecha1.fechaCorrecta());
				
				System.out.println("\n-----------------------------");

				// Prueba 2: Poniendo a prueba el Fin de Año
				Fecha nochevieja = new Fecha(31, 12, 2023);
				System.out.println("Fecha actual: " + nochevieja.toString());
				
				nochevieja.diaSiguiente(); // Llamamos al método
				
				System.out.println("Día siguiente: " + nochevieja.toString()); // Debería imprimir 1-1-2024
				
				System.out.println("\n-----------------------------");

				// Prueba 3: Poniendo a prueba un año bisiesto
				Fecha febreroBisiesto = new Fecha(28, 2, 2024); // 2024 ES bisiesto
				System.out.println("Fecha actual: " + febreroBisiesto.toString());
				
				febreroBisiesto.diaSiguiente();
				
				
				System.out.println("Día siguiente: " + febreroBisiesto.toString()); // Debería imprimir 29-2-2024 (No pasa a marzo aún)

	}

}