package fr.afcepf.al34.cli.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import fr.afcepf.al34.cli.dto.DeviseDto;

@Service //composant spring de type "business service" (codé localement ou par déléguation)
public class DeviseServiceDelegate implements IDeviseService {
	
	private RestTemplate restTemplate = new RestTemplate();
	
	//private String baseUrl="http://localhost:8080/springBootWs/devise-api/public/devise";
	
	@Value("${devise-api.base-url}") //pour récupérer 
	// devise-api.base-url=http://localhost:8080/springBootWs/devise-api/public/devise
	// dans application.properties
	private String baseUrl;

	@Override
	public DeviseDto getDeviseByCode(String code) {
		String url= baseUrl + "/" + code;
		return restTemplate.getForObject(url, DeviseDto.class);
	}

	@Override
	public List<DeviseDto> getAllDevises() {
		DeviseDto[] tabDevise = null ;
		String url= baseUrl ;
		tabDevise =  restTemplate.getForObject(url, DeviseDto[].class);
		return Arrays.asList(tabDevise);
	}

	@Override
	public DeviseDto postDevise(DeviseDto devise) {
		String url= baseUrl ;
		return restTemplate.postForObject(url, devise, DeviseDto.class);
	}

	@Override
	public void deleteDevise(String code) {
		String url= baseUrl + "/" + code;
		restTemplate.delete(url);
	}

}
