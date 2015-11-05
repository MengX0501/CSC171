import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket sock = new Socket("localhost", 2511);
		
		OutputStream out = sock.getOutputStream();
		InputStream in = sock.getInputStream();
		out.write("Hi there!".getBytes());
		out.flush();
		byte[] buffer = new byte[1024];
		int n;
		if((n = in.read(buffer)) != -1) {
			System.out.println(new String(buffer, 0, n));
		}
		
	}
}
