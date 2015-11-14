package dataRace;

public class Data2 {
	  static int a = 0;
	private int flag=0;
	  public static void main(String[] args) {
	    new MyThread().start();
		if(flag==0){
		    a = 1;
		}else{
			a=1;
		}
	  }

	  public static class MyThread extends Thread {
	    public void run() { 
	      System.out.println(a);
	    }
	  }
	}
