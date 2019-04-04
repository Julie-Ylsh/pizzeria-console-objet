package MenuService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import DAO.PizzaJBADAO;
import DAO.PizzaMemDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

public class SupprimerPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner questionMenu, PizzaJBADAO dao) throws StockageException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("Suppression d'une pizza");
		System.out.println("Liste des pizzas");
		// Afficher la m�thode de la liste dees pizzas
		List<Pizza> pizzas2 = dao.findAllPizzas();

		/* Plus besoin de lister les pizzas !
		for (Pizza pizza : pizzas2) {
			System.out.println(pizza);
		}
		*/
		
//Ancien code
//		for (int i = 0; i < pizzas2.length; i++) {
//			if (pizzas2[i] != null) {
//				System.out.println(pizzas2[i]);
//			} else {
//				System.out.println("[case vide pizza]");
//			}
//		}
		System.out.println("Veuillez choisir le code de la pizza à supprimer");
		String codesup = null;
		do {
			codesup = questionMenu.nextLine();
			if (codesup.length() != 3)
				System.out.println("On a dit un code de 3 lettres !");
		}

		while (codesup.length() != 3);
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
