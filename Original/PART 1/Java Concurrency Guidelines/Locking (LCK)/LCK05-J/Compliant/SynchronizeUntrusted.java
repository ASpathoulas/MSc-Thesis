//LCK05-J. Synchronize access to static fields that can be modified by untrusted code


public final class SynchronizeUntrusted {
	private static int counter;
	private static final Object lock = new Object();
 
	public void incrementCounter() {
	    synchronized (lock) {
	      counter++;
    	}
  }
	}
