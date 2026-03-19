package videojuegorpg002;

import java.util.ArrayList;
import java.util.HashMap;

public class GestorGremio {

	// [EL ARCHIVADOR DE LA OFICINA]
	// Clave (String): La pegatina de la carpeta (Ej: "Magos", "Guerreros").
	// Valor (ArrayList): El taco de folios con las fichas de los personajes dentro
	// de esa carpeta.
	private HashMap<String, ArrayList<Personaje>> archivador;

	// Constructor con parámetros (Si ya nos dan un archivador montado)
	public GestorGremio(HashMap<String, ArrayList<Personaje>> archivador) {
		this.archivador = archivador;
	}

	// Constructor por defecto (El que usaremos casi siempre al empezar el juego)
	public GestorGremio() {
		// ¡VITAL! Compramos el archivador en la tienda (lo instanciamos) para que no dé
		// NullPointerException
		this.archivador = new HashMap<>();
	}

	// GETTERS & SETTERS habituales
	public HashMap<String, ArrayList<Personaje>> getArchivador() {
		return archivador;
	}

	public void setArchivador(HashMap<String, ArrayList<Personaje>> archivador) {
		this.archivador = archivador;
	}

	// ==========================================
	// RECLUTAR (Añadir un personaje a una facción)
	// ==========================================
	public void reclutarAventurero(String faccion, Personaje nuevo) {

		// 1. ¿No existe la carpeta de esta facción en el archivador?
		if (!archivador.containsKey(faccion)) {
			// Entonces la fabricamos y metemos dentro un taco de folios en blanco
			// (ArrayList vacío)
			archivador.put(faccion, new ArrayList<Personaje>());
		}

		// 2. LA MESA DE TRABAJO: Sacamos el taco de folios de la carpeta y lo ponemos
		// en la mesa (listaDeEstaFaccion)
		// A partir de aquí, dejamos en paz al 'archivador' y trabajamos rápido con la
		// mesa.
		ArrayList<Personaje> listaDeEstaFaccion = archivador.get(faccion);

		boolean existe = false;
		int i = 0; // Nuestro dedo para ir pasando las páginas

		// 3. BUCLE DE BÚSQUEDA: Mientras no lleguemos al final del taco Y no lo hayamos
		// encontrado
		while (i < listaDeEstaFaccion.size() && !existe) {

			// Agarramos el folio número 'i' con la mano para leerlo cómodamente (Tu
			// variable temporal)
			Personaje personaje1 = listaDeEstaFaccion.get(i);

			// Comparamos el nombre del folio que tenemos en la mano con el nombre del
			// novato
			if (personaje1.getNombre().equalsIgnoreCase(nuevo.getNombre())) {
				existe = true; // ¡Ups! Ya hay alguien con ese nombre. Cambiamos la bandera para que el bucle
								// muera.
			}
			i++; // Pasamos al siguiente folio
		}

		// 4. VEREDICTO FINAL: Si terminamos de mirar todos los folios y la bandera
		// sigue en 'false'...
		if (!existe) {
			listaDeEstaFaccion.add(nuevo); // ...apuntamos al novato al final del taco de folios.
			System.out.println(nuevo.getNombre() + " se ha unido a la facción de los " + faccion + "!");
		} else {
			System.out.println("Error: Ya hay un aventurero llamado " + nuevo.getNombre() + " en esta facción.");
		}
	}

	// ==========================================
	// EXPULSAR (Eliminar un personaje de una facción)
	// ==========================================
	public void expulsarAventurero(String faccion, String nombreAventurero) {

		// 1. Miramos si la pegatina de la facción existe en nuestro archivador
		if (archivador.containsKey(faccion)) {

			// 2. LA MESA DE TRABAJO: Sacamos el taco de folios de esa facción
			ArrayList<Personaje> lista = archivador.get(faccion);

			boolean encontrado = false;
			int i = 0; // Nuestro dedo para pasar páginas

			// 3. BUCLE DE BÚSQUEDA: Mientras queden folios Y no hayamos encontrado al
			// traidor
			while (i < lista.size() && !encontrado) {

				// Agarramos el folio actual con la mano
				Personaje p = lista.get(i);

				// 4. ¿El nombre del folio coincide con el que queremos echar?
				if (p.getNombre().equalsIgnoreCase(nombreAventurero)) {

					lista.remove(i); // ¡Arrancamos ese folio del taco!
					System.out.println(nombreAventurero + " ha sido expulsado.");

					encontrado = true; // Cambiamos la bandera para decir "¡Misión cumplida, deja de buscar!"
				}
				i++; // Si no era este, pasamos al siguiente folio
			}

			// 5. Si pasamos todas las páginas y la bandera nunca cambió a 'true'...
			if (!encontrado) {
				System.out.println("No se encontró a " + nombreAventurero + " en esa facción.");
			}

		} else {
			// Esto pasa si nos piden buscar en una carpeta que no existe (Ej: facción
			// "Extraterrestres")
			System.out.println("La facción " + faccion + " no existe.");
		}
	}

	public void listarGremio() {
		if (archivador.isEmpty()) {
			System.out.println("El gremio está vacío.");

		}
		for (String nombreFaccion : archivador.keySet()) {
			System.out.println("\n[" + nombreFaccion.toUpperCase() + "]");

			ArrayList<Personaje> listaDeEstaFaccion = archivador.get(nombreFaccion);
			if (listaDeEstaFaccion.isEmpty()) {
				System.out.println("Esta facción no tiene aventureros");
			} else {
				for (Personaje p : listaDeEstaFaccion) {
					System.out.println("Nombre: " + p.getNombre());
					System.out.println("Vida: " + p.getVidaActual());
					System.out.println("Ataque: " + p.getPoderAtaque());
					System.out.println("Armadura: " + p.getArmadura());
					System.out.println("¿Está vivo?: " + p.isEstaVivo());
				}
			}
		}

	}
}