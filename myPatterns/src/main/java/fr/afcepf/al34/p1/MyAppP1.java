package fr.afcepf.al34.p1;

import fr.afcepf.al34.p2.Afficheur;

public class MyAppP1 {
	
	private Afficheur afficheur = new Afficheur();
	private String data = "valeur à afficher";
	
	public static void main(String[] args) {
		(new MyAppP1()).tache();
	}
	
	public void tache() {
		afficheur.afficher(data);
	}
}
