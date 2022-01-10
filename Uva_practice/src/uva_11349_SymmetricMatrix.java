import java.util.Scanner;

public class uva_11349_SymmetricMatrix {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int cases= Integer.parseInt(sc.next());
		for(int C=0; C<cases;C++) {
			boolean s= martrix(sc);
			if(s==true) {
				 System.out.println("Test #"+(C+1)+": Symmetric.");
			}
			else {
				 System.out.println("Test #"+(C+1)+": Non-symmetric.");
			}
		}
		sc.close();
	}


	static boolean martrix(Scanner sc) {
		String temp1=sc.next();String temp2=sc.next();
		int n=Integer.parseInt(sc.next());
		long arr[]=new long[n*n];
		

		int size=n*n;
		for(int j=0;j<size;j++) arr[j]=Long.parseLong(sc.next()); //把數值讀到矩陣。
		
		//進行判斷。
		for(int j=0;j<size;j++){
			if(arr[j]<0 || (arr[j]!=arr[size-1-j])){
				return false;
			}
		}
		return true;
	}
}
