import java.util.Scanner;

public class uva_10035_PrimaryArithmetic {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		while(sc.hasNext()) {
			int a= sc.nextInt();
			int b= sc.nextInt();
			if(a==0&b==0) {break;}
			int count=0;
			int carrys=0;
			while(a!=0||b!=0) {
				int sum=0;
				sum=(a%10)+(b%10)+carrys;
				if(sum>=10) {carrys=1;count++;}
				else {carrys=0;}
				a=a/10;
				b=b/10;
			}
			if(count==0) {System.out.println("No carry operation.");}
			else if(count==1) {System.out.println("1 carry operation.");}
			else {System.out.println(count+" carry operations.");}
		}
		sc.close();
	}
}
