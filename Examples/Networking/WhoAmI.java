import java.net.InetAddress;
import java.net.UnknownHostException;


public class WhoAmI {
	public static void main(String[] args) throws UnknownHostException {
		// one of many static methods to retrieve an address
		InetAddress local = InetAddress.getLocalHost();
		
		InetAddressUtils.printAll(local);
	}
	
	public static int signedByteToInt(byte b) {
		int unsigned = b & 0xff;
		return unsigned;
	}
}
