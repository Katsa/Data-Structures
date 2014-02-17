
public class practiceOne {
	
	public static void main(String[]args) {
		;
		System.out.println(reverse("Hello"));
		System.out.println(name("Amy", "TheProgrammer", false));
	}
	public static String reverse(String s) {
		int index = s.length()-1;
		String result = "";

		for (;index >= 0; index--) {
			result += s.charAt (index);

		}
		return result;
	}
	//reverse("Hello");

	public static String name(String first, String last, boolean firstNameFirst){

		if( firstNameFirst ){
			return first.toUpperCase() + " " + last.toUpperCase();
		}else{
			return last.toUpperCase() + ", " + first.toUpperCase();
		}
	}
	
	
}
