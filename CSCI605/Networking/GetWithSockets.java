import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class GetWithSockets {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		String host = args.length > 0 ? args[0] : "www.google.com";
		int port = args.length > 1 ? Integer.parseInt(args[1]) : 80;
		
		System.out.println("Opening connection to " + host + ":" + port + "...");
		try(Socket sock = new Socket(host, port)) {
			System.out.println("Connection established!");
			
			OutputStream out = sock.getOutputStream();
				
			System.out.println("Sending request...");
			String req = "GET http://" + host + "/ HTTP/1.0\n\n";
			byte[] request = req.getBytes(); 
			out.write(request);
			out.flush();
			System.out.println("Request sent!");
			
			System.out.println("Reading response...");
			InputStream in = sock.getInputStream();
			byte[] response = new byte[10240];
			int n;
			while((n = in.read(response)) != -1) {
				System.out.println(new String(response, 0, n));
			}
		}
	}
}
