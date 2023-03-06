package pk;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.table.AbstractTableModel;

public class TableData extends AbstractTableModel {
	private List<Transaction> list;
	//header 이름 지정
	private String[] headers = {"Name","Type","Amount","Note"};
	public TableData() {
		updateList();
	}
	
	public String getColumnName(int cell) {
		return headers[cell];
	}
	// 만약 앱 실행시, Transaction에서 추가 후 summary에 갔을 때 업데이트가 되게 하기 위해서
	public void updateList() {
		list = new ArrayList<>();
		try {
			Scanner sc = new Scanner(new File("./data.csv"));	
			// 첫 번째 라인은 읽지 않도록 while이 아닌 for 루프를 사용
			for(int i=0; sc.hasNextLine(); i++) {
				String[] data = sc.nextLine().split(",");
				if (i!=0) {
				Transaction t = new Transaction();
				TransactionBuilder tb = new TransactionBuilder(t);
				t = tb
						.name(data[0])
						.type(data[1])
						.amount(Double.parseDouble(data[2]))
						.note(data[3])
						.transaction();
//				Transaction t = new Transaction(data[0],data[1],Double.parseDouble(data[2]),data[3]);
				list.add(t);
//				System.out.print(sc.nextLine());
				}
			}
			sc.close(); // scanner close
		}catch(Exception e) {
			e.printStackTrace();
		}
		for(Transaction t: list) {
			System.out.println(t);
		}
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public Object getValueAt(int row, int cell) {
		switch(cell) {
		case 0:
			return list.get(row).getName();
		case 1:
			return list.get(row).getType();
		case 2:
			return list.get(row).getAmount();
		case 3:
			return list.get(row).getNote();
		}
		return null;
	}
	
	// 자동 업데이트
	public void refresh() {
		updateList();
		super.fireTableDataChanged();
	}

}
