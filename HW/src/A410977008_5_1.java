import java.util.Scanner;
import java.util.ArrayList;
public class A410977008_5_1 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		while(sc.hasNext()) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			System.out.println(n+" "+m);
			if (n==0&&m==0)		break;
			ArrayList<Integer> oddArr= new ArrayList<Integer>();
			ArrayList<Integer> evenArr= new ArrayList<Integer>();
			ArrayList<Integer> finArr= new ArrayList<Integer>();
			int oddArrl=0;
			int evenArrl=0;
			for(int i=0; i<n;i++) {		
				int num = sc.nextInt();
				if(num%2==1) {oddArr.add(num); oddArrl+=1;}	//奇數陣列
				else {evenArr.add(num);evenArrl+=1;}		//偶數陣列
			}		
			//use 插入排序法
			//奇數陣列由大到小	
			int temp=0;
			int j;
			for (int i = 1; i <oddArrl; i++){		//第二個跟第一個比,第三個跟第二個比
				temp=oddArr.get(i);
				for (j=i ; j>0&&temp>oddArr.get(j-1);j--) {
					oddArr.set(j,oddArr.get(j-1));
				}
				oddArr.set(j,temp);
	        }
			//偶數陣列由小到大
			int tem=0;
			for (int i = 1; i <evenArrl; i++){	
				tem=evenArr.get(i);
				for (j=i ; j>0&&tem<evenArr.get(j-1);j--) {
					evenArr.set(j,evenArr.get(j-1));
				}
				evenArr.set(j,tem);
	        }
			int finArrl=0;
			// 餘數的迴圈
			for(int o=(1-m); o<m;o++) {	
				for (int i=0; i<oddArrl;i++) {	//先用奇數迴圈
					if (oddArr.get(i)%m==o) {
						finArr.add(oddArr.get(i));finArrl+=1;}
				}
				for(int u=0;u<evenArrl;u++) {	//再用偶數迴圈
					if (evenArr.get(u)%m==o) {
						finArr.add(evenArr.get(u));finArrl+=1;}
				}
			}
			//將finArr陣列印出來
			for(int y=0; y<finArrl;y++) {
				System.out.println(finArr.get(y));
			}	
		}
		sc.close();
		}		
	}
