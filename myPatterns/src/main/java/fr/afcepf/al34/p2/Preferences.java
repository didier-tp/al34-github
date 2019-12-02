package fr.afcepf.al34.p2;

public class Preferences {
	private String titre;
	private String prefixe;
	
	public Preferences(String titre, String prefixe) {
		super();
		this.titre = titre;
		this.prefixe = prefixe;
	}
	
	public Preferences() {
		this("titre inconnu", ">> ");
	}
	
	
	public final String getTitre() {
		return titre;
	}
	public final void setTitre(String titre) {
		this.titre = titre;
	}
	public final String getPrefixe() {
		return prefixe;
	}
	public final void setPrefixe(String prefixe) {
		this.prefixe = prefixe;
	}
	
	
}
