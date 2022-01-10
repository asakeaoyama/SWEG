import java.util.Scanner;

public class uva_10783_OddSum {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int caseNum = sc.nextInt();
		for (int y=1; y<caseNum+1; y++) {
			int a= sc.nextInt();
			int b= sc.nextInt();
			int sum=0;
			for (int u=a; u<b+1; u++) {
				if(u%2==1) {
					sum+=u;
				}
			}
			System.out.printf("Case %d: %d\n",y,sum);
		}
		sc.close();
	}
}
