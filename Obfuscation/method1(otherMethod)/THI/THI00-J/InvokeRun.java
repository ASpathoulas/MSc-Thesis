//THI00-J. Do not invoke Thread.run()

public final class InvokeRun implements Runnable {
	@Override public void run() {
		System.out.println("testing...");
	}
	private void otherMethod(){
		InvokeRun foo = new InvokeRun();
		new Thread(foo).run();
	}
	public static void main(String[] args) {
			otherMethod();
		}
	}

}
