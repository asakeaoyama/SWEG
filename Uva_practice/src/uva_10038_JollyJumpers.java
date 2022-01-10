import java.util.Scanner;
import java.util.Arrays;
public class uva_10038_JollyJumpers {
	public static void  main(String[] args) {
		Scanner sc= new Scanner(System.in);
		while (sc.hasNext()) {
			int n= sc.nextInt();
			boolean flag = false;
			int numArr[] = new int[n];
			for (int i=0 ; i<n; i++) {
				int num = sc.nextInt();
				numArr[i]= num;
			}
			int jollyArr[]= new int[n-1];	
			for (int u =0 ; u<n-1;u++) {
				jollyArr[u]= u+1;
			}
			int checkArr [] = new int[n-1];	
			for (int i=0; i<n-1; i++) {
				checkArr[i]=Math.abs(numArr[i+1]-numArr[i]);
			}
			Arrays.sort(checkArr);
			for (int u =0 ; u<n-1;u++) {
				if (checkArr[u]!=jollyArr[u])flag = true;
			}
			
			if (flag == true) System.out.println("Not jolly");
			else System.out.println("Jolly");
		}
		sc.close();
	}
	
}
