package fr.afcepf.al34.client;



import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import fr.afcepf.al34.dto.ResCalculTva;
import fr.afcepf.al34.itf.ICalculTva;

public class EjbClientApp {

	public static void main(String[] args) {
		try {
			String machineServeur = "localhost"; //ou "192.168.xx.yy"
			//192.168.102.183 ,  102.38 , ....
			
			Properties props = new Properties();//java.util
			//Context et InitialContext de javax.naming (JNDI)
			
			props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			
			
			props.put(Context.INITIAL_CONTEXT_FACTORY,/*WildFlyInitialContextFactory.class.getName()*/
		    			/*"org.jboss.naming.remote.client.InitialContextFactory"*/
					    "org.wildfly.naming.client.WildFlyInitialContextFactory");
			props.put(Context.PROVIDER_URL, "remote+http://localhost:8080");
					// remote://localhost:4447 for Jboss7.1 , http-remoting://localhost:8080 for wildfly 8,9
			props.put(Context.SECURITY_PRINCIPAL, "guest"); // username : "admin" , "guest" , "..."
			props.put(Context.SECURITY_CREDENTIALS, "guest007"); //password : "pwd", "guest007"
					//avec utilisateur ajouté via la commande JBOSS_7_HOME/bin/add-user
					//et roles associés admin,guest,.... sur partie "ApplicationRealm" .
			props.put("jboss.naming.client.ejb.context", true); //indispensable pour accès @Remote
			Context jndiContext = new InitialContext(props);
			
			//NB: ce nom logique (respectant la norme JEE6) s'affiche dans la console jboss
			//lors du démarrage du projet servEjb
			String nomLogiqueEjbCalculateur= "servEjb/CalculTvaImpl!fr.afcepf.al34.itf.ICalculTva";
			//ne pas utiliser le préfixe "ejb:" avec cette version/configuration (de Jboss, du client , ...) 
			//connection à l'objet distant RMI via son nom logique
			ICalculTva proxyCalculateurTva = (ICalculTva) jndiContext.lookup(nomLogiqueEjbCalculateur);
			//appels de méthodes à distance (via le réseau):
			double tva= proxyCalculateurTva.tva(200.0, 20.0);
			String auteur = proxyCalculateurTva.getAuteur();
			ResCalculTva resCalculTva = proxyCalculateurTva.tvaEtTtc(200.0, 20.0);
			System.out.println("ttc="+resCalculTva.getTtc());
			System.out.println("tva="+tva);
			System.out.println("auteur="+auteur);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
