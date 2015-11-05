import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class GetWithURLs {
	public static void main(String[] args) throws MalformedURLException, IOException {
		String host = args.length > 0 ? args[0] : "www.google.com";
		int port = args.length > 1 ? Integer.parseInt(args[1]) : 80;
		
		//new thing to deal with: MalformedURLException
		URL url = new URL("http://" + host + ":" + port + "/");
		System.out.println("host:     " + url.getHost());
		System.out.println("port:     " + url.getPort());
		System.out.println("protocol: " + url.getProtocol());
		System.out.println("file:     " + url.getFile());
		System.out.println("ref:      " + url.getRef());
		
		// open the connection
		URLConnection connection = url.openConnection();
		// open the input stream
		try( InputStream in = connection.getInputStream()) {
			byte[] buffer = new byte[10240];
			int n;
			while((n = in.read(buffer)) > 0) {
				System.out.println(new String(buffer, 0, n));
			}
		}
		
		//alternative, skip the connection
		try( InputStream in = url.openStream()) {
			byte[] buffer = new byte[10240];
			int n;
			while((n = in.read(buffer)) > 0) {
				System.out.println(new String(buffer, 0, n));
			}
		}
	}
}
