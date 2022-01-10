import java.util.Scanner;

public class A410977008_8_1 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		while(true) {
			int m= sc.nextInt();
			int n=sc.nextInt();
			if(m==0)break; 
			char oilArea[][]=new char[m][n];
			int sigh[][]= new int[m][n];	//標記有沒有尋遍，避免重複
			makeArea(sc,oilArea);
			int count=0;	//有幾個pocket
			for(int i=0; i<m;i++) {		//找出第一個有@的點，之後進行搜尋
				for(int j=0;j<n;j++) {
					if(sigh[i][j]==0&&oilArea[i][j]=='@') {
						count++;//下一個pocket
						search(oilArea, sigh,i,j,count);}	//進行歷遍
				}
			}
			System.out.println(count);
		}
		sc.close();
	}
	static void makeArea(Scanner sc, char oilArea[][]) {	//輸入二維陣列
		for(int i=0; i<oilArea.length;i++) {
			String lines = sc.next();
			for(int k=0; k<lines.length();k++) {
				oilArea[i][k]=lines.charAt(k);}
		}
	}
	
	static void search(char oilArea[][],int sigh[][],int r, int c, int count) {
		int m=oilArea.length;
		int n=oilArea[0].length;
		if(r<0||r>=m||c<0||c>=n) {return;}	//超過邊界再跳
		if(oilArea[r][c]!='@'||sigh[r][c]!=0) {return;}	
		
		sigh[r][c]=count;	//找到了!就在標記表上標記這是第幾個pocket
		//此點的八個方位都要search一遍	符合if就return不會過來
		search(oilArea,sigh,r-1,c-1,count);
		search(oilArea,sigh,r-1,c,count);
		search(oilArea,sigh,r-1,c+1,count);
		search(oilArea,sigh,r,c-1,count);
		search(oilArea,sigh,r,c+1,count);
		search(oilArea,sigh,r+1,c-1,count);
		search(oilArea,sigh,r+1,c,count);
		search(oilArea,sigh,r+1,c+1,count);
		return;
	}
}
/*先循遍一個pocket所有@的點，坐上標記(這個點已屬於一個pocket)
再進行到下一個pocket
 */
/*
1 1
*
3 5
*@*@*
**@**
*@*@*
1 8
@@****@*
5 5
****@
*@@*@
*@**@
@@@*@
@@**@
0 0
*/