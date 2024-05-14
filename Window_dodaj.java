package Program;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
class Window_dodaj extends JFrame implements ActionListener {
		JTextField imie, nazwisko, wiek, pesel, adres, Wykroczenie;
		JLabel imie1, nazwisko1, wiek1, pesel1, adres1, Wykroczenie1;
		JButton zapisz;
		Tabela Tabela;
		JPanel panel;
		
	public void formularz(JPanel panel){
		// Ustawienie panel
		panel.setLayout(new GridLayout(7,2,5,10));
		// imie
		imie1 = new JLabel("Imie: ");
		imie = new JTextField(20);
		imie.getDocument().addDocumentListener(new DocumentListener(){
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
				if (imie.getText().matches(".*\\d.*")){
					imie.setBackground(Color.red);
					zapisz.setEnabled(false);
					imie.setToolTipText("Nie prawidłowe znaki! Nie pisz liczb");
				}
				else {
					imie.setBackground(Color.white);
					zapisz.setEnabled(true);
				}
			}
			}
		);
		panel.add(imie1);
		panel.add(imie);
		
		// nazwisko
		
		nazwisko1 = new JLabel("Nazwisko: ");
		nazwisko = new JTextField(20);
		nazwisko.getDocument().addDocumentListener(new DocumentListener(){

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
				if (nazwisko.getText().matches(".*\\d.*")){
					nazwisko.setBackground(Color.red);
					zapisz.setEnabled(false);
					nazwisko.setToolTipText("Nie prawidłowe znaki! Nie pisz liczb");
				}
				else {
					nazwisko.setBackground(Color.white);
					zapisz.setEnabled(true);
				}
			}
		});		
		panel.add(nazwisko1);
		panel.add(nazwisko);
		//data_urodzenia
		wiek1 = new JLabel("Data urodzenia: ");
		wiek = new JTextField(20);
		
		wiek.getDocument().addDocumentListener(new DocumentListener(){
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
				if(wiek.getText().matches("[\\d.]+")){  // \\d+ oznacza dowolną liczbę od 0 do 9 natomiast, '+' oznacza że poprzednia liczba może wystąpić jeden lub wiecej razy
					wiek.setBackground(Color.white);
					zapisz.setEnabled(true);
				}
				else{
					wiek.setBackground(Color.red);
					zapisz.setEnabled(false);
					wiek.setToolTipText("Nie prawidłowe znaki! Wpisz cyfry");
				}
			}
			
			
		});
		panel.add(wiek1);
		panel.add(wiek);
		
		//Pesel
		pesel1 = new JLabel("Pesel: ");
		pesel = new JTextField(20);
		
		
		pesel.getDocument().addDocumentListener(new DocumentListener() {

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
				if(pesel.getText().matches("[\\d.]+")){  // \\d+ oznacza dowolną liczbę od 0 do 9 natomiast, '+' oznacza że poprzednia liczba może wystąpić jeden lub wiecej razy
					pesel.setBackground(Color.white);
					zapisz.setEnabled(true);
					if(String.valueOf(pesel.getText()).length() == 11){
						pesel.setBackground(Color.white);
						zapisz.setEnabled(true);
					}
					else{
						pesel.setBackground(Color.red);
						zapisz.setEnabled(false);
						pesel.setToolTipText("Nie prawidłowa liczba znaków, musi być 11!");
					}
				}
				else{
					pesel.setBackground(Color.red);
					zapisz.setEnabled(false);
					pesel.setToolTipText("Nie prawidłowe znaki! Wpisz cyfry");
				}	
			}
			
		});
		panel.add(pesel1);
		panel.add(pesel);
		
		//Adres Zamieszkania
		
		adres1 = new JLabel("Adres: ");
		adres= new JTextField(20);
		panel.add(adres1);
		panel.add(adres);
		
		// Wykroczenie
		
		Wykroczenie1 = new JLabel("Wykroczenie: ");
		Wykroczenie= new JTextField(20);
		panel.add(Wykroczenie1);
		panel.add(Wykroczenie);
		
		//Przycisk
		zapisz = new JButton("Zapisz formluarz");
		Tabela = new Tabela();
		
		zapisz.addActionListener(event -> {panel.removeAll(); Tabela.Tabelka(panel);panel.revalidate();Tabela.loadDataFromFile();}); // z panelu usuwamy wszytsko; to panelu dolaczam Tabelke; odswiezanie
		panel.add(zapisz);
        // Odswiezanie
        panel.revalidate();
        panel.repaint();
        
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == zapisz) {
            // Save data to a text file
            Tabela.saveDataToFile(imie.getText(), nazwisko.getText(), wiek.getText(), pesel.getText(), adres.getText(), Wykroczenie.getText());
            // Clear text fields after saving
            imie.setText("");
            nazwisko.setText("");
            wiek.setText("");
            pesel.setText("");
            adres.setText("");
            Wykroczenie.setText("");
        }
		
	}
	


}
