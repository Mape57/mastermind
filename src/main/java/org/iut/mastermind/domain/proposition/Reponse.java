package org.iut.mastermind.domain.proposition;

import java.util.ArrayList;
import java.util.List;

public class Reponse {
	private final String motSecret;
	private final List<Lettre> resultat = new ArrayList<>();
	private int position;

	public Reponse(String mot) {
		this.motSecret = mot;
	}

	// on récupère la lettre à la position dans le résultat
	public Lettre lettre(int position) {
		return resultat.get(position);
	}

	// on construit le résultat en analysant chaque lettre
	// du mot proposé
	public void compare(String essai) {
		for (this.position = 0; this.position < essai.length(); this.position++) {
			char c = essai.charAt(this.position);
			this.resultat.add(this.evaluationCaractere(c));
		}
	}

	// si toutes les lettres sont placées
	public boolean lettresToutesPlacees() {
		return this.resultat.stream().allMatch(Lettre.PLACEE::equals);
	}

	public List<Lettre> lettresResultat() {
		return this.resultat;
	}

	// renvoie le statut du caractère
	private Lettre evaluationCaractere(char carCourant) {
		if (this.estPlace(carCourant)) {
			return Lettre.PLACEE;
		} else if (this.estPresent(carCourant)) {
			return Lettre.NON_PLACEE;
		} else {
			return Lettre.INCORRECTE;
		}
	}

	// le caractère est présent dans le mot secret
	private boolean estPresent(char carCourant) {
		return this.motSecret.contains(String.valueOf(carCourant));
	}

	// le caractère est placé dans le mot secret
	private boolean estPlace(char carCourant) {
		return this.motSecret.charAt(position) == carCourant;
	}
}
