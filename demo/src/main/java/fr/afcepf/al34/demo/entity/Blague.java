package fr.afcepf.al34.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
public class Blague {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
