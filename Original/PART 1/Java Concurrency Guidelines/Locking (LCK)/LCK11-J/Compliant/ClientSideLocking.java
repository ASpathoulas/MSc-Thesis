import java.net.InetAddress;
import java.util.*;

public class ClientSideLocking {

	class PrintableIPAddressList {
  		private final IPAddressList ips;
 
  		public PrintableIPAddressList(IPAddressList list) {
   			this.ips = list;
  		}
 
  		public synchronized void addIPAddress(InetAddress address) {
    			ips.addIPAddress(address);
  		}
 
  		public synchronized void addAndPrintIPAddresses(InetAddress address) {
    			addIPAddress(address);
    			InetAddress[] ia =(InetAddress[]) ips.getList().toArray(new InetAddress[0]);
    			// ...
  		}
	}
}
