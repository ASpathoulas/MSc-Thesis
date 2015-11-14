
public class PublishObj {
	class Foo {
		  private Helper helper;
		 
		  public Helper getHelper() {
		    return helper;
		  }
		 
		  public void initialize() {
		    helper = new Helper(42);
		  }
		}
		 
		public class Helper {
		  private int n;
		 
		  public Helper(int n) {
		    this.n = n;
		  }
		  // ...
		}
}
