import java.util.List;

public class Consumer implements Runnable {

	private String name;
	private List<String> queue;
	
	public Consumer(int id, List<String> queue) {
		name = "consumer-" + id;
		this.queue = queue;
	}
	
	@Override
	public void run() {
		while(true) {
			String job;
			synchronized(queue) {
				while(queue.size() == 0) {
					try {
						queue.wait();
					} catch (InterruptedException e) {}
				}
				
				job = queue.remove(0);
			}
			
			System.out.println(name + ": " + job);
		}
		
	}

}
