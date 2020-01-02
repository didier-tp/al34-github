package fr.afcepf.al34.serveur;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebService;

import fr.afcepf.al34.dto.ResCalculTva;
import fr.afcepf.al34.itf.ICalculTva;

//Surveiller les messages de la console Jboss pour connaître les noms
//des EJB "@Remote" enregistrés dans la partie "noms logiques JNDI" de JBOSS
//et aussi pour connaître l'URL de la description WSDL du WS SOAP
//à tester via soap-ui .

@Stateless
@Remote //pour access rmi , ici ou bien sur l'interface
@WebService(endpointInterface = "fr.afcepf.al34.itf.ICalculTva") //pour access soap
//@Remote peut cohabiter avec @WebService
public class CalculTvaImpl  implements ICalculTva {

	protected CalculTvaImpl() {
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
