package fr.afcepf.al34.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Blague {
	private Long id;
	private String titre;
	private String texte;
	
	@Override
	public String toString() {
		return "Blague [id=" + id + ", titre=" + titre + ", texte=" + texte + "]";
	}

	public Blague(Long id, String titre, String texte) {
		super();
		this.id = id;
		this.titre = titre;
		this.texte = texte;
	}
	

}
