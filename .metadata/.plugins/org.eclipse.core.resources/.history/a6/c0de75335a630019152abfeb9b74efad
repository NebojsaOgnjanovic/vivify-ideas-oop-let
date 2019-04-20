package prtljag;

import java.util.Random;
import ljudi.Putnik;

public class PredatiPrtljag extends Prtljag{
	public PredatiPrtljag(Putnik vlasnikPrtljaga, int tezinaPrtljaga) {
		super(vlasnikPrtljaga, tezinaPrtljaga);
	}

	@Override
	public void nasumicnoIzgubiPrtljag() 
	{
		Random rn = new Random();
		int randVal = rn.nextInt(100 - 1 + 1) + 1;
		if(randVal <= 30) {
			this.IzgubiPrtljag();
		}
	}
	
	@Override
	public void IzgubiPrtljag() {
		this.vlasnikPrtljaga.getLet().dodajIzgubljeniPrtljag(this);
	}
}
