//THI00-J. Do not invoke Thread.run()

public final class InvokeRun implements Runnable {
	@Override public void run() {
		System.out.println("testing...");
	}
	public static void main(String[] args) {

			new Thread(foo).run();

	}

}
