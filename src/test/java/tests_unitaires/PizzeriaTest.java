package tests_unitaires;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.mockito.Mockito;

import DAO.IPizzaDAO;
//import fr.pizzeria.model.CategoriePizza;
//import fr.pizzeria.model.Pizza;
import DAO.PizzaMemDao;
import MenuService.AjouterPizzaService;
import MenuService.MenuService;
import MenuService.SupprimerPizzaService;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzeriaTest {
	@Test
	public void testSaveNew() {
		PizzaMemDao dao = new PizzaMemDao();
		Pizza pizzaAjout = new Pizza("JOL", "Julietheverybest", CategoriePizza.Viande, 12.50);

		List<Pizza> listePizzaTest = dao.findAllPizzas();

		Integer taille = listePizzaTest.size();
		System.out.println(listePizzaTest.size());

		dao.saveNewPizza(pizzaAjout);
		Integer tailleArrivee = listePizzaTest.size();
		System.out.println(listePizzaTest.size());

		Assert.assertNotEquals(taille, tailleArrivee);

	}

	@Test
	public void testUpdatePizza() {
		PizzaMemDao dao = new PizzaMemDao();
		List<Pizza> listePizzaTest = dao.findAllPizzas();
		Pizza pizzaAjout = new Pizza("JUL", "Juliethebest", CategoriePizza.Viande, 12.50);

		dao.updatePizza("PEP", pizzaAjout);
		Assert.assertNotEquals(dao.tabPizza.get(0), pizzaAjout);

	}

	@Test
	public void testDelete() {
		PizzaMemDao dao = new PizzaMemDao();

		List<Pizza> listePizzaTest = dao.findAllPizzas();

		Integer taille = listePizzaTest.size();
		System.out.println(listePizzaTest.size());

		dao.deletePizza("PEP");
		Integer tailleArrivee = listePizzaTest.size();
		System.out.println(listePizzaTest.size());

		Assert.assertNotEquals(taille, tailleArrivee);

	}

	@Test
	public void testFindPizza() {
		PizzaMemDao dao = new PizzaMemDao();

		List<Pizza> listePizzaTest = dao.findAllPizzas();

		Pizza pizzaTrouvee = dao.findPizzaByCode("PEP");

		Assert.assertEquals(dao.tabPizza.get(0), pizzaTrouvee);
		;

	}

	/**
	 * Création d'une "Rule" qui va permettre de substituer le System.in utilisé
	 * par le Scanner par un mock: systemInMock
	 */
	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@Test
	public void testAjouterPizzaService() throws StockageException, SQLException {
		// J'alimente le mock avec une nouvelle pizza
		// La nouvelle pizza sera de type : "JOL", "Julietheverybest",
		// CategoriePizza.Viande, 12.50);
		Pizza pizzaAVerifier = new Pizza("JOL", "Julietheverybest", CategoriePizza.Viande, 12.5);
		systemInMock.provideLines("Julietheverybest", "JOL", "1", "12.5");
		AjouterPizzaService serv = new AjouterPizzaService();

		serv.executeUC(new Scanner(System.in));
		System.out.println(MenuService.getGestionnairePizza().findAllPizzas());

		Assert.assertEquals(
				MenuService.getGestionnairePizza().findAllPizzas()
						.get(MenuService.getGestionnairePizza().findAllPizzas().size() - 1).toString(),
				pizzaAVerifier.toString());

	}

	@Test
	public void testSupprimerPizzaService() {

		List<Pizza> listePizzaTest = MenuService.getGestionnairePizza().findAllPizzas();
		Integer taille = listePizzaTest.size();
		System.out.println(listePizzaTest.size());

		systemInMock.provideLines("PEP");
		SupprimerPizzaService serv = new SupprimerPizzaService();
		try {
			serv.executeUC(new Scanner(System.in));
		} catch (StockageException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("fail");
		}

		Integer tailleArrivee = listePizzaTest.size();
		System.out.println(listePizzaTest.size());

		Assert.assertNotEquals(taille, tailleArrivee);

	}

	@Test 
	public void testSupprimerPizzaServiceMockito() throws StockageException, SQLException {
		IPizzaDAO mockedDao = Mockito.mock(IPizzaDAO.class);
		Mockito.doThrow(new StockageException()).when(mockedDao).deletePizza(Mockito.anyString());

	}

	@Test 
	public void  testFindAllPizzas() throws StockageException, SQLException {
		IPizzaDAO mockedDao = Mockito.mock(IPizzaDAO.class);
		Mockito.when(mockedDao.findAllPizzas()).thenReturn(new ArrayList<Pizza>());
	}
}
