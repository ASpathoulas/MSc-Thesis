
public class overrideThread {
	class Base {
  		public synchronized void doSomething() {
   		 // ...
  	}
}
 
class Derived extends Base {
	@Override public synchronized void doSomething() {
    	// ...
  	}
	}
}
