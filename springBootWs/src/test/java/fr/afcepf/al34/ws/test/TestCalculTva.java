package fr.afcepf.al34.ws.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.afcepf.al34.ws.MySpringBootApplication;
import fr.afcepf.al34.ws.service.ICalculTva;


@RunWith(SpringRunner.class)
@SpringBootTest(classes= {MySpringBootApplication.class})
public class TestCalculTva {
	
	@Autowired
	private ICalculTva	calculTva; //à tester
	
	@Test
	public void testTva() {
		double resTva= calculTva.tva(200.0, 20.0);
		Assert.assertEquals(40, resTva,0.0001);
	}

}
