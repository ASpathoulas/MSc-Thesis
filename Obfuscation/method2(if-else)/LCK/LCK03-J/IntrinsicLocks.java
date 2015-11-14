//LCK03-J. Do not synchronize on the intrinsic locks of high-level concurrency objects

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class IntrinsicLocks{	 
	private final Lock lock = new ReentrantLock();
	private int flag=0;
	
	public void doSomething() {
		if(flag==0){
			synchronized(lock) {
				System.out.println("didSomething");
			}
		}
		else{
			synchronized(lock) {
				System.out.println("didSomething");
			}
		}
}
}
