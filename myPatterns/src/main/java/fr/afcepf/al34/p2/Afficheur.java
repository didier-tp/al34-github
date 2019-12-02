package fr.afcepf.al34.p2;

import javax.swing.JOptionPane;

public class Afficheur {
	
	private Preferences preferences = new Preferences();//avec titre et préfixe par défaut
	
	private ContextAffichage contextAffichage; //interface 	abstraite (ressemble XyListener)
	
		
	//méthode d'enregistrement (ressemble à addXyListener)
	public void setContextAffichage(ContextAffichage contextAffichage) {
		this.contextAffichage = contextAffichage;
		this.preferences = this.contextAffichage.getPreferences();
	}


	public void afficher(Object obj) {
		//System.out.println(obj.toString());
		JOptionPane.showMessageDialog(null, 
				this.preferences.getPrefixe()+obj.toString(), 
				this.preferences.getTitre(),
				JOptionPane.INFORMATION_MESSAGE);
	}

}
