package fr.afcepf.al34.p2;

import javax.swing.JOptionPane;

import fr.afcepf.al34.p1.MyAppP1;

public class Afficheur {
	
	private Preferences preferences;
	
	public Afficheur(MyAppP1 myAppP1) {
		this.preferences=myAppP1.getPreferences();
	}
	
	public void afficher(Object obj) {
		//System.out.println(obj.toString());
		JOptionPane.showMessageDialog(null, 
				this.preferences.getPrefixe()+obj.toString(), 
				this.preferences.getTitre(),
				JOptionPane.INFORMATION_MESSAGE);
	}

}
