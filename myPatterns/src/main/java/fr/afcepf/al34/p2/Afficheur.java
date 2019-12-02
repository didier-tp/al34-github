package fr.afcepf.al34.p2;

import javax.swing.JOptionPane;

public class Afficheur {
	
	public void afficher(Object obj) {
		//System.out.println(obj.toString());
		JOptionPane.showMessageDialog(null, obj.toString(), "titre qui va bien",
				JOptionPane.INFORMATION_MESSAGE);
	}

}
