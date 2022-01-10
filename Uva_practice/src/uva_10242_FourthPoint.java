import java.util.Scanner;

public class uva_10242_FourthPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		while(sc.hasNext()) {
			double sArr[][]= new double[4][2];
			double same[]=new double[2];
			double xx=0,yy=0;
			for(int u=0;u<4;u++) {
				for(int h=0;h<2;h++) {
					sArr[u][h]=sc.nextDouble();
				}
				for(int y=0;y<u;y++) {
					if(sArr[u][0]==sArr[y][0]&&sArr[u][1]==sArr[y][1]) {
						same[0]=sArr[u][0];
						same[1]=sArr[u][1];
					}
					
				}
			}
			
			for(int i=0;i<4;i++) {
				if(!(sArr[i][0]==same[0]&&sArr[i][1]==same[1])) {
					xx+=sArr[i][0];
					yy+=sArr[i][1];
				}
			}
			
			System.out.printf("%.3f %.3f",xx-same[0],yy-same[1]);
			System.out.println("");
		}
		sc.close();
	}

}
