import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerThread implements Runnable {
	private ServerSocket server;
	
	public ServerThread(int port) throws IOException {
		server = new ServerSocket(port);
	}
	
	public void run() {
		while(true) {
			try {
				System.out.println("waiting for connections...");
				Socket client = server.accept();
				System.out.println("connection estalished!");
				new Thread(new ClientHandler(client)).start();
			} 
			catch (IOException e) {
			} 
		}
	}
	
	public static void main(String[] args) throws Exception {
		new Thread(new ServerThread(2511)).start();
	}
	
	private static class ClientHandler implements Runnable {
		private Socket sock;
		
		ClientHandler(Socket sock) {
			this.sock = sock;
		}
		
		
		public void run() {
			try {
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
			catch(Exception e) {
				
			}
		}
	}

}
