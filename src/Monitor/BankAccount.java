package Monitor;

public class BankAccount {

	private double balance;
	
	public BankAccount(double balance) {
		this.balance = balance;
	}
	
	
	// lock
	public synchronized double getBalance() {
		return balance;
	}
	
	
	// lock with notification
	// notify one of the withdrawal threads after each deposit 
	public synchronized void deposit(double amount) {
		double temp = balance + amount;
		
		try {
			Thread.sleep(400);
		}catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
		
		System.out.println("After deposit, balance is $" + temp);
		balance = temp;
		notify();
	}
	
	
	// lock with notification
	// withdrawal thread waits for sufficient funds
	public synchronized void withdraw(double amount) {
		while (balance < amount) {
			try {
				wait();
			}catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}
		}
		
		double temp = balance - amount;
		
		try {
			Thread.sleep(300);
		}catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
		
		System.out.println("After withdrawal, balance is $" + temp);
		balance = temp;
	}
}
