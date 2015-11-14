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
	private void otherMethod(){
		number=42;
	}
	public static void main(String[] args){
		new ReaderThread().start();
		otherMethod();
		ready =  true;
		
	}
}
