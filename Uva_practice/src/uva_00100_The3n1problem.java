import java.util.Scanner;

public class uva_00100_The3n1problem {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		while(sc.hasNext()) {
			int i= sc.nextInt();
			int j= sc.nextInt();
			System.out.print(i+" "+j+" ");
			int temp=i;
			i=Math.min(i,j);
			j=Math.max(temp, j);
			int maxClength=0;
			for(int k=i;k<j+1;k++) {
				int Clength=1;
				for(int y=k;y!=1;) {
					if (y%2==1) {y=3*y+1;}
					else {y=y/2;}
					Clength+=1;
				}
				if(Clength>maxClength) {maxClength=Clength;}
			}
			System.out.println(maxClength);
		}
		sc.close();
	}
}