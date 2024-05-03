package Program;

public class Podejrzany {
	
	
	private String imie;
	private String nazwisko;
	private String Adres_zamieszkania;
	private int Pesel;
	private String Wykroczenie;
	private double data_urodzenia;
	
	
	
	
	public Podejrzany(String imie, String nazwisko, double data_urodzenia, String Adres_zamieszkania, int Pesel, String Wykroczenie){
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.data_urodzenia = data_urodzenia;
		this.Adres_zamieszkania = Adres_zamieszkania;
		this.Pesel = Pesel;
		this.Wykroczenie = Wykroczenie;
	}
}
