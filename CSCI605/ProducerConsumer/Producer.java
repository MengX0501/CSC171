import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Producer implements Runnable {
	private List<String> queue;
	
	public Producer(List<String> queue) {
		this.queue = queue;
	}
	
	public void makeWork(String job) {
		synchronized(queue) {
			queue.add(job);
			queue.notifyAll();
		}
	}
	
	
	@Override
	public void run() {
		Random random = new Random();
		for(int i=0; i<100; i++) {
			int numberOfJobs = random.nextInt(5) + 1;
			for( int j=0; j<numberOfJobs; j++) {
				makeWork(UUID.randomUUID().toString());
			}
			try {
				Thread.sleep(random.nextInt(1000));
			}
			catch(InterruptedException e) {
				
			}
		}
	}
}
