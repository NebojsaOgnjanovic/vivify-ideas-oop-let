package osobe;

import java.util.Random;

public class Pilot extends Osoba {
	private boolean imaLicencu;

	public Pilot(String ime, String prezime, int kilaza) {
		super(ime, prezime, kilaza);
		this.imaLicencu = genValidnostLicence();
	}

	public boolean isPosedujeLicencu() {
		return imaLicencu;
	}

	private boolean genValidnostLicence() {
		Random rn = new Random();
		int randVal = rn.nextInt(100 - 1 + 1) + 1;
		if (randVal <= 5) {
			return false;
		}
		return true;
	}
}
