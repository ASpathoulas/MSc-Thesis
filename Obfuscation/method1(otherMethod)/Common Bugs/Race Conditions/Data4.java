//BankAccount

import java.util.Random;

class BankAccount {
     protected int balance;

     // Instances of this class represent bank accounts
     // The three public methods are all synchronised correctly

     public BankAccount(int initial_balance) {
         if (initial_balance < 0)
             throw new IllegalArgumentException("Balance must be greater than 0");

         this.balance = initial_balance;
     }

     public synchronized int getBalance () {
         return balance;
      
     }

     public synchronized void credit(int increment) {
//         balance += increment;
	otherMethod(increment);
     }
	private void otherMethod(int myInt){
		balance+=myInt;
	}

     public synchronized boolean debit(int decrement) {
         if (balance < decrement)
             return false;

         balance -= decrement;

         return true;
     }
}

class BonusAccount extends BankAccount {
     private int bonus;

     // This subclass of BankAccount represents accounts where
     // a fixed bonus can be added.
     //
     // The applyBonus method here is incorrectly synchronised, breaking the
     // design used in the parent class

     public BonusAccount(int initial_balance, int bonus) {
         super(initial_balance);
         this.bonus = bonus;
     }

     public void applyBonus() {
         balance += bonus;
     }
}

public class Data4 {
     // This thread loops for 10000 iterations, applying the account's bonus
     private static class BonusAdder extends Thread {
         private BonusAccount account;

         public BonusAdder (BonusAccount account) {
             this.account = account;
         }

         public void run() {
             Random rng = new Random();

             try {
                 for (int i = 0; i < 10000; i++) {
                     account.applyBonus();
                     Thread.sleep(rng.nextInt(5));
                 }
                     } catch (InterruptedException e) {
                 // do nothing
             }
         }
     }

     // This thread loops for 10000 iterations, applying credits to the account
     private static class BalanceIncrementer extends Thread {
         private BankAccount account;
         private int credit_amount;

         public BalanceIncrementer (BankAccount account, int credit_amount) {
             this.account = account;
             this.credit_amount = credit_amount;
         }

         public void run () {
             Random rng = new Random ();

             try {
                 for (int i = 0; i < 10000; i++) {
                     account.credit (credit_amount);
                      Thread.sleep(rng.nextInt(5));
                 }
                     } catch (InterruptedException e) {
                 // do nothing
             }
         }
     }


     public static void main(String[] args) {
         // Create a bank account with several threads accessing it
         // Idea is to try and provoke a race condition

         // Create a new bonus account with a periodic bonus of 5
         BonusAccount account = new BonusAccount (0, 5);

         // Create three threads, all incrementing the account
         Thread t1 = new BalanceIncrementer(account, 5);
         Thread t2 = new BonusAdder(account);
         Thread t3 = new BonusAdder(account);

         // Set them running
         t1.start ();
         t2.start ();
         t3.start ();

         // Wait until they finish
         try {
             t1.join ();
             t2.join ();
             t3.join ();
         } catch (InterruptedException e) {
             // do nothing
         }

         // Print out the results:
         // - computed result by the incrementing threads
         // - the expected results given the increments we have given
         // Sometimes, these will be different due to the unsynchronised access in BonusAccount
         int computed = account.getBalance ();
         int expected = 10000*(5+5+5);
         System.out.println ("Computed Balance = " + computed);
         System.out.println ("Expected Balance = " + expected);
         System.out.println ("Error = " + 100.0*(expected-computed)/expected + "%");
         System.out.println ((expected-computed)/5 + " races out of 30000 accesses");
     }

}
