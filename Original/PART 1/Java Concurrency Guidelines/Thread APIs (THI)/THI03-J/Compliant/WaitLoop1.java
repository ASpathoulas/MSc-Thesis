////THI03-J. Always invoke wait() and await() methods inside a loop
//

public class WaitLoop1{
	Object object = new Object();
	private int flag=0;
	
	public void toSynchronize(){
		synchronized (object) {
		while (flag==0) {
			try {
				System.out.println("Thread will now wait");
				object.wait();
				flag=1;
			} catch (InterruptedException e) {e.printStackTrace();}
		}else{System.out.println("Thread is not in a wait state anymore");}
	}
	}

}

