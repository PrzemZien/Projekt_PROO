package Program;

import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;


public class Window extends JFrame implements ActionListener{
	// wyjąłem to z konstruktora aby actionPerforemd to widział
		JMenuBar menu;
		JMenu Osoby;
		JMenuItem dodaj_osobe,szukaj_osobe, wyjdz;
		JTextField Imie, Nazwisko, Wiek;
		Window_dodaj dane_osoby;
		Szuka_osoby szukaj_osob;
		JPanel panel;
	public Window(){
		// do kody generalnie to jest to samo co JFrame okno = new JFrame() ale zrobiłem to tutaj żeby dalej można było edytować
		this.setSize(1000, 720); // okno pionowo,poziomo
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Dzięki temu może zamykac się po wcisnieciu x
		this.setResizable(false);
		this.setTitle("Kartoteka Komendy Głownej policji");
		this.setLayout(new FlowLayout());
		this.setLocationRelativeTo(null); 
		
		
		// Menu 
		menu = new JMenuBar();
		Osoby = new JMenu("Zarządzanie");
		dodaj_osobe = new JMenuItem("Dodaj osobę");
		szukaj_osobe = new JMenuItem("Szukaj osoby");
		wyjdz = new JMenuItem("Zamknij kartotekę");
		
		
		menu.add(Osoby);	// tutaj dodałem do paska tą opcje
		Osoby.add(dodaj_osobe); // tutaj do opcji Zarządanie dodaje dodaj_osobe
		dodaj_osobe.addActionListener(this); // to musiałem dodać bo inaczej ActionListener nie zadziałałby, czyli ta komenda łączy działanie tego konstruktora z ActListe
		Osoby.add(szukaj_osobe);
		szukaj_osobe.addActionListener(this);
		Osoby.add(wyjdz);
		wyjdz.addActionListener(this);
		// okno
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		//
		this.add(panel);
		this.setJMenuBar(menu);
		this.setVisible(true); // daje widzialnosc okna
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// przypisane przyciskow
		
		if(e.getSource()==dodaj_osobe){
			 panel.removeAll();
			 dane_osoby = new Window_dodaj();
			 dane_osoby.formularz(panel);
			 panel.revalidate();
		     panel.repaint();
		     panel.setVisible(true);
		     
		}
		if(e.getSource()==wyjdz){
			System.exit(0);
		}
		if(e.getSource()==szukaj_osobe){
			panel.removeAll();
			szukaj_osob = new Szuka_osoby();
			szukaj_osob.szukanie(panel);
			panel.revalidate();
		    panel.repaint();
		    panel.setVisible(true);
		}
	
		
	}
			
	
	
}
