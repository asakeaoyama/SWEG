import java.util.Scanner;

public class uva_22801_DoomsDayAlgorithm {

	public static void main(String[] args) {
		String week[]={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
		int month[]={0,31,59,90,120,151,181,212,243,273,304,334,365}; 
		Scanner sc= new Scanner(System.in);
		int cases = sc.nextInt();
		for(int C=0;C<cases;C++) {
			int M=sc.nextInt(),D=sc.nextInt();
			//計算到目前為止有幾天
			System.out.println(week[(month[M-1]+D+4)%7]);
			
		}
		sc.close();
	}

}
