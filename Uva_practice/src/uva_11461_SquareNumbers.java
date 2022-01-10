import java.util.Scanner;

public class uva_11461_SquareNumbers {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		while(sc.hasNext()) {
			double a= sc.nextInt();
			double b= sc.nextInt();
			if(a==0&&b==0) break;
			int as=(int)Math.round(Math.sqrt(a));
			int bs=(int)Math.round(Math.sqrt(b));
			
			int count=0;
			for(int i=as; i<=bs;i++) {
				int i2= i*i;
				int a1=(int)a;int b1=(int)b;
				if(a1<=i2 &&i2<=b1) {count++;}
			}
			System.out.println(count);
		}
		sc.close();
	}
}
