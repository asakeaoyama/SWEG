package selfPractice;
import java.util.Scanner;
public class PM_3 {
		public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
			int total=0;
		    System.out.println("total=0 ?"+total);
			while(true){
			    String product = sc.next();
			    if (product.equals("done")) break;
			    int cost = sc.nextInt();
			    total+=cost;
			    System.out.println("time total: "+total);
			}
		    sc.close();
		}

}


