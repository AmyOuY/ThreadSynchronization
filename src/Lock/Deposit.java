package Lock;

public class Deposit extends Thread{

	private BankAccount account;
	
	
	public Deposit(BankAccount account) {
		this.account = account;
	}
	
	
//	public void run() {
//		for (int i = 0; i < 5; i ++) {
//			// current thread attempts to hold an object's lock by using a synchronization block
//			synchronized(account) {account.deposit(10);}
//		}
//	}
	
		
	
	// lock with notification
	// notify one of the withdrawal threads after each deposit
	public void run() {
		for (int i = 0; i < 15; i++) {
			synchronized(account) {
				account.deposit(10);
				account.notify();
			}
		}
	}
		
}
