package P;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class WB {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Table Prac.");
		JPanel panel = new JPanel();
		
		String[] headings = new String[] {"id", "name", "country"};
		Object[][] data = new Object[][] {
			{"1","Dani","Korea"},
			{"2","Sunn","France"},
			{"3","John","Japan"}
		};
		
		JTable table = new JTable(data, headings);
		table.setPreferredScrollableViewportSize(new Dimension(700,600));
		table.setFillsViewportHeight(true);
		

		panel.add(new JScrollPane(table));
		frame.add(panel);
		
		frame.setVisible(true);
		frame.setSize(800, 640);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
