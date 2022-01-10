import java.util.Scanner;
public class uva_10193_AllYouNeedisLove {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int cases= sc.nextInt();
		
		for(int z=1;z<=cases;z++) {
			String str1=sc.nextLine();
			String str2= sc.nextLine();
			int num1= Integer.parseInt(str1,2);
			int num2= Integer.parseInt(str2,2);
		
			int temp;
			while(num1 % num2 != 0) { 
				temp=num2;
				num2= num1%num2;
				num1=temp;
			}
			if(num2==1) {System.out.println("Pair #"+z+": Love is not all you need!");}
			else {System.out.println("Pair #"+z+": All you need is love!");}
		}
		sc.close();
	}
}
/*
5
11011
11000
11011
11001
111111
100
1000000000
110
1010
*/