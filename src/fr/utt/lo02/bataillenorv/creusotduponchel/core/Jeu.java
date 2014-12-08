package fr.utt.lo02.bataillenorv.creusotduponchel.core;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import fr.utt.lo02.bataillenorv.creusotduponchel.core.carte.Carte;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.carte.CarteAs;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.carte.CarteDeux;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.carte.CarteDix;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.carte.CarteHuit;
import fr.utt.lo02.bataillenorv.creusotduponchel.core.carte.CarteSept;

public class Jeu {
	private Iterator<Joueur> tourJeu;
	private List<Joueur> listeDeJoueurs;
	private LinkedList<Carte> pioche;
	private Collection<Carte> tas;



	public Jeu(LinkedList<Joueur> listeDeJoueurs){
		this.listeDeJoueurs=listeDeJoueurs;
		tas = new LinkedList<>();
		pioche = new LinkedList<>();
		initCartes();
	}

	/**
	 * Initialise les cartes du jeu et les ajoutes dans la pioche
	 */
	private void initCartes() {
		Collection<Carte> jeuCarte = new ArrayList<Carte>(13);
		//Initialise un jeu de carte
		for(int i=0; i<13; i++) {
			switch(i+1) {
			case 2 : 
				jeuCarte.add(new CarteDeux());
				break;
			case 7 :
				jeuCarte.add(new CarteSept());
				break;
			case 8 :
				jeuCarte.add(new CarteHuit());
				break;
			case 10 :
				jeuCarte.add(new CarteDix());
				break;
			case 1 :
				jeuCarte.add(new CarteAs());
				break;
			default :
				jeuCarte.add(new Carte(i+1));
				break;
			}
		}

		//nbJoueur/6+1 -> nb packet de carte -> (4*13 carte)
		for(int i =0; i<(listeDeJoueurs.size()/6 +1)*4; i++) {
			pioche.addAll(jeuCarte);
		}
		
		//on melange la pioche
		Collections.shuffle(pioche);
	}

	/**
	 * Lance une partie
	 */
	public void start() {
		listeDeJoueurs.get(0).distribuer(listeDeJoueurs, pioche);
		//TODO : suite du jeu
	}
	
	Iterator<Joueur>getTourJeu() {
		return tourJeu;
	}
	
	


}
