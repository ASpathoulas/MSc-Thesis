public class Data2 {
	  static int a = 0;
	private void otherMethod(){
		a=1;
	}
	  public static void main(String[] args) {
	    new MyThread().start();
	    otherMethod()
	  }

	  public static class MyThread extends Thread {
	    public void run() { 
	      System.out.println(a);
	    }
	  }
	}
