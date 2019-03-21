package MenuService;

import java.util.Scanner;

import DAO.PizzaMemDao;
import fr.pizzeria.model.Pizza;

public class AjouterPizzaService extends MenuService {
	
	public void executeUC(Scanner questionMenu, PizzaMemDao toto) {
		// TODO Auto-generated method stub
		System.out.println("Ajout d'une nouvelle pizza");
		// Il va falloir créer une pizza
		// D'abord on récupère les nos de pizza et les code
		System.out.println("Un nom pour cette pizza ?");
		String nomPizza = questionMenu.nextLine();

		System.out.println("Ecrivez également un raccourci de 3 lettres");
		String raccourci = questionMenu.nextLine();

		System.out.println("A combien voulez-vous vendre cette pizza ? (indiquez un prix sans les euros)");
		String prixStr = questionMenu.nextLine();
		double prix = Double.parseDouble(prixStr);

		// Définition de la nouvelle pizza
		Pizza pizza = new Pizza(raccourci, nomPizza, prix);
		toto.saveNewPizza(pizza);
		System.out.println("Votre pizza a bien été ajoutée");
	}
}
