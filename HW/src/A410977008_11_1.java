import java.util.Scanner;
public class A410977008_11_1 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int cases= Integer.parseInt(sc.nextLine());
		for(int z=1;z<=cases;z++) {
			String numStr= sc.nextLine();
			System.out.println("Case "+z+": "+game(numStr));
		}
		sc.close();
	}
	//找可能可以被移除的位元共有幾個
	static String game(String numStr) {
		String numArr[] = numStr.split("");
		int sum=0;	//存放num位元數字總和
		int canTake=0;
		int left0=0;	//numbit%3==0
		int left1=0;	//numbit%3==1
		int left2=0;	//numbit%3==2
		for(int i=0;i<numStr.length();i++) {	//將numbit分類好讓我們去分析
			int numbit=Integer.parseInt(numArr[i]);
			sum+=numbit;	//計算
			if(numbit%3==0) left0++;
			else if(numbit%3==1) left1++;
			else if(numbit%3==2) left2++;
		}
		canTake=left0;
		if(sum==0) return "T";	//0的情況
		//怎麼樣的情況可以移掉left2或lest1的位元?
		//如果初始sum並非3的倍數，那麼一個left1或left2可以讓結果位元和為3的倍數
		if((sum%3==1)&&(left1!=0)) 	canTake++;	//移動一個left1,將會使sum變成3的倍數(和三倍數差1)
		else if((sum%3==2)&&(left2!=0)) canTake++;	//移動一個left2,將會使sum變成3的倍數(和三倍數差2)	
		//根據總共可以拿得bit有多少
		if(canTake%2==0) return "T";
		else return "S";
	}
}
