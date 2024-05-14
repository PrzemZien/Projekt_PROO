
package Program;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Szuka_osoby extends JFrame{
		JLabel dane;
		JTextField daneszuk;
		JButton szukaj;
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
		szukaj.addActionListener(event -> panel.setVisible(false));
		panel.add(szukaj);
		
		
		// Odswiezanie
        panel.revalidate();
        panel.repaint();
		
		
	}
}
