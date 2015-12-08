import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;


public class HelloServer {
	public static void main(String[] args) throws RemoteException, MalformedURLException {
		HelloInterface hello = new HelloRemote();
		Naming.rebind("//localhost/HelloInterfaceImplementation", hello);
		System.out.println("HelloServer bound in registry.");
	}
}
