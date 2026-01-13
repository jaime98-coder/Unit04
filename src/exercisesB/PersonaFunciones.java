package exercisesB;

public class PersonaFunciones {

    // Atributos de la clase
    String dni;
    String nombre;
    String apellidos;
    int edad;
    boolean esMayorEdad;

    // Constructor: Asigna los valores recibidos a los atributos del objeto
    public PersonaFunciones(String dni, String nombre, String apellidos, int edad, boolean esMayorEdad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.esMayorEdad = esMayorEdad;
    }

    // --- MÉTODO MOSTRAR DATOS ---
    // Este es el método que tu main está llamando.
    // Usamos 'this' para referirnos a los datos de "esta" persona en concreto.
    public void mostrarDatos() {
        System.out.println("-------------------------------------------------");
        System.out.println("DNI: " + this.dni);
        System.out.println("Nombre Completo: " + this.nombre + " " + this.apellidos);
        
        // Un pequeño detalle de calidad para mostrar texto en vez de 'true'
        if (this.esMayorEdad) {
            System.out.println("Edad: " + this.edad + " años (Mayor de edad)");
        } else {
            System.out.println("Edad: " + this.edad + " años (Menor de edad)");
        }
        System.out.println("-------------------------------------------------");
    }
}