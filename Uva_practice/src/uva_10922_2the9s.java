import java.util.Scanner;
public class uva_10922_2the9s {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		while (sc.hasNext()) {
			String numStr= sc.nextLine();
			if(numStr=="0") break;
			int sum=0;
			for (char nC : numStr.toCharArray()) {
				int n=(int)nC;
				sum+=n;
			}
			//是不是9的倍數
			if (sum%9!=0) System.out.println(numStr+" is not a multiple of 9.");
			else {
				int count=0;
				int degree=0;
				int sum2=0;
				while(degree!=9) {
					String d = Integer.toString(sum);
					for (char nC : d.toCharArray()) {
						int n=(int)nC;
						sum2+=n;}
					sum=sum2;
				}
				System.out.println(numStr+" is a multiple of 9 and has 9-degree "+count+".");
			}
		}
		sc.close();
	}
}
