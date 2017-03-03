public class DiningThread implements Runnable {
	private Philosopher philosopher;
	
	public DiningThread(Philosopher philosopher) {
		this.philosopher = philosopher;
	}
	
	public Philosopher getPhilosopher() {
		return philosopher;
	}
	
	public void run() {
		getPhilosopher().chooseChopsticksAndEat();
	}
	
	public static void dine(Philosopher[] philosophers) {
		Chopstick[] chopsticks = new Chopstick[philosophers.length];
		for(int i=0; i<chopsticks.length; i++) {
			chopsticks[i] = new Chopstick(i);
		}
		
		for(int i=0; i<chopsticks.length; i++) {
			int left = i;
			int right = i > 0 ? i-1 : chopsticks.length - 1;
			philosophers[i].placeLeft(chopsticks[left]);
			philosophers[i].placeRight(chopsticks[right]);
		}
		
		for(Philosopher phil : philosophers) {
			new Thread(new DiningThread(phil)).start();
		}
	}
}
