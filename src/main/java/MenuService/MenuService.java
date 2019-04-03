package MenuService;

import java.sql.SQLException;
import java.util.Scanner;

import DAO.PizzaMemDao;
import fr.pizzeria.exception.StockageException;

public abstract class MenuService {
	
	public abstract void executeUC(Scanner scanner, PizzaMemDao dao) throws StockageException, SQLException;
}
