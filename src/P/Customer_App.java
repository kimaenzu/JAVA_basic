package P;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Customer_App {

	private JFrame frame;
	private JTextField ID;
	private JPasswordField PW;
	private JTextField name;
	private JTextField age;
	private JTextField phone;
	private JTextField birthday;
	private JTextField search;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_App window = new Customer_App();
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
	public Customer_App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		Customer customer = new Customer();
		
		// frame
		frame = new JFrame();

		// Table_P
		ImagePanel Table_P = new ImagePanel();
		Table_P.setBounds(0, 0, 1388, 822);
		// 코드 작성할 때만 잠깐 true로 하고 실행할 땐 false로 (이 페이지가 먼저 보이면 안됨)
		Table_P.setVisible(false);
		String [][] data = customer.getCustomers();
		String [] headers = new String[] {"name","phone","gender","age","Note"};
		Table_P.setLayout(null);
		JTable table = new JTable(data, headers);
		table.setRowHeight(30);
		table.setFont (new Font("Georgia", Font.BOLD, 20));
		table.setAlignmentX(0);
		table.setSize(800,600);
		table.setPreferredScrollableViewportSize(new Dimension(800,600));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(292, 111, 802, 628);
		Table_P.add(scrollPane);
		frame.getContentPane().add(Table_P);
		
		JLabel SearchL = new JLabel("DB Table");
		SearchL.setFont(new Font("Georgia", Font.PLAIN, 42));
		SearchL.setBounds(53, 31, 210, 70);
		Table_P.add(SearchL);
		
		search = new JTextField();
		search.setFont(new Font("Georgia", Font.PLAIN, 38));
		search.setBounds(292, 31, 759, 70);
		Table_P.add(search);
		search.setColumns(10);
		// event 추가
		search.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String val = search.getText();
				TableRowSorter<TableModel> trs = new TableRowSorter<>(table.getModel());
				table.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(val));
			}
		});
		
		TableColumnModel columnModels = table.getColumnModel();
		columnModels.getColumn(0).setPreferredWidth(100);
		columnModels.getColumn(2).setPreferredWidth(50);
		columnModels.getColumn(3).setPreferredWidth(20);  //20이 최솟값

		
		// welcomePanel
		ImagePanel welcomePanel = new ImagePanel(new ImageIcon("C:/Users/user/eclipse-workspace/WB/image/bgi_gray.png").getImage());
		frame.setSize(welcomePanel.getWidth(), welcomePanel.getHeight());
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(959, 0, 429, 895);
		welcomePanel.add(panel);
		panel.setLayout(null);
		
		JLabel Title = new JLabel("Save DATA");
		Title.setFont(new Font("Georgia", Font.PLAIN, 60));
		Title.setBounds(28, 145, 320, 102);
		panel.add(Title);
		
		ID = new JTextField();
		ID.setBounds(90, 301, 250, 45);
		panel.add(ID);
		ID.setColumns(10);
		
		JLabel ID_L = new JLabel("ID");
		ID_L.setFont(new Font("Georgia", Font.PLAIN, 30));
		ID_L.setBounds(28, 299, 50, 50);
		panel.add(ID_L);
		
		JLabel PW_L = new JLabel("PW");
		PW_L.setFont(new Font("Georgia", Font.PLAIN, 30));
		PW_L.setBounds(28, 354, 50, 50);
		panel.add(PW_L);
				
		JButton FG = new JButton("forgot ID/PW?");
		FG.setBackground(new Color(255, 255, 255));
		FG.setForeground(new Color(57, 52, 48));
		FG.setFont(new Font("Georgia", Font.PLAIN, 20));
		FG.setBounds(28, 544, 312, 23);
		panel.add(FG);
		
		JButton SignUP = new JButton("Sign UP");
		SignUP.setForeground(new Color(57, 52, 48));
		SignUP.setFont(new Font("Georgia", Font.PLAIN, 20));
		SignUP.setBackground(Color.WHITE);
		SignUP.setBounds(28, 577, 312, 23);
		panel.add(SignUP);
		
		PW = new JPasswordField();
		PW.setBounds(90, 356, 250, 45);
		
		panel.add(PW);

		// MAIN
		JPanel MAIN = new JPanel();
		MAIN.setSize(1380, 890);
		MAIN.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(MAIN);
		MAIN.setLayout(null);
		MAIN.setVisible(false);

		JLabel MAIN_L = new JLabel("Main Page");
		MAIN_L.setHorizontalAlignment(SwingConstants.CENTER);
		MAIN_L.setBounds(0, 0, 1380, 200);
		MAIN_L.setBackground(new Color(255, 255, 255));
		MAIN_L.setFont(new Font("Georgia", Font.PLAIN, 70));
		MAIN.add(MAIN_L);
		
		JLabel LNAME = new JLabel("Name");
		LNAME.setFont(new Font("Georgia", Font.PLAIN, 25));
		LNAME.setBackground(new Color(255, 255, 255));
		LNAME.setBounds(146, 245, 150, 50);
		MAIN.add(LNAME);
		
		name = new JTextField();
		name.setFont(new Font("Georgia", Font.PLAIN, 20));
		name.setBounds(308, 245, 300, 50);
		MAIN.add(name);
		name.setColumns(10);
		
		age = new JTextField();
		age.setFont(new Font("Georgia", Font.PLAIN, 20));
		age.setColumns(10);
		age.setBounds(308, 355, 300, 50);
		MAIN.add(age);
		
		JLabel LAge = new JLabel("Age");
		LAge.setFont(new Font("Georgia", Font.PLAIN, 25));
		LAge.setBackground(Color.WHITE);
		LAge.setBounds(146, 355, 150, 50);
		MAIN.add(LAge);
		
		JLabel LGen = new JLabel("Gender");
		LGen.setFont(new Font("Georgia", Font.PLAIN, 25));
		LGen.setBackground(Color.WHITE);
		LGen.setBounds(146, 466, 150, 50);
		MAIN.add(LGen);
		
		JLabel LNote = new JLabel("Note");
		LNote.setFont(new Font("Georgia", Font.PLAIN, 25));
		LNote.setBackground(Color.WHITE);
		LNote.setBounds(706, 466, 150, 50);
		MAIN.add(LNote);
		
		JLabel LPhone = new JLabel("Phone");
		LPhone.setFont(new Font("Georgia", Font.PLAIN, 25));
		LPhone.setBackground(Color.WHITE);
		LPhone.setBounds(706, 245, 150, 50);
		MAIN.add(LPhone);
		
		phone = new JTextField();
		phone.setFont(new Font("Georgia", Font.PLAIN, 20));
		phone.setColumns(10);
		phone.setBounds(868, 245, 300, 50);
		MAIN.add(phone);
		
		JLabel LBirthday = new JLabel("Birthday");
		LBirthday.setFont(new Font("Georgia", Font.PLAIN, 25));
		LBirthday.setBackground(Color.WHITE);
		LBirthday.setBounds(706, 355, 150, 50);
		MAIN.add(LBirthday);
		
		birthday = new JTextField();
		birthday.setFont(new Font("Georgia", Font.PLAIN, 20));
		birthday.setColumns(10);
		birthday.setBounds(868, 355, 300, 50);
		MAIN.add(birthday);
		
		JComboBox gender = new JComboBox(new String[] {"Male", "Female"});
		gender.setFont(new Font("Georgia", Font.PLAIN, 20));
		gender.setForeground(new Color(255, 255, 255));
		gender.setBackground(new Color(57, 52, 48));
		gender.setBounds(308, 466, 300, 50);
		MAIN.add(gender);
		
		JTextArea note = new JTextArea();
		note.setFont(new Font("Georgia", Font.PLAIN, 20));
		note.setForeground(new Color(57, 52, 48));
		note.setBackground(new Color(255, 255, 255));
		note.setBounds(868, 466, 300, 200);
		//note box 테두리
		note.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
		MAIN.add(note);
		
		JButton btnNewButton = new JButton("Done");
		btnNewButton.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent arg0) {
				String nameTxt = name.getText();
				String ageTxt = age.getText();
				String phoneTxt = phone.getText();
//				String birthdayTxt = birthday.getText();
				String genderTxt = gender.getSelectedItem().toString();
				String noteTxt = note.getText();
//				Customer customer = new Customer(nameTxt, ageTxt);
				// 입력받은 데이터 저장
		//		customer.createCustomer(nameTxt, phoneTxt, genderTxt, ageTxt, noteTxt);
				JOptionPane.showMessageDialog(null, "Your data has been saved successfully");
				// 버튼을 누르면 정보를 불러오는 페이지 (DB Table)을 보이도록 함
				MAIN.setVisible(false);
			}
		});
		
		btnNewButton.setBackground(new Color(57, 52, 48));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Georgia", Font.PLAIN, 20));
		btnNewButton.setBounds(146, 572, 91, 94);
		MAIN.add(btnNewButton);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBackground(new Color(255, 255, 255));
		chckbxNewCheckBox.setFont(new Font("Georgia", Font.PLAIN, 15));
		chckbxNewCheckBox.setBounds(259, 572, 349, 45);
		MAIN.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("");
		chckbxNewCheckBox_1.setBackground(new Color(255, 255, 255));
		chckbxNewCheckBox_1.setFont(new Font("Georgia", Font.PLAIN, 15));
		chckbxNewCheckBox_1.setBounds(259, 621, 349, 45);
		MAIN.add(chckbxNewCheckBox_1);

		frame.getContentPane().add(welcomePanel);
	//	welcomePanel.setLayout(null);

		JButton btn_sign_in = new JButton("Sign in");
		btn_sign_in.setBackground(new Color(255, 255, 255));
		btn_sign_in.setFont(new Font("Georgia", Font.PLAIN, 30));
		btn_sign_in.setBounds(28, 464, 312, 50);
		btn_sign_in.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (ID.getText().equals("ice") && Arrays.equals(PW.getPassword(), "hi".toCharArray())) {
					System.out.println("HI "+ID.getText());
					MAIN.setVisible(true);
					welcomePanel.setVisible(false);
					
				} else {
					JOptionPane.showMessageDialog(null,  "FAIL");
				}
			}
			
		});
		panel.add(btn_sign_in);
		

		frame.setJMenuBar(menuBar());
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	// 상단 메뉴 바
	public JMenuBar menuBar() {
		JMenuBar bar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu aboutMenu = new JMenu("About");
		
		bar.add(fileMenu);
		bar.add(aboutMenu);
		
		JMenuItem openFile = new JMenuItem("Open");
		JMenuItem exit = new JMenuItem("Exit");
		fileMenu.add(openFile);
		fileMenu.addSeparator();
		fileMenu.add(exit);
		
		// 종료 이벤트 추가
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		return bar;
	}
}

class ImagePanel extends JPanel {
	private Image img;
	
	public ImagePanel (Image img) {
		this.img = img;
		setSize (new Dimension(img.getWidth(null), img.getHeight(null)));
		setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setLayout(null);
	}
	
	public int getWidth() {
		return img.getWidth(null);
	}
	public int getHeight() {
		return img.getHeight(null);
	}
	
	public void paintComponent (Graphics g) {
		g.drawImage(img,  0, 0, null);
	}
}

