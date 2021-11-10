package Monitor;

public class Withdrawal extends Thread{

	private BankAccount account;
	
	public Withdrawal(BankAccount account) {
		this.account = account;
	}
	
	
	public void run() {
		for (int i = 0; i < 5; i++) {
			account.withdraw(10);
		}
	}
}
