import java.util.Scanner;

public class uva_10055_HashmatTheBraveWarrior {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 	// int : 2^31 - 1 ; byte : 2^7-1
		while(sc.hasNextLong()){
			long us =sc.nextLong(),them = sc.nextLong();
			System.out.println(Math.abs(them-us));
		}
		sc.close();
	}
}
