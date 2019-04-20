package osobe;

import java.util.ArrayList;
import java.util.Random;

import let.Let;
import prtljag.Prtljag;

public class Putnik extends Osoba {
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
		this.setKilaza(this.genKilazu());
		noFly = genNoFly();
	}

	private boolean genNoFly() {
		Random rn = new Random();
		int randVal = rn.nextInt(100 - 1 + 1) + 1;
		if (randVal <= 30)
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

	public int getTezinaPrtljaga() {
		int ukupnoPrtljag = 0;
		for (Prtljag torba : prtljag) {
			ukupnoPrtljag += torba.getTezinaPrtljaga();
		}
		return ukupnoPrtljag;
	}
}
