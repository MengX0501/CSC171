public class RightHandedPhilosopher extends Philosopher {

	public RightHandedPhilosopher(int id) {
		super(id);
	}

	@Override
	public void chooseChopsticksAndEat() {
		while(true) {
			eat(getRight(), getLeft());
		}
	}
	
	public static void main(String[] args) {
		Philosopher[] philosophers = new Philosopher[5];
		for(int i=0; i<philosophers.length; i++) {
			philosophers[i] = new RightHandedPhilosopher(i);
		}
		
		DiningThread.dine(philosophers);
	}

}
