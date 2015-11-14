//LCK08-J. Ensure actively held locks are released on exceptional conditions

package locking;
import java.io.*;
import java.util.concurrent.locks.*;

public class HeldLocks {
	public final class Client {

		private int flag=0;
		public void doSomething(File file) {
			final Lock lock = new ReentrantLock();
		    InputStream in = null;
	
				try {
					if(flag==0){
						lock.lock();
					}else{
						lock.lock(); 
					}
			      
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

