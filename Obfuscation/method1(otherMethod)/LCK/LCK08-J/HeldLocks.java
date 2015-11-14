//LCK08-J. Ensure actively held locks are released on exceptional conditions

import java.io.*;
import java.util.concurrent.locks.*;

public class HeldLocks {
	public final class Client {

		private void anotherMethod(Lock lock1){
			lock1.lock();
		}
		public void doSomething(File file) {
			final Lock lock = new ReentrantLock();
		    	InputStream in = null;
	
				try {
					anotherMethod(lock);
			      		in = new FileInputStream(file);
			      		lock.unlock();
			    	} catch (FileNotFoundException x) {
			    	} finally {
			      		if (in != null) {
			       			try {
			          			in.close();
			        		} catch (IOException x) {} 
			      		}	
			}
		}
	}
}

