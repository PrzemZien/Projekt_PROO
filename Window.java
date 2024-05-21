package Program;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;


public class Window extends JFrame implements ActionListener{
	// wyjąłem to z konstruktora aby actionPerforemd to widział
		JMenuBar Menu;
		JMenu Zarzadanie;
		JMenuItem Item_dodaj_osobe,Item_szukaj_osobe, Wyjdz;
		JTextField Imie, Nazwisko, Wiek;
		Dodawanie Dane_osoby;
		Poszukiwacz Szukaj_osob;
		JPanel Panel;
		Tabela Tabela;
		
		
	public Window(){
		// do kody generalnie to jest to samo co JFrame okno = new JFrame() ale zrobiłem to tutaj żeby dalej można było edytować
		this.setSize(1000, 720); // okno pionowo,poziomo
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Dzięki temu może zamykac się po wcisnieciu x
		this.setResizable(false);
		this.setTitle("Kartoteka Komendy Głownej policji");
		this.setLayout(new FlowLayout());
		this.setLocationRelativeTo(null); 
		this.getContentPane().setBackground(Color.decode("#eaece5"));
		
		
		// Menu 
		Menu = new JMenuBar();
		Zarzadanie = new JMenu("Zarządzanie");
		Zarzadanie.setBorder(BorderFactory.createEtchedBorder());
		Item_dodaj_osobe = new JMenuItem("Dodaj osobę");
		Item_szukaj_osobe = new JMenuItem("Szukaj osoby");
		Wyjdz = new JMenuItem("Zamknij kartotekę");
		
		
		Menu.add(Zarzadanie);	// tutaj dodałem do paska tą opcje
		Zarzadanie.add(Item_dodaj_osobe); // tutaj do opcji Zarządanie dodaje Item_dodaj_osobe
		Item_dodaj_osobe.addActionListener(this); // to musiałem dodać bo inaczej ActionListener nie zadziałałby, czyli ta komenda łączy działanie tego konstruktora z ActListe
		Zarzadanie.add(Item_szukaj_osobe);
		Item_szukaj_osobe.addActionListener(this);
		Zarzadanie.add(Wyjdz);
		Wyjdz.addActionListener(this);
		// okno
		Panel = new JPanel();
		Panel.setLayout(new FlowLayout());
		//Tabela
		Tabela = new Tabela();
		Tabela.Tabelka(Panel);
		
		
		this.add(Panel);
		this.setJMenuBar(Menu);
		this.setVisible(true); // daje widzialnosc okna
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// przypisane przyciskow
		
		if(e.getSource()==Item_dodaj_osobe){
			 Panel.removeAll();
			 Panel.revalidate();
		     Panel.repaint();
			 Dane_osoby = new Dodawanie();
		     Panel.setVisible(true);
		     Dane_osoby.Formularz(Panel);
	
		     
		}
		if(e.getSource()==Wyjdz){
			System.exit(0);
		}
		if(e.getSource()==Item_szukaj_osobe){
			Panel.removeAll();
			Szukaj_osob = new Poszukiwacz();
			Szukaj_osob.PanelSzukanie(Panel);
			Panel.revalidate();
		    Panel.repaint();
		    Panel.setVisible(true);
		}
	
		
	}
			
	
	
}
