package fr.afcepf.al33.appX.delegate;

import java.util.List;

import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import fr.afcepf.al33.appX.dto.DeviseDto;

@Named //@Named de DI/CDI pour avoir un composant pris en charge par jboss
       //et injectable via @Inject dans un ManagedBean de JSF
public class DeviseServiceDelegate implements IDeviseService{
	
	private Client jaxrs2client = ClientBuilder.newClient();
	private String baseUrl="http://localhost:8383/springBootWs/devise-api/public/devise";

	@Override
	public DeviseDto getDeviseByCode(String code) {
		WebTarget deviseTarget = jaxrs2client.target(baseUrl).path(code);
		return deviseTarget.request(MediaType.APPLICATION_JSON_TYPE)
		            .get().readEntity(DeviseDto.class);
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
