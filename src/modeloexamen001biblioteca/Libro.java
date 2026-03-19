package modeloexamen001biblioteca;

public class Libro {
	private String idLibro;
	private String nombre;
	private int cantidadEjemplares;

	public Libro(String idLibro, String nombre, int cantidadEjemplares) {
		setIdLibro(idLibro);
		setNombre(nombre);
		setCantidadEjemplares(cantidadEjemplares);
	}

	public Libro() {

	}

	public String getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(String idLibro) {
		this.idLibro = idLibro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidadEjemplares() {
		return cantidadEjemplares;
	}

	public void setCantidadEjemplares(int cantidadEjemplares) {
		if (cantidadEjemplares > 0) {
			this.cantidadEjemplares = cantidadEjemplares;
		} else {
			this.cantidadEjemplares = 0;
		}
	}

	public boolean isDisponibilidad() {
		return this.cantidadEjemplares > 0;
	}

//	public void setDisponibilidad(boolean disponibilidad) {
//		if (this.cantidadEjemplares > 0) {
//			this.disponibilidad = true;
//			
//		} else {
//			this.disponibilidad = false;
//		}
//	}

	@Override
	public String toString() {
		return "Libro [idLibro=" + idLibro + ", nombre=" + nombre + ", cantidadEjemplares=" + cantidadEjemplares + "]";
	}

}
