import java.util.Random;

public abstract class Philosopher {
	static final Random RANDOM = new Random();
	private static int TOTAL_GRAINS = 0;
	
	private int id;
	private String name;
	private Chopstick left;
	private Chopstick right;
	private int eaten;
	
	public Philosopher(int id) {
		this.id = id;
		name = "phil-" + id;
		eaten = 0;
	}
	
	public abstract void chooseChopsticksAndEat();
	
	public int getId() {
		return id;
	}
	
	public void placeLeft(Chopstick left) {
		this.left = left;
	}
	
	public void placeRight(Chopstick right) {
		this.right = right;
	}
	
	public Chopstick getLeft() {
		return left;
	}
	
	public Chopstick getRight() {
		return right;
		
	}
	
	public String getName() {
		return name;
	}
	
	public void eat(Chopstick first, Chopstick second) {
		System.out.println(getName() + " is trying to grab his first chopstick");
		synchronized(first) {
			System.out.println(getName() + " got the first, now going for the second");
			synchronized(second) {
				eaten = eaten + 1;
				int total = incrementTotalGrains();
				System.out.println( name + " got both chopsticks.  Yum!  (" + eaten + "/" + total + ")");
			}
		}
	}
	
	private static synchronized int incrementTotalGrains() {
		TOTAL_GRAINS = TOTAL_GRAINS + 1;
		return TOTAL_GRAINS;
	}
}
