//LCK02-J. Do not synchronize on the class object returned by getClass()

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;


public class SynchronizeOnGet {
	class Base {
			DateFormat format1 = DateFormat.getDateInstance(DateFormat.MEDIUM);
			public Date parse(String str) throws ParseException {

					synchronized (getClass()) {return format1.parse(str);}
				
		  	}
		}
		 
	class Derived extends Base {
		public Date doSomethingAndParse(String str) throws ParseException {
		    synchronized (Base.class) {
		      // ...
		      return format1.parse(str);
		    }
		  }
		}
}
