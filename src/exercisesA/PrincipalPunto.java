package exercisesA;

public class PrincipalPunto {

	public static void main(String[] args) {
		Punto punto1 = new Punto();
		Punto punto2 = new Punto();
		Punto punto3 = new Punto();

		// Punto 1
		punto1.x = 5;
		punto1.y = 0;
		System.out.println("Punto 1: (" + punto1.x + "," + punto1.y + ")");

		// Punto 2
		punto2.x = 10;
		punto2.y = 10;
		System.out.println("\nPunto 2: (" + punto2.x + "," + punto2.y + ")");
		punto2.x = punto2.x - 2;
		punto2.x += 5;
		System.out.println("Punto 2: (" + punto2.x + "," + punto2.y + ")");

		// Punto 3
		punto3.x = -3;
		punto3.y = 7;
		System.out.println("\nPunto 3: (" + punto3.x + "," + punto3.y + ")");
		punto3.x*=2;
		punto3.y*=3;
		System.out.println("Punto 3: (" + punto3.x + "," + punto3.y + ")");

	}

}
