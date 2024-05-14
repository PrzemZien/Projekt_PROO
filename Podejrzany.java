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
	
	
	public String getImie() {
        return imie;
    }
    
    public void setImie(String imie) {
        this.imie = imie;
    }
    
    
    public String getNazwisko() {
        return nazwisko;
    }
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
    
    public double getDataUrodzenia() {
        return data_urodzenia;
    }
    
    public void setDataUrodzenia(double dataUrodzenia) {
        this.data_urodzenia = dataUrodzenia;
    }
    
    public String getAdresZamieszkania() {
        return Adres_zamieszkania;
    }
    
    public void setAdresZamieszkania(String adresZamieszkania) {
        this.Adres_zamieszkania = adresZamieszkania;
    }
    
    public int getPesel() {
        return Pesel;
    }
    
    public void setPesel(int pesel) {
        this.Pesel = pesel;
    }
    
    public String getWykroczenie() {
        return Wykroczenie;
    }
    
    public void setWykroczenie(String wykroczenie) {
        this.Wykroczenie = wykroczenie;
    }
}	
