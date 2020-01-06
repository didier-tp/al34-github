package fr.afcepf.al34.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al34.ws.dao.DeviseDao;
import fr.afcepf.al34.ws.entity.Devise;

@Service
@Transactional
public class DeviseServiceImpl implements DeviseService {
	
	@Autowired
	private DeviseDao deviseDao;

	@Override
	public Devise rechercherDeviseParCode(String code) {
		return deviseDao.findById(code).orElse(null);
	}
	@Override
	public List<Devise> rechercherDeviseParChangeMini(Double change) {
		return deviseDao.findByChangeGreaterThanEqual(change);
	}
	@Override
	public Devise sauvegarderDevise(Devise d) {
		return deviseDao.save(d);
	}
	@Override
	public void supprimerDevise(String code) {
		deviseDao.deleteById(code);
	}

}