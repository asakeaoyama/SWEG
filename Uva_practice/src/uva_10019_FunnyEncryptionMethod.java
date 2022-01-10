import java.util.Scanner;

public class uva_10019_FunnyEncryptionMethod {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int cases = sc.nextInt();
		for(int k=0; k<cases;k++) {
			String strnum= sc.next();
			int num=Integer.parseInt(strnum);
			int num8= Integer.parseInt(strnum, 16);
			int b1=B(num);  
			int b2=B(num8);
			System.out.println(b1+" "+b2);
		}
		
		sc.close();
	}
	static int B(int num) {
		int b=0;
		String numB = Integer.toBinaryString(num);
		for(char c: numB.toCharArray()) {
			if(c=='1')b+=1;
		}
		return b;
	}
}
