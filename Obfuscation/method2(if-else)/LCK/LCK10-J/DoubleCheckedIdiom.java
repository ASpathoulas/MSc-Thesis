//LCK10-J. Do not use incorrect forms of the double-checked locking idiom

package locking;

public class DoubleCheckedIdiom {
	private int flag=0;
	final class Foo {
		private DoubleCheckedIdiom helper = null;
		public DoubleCheckedIdiom getHelper() {
			if (flag==0){
				if (helper == null) {
					System.out.println("First check");
					synchronized (this) {
						if (helper == null) {
							System.out.println("Second check");
							helper = new DoubleCheckedIdiom();
						}
					}
				}
			}else{
				if (helper == null) {
					System.out.println("First check");
					synchronized (this) {
						if (helper == null) {
							System.out.println("Second check");
							helper = new DoubleCheckedIdiom();
						}
					}
				}
			}
			return helper;
		}
	}
}
