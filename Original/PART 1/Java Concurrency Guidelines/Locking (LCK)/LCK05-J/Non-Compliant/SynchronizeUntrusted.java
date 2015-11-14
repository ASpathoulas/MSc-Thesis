//LCK05-J. Synchronize access to static fields that can be modified by untrusted code


public final class SynchronizeUntrusted {
	  private static int counter;
	 
	  public void incrementCounter() {
	    counter++;
	  }
	}
