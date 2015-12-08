import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class HelloRemote extends UnicastRemoteObject implements HelloInterface {
	private static final long serialVersionUID = 1L;
	
	protected HelloRemote() throws RemoteException {

	}

	@Override
	public String sayHello(String name) {
		return "Hello, " + name + "!";
	}
}
