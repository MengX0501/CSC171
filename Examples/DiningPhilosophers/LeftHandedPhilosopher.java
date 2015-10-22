public class LeftHandedPhilosopher extends Philosopher {

	public LeftHandedPhilosopher(int id) {
		super(id);
	}

	@Override
	public void chooseChopsticksAndEat() {
		while(true) {
			eat(getLeft(), getRight());
		}
	}
	
	public static void main(String[] args) {
		Philosopher[] philosophers = new Philosopher[5];
		for(int i=0; i<philosophers.length; i++) {
			philosophers[i] = new LeftHandedPhilosopher(i);
		}
		
		DiningThread.dine(philosophers);
	}
}
