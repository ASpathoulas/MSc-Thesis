//LCK00-J. Use private final lock objects to synchronize classes that may interact with untrusted code
package locking;

public class SomeObject implements Runnable {
	// changeValue locks on the class object's monitor
	
	private int flag=0;
	public static synchronized void changeValue() {
		System.out.println("In changeValue()");
	}
	
	public void acquireLock(){
	// Untrusted code
		synchronized (SomeObject.class) {
			if(flag==0){
				try {Thread.sleep(Integer.MAX_VALUE);} 
				catch (InterruptedException e) {e.printStackTrace();}// Indefinitely delay someObject
			}
			else{
				try {Thread.sleep(Integer.MAX_VALUE);} 
				catch (InterruptedException e) {e.printStackTrace();}// Indefinitely delay someObject
			}
		} 
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}

