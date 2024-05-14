
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


public class Szuka_osoby extends JFrame implements ActionListener{
		JLabel dane;
		JTextField daneszuk;
		JButton szukaj;
		JPanel panel;
		String linia;
		
	public void szukanie(JPanel panel){
		panel.setLayout(new GridLayout(2,2,5,10));
		// Label
		dane = new JLabel("Pesel osoby: ");
		panel.add(dane);
		
		// Pole tekstowe
		daneszuk = new JTextField(10);
		daneszuk.getDocument().addDocumentListener(new DocumentListener() {

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
				if(daneszuk.getText().matches("[\\d.]+")){  // \\d+ oznacza dowolną liczbę od 0 do 9 natomiast, '+' oznacza że poprzednia liczba może wystąpić jeden lub wiecej razy
					daneszuk.setBackground(Color.white);
					szukaj.setEnabled(true);
					if(String.valueOf(daneszuk.getText()).length() == 11){
						daneszuk.setBackground(Color.white);
						szukaj.setEnabled(true);
					}
					else{
						daneszuk.setBackground(Color.red);
						szukaj.setEnabled(false);
						daneszuk.setToolTipText("Nie prawidłowa liczba znaków, musi być 11!");
					}
				}
				else{
					daneszuk.setBackground(Color.red);
					szukaj.setEnabled(false);
					daneszuk.setToolTipText("Nie prawidłowe znaki! Wpisz cyfry");
				}	
			}
			
		});
		panel.add(daneszuk);
		// Przycisk
		szukaj = new JButton("Szukaj");
		szukaj.setBorder(BorderFactory.createEtchedBorder());
		szukaj.addActionListener(this);
		panel.add(szukaj);
		
		
		// Odswiezanie
        panel.revalidate();
        panel.repaint();
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == szukaj){
			String pesel = String.valueOf(daneszuk.getText());
			Szukanie(pesel);
			panel.removeAll();
			panel.revalidate();
	    	panel.repaint();
		}
		
	}
	
	public void Szukanie(String pesel){
		try (BufferedReader reader = new BufferedReader(new FileReader("dane.txt"))){
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

