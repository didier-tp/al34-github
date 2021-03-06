package fr.afcepf.al34.client;

import java.net.MalformedURLException;
import java.net.URL;

import fr.afcepf.al34.dto.ResCalculTva;
import fr.afcepf.al34.serveur.CalculTvaImplService;
import fr.afcepf.al34.serveur.ICalculTva;

public class CliSoapApp {

	//ce code s'appuie sur le code généré via wsimport ... ?wsdl
	public static void main(String[] args)  {
		try {
			//ipconfig -->  192.168.102.183 ou 192.168.102.62 ou ..
			//NB: le serveur Jboss accepte des requêtes autres que localhost
			//si l'option -b 0.0.0.0 précisée au lancement du serveur (depuis eclipse ou pas)
			//URL wsdlUrl = new URL("http://192.168.102.62:8080/servEjb/CalculTvaImpl?wsdl");
			URL wsdlUrl = new URL("http://localhost:8080/servEjb/CalculTvaImpl?wsdl");
			ICalculTva proxyWSTva = (new CalculTvaImplService(wsdlUrl)).getCalculTvaImplPort();
			System.out.println("auteur="+proxyWSTva.getAuteur());
			ResCalculTva res= proxyWSTva.tvaEtTtc(200.0, 20.0);
			System.out.println("tva=" + res.getTva());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
