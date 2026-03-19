package modeloexamen001biblioteca;

public class Prestamo {
	private String idPrestamo;
	private Socio socio;
	private Libro libro;
	private boolean devuelto;

	public Prestamo(String idPrestamo, Socio socio, Libro libro) {
		this.idPrestamo = idPrestamo;
		this.socio = socio;
		this.libro = libro;
		this.devuelto = false;
	}

	public Prestamo() {

	}

	public String getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(String idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public boolean isDevuelto() {
		return devuelto;
	}

	public void setDevuelto(boolean devuelto) {
		this.devuelto = devuelto;
	}

	@Override
	public String toString() {
		return "Prestamo [idPrestamo=" + idPrestamo + ", socio=" + socio + ", libro=" + libro + ", ¿Devuelto?="
				+ devuelto + "]";
	}

}
