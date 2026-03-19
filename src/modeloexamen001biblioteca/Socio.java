package modeloexamen001biblioteca;

public class Socio {
	private String idSocio;
	private String nombre;
	private int numeroTelefono;
	private int cantidadEnPrestamo;
	static final int LIMITE_PRESTAMO = 5;

	public Socio(String idSocio, String nombre, int numeroTelefono, int cantidadEnPrestamo) {

		setIdSocio(idSocio);
		setNombre(nombre);
		setNumeroTelefono(numeroTelefono);
		setCantidadEnPrestamo(cantidadEnPrestamo);

	}

	public Socio() {

	}

	public String getIdSocio() {
		return idSocio;
	}

	public void setIdSocio(String idSocio) {
		this.idSocio = idSocio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(int numeroTelefono) {
		if (numeroTelefono >= 600000000 && numeroTelefono < 800000000) {
			this.numeroTelefono = numeroTelefono;
		}
	}

	// modo pro
	public boolean isPuedePrestamo() {
		return this.cantidadEnPrestamo < LIMITE_PRESTAMO;
	}

	// No es necesario, porque puede pedir prestamos depende de si llego al limite o
	// no
//	public void setPuedePrestamo(boolean puedePrestamo) {
//		if (this.cantidadEnPrestamo < LIMITE_PRESTAMO) {
//			this.puedePrestamo = true;
//		} else {
//			this.puedePrestamo = false;
//		}
//	}

	public int getCantidadEnPrestamo() {
		return cantidadEnPrestamo;
	}

	public void setCantidadEnPrestamo(int cantidadEnPrestamo) {
		this.cantidadEnPrestamo = cantidadEnPrestamo;
	}

	public static int getLimitePrestamo() {
		return LIMITE_PRESTAMO;
	}

	@Override
	public String toString() {
		return "Socio [idSocio=" + idSocio + ", nombre=" + nombre + ", numeroTelefono=" + numeroTelefono
				+ ", cantidadEnPrestamo=" + cantidadEnPrestamo + "]";
	}

}
