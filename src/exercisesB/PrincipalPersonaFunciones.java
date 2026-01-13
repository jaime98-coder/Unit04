package exercisesB;

import java.util.Scanner;

public class PrincipalPersonaFunciones {

    public static void main(String[] args) {
        
        // --- Declaración de Variables ---
        Scanner sc = new Scanner(System.in);
        String dniAux;
        String nombreAux;
        String apellidosAux;
        int edadAux;
        boolean esMayorEdadAux; // No hace falta inicializar, el if/else se encarga

        final int NUM_PERSONAS = 2;

        // --- Declaración del Array ---
        // Creamos el array de huecos para objetos tipo PersonaFunciones
        PersonaFunciones[] listadoPersonas = new PersonaFunciones[NUM_PERSONAS];

        // --- Bucle de Entrada ---
        for (int i = 0; i < listadoPersonas.length; i++) {
            System.out.println("\n--- Datos de Persona " + (i + 1) + " ---");

            System.out.println("Introduce el DNI:");
            dniAux = sc.nextLine();

            System.out.println("Introduce el nombre:");
            nombreAux = sc.nextLine();

            System.out.println("Introduce los apellidos:");
            apellidosAux = sc.nextLine();

            System.out.println("Introduce la edad:");
            edadAux = sc.nextInt();

            // Limpiamos el buffer tras leer un entero
            sc.nextLine();

            // Lógica de mayoría de edad
            if (edadAux >= 18) {
                esMayorEdadAux = true;
            } else {
                esMayorEdadAux = false;
            }

            // Instanciamos y guardamos en el array
            listadoPersonas[i] = new PersonaFunciones(dniAux, nombreAux, apellidosAux, edadAux, esMayorEdadAux);
        }

        System.out.println("\n--- RESULTADOS ---");

        // --- Bucle de Salida ---
        for (int i = 0; i < listadoPersonas.length; i++) {
            
            // BUENA PRÁCTICA: Verificar que la posición no sea nula antes de usarla
            // Esto evita el error "NullPointerException" si cambiamos la lógica más adelante
            if (listadoPersonas[i] != null) {
                
                // Aquí delegamos la tarea de mostrarse al objeto
                listadoPersonas[i].mostrarDatos();
            }
        }

        // Cerramos el scanner
        sc.close();
    }
}