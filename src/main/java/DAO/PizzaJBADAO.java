package DAO;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.pizzeria.model.Pizza;

public class PizzaJBADAO implements IPizzaDAO {

	@Override
	public List<Pizza> findAllPizzas() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pizzeria");
		EntityManager em1 = emf.createEntityManager();

		TypedQuery<Pizza> requete = em1.createQuery("select p from Pizza p", Pizza.class);
		List<Pizza> listePizzas = requete.getResultList();
		listePizzas.forEach(unePizza -> {
			System.out.println(unePizza.getId() + " - " + unePizza.getCode() + " - " + unePizza.getLibelle() + " ( "
					+ unePizza.getPrix() + "€ )");
		});

		em1.close();
		emf.close();

		return listePizzas;

	}

	@Override
	public void saveNewPizza(Pizza nvPizza) throws SQLException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pizzeria");
		EntityManager em1 = emf.createEntityManager();

		// insertion nouvelle pizza en ouvrant une transaction
		EntityTransaction et = em1.getTransaction();
		et.begin();
		em1.persist(nvPizza);

		et.commit();
		em1.close();
		emf.close();

	}
	


	@Override
	public void updatePizza(String codePizza, Pizza pizza) throws SQLException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pizzeria");
		EntityManager em1 = emf.createEntityManager();

		// Recherche de la pizza par le code
		TypedQuery<Pizza> requete = em1.createQuery("select p from Pizza p where CODE_PIZZA='" + codePizza + "'",
				Pizza.class);
		Pizza pizzaTrouvee = requete.getSingleResult();

		// modificationpizza en ouvrant une transaction
		EntityTransaction et = em1.getTransaction();
		et.begin();
		Pizza p = em1.find(Pizza.class, pizzaTrouvee.getId());
		if (p != null) {
			p.setLibelle(pizza.getLibelle());
			p.setPrix(pizza.getPrix());
			p.setType(pizza.getType());
		}

		et.commit();
		em1.close();
		emf.close();

	}

	@Override
	public void deletePizza(String codePizza) throws SQLException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pizzeria");
		EntityManager em1 = emf.createEntityManager();

		// Recherche de la pizza par le code
		TypedQuery<Pizza> requete = em1.createQuery("select p from Pizza p where CODE_PIZZA='" + codePizza + "'",
				Pizza.class);
		Pizza pizzaTrouvee = requete.getSingleResult();

		// modificationpizza en ouvrant une transaction
		EntityTransaction et = em1.getTransaction();
		et.begin();
		Pizza p = em1.find(Pizza.class, pizzaTrouvee.getId());
		if (p != null) {
			em1.remove(p);
		}

		et.commit();
		em1.close();
		emf.close();
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) throws SQLException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pizzeria");
		EntityManager em1 = emf.createEntityManager();

		// Recherche de la pizza par le code
		TypedQuery<Pizza> requete = em1.createQuery("select p from Pizza p where CODE_PIZZA='" + codePizza + "'",
				Pizza.class);
		Pizza pizzaTrouvee = requete.getSingleResult();

		// modificationpizza en ouvrant une transaction
		EntityTransaction et = em1.getTransaction();
		et.begin();
		Pizza p = em1.find(Pizza.class, pizzaTrouvee.getId());
		return p;
	}
}
