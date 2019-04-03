package DAO;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaMemDao implements IPizzaDAO {

	private Pizza[] listePizzas = new Pizza[10];

	public PizzaMemDao() {
		listePizzas[0] = new Pizza(0, "PEP", "Peperoni", CategoriePizza.VIANDE, 12.5);
		listePizzas[1] = new Pizza(1, "MAR", "Margherita", CategoriePizza.VEGETARIENNE, 14.00);
		listePizzas[2] = new Pizza(2, "REI", "La Reine", CategoriePizza.VIANDE, 11.50);
		listePizzas[3] = new Pizza(3, "FRO", "La 4 fromages", CategoriePizza.VEGETARIENNE, 12.00);
		listePizzas[4] = new Pizza(4, "CAN", "La cannibale", CategoriePizza.VIANDE, 12.50);
		listePizzas[5] = new Pizza(5, "SAV", "La savoyarde", CategoriePizza.VIANDE, 13.00);
		listePizzas[6] = new Pizza(6, "ORI", "L'orientale", CategoriePizza.VIANDE, 13.50);
		listePizzas[7] = new Pizza(7, "IND", "L'indienne", CategoriePizza.POISSON, 14.00);
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Pizza[] findAllPizzas() {
		// TODO Auto-generated method stub

		return listePizzas;
	}

	@Override
	public void saveNewPizza(Pizza nvPizza) {
		for (int i = 0; i < listePizzas.length; i++) {
			if (listePizzas[i] == null) {
				listePizzas[i] = nvPizza;
				break;
			}
		}

	}

	@Override
	public void updatePizza(String codePizza, Pizza pizzaC) {
		// TODO Auto-generated method stub
		for (int i = 0; i < listePizzas.length; i++) {
			if (listePizzas[i] != null && listePizzas[i].getCode().equals(codePizza)) {
				listePizzas[i] = pizzaC;
			}
		}
	}

	@Override
	public void deletePizza(String codePizza) {
		// TODO Auto-generated method stub
		for (int i = 0; i < listePizzas.length; i++) {
			if (listePizzas[i] != null && listePizzas[i].getCode().equals(codePizza)) {
				listePizzas[i] = null;
			}
		}

	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		// boucle pour chercher le n� du code
		for (int i = 0; i < listePizzas.length; i++) {
			if (listePizzas[i] != null && listePizzas[i].getCode().equals(codePizza)) {
				return listePizzas[i];
			}
		}
		return null;
	}
}
