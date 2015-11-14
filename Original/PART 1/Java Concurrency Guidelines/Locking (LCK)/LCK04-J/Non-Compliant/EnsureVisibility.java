//LCK04-J. Do not synchronize on a collection view if the backing collection is accessible

import java.util.*;

public class EnsureVisibility {

	private final Map<Integer, String> mapView =Collections.synchronizedMap(new HashMap<Integer, String>());
	private final Set<Integer> setView = mapView.keySet();
	
	private int flag=0;
	
	public Map<Integer, String> getMap() {
		return mapView;
	}
		 
	public void doSomething() {
		synchronized (setView) {  // Incorrectly synchronizes on setView  
				for (Integer k : setView) {System.out.println(k);}
			
		}
	}
		
		

}
