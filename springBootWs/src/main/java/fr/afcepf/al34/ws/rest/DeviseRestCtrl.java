package fr.afcepf.al34.ws.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.afcepf.al34.ws.entity.Devise;
import fr.afcepf.al34.ws.service.DeviseService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping(value="/devise-api/public/devise" , headers="Accept=application/json")
@Api(tags = { "My REST Devise api (public part)" })
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
	/*
	// Version techniquement correcte (au sens HTTP) MAIS SANS IDEMPOTENCE 
	//en mode DELETE, url=http://localhost:8080/springBootWs/devise-api/public/devise/JPY
	@DeleteMapping(value="/{codeDevise}")
	public void deleteDeviseByCode(@PathVariable("codeDevise")  String code)
	     throws MyEntityNotFoundException{
		     deviseService.supprimerDevise(code); //renvoi code 404 en cas d'erreur
		     //car annotation @ResponseStatus(HttpStatus.NOT_FOUND) au dessus de 
		     //la classe MyEntityNotFoundException
	}*/
	
	
	/*
	//en mode DELETE, url=http://localhost:8080/springBootWs/devise-api/public/devise/JPY
	//à tester via PostMan ou un équivalent
	@DeleteMapping(value="/{codeDevise}")
	public ResponseEntity<?> deleteDeviseByCode(@PathVariable("codeDevise")  String code){
		try {
			deviseService.supprimerDevise(code);
			return new ResponseEntity<String>("suppression bien effectuee" , HttpStatus.OK); //suppression bien effectuée
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);//pas trouvé ce qu'il fallait supprimer
			//return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); //erreur quelconque
		}
	}
	*/
	
	// version avec IDEMPOTENCE (retour toujours au même format)
	//en mode DELETE, url=http://localhost:8080/springBootWs/devise-api/public/devise/JPY
	//à tester via PostMan ou un équivalent
	@DeleteMapping(value="/{codeDevise}")
	public ResponseEntity<String> deleteDeviseByCode(@PathVariable("codeDevise")  String code){
			try {
				deviseService.supprimerDevise(code);
				return new ResponseEntity<String>("suppression bien effectuee" , 
						                           HttpStatus.OK); 
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<String>("devise déjà supprimée ou inexistante",
						                    HttpStatus.OK);
				
			}
		}

}
