package osobe;

public class Osoba {

	private String ime;
	private String prezime;
	private int kilaza;

	public Osoba(String ime, String prezime) {
		this.ime = ime;
		this.prezime = prezime;
	}

	public Osoba(String ime, String prezime, int kilaza) {
		this.ime = ime;
		this.prezime = prezime;
		this.kilaza = kilaza;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public int getKilaza() {
		return kilaza;
	}

	public void setKilaza(int kilaza) {
		this.kilaza = kilaza;
	}

}