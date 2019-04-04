package fr.pizzeria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe puor faire les pizzas
 * 
 * @author julie
 *
 */
@Entity
@Table(name = "Pizza")
public class Pizza {

	@Id // obligatoire
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "CODE_PIZZA")
	private String code;

	@Column(name = "NAME")
	private String libelle;

	@Column(name = "PRIX")
	private double prix;

	@Column(name = "CATEGORIE_PIZZA")
	@Enumerated(EnumType.STRING)
	private CategoriePizza type;

	public String getCode() {
		return code;
	}

	public void setCode(String PAP) {
		code = PAP;
	}

	/**
	 * @param code
	 * @param libelle
	 * @param prix
	 */
	
	public Pizza () {
		
	}
	public Pizza(String code, String libelle, CategoriePizza type, double prix) {
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.type = type;
	}

	/**
	 * @param id
	 * @param code
	 * @param libelle
	 * @param prix
	 */
	public Pizza(int id, String code, String libelle, CategoriePizza type, double prix) {
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.type = type;
	}

	public String toString() {
		return code + " -> " + libelle + " (" + type + ", " + prix + " €)";
	}

	public void afficherLibelle() {
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

	public CategoriePizza getType() {
		return type;
	}

	public void setType(CategoriePizza type) {
		this.type = type;
	}
}
