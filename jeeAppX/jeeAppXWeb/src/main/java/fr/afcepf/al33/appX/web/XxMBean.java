package fr.afcepf.al33.appX.web;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;

import fr.afcepf.al33.appX.delegate.DeviseServiceDelegate;
import fr.afcepf.al33.appX.delegate.IDeviseService;
import fr.afcepf.al33.appX.dto.DeviseDto;
import fr.afcepf.al33.appX.service.ServiceXx;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ManagedBean
@SessionScoped
@Getter @Setter @NoArgsConstructor
public class XxMBean {
	
	private Double montantEuro=15.0;
	private Double montantFranc;
	
	private Double montantSource=100.0;
	private Double montantCible;
	private String codeMonnaieSource="EUR";
	private String codeMonnaieCible="USD";

	@EJB
	private ServiceXx serviceXx;
	
	@Inject
	private IDeviseService deviseServiceDelegate;
	/*
	//NB: @Inject ne fonctionne que si WEB-INF/beans.xml est présent
	@Inject //pour etablir un lien avec le composant avec @Named
	private Convertisseur convertisseur;
	
	//private Convertisseur convertisseur = MyConvRestDelegate.getInstance();
	//private Convertisseur convertisseur = MyConvSoapDelegate.getInstance();
	*/
	public String doEuroToFranc() {
		this.montantFranc = serviceXx.euroToFranc(this.montantEuro);
		test_temporaire_appel_ws_rest();
		return null;
	}
	
	private void test_temporaire_appel_ws_rest() {
		//DeviseServiceDelegate deviseServiceDelegate = new DeviseServiceDelegate();
		DeviseDto deviseDto = deviseServiceDelegate.getDeviseByCode("USD");
		System.out.println("deviseDto="+deviseDto);
	}
	/*
	public String doConversion() {
		this.montantCible = convertisseur.convertir(this.montantSource,
				         codeMonnaieSource, codeMonnaieCible);
		return null;
	}
	*/
	public void onSomethingChange(ValueChangeEvent event)
	{
	if(this.montantFranc!=null)
		this.montantFranc=this.montantFranc+1;
	System.out.println("onSomethingChange");
	}
	
}
