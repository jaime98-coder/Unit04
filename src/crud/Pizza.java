package crud;

public class Pizza {
	private String codigoPizza;
	private String tamano; // Familiar o mediana
	private String tipo; // Margarita, Cuatro Quesos o Funghi
	private String estado; // Se iniializa con pedida, y despues cambia a servida cuando la sirve

	public Pizza(String codigoPizza, String tamano, String tipo, String estado) {
		setCodigoPizza(codigoPizza);
		setTamano(tamano);
		setTipo(tipo);
		setEstado(estado);
	}

	/**
	 * Constructor sin estado ,para que se cree por defecto en estado "pedida"
	 * 
	 * @param codigoPizza
	 * @param tamano
	 * @param tipo
	 */
	public Pizza(String codigoPizza, String tamano, String tipo) {
		setCodigoPizza(codigoPizza);
		setTamano(tamano);
		setTipo(tipo);
		this.estado = "Pedida";
	}

	public Pizza() {

	}

	public String getCodigoPizza() {
		return codigoPizza;
	}

	public void setCodigoPizza(String codigoPizza) {
		this.codigoPizza = codigoPizza;
	}

	public String getTamano() {
		return tamano;
	}

	public void setTamano(String tamano) {
		if (tamano.equalsIgnoreCase("familiar") || tamano.equalsIgnoreCase("mediana")) {
			this.tamano = tamano;
		} else {
			this.tamano = "Tamaño no válido";
			System.out.println("ERROR. TAMAÑO NO VÁLIDO");
		}
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		if (tipo.equalsIgnoreCase("Margarita") || tipo.equalsIgnoreCase("Cuatro quesos") || tipo.equals("Funghi")) {
			this.tipo = tipo;
		} else {
			this.tipo = "Tipo de pizza no válido";
			System.out.println("ERROR. TIPO DE PIZZA NO VÁLIDO");
		}
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public boolean servir() {
		boolean esServida = false;
		if (this.estado.equalsIgnoreCase("Pedida")) {
			this.estado = "Servida";
			esServida = true; // Se ha servido con éxito
		} else {
			esServida = false; // Error: Ya estaba servida o cancelada
		}
		return esServida;
	}

	@Override
	public String toString() {
		return "Pizza [codigoPizza=" + codigoPizza + ", tamano=" + tamano + ", tipo=" + tipo + ", estado=" + estado
				+ "]";
	}

}
