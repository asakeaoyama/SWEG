
import java.util.Scanner;
public class uva_10062_Tellmethefrequencies {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int cases=0;
		while(sc.hasNext()) {
			String str= sc.nextLine();
			if(str=="") {break;}
			if(cases!=0)System.out.println();
			int arr[]= new int[127];
			int max=0;
			for(int i=0;i<str.length();i++) arr[str.charAt(i)]++;	//每個字元的出現次數
			for(int i=0;i<arr.length;i++) {if(arr[i]>max) max=arr[i];}	//出現最大的次數
			//output
			for(int y=1; y<=max; y++) {
				for(int k=arr.length-1;k>=0;k--) {	//由大到小的全部127個ASCII碼
					if(arr[k]==y) {System.out.println(k+" "+arr[k]);}
				}
			}
		cases+=1;
		}
		sc.close();
	}

}
/*
用一個arr當作127個ASCII的家,再將這個ASCII出現幾次放上去([編號]就代表ASCII是幾位)
得出多次數，再依序println出
*/