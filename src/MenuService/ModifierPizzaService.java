package MenuService;

import java.util.Scanner;

import DAO.PizzaMemDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner questionMenu, PizzaMemDao dao) throws StockageException {
		// TODO Auto-generated method stub
		System.out.println("Mise à jour d'une pizza");
		System.out.println("Veuillez choisir le code d'une pizza à modifier");
		String code = questionMenu.nextLine();
		Pizza pizzaModif = dao.findPizzaByCode(code);

		if (pizzaModif != null) {
			System.out.println("La pizza que vous voulez modifier est la : ");
			System.out.println(pizzaModif);

			System.out.println("Veuillez choisir un nouveau nom pour la pizza :");
			String nomPizza2 = questionMenu.nextLine();

			System.out.println("Ecrivez également un nouveau raccourci de 3 lettres");
			String raccourci2 = questionMenu.nextLine();

			if (raccourci2.length() != 3) {
				throw new StockageException("On a dit un code de 3 lettres !");
			}

			System.out.println("A combien voulez-vous vendre cette pizza ? (indiquez un prix sans les euros)");
			String prixStr2 = questionMenu.nextLine();
			double prix2 = Double.parseDouble(prixStr2);
			if (prix2 < 0) {
				throw new StockageException("Vous avez entré un chiffre négatif. Mais quel idiot !");
			}
			if (prix2 > 20)
			{
				throw new StockageException("C'est un peu cher pour une pizza quand même !");
			}
			Pizza pizzaC = new Pizza(raccourci2, nomPizza2, prix2);
			dao.updatePizza(code, pizzaC);
			System.out.println("Votre pizza a bien été modifiée");
		} else
			System.out.println("Le code que vous avez entré ne correspond à rien");

	}

}
