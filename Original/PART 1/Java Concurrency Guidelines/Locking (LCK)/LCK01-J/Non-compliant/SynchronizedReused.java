////LCK01-J. Do not synchronize on objects that may be reused


public class SynchronizedReused {
	private final Boolean initialized = Boolean.FALSE;
	private int flag = 0;
	private void doSomething() {
			synchronized (initialized) {
			}		

	}
}



