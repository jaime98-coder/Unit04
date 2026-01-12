package exercisesA;

public class PrincipalRectangulo {

	public static void main(String[] args) {

		// --- DECLARACIÓN E INSTANCIACIÓN ---
		// Declaramos los objetos
		Rectangulo rectangulo1 = new Rectangulo();
		Rectangulo rectangulo2 = new Rectangulo();

		// --- INICIALIZACIÓN DE DATOS (Manual) ---
		// Accedemos a los atributos con el punto (.) para darles valor

		// Rectángulo 1: (0,0) y (5,5)
		rectangulo1.x1 = 0;
		rectangulo1.y1 = 0;
		rectangulo1.x2 = 5;
		rectangulo1.y2 = 5;

		// Rectángulo 2: (7,9) y (2,3)
		rectangulo2.x1 = 7;
		rectangulo2.y1 = 9;
		rectangulo2.x2 = 2;
		rectangulo2.y2 = 3;

		// --- CÁLCULOS Y SALIDA RECTÁNGULO 1 ---
		System.out.println("----- RECTÁNGULO 1 -----");
		System.out.println("Coordenadas: (" + rectangulo1.x1 + "," + rectangulo1.y1 + ") y (" + rectangulo1.x2 + ","
				+ rectangulo1.y2 + ")");

		// Calculamos base y altura usando Math.abs para evitar negativos
		// Buena práctica: Usar variables intermedias para que se entienda la fórmula
		int base1 = Math.abs(rectangulo1.x2 - rectangulo1.x1);
		int altura1 = Math.abs(rectangulo1.y2 - rectangulo1.y1);

		// Calculamos área y perímetro
		int area1 = base1 * altura1;
		int perimetro1 = 2 * (base1 + altura1);

		System.out.println("Base: " + base1 + ", Altura: " + altura1);
		System.out.println("Área: " + area1);
		System.out.println("Perímetro: " + perimetro1);
		System.out.println(); // Salto de línea estético

		// --- CÁLCULOS Y SALIDA RECTÁNGULO 2 ---
		System.out.println("----- RECTÁNGULO 2 -----");
		System.out.println("Coordenadas: (" + rectangulo2.x1 + "," + rectangulo2.y1 + ") y (" + rectangulo2.x2 + ","
				+ rectangulo2.y2 + ")");

		// Repetimos la lógica para el segundo objeto
		int base2 = Math.abs(rectangulo2.x2 - rectangulo2.x1);
		int altura2 = Math.abs(rectangulo2.y2 - rectangulo2.y1);

		int area2 = base2 * altura2;
		int perimetro2 = 2 * (base2 + altura2);

		System.out.println("Base: " + base2 + ", Altura: " + altura2);
		System.out.println("Área: " + area2);
		System.out.println("Perímetro: " + perimetro2);

		// --- MODIFICACIÓN (Como pide el ejercicio) ---
		System.out.println("--------------------------------");
		System.out.println("Modificando coordenadas del rectangulo1...");

		// Cambiamos valores accediendo directamente a los atributos
		rectangulo1.x2 = 10;
		rectangulo1.y1 = 9;

		// Tenemos que volver a calcular porque los datos han cambiado
		base1 = Math.abs(rectangulo1.x2 - rectangulo1.x1);
		altura1 = Math.abs(rectangulo1.y2 - rectangulo1.y1);

		// Calculamos área y perímetro
		area1 = base1 * altura1;
		perimetro1 = 2 * (base1 + altura1);
		System.out.println("Base modificada: " + base1 + ", Altura modificada: " + altura1);
		System.out.println("Área modificada: " + area1);
		System.out.println("Perímetro modificada: " + perimetro1);
	}
}