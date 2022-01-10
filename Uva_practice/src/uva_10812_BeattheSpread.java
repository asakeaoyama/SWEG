import java.util.Scanner;

public class uva_10812_BeattheSpread {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int case1 = sc.nextInt();
		for (int u=0 ; u<case1 ; u++) {
			long s= sc.nextLong();
			long d= sc.nextLong();
			if (s-d<0 || (s-d)%2==1) {
				System.out.println("impossible");
			}
			else {
				long x= (s+d)/2;
				long y= (s-d)/2;
				System.out.println(x+" "+y);

			}
		}
		sc.close();
	}
}
