package fr.afcepf.al34.itf;

import javax.ejb.Remote;

import fr.afcepf.al34.dto.ResCalculTva;

//@Remote //ici ou bien sur classe d'implémentation
public interface ICalculTva  {
	double tva(double ht, double tauxTva) ;
	double ttc(double ht, double tauxTva);
	ResCalculTva tvaEtTtc(double ht, double tauxTva);
	String getAuteur() ;
}
