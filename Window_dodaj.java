package Program;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

class Window_dodaj extends JFrame {
		JTextField imie, nazwisko, wiek, pesel, adres, Wykroczenie;
		JLabel imie1, nazwisko1, wiek1, pesel1, adres1, Wykroczenie1;
		JButton zapisz;
	
	public void formularz(JPanel panel){
		// Ustawienie panel
		panel.setLayout(new GridLayout(7,2,5,10));
		// imie
		imie1 = new JLabel("Imie: ");
		imie = new JTextField(10);
		panel.add(imie1);
		panel.add(imie);
		
		// nazwisko
		
		nazwisko1 = new JLabel("Nazwisko: ");
		nazwisko = new JTextField(10);
		panel.add(nazwisko1);
		panel.add(nazwisko);
		
		//data_urodzenia
		
		wiek1 = new JLabel("Data urodzenia: ");
		wiek = new JTextField(10);
		panel.add(wiek1);
		panel.add(wiek);
		
		//Pesel
		pesel1 = new JLabel("Pesel: ");
		pesel = new JTextField(10);
		panel.add(pesel1);
		panel.add(pesel);
		
		//Adres Zamieszkania
		adres1 = new JLabel("Adres: ");
		adres= new JTextField(10);
		panel.add(adres1);
		panel.add(adres);
		// Wykroczenie
		Wykroczenie1 = new JLabel("Telefon: ");
		Wykroczenie= new JTextField(10);
		panel.add(Wykroczenie1);
		panel.add(Wykroczenie);
		
		//Przycisk
		zapisz = new JButton("Zapisz formluarz");
		zapisz.addActionListener(event -> panel.setVisible(false));
		panel.add(zapisz);
		
		
		
		// Odswiezanie
		panel.revalidate();
        panel.repaint();
	}
}