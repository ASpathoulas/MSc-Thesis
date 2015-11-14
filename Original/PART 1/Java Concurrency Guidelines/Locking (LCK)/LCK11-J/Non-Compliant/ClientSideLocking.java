

import java.net.InetAddress;
import java.util.*;

public class ClientSideLocking {

	class IPAddressList {
		  private final List<InetAddress> ips =
		      Collections.synchronizedList(new ArrayList<InetAddress>());
		 
		  public List<InetAddress> getList() {
		    return ips; // No defensive copies required
		                // as visibility is package-private
		  }
		 
		  public void addIPAddress(InetAddress address) {
		    ips.add(address);
		  }
		}
		 
		class PrintableIPAddressList extends IPAddressList {
		  public void addAndPrintIPAddresses(InetAddress address) {
		    synchronized (getList()) {
		      addIPAddress(address);
		      InetAddress[] ia =
		          (InetAddress[]) getList().toArray(new InetAddress[0]);
		      // ...
		    }
		  }
		}
}
