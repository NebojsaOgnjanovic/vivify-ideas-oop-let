package ljudi;

import java.util.ArrayList;
import java.util.Random;

import let.Let;
import prtljag.Prtljag;

public class Putnik extends Covek{
	boolean noFly;
	ArrayList<Prtljag> prtljag = new ArrayList<Prtljag>();
	
	Let let;
	
	public Let getLet() {
		return let;
	}

	public void setLet(Let let) {
		this.let = let;
	}

	public Putnik(String ime, String prezime) {
		super(ime, prezime);
		// kilazu postavljamo na nasumicno generisanu vrednost u intervalu 20 - 100
		this.setKilaza(this.genKilazu());
		// noFly postavljamo na nasumicno generisanu vrednost u skladu sa verovatnocom da je putnik na listi 30%
		noFly = genNoFly();
	}
	
	private boolean genNoFly() {
		Random rn = new Random();
		int randVal = rn.nextInt(9 - 1 + 1) + 1;
		// 30% sanse za no fly
		if(randVal <= 3)
			return true;
		else 
			return false;
	}
	
	public int genKilazu() {
		Random rn = new Random();
		int randVal = rn.nextInt(100 - 20 + 1) + 20;
		return randVal;
	}
	
	public boolean isNoFly() {
		return noFly;
	}

	public ArrayList<Prtljag> getPrtljag() {
		return prtljag;
	}

	public void setPrtljag(ArrayList<Prtljag> prtljag) {
		this.prtljag = prtljag;
	}
	
	public int getTezinaPrtljaga() 
	{
		int ukupnoPrtljag = 0;
		for(Prtljag torba : prtljag) {
			ukupnoPrtljag+= torba.getTezinaPrtljaga();
		}
		return ukupnoPrtljag;
	}
}
