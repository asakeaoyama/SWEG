import java.util.Scanner;

public class uva_10931_Parity {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		while(true) {
			int num= sc.nextInt();
			if (num==0) {break;}
			String numB= Integer.toBinaryString(num);
			int sum=0;
			for (char o: numB.toCharArray()) {
				if (o=='1') {sum+=1;}
			}
			System.out.println("The parity of "+numB+" is "+sum+" (mod 2).");
		}
		sc.close();
	}
}
