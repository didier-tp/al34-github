package fr.afcepf.al34.cli.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString()
public class DeviseDto {
	private String code; // "EUR" , "USD" , "JPY" , "GBP"
	private String name; // "euro" , "dollar" , "yen" , "livre"
	private Double change;
	
	public DeviseDto(String code, String name, Double change) {
		super();
		this.code = code;
		this.name = name;
		this.change = change;
	}
	
	
}
