package Program;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.Queue;
import java.util.LinkedList;
class Dodawanie extends JFrame implements ActionListener {
		JTextField Imie, Nazwisko, Wiek, Pesel, Adres, Wykroczenie;
		JLabel Imie1, Nazwisko1, Wiek1, Pesel1, Adres1, Wykroczenie1;
		JButton Przyciskzapisz;
		Tabela Tabela;
		JPanel Panel;
		Queue<String[]> Dane;
		
	public void Formularz(JPanel Panel){
		// Ustawienie Panel
		this.Panel = Panel;
		Panel.setLayout(new GridLayout(7,2,5,10));
		Panel.setBackground(Color.decode("#eaece5"));
		// kolejka
		Dane = new LinkedList<>();
		// Imie
		Imie1 = new JLabel("Imie: ");
		Imie = new JTextField(20);
		Imie.getDocument().addDocumentListener(new DocumentListener(){
			@Override
			public void insertUpdate(DocumentEvent e) {
				kolor();
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				kolor();
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				kolor();
				
			}
			
			private void kolor(){
				if (Imie.getText().matches(".*\\d.*")){
					Imie.setBackground(Color.red);
					Przyciskzapisz.setEnabled(false);
					Imie.setToolTipText("Nie prawidłowe znaki! Nie pisz liczb");
				}
				else {
					Imie.setBackground(Color.white);
					Przyciskzapisz.setEnabled(true);
				}
			}
			}
		);
		Panel.add(Imie1);
		Panel.add(Imie);
		
		// Nazwisko
		
		Nazwisko1 = new JLabel("Nazwisko: ");
		Nazwisko = new JTextField(20);
		Nazwisko.getDocument().addDocumentListener(new DocumentListener(){

			@Override
			public void insertUpdate(DocumentEvent e) {
				kolornazwisko();
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				kolornazwisko();
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				kolornazwisko();
				
			}
			private void kolornazwisko(){
				if (Nazwisko.getText().matches(".*\\d.*")){
					Nazwisko.setBackground(Color.red);
					Przyciskzapisz.setEnabled(false);
					Nazwisko.setToolTipText("Nie prawidłowe znaki! Nie pisz liczb");
				}
				else {
					Nazwisko.setBackground(Color.white);
					Przyciskzapisz.setEnabled(true);
				}
			}
		});		
		Panel.add(Nazwisko1);
		Panel.add(Nazwisko);
		//data_urodzenia
		Wiek1 = new JLabel("Data urodzenia: ");
		Wiek = new JTextField(20);
		
		Wiek.getDocument().addDocumentListener(new DocumentListener(){
			@Override
			public void insertUpdate(DocumentEvent e) {
				kolorwiek();
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				kolorwiek();
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				kolorwiek();
				
			}
			
			private void kolorwiek(){
				if(Wiek.getText().matches("[\\d.]+")){  // \\d+ oznacza dowolną liczbę od 0 do 9 natomiast, '+' oznacza że poprzednia liczba może wystąpić jeden lub wiecej razy
					Wiek.setBackground(Color.white);
					Przyciskzapisz.setEnabled(true);
				}
				else{
					Wiek.setBackground(Color.red);
					Przyciskzapisz.setEnabled(false);
					Wiek.setToolTipText("Nie prawidłowe znaki! Wpisz cyfry");
				}
			}
			
			
		});
		Panel.add(Wiek1);
		Panel.add(Wiek);
		
		//Pesel
		Pesel1 = new JLabel("Pesel: ");
		Pesel = new JTextField(20);
		
		
		Pesel.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				pesel_liczby();
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				pesel_liczby();
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				pesel_liczby();
				
			}
			
			private void pesel_liczby(){
				if(Pesel.getText().matches("[\\d.]+")){  // \\d+ oznacza dowolną liczbę od 0 do 9 natomiast, '+' oznacza że poprzednia liczba może wystąpić jeden lub wiecej razy
					Pesel.setBackground(Color.white);
					Przyciskzapisz.setEnabled(true);
					if(String.valueOf(Pesel.getText()).length() == 11){
						Pesel.setBackground(Color.white);
						Przyciskzapisz.setEnabled(true);
					}
					else{
						Pesel.setBackground(Color.red);
						Przyciskzapisz.setEnabled(false);
						Pesel.setToolTipText("Nie prawidłowa liczba znaków, musi być 11!");
					}
				}
				else{
					Pesel.setBackground(Color.red);
					Przyciskzapisz.setEnabled(false);
					Pesel.setToolTipText("Nie prawidłowe znaki! Wpisz cyfry");
				}	
			}
			
		});
		Panel.add(Pesel1);
		Panel.add(Pesel);
		
		//Adres Zamieszkania
		
		Adres1 = new JLabel("Adres: ");
		Adres= new JTextField(20);
		Panel.add(Adres1);
		Panel.add(Adres);
		
		// Wykroczenie
		
		Wykroczenie1 = new JLabel("Wykroczenie: ");
		Wykroczenie= new JTextField(20);
		Panel.add(Wykroczenie1);
		Panel.add(Wykroczenie);
		
		//Przycisk
		Przyciskzapisz = new JButton("Przyciskzapisz formluarz");
		Przyciskzapisz.setBorder(BorderFactory.createEtchedBorder());
		Tabela = new Tabela();
		Przyciskzapisz.addActionListener(this);
		
		Panel.add(Przyciskzapisz);
        // Odswiezanie
        Panel.revalidate();
        Panel.repaint();
        
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == Przyciskzapisz) {
	    	String Imie_plik = Imie.getText();
	    	String Nazwisko_plik = Nazwisko.getText();
	    	String Wiek_plik = String.valueOf(Wiek.getText());
	    	String Pesel_plik = String.valueOf(Pesel.getText());
	    	String Adres_plik = Adres.getText();
	    	String Wykroczenie_plik = Wykroczenie.getText();
	    	String[] row = {Imie_plik, Nazwisko_plik, Wiek_plik, Adres_plik, Pesel_plik, Wykroczenie_plik};
            Dane.offer(row);
	    	Panel.removeAll();
	    	Tabela.Tabelka(Panel);
	    	Panel.revalidate();
	    	Panel.repaint();
	    	Zapisywanie("Dane.txt", Dane);
	    	Tabela.revalidate();
	    	Panel.repaint();
	    }
	}
	private void Zapisywanie(String nazwaPliku, Queue<String[]> Dane) {
        try (FileWriter writer = new FileWriter(nazwaPliku, true)) {
            while (!Dane.isEmpty()) {
                String[] row = Dane.poll();
                if (row != null) {
                    for (String field : row) {
                        writer.write(field + ",");
                    }
                    writer.write("\n");
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
     }
    
}
	


}
