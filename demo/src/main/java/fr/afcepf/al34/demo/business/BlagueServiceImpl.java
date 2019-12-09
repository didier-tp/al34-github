package fr.afcepf.al34.demo.business;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afcepf.al34.demo.dao.BlagueDao;
import fr.afcepf.al34.demo.entity.Blague;
import lombok.Setter;

@Setter
//@Component
@Service //id par defaut = blagueServiceImpl
public class BlagueServiceImpl implements BlagueService {
	
	@Autowired //demander à injecter/référencer un composant Spring
	           //compatible avec l'interface BlagueDao
	private BlagueDao blagueDao; //avec setter obligatoire pour config xml/java

	public BlagueServiceImpl() {
		System.out.println("dans le constructeur de BlagueServiceImpl , blagueDao="+blagueDao);
	}
	
	@PostConstruct
	public void initAfterAllInjections() {
		System.out.println("dans méthode préfixée par @PostConstruct, blagueDao="+blagueDao);
	}
	
	
	@Override
	public Blague rechercherBlagueParId(Long id) {
		return blagueDao.findById(id);
	}

}
