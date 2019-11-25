package fr.afcepf.al34.tp.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.afcepf.al34.tp.data.Produit;

//(com.fasterxml.)jackson.databind in pom.xml is a medium level json api for java

public class JacksonJsonUtil {

	public static void demoJsonJavaViaJacksonObjectMapper() {
		System.out.println("demoJsonJavaViaJacksonObjectMapper");
		try {
		ObjectMapper jacksonObjectMapper  = new ObjectMapper();
		jacksonObjectMapper.configure(
				DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			
		Produit p1 = new Produit("p1","gomme",2.3);
		System.out.println("p1:"+p1);//p1:Produit [ref=p1, label=gomme, prix=2.3]
		String p1AsJsonString = jacksonObjectMapper.writeValueAsString(p1);
		System.out.println("p1AsJsonString:"+p1AsJsonString);
		//p1AsJsonString:{"ref":"p1","label":"gomme","prix":2.3}
		
		
		String p2AsJsonString = "{'ref':'p2' , 'label':'cahier' , 'prix':3.3 }".replace('\'', '\"');
		System.out.println("p2AsJsonString:"+p2AsJsonString);
		//p2AsJsonString:{"ref":"p2" , "label":"cahier" , "prix":3.3 }
		Produit p2 = jacksonObjectMapper.readValue(p2AsJsonString,Produit.class);
		System.out.println("p2:"+p2);//p2:Produit [ref=p2, label=cahier, prix=3.3]	
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
}
