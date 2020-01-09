package fr.afcepf.al34.o.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import fr.afcepf.al34.o.dto.PropositionPret;

@RestController
@RequestMapping()
public class PropositionPretRestCtrl {
	
	//utilisation directe ou indirecte via BusinessDelagate
	private RestTemplate restTemplate = new RestTemplate();
	
	// GET url 
	@GetMapping(...)
	public PropositionPret getPropositionPret(double montant,int nbMois) {
		//...
	}

}
