package Monitor;

public class Bank {

	public static void main(String[] args) {
		int numThreads = 4;
		Thread[] threads = new Thread[numThreads];
		
		BankAccount account = new BankAccount(0);
		threads[0] = new Deposit(account);
		for (int i = 1; i < numThreads; i++) {
			threads[i] = new Withdrawal(account);
		}
		
		for (int i = 0; i < numThreads; i++) {
			threads[i].start();
		}
		
		
		for (int i = 0; i <numThreads; i++) {
			try {
				threads[i].join();
			}catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}finally {
				System.out.println("Thread " + i + " has died");
			}
		}
		
		System.out.println("Closing balance is $" + account.getBalance());
	}
}
