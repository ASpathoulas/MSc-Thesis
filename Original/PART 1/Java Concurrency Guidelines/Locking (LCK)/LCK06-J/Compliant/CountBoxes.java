//LCK06-J. Do not use an instance lock to protect shared static data


public class CountBoxes implements Runnable {
	private static int counter;
	// ...
	private static final Object lock = new Object();
 
	public void run() {
		synchronized (lock) {
	  	      counter++;
	      // ...
	    }
	  }
  // ...
}
