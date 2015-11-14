//LCK00-J. Use private final lock objects to synchronize classes that may interact with untrusted code

public class SomeObject implements Runnable {
	// changeValue locks on the class object's monitor
	
	public static synchronized void changeValue() {
		System.out.println("In changeValue()");
	}
	
	public void acquireLock(){
	// Untrusted code
		synchronized (SomeObject.class) {

				try {Thread.sleep(Integer.MAX_VALUE);} 
				catch (InterruptedException e) {e.printStackTrace();}// Indefinitely delay someObject
		} 
	}
	@Override
	public void run() {
		
	}
}
