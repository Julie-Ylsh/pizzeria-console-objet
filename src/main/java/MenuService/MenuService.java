package MenuService;

import java.sql.SQLException;
import java.util.Scanner;

import DAO.PizzaJBADAO;

import fr.pizzeria.exception.StockageException;

public abstract class MenuService {

	public abstract void executeUC(Scanner scanner, PizzaJBADAO dao) throws StockageException, SQLException;
}
