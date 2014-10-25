package bataille;

import java.util.ArrayList;

public class Bataille {
	private ArrayList<Carte> jeu = new ArrayList<Carte>();
	private String[] couleurs = { "Pique", "Carreau", "Trèfle", "Coeur" };

	public static void main(String[] args) {
		Bataille maBataille = new Bataille();

		Joueur Olaf = new Joueur("Olaf");
		Joueur Pierre = new Joueur("Pierre");
		maBataille.creationJeu();
		maBataille.melangerJeu(maBataille.jeu);
		maBataille.distributionCarte(Olaf, Pierre);
		maBataille.jouerPartie(Olaf, Pierre);
	}

	public void creationJeu() {
		for (String couleur : couleurs) {
			for (int valeur = 0; valeur < 13; valeur++) {
				this.jeu.add(new Carte(couleur, valeur));
			}
		}
	}

	public void distributionCarte(Joueur joueur1, Joueur joueur2) {
		if (this.jeu.size() != 0) {
			for (Carte carte : this.jeu) {
				if (this.jeu.indexOf(carte) % 2 == 0)
					joueur1.addNewCard(carte);
				else
					joueur2.addNewCard(carte);
			}
		}
	}

	public void jouerPartie(Joueur joueur1, Joueur joueur2) {
		this.jouerManches(joueur1, joueur2);
		this.declareVainqueur(joueur1, joueur2);
	}

	private void jouerManches(Joueur joueur1, Joueur joueur2) {
		for (int i = 25; i >= 0; i--) {
			Carte carteJoueur1 = joueur1.playCard(i);
			System.out.println(joueur1.getPrenom() + " joue : "
					+ (carteJoueur1.getValeur() + 1) + " de "
					+ carteJoueur1.getCouleur());
			Carte carteJoueur2 = joueur2.playCard(i);
			System.out.println(joueur2.getPrenom() + " joue : "
					+ (carteJoueur2.getValeur() + 1) + " de "
					+ carteJoueur2.getCouleur());

			this.vainqueurManche(carteJoueur1, carteJoueur2, joueur1, joueur2);
		}
	}

	private void vainqueurManche(Carte carteJoueur1, Carte carteJoueur2,
			Joueur joueur1, Joueur joueur2) {
		if (carteJoueur1.isSuperiorTo(carteJoueur2)) {
			joueur1.addPoint();
			System.out.println(joueur1.getPrenom() + " gagne 1 point !" + "\n");
		}
		if (carteJoueur2.isSuperiorTo(carteJoueur1)) {
			joueur2.addPoint();
			System.out.println(joueur2.getPrenom() + " gagne 1 point !" + "\n");
		}
		if(carteJoueur1.getValeur() == carteJoueur2.getValeur())
			System.out.println("Personne ne gagne de point ! \n");
	}

	private void declareVainqueur(Joueur joueur1, Joueur joueur2) {
		if (joueur1.getPoint() > joueur2.getPoint())
			System.out.println("\n" + joueur1.getPrenom()
					+ " gagne la bataille avec " + joueur1.getPoint()
					+ " points !!");
		if (joueur1.getPoint() < joueur2.getPoint())
			System.out.println("\n" + joueur2.getPrenom()
					+ " gagne la bataille avec " + joueur2.getPoint()
					+ " points !!");
	}

	public void melangerJeu(ArrayList<Carte> jeu) {
		int iteration = 0;
		for (int i = 0; i < jeu.size(); i++) {

			int indexCartePourMelange = (int) Math.abs((Math.random() * jeu.size()));
			int indexAutreCarte = (int) Math.abs((Math.random() * jeu.size()));

			if (indexCartePourMelange != indexAutreCarte) {
				Carte cartePourMelange = jeu.get(indexCartePourMelange);
				Carte ancienneCarte = jeu.set(indexAutreCarte, cartePourMelange);
				jeu.set(indexCartePourMelange, ancienneCarte);
			}
			iteration++;
		}
		if (iteration < 2) {
			melangerJeu(jeu);
		}
	}
}
