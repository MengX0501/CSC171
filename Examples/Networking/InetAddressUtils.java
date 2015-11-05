import java.net.InetAddress;


public class InetAddressUtils {
	public static void printAll(InetAddress addr) {
		printIP(addr);
		printRawAddress(addr);
		printUnsignedAddress(addr);
		printHostName(addr);
		printFullHostName(addr);
	}
	
	public static void printIP(InetAddress addr) {
		System.out.println("IP: " + addr.getHostAddress());
	}
	
	public static void printRawAddress(InetAddress addr) {
		// a dotted quad may have values from 0-255, but signed bytes may
		// have values from -128-127.  This means the bytes in the address
		// may be negative
		byte[] address = addr.getAddress();
		System.out.println("raw address bytes: " 
				+ address[0] + "." 
				+ address[1] +	"." 
				+ address[2] + "." 
				+ address[3]);
	}
	
	public static void printUnsignedAddress(InetAddress addr) {
		byte[] address = addr.getAddress();
		// it is easy enough to convert them to unsigned integers
		System.out.println("unsigned address bytes: " 
			+ (address[0] & 0xFF) + "."
			+ (address[1] & 0xFF) + "."
			+ (address[2] & 0xFF) + "."
			+ (address[3] & 0xFF));
	}
	
	public static void printHostName(InetAddress addr) {
		System.out.println("host name: " + addr.getHostName());
	}
	
	public static void printFullHostName(InetAddress addr) {
		System.out.println("full host name: " + addr.getCanonicalHostName());
	}
	
	
}
