//LCK10-J. Do not use incorrect forms of the double-checked locking idiom


public class DoubleCheckedIdiom {
	private int flag=0;
	final class Foo {

		private void otherMethod(){
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

		private DoubleCheckedIdiom helper = null;
		public DoubleCheckedIdiom getHelper() {
			otherMethod();
			return helper;
		}
	}
}
