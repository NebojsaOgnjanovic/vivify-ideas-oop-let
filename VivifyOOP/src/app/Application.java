package app;

import java.lang.reflect.Array;
import java.util.Random;

import exceptions.ImaLicencu;
import let.Let;
import osobe.Pilot;
import osobe.Putnik;
import prtljag.Prtljag;
import prtljag.PrtljagFactory;

public class Application {

	public static void main(String[] args) throws ImaLicencu {

		Let let = new Let("Let21310", 5250);

		Pilot pilotMarko = new Pilot("Andrea", "Romanic", 66);
		Pilot pilotDusan = new Pilot("Sonja", "Ristic", 83);

		Putnik[] putnici = { new Putnik("Nebojsa", "Ognjanovic"), new Putnik("Igor", "Igorijevic"),
				new Putnik("Zinedin", "Zidan"), new Putnik("Milan", "Ivanovic"), new Putnik("Ivan", "Milanovic"),
				new Putnik("Gordan", "Gordanovic"), new Putnik("Ilija", "Gromovnik"), new Putnik("Boban", "Bobanovic"),
				new Putnik("Golijat", "Davidovic"), new Putnik("Smiljan", "Dobricin") };
		Random rnd = new Random();

		for (int i = 0; i < putnici.length; i++) {
			int tezinaPrtljaga = rnd.nextInt(5 - 1 + 1) + 1;
			Prtljag tmpPrtljag = PrtljagFactory.kreirajPrtljag(putnici[i], tezinaPrtljaga);
			let.ukrcajPutnika(putnici[i]);
			if (putnici[i].getLet() != null) {
				tmpPrtljag.nasumicnoIzgubiPrtljag();
			}
		}

		let.postaviPilota(pilotDusan);
		let.postaviPilota(pilotMarko);

		let.izvrsiLet();

	}

}
