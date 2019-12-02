package fr.afcepf.al34.p1;

import fr.afcepf.al34.p2.Afficheur;
import fr.afcepf.al34.p2.Preferences;

public class MyAppP1 {
	
	private Afficheur afficheur = new Afficheur(this);
	private String data = "valeur à afficher";
	
	public static void main(String[] args) {
		(new MyAppP1()).tache();
	}
	
	public void tache() {
		afficheur.afficher(data);
	}
	
	public Preferences getPreferences() {
		return new Preferences("p1", "** ");
	}
}
