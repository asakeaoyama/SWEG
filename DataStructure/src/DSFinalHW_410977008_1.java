import java.util.Scanner;
import java.util.Stack;
public class DSFinalHW_410977008_1 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		reverse(sc);
		sc.close();
	}
	static void reverse(Scanner sc) {
		System.out.println("Please enter a String.");
		String str= sc.nextLine();	
		Stack<String> stack = new Stack<String>();
		int strLong=fillStack(str,stack);
		popStack(strLong,stack);
	}
	static int fillStack(String str,Stack stack) {
		String strsp[]= str.split(" ");
		for(int i=0;i<strsp.length;i++) {
			stack.push(strsp[i]);
		}
		return strsp.length;
	}
	static void popStack(int strLong,Stack stack) {
		String tmp;
		for(int i=0;i<strLong;i++) {
			if(i==0) {
				tmp= (String)stack.pop();	//為甚麼這裡一定要強制轉型
				System.out.print(tmp.substring(0,1).toUpperCase()+tmp.substring(1));	//回文字串的第一個字需轉小寫為大寫
			}
			else if(i==strLong-1) {
				tmp= (String)stack.pop();
				System.out.print(" "+tmp.substring(0,1).toLowerCase()+tmp.substring(1));}	//最後一個字轉大寫為小寫
			else {System.out.print(" "+stack.pop());}
		}
		System.out.println();
	}

}
