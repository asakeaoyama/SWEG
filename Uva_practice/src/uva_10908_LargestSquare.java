import java.util.Scanner;
public class uva_10908_LargestSquare {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int  cases= Integer.parseInt(sc.nextLine());
		for(int uu=0; uu<cases;uu++) {
			String[] tmp = sc.nextLine().split(" ");
			int m=Integer.parseInt(tmp[0]);
			int n=Integer.parseInt(tmp[1]);
			int q=Integer.parseInt(tmp[2]);
			System.out.println(m+" "+n+" "+q);
			char area[][]= new char[m][n];
			makeArea(sc,area);
			for(int j=0;j<q;j++) {
				tmp = sc.nextLine().split(" ");
				int r=Integer.parseInt(tmp[0]);
				int c=Integer.parseInt(tmp[1]); 
				int side= find(r,c,area);
				System.out.println(side);
			}
		}
		sc.close();
	}
	static void makeArea(Scanner sc,char area[][]) {
		for(int m=0;m<area.length;m++) {
			String str= sc.nextLine();
			for(int n=0;n<area[0].length;n++) {
				area[m][n]=str.charAt(n);
			}
		}
	}
	static int find(int r,int c,char area[][]) {
		int side = 1;
		int increment = 1;
		char center = area[r][c];
	 A: while (true) {
        	for (int y=r-increment; y<= r+increment; y++) { 
        		for (int x=c-increment; x <= c+increment; x++) {
        			if (x<0 || x> area[0].length-1 || y<0 || y > area.length-1 ||area[y][x] != center)
        				break A;
        		}
        	}
        	side +=2;
        	increment++;
        }
		return side;
	}
	
}
