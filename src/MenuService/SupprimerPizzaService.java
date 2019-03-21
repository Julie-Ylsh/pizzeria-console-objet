package MenuService;

import java.util.Scanner;

import DAO.PizzaMemDao;
import fr.pizzeria.model.Pizza;

public class SupprimerPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner questionMenu, PizzaMemDao dao) {
		// TODO Auto-generated method stub
		System.out.println("Suppression d'une pizza");
		System.out.println("Liste des pizzas");
		// Afficher la méthode de la liste dees pizzas
		Pizza[] pizzas2 = dao.findAllPizzas();

		for (int i = 0; i < pizzas2.length; i++) {
			if (pizzas2[i] != null) {
				System.out.println(pizzas2[i]);
			} else {
				System.out.println("[case vide pizza]");
			}
		}
		System.out.println("Veuillez choisir le code de la pizza à supprimer");
		String codesup = questionMenu.nextLine();
		Pizza pizzaSup = dao.findPizzaByCode(codesup);

		if (pizzaSup != null) {
			System.out.println("La pizza que vous voulez supprimer est la : ");
			System.out.println(pizzaSup);
			dao.deletePizza(codesup);
			System.out.println("Votre pizza a bien été supprimée");
		} else
			System.out.println("Le code que vous avez entré ne correspond à rien");

	}

	

}
