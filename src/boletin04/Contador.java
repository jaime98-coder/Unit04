package boletin04;

/**
 * Clase que representa un contador de...
 * 
 * 
 * - incrementar - decrementar Es posible que pida una estructura de datos para
 * examen. EJ: Contador > cont
 * 
 * Limitación: El contadornunca puede tener valores negativos
 */
public class Contador {
	private int cont;

	/**
	 * Constructor completo
	 * 
	 * @param cont
	 */
	public Contador(int cont) {
		setCont(cont);
	}

	/**
	 * Constructor por defecto
	 */
	public Contador() {
		this.cont = 0;
	}

	public int getCont() {
		return cont;
	}

	public void setCont(int cont) {
		if (cont >= 0) {
			this.cont = cont;
		}
	}

	public void incrementar() {
		this.cont++;
	}

	/**
	 * 
	 * @param suma. Cantidad que se incrementa al contador:.
	 */
	public void incrementar(int suma) {
		if (suma >= 0) {
			this.cont = this.cont + suma;
		}
	}

	public void decremementar() {
		if (this.cont <= 0) {
			this.cont = 0;
		} else {
			this.cont--;
		}
	}

	public void decremementar(int resta) {
		if (this.cont <= 0) {
			this.cont = 0;
		} else {
			this.cont -= resta;
		}
	}

	@Override
	public String toString() {
		return "Contador [cont=" + cont + "]";
	}

}
