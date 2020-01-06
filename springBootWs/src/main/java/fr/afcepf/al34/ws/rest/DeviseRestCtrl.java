package fr.afcepf.al34.ws.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.afcepf.al34.ws.entity.Devise;
import fr.afcepf.al34.ws.service.DeviseService;

@RestController
@RequestMapping(value="/devise-api/public/devise" , headers="Accept=application/json")
public class DeviseRestCtrl {
	
	@Autowired
	private DeviseService deviseService;
	
	//url complete : http://localhost:8080/springBootWs/devise-api/public/devise/EUR
	//@RequestMapping(value="/{codeDevise}" , method=RequestMethod.GET)
	@GetMapping(value="/{codeDevise}")
	public Devise getDeviseByCode(@PathVariable("codeDevise")  String code){
		return deviseService.rechercherDeviseParCode(code);
	}
	//url complete : http://localhost:8080/springBootWs/devise-api/public/devise
	//http://localhost:8080/springBootWs/devise-api/public/devise?changeMini=0.95
	@GetMapping(value="")
	public List<Devise> getDevisesByCriteria(
			@RequestParam(value="changeMini",required=false) Double changeMini){
		if(changeMini!=null)
			return deviseService.rechercherDeviseParChangeMini(changeMini);
		else
			return deviseService.rechercherToutesDevises();
	}
	//http://localhost:8080/springBootWs/devise-api/public/devise appelé en mode POST
	//avec { "code" : "SIN" , "name":"monnaieSinge" , "change" :9999 }
	//dans la partie "body" (invisible) de la requête entrante HTTP
	//à tester via le logiciel PostMan ou un equivalent
	@PostMapping(value="")
	public Devise postDevise(@RequestBody Devise devise) {
		return deviseService.sauvegarderDevise(devise);
	}

}
