package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaMemDao implements IPizzaDAO {
	/*
	 * Ancienne commande pour créer un tableau de pizzas private Pizza[]
	 * listePizzas = new Pizza[10];
	 * 
	 * public PizzaMemDao() {
	 * 
	 * listePizzas[0] = new Pizza(0, "PEP", "Peperoni", CategoriePizza.VIANDE,
	 * 12.5); listePizzas[1] = new Pizza(1, "MAR", "Margherita",
	 * CategoriePizza.VEGETARIENNE, 14.00); listePizzas[2] = new Pizza(2, "REI",
	 * "La Reine", CategoriePizza.VIANDE, 11.50); listePizzas[3] = new Pizza(3,
	 * "FRO", "La 4 fromages", CategoriePizza.VEGETARIENNE, 12.00);
	 * listePizzas[4] = new Pizza(4, "CAN", "La cannibale",
	 * CategoriePizza.VIANDE, 12.50); listePizzas[5] = new Pizza(5, "SAV",
	 * "La savoyarde", CategoriePizza.VIANDE, 13.00); listePizzas[6] = new
	 * Pizza(6, "ORI", "L'orientale", CategoriePizza.VIANDE, 13.50);
	 * listePizzas[7] = new Pizza(7, "IND", "L'indienne",
	 * CategoriePizza.POISSON, 14.00);
	 * 
	 * }
	 */

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");

	}

	@Override
	public boolean pizzaExists(String codePizza) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Pizza> findAllPizzas() throws SQLException {
		List<Pizza> listePizzas = new ArrayList<>();
		String jdbcUrl = "jdbc:mysql://bxtb5p7tvljidmqpfkpw-mysql.services.clever-cloud.com:3306/bxtb5p7tvljidmqpfkpw?useSSL=false";

		// Connexion au serveur
		Connection uneConnexion = DriverManager.getConnection(jdbcUrl, "u1hfeof3sqlpi6ge", "YgTkfeGiiheosyfYUf9F");
		Statement st = uneConnexion.createStatement();

		// Execution d'une requête
		ResultSet rs = st.executeQuery("SELECT * FROM PIZZA");

		while (rs.next()) {
			Integer id = rs.getInt("ID");
			String codePizza = rs.getString("CODE_PIZZA");
			String name = rs.getString("NAME");
			String categoriePizza = rs.getString("CATEGORIE_PIZZA");
			Double price = rs.getDouble("PRIX");
			listePizzas.add(new Pizza(id, codePizza, name, CategoriePizza.valueOf(categoriePizza), price));
		}
		rs.close();
		st.close();
		uneConnexion.close();
		return listePizzas;

	}

	@Override
	public void saveNewPizza(Pizza nvPizza) throws SQLException {
		String jdbcUrl = "jdbc:mysql://bxtb5p7tvljidmqpfkpw-mysql.services.clever-cloud.com:3306/bxtb5p7tvljidmqpfkpw?useSSL=false";

		// Connexion au serveur
		Connection uneConnexion = DriverManager.getConnection(jdbcUrl, "u1hfeof3sqlpi6ge", "YgTkfeGiiheosyfYUf9F");
		Statement st = uneConnexion.createStatement();

		// Rcupération des infos données de l'utilisateur et éxecution d'une
		// requête
		// Pizza pizzaAjout = nvPizza;
		String codePizza = nvPizza.getCode();
		String name = nvPizza.getLibelle();
		String categoriePizza = nvPizza.getType().getNom();
		Double price = nvPizza.getPrix();
		String requete = "\"" + codePizza + "\"" + ", " + "\"" + name + "\"" + ", " + "\"" + categoriePizza + "\""
				+ ", " + price;
		System.out.println(requete);
		st.executeUpdate("INSERT INTO PIZZA (CODE_PIZZA, NAME, CATEGORIE_PIZZA, PRIX) VALUES ("
				+ requete + ")");

		// fermeture des requêtes
		st.close();
		uneConnexion.close();

	}

	/*
	 * Ancien code for (int i = 0; i < listePizzas.length; i++) { if
	 * (listePizzas[i] == null) { listePizzas[i] = nvPizza; break;
	 */

	@Override
	public void updatePizza(String codePizza, Pizza pizzaC) throws SQLException {

		String jdbcUrl = "jdbc:mysql://bxtb5p7tvljidmqpfkpw-mysql.services.clever-cloud.com:3306/bxtb5p7tvljidmqpfkpw?useSSL=false";

		// Connexion au serveur
		Connection uneConnexion = DriverManager.getConnection(jdbcUrl, "u1hfeof3sqlpi6ge", "YgTkfeGiiheosyfYUf9F");
		Statement st = uneConnexion.createStatement();

		// Rcupération des infos données de l'utilisateur et éxecution d'une
		// requête
		// Pizza pizzaAjout = nvPizza;
		String codePizza2 = pizzaC.getCode();
		String name = pizzaC.getLibelle();
		String categoriePizza = pizzaC.getType().getNom();
		Double price = pizzaC.getPrix();
		st.executeUpdate("UPDATE PIZZA SET CODE_PIZZA= '"+ codePizza2 + "', NAME='" + name + "', CATEGORIE_PIZZA='"
				+ categoriePizza + "', PRIX= "+ price +" WHERE CODE_PIZZA='" + codePizza + "'");

		// fermeture des requêtes
		st.close();
		uneConnexion.close();

		/*
		 * Ancienne méthode for (int i = 0; i < listePizzas.length; i++) { // if
		 * (listePizzas[i] != null &&
		 * listePizzas[i].getCode().equals(codePizza)) { // listePizzas[i] =
		 * pizzaC; // } // }
		 */

	}

	@Override
	public void deletePizza(String codePizza) throws SQLException {

		String jdbcUrl = "jdbc:mysql://bxtb5p7tvljidmqpfkpw-mysql.services.clever-cloud.com:3306/bxtb5p7tvljidmqpfkpw?useSSL=false";

		// Connexion au serveur
		Connection uneConnexion = DriverManager.getConnection(jdbcUrl, "u1hfeof3sqlpi6ge", "YgTkfeGiiheosyfYUf9F");
		PreparedStatement st = uneConnexion.prepareStatement("DELETE FROM PIZZA WHERE CODE_PIZZA = ?");
		st.setString(1, codePizza);

		// Execution d'une
		// requête

		st.executeUpdate();
		

		// fermeture des requêtes
		st.close();
		uneConnexion.close();

	}

	@Override
	public Pizza findPizzaByCode(String codePizza) throws SQLException {

		String jdbcUrl = "jdbc:mysql://bxtb5p7tvljidmqpfkpw-mysql.services.clever-cloud.com:3306/bxtb5p7tvljidmqpfkpw?useSSL=false";

		// Connexion au serveur
		Connection uneConnexion = DriverManager.getConnection(jdbcUrl, "u1hfeof3sqlpi6ge", "YgTkfeGiiheosyfYUf9F");
		Statement st = uneConnexion.createStatement();

		// Execution d'une requête

		ResultSet rs = st.executeQuery("SELECT * FROM PIZZA WHERE CODE_PIZZA = '" + codePizza + "'");
		rs.next();
		Integer id = rs.getInt("ID");
		String codePizza2 = rs.getString("CODE_PIZZA");
		String name = rs.getString("NAME");
		String categoriePizza = rs.getString("CATEGORIE_PIZZA");
		Double price = rs.getDouble("PRIX");
		Pizza pizzaTrouvee = new Pizza(id, codePizza2, name, CategoriePizza.valueOf(categoriePizza), price);
		return pizzaTrouvee;
	}
}
