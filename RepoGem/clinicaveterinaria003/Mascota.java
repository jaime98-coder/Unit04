package clinicaveterinaria003;

public class Mascota {
	private String numeroChip;
	private String nombre;
	private double peso;
	private boolean vacunada;

	/**
	 * Constructor completo
	 */
	public Mascota(String numeroChip, String nombre, double peso, boolean vacunada) {

		setNumeroChip(numeroChip);
		setNombre(nombre);
		setPeso(peso);
		setVacunada(vacunada);
	}

	/**
	 * Constructor por defecto
	 */
	public Mascota() {

	}

	public String getNumeroChip() {
		return numeroChip;
	}

	public void setNumeroChip(String numeroChip) {
		this.numeroChip = numeroChip;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		if (peso <= 0) {
			this.peso = 1.0;
		} else {
			this.peso = peso;
		}
	}

	public boolean isVacunada() {
		return vacunada;
	}

	public void setVacunada(boolean vacunada) {
		this.vacunada = vacunada;
	}

	public boolean recibirVacuna() {
		boolean seVacuna = false;
		if (!this.vacunada) {
			this.vacunada = true;
			seVacuna = true;
			System.out.println(getNombre() + " ha recibido su vacuna correctamente");
		} else {
			System.out.println(getNombre() + " ya estaba vacunada, no le pinches más");
		}
		return seVacuna;
	}

	@Override
	public String toString() {
		return "Mascota [numeroChip=" + numeroChip + ", nombre=" + nombre + ", peso=" + peso + ", vacunada=" + vacunada
				+ "]";
	}

}
