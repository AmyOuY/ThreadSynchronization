package Monitor;

public class Deposit extends Thread{

	private BankAccount account;
	
	public Deposit(BankAccount account) {
		this.account = account;
	}
	
	
	public void run() {
		for (int i = 0; i < 15; i++) {
			account.deposit(10);
		}		
	}
}
