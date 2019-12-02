package fr.afcepf.al34.calculateur;

import java.text.MessageFormat;

import fr.afcepf.al34.annotations.MyInject;
import fr.afcepf.al34.factory.MegaFactoryAvecInjection;
import fr.afcepf.al34.logger.MyLogger;

public class CalculateurAvecLog extends CalculateurDecorateur /* implements Calculateur */ {
	
	@MyInject //@Inject ou @Autowired
	//@Inject ou notre version @MyInject 
	//va demander à initialiser la chose (ici myLogger) de façon
	//à ce que ça référence un composant compatible avec l'interface précisée
	//(ici MyLogger)
	private MyLogger myLogger=null;
	
	private String commentaireQuiVaBien="you know what , i am happy";
	
	//@MyInject
	//I2 ref2=null;
	
	public CalculateurAvecLog(){
		super(new CalculateurBasic());
		//myLogger = MegaFactory.getInstance().createLogger();
		//dans vrai projet Spring , EJB ou ...
		//pas besoin de faire l'appel ci-dessous , c'est fait automatiquement
		MegaFactoryAvecInjection.injectDependenciesInObject(this);
	}

	@Override
	public double addition(double a, double b) {
		double res=super.addition(a, b); //au lieu de a+b en direct
		myLogger.log(MessageFormat.format("addition({0},{1})={2}", a,b,res));
		return res;
	}

	@Override
	public double multiplication(double a, double b) {
		double res=super.multiplication(a, b);//a*b;
		myLogger.log(MessageFormat.format("multiplication({0},{1})={2}", a,b,res));
		return res;
	}

}
