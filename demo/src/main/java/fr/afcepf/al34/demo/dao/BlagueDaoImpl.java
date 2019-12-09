package fr.afcepf.al34.demo.dao;

import org.springframework.stereotype.Repository;

import fr.afcepf.al34.demo.entity.Blague;

//@Component
@Repository //id par defaut = blagueDaoImpl
public class BlagueDaoImpl implements BlagueDao {

	@Override
	public Blague findById(Long id) {
		// v1 : simulation sans base de données
		return new Blague(id ,"blague_" + id , "texte de la blague");
	}

}
