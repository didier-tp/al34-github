package fr.afcepf.al34.demo.business;

import fr.afcepf.al34.demo.dao.BlagueDao;
import fr.afcepf.al34.demo.entity.Blague;
import lombok.Setter;

@Setter
public class BlagueServiceImpl implements BlagueService {
	
	private BlagueDao blagueDao; //avec setter obligatoire pour config xml/java

	@Override
	public Blague rechercherBlagueParId(Long id) {
		return blagueDao.findById(id);
	}

}
