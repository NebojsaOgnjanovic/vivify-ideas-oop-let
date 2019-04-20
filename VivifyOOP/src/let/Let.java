package let;

import java.util.ArrayList;

import exceptions.ImaLicencu;
import logger.Logger;
import osobe.Pilot;
import osobe.Putnik;
import prtljag.Prtljag;

public class Let {
	private String naziv;
	private int kapacitet;
	Pilot pilot;

	private ArrayList<Putnik> ukrcaniPutnici = new ArrayList<Putnik>();
	private ArrayList<Prtljag> listaIzgubljenihPrtljaga = new ArrayList<Prtljag>();

	int ukupnaMasa = 0;
	int masaIzgubljenihPrtljaga = 0;

	Logger logger = Logger.getInstance();

	public Let(String naziv, int kapacitet) {
		this.naziv = naziv;
		this.kapacitet = kapacitet;
	}

	public void ukrcajPutnika(Putnik putnik) {
		if (!ukrcaniPutnici.contains(putnik) && putnik.isNoFly() == false && ukupnaMasa < kapacitet) {
			this.ukrcaniPutnici.add(putnik);
			putnik.setLet(this);
			ukupnaMasa += putnik.getTezinaPrtljaga();
		}
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getKapacitet() {
		return kapacitet;
	}

	public void setKapacitet(int kapacitet) {
		this.kapacitet = kapacitet;
	}

	public ArrayList<Putnik> getSpisakPutnika() {
		return ukrcaniPutnici;
	}

	public void setSpisakPutnika(ArrayList<Putnik> spisakPutnika) {
		this.ukrcaniPutnici = spisakPutnika;
	}

	public void dodajIzgubljeniPrtljag(Prtljag izgubljeniPrtljag) {
		if (!listaIzgubljenihPrtljaga.contains(izgubljeniPrtljag)
				&& ukrcaniPutnici.contains(izgubljeniPrtljag.getVlasnikPrtljaga()))
			listaIzgubljenihPrtljaga.add(izgubljeniPrtljag);
	}

	public void postaviPilota(Pilot pilot) throws ImaLicencu {
		if (pilot.isPosedujeLicencu() == false) {
			throw new ImaLicencu(
					String.format("%s %s ne poseduje licencu za izvrsavanje leta !!!!Uhapsite ga!!!!", pilot.getIme(), pilot.getPrezime()));
		} else {
			this.pilot = pilot;
		}
	}

	public void izvrsiLet() {
		logger.loguj("\n=========================================================", true);
		if (pilot == null) {
			logger.loguj("\nNeuspelo poletanje !!!Nedostaje nam pilot", false);
		} else if (listaIzgubljenihPrtljaga.isEmpty()) {
			logger.loguj("\nNema izgubljenog prtljaga !!!", true);
		} else {
			logger.loguj("\n\n\nPutnici ciji prtljag nedostaje su:", true);
			for (Prtljag prtljag : listaIzgubljenihPrtljaga) {
				masaIzgubljenihPrtljaga += prtljag.getTezinaPrtljaga();
				logger.loguj(String.format("%s %s", prtljag.getVlasnikPrtljaga().getIme(),
						prtljag.getVlasnikPrtljaga().getPrezime()), true);
			}
			logger.loguj(String.format("\n \nUkupna tezina izgubljenih prtljaga je: %skg",
					Integer.toString(masaIzgubljenihPrtljaga)), true);

		}
	}
}
