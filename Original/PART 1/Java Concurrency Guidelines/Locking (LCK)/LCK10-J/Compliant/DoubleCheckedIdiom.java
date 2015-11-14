//LCK10-J. Do not use incorrect forms of the double-checked locking idiom


public class DoubleCheckedIdiom {
	final class Foo {
  		private volatile DoubleCheckedIdiom helper = null;
 
  		public DoubleCheckedIdiom getHelper() {
    			if (helper == null) {
      				synchronized (this) {
        				if (helper == null) {
          					helper = new DoubleCheckedIdiom();
        				}
      				}
    			}
    		return helper;
  		}
	}
}
