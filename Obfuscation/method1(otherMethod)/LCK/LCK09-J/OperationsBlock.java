//LCK09-J. Do not perform operations that can block while holding a lock

public class OperationsBlock {
	private int flag=0;
	public synchronized void doSomething(long time)throws InterruptedException {
		// ...
		
		if(flag==0){
			Thread.sleep(time);
		}else{
			Thread.sleep(time);
		}
		
	}
}

