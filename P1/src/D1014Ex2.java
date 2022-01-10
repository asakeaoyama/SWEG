
public class D1014Ex2 {
	public static void main(String[] args) {
		int a=6;
		if (a % 2 == 0 && a % 3==0) {  //(a%2 == 0)==boolean
			System.out.print("hello");
		}	
	}
	static boolean ModeBy3(int in) {
		System.out.println("Using ModeBy3()");
		return in%3==0;
	}
}
