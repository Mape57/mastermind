package org.iut.mastermind.domain.partie;

public class Joueur {

	private final String nom;

	// constructeur
	public Joueur(String nom) {
		this.nom = nom;
	}

	// getter nom joueur
	public String getNom() {
		return this.nom;
	}

	// equals
	@Override
	public boolean equals(Object o) {
		if (o instanceof Joueur j) {
			return j.getNom().equals(this.getNom());
		}
		return false;
	}

	// hashcode
	@Override
	public int hashCode() {
		return this.getNom().hashCode();
	}
}
