package fr.afcepf.al34.tp.json;

import java.util.HashMap;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonObject;

//javax.json-api in pom.xml is a low level json api for java

public class LowLevelJsonUtil {

	public static void demoSimpleJsonJava() {
		System.out.println("demoSimpleJsonJava");
		
		JsonObject jsonSubObjectA = Json.createObjectBuilder()
		        .add("firstName", "olie")
		        .add("lastName", "Condor")
		        .build();
		
		JsonObject jsonSubObjectB = Json.createObjectBuilder()
		        .add("firstName", "alex")
		        .add("lastName", "Therieur")
		        .build();
		
		JsonObject jsonObject1 = Json.createObjectBuilder()
		        .add("firstName", "jean")
		        .add("lastName", "Bon")
		        .add("size", 180.0)
		        .add("mad", true)
		        .add("address", Json.createObjectBuilder()
		        					.add("street", "12, rue qui va bien")
		        					.add("city", "Paris")
		        	)
		        .add("phones",
	                      Json.createArrayBuilder()
	                          .add("0102030405")
	                          .add("0605040302"))
		        .add("friends",
	                      Json.createArrayBuilder()
	                          .add(jsonSubObjectA)
	                          .add(jsonSubObjectB))
		        .build();	
		
		System.out.println(jsonObject1.toString());
		
		//============================================
		
		Map<String,Object> submapAdr = new HashMap<>();
		submapAdr.put("street", "13, rue Elle");
		submapAdr.put("city", "Lyon");
		
		Map<String,Object> mapPers = new HashMap<>();
		mapPers.put("firstName", "alain");
		mapPers.put("lastName", "Therieur");
		mapPers.put("age", 40);
		mapPers.put("address", submapAdr);
		
		JsonObject jsonObject2FromMap= Json.createObjectBuilder(mapPers).build();
		System.out.println(jsonObject2FromMap.toString());
		
	}
	
}
