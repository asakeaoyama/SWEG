import java.util.Scanner;
public class uva_10252_CommonPermutation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String str1= sc.nextLine();
			String str2= sc.nextLine();
			int arr1[]= new int[26];
			int arr2[] = new int[26];
			for(char c1: str1.toCharArray()) {
				if('a'<=c1&&c1<='z') arr1[c1-'a']++;}
			for(char c2: str2.toCharArray()) {
				if('a'<=c2&&c2<='z') arr2[c2-'a']++;}
			for(int y=0;y<26;y++) {
				int pp= Math.min(arr1[y],arr2[y]);
				if(pp!=0) {
					for(int o=0;o<pp;o++) System.out.print((char)('a'+y));}
			}
			System.out.println();
		}
		sc.close();
	}

}
