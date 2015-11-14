//VNA02-J. Ensure that compound operations on shared variables are atomic

import java.util.concurrent.atomic.AtomicInteger;

public class EnsureOperation {
	
	final class Flag {
		  private volatile boolean flag = true;
		 
		  public void toggle() {  // Unsafe
		    flag ^= true;
		  }
		 
		  public boolean getFlag() { // Safe
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
	

