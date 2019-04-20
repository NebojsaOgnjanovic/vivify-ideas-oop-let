package prtljag;

import java.util.Random;

import ljudi.Putnik;

public class RucniPrtljag extends Prtljag{
	public RucniPrtljag(Putnik vlasnikPrtljaga, int tezinaPrtljaga) {
		super(vlasnikPrtljaga, tezinaPrtljaga);
	}
	
	public void nasumicnoIzgubiPrtljag() 
	{	
		Random rn = new Random();
		int randVal = rn.nextInt(100 - 1 + 1) + 1;
		if(randVal <= 10) {
			this.IzgubiPrtljag();
		}
	}
	
	@Override
	public void IzgubiPrtljag() {
		
	}
}
