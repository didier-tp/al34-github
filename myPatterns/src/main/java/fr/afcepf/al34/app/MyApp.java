package fr.afcepf.al34.app;

import fr.afcepf.al34.logger.GoodLogger;

public class MyApp {

	public static void main(String[] args) {
		System.out.println("myApp");
		GoodLogger goodLogger  = new GoodLogger();
		goodLogger.log("essai log");
	}

}
