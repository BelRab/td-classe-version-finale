package fr.solinum.classe.td;

import java.util.ArrayList;
import java.util.List;

public class Principale {

	public static List<Tueur> listeTueur = new ArrayList<Tueur>();

	// une methode qui permet de comparer des objets

	public static boolean isEqual(Tueur tueur1, Tueur tueur2) {
		if (tueur1.getNom().equals(tueur2.getNom()) && tueur1.getAge() == tueur2.getAge()) {
			return true;
		} else {
			return false;
		}
	}

	public static void supprimer(Tueur tueur1) {

		// Gestion des exceptions
		if (listeTueur.isEmpty()) {
			throw new IndexOutOfBoundsException("La liste est vide");
		}

		int tailleListeTueur = listeTueur.size() - 1;
		Tueur tueurIsFirst = listeTueur.get(0);
		Tueur tueurIsLast = listeTueur.get(tailleListeTueur);

		// condition si le tueur a supprimer est le premier element de la liste

		if (isEqual(tueurIsFirst, tueur1)) {
			Tueur nouveauPremierTueur = listeTueur.get(1);
			tueurIsLast.setContrat(nouveauPremierTueur);
			nouveauPremierTueur.setContrat(tueurIsLast);

			listeTueur.remove(tueur1);
		}
		
		// condition si le tueur a supprimer est le dernier element de la liste

		else if (isEqual(tueurIsLast, tueur1)) {
			Tueur nouveauDernierTueur = listeTueur.get(tailleListeTueur);
			nouveauDernierTueur.setContrat(tueurIsLast.getContrat());

			listeTueur.remove(tueur1);
		}

		// parcourir la liste array et ou on trouve le tueur choisi on va faire le mis a
		// jour de son precedent et de son successeur puis on va lui supprimer
		else {

			for (int i = 0; i < listeTueur.size(); i++) {
				Tueur tueurCourant = listeTueur.get(i);
				if (isEqual(tueurCourant, tueur1)) {
					Tueur tueurPrecedent = listeTueur.get(i - 1);
					Tueur tueurSuivant = listeTueur.get(i + 1);

					tueurPrecedent.setContrat(tueurSuivant);
					listeTueur.remove(tueur1);
				}
			}
		}
	}

	public static void inserrer(String nom, int age, int position) {

		Tueur nouveauTueur = new Tueur(nom, age);
		int tailleListeTueur = listeTueur.size() - 1;
		// gestion des exceptions

		// si la valeur de la position est plus grand de la taille de liste

		if (position > listeTueur.size()) {
			throw new NullPointerException("Position invalide,Il faut choisir une autre position");
		}

		// si la liste est vide

		if (listeTueur.isEmpty()) {
			nouveauTueur.setContrat(null);
			listeTueur.add(nouveauTueur);
		}
		// si la liste n'est pas vide
		else {

			Tueur tueurPremier = listeTueur.get(0);// apres le test de liste empty ou non
			Tueur tueurDernier = listeTueur.get(tailleListeTueur);

			// si la position est à 0

			if (position == 0) {
				nouveauTueur.setContrat(tueurPremier);
				tueurDernier.setContrat(nouveauTueur);
				listeTueur.add(position, nouveauTueur);
			}
			// si la position est egale a la taille de tableau

			else if (position > 0) {
				Tueur tueurAvant = listeTueur.get(position - 1);
				Tueur tueurApres = listeTueur.get(position);

				nouveauTueur.setContrat(tueurApres);
				tueurAvant.setContrat(nouveauTueur);

				listeTueur.add(position, nouveauTueur);
			}
		}
	}

	public static void main(String args[]) {

		Tueur tueur1 = new Tueur("Ibrahim", 55);
		Tueur tueur2 = new Tueur("Salah", 53);
		Tueur tueur3 = new Tueur("Rabie", 43);

		tueur1.setContrat(tueur2);
		tueur2.setContrat(tueur3);
		tueur3.setContrat(tueur1);

		 listeTueur.add(tueur1);
		 listeTueur.add(tueur2);
		 listeTueur.add(tueur3);

		// inserrer("Hassan", 56, 1);

		supprimer(tueur2);

		// System.out.println(listeTueur.size());
		System.out.println("\n---  C'est ci est l'affichage avec ArrayList ----\n");
		for (int i = 0; i < listeTueur.size(); i++) {

			System.out.println("Le nom de tueur est :" + listeTueur.get(i).getNom() + " et son contrat est :"
					+ listeTueur.get(i).getContrat().getNom());
		}

		System.out.println("\n----	C'est ci est l'affichage normal sans ArrayList	------\n");

		System.out.println(tueur1.afficher());
		System.out.println(tueur2.afficher());
		System.out.println(
				"\n---	C'est ci est l'affichage contrat de contrat de tueur " + tueur2.getNom() + "	----\n");

		tueur2.afficheContrat(tueur3);
	}
}
