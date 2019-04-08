package MenuService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class ListerPizzasService extends MenuService {
	@Override
	public void executeUC(Scanner questionMenu) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Liste des pizzas");
		// La fonction pour afficher

		List<Pizza> pizzas = gestionnairePizza.findAllPizzas();

		/*
		 * Ancien code for (Pizza pizza : pizzas) { System.out.println(pizza); }
		 */
		// Ancien code
		// for (int i = 0; i < pizzas.size(); i++) {
		// if (pizzas[i] != null) {
		// System.out.println(pizzas[i]);
		// } else {
		// System.out.println("[case vide pizza]");
		// }
		// }
	}

}
