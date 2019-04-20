package simulacija;

import java.lang.reflect.Array;
import java.util.Random;

import exceptions.NemaLicencu;
import let.Let;
import ljudi.Pilot;
import ljudi.Putnik;
import prtljag.Prtljag;
import prtljag.PrtljagFactory;

public class Simulacija {

	public static void main(String[] args) throws NemaLicencu {
		// kreiramo let sa 10 putnika
		Let let = new Let("Let Srbija - Tajland",2000);
		Putnik[] putnici = {new Putnik("Marko", "Markovic"),new Putnik("Petar", "Petrovic"), new Putnik("Slobodan","Slobodanovic"), 
				new Putnik("Zarko","Zarkovic"), new Putnik("Slavko","Mitrovic"),new Putnik("Mirko","Slavkovic"), new Putnik("Vuk","Dragicevic"),
				new Putnik("Neo","Matriksovic"), new Putnik("Darko","Vitorovic"), new Putnik("Bil","Gejts")};
		Random rnd = new Random();
		
		Pilot pilotMarko = new Pilot("Marko", "Puric", 60);
		Pilot pilotDusan = new Pilot("Dusan", "Ivanovic", 95);
		
		// dajemo svakom putniku prtljag i ukrcavamo ga na let
		for(int i=0; i<putnici.length;i++) {
			int tezinaPrtljaga = rnd.nextInt(5 - 1 + 1) + 1;
			Prtljag tmpPrtljag = PrtljagFactory.kreirajPrtljag(putnici[i], tezinaPrtljaga);
			let.ukrcajPutnika(putnici[i]);
			// ukoliko se putnik ukrcao nasumicnom verovatnocom ce moci da izgubi prtljag
			if(putnici[i].getLet() != null) {
				tmpPrtljag.nasumicnoIzgubiPrtljag();
			}
		}
		
		// postavljamo pilote na let
		let.postaviPilota(pilotDusan);
		let.postaviPilota(pilotMarko);
	
		let.izvrsiLet();
		
	}

}
