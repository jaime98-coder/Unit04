package boletin04;

public class Fraccion {
	private int numerador;
	private int denominador;

	public Fraccion(int numerador, int denominador) {
		setNumerador(numerador);
		setDenominador(denominador);
	}

	public int getNumerador() {
		return numerador;
	}

	public void setNumerador(int numerador) {
		this.numerador = numerador;
	}

	public int getDenominador() {
		return denominador;
	}

	public void setDenominador(int denominador) {
	    if (denominador == 0) {
	        // Evitamos que el programa explote si nos cuelan un 0
	        this.denominador = 1; 
	    } else if (denominador < 0) {
	        // Si es negativo (ej. -4), pasamos el denominador a positivo (4)
	        this.denominador = -denominador; 
	        // ¡Y le cambiamos el signo al numerador para mantener el equilibrio!
	        this.numerador = -this.numerador; 
	    } else {
	        // Si es mayor que 0, se guarda normal
	        this.denominador = denominador;
	    }
	}

	@Override
	public String toString() {
		return "Fraccion [numerador=" + numerador + ", denominador=" + denominador + "]";
	}

	public Fraccion suma(Fraccion f) {
		int num = this.numerador * f.denominador + f.numerador * this.denominador;
		int den = this.denominador * f.denominador;

		Fraccion resultado = new Fraccion(num, den);
		resultado.simplificar();

		return resultado;
	}

	public Fraccion resta(Fraccion f) {
		int num = this.numerador * f.denominador - f.numerador * this.denominador;
		int den = this.denominador * f.denominador;

		Fraccion resultado = new Fraccion(num, den);
		resultado.simplificar();

		return resultado;
	}

	public Fraccion multiplica(Fraccion f) {
		int num = this.numerador * f.numerador;
		int den = this.denominador * f.denominador;
		Fraccion resultado = new Fraccion(num, den);
		resultado.simplificar();

		return resultado;
	}

	public Fraccion division(Fraccion f) {
		int num = this.numerador * f.denominador;
		int den = this.denominador * f.numerador;
		Fraccion resultado = new Fraccion(num, den);
		resultado.simplificar();

		return resultado;
	}

	/**
	 * Para simplificar la fracción, hay que sacar el Maximo Comun Divisor, para
	 * ello creamos otra función
	 * 
	 * @param f
	 */
	public void simplificar() {
		int MCD = mcd(this.numerador, this.denominador);
		this.numerador = this.numerador / MCD;
		this.denominador = this.denominador / MCD;
	}

	/**
	 * Se pone en PRIVATE porque es un método que se va a utilizar únicamente dentro
	 * de la clase, NO en el MAIN.
	 * 
	 */
	private int mcd(int numA, int numB) {
		numA = Math.abs(numA);
		numB = Math.abs(numB);

		while (numB != 0) {
			int temp = numB;
			numB = numA % numB;
			numA = temp;
		}
		// Daria como resultado el MCD
		return numA;
	}

}
