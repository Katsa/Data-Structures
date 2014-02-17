
public class WarmUp {
	public static void printVertical(String s) {
		//String temp;
		for(int i=0; i<=s.length()-1;i++) {
			char temp = s.charAt(i);
			System.out.println(temp);
		}
		//return v;
	}
	
	public static double savings(int money, double rate) {
		double total;
		total = money + (money * rate);
		return total;
	}
	
	public static double savings(int money, double rate, int years) {
		double total;
		total = money + Math.pow( money * rate, years);
		return total;
	}
	
	public static void hailstorm(int num) {
		int newNum;
		if(num !=1){
			System.out.print(num + ", ");
			if(num%2 == 0) {
				newNum = num/2;
			}
			else {
				newNum = (3 * num) + 1;
			}
			hailstorm(newNum);
		}
		else {
			System.out.print(num);
		}
		
	}
	
	public static void main(String[]args) {
		printVertical("I love CS");
		System.out.println(savings(1000, 0.1));
		System.out.println(savings(1000, 0.1, 3));
		hailstorm(5);
	}
}
