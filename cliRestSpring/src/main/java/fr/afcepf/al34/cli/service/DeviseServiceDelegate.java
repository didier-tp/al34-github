package fr.afcepf.al34.cli.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import fr.afcepf.al34.cli.dto.DeviseDto;

@Service //composant spring de type "business service" (codé localement ou par déléguation)
public class DeviseServiceDelegate implements IDeviseService {
	
	private RestTemplate restTemplate = new RestTemplate();
	private String baseUrl="http://localhost:8080/springBootWs/devise-api/public/devise";

	@Override
	public DeviseDto getDeviseByCode(String code) {
		String url= baseUrl + "/" + code;
		return restTemplate.getForObject(url, DeviseDto.class);
	}

	@Override
	public List<DeviseDto> getAllDevises() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeviseDto postDevise(DeviseDto devise) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteDevise(String code) {
		// TODO Auto-generated method stub

	}

}
