package tp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tp.entity.Film;

@Repository
@Transactional //de Spring
public class FilmDaoJpa implements FilmDao {
	
	@PersistenceContext //pour demander une initialisation aux EJB ou a Spring
	private EntityManager entityManager;

	@Override
	public Film save(Film f) {
		if(f.getId()==null) {
		   entityManager.persist(f); //insert into et f.id est auto_incrementé
		}
		else {
		   entityManager.merge(f); //update sql
		  }
		return f;
	}
	
	@Override
	public Film findById(Long id) {
		return entityManager.find(Film.class, id);
	}

	@Override
	public void deleteById(Long id) {
		Film f =entityManager.find(Film.class, id);
		entityManager.remove(f);
	}

	@Override
	public List<Film> findAll() {
		//Session sessionHibernate = (Session) entityManager.getDelegate();
		//+ eventuelles instructions utilisant les spécificités de Session hibernate
		//pour les cas pointus seulement
		return entityManager.createNamedQuery("Film.findAll", Film.class)
				            .getResultList();
		
 	}

	

	@Override
	public List<Film> findByTitre(String titre) {
		return entityManager.createNamedQuery("Film.findByTitre", Film.class)
				.setParameter("titre", titre) //pour remplacer :titre dans requete
	            .getResultList();
	}

}
