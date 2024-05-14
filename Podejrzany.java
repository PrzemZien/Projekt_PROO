package Program;

public class Podejrzany {
	
	
	private String imie;
	private String nazwisko;
	private String Adres_zamieszkania;
	private String Pesel;
	private String Wykroczenie;
	private String data_urodzenia;
	
	
	//zapisz.addActionListener(event -> {panel.removeAll();Tabela.Tabelka(panel);panel.revalidate();panel.repaint();});
	
	public Podejrzany(String imie, String nazwisko, String data_urodzenia, String Adres_zamieszkania, String Pesel, String Wykroczenie){
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
    public String getNazwisko() {
        return nazwisko;
    }
    public String getDataUrodzenia() {
        return data_urodzenia;
    }
    public String getAdresZamieszkania() {
        return Adres_zamieszkania;
    }
    public String getPesel() {
        return Pesel;
    }
    public String getWykroczenie() {
        return Wykroczenie;
    }
    
}	
