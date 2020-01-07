package fr.afcepf.al34.cli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;


//NB: @SpringBootApplication est un équivalent
//de @Configuration + @EnableAutoConfiguration + @ComponentScan/current package
@SpringBootApplication
//NB: via le @EnableAutoConfiguration, application.properties sera analysé
//NB: cette classe doit être dans ws pour que le @ComponentScan automatique
// scrute tous les sous packages ws.dao, ws.service , ...
public class MySpringBootApplication extends SpringBootServletInitializer {
public static void main(String[] args) {
	//SpringApplication.run(MySpringBootApplication.class, args);
	SpringApplication app = new SpringApplication(MySpringBootApplication.class);
	//app.setAdditionalProfiles("initData","swagger");
	ConfigurableApplicationContext context = app.run(args);
	System.out.println("http://localhost:8282/cliRestSpring");
}
}