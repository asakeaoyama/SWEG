import java.util.Scanner;
public class uva_10101_BanglaNumbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count=0;
		while (sc.hasNext()) {
			count+=1;
			Long num = sc.nextLong();
			System.out.printf("%4d. ",count);
			if(num==0)
				System.out.print("0");
			else change(num);
			System.out.println("");
		}
		sc.close();
	}
	public static void change(long num) {
		if (num>=10000000) {
			change(num/10000000);
			System.out.print(" kuti ");
			num= num%10000000;
		}
		if (num>=100000) {
			change(num/100000);
			System.out.print(" lakh ");
			num= num%100000;
		}
		if (num>=1000) {
			change(num/1000);
			System.out.print(" hajar ");
			num= num%1000;
		}
		if (num>= 100) {
			change(num/100);
			System.out.print(" shata ");
			num= num%100;
		}
		if (num>0) {
			System.out.print(" "+num);
		}
	}
}