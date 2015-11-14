//LCK08-J. Ensure actively held locks are released on exceptional conditions

import java.io.*;
import java.util.concurrent.locks.*;

public class HeldLocks {
	public final class Client {
		public void doSomething(File file) {
			final Lock lock = new ReentrantLock();
			InputStream in = null;
	
				try {
					lock.lock();
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
