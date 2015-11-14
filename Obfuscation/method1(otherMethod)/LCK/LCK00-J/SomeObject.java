//LCK00-J. Use private final lock objects to synchronize classes that may interact with untrusted code

public class SomeObject implements Runnable {
	// changeValue locks on the class object's monitor
	
	private int flag=0;
	public static synchronized void changeValue() {
		System.out.println("In changeValue()");
	}

	private void otherMethod(){
		try {Thread.sleep(Integer.MAX_VALUE);} 
		catch (InterruptedException e) {e.printStackTrace();}
	}

	public void acquireLock(){
	// Untrusted code
		synchronized (SomeObject.class) {
			otherMethod();
			
		} 
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}

