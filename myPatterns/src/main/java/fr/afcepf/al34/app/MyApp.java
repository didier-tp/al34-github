package fr.afcepf.al34.app;

import fr.afcepf.al34.calculateur.Calculateur;
import fr.afcepf.al34.factory.MegaFactory;
import fr.afcepf.al34.logger.MyLogger;

public class MyApp {

	public static void main(String[] args) {
		
		System.out.println("myApp");
		MyLogger myLogger  = MegaFactory.getInstance().create(MyLogger.class);
		myLogger.log("essai log");
		
		//Calculateur calculateur = MegaFactory.getInstance().createCalculateur();
		Calculateur calculateur = MegaFactory.getInstance().create(Calculateur.class);
		double resAdd=calculateur.addition(5, 6);
		System.out.println("resAdd="+resAdd);
		double resMult=calculateur.multiplication(5, 6);
		System.out.println("resMult="+resMult);
	}

}
