package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import fr.pizzeria.exception.DataAccessException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaMemDao implements IPizzaDAO {

	public <TYPESORTIE> TYPESORTIE executerSQL(Function<Connection, TYPESORTIE> fn) {
		String jdbcUrl = "jdbc:mysql://bxtb5p7tvljidmqpfkpw-mysql.services.clever-cloud.com:3306/bxtb5p7tvljidmqpfkpw?useSSL=false";

		try (
				// Connexion au serveur
				Connection uneConnexion = DriverManager.getConnection(jdbcUrl, "u1hfeof3sqlpi6ge",
						"YgTkfeGiiheosyfYUf9F");) {
			return fn.apply(uneConnexion);
		} catch (SQLException e) {
			throw new DataAccessException("Problème de communication avec la base de données", e);
		}

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");

	}


	@Override
	public List<Pizza> findAllPizzas() {
		
		List<Pizza> listePizzas = new ArrayList<>();
		String jdbcUrl = "jdbc:mysql://bxtb5p7tvljidmqpfkpw-mysql.services.clever-cloud.com:3306/bxtb5p7tvljidmqpfkpw?useSSL=false";

		try (
				// Connexion au serveur
				Connection uneConnexion = DriverManager.getConnection(jdbcUrl, "u1hfeof3sqlpi6ge",
						"YgTkfeGiiheosyfYUf9F");
				Statement st = uneConnexion.createStatement();

				// Execution d'une requête
				ResultSet rs = st.executeQuery("SELECT * FROM PIZZA");) {

			while (rs.next()) {
				Integer id = rs.getInt("ID");
				String codePizza = rs.getString("CODE_PIZZA");
				String name = rs.getString("NAME");
				String categoriePizza = rs.getString("CATEGORIE_PIZZA");
				Double price = rs.getDouble("PRIX");
				listePizzas.add(new Pizza(id, codePizza, name, CategoriePizza.valueOf(categoriePizza), price));
			}
		} catch (SQLException e) {
			// TODO
		}
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
		st.executeUpdate("INSERT INTO PIZZA (CODE_PIZZA, NAME, CATEGORIE_PIZZA, PRIX) VALUES (" + requete + ")");

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
		st.executeUpdate("UPDATE PIZZA SET CODE_PIZZA= '" + codePizza2 + "', NAME='" + name + "', CATEGORIE_PIZZA='"
				+ categoriePizza + "', PRIX= " + price + " WHERE CODE_PIZZA='" + codePizza + "'");

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

		// fermeture des requêtes
		st.close();
		rs.close();
		uneConnexion.close();

		return pizzaTrouvee;
	}
}
