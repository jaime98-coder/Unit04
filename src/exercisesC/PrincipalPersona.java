package exercisesC;

import java.util.ArrayList;

public class PrincipalPersona {

	public static void main(String[] args) {
		Persona p1 = new Persona("74224459Z", "Jaime", "Martin", 27);

		System.out.println(p1);
		p1.setDni("54545499S");
		p1.setApellidos("Rikitanka");
		System.out.println("Apellido: " + p1.getApellidos());
		System.out.println(p1);

		Persona p2 = new Persona("85495845D", "Marina", "Sanchez", 97);
		System.out.println(p2.toString());
		// EXTRA porque quise
		ArrayList<Persona> listaPersonas = new ArrayList<>();
		listaPersonas.add(p1);
		listaPersonas.add(p2);
		System.out.println(listaPersonas.toString());

	}

}
