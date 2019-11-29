package fr.afcepf.al34.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.afcepf.al34.calculateur.Calculateur;
import fr.afcepf.al34.logger.MyLogger;
import fr.afcepf.al34.util.MyPropertiesUtil;

public class MegaFactory {
	
private static Logger logger = LoggerFactory.getLogger(MegaFactory.class);
	
	private static MegaFactory uniqueInstance = null;
	
	String calculateurImplClassName;
	String myloggerImplClassName ;
	
	public synchronized static MegaFactory getInstance()	{
		if(uniqueInstance==null){
			uniqueInstance=new MegaFactory();
			logger.debug("uniqueInstance=" + uniqueInstance.toString());
		}
		return uniqueInstance;
	}
	
	protected MegaFactory() {
		
	}
	
	public Calculateur createCalculateur() {
			Calculateur calculateur =null;
			if(calculateurImplClassName ==null) {
				calculateurImplClassName 
			       = MyPropertiesUtil.propertyValueFromEntryOfPropertyFile(
			    		   "megaFactory.properties","fr.afcepf.al34.calculateur.Calculateur");
			}
			try {
				calculateur = (Calculateur) Class.forName(calculateurImplClassName).newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			} 
			return calculateur;
	}
	
	public MyLogger createLogger() {
		MyLogger mylogger =null;
		if(myloggerImplClassName == null) {
			myloggerImplClassName = MyPropertiesUtil.propertyValueFromEntryOfPropertyFile(
					"megaFactory.properties","fr.afcepf.al34.logger.MyLogger");
		}
		try {
			mylogger = (MyLogger) Class.forName(myloggerImplClassName).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return mylogger;
	}
	
	//MegaFactory.getInstance().create(Calculateur.class);
	public <T> T create(Class<T> interfaceType) {
		T instance =null;
		String	implClassName = MyPropertiesUtil.propertyValueFromEntryOfPropertyFile(
					"megaFactory.properties",interfaceType.getName());
		try {
			instance = (T) Class.forName(implClassName).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return instance;
	}
	

}
