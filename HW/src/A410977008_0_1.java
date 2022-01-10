import java.util.Scanner;
public class A410977008_0_1 {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int num1=scanner.nextInt();
			for(int i=1;i<=num1; i++) {
				int sum=0;
				int num2=scanner.nextInt();
				int num3=scanner.nextInt();
				for(int j=num2; j<=num3;j++){
					if(j%2!=0){
						sum+=j;
					}
				}
				System.out.printf("Case %d: %d\n",i,sum);
			}
		}
	}
}
//wrong