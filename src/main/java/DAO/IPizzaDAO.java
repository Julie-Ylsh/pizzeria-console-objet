package DAO;



import fr.pizzeria.model.Pizza;

public interface IPizzaDAO {
	Pizza [] findAllPizzas();
	void saveNewPizza (Pizza pizza);
	void updatePizza (String codePizza, Pizza pizza);
	void deletePizza (String codePizza);
	Pizza findPizzaByCode(String codePizza);
	boolean pizzaExists(String codePizza);

}
