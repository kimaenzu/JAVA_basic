package pk;
// 데이터를 기록하는 객체
public class Transaction {
	private String name;
	private String type;
	private double amount;
	private String note;
/*
 * TransactionBuilder를 사용하기 때문에 지움	
	// Ctrl + Shift + S : Generate Constructor using Fields
	public Transaction(String name, String type, double amount, String note) {
		super();
		this.name = name;
		this.type = type;
		this.amount = amount;
		this.note = note;
	}
*/
	// Ctrl + Shift + S : Generate Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	// Ctrl + Shift + S : Generate toString()...
	public String toString() {
		return "Transaction [name=" + name + ", type=" + type + ", amount=" + amount + ", note=" + note + "]";
	}
	

}
