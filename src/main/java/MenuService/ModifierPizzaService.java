package MenuService;

import java.util.Scanner;

import DAO.PizzaMemDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import utils.NumberUtils;

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

			System.out.println(
					"La pizza est actuellement classée : " + pizzaModif.getType() + ". Choisissez son nouveau type :");
			System.out.println("Tapez 1 pour une pizza à la viande");
			System.out.println("Tapez 2 pour une pizza au poisson");
			System.out.println("Tapez 3 pour une pizza végétarienne");
			String questionTypeSrt = questionMenu.nextLine();

			if (NumberUtils.isNumber(questionTypeSrt) == false) {
				throw new StockageException("Ceci n'est pas un numéro, doofus");
			}
			if (!(questionTypeSrt.equals("1") || questionTypeSrt.equals("2") || questionTypeSrt.equals("3"))) {
				throw new StockageException("Vous n'avez pas tapé le bon choix");
			}

			System.out.println("A combien voulez-vous vendre cette pizza ? (indiquez un prix sans les euros)");
			String prixStr2 = questionMenu.nextLine();

			if (NumberUtils.isNumber(prixStr2) == false) {
				throw new StockageException("Ceci n'est pas un prix, doofus");
			}
			Double prix2 = Double.parseDouble(prixStr2);
			if (prix2 < 0) {
				throw new StockageException("Vous avez entré un chiffre négatif. Mais quel idiot !");
			}
			if (prix2 > 20) {
				throw new StockageException("C'est un peu cher pour une pizza quand même !");
			}

			CategoriePizza categorie = CategoriePizza.VIANDE;
			if (questionTypeSrt.equals("1")) {
				categorie = CategoriePizza.VIANDE;
			} else if (questionTypeSrt.equals("2")) {
				categorie = CategoriePizza.POISSON;
			} else if (questionTypeSrt.equals("3")) {
				categorie = CategoriePizza.VEGETARIENNE;
			}

			Pizza pizzaC = new Pizza(raccourci2, nomPizza2, categorie, prix2);
			dao.updatePizza(code, pizzaC);
			System.out.println("Votre pizza a bien été modifiée");
		} else
			System.out.println("Le code que vous avez entré ne correspond à rien");

	}

}
