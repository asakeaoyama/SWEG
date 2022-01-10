import java.util.Scanner;

public class uva_11332_SummingDigits {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		while(sc.hasNextInt()) {
			int num= sc.nextInt();
			if(num==0) {break;}
				while(num/10>0){
					int checksum=0;
					while(num>0) {	//加起來
						checksum+=num%10;
						num=num/10;}
					num=checksum;	
				}
			
			System.out.println(num);
		}
		sc.close();
	}
}
