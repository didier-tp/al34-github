package fr.afcepf.al34.o.rest;

import java.text.MessageFormat;
import java.util.Locale;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import fr.afcepf.al34.o.dto.PropositionPret;
import fr.afcepf.al34.o.dto.ResCalculMensualite;
import fr.afcepf.al34.o.dto.ResFraisDossier;
import fr.afcepf.al34.o.dto.ResTauxInteretCourant;

@RestController
@RequestMapping(value="/pret-api/public/propositionPret" , headers="Accept=application/json")
public class PropositionPretRestCtrl {
	
	private String apiBanqueBaseUrl ="http://localhost:8686/api-banque";
	private String apiEmpruntBaseUrl ="http://localhost:8585/api-emprunt";
	
	//utilisation directe ou indirecte via BusinessDelagate
	private RestTemplate restTemplate = new RestTemplate();
	
	private Double recupererTauxInteretCourant(int nbMois){
		//http://localhost:8686/api-banque/tauxInteretCourant?nbMois=120
		String url= new MessageFormat("{0}/tauxInteretCourant?nbMois={1}",Locale.ENGLISH)
				  .format(apiBanqueBaseUrl ,nbMois);
		System.out.println(url);
		ResTauxInteretCourant resTauxInteretCourant= restTemplate.getForObject(url, ResTauxInteretCourant.class);
		return resTauxInteretCourant.getTauxAnnuelPct();
	}
	
	private Double recupererFraisDossier(double  montant){
		//http://localhost:8686/api-banque/fraisDossier?montant=28900
		String url= new MessageFormat("{0}/fraisDossier?montant={1}",Locale.ENGLISH)
						.format(apiBanqueBaseUrl ,montant);
		System.out.println(url);
		ResFraisDossier resFraisDossier= restTemplate.getForObject(url, ResFraisDossier.class);
		return resFraisDossier.getFraisDossier();
	}
	
	//http://localhost:8585/api-emprunt/mensualite?montant=2000&nbMois=120&tauxAnnuelPct=1
	private Double recupererMensualite(double  montant,int nbMois,double tauxAnnuelPct){
		String url= new MessageFormat("{0}/mensualite?montant={1}&nbMois={2}&tauxAnnuelPct={3}",Locale.ENGLISH)
				    .format( apiEmpruntBaseUrl ,montant,nbMois,tauxAnnuelPct);
		System.out.println(url);
		ResCalculMensualite resCalculMensualite= restTemplate.getForObject(url, ResCalculMensualite.class);
		return resCalculMensualite.getMensualite();
	}
	
	// GET http://localhost:8787/orchestrationJava/pret-api/public/propositionPret?montant=2000&nbMois=120
	@GetMapping("")
	public PropositionPret getPropositionPret(
			@RequestParam(value="montant",required=true) double montant,
			@RequestParam(value="nbMois",required=true) int nbMois) {
		
		//orchestration de services:
		double tauxInteretAnnuelPct = this.recupererTauxInteretCourant(nbMois);//donnée pivot
		double mensualite = this.recupererMensualite(montant, nbMois, 
                /*donnée pivot*/tauxInteretAnnuelPct);
		//+quelfois if(promo) , frais de dossier offert
		double fraisDossier= this.recupererFraisDossier(montant);
		
		//construction et retour de la proposition de pret :
		PropositionPret propositionPret = new PropositionPret();
		propositionPret.setMontant(montant);
		propositionPret.setNbMois(nbMois);
		propositionPret.setTauxInteretAnnuelPct(tauxInteretAnnuelPct);
		propositionPret.setMensualite(mensualite);
		propositionPret.setFraisDossier(fraisDossier);
		return propositionPret;
	}

}
