package Lock;

public class BankAccount {

	private double balance;
	
	public BankAccount(double balance) {
		this.balance = balance;
	}
	
	
	public double getBalance() {
		return balance;
	}
	
	
	public void deposit(double amount) {
		double temp = balance + amount;
		try {
			Thread.sleep(400);			
		}catch (InterruptedException e) {			
			System.err.println(e.getMessage());
		}
		
		System.out.println("After deposit, balance is $ " + temp);
		balance = temp;
	}
	
	
	public void withdraw(double amount) {
		if (balance < amount) {
			System.out.println("Insufficient funds!");
			return;
		}
		double temp = balance - amount;
		try {
			Thread.sleep(300);
		}catch (InterruptedException e) {			
			System.err.println(e.getMessage());
		}
		
		System.out.println("After withdrawl, balance is $" + temp);
		balance = temp;
	}
}
