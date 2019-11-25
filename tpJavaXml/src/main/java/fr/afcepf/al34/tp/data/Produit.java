package fr.afcepf.al34.tp.data;

public class Produit {
	private String ref;
	private String label;
	private Double prix;
	
	public Produit() {
		super();
	}
	
	public Produit(String ref, String label, Double prix) {
		super();
		this.ref = ref;
		this.label = label;
		this.prix = prix;
	}
	
	@Override
	public String toString() {
		return "Produit [ref=" + ref + ", label=" + label + ", prix=" + prix + "]";
	}
	
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	
	
}
