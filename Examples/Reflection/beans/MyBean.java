package beans;

public class MyBean {
	private int age;
	private double weight;
	private String name;
	
	// beans must have a parameterless or default constructor
	public MyBean() {
		
	}
	
	//beans have properties, each of which meets the following requirement:
	// 1. set method
	//    a. name begins with "set"
	//    b. takes exactly one parameter
	//    c. returns void
	// 2. get method
	//    a. name is identical to the set method, replacing "set" with "get".
	//    b. takes no parameters.
	//    c. returns a type that is the same as the parameter for the set method
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getMyName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
