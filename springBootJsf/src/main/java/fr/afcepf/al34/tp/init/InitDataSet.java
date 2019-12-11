package fr.afcepf.al34.tp.init;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import fr.afcepf.al34.tp.entity.Compte;
import fr.afcepf.al34.tp.service.CompteService;



@Profile("initData") //code ci-dessus activé que si le profile "initData" est choisi (parmis d'autres)
                     //au démarrage d'un test ou de l'application
@Component
//@Scope("singleton") par defaut
public class InitDataSet {
	
	@Autowired
	CompteService compteService;
	
	@PostConstruct
	public void initJeuxDeDonneesQueJaime() {
		compteService.sauvegarderCompte(new Compte(null,"compte A", 234.0));
		compteService.sauvegarderCompte(new Compte(null,"compte B", 567.0));
	}

}
