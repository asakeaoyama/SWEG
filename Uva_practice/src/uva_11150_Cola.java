import java.util.Scanner;

public class uva_11150_Cola {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		while(sc.hasNextInt()) {
			int num= sc.nextInt();	//有裝可樂的瓶子
			int left=0;	//目前有幾個空瓶
			int sum=0;	//共喝幾瓶
			if(num<3) sum=sum+num;
			while(num+left>=3) {
				sum+=num;
				left+=num;
				num=left/3;	
				left%=3;
				if(num+left<3) sum=sum+num;
			}
			if(num+left==2) sum++;
			System.out.println(sum);
		}
		sc.close();
	}

}
