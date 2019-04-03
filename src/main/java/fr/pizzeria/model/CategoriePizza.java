package fr.pizzeria.model;

public enum CategoriePizza {
	Viande("Viande"), Poisson("Poisson"), Végétarienne("Végétarienne");
	private String nom;

	private CategoriePizza(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
