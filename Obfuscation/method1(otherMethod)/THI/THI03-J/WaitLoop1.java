//THI03-J. Always invoke wait() and await() methods inside a loop

public class WaitLoop1{
	Object object = new Object();
	private int flag=0;
	
	private int myFlag=0;
	
	private void otherMethod(){
		object.wait();
	}

	public void toSynchronize(){
		synchronized (object) {
			if (flag==0) {
				try {
					System.out.println("Thread will now wait");
					otherMethod();
					}
					flag=1;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			else
			{System.out.println("Thread is not in a wait state anymore");}
		}
	}
}

