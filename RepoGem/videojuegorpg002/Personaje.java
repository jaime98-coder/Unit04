package videojuegorpg002;

/**
 * Clase personaje
 */
public class Personaje {
	private String nombre;
	private int vidaMaxima;
	private int vidaActual;
	private int poderAtaque;
	private int armadura;
	private boolean estaVivo;

	// Constructor completo
	public Personaje(String nombre, int vidaMaxima, int poderAtaque, int armadura) {
		setNombre(nombre);
		setVidaMaxima(vidaMaxima);
		this.vidaActual = vidaMaxima;
		setPoderAtaque(poderAtaque);
		setArmadura(armadura);
		this.estaVivo = true;
	}

	// Constructor por defecto
	public Personaje() {

	}

	// GETTERS & SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVidaMaxima() {
		return vidaMaxima;
	}

	public void setVidaMaxima(int vidaMaxima) {
		if (vidaMaxima > 0) {
			this.vidaMaxima = vidaMaxima;
		}
	}

	public int getVidaActual() {
		return vidaActual;
	}

	public void setVidaActual(int vidaActual) {
		if (vidaActual < 0) {
			this.vidaActual = 0;
		} else {
			this.vidaActual = vidaActual;
		}
	}

	public int getPoderAtaque() {
		return poderAtaque;
	}

	public void setPoderAtaque(int poderAtaque) {
		if (poderAtaque < 0) {
			this.poderAtaque = 0;
		} else {
			this.poderAtaque = poderAtaque;
		}
	}

	public int getArmadura() {
		return armadura;
	}

	public void setArmadura(int armadura) {
		if (armadura < 0) {
			this.armadura = 0;
		} else {
			this.armadura = armadura;
		}
	}

	public boolean isEstaVivo() {
		return estaVivo;
	}

	public void setEstaVivo(boolean estaVivo) {
		this.estaVivo = estaVivo;
	}

	public void recibirAtaque(int danioAtaque) {
		// 1. Calculamos el daño real (si la armadura es mayor, el daño es 0)
		int danioRecibido = danioAtaque - this.armadura;
		if (danioRecibido < 0) {
			danioRecibido = 0;
		}

		// 2. Restamos la vida
		this.vidaActual = this.vidaActual - danioRecibido;

		// 3. Comprobamos si ha muerto
		if (this.vidaActual <= 0) {
			this.vidaActual = 0;
			this.estaVivo = false;
			System.out.println(this.nombre + " ha muerto.");
		}
	}

	public void curar(int cantidadPocion) {
		if (this.estaVivo) {
			this.vidaActual += cantidadPocion;
			if (this.vidaActual >= this.vidaMaxima) {
				this.vidaActual = this.vidaMaxima;
				System.out.println(this.nombre + " está FULL DE VIDA");
			}
		}

	}

	public void atacar(Personaje objetivo) {
		if (this.estaVivo) {
			System.out.println(
			this.nombre + " ataca a " + objetivo.getNombre() + " con " + this.poderAtaque + " de poder!");
			// Solo le pasamos "la bola de fuego", el objetivo se encarga de lo demás
			objetivo.recibirAtaque(this.poderAtaque);
		}

	}
}
