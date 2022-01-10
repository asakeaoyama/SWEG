import java.util.Scanner;
import java.util.Arrays;
public class uva_10420_ListofConquests {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int cases= Integer.parseInt(sc.nextLine());
		String country[]= new String[cases];
		for(int c=0; c<cases; c++) {
			String str= sc.nextLine();
			String ss[]=str.trim().split(" ");
			country[c]= ss[0];
		}
		Arrays.sort(country);
		int count=0;
		String temp="";
		for(int k=0; k<cases; k=k+count) {
			temp=country[k];
			count=0;
			for(int j=0; j<cases;j++) {
				if(temp.equals(country[j])) {
					count++;}
			}
			System.out.println(temp+" "+count);
		}
		sc.close();
	}
}
