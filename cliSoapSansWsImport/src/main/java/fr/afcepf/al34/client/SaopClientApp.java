package fr.afcepf.al34.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import fr.afcepf.al34.ws.service.ICalculTva;

public class SaopClientApp {

	public static void main(String[] args) {
		// appeler un WS Soap codé en java (dans le même langage)
		// on peut se passer de wsimport.

		QName SERVICE_NAME = new QName("http://service.ws.al34.afcepf.fr/", "CalculTvaImplService");
		QName PORT_NAME = new QName("http://service.ws.al34.afcepf.fr/", "CalculTvaImplPort");
		// en précisant une URL WSDL connue et accessible
		
		String wdlUrl =
		"http://localhost:8080/springBootWs/service/calculTva?wsdl";
		URL wsdlDocumentLocation=null;
		try {wsdlDocumentLocation = new URL(wdlUrl);
		} catch (MalformedURLException e) { e.printStackTrace();}
		
		//avec import javax.xml.ws.Service;
		Service service = Service.create(wsdlDocumentLocation, SERVICE_NAME);
		ICalculTva caculateurWSProxy = (ICalculTva)
		                service.getPort(PORT_NAME, ICalculTva.class);
		
		double resTva = caculateurWSProxy.ttc(200.0, 20.0);
		System.out.println("resTva="+resTva);
		System.out.println("auteur="+caculateurWSProxy.getAuteur());
	}

}
