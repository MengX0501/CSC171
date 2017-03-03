import java.util.LinkedList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<String> queue = new LinkedList<>();
		
		new Thread(new Consumer(0, queue)).start();
		new Thread(new Consumer(1, queue)).start();
		new Thread(new Producer(queue)).start();
	}
}
