package pk;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;

import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import java.awt.Canvas;
import javax.swing.JTextArea;
import javax.swing.JTable;

public class App {
	
	private final String ID = "IB";
	private final String PW = "zxc";	

	private JFrame frame;
	private JTextField idfield;
	private JPasswordField pwfield;
	private JPanel currPanel;
	private JTextField NameInput;
	private JTextField AmountInput;
	private JTextField searchInput;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
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
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		TableData td = new TableData();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// error가 발생할 수 있어서 모두 위로 올림
		ImagePanel loginPanel = new ImagePanel(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\AccountingApp\\image\\green_simple.png").getImage());
		// 현재 패널은 로그인 패널
		currPanel = loginPanel;
		ImagePanel sumPanel = new ImagePanel(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\AccountingApp\\image\\panel_bgi_bagic.png").getImage());
		ImagePanel tranPanel = new ImagePanel(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\AccountingApp\\image\\panel_bgi_bagic.png").getImage());
		
		frame.setSize(new Dimension(1010, 595));
		frame.setPreferredSize(new Dimension(1010, 595));
		// Design에서 panel 드래그가 안돼서 불편함. 편집할 때 여기서 순서 바꿔서 하기
		frame.getContentPane().add(loginPanel);
		frame.getContentPane().add(sumPanel);
		frame.getContentPane().add(tranPanel);
		
		sumPanel.setVisible(false);
		tranPanel.setVisible(false);
		
		idfield = new JTextField();
		idfield.setBounds(756, 196, 210, 45);
		loginPanel.add(idfield);
		idfield.setColumns(10);
		idfield.setBorder(null);
		pwfield = new JPasswordField();
		pwfield.setBounds(756, 251, 210, 45);
		loginPanel.add(pwfield);
		pwfield.setBorder(null);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBounds(716, 322, 20, 20);
		loginPanel.add(chckbxNewCheckBox);
		
		JLabel rememb = new JLabel("Remember me?");
		rememb.setForeground(new Color(255, 255, 255));
		rememb.setHorizontalAlignment(SwingConstants.LEFT);
		rememb.setFont(new Font("Georgia", Font.PLAIN, 20));
		rememb.setBounds(740, 320, 150, 25);
		loginPanel.add(rememb);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\AccountingApp\\image\\id.png"));
		lblNewLabel.setBounds(714, 196, 42, 45);
		loginPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\AccountingApp\\image\\pw.png"));
		lblNewLabel_1.setBounds(714, 251, 42, 45);
		loginPanel.add(lblNewLabel_1);
		
		// 버튼 따로 관리 (코드가 길어지면)
		
		// Summary
		JButton susu = new JButton("");
		susu.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\AccountingApp\\image\\summary_ck.png"));
		susu.setBounds(17, 37, 230, 50);
		susu.setBorder(null);
		sumPanel.add(susu);
		
		JButton sutr = new JButton("");
		sutr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sumPanel.setVisible(false);
				tranPanel.setVisible(true);
				// 현재 패널은 sumPanel
				currPanel = tranPanel;
			}			
		});
		sutr.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\AccountingApp\\image\\Transactions.png"));
		sutr.setBounds(24, 87, 226, 50);
		sutr.setBorder(null);
		sumPanel.add(sutr);
		
		JLabel lblNewLabel_2 = new JLabel("Search");
		lblNewLabel_2.setFont(new Font("Georgia", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(313, 37, 110, 40);
		sumPanel.add(lblNewLabel_2);
		
		searchInput = new JTextField();
		searchInput.setBounds(423, 37, 534, 40);
		sumPanel.add(searchInput);
		searchInput.setColumns(10);
		
		JPanel TP = new JPanel();
		TP.setBounds(275, 103, 682, 397);
		sumPanel.add(TP);
//		TP.setLayout(null); // header를 위해 지움
		//scroll을 위해 설정		
		
		table = new JTable(td);
		table.setBounds(12, 10, 658, 377);
		table.setRowHeight(30);
		table.setFont(new Font("Georgia", Font.PLAIN, 20));
		table.setPreferredScrollableViewportSize(new Dimension(680, 350)); // 보면서 조절
//		TP.add(table);
		TP.add(new JScrollPane(table));
		TP.setOpaque(false); // 불필요한 테두리 제거

		// table에서 getTableHeader를 하기 위해 table보다 아래에 있어야 함
		JTableHeader header = table.getTableHeader();
		header.setBackground(new Color(49,63,32));
		header.setForeground(new Color(255,255,255));
		header.setFont(new Font("Georgia", Font.BOLD, 25));

		//filter 추가
		searchInput.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String search = searchInput.getText();
				// 행을 정리하는 클래스
				TableRowSorter<AbstractTableModel> trs = new TableRowSorter(td);
				table.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(search));
			}
		});
		
		// Transactions
		JButton trsu = new JButton("");
		trsu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sumPanel.setVisible(true);
				tranPanel.setVisible(false);				
				// 현재 패널은 sumPanel
				currPanel = sumPanel;
			}
			
		});
		trsu.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\AccountingApp\\image\\summary.png"));
		trsu.setBorder(null);
		trsu.setBounds(17, 37, 230, 50);
		tranPanel.add(trsu);
		
		JButton trtr = new JButton("");
		trtr.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\AccountingApp\\image\\Transactions_ck.png"));
		trtr.setBorder(null);
		trtr.setBounds(24, 87, 226, 50);
		tranPanel.add(trtr);		
		
		JLabel NameLabel = new JLabel("Name");
		NameLabel.setFont(new Font("Georgia", Font.PLAIN, 30));
		NameLabel.setBounds(300, 60, 131, 40);
		tranPanel.add(NameLabel);
		
		JLabel TypeLabel = new JLabel("Type");
		TypeLabel.setFont(new Font("Georgia", Font.PLAIN, 30));
		TypeLabel.setBounds(300, 150, 131, 40);
		tranPanel.add(TypeLabel);
		
		JLabel AmountLabel = new JLabel("Amount");
		AmountLabel.setFont(new Font("Georgia", Font.PLAIN, 30));
		AmountLabel.setBounds(300, 240, 131, 40);
		tranPanel.add(AmountLabel);
		
		JLabel NoteLabel = new JLabel("Note");
		NoteLabel.setFont(new Font("Georgia", Font.PLAIN, 30));
		NoteLabel.setBounds(300, 330, 131, 40);
		tranPanel.add(NoteLabel);
		
		NameInput = new JTextField();
		NameInput.setFont(new Font("Georgia", Font.PLAIN, 26));
		NameInput.setBounds(437, 60, 500, 40);
		tranPanel.add(NameInput);
		NameInput.setColumns(10);
		
		AmountInput = new JTextField();
		AmountInput.setFont(new Font("Georgia", Font.PLAIN, 26));
		AmountInput.setColumns(10);
		AmountInput.setBounds(437, 240, 500, 40);
		tranPanel.add(AmountInput);
		
		String[] typeArr = new String[] {"Deposit", "Withdraw"};
		JComboBox TypeInput = new JComboBox(typeArr);
		TypeInput.setFont(new Font("Georgia", Font.PLAIN, 26));
		TypeInput.setBounds(437, 150, 500, 40);
		tranPanel.add(TypeInput);
		TypeInput.setBackground(Color.white);
		
		JTextArea NoteInput = new JTextArea();
		NoteInput.setFont(new Font("Georgia", Font.PLAIN, 26));
		NoteInput.setBounds(437, 330, 500, 128);
		tranPanel.add(NoteInput);
		NoteInput.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JButton btn_submit = new JButton("SUBMIT");
		btn_submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// 이 파일이 어떤 문제가 있을지 모르기 때문에
				try {
					/*
					SUBMIT 버튼을 누르면 데이터가 저장되도록 해야 하는데
					FileWriter의 두 번째 인수가 false라면 SUBMIT 버튼을 눌렀을 때 새로운 데이터만 저장되고 이전 데이터는 사라짐
										    true : 새로운 데이터가 추가 될 때 이전 데이터를 지우지 않음
					버튼을 누르면 data.csv 파일에 저장됨 (AcountApp 파일)
					엑셀로 열어볼 수 있음
					 */
					// 파일이 존재한지 확인하기 위해서  파일이 존재할 경우 true return
					boolean fileExists = new File("./data.csv").exists();
					FileWriter fw = new FileWriter("./data.csv", true);
					if (!fileExists) {
						// 파일을 처음 생성하는 경우에만 header 추가
						fw.append("Name, Type, Amount, Note\n");
					}
					String name = NameInput.getText();
					String type = (String) TypeInput.getSelectedItem();
					String amount = AmountInput.getText();
					String note = NoteInput.getText();
					fw.append(name + "," + type + "," + amount +","+note+"\n");
					NameInput.setText("");
					AmountInput.setText("");
					TypeInput.setSelectedIndex(0);
					NoteInput.setText("");
					JOptionPane.showMessageDialog(null, "Data Saved Successfully");
					fw.close();
					td.refresh(); // 자동 업데이트
				} catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "There was an erorr while writing the data.");
				}

				
			}
			
		});
		btn_submit.setFont(new Font("Georgia", Font.PLAIN, 30));
		btn_submit.setBounds(711, 485, 226, 40);
		tranPanel.add(btn_submit);

		// loginPanel
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(ID.equals(idfield.getText()) && PW.equals(pwfield.getText())) {
					loginPanel.setVisible(false);
					sumPanel.setVisible(true);
					// 현재 패널은 sumPanel
					currPanel = sumPanel;
					JOptionPane.showMessageDialog(null, "You are logged in!");
					loginPanel.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "FAIL..");
				}
			}
		});
		btnNewButton.setBorder(null);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\AccountingApp\\image\\btn_sign.png"));
		btnNewButton.setPressedIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\AccountingApp\\image\\btn_sign_ck.png"));
		btnNewButton.setBounds(716, 351, 250, 40);
		loginPanel.add(btnNewButton);
		
		frame.pack();
	}
}
