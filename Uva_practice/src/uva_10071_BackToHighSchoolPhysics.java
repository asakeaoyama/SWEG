import java.util.Scanner;
public class uva_10071_BackToHighSchoolPhysics {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int v= sc.nextInt();
			int t = sc.nextInt();
			System.out.println((v*2)*(t*2)/2);
		}
		sc.close();	
	}

}
