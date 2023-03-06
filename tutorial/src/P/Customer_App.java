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

	public Customer_App() {
		initialize();
	}

	private void initialize() {
		
		Customer customer = new Customer();
		
		// frame
		frame = new JFrame();
		
		// MAIN (오류 때문에 위에)
		ImagePanel MAIN = new ImagePanel(new ImageIcon("C:/Users/user/eclipse-workspace/WB/image/bgi_list.png").getImage());

		// Table_P
		ImagePanel Table_P = new ImagePanel(new ImageIcon("C:/Users/user/eclipse-workspace/WB/image/bgi_list.png").getImage());
		Table_P.setBounds(0, 0, 1388, 822);
/*
가장 안쪽에 있는 페이지 : Table_P
가장 바깥쪽에 있는 페이지 : welcomePanel
사용자가 접근하는 순서대로 판넬을 생성하고 작업하기 때문에 window builder를 쉽게 사용하기 위해서 코드를 위쪽에 추가한다.
다시 사용 순서대로 보기 위해선 setVisible을 false로 해준다.
 */
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
		scrollPane.setBounds(434, 114, 942, 698);
		Table_P.add(scrollPane);
		
		JButton btn_register_L = new JButton("");
		btn_register_L.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\WB\\image\\btn_register.png"));
		btn_register_L.setBorder(BorderFactory.createEmptyBorder());
		btn_register_L.setFont(new Font("Georgia", Font.PLAIN, 30));
		btn_register_L.setBounds(150, 292, 274, 70);
		btn_register_L.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Table_P.setVisible(false);
				MAIN.setVisible(true);
			}
		});
		Table_P.add(btn_register_L);
		
		JButton btn_list_L = new JButton("");
		btn_list_L.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\WB\\image\\btn_list_click.png"));
		btn_list_L.setBorder(BorderFactory.createEmptyBorder());
		btn_list_L.setFont(new Font("Georgia", Font.PLAIN, 30));
		btn_list_L.setBounds(150, 369, 274, 70);
		Table_P.add(btn_list_L);


		
		frame.getContentPane().add(Table_P);
		
		search = new JTextField();
		search.setFont(new Font("Georgia", Font.PLAIN, 38));
		search.setBounds(434, 34, 942, 70);
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
		
		JPanel wel_ = new JPanel();
		wel_.setBackground(new Color(255, 255, 255));
		wel_.setBounds(959, 0, 429, 895);
		welcomePanel.add(wel_);
		wel_.setLayout(null);
		
		JLabel Title = new JLabel("Save DATA");
		Title.setFont(new Font("Georgia", Font.PLAIN, 60));
		Title.setBounds(28, 145, 320, 102);
		wel_.add(Title);
		
		ID = new JTextField();
		ID.setBounds(90, 301, 250, 45);
		wel_.add(ID);
		ID.setColumns(10);
		
		JLabel ID_L = new JLabel("ID");
		ID_L.setFont(new Font("Georgia", Font.PLAIN, 30));
		ID_L.setBounds(28, 299, 50, 50);
		wel_.add(ID_L);
		
		JLabel PW_L = new JLabel("PW");
		PW_L.setFont(new Font("Georgia", Font.PLAIN, 30));
		PW_L.setBounds(28, 354, 50, 50);
		wel_.add(PW_L);
				
		JButton FG = new JButton("forgot ID/PW?");
		FG.setBackground(new Color(255, 255, 255));
		FG.setBorder(BorderFactory.createEmptyBorder());
		FG.setForeground(new Color(57, 52, 48));
		FG.setFont(new Font("Georgia", Font.PLAIN, 20));
		FG.setBounds(28, 544, 312, 23);
		wel_.add(FG);
		
		JButton SignUP = new JButton("Sign UP");
		SignUP.setBorder(BorderFactory.createEmptyBorder());
		SignUP.setForeground(new Color(57, 52, 48));
		SignUP.setFont(new Font("Georgia", Font.PLAIN, 20));
		SignUP.setBackground(Color.WHITE);
		SignUP.setBounds(28, 577, 312, 23);
		wel_.add(SignUP);
		
		PW = new JPasswordField();
		PW.setBounds(90, 356, 250, 45);
		
		wel_.add(PW);

		// MAIN
	//	ImagePanel MAIN = new ImagePanel(new ImageIcon("C:/Users/user/eclipse-workspace/WB/image/bgi_list.png").getImage());
		MAIN.setSize(1380, 890);
		MAIN.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(MAIN);
		MAIN.setLayout(null);
		MAIN.setVisible(false);
		
		JLabel LNAME = new JLabel("Name");
		LNAME.setFont(new Font("Georgia", Font.PLAIN, 25));
		LNAME.setBackground(new Color(255, 255, 255));
		LNAME.setBounds(450, 150, 150, 50);
		MAIN.add(LNAME);
		
		name = new JTextField();
		name.setFont(new Font("Georgia", Font.PLAIN, 20));
		name.setBounds(615, 150, 300, 50);
		MAIN.add(name);
		name.setColumns(10);
		
		age = new JTextField();
		age.setFont(new Font("Georgia", Font.PLAIN, 20));
		age.setColumns(10);
		age.setBounds(615, 450, 300, 50);
		MAIN.add(age);
		
		JLabel LAge = new JLabel("Age");
		LAge.setFont(new Font("Georgia", Font.PLAIN, 25));
		LAge.setBackground(Color.WHITE);
		LAge.setBounds(450, 450, 150, 50);
		MAIN.add(LAge);
		
		JLabel LGen = new JLabel("Gender");
		LGen.setFont(new Font("Georgia", Font.PLAIN, 25));
		LGen.setBackground(Color.WHITE);
		LGen.setBounds(450, 550, 150, 50);
		MAIN.add(LGen);
		
		JLabel LNote = new JLabel("Note");
		LNote.setFont(new Font("Georgia", Font.PLAIN, 25));
		LNote.setBackground(Color.WHITE);
		LNote.setBounds(980, 150, 150, 50);
		MAIN.add(LNote);
		
		JLabel LPhone = new JLabel("Phone");
		LPhone.setFont(new Font("Georgia", Font.PLAIN, 25));
		LPhone.setBackground(Color.WHITE);
		LPhone.setBounds(450, 250, 150, 50);
		MAIN.add(LPhone);
		
		phone = new JTextField();
		phone.setFont(new Font("Georgia", Font.PLAIN, 20));
		phone.setColumns(10);
		phone.setBounds(615, 250, 300, 50);
		MAIN.add(phone);
		
		JLabel LBirthday = new JLabel("Birthday");
		LBirthday.setFont(new Font("Georgia", Font.PLAIN, 25));
		LBirthday.setBackground(Color.WHITE);
		LBirthday.setBounds(450, 350, 150, 50);
		MAIN.add(LBirthday);
		
		birthday = new JTextField();
		birthday.setFont(new Font("Georgia", Font.PLAIN, 20));
		birthday.setColumns(10);
		birthday.setBounds(615, 350, 300, 50);
		MAIN.add(birthday);
		
		JComboBox gender = new JComboBox(new String[] {"Male", "Female"});
		gender.setFont(new Font("Georgia", Font.PLAIN, 20));
		gender.setForeground(new Color(255, 255, 255));
		gender.setBackground(new Color(57, 52, 48));
		gender.setBounds(615, 550, 300, 50);
		MAIN.add(gender);
		
		JTextArea note = new JTextArea();
		note.setFont(new Font("Georgia", Font.PLAIN, 20));
		note.setForeground(new Color(57, 52, 48));
		note.setBackground(new Color(255, 255, 255));
		note.setBounds(980, 218, 360, 382);
		//note box 테두리
		note.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
		MAIN.add(note);
		
		JButton btn_done = new JButton("Done");
		btn_done.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\WB\\image\\btn_done.png"));
		//note box 테두리
		btn_done.setBorder(BorderFactory.createEmptyBorder());

		btn_done.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent arg0) {
				String nameTxt = name.getText();
				String ageTxt = age.getText();
				String phoneTxt = phone.getText();
//				String birthdayTxt = birthday.getText();
				String genderTxt = gender.getSelectedItem().toString();
				String noteTxt = note.getText();
				Customer customer = new Customer();
				// 입력받은 데이터 저장
				customer.createCustomer(nameTxt, phoneTxt, genderTxt, ageTxt, noteTxt);
				JOptionPane.showMessageDialog(null, "Your data has been saved successfully");
				// 버튼을 누르면 정보를 불러오는 페이지 (DB Table)을 보이도록 함
				MAIN.setVisible(false);
				Table_P.setVisible(true);

			}
		});
		
		btn_done.setBackground(new Color(57, 52, 48));
		btn_done.setForeground(new Color(255, 255, 255));
		btn_done.setFont(new Font("Georgia", Font.PLAIN, 20));
		btn_done.setBounds(980, 647, 360, 94);
		MAIN.add(btn_done);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("I agree ..");
		chckbxNewCheckBox.setBackground(new Color(255, 255, 255));
		chckbxNewCheckBox.setFont(new Font("Georgia", Font.PLAIN, 15));
		chckbxNewCheckBox.setBounds(450, 650, 349, 45);
		MAIN.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("I agree ..");
		chckbxNewCheckBox_1.setBackground(new Color(255, 255, 255));
		chckbxNewCheckBox_1.setFont(new Font("Georgia", Font.PLAIN, 15));
		chckbxNewCheckBox_1.setBounds(450, 696, 349, 45);
		MAIN.add(chckbxNewCheckBox_1);
		
		JButton btn_register = new JButton("");
		btn_register.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\WB\\image\\btn_register_click.png"));
		btn_register.setBorder(BorderFactory.createEmptyBorder());
		btn_register.setFont(new Font("Georgia", Font.PLAIN, 30));
		btn_register.setBounds(150, 292, 274, 70);
		MAIN.add(btn_register);
		
		JButton btn_list = new JButton("");
		btn_list.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MAIN.setVisible(false);
				Table_P.setVisible(true);
			}
		});
		btn_list.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\WB\\image\\btn_list.png"));
		btn_list.setBorder(BorderFactory.createEmptyBorder());
		btn_list.setFont(new Font("Georgia", Font.PLAIN, 30));
		btn_list.setBounds(150, 369, 274, 70);
		MAIN.add(btn_list);

		frame.getContentPane().add(welcomePanel);
	//	welcomePanel.setLayout(null);

		JButton btn_sign_in = new JButton("Sign in");
		btn_sign_in.setBackground(new Color(255, 255, 255));
		btn_sign_in.setFont(new Font("Georgia", Font.PLAIN, 30));
		btn_sign_in.setBorder(BorderFactory.createEmptyBorder());
		btn_sign_in.setBounds(28, 464, 312, 50);
		btn_sign_in.addActionListener(new ActionListener() {
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
		wel_.add(btn_sign_in);
		

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

