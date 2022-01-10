public class D1028EX1 {
	public static void main() {
		int a;
		double b;
		byte c;
		a=2;
		b=a; //auto conversation 正確原則
		
		b=2.5;
		a=(int)b;//type casting 
		
		c=5;
		a=c; // 放寬原則
		
		c=(byte)a;
	
	}
}
