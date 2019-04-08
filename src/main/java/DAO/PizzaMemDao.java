package DAO;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author BIRABEN-BIANCHI Hugo
 *
 */
public class PizzaMemDao implements IPizzaDAO {
	// private Pizza [] tabPizza;
	private List<Pizza> tabPizza;

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
	@Test
	public void testSaveNew() {
		PizzaMemDao dao = new PizzaMemDao();
		Pizza pizzaAjout = new Pizza("JOL", "Julietheverybest", CategoriePizza.Viande, 12.50);

		List<Pizza> listePizzaTest = dao.findAllPizzas();

		Integer taille = listePizzaTest.size();
		System.out.println(listePizzaTest.size());

		dao.saveNewPizza(pizzaAjout);
		Integer tailleArrivee = listePizzaTest.size();
		System.out.println(listePizzaTest.size());

		Assert.assertNotEquals(taille, tailleArrivee);

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

	@Test
	public void testUpdatePizza() {
		PizzaMemDao dao = new PizzaMemDao();
		List<Pizza> listePizzaTest = findAllPizzas();
		Pizza pizzaAjout = new Pizza("JUL", "Juliethebest", CategoriePizza.Viande, 12.50);

		dao.updatePizza("PEP", pizzaAjout);
		Assert.assertNotEquals(tabPizza.get(0), pizzaAjout);

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

	@Test
	public void testDelete() {
		PizzaMemDao dao = new PizzaMemDao();

		List<Pizza> listePizzaTest = dao.findAllPizzas();

		Integer taille = listePizzaTest.size();
		System.out.println(listePizzaTest.size());

		dao.deletePizza("PEP");
		Integer tailleArrivee = listePizzaTest.size();
		System.out.println(listePizzaTest.size());

		Assert.assertNotEquals(taille, tailleArrivee);

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

	@Test
	public void testFindPizza() {
		PizzaMemDao dao = new PizzaMemDao();

		List<Pizza> listePizzaTest = findAllPizzas();

		Pizza pizzaTrouvee = findPizzaByCode("PEP");

		Assert.assertEquals(tabPizza.get(0), pizzaTrouvee);
		;

	}

}