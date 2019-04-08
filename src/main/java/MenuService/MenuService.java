package MenuService;

import java.sql.SQLException;
import java.util.Scanner;

import DAO.IPizzaDAO;
import DAO.PizzaMemDao;
import fr.pizzeria.exception.StockageException;

public abstract class MenuService {
	
	public static IPizzaDAO gestionnairePizza = new PizzaMemDao();

	public abstract void executeUC(Scanner scanner) throws StockageException, SQLException;

}
