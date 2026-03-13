package exercisesC;

public class PrincipalPunto {

	public static void main(String[] args) {
		Punto punto1 = new Punto(5, 0);
		Punto punto2 = new Punto(10, 10);
		Punto punto3 = new Punto(-3, 7);

		System.out.println("Punto 1: (" + punto1.getX() + ", " + punto1.getY() + ")");
		System.out.println("Punto 2: (" + punto2.getX() + ", " + punto2.getY() + ")");

		punto1.setX(17);
		punto1.setY(2);
		System.out.println("Punto 1 modificado: (" + punto1.getX() + ", " + punto1.getY() + ")");

		punto2.setX(9);
		punto2.setY(1);
		System.out.println("Punto 2 modificado: (" + punto2.getX() + ", " + punto2.getY() + ")");
	}

}
