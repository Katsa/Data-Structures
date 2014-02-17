
public class Person {

	private static int age = 18;
	private static String first;
	private static String last;

	public Person(String tempFirst, String tempLast) {
		first = tempFirst;
		last = tempLast;
	}
	
	private static String getFirst() {
		return first;
	}

	private static String getLast() {
		return last;
	}

	private static int getAge() {
		return age;
	}

	private static int anotherYear() {
		age ++;
		return age;
	}

	public static void main(String[] args){
		Person me = new Person("Steve", "Perry");
		System.out.println(me.getFirst() + " " + me.getLast() + " is " + me.getAge());
		me.anotherYear();
		System.out.println("and now: " + me.getAge());
	}
	
}
