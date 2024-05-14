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
		// umieszczenie tabeli w panelu 
		panel.add(Scroll);
		Panel = panel;
	}
	public static void saveDataToFile(String imie, String nazwisko, String dataUrodzenia, String pesel, String adres, String wykroczenie) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("suspect_data.txt", true))) {
            writer.println(imie + "," + nazwisko + "," + dataUrodzenia + "," + pesel + "," + adres + "," + wykroczenie);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	public void loadDataFromFile() {
	    try (Scanner scanner = new Scanner(new File("suspect_data.txt"))) {
	        while (scanner.hasNextLine()) {
	            String line = scanner.nextLine();
	            String[] data = line.split(",");
	            Informacje.addRow(data);
	        }
	        // Refresh the table after adding rows
	        Tabela.revalidate();
	        Tabela.repaint();
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	}

	

	

}
