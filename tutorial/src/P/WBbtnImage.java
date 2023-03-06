package P;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class WBbtnImage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WBbtnImage window = new WBbtnImage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WBbtnImage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 898, 630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\WB\\image\\btn_blue.png"));
		btnNewButton.setSelectedIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\WB\\image\\btn_blue.png"));
		btnNewButton.setBounds(70, 183, 367, 103);
		btnNewButton.setPressedIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\WB\\image\\btn_skyblue.png"));
		panel.add(btnNewButton);
	}
}
