//VNA02-J. Ensure that compound operations on shared variables are atomic

import java.util.concurrent.atomic.AtomicInteger;

public class EnsureOperation {
	
	final class Flag {
  		private boolean flag = true;
 
  		public synchronized void toggle() {
    			flag ^= true; // Same as flag = !flag;
  		}
 
  	public synchronized boolean getFlag() {
    		return flag;
  	}
}
final class Adder {
	  private int a;
	  private int b;
	 
	  public int getSum() {
	    return a + b;
	  }
	 
	  public void setValues(int a, int b) {
	    this.a = a;
	    this.b = b;
	  }
	}
}
	

