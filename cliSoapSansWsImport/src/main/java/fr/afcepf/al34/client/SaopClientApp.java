package fr.afcepf.al34.client;

import fr.afcepf.al34.ws.service.ICalculTva;

public class SaopClientApp {

	public static void main(String[] args) {
		
		ICalculTva calculateurTva = new CalculTvaDeleguate();
		
		double resTva = calculateurTva.ttc(200.0, 20.0);
		System.out.println("resTva="+resTva);
		System.out.println("Auteur="+calculateurTva.getAuteur());
	}

}
