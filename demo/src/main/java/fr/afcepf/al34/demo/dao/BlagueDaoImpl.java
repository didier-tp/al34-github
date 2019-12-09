package fr.afcepf.al34.demo.dao;

import fr.afcepf.al34.demo.entity.Blague;

public class BlagueDaoImpl implements BlagueDao {

	@Override
	public Blague findById(Long id) {
		// v1 : simulation sans base de données
		return new Blague(id ,"blague_" + id , "texte de la blague");
	}

}
