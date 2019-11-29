package fr.afcepf.al34.logger;

public class BadLogger implements MyLogger {
	
	public void log(String message) {
		System.out.println(">> Bad log >> " + message);
	}
}
