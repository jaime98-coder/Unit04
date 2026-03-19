package crud;

import java.util.ArrayList;

public class GestorPizzas {
	private ArrayList<Pizza> listaPizzas;

	public GestorPizzas() {
		listaPizzas = new ArrayList<Pizza>();
	}

	public ArrayList<Pizza> getListaPizzas() {
		return listaPizzas;
	}

	public void setListaPizzas(ArrayList<Pizza> listaPizzas) {
		this.listaPizzas = listaPizzas;
	}

	public void listadoPizzas() {
		if (listaPizzas.isEmpty()) {
			System.out.println("No hay ninguna pizza en la lista");
		} else {
			for (Pizza pizza : listaPizzas) {
				System.out.println(pizza);
			}
		}
	}

	public boolean nuevoPedido(String codigoPizza, String tamano, String tipo, String estado) {
		Pizza pizza = new Pizza(codigoPizza,tamano,tipo,estado);
		
	}

}
