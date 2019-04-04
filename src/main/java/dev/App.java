package dev;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.pizzeria.model.Pizza;




public class App {
	
	public static void main (String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pizzeria");
			
		EntityManager em1 = emf.createEntityManager();
		
		TypedQuery<Pizza> requete = em1.createQuery("select p from Pizza p", Pizza.class);
		List<Pizza> listePizzas =  requete.getResultList();
		listePizzas.forEach(unePizza -> {
			System.out.println(unePizza.getId() + " - "  + unePizza.getPrix() + " - " + unePizza.getLibelle());
		});
		
		em1.close();
		emf.close();
	}
	
	

}
