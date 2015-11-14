//LCK09-J. Do not perform operations that can block while holding a lock

public class OperationsBlock {
	public synchronized void doSomething(long timeout) throws InterruptedException {
	// ...
  		while (<condition does not hold>) {
    			wait(timeout); // Immediately releases the current monitor
  		}
	}
}

