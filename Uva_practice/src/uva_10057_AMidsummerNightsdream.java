import java.util.Arrays;
import java.util.Scanner;

public class uva_10057_AMidsummerNightsdream {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		while(sc.hasNext()) {
			int case1= sc.nextInt();
			int numArr[] = new int[case1];
			for (int y= 0; y<case1;y++) {
				int n= sc.nextInt();
				numArr[y]= n;
			}
			Arrays.sort(numArr);
			//找中位數
			int mid1 = numArr[(case1 - 1)/2];
			int mid2 = numArr[case1 /2];
			//input有無相同
			int same=0;
			for(int u=0;u<case1;u++) {
				if (numArr[u]==mid1|| numArr[u]==mid2) same++;
			}
			int possible=0;
			//有幾種可能
			if (case1%2==0) {
				possible=mid2-mid1+1;
			}
			else possible=1;
			System.out.println(mid1 + " " + same+ " " + possible);
		}
		sc.close();
	}
}
