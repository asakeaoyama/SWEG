import java.util.Scanner;

public class uva_10235_SimplyEmirp {
	public static void  main(String[] args) {
		Scanner sc= new Scanner(System.in);
		while(sc.hasNext()) {
			int num= sc.nextInt();
			
			if(isPrime(num)==false)  {System.out.println(num+" is not prime.");}
			else {
				//翻轉
				int numR=reverse(num);
				//判斷翻轉後的數有沒有一樣
				//判斷翻轉後的數是不是質數
				if (numR==num) {System.out.println(num+" is prime.");}
				else if (isPrime(numR)==false) {System.out.println(num+" is prime.");}
				else {System.out.println(num+" is emirp.");}
			}
		}
	sc.close();
	}
	//翻轉數字
	public static int reverse(int n) {
		int result =0;
		while(true) {
			int num= n%10;
			result= result*10+num;
			n=n/10;
			if (n==0) return result; 
		}
	}
	//確認是不是質數
	public static boolean isPrime(int n) {
		if (n==2) return true;
		else if (n%2==0 && n!=2) return false; 
		else {
			int sqn= (int)Math.floor(Math.sqrt(n));	//若N是合數，必有一個為<=sqrt(N)
			for(int i=3; i<=sqn;i+=2) {
				if (n%i==0) return false;}
		return true;}
	}
}
