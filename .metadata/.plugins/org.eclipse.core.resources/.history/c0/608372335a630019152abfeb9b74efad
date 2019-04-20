package let;

import java.util.ArrayList;

import exceptions.NemaLicencu;
import ljudi.Pilot;
import ljudi.Putnik;
import logger.LoggerLeta;
import prtljag.Prtljag;

public class Let {
	private String naziv; 
	// predpostavljam da se kapacitet odnosi na kapacatitet prtljaga
	private int kapacitet;
	private ArrayList<Putnik> spisakPutnika = new ArrayList<Putnik>();
	private ArrayList<Prtljag> listaIzgubljenihPrtljaga = new ArrayList<Prtljag>();
	// ukupna tezina svih prtljaga na letu
	int tezinaPrtljaga = 0;
	int tezinaIzgubljenihPrtljaga = 0;
	Pilot pilot;
	
	LoggerLeta logger = LoggerLeta.getInstance();
	
	public Let(String naziv, int kapacitet) {
		this.naziv = naziv;
		this.kapacitet = kapacitet;
	}
	
	public void ukrcajPutnika(Putnik putnik) {
		if(!spisakPutnika.contains(putnik) && putnik.isNoFly() == false && tezinaPrtljaga < kapacitet) {
			this.spisakPutnika.add(putnik);
			putnik.setLet(this);
			// prilikom ukrcavanja putnika ukrcavamo i njegov prtljag
			tezinaPrtljaga+= putnik.getTezinaPrtljaga();
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
		return spisakPutnika;
	}

	public void setSpisakPutnika(ArrayList<Putnik> spisakPutnika) {
		this.spisakPutnika = spisakPutnika;
	}
	
	public void dodajIzgubljeniPrtljag(Prtljag izgubljeniPrtljag) {
		if(!listaIzgubljenihPrtljaga.contains(izgubljeniPrtljag) && spisakPutnika.contains(izgubljeniPrtljag.getVlasnikPrtljaga()))
			listaIzgubljenihPrtljaga.add(izgubljeniPrtljag);
	}
	
	public void postaviPilota(Pilot pilot) throws NemaLicencu {
		if(pilot.isPosedujeLicencu() == false) 
		{
			throw new NemaLicencu(String.format("Pilot %s %s nema licencu, saljemo ga u zatvor", pilot.getIme(), pilot.getPrezime()));
		} else {
			this.pilot = pilot;
		} 
	}
	
	public void izvrsiLet() 
	{	
		// onemogucavamo let bez pilota, u slucaju da pilot nema licencu nas deklarisani pilot objekat nece biti inicijalizovan
		// ova provera je napisana za svaki slucaj, ukoliko se obradi exception da svakako sprecimo let
		logger.loguj("\n\n\n=========================================================", true);
		if(pilot == null) {
			logger.loguj("\n\n\nLet se nece odrzati, nedostaje pilot", false);
		}
		else if(listaIzgubljenihPrtljaga.isEmpty()) 
		{
			logger.loguj("\n\n\nNa letu nije bilo izgubljenih prtljaga.", true);
		}
		else {
			logger.loguj("\n\n\nImena putnika ciji su prtljazi izgubljeni su:", true);
			for(Prtljag prtljag : listaIzgubljenihPrtljaga) {
				tezinaIzgubljenihPrtljaga+= prtljag.getTezinaPrtljaga();
				logger.loguj(String.format("%s %s", prtljag.getVlasnikPrtljaga().getIme(), prtljag.getVlasnikPrtljaga().getPrezime()), true);
			}
			logger.loguj(String.format("\n \nUkupna tezina izgubljenih prtljaga je: %skg", Integer.toString(tezinaIzgubljenihPrtljaga)), true);
			
		}
	}
}
