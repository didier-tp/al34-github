package fr.afcepf.al33.appX.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import fr.afcepf.al33.appX.dto.ResConv;
import fr.afcepf.al33.appX.service.ServiceXx;

@Path("conv-api/conversion")
@Produces("application/json")
public class ConversionRestCrtl {

	@Inject //un peu comme @Ejb ou Autowired
	private ServiceXx ejbServiceXx ;

	//GET http://localhost:8080/jeeAppXWeb/rest/conv-api/conversion?enEuro=15
	@GET
	@Path("")
	public ResConv getResConversion(@QueryParam("enEuro") Double montantEuro) {
		Double resEnFranc = ejbServiceXx.euroToFranc(montantEuro);
		return new ResConv(resEnFranc,montantEuro);
	}

}
