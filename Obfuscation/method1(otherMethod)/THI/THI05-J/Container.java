//THI05-J. Do not use Thread.stop() to terminate threads

import java.util.*;

public final class Container implements Runnable {
	private final Vector<Integer> vector = new Vector<Integer>(1000);

	public Vector<Integer> getVector() {
		return vector;
	}
	
	private void otherMethod(){
		int i = vector.capacity();
			while (i > 0) {
					vector.add(number.nextInt(100));
					i--;
			}
	}

	@Override 
	public synchronized void run() {
		Random number = new Random(123L);
		otherMethod();
			

			
	}


	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new Container());
		thread.start();
		Thread.sleep(5000);
		thread.stop();
	}
}
