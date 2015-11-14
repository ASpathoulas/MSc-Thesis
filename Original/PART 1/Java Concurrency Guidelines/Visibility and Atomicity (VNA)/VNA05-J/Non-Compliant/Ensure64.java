//VNA05-J. Ensure atomicity when reading and writing 64-bit values


public class Ensure64 {
	class LongContainer {
		  private long i = 0;
		 
		  void assignValue(long j) {
		    i = j;
		  }
		 
		  void printLong() {
		    System.out.println("i = " + i);
		  }
		}
}

