package tp.test;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import tp.MySpringBootApplication;
import tp.dao.FilmDao;
import tp.entity.Film;


@RunWith(SpringRunner.class)
@SpringBootTest(classes= {MySpringBootApplication.class})
@ActiveProfiles("h2")
public class TestDaoFilm {
	
	@Autowired //equivalent spring de @Inject
	private /*interface*/FilmDao filmDao; //à tester
	
	@Test
	public void test1() {
		Film fa = new Film(null,"titre_a",new Date());
		filmDao.save(fa);
		System.out.println("id du film sauvegardé:" + fa.getId());
		
		Film fb = new Film(null,"titre_b",new Date());
		filmDao.save(fb);
		
		List<Film> listeFilms= filmDao.findAll();
		System.out.println("listeFilms="+listeFilms) ;
		Assert.assertTrue(listeFilms.size()>=2);
	}

}
