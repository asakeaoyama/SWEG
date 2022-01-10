import java.util.Scanner;
import java.util.HashSet;
public class uva_11063_B2Sequence {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int c=0;
		while(sc.hasNext()) {
			boolean isB2= true;
			c+=1;
			int cases=sc.nextInt();
			int numL[]= new int[cases];
			
			for(int z=0;z<cases;z++) {
				int y=sc.nextInt();
				numL[z]=y;}
			
			for(int z=0;z<cases;z++) {
				if(numL[z]<1) {isB2=false;break;}
				if(z!=0) {
					if(numL[z]<numL[z-1]) {isB2=false;break;}
				}
			}
			
			HashSet<Integer> sumSet = new HashSet<Integer>();
			for(int i=0;i<cases&&isB2;i++) {
				for(int y=0;y<=i;y++) {
					int sum = numL[i]+numL[y];
					if(sumSet.add(sum)==false) {isB2=false;break;}
				}
			}
			
			if(isB2==true) {System.out.println("Case #"+c+": It is a B2-Sequence.");}
			else {System.out.println("Case #"+c+": It is not a B2-Sequence.");}
			System.out.println();
		}
		sc.close();
}
}