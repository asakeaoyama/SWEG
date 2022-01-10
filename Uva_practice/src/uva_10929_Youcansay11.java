import java.math.BigInteger;
import java.util.Scanner;
public class uva_10929_Youcansay11 {
	public static void main (String [] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
		String bistr = sc.nextLine();
		if (bistr.equals("0")) break;
		BigInteger b1= new BigInteger(bistr);
		BigInteger b2 = new BigInteger("11");
		BigInteger b0 = new BigInteger("0");
		BigInteger result[] = b1.divideAndRemainder(b2);
		if (result[1].equals(b0))	System.out.printf("%s is a multiple of 11.\n",bistr);
		else System.out.printf("%s is not a multiple of 11.\n",bistr);
		}
		sc.close();
	}
	
	
}
