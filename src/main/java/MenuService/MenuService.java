package MenuService;

import java.sql.SQLException;
import java.util.Scanner;

import DAO.IPizzaDAO;
import DAO.PizzaJBADAO;
import fr.pizzeria.exception.StockageException;

public abstract class MenuService {
	
	public static IPizzaDAO gestionnairePizza = new PizzaJBADAO();

	public abstract void executeUC(Scanner scanner) throws StockageException, SQLException;

	public static IPizzaDAO getGestionnairePizza() {
		return gestionnairePizza;
	}

	public static void setGestionnairePizza(IPizzaDAO gestionnairePizza) {
		MenuService.gestionnairePizza = gestionnairePizza;
	}

}
