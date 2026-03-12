package exercisesB;

public class PrincipalArticulo {

	public static void main(String[] args) {
		Articulo articulo1 = new Articulo("Pijama", 10.0, 21, 50);
		mostrarArticulo(articulo1);
		Articulo articulo2 = new Articulo("Zapatillas", 4.0, 210, 34);
		mostrarArticulo(articulo2);

	}
	

	static void mostrarArticulo(Articulo articuloMostrado) {
		System.out.println("-------------");
		System.out.println(articuloMostrado.nombre + " | Precio: " + articuloMostrado.precio + "€ "
				+ " | IVA: " + articuloMostrado.iva + "% " + " | Stock: " + articuloMostrado.cuantosQuedan);
		System.out.println("-------------");

	}
}