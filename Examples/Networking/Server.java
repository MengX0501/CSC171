import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(2511);
		
		while(true) {
			Socket sock = server.accept();
			
			System.out.println("connection estalished!");
			
			InputStream in = sock.getInputStream();
			OutputStream out = sock.getOutputStream();
			byte[] buffer = new byte[1024];
			int n;
			if((n = in.read(buffer)) != -1) {
				System.out.println(new String(buffer, 0, n));
				out.write("Why hello!".getBytes());
				out.flush();
			}
		}
	}
}
