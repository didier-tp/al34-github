package fr.afcepf.al34.tp;

import fr.afcepf.al34.tp.json.JacksonJsonUtil;
import fr.afcepf.al34.tp.json.LowLevelJsonUtil;

public class MyApp {

	public static void main(String[] args) {
		LowLevelJsonUtil.demoSimpleJsonJava();
		JacksonJsonUtil.demoJsonJavaViaJacksonObjectMapper();

	}

}
