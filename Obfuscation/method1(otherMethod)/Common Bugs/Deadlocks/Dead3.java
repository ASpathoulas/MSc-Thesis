public class Dead3 {
	public static void main(String[] args) {
		final Object resource1 = "resource1";
		final Object resource2 = "resource2";
		Thread t1 = new Thread() {
			
			private void otherMethod(){
				try { Thread.sleep(50); } catch (InterruptedException e) {}
			}
			
			public void run() {
				synchronized(resource1) {
					System.out.println("Thread 1: locked resource 1");
					otherMethod();
					synchronized(resource2) {
						System.out.println("Thread 1: locked resource 2");
					}
				}
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				synchronized(resource2) {
					System.out.println("Thread 2: locked resource 2");

					try { Thread.sleep(50); } catch (InterruptedException e) {}
					synchronized(resource1) {
						System.out.println("Thread 2: locked resource 1");
					}
				}
			}
		};

		t1.start(); 
	    t2.start();
	}
}

