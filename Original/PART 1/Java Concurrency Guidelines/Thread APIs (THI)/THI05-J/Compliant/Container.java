//THI05-J. Do not use Thread.stop() to terminate threads

import java.util.*;

public final class Container implements Runnable {
	private final Vector<Integer> vector = new Vector<Integer>(1000);
 
  	public Vector<Integer> getVector() {
    		return vector;
  	}
 
  	@Override public synchronized void run() {
    		Random number = new Random(123L);
    		int i = vector.capacity();
    		while (!Thread.interrupted() && i > 0) {
      			vector.add(number.nextInt(100));
      			i--;
    		}
  	}
 
 	public static void main(String[] args) throws InterruptedException {
    		Container c = new Container();
    		Thread thread = new Thread(c);
    		thread.start();
    		Thread.sleep(5000);
    		thread.interrupt();
  	}
}
