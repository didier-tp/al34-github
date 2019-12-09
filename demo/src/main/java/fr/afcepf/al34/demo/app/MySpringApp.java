package fr.afcepf.al34.demo.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.afcepf.al34.demo.business.BlagueService;
import fr.afcepf.al34.demo.entity.Blague;

public class MySpringApp {

	public static void main(String[] args) {
		// Exemple de démarrage d'une application 
		//en mode "pas automatique , sans spring-boot":
		
		//V1 : entièrement XML (environ 2005)
		//V2 : config xml + annotations (environ 2010)
		ApplicationContext contextSpring =
				new ClassPathXmlApplicationContext("mySpringConf.xml");
		//BlagueService s = (BlagueService) 
		//		 contextSpring.getBean("blagueServiceImpl" /*id*/);
		BlagueService s = contextSpring.getBean(BlagueService.class);
		Blague b = s.rechercherBlagueParId(1L);
		System.out.println(b.toString());
		((ClassPathXmlApplicationContext)contextSpring).close();
		
		
		//V3 : config java + annotations (environ 2015)
		
		//V4 : --> démarrage via Spring-boot et demo.DemoApplication

	}

}
