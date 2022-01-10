import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Deque;
//using deque as a stack
public class DSFinalHW_410977008_2 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		fragment(sc);
		sc.close();
	}
	static void fragment(Scanner sc) {
		System.out.println("Please enter a string.");
		String str=sc.nextLine();
		int strLong=str.length();
		Deque<Character> arrdeque= new ArrayDeque<Character>(); 
		int countNumeric=0;
		int countNoNumeric=0;
		for(char c:str.toCharArray()) {	
			if('0'<=c&&c<='9') {
				arrdeque.addLast(c);
				countNumeric++;}
			else {
				arrdeque.addFirst(c);
				countNoNumeric++;}
		}
		printDeque(strLong,arrdeque);
		System.out.println("The number of numeric char : "+countNumeric);
		System.out.println("The number of non-numeric char : "+countNoNumeric);
	}
	
	static void printDeque(int strLong,Deque<Character> arrdeque) {
		System.out.print("The String after fragment : ");
		for(int i=0;i<strLong;i++) {
			System.out.print(arrdeque.poll());
		}
		System.out.println();
	}
}
