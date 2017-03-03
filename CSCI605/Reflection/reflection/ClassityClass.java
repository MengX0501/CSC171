package reflection;

public class ClassityClass {
	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> s1 = String.class;
		String abc = "abc";
		Class<?> s2 = abc.getClass();
		Class<?> s3 = Class.forName("java.lang.String");
		
		System.out.println(s1 == s2);
		System.out.println(s2 == s3);
	}
}
