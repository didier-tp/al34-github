package fr.afcepf.al34.demo.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.afcepf.al34.demo.entity.Blague;

//@Component
@Repository //id par defaut = blagueDaoImpl
public class BlagueDaoImpl implements BlagueDao {
	
	@Autowired
	private DataSource dataSource;

	@Override
	public Blague findById(Long id) {
		// v1 : simulation sans base de données
		String texte="texte de la blague " + dataSource.toString() ;
		return new Blague(id ,"blague_" + id , texte);
	}

}
