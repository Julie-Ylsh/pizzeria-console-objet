package tests_unitaires;

import java.sql.SQLException;

import org.junit.Test;

import DAO.PizzaJBADAO;
//import fr.pizzeria.model.CategoriePizza;
//import fr.pizzeria.model.Pizza;

public class PizzeriaTest {
	@Test
	public void testJUnitDelete() {
		// On implémente un premier truc
		try {
			//Pizza onTeste = new Pizza("PET", "Petita pizzanita", CategoriePizza.Viande, 12.5);
			PizzaJBADAO dao = new PizzaJBADAO();

			dao.deletePizza("PEP");

		} catch (SQLException e) {
			System.err.println("Attention SQL Exception");
		}


	}

}
