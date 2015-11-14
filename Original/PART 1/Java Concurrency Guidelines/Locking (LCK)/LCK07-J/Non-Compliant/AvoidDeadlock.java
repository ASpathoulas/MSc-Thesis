//LCK07-J. Avoid deadlock by requesting and releasing locks in the same order

public class AvoidDeadlock {
	final class BankAccount {
		  private double balanceAmount;  // Total amount in bank account
		 
		  BankAccount(double balance) {
		    this.balanceAmount = balance;
		  }
		 
		  // Deposits the amount from this object instance
		  // to BankAccount instance argument ba
		  private void depositAmount(BankAccount ba, double amount) {
		    synchronized (this) {
		      synchronized (ba) {
		        if (amount > balanceAmount) {
		          throw new IllegalArgumentException(
		               "Transfer cannot be completed"
		          );
		        }
		        ba.balanceAmount += amount;
		        this.balanceAmount -= amount;
		      }
		    }
		  }
		 
		  public void initiateTransfer(final BankAccount first,
		    final BankAccount second, final double amount) {
		 
		    Thread transfer = new Thread(new Runnable() {
		        public void run() {
		          first.depositAmount(second, amount);
		        }
		    });
		    transfer.start();
		  }
		}
}
