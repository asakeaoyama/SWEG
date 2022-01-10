
public class D1014Ex5 {
	public static void main(String[] args) {
		int[][] a = { { 2, 1, 3 },
			      { 4 }, 
			      { 6, 4, 8, 7 } };
		int sum=0;
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				sum+=j;
				System.out.print(a[i][j]+" ");
			}
			System.out.println("");
		}
		System.out.println("sum="+sum);
	}
}
