package fr.afcepf.al34.factory;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.afcepf.al34.annotations.MyInject;

public class MegaFactoryAvecInjection extends MegaFactory {
	
	static Logger logger = LoggerFactory.getLogger(MegaFactoryAvecInjection.class);
	
	
	public MegaFactoryAvecInjection(){
		super();
	}
	
	public static void injectDependenciesInObject(Object obj) {
		Class metaClasse=obj.getClass();
		logger.trace("injection au sein de " + metaClasse.getName());
		for(Field f : metaClasse.getDeclaredFields()) {
			logger.trace("\t attribut=" + f.getName() + " de type " + f.getType().getSimpleName());
			MyInject annotMyInject = f.getAnnotation(MyInject.class);
			if(annotMyInject!=null) {
				Class typeDeF = f.getType();
				Object instance = MegaFactory.getInstance().create(typeDeF);
				//plus qu'a affecter instance en tant que nouvelle valeur de f
				//problème à régler : f est souvent "private"
				f.setAccessible(true);
				try {
					f.set(obj, instance);
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		}
	}
}
