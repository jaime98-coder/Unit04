package apuntes;

public class PersonTest {
	
	 // Atributos
    String name;
    int age;

    // Constructor
    public PersonTest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Métodos
    public void sayHello() {
        System.out.println("Hola, soy " + name + " y tengo " + age + " años.");

    }
}
