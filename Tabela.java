package Program;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;




public class Tabela extends JFrame{
	JTable Tabela;
	DefaultTableModel Informacje;
	private JScrollPane Scroll;
	private JPanel Panel;
	public void Tabelka(JPanel panel){
		Informacje = new DefaultTableModel();
		Informacje.addColumn("Imię");
		Informacje.addColumn("Nazwisko");
		Informacje.addColumn("Data ur.");
		Informacje.addColumn("Adres zam.");
		Informacje.addColumn("Pesel");
		Informacje.addColumn("Wykroczenie");
		Tabela = new JTable(Informacje);
		Scroll = new JScrollPane(Tabela);
		panel.add(Scroll);
		Panel = panel;
		OdswiezanieTabeli watekOdswiezania = new OdswiezanieTabeli();
        watekOdswiezania.start();
		
	}
	private class OdswiezanieTabeli extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    sleep(2000); 
                    Wczytywanie("dane.txt");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
	
	
	
	 private void Wczytywanie(String nazwaPliku) {
		 	Informacje.setRowCount(0);// Czysci to co jest w tabeli przed dodaniem nowych osob
	        try (Scanner scanner = new Scanner(new File(nazwaPliku))) {
	            while (scanner.hasNextLine()) {
	                String[] dane = scanner.nextLine().split(",");
	                Informacje.addRow(dane);
	            }
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
	 }

}}
