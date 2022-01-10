import java.util.Scanner;

public class uva_490_RotatingSentences {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		char cL[][]= new char[101][101]; 
		int strLong[]= new int[101];
		int lines=0,maxStr=0;
		while(true) {
			String str= sc.nextLine();
			if(str=="") {break;}
			int strL=str.length();
			strLong[lines]=strL;
			if (strL>maxStr) {maxStr=strL;}
			for(int y=0;y<strL;y++) {
				cL[lines][y]=str.charAt(y);
			}
			lines+=1;
		}
		for(int i=0;i<maxStr;i++ ) {
			for(int u=lines-1;u>=0;u--) {
				if(strLong[u]<=i) {System.out.print(" ");}
				else {
				System.out.print(cL[u][i]);}
			}
		System.out.println();
		}
		sc.close();
	}
}
