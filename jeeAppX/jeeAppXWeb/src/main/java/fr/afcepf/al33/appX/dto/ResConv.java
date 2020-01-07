package fr.afcepf.al33.appX.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class ResConv {

	private Double montantFranc;
	private Double montantEuro;
	
	public ResConv(Double montantFranc, Double montantEuro) {
		super();
		this.montantFranc = montantFranc;
		this.montantEuro = montantEuro;
	}
	
	

}
