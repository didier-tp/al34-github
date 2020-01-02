package fr.afcepf.al34.client;



import fr.afcepf.al34.dto.ResCalculTva;
import fr.afcepf.al34.itf.ICalculTva;

public class EjbClientApp {

	public static void main(String[] args) {
		try {
			String machineServeur = "localhost"; //ou "192.168.xx.yy"
			//192.168.102.183 ,  102.38 , ....
			
			String nomLogiqueEjbCalculateur= "....";
			//connection à l'objet distant RMI via son nom logique
			ICalculTva proxyCalculateurTva = null;
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
