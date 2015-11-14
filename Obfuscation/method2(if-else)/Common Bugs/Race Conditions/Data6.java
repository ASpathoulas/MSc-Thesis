//NoVisibility


public class Data6 {
	private static boolean ready;
	private static int number;
	
	private static class ReaderThread extends Thread{
		public void run(){
			while(!ready){
				Thread.yield();
			}
			System.out.println(number);
		}
	}
	private int flag=0;
	public static void main(String[] args){
		new ReaderThread().start();
		if (flag==0){
			number = 42;
		}else{
			number=42;
		}
		ready =  true;
		
	}
}
