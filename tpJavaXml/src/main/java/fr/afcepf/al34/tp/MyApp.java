package fr.afcepf.al34.tp;

import fr.afcepf.al34.tp.data.Produit;
import fr.afcepf.al34.tp.json.JacksonJsonUtil;
import fr.afcepf.al34.tp.json.LowLevelJsonUtil;

public class MyApp {

	public static void main(String[] args) {
		LowLevelJsonUtil.demoSimpleJsonJava();
		JacksonJsonUtil.demoJsonJavaViaJacksonObjectMapper();
		/*
		//exemple en javascript (js):
		var jsonString = JSON.stringify(objetJs);
		var objJs= JSON.parse(jsonString);
		*/
		
		Produit p1 = new Produit("refP1" , "cahier" , 12.5);
		String p1AsJsonString = JacksonJsonUtil.stringify(p1);
		System.out.println(p1AsJsonString);
		
		//NB: chaine json volontairement sans prix et avec comment n'existant pas sur Produit.java :
		String p2AsJsonString = "{'ref':'p2' , 'label':'cahier' , 'comment': 'cc' }"
				                .replace('\'', '\"');
		Produit p2 = JacksonJsonUtil.parse(p2AsJsonString,Produit.class);
		System.out.println(p2.toString());
	}

}
