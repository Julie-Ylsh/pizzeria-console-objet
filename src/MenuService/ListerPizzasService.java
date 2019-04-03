package MenuService;

import java.util.Scanner;

import DAO.PizzaMemDao;
import fr.pizzeria.model.Pizza;

public class ListerPizzasService extends MenuService {
	@Override
	public void executeUC(Scanner questionMenu, PizzaMemDao dao) {
		// TODO Auto-generated method stub
		System.out.println("Liste des pizzas");
		// La fonction pour afficher

		Pizza[] pizzas = dao.findAllPizzas();

		for (int i = 0; i < pizzas.length; i++) {
			if (pizzas[i] != null) {
				System.out.println(pizzas[i]);
			} else {
				System.out.println("[case vide pizza]");
			}
		}
	}

}
