package fr.pizzeria.console;

import java.sql.SQLException;
import java.util.Scanner;

import DAO.PizzaJBADAO;
import MenuService.AjouterPizzaService;
import MenuService.ListerPizzasService;
import MenuService.ModifierPizzaService;
import MenuService.SupprimerPizzaService;
import fr.pizzeria.exception.DataAccessException;
import fr.pizzeria.exception.StockageException;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) throws SQLException, StockageException {

		PizzaJBADAO dao = new PizzaJBADAO();
		Scanner questionMenu = new Scanner(System.in);

		int cpt = 8;

		// Afficher les options du menu
		System.out.println("***** Pizzeria Administration*****");
		

		boolean fin = false;
		while (fin == false) {

			// On demande quelle action l'utilisateur veut faire
			System.out.println("/n" + "Menu principal. Veuillez faire votre choix");
			System.out.println("1. Lister les pizzas");
			System.out.println("2. Ajouter une nouvelle pizza");
			System.out.println("3. Mettre à jour une pizza");
			System.out.println("4. Supprimer une pizza");
			System.out.println("99. Sortir");

			String z = questionMenu.nextLine();
			int question = Integer.parseInt(z);
			try {
			if (question != 99) {
				fin = false;
				switch (question) {
				case 1:
					ListerPizzasService liste = new ListerPizzasService();
					liste.executeUC(questionMenu);

					break;
				case 2:
					AjouterPizzaService ajout = new AjouterPizzaService();
					
						ajout.executeUC(questionMenu);
					

					break;
				case 3:
					ModifierPizzaService modif = new ModifierPizzaService();
					
						modif.executeUC(questionMenu);
					
					break;
				case 4:
					SupprimerPizzaService suppression = new SupprimerPizzaService();
					suppression.executeUC(questionMenu);
					break;

				default:
					System.out.println("Je n'ai pas compris votre choix, merci de réessayer");

				}

			} else

			{
				System.out.println("Au revoir !");
				fin = true;
			}
			
			} catch (StockageException | DataAccessException e) {
				System.out.println(e.getMessage());
			}
		}
		questionMenu.close();

	}
}
