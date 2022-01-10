import java.util.Scanner;
public class A410977008_4_1 {
	public static void main(String[] args) {
		//***** 玩幾局
		Scanner sc= new Scanner(System.in);
		int caseNum=sc.nextInt();
		for(int z=0;z<caseNum;z++) {

			//****讀入玩家的BINGO表 
			int playerArr[][]= new int[5][5];;	
			for (int k=0; k<5;k++) {	
				for(int u=0;u<5;u++) {
					if(k==2&&u==2) {}	//中間不讀入
					else {
						int playerInt=sc.nextInt();		
						playerArr[k][u]=playerInt;}}	
			}
		
			boolean bingoArr[][]=new boolean [5][5];	//放playArr 的布林值
			bingoArr[2][2]=true;
			int binArr[] = new int[75];	
			for (int y=0;y<75;y++) {	//讀入全部bin值 這樣才不會影響到下一局
				int binNum= sc.nextInt();
				binArr[y]=binNum;
			}
			//****開始check bin number
			A:
			for (int i=0; i<75;i++) {
				int binNum=binArr[i];
				if (1<=binNum&&binNum<=15) {checkSame(0,binNum,playerArr,bingoArr);}
				else if (16<=binNum&&binNum<=30) checkSame(1,binNum,playerArr,bingoArr);
				else if (31<=binNum&&binNum<=45) checkSame(2,binNum,playerArr,bingoArr);
				else if (46<=binNum&&binNum<=60) checkSame(3,binNum,playerArr,bingoArr);
				else checkSame(4,binNum,playerArr,bingoArr);
			
				//***check player 有沒有binNum 有的話
					
				boolean check1 = false,check2= false,check3= false,check4=false,checkfin=false;
					//  row check 
					for(int a=0; a<5;a++) {		
						check1=(bingoArr[a][0]&&bingoArr[a][1]&&bingoArr[a][2]&&bingoArr[a][3]&&bingoArr[a][4]);	// 全部都要是true才會bingo
						if (check1==true) break;
					}
					// column check 
					for(int a=0; a<5;a++) {
						check2=(bingoArr[0][a]&&bingoArr[1][a]&&bingoArr[2][a]&&bingoArr[3][a]&&bingoArr[4][a]);
						if (check2==true) break;
					}
					
					//斜check 斜
					
					check3=(bingoArr[0][0]&&bingoArr[1][1]&&bingoArr[2][2]&&bingoArr[3][3]&&bingoArr[4][4]); 
					
					check4=(bingoArr[0][4]&&bingoArr[1][3]&&bingoArr[2][2]&&bingoArr[3][1]&&bingoArr[4][0]);
					
					checkfin = check1 || check2 || check3 || check4; //多種bingo方式滿足其一
				
					if (checkfin) {		//****check 有無bingo 有的話break
						System.out.printf("BINGO after %d numbers announced\n",i+1);
						break A ;}
			
			}	
			}
			sc.close();	
		}
		
	public static void checkSame(Integer line,Integer binNum,int[][] playerArr,boolean[][] bingoArr) {	
		for(int h=0;h<5;h++) {	// 如果bin值==玩家有的值 
			if (binNum==playerArr[h][line]) {
				bingoArr[h][line]=true; 
			}}
	}
}


