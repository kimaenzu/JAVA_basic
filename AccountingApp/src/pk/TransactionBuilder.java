package pk;
// Transaction data를 코딩할 때 더 깔끔하게 도와주는 역할
public class TransactionBuilder {
	private Transaction t;
	public TransactionBuilder(Transaction t) {
		this.t = t;
	}
	
	public TransactionBuilder name(String name) {
		t.setName(name);
		return this;
	}
	
	public TransactionBuilder type(String type) {
		t.setType(type);
		return this;
	}
	
	public TransactionBuilder amount(double amount) {
		t.setAmount(amount);
		return this;
	}
	
	public TransactionBuilder note(String note) {
		t.setNote(note);
		return this;
	}
	
	public Transaction transaction() {
		return t;
	}
	
	

}
