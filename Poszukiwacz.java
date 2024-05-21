
package Program;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class Poszukiwacz extends JFrame implements ActionListener{
		JLabel Dane;
		JTextField Daneszukane;
		JButton PrzyciskSzukaj;
		JPanel Panel;
		private String linia;
		
	public void Szukanie_Panel(JPanel Panel){
		Panel.setLayout(new GridLayout(2,2,5,10));
		// Label
		Dane = new JLabel("Pesel osoby: ");
		Panel.add(Dane);
		
		// Pole tekstowe
		Daneszukane = new JTextField(10);
		Daneszukane.getDocument().addDocumentListener(new DocumentListener() {

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
				if(Daneszukane.getText().matches("[\\d.]+")){  // \\d+ oznacza dowolną liczbę od 0 do 9 natomiast, '+' oznacza że poprzednia liczba może wystąpić jeden lub wiecej razy
					Daneszukane.setBackground(Color.white);
					PrzyciskSzukaj.setEnabled(true);
					if(String.valueOf(Daneszukane.getText()).length() == 11){
						Daneszukane.setBackground(Color.white);
						PrzyciskSzukaj.setEnabled(true);
					}
					else{
						Daneszukane.setBackground(Color.red);
						PrzyciskSzukaj.setEnabled(false);
						Daneszukane.setToolTipText("Nie prawidłowa liczba znaków, musi być 11!");
					}
				}
				else{
					Daneszukane.setBackground(Color.red);
					PrzyciskSzukaj.setEnabled(false);
					Daneszukane.setToolTipText("Nie prawidłowe znaki! Wpisz cyfry");
				}	
			}
			
		});
		Panel.add(Daneszukane);
		// Przycisk
		PrzyciskSzukaj = new JButton("PrzyciskSzukaj");
		PrzyciskSzukaj.setBorder(BorderFactory.createEtchedBorder());
		PrzyciskSzukaj.addActionListener(this);
		Panel.add(PrzyciskSzukaj);
		
		
		// Odswiezanie
        Panel.revalidate();
        Panel.repaint();
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == PrzyciskSzukaj){
			String pesel = String.valueOf(Daneszukane.getText());
			Szukanie(pesel);
			Panel.removeAll();
			Panel.revalidate();
	    	Panel.repaint();
		}
		
	}
	
	public void Szukanie(String pesel){
		try (BufferedReader reader = new BufferedReader(new FileReader("Dane.txt"))){
			while ((linia = reader.readLine()) != null){
				for (String slowo : linia.split(",")){
					if (slowo.equals(pesel)) {
						JOptionPane.showMessageDialog(this, "Znaleziono osobę o podanym numerze PESEL!");
						return;
					}
				}
			}
			JOptionPane.showMessageDialog(this, "Nie ma takiej osoby");
		}catch(IOException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Błąd podczas odczytu pliku");
		}
		
	}
}

