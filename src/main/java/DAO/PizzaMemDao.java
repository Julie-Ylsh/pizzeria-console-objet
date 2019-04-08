package DAO;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author BIRABEN-BIANCHI Hugo
 *
 */
public class PizzaMemDao implements IPizzaDAO {
	// private Pizza [] tabPizza;
	public List<Pizza> tabPizza;

	public PizzaMemDao() {
		tabPizza = new ArrayList<Pizza>();
		initialisation();
	}

	public void initialisation() {
		if (tabPizza.size() < 8) {
			tabPizza.add(new Pizza("PEP", "Pépéroni", CategoriePizza.Viande, 12.50));
			tabPizza.add(new Pizza("MAR", "Margherita", CategoriePizza.Végétarienne, 14.00));
			tabPizza.add(new Pizza("REIN", "La Reine", CategoriePizza.Viande, 11.50));
			tabPizza.add(new Pizza("FRO", "La 4 Fromage", CategoriePizza.Végétarienne, 12.00));
			tabPizza.add(new Pizza("CAN", "La cannibale", CategoriePizza.Viande, 12.50));
			tabPizza.add(new Pizza("SAV", "La savoyarde", CategoriePizza.Viande, 13.00));
			tabPizza.add(new Pizza("ORI", "L’orientale", CategoriePizza.Viande, 13.50));
			tabPizza.add(new Pizza("IND", "L’indienne", CategoriePizza.Poisson, 14.00));
		} else {
			System.out.println("Taille du tableau insuffisante pour l'initialisation !");
		}
	}

	@Override
	public List<Pizza> findAllPizzas() {
		return tabPizza;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		tabPizza.add(pizza);
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		for (Pizza p : tabPizza) {
			if (p != null) {
				if (p.getCode().equals(codePizza)) {
					p.setCode(pizza.getCode());
					p.setLibelle(pizza.getLibelle());
					p.setPrix(pizza.getPrix());
					p.setType(pizza.getType());
				}
			}
		}
	}

	@Override
	public void deletePizza(String codePizza) {
		for (Pizza p : tabPizza) {
			if (p.getCode().equals(codePizza)) {
				tabPizza.remove(p);
				break;
			}
		}

		for (int i = 0; i < tabPizza.size(); i++) {
			if (tabPizza.get(i).getId() != i) {
				tabPizza.get(i).setId(i);
			}
		}
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		for (Pizza pizza : tabPizza) {
			if (pizza.getCode().equals(codePizza.toUpperCase())) {
				return pizza;
			}
		}

		return null;
	}

}