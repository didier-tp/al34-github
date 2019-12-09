package fr.afcepf.al34.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import fr.afcepf.al34.demo.business.BlagueService;
import fr.afcepf.al34.demo.entity.Blague;

//NB: @SpringBootApplication est un équivalent
//de @Configuration + @EnableAutoConfiguration + @ComponentScan/current package

@SpringBootApplication
//NB: tres important : Toutes les classes (de @Configuration ou bien @Service , @Component)
//qui doivent être prises en compte par Spring boot doivent être dans des sous packages de demo
//tout ce qui est à coté de démo doit être explicitement importé par @Import ou équivalent
public class DemoApplication {

	public static void main(String[] args) {
		/*Configurable*/ApplicationContext contextSpring =
				SpringApplication.run(DemoApplication.class, args);
		BlagueService s = contextSpring.getBean(BlagueService.class);
		Blague b = s.rechercherBlagueParId(1L);
		System.out.println(b.toString());
		//+close() idealement
	}

}
//la partie @EnableAutoConfiguration de @SpringBootApplication fait que le fichier
//application.properties sera automatiquement analysé
