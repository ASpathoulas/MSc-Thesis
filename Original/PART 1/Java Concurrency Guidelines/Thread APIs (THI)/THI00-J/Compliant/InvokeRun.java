//THI00-J. Do not invoke Thread.run()

public final class InvokeRun implements Runnable {
  	@Override public void run() {
    	// ...
  	}
 
  	public static void main(String[] args) {
    		InvokeRun foo = new Foo();
    		new Thread(foo).start();
  	}
}
