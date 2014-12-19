package fr.utt.lo02.bataillenorv.creusotduponchel.core;



public class CarteDix extends Carte {

	public CarteDix() {
		super(10);
	}

	@Override
	public void onPlaced(Jeu jeu, int nb) {
		super.onPlaced(jeu, nb);
		jeu.getTas().clear();
	}
	
	

}
