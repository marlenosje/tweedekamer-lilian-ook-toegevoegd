package personen;

public abstract class Persoon {
	private String naam;
	private String geboortedatum;
	private char gender;

	public void setGeboortedatum(String value) { this.geboortedatum = value; }
	public String getGeboortedatum() { return this.geboortedatum; }
	
	public void setNaam(String value) { this.naam = value; }
	public String getNaam() { return this.naam; }
	
	public void setGender(char value) { this.gender = value; }
	public char getGender() { return this.gender; }
}

