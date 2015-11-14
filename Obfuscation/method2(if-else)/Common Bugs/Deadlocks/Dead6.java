import java.util.concurrent.locks.*;  

public class Dead6 { 
	public static final Lock l1 = new ReentrantLock(); 
	public static final Lock l2 = new ReentrantLock(); 
	    
	static class DeadLock1 implements Runnable { 
	private int flag=0;
        public void run() {
	if(flag==0){
		l1.lock(); 
		l2.lock();
	}else{
		l1.lock(); 
		l2.lock();
	}

            l1.unlock(); 
            l2.unlock(); 
        } 
    } 

    static class DeadLock2 implements Runnable { 
        public void run() { 
            l2.lock(); 
            l1.lock();   
            l2.unlock(); 
            l1.unlock(); 
        } 
    } 

    public static void main(String[] args) { 
        new Thread(new DeadLock1()).start(); 
        new Thread(new DeadLock2()).start(); 
    } 
} 
