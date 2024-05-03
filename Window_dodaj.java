package Program;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

class Window_dodaj extends JFrame {
		JTextField imie, nazwisko, wiek, pesel, adres, telefon;
		JLabel imie1, nazwisko1, wiek1, pesel1, adres1, telefon1;
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
		
		// wiek
		
		wiek1 = new JLabel("Nazwisko: ");
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
		// Nr_telefonu
		telefon1 = new JLabel("Telefon: ");
		telefon= new JTextField(10);
		panel.add(telefon1);
		panel.add(telefon);
		
		//Przycisk
		zapisz = new JButton("Zapisz formluarz");
		zapisz.addActionListener(event -> panel.setVisible(false));
		panel.add(zapisz);
		
		
		
		// Odswiezanie
		panel.revalidate();
        panel.repaint();
	}
}