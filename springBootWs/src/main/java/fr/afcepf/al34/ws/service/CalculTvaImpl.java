package fr.afcepf.al34.ws.service;

import javax.jws.WebService;

import org.springframework.stereotype.Service;

import fr.afcepf.al34.ws.dto.ResCalculTva;

@Service //ou bien @Component de Spring
//@Transactional
@WebService(endpointInterface = "fr.afcepf.al34.ws.service.ICalculTva") //pour access soap
public class CalculTvaImpl  implements ICalculTva {

	public CalculTvaImpl() {
	}

	public double tva(double ht, double tauxTva) {
		return ht * tauxTva/100;
	}

	public double ttc(double ht, double tauxTva)  {
		return ht * (1 + tauxTva/100);
	}

	public String getAuteur()  {
		return "didier / formateur fou";
	}

	public ResCalculTva tvaEtTtc(double ht, double tauxTva)  {
		double tva  = this.tva(ht, tauxTva);
		return new ResCalculTva(tva,ht + tva);
	}

}
