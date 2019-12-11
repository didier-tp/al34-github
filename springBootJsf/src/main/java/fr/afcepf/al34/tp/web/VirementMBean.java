package fr.afcepf.al34.tp.web;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import fr.afcepf.al34.tp.entity.Compte;
import fr.afcepf.al34.tp.service.CompteService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ManagedBean
@RequestScoped
@Getter @Setter @NoArgsConstructor
public class VirementMBean {
	
	private Long numCptDeb;
	private Long numCptCred;
	private Double montant;
	
	@Inject //ou @Autowired
	private CompteService compteService;
	
	
	@PostConstruct
	public void init() {
		
	}
	
	public String doVirement() {
		//...
		return "comptes.xhtml"; //naviguer vers liste des comptes à jour
	}
}
