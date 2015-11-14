//THI00-J. Do not invoke Thread.run()

public final class InvokeRun implements Runnable {
	@Override public void run() {
		System.out.println("testing...");
	}
	private static int flag=0;
	public static void main(String[] args) {
		InvokeRun foo = new InvokeRun();
		if (flag==0){
			new Thread(foo).run();
			}
		else{
			new Thread(foo).run();
		}
	}

}
