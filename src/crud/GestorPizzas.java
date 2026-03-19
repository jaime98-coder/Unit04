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

	public Pizza buscarPorCodigo(String codigo) {
		Pizza pizzaBuscada = null;
		for (Pizza pizza : listaPizzas) {
			if (pizza.getCodigoPizza().equalsIgnoreCase(codigo)) {
				pizzaBuscada = pizza;
				break;
			}
		}
		return pizzaBuscada;
	}

	public boolean nuevoPedido(String codigoPizza, String tamano, String tipo) {
		boolean pedidoRegistrado = false;
		Pizza pizza = buscarPorCodigo(codigoPizza);
		if (pizza == null) {
			pizza = new Pizza(codigoPizza, tamano, tipo);

			listaPizzas.add(pizza);
			pedidoRegistrado = true;
		}
		return pedidoRegistrado;

	}

	/**
	 * Método para servir pizzas (que pasen de estado "pedida" a "servida"
	 * 
	 * @param codigoPizza. Código para identificar a la pizza
	 * @return True --> La pizza se ha podido servir. False --> La pizza NO se ha
	 *         podido servir
	 */
	public boolean pizzaServida(String codigoPizza) {
		boolean esServida = false;
		Pizza pizza = buscarPorCodigo(codigoPizza);
		if (pizza != null) {
			if (pizza.servir()) {
				esServida = true;
			}
		}

		return esServida;
		
	}

}
