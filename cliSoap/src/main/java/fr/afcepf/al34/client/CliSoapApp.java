package fr.afcepf.al34.client;

import fr.afcepf.al34.dto.ResCalculTva;
import fr.afcepf.al34.serveur.CalculTvaImplService;
import fr.afcepf.al34.serveur.ICalculTva;

public class CliSoapApp {

	public static void main(String[] args) {
		ICalculTva proxyWSTva = (new CalculTvaImplService()).getCalculTvaImplPort();
		System.out.println("auteur="+proxyWSTva.getAuteur());
		ResCalculTva res= proxyWSTva.tvaEtTtc(200.0, 20.0);
		System.out.println("tva=" + res.getTva());
	}

}
