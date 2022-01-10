import java.util.Scanner;
//泡泡排序車廂
public class uva_00299_TrainSwapping {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int cases = sc.nextInt();
		for (int c =0;c<cases; c++) {
			int train = sc.nextInt();
			int num[]= new int[train];
			for(int u=0; u<train;u++) {
				num[u]=sc.nextInt();
			}
			//泡泡排序法 : 兩兩比較
			int swap=0;
			for (int t=0; t<train ;t++) {
				for(int i=0; i<train-1;i++) {
					if(num[i]>num[i+1]) {
						int temp;
						temp=num[i];
						num[i]=num[i+1];
						num[i+1]=temp;
						swap+=1;}
				}
		}
		System.out.println("Optimal train swapping takes "+swap+" swaps.");
	}
	sc.close();	
}
}
