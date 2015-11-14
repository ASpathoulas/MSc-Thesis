//LCK08-J. Ensure actively held locks are released on exceptional conditions

import java.io.*;
import java.util.concurrent.locks.*;

public class HeldLocks {
	public final class Client {
  		public void doSomething(File file) {
    			final Lock lock = new ReentrantLock();
			InputStream in = null;
			lock.lock();
    		try {
      			in = new FileInputStream(file);
		        // Perform operations on the open file
    		} catch (FileNotFoundException fnf) {
      // Forward to handler
    		} finally {
      			lock.unlock();
 
      		if (in != null) {
        		try {
			        in.close();
        		} catch (IOException e) {
		          // Forward to handler
        		}
      		}
    	}
  	}
	}
}
