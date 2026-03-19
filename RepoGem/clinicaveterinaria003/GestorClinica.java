package clinicaveterinaria003;

import java.util.ArrayList;

public class GestorClinica {
	private ArrayList<Mascota> listaPacientes;

	public GestorClinica(ArrayList<Mascota> listaPacientes) {
		this.listaPacientes = listaPacientes;
	}

	public GestorClinica() {
		listaPacientes = new ArrayList<Mascota>();
	}

	public ArrayList<Mascota> getListaPacientes() {
		return listaPacientes;
	}

	public void setListaPacientes(ArrayList<Mascota> listaPacientes) {
		this.listaPacientes = listaPacientes;
	}

	/**
	 * Método para buscar a un paciente (mascota) por codigo de chip
	 * 
	 * @param chipBuscado. Para localizar la mascota de nuestra listaPacientes
	 * @return la mascota concreta que coincide con el chip introducido como param
	 */
	public Mascota buscarPorChip(String chipBuscado) {
		Mascota mascotaBuscada = null;
		for (Mascota paciente : this.listaPacientes) {
			if (paciente.getNumeroChip().equalsIgnoreCase(chipBuscado)) {
				mascotaBuscada = paciente;
				break;
			}
		}
		return mascotaBuscada;
	}

	public boolean registrarMascota(String numeroChip, String nombre, double peso, boolean estaVacunada) {
		boolean fueCreada = false;
		// Busco al paciente por chip primero
		Mascota paciente = buscarPorChip(numeroChip);
		if (paciente == null) {
			// Creo el objeto de tipo Mascota directamente con el constructor, ya que al
			// haberle puesto los Setters en él mismo, ya realiza las comprobaciones de
			// seguridad.
			paciente = new Mascota(numeroChip, nombre, peso, estaVacunada);
			fueCreada = true;
		}
		return fueCreada;
	}

	/**
	 * Método para dar de baja la mascota en el caso de que el param introducido
	 * corresponda
	 * 
	 * @param chip. Para localizar a la mascota y poder borrarla por dicho
	 *              identificador
	 * @return True --> Paciente eliminado. False --> Paciente no eliminado
	 */
	public boolean bajaMascota(String chip) {
		boolean fueBorrada = false;
		Mascota paciente = buscarPorChip(chip);
		if (paciente != null) {
			listaPacientes.remove(paciente);
			fueBorrada = true;
		}
		return fueBorrada;
	}

	public boolean vacunarPaciente(String chip) {
		boolean fueVacunado = false;
		Mascota paciente = buscarPorChip(chip);
		if (paciente != null && !paciente.isVacunada()) {
			paciente.setVacunada(true);
			fueVacunado = true;
		}
		return fueVacunado;

		// Debido a que tengo el método recibirVacuna() en la clase Mascota, podria
		// haber hecho:
		// fueVacunado = paciente.recibirVacuna(); y ya.

	}

	/**
	 * Método para imprimir las mascotas no vacunadas
	 */
	public void listarPendientesVacuna() {
		// Busco los no vacunados
		for (Mascota paciente : listaPacientes) {
			if (!paciente.isVacunada()) {
				// Los imprimo con el método to String
				System.out.println(paciente.toString());
			}
		}

	}

}
