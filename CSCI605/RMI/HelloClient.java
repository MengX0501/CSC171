import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class HelloClient {
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		HelloInterface hello = (HelloInterface)Naming.lookup("//localhost/HelloInterfaceImplementation");
		String response = hello.sayHello("Bobby");
		System.out.println(response);
	}
}
