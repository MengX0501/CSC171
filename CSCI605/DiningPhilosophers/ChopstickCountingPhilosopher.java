public class ChopstickCountingPhilosopher extends Philosopher {

	public ChopstickCountingPhilosopher(int id) {
		super(id);
	}

	@Override
	public void chooseChopsticksAndEat() {
		Chopstick left = getLeft();
		Chopstick right = getRight();
		
		Chopstick first;
		Chopstick second;
		if( left.getNumber() < right.getNumber()) {
			first = left;
			second = right;
		}
		else {
			first = right;
			second = left;
		}
		while(true) {
			eat(first, second);
		}
	}
	
	public static void main(String[] args) {
		Philosopher[] philosophers = new Philosopher[5];
		for(int i=0; i<philosophers.length; i++) {
			philosophers[i] = new ChopstickCountingPhilosopher(i);
		}
		
		DiningThread.dine(philosophers);
	}

}
