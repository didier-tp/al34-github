package fr.afcepf.al34.demo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al34.demo.entity.Blague;

//@Component
@Repository //id par defaut = blagueDaoImpl
@Transactional
public class BlagueDaoImpl implements BlagueDao {
	
	//@Autowired
	//private DataSource dataSource; //utile pour dao codé avec JDBC
	
	@PersistenceContext
	private EntityManager entityManager;
	//entityManager créé par EntityManagerFactory utilisant dataSource en interne

	@Override
	public Blague findById(Long id) {
		// v1 : simulation sans base de données
		//String texte="texte de la blague " + dataSource.toString() ;
		//return new Blague(id ,"blague_" + id , texte);
		//v2 (jpa):
		return entityManager.find(Blague.class,id);
	}

	@Override
	public Blague save(Blague b) {
		if(b.getId()==null) {
			entityManager.persist(b);
		}else {
			entityManager.merge(b);
		}
		return b;
	}

}
