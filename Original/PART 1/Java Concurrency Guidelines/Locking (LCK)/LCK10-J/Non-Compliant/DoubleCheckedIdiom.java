//LCK10-J. Do not use incorrect forms of the double-checked locking idiom


public class DoubleCheckedIdiom {
	final class Foo {
		private DoubleCheckedIdiom helper = null;
		public DoubleCheckedIdiom getHelper() {
				if (helper == null) {
					System.out.println("First check");
					synchronized (this) {
						if (helper == null) {
							System.out.println("Second check");
							helper = new DoubleCheckedIdiom();
						}
					}
				}
			return helper;
		}
	}
}
