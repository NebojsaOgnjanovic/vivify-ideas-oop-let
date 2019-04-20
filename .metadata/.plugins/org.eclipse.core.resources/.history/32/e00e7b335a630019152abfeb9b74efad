package prtljag;

import ljudi.Putnik;

public class PrtljagFactory {
	
	public static Prtljag kreirajPrtljag(Putnik vlasnikPrtljaga, int tezinaPrtljaga) {
		if(tezinaPrtljaga <= 2) {
			return new RucniPrtljag(vlasnikPrtljaga, tezinaPrtljaga);
		}
		else if(tezinaPrtljaga > 2 && tezinaPrtljaga <= 5) {
			return new PredatiPrtljag(vlasnikPrtljaga, tezinaPrtljaga);
		}
		return null;
	}
	
}

