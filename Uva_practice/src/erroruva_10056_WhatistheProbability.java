import java.util.Scanner;
public class erroruva_10056_WhatistheProbability {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int cases = sc.nextInt();
		for(int z=0;z<cases;z++) {
			int n=sc.nextInt();
			double p= sc.nextDouble();
			int i=sc.nextInt();
			double q=1-p;
			if(p==0) {
				System.out.println("0.0000");
			}
			else {
				System.out.printf("%.4f\r\n",(Math.pow(q,i-1)*p/(1-Math.pow(q,n))));
			}
			
		}
		sc.close();
	}

}

/*

Round_1：
第一個人獲勝的機率：p

第二個人獲勝的機率：q*p

第三個人獲勝的機率：(q^2)*p

第k個人獲勝的機率：(q^(k-1))*p

 

Round_2：

第一個人獲勝的機率：(q^n)*p

第二個人獲勝的機率：(q^n)*q*p

第三個人獲勝的機率：(q^n)*(q^2)*p

第k個人獲勝的機率：(q^n)*(q^(k-1))*p

 

Round_R：

第一個人獲勝的機率：(q^(R-1)*n)*p

第二個人獲勝的機率：(q^(R-1)*n)*q*p

第三個人獲勝的機率：(q^(R-1)*n)*(q^2)*p

第k個人獲勝的機率：(q^(R-1)*n)*(q^(k-1))*p


※使用等比級數整理每個回合獲勝的機率就可以獲得此公式：(q^(k-1)*p) * (1-(q^n^R)) / (1-q^n)。(首項：(q^(k-1)*p)、公比：q^n)


注意事項：

1.由於題目沒有說要進行多少回合的遊戲，所以R帶50即可。我有試過R=100，但是在Uva Online Judge會出現錯誤，可能是回合數太多，算出來的機率會更精準的關係。

2.在瘋狂程設中要輸出答案時使用printf輸出時，換行符號則要打\r\n。在Uva Online Judge使用printf輸出時，換行符號只需要打\n即可，多打會錯。
*/

