package fr.pizzeria.console;

import java.util.Arrays;
import java.util.Scanner;

import DAO.PizzaMemDao;
import MenuService.AjouterPizzaService;
import MenuService.ListerPizzasService;
import MenuService.ModifierPizzaService;
import MenuService.SupprimerPizzaService;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {

		PizzaMemDao dao = new PizzaMemDao();
		Scanner questionMenu = new Scanner(System.in);

		int cpt = 8;

		// Afficher les options du menu
		System.out.println("***** Pizzeria Administration*****");
		System.out.println("1. Lister les pizzas");
		System.out.println("2. Ajouter une nouvelle pizza");
		System.out.println("3. Mettre � jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("99. Sortir");

		boolean fin = false;
		while (fin == false) {

			// On demande quelle action l'utilisateur veut faire
			System.out.println("Menu principal. Veuillez faire votre choix");

			String z = questionMenu.nextLine();
			int question = Integer.parseInt(z);

			if (question != 99) {
				fin = false;
				switch (question) {
				case 1:
					ListerPizzasService liste = new ListerPizzasService();
					liste.executeUC(questionMenu, dao);

					break;
				case 2:
					AjouterPizzaService ajout = new AjouterPizzaService();
					try {
						ajout.executeUC(questionMenu, dao);
					} catch (StockageException e3) {
						// TODO Auto-generated catch block
						System.out.println(e3.getMessage());
					}

					break;
				case 3:
					ModifierPizzaService modif = new ModifierPizzaService();
					try {
						modif.executeUC(questionMenu, dao);
					} catch (StockageException e2) {
						System.out.println(e2.getMessage());
					}
					break;
				case 4:
					SupprimerPizzaService suppression = new SupprimerPizzaService();
					suppression.executeUC(questionMenu, dao);
					break;

				default:
					System.out.println("Je n'ai pas compris votre choix, merci de r�essayer");

				}

			} else

			{
				System.out.println("Au revoir !");
				fin = true;
			}
		}
		questionMenu.close();

	}
}