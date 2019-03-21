package fr.pizzeria.model;

/**
 * Classe puor faire les pizzas
 * @author julie
 *
 */
public class Pizza {

	private int id;
	private String code;
	private String libelle;
	private double prix;
	
	public String getCode () {
		return code;
	}
	public void setCode (String PAP){
	code = PAP;
	}
	
	/**
	 * @param code
	 * @param libelle
	 * @param prix
	 */
	public Pizza(String code, String libelle, double prix) {
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}

	/**
	 * @param id
	 * @param code
	 * @param libelle
	 * @param prix
	 */
	public Pizza(int id, String code, String libelle, double prix) {
		this.id = id;
		this.code = code;
		this.libelle = libelle; 
		this.prix = prix;
	}

	public String toString() {
		return code + " -> " + libelle + " (" + prix + " €)";
	}
	public void afficherLibelle () {
		System.out.println(libelle);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
}
