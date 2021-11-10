package Lock;

public class Withdrawal extends Thread{

	private BankAccount account;
	
	public Withdrawal(BankAccount account) {
		this.account = account;
	}
	
	
//	public void run() {
//		for (int i = 0; i < 5; i++) {
//			// current thread attempts to hold an object's lock by using a synchronization block
//			synchronized(account) {account.withdraw(10);}
//		}
//	}
	
	
	
	// lock with notification
	// withdrawal thread waits for sufficient funds
	public void run() {
		for (int i = 0; i < 5; i++) {
			synchronized(account) {
				while (account.getBalance() < 10) {
					try {
						account.wait();
					}catch (InterruptedException e) {
						System.err.println(e.getMessage());
					}
				}
				account.withdraw(10);
			}
		}
	}
	
}
