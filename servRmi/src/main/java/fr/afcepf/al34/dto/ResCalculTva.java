package fr.afcepf.al34.dto;

import java.io.Serializable;

//objet de données véhiculé via RMI = doit absolument être Serializable
public class ResCalculTva implements Serializable{

	private static final long serialVersionUID = 1L;
	
		private double tva;
		private double ttc;
		
		public ResCalculTva() {
			super();
		}
		
		public ResCalculTva(double tva, double ttc) {
			super();
			this.tva = tva;
			this.ttc = ttc;
		}
		public final double getTva() {
			return tva;
		}
		public final void setTva(double tva) {
			this.tva = tva;
		}
		public final double getTtc() {
			return ttc;
		}
		public final void setTtc(double ttc) {
			this.ttc = ttc;
		}
		
		

}
