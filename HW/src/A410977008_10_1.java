import java.util.Scanner;

public class A410977008_10_1 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		while(sc.hasNextInt()) {
			int num= sc.nextInt();
			if(num==0) break;
			int count1=0;
			int count2=0;
			int numcopy=num;
			while(!isPrime(numcopy)) {	//小於n的質數和n相差多少
				count1++;
				numcopy--;
			}
			while(!isPrime(num)) {	//大於n的質數和n相差多少
				count2++;
				num++;
			}
			System.out.println(count1+count2);
		}
		sc.close();
	}
	static boolean isPrime(int n) {
		if(n==2||n==3) return true;
		else if(n>4) {
			int check=n%6;
			if(check!=5&&check!=1) return false;
			int sqrt =(int)Math.floor(Math.sqrt(n)) ;
			for(int y=5; y<=sqrt;y+=6) {
				if(n%y==0||n%(y+2)==0) return false;
			}
			return true;
		}
		else {
		return false;
		}
	}
}
/*關於判斷質數的function，因為所有數都可以表示成6n+k(1<=k<=5)
只要數的k不為1或5，就不是質數，先就這點進行篩選
接下來for迴圈的部分，結合埃拉托斯特尼篩法(根號n)
檢查剩下的數因數中有沒有6n+1或6n-1(6n+5可以表示成(6(n+1)-1))
 */
 