//LCK07-J. Avoid deadlock by requesting and releasing locks in the same order

public class AvoidDeadlock {
	final class BankAccount {
  	private double balanceAmount;  // Total amount in bank account
  	private static final Object lock = new Object();
 
  	BankAccount(double balance) {
    		this.balanceAmount = balance;
	}
 
	  // Deposits the amount from this object instance
	  // to BankAccount instance argument ba
	private void depositAmount(BankAccount ba, double amount) {
		synchronized (lock) {
			if (amount > balanceAmount) {
				throw new IllegalArgumentException("Transfer cannot be completed");
      			}
      		ba.balanceAmount += amount;
      		this.balanceAmount -= amount;
    		}
  	}
 
  	public static void initiateTransfer(final BankAccount first,final BankAccount second, final double amount) {
 
    		Thread transfer = new Thread(new Runnable() {
        	@Override public void run() {
         		first.depositAmount(second, amount);
        	}
    		});
    	transfer.start();
  	}
	}
}	
