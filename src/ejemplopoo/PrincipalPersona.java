package ejemplopoo;

public class PrincipalPersona {

	public static void main(String[] args) {
		Persona daniel = new Persona();
		System.out.println(daniel.nombre);
		daniel.nombre = "Daniel";
		System.out.println(daniel.nombre);
		System.out.println(daniel.edad);
		System.out.println(daniel.estatura);
		System.out.println(daniel.carnet);
		
		Persona p1 = new Persona();
		Persona p2 = new Persona();
		// De esta forma, p3 apunta al mismo objeto/referencia que p1
		Persona p3 = p1;
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		
		

	}

}
