import java.net.InetAddress;
import java.net.UnknownHostException;


public class WhoAreYou {
	public static void main(String[] args) throws UnknownHostException {
		String host = args.length > 0 ? args[1] : "www.stackoverflow.com";
		
		InetAddress remote = InetAddress.getByName(host);
		InetAddressUtils.printAll(remote);
	}
}
