public class AmbidextrousPhilosopher extends Philosopher {	
	public AmbidextrousPhilosopher(int id) {
		super(id);
	}

	@Override
	public void chooseChopsticksAndEat() {
		while(true) {
			Chopstick left = getLeft();
			Chopstick right = getRight();
			
			int choice = RANDOM.nextInt(2);
			Chopstick first;
			Chopstick second;
			if( choice == 1 ) {
				first = left;
				second = right;
			}
			else {
				first = right;
				second = left;
			}
			
			eat(first, second);
		}		
	}
	
	public static void main(String[] args) {
		Philosopher[] philosophers = new Philosopher[5];
		for(int i=0; i<philosophers.length; i++) {
			philosophers[i] = new AmbidextrousPhilosopher(i);
		}
		
		DiningThread.dine(philosophers);
	}

}
