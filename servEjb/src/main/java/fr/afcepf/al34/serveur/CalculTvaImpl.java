package fr.afcepf.al34.serveur;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.al34.dto.ResCalculTva;
import fr.afcepf.al34.itf.ICalculTva;

//Surveiller les messages de la console Jboss pour connaître les noms
//des EJB "@Remote" enregistrés dans la partie "noms logiques JNDI" de JBOSS

@Stateless
@Remote //ici ou bien sur l'interface
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
