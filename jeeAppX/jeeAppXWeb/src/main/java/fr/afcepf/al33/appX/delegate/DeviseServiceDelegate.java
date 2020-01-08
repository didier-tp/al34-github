package fr.afcepf.al33.appX.delegate;

import java.util.Arrays;
import java.util.List;

import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
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
		try {
			WebTarget deviseTarget = jaxrs2client.target(baseUrl).path(code);
			return deviseTarget.request(MediaType.APPLICATION_JSON_TYPE)
			            .get().readEntity(DeviseDto.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<DeviseDto> getAllDevises() {
		WebTarget deviseTarget = jaxrs2client.target(baseUrl);
		return Arrays.asList(deviseTarget.request(MediaType.APPLICATION_JSON_TYPE)
		            .get().readEntity(DeviseDto[].class));
	}

	@Override
	public DeviseDto postDevise(DeviseDto devise) {
		WebTarget deviseTarget = jaxrs2client.target(baseUrl);
		return deviseTarget.request(MediaType.APPLICATION_JSON_TYPE)
		            .post(Entity.entity(devise, MediaType.APPLICATION_JSON_TYPE))
		            .readEntity(DeviseDto.class);
	}

	@Override
	public void deleteDevise(String code) {
		WebTarget deviseTarget = jaxrs2client.target(baseUrl).path(code);
		deviseTarget.request().delete();
	}

}
