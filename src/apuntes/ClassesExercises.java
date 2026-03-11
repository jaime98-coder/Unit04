package apuntes;


import java.util.ArrayList;

public class ClassesExercises {

    public static void main(String[] args) {

        // 1. Crea una clase Book con atributos title y author. Crea un objeto y muestra
        // sus datos.
        // 3. AÃ±ade un constructor a la clase Book que reciba title y author.
        var book1 = new Book("El Principito", "Federico Escritor");
        book1.showInfo();
        // 2. Crea una clase Dog con un mÃ©todo bark() que imprima su sonido.
        var dog1 = new Dog("Ron");
        dog1.bark();

        // 4. Crea una clase Car con atributos brand y model y un mÃ©todo showData().
        var car1 = new Car("Mazda", "3");
        car1.showData();
        // 5. Crea una clase Student con atributo score y un mÃ©todo que diga si aprobÃ³
        // (mayor o igual a 60).
        var student1 = new Student("Manolete", 65);
        student1.scoreCheck();
        var student2 = new Student("Antonio", 45);
        student2.scoreCheck();
        // 6. Crea una clase BankAccount con atributo balance y un mÃ©todo deposit() que
        // sume el saldo.
        var bankAccount1 = new BankAccount("ES302020455874565", 5000);
        bankAccount1.showBalance();
        bankAccount1.deposit(300);
        bankAccount1.showBalance();


        // 7. Crea una clase Rectangle con mÃ©todos para calcular el Ã¡rea y el perÃ­metro.
        var rectangle1 = new Rectangle(300, 20);
        rectangle1.calculateArea();
        rectangle1.calculatePerimeter();
        // 8. Crea una clase Worker que reciba nombre y salario, y un mÃ©todo para
        // mostrar su salario.
        var worker1 = new Worker("Sonia", 1750);
        worker1.showSalary();
        // 9. Crea varios objetos Person y guÃ¡rdalos en un ArrayList.
        var person1 = new Person("Lucia", 24, "Gerente");
        person1.showData();
        var person2 = new Person("Toni", 29, "Peon");
        var person3 = new Person("Maria", 36, "Supervisor");
        var persons = new ArrayList<Person>();
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        System.out.println(persons.size());
        persons.add(new Person("Jaime", 43, "Jefe"));
        System.out.println(persons.size());
        for (Person person : persons) {
            person.showData();
        }
        // Al no haber creado el objeto con una etiqueta, tengo que llamarlo por la posición
        persons.get(3).showData();
        // Sin embargo, si quisiese almacenarlo enuna varible podria crear la variable y guardarlo a posteriori
        Person elJefe = persons.get(3);


        // 10. Crea una clase Product y un mÃ©todo que aplique un descuento sobre su
        // precio.

        var product1 = new Product("Huevos", "Alimento", 3);
        product1.addDiscount(10);
        product1.showPrice();
    }
}

// 1, 3
class Book {
    String title;
    String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void showInfo() {
        System.out.println("Title::" + title + "\t" + "Author:" + author);
    }
}

// 2
class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public void bark() {
        System.out.println(name + " Dog: Woof!!");
    }

    public String getName() {
        return name;
    }


}

// 4
class Car {
    private String brand;
    private String model;

    public Car(String brand, String model) {

        this.brand = brand;
        this.model = model;
    }

    public void showData() {
        System.out.println("Brand: " + brand + "\tModel: " + model);

    }
}

class Student {
    private String name;
    private double score;

    public Student(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public void scoreCheck() {
        if (score >= 60) {
            System.out.println("Name: " + name + " | Score: Passed");
        } else {
            System.out.println("Name: " + name + " | Score: Failed");
        }
    }
}

// 6
class BankAccount {
    private String accountNumber;
    private double balance;


    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;

    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Depósito realizado correctamente (" + amount + ").");
        } else {
            System.out.println("El monto del depósito debe ser positivo. ");
        }
    }

    public void showBalance() {
        System.out.println("Saldo de la cuenta " + accountNumber + " actual: " + balance);
    }
}

// 7
class Rectangle {
    private double height;
    private double width;
    private double area;
    private double perimeter;

    public Rectangle(double length, double width) {
        this.height = length;
        this.width = width;

    }

    public void calculateArea() {
        area = height * width;
        System.out.println("El área del rectángulo es: " + area);
    }

    public void calculatePerimeter() {
        perimeter = 2 * (height * width);
        System.out.println("El perímetro del rectángulo es: " + perimeter);
    }

}

class Worker {
    private String name;
    private double salary;

    public Worker(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void showSalary() {
        System.out.println("Trabajador: " + name + ", Salario: " + salary + "€");
    }
}

class Person {
    private String name;
    private int age;
    private String workPosition;

    public Person(String name, int age, String workPosition) {
        this.name = name;
        this.age = age;
        this.workPosition = workPosition;
    }

    public void showData() {
        System.out.println("Nombre: " + name + ", Edad: " + age + ", Posición laboral: " + workPosition);
    }
}

//10
class Product {
    private String name;
    private String category;
    private double price;
    private double finalPrice;


    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;

    }

    public void addDiscount(double discountPercentage) {
        if (discountPercentage >= 0 && discountPercentage <= 100) {
            finalPrice = price - ((price * discountPercentage) / 100);
            System.out.println("Descuento del " + discountPercentage + "% aplicado correctamente");
        } else {
            System.out.println("El descuento debe estar entre el 0 y el 100%");
        }


    }

    public void showPrice() {
        System.out.println("Precio antes de descuento: " + price + " €");
        System.out.println("Precio final despues de descuento: " + finalPrice + " €");
    }
}
