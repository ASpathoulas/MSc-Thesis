//VNA03-J. Do not assume that a group of calls to independently atomic methods is atomic


import java.util.*;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

public class AssumeAtomic {
	
	final class KeyedCounter {
		private final Map<String, Integer> map =
				Collections.synchronizedMap(new HashMap<String, Integer>());
		  
		private void otherMethod(int myInt, String myString){
			map.put( myString, myInt + 1);
			
		}
		 
		public void increment(String key) {
			  Integer old = map.get(key);
			  int oldValue = (old == null) ? 0 : old.intValue();
			  if (oldValue == Integer.MAX_VALUE) {
			 	throw new ArithmeticException("Out of range");
			  }
			  otherMethod(old,key);
		  }
		  
		 
		  public Integer getCount(String key) {
			  return map.get(key);
		  }
		}
}

