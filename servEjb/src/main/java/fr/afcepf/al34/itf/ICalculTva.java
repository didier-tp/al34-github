package fr.afcepf.al34.itf;

import javax.jws.WebParam;
import javax.jws.WebService;

import fr.afcepf.al34.dto.ResCalculTva;

//@Remote //ici ou bien sur classe d'implémentation pour accès distant via rmi
@WebService //pour vision externe sous forme de web service Soap
public interface ICalculTva  {
	double tva(@WebParam(name="ht")double ht,
			   @WebParam(name="tauxTva") double tauxTva) ;
	double ttc(@WebParam(name="ht")double ht,
			   @WebParam(name="tauxTva") double tauxTva);
	ResCalculTva tvaEtTtc(@WebParam(name="ht")double ht,
			              @WebParam(name="tauxTva") double tauxTva);
	String getAuteur() ;
}
