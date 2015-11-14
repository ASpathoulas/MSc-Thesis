//LCK03-J. Do not synchronize on the intrinsic locks of high-level concurrency objects

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class IntrinsicLocks{	 
	private final Lock lock = new ReentrantLock();
	
	public void doSomething() {

			synchronized(lock) {
				System.out.println("didSomething");
			}

		}
}

