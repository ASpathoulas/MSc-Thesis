//LCK09-J. Do not perform operations that can block while holding a lock

public class OperationsBlock {
	public synchronized void doSomething(long time)throws InterruptedException {
		// ...
			Thread.sleep(time);

		
	}
}

