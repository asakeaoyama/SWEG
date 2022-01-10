import java.util.Scanner;
import java.util.Arrays;
public class uva_10008_WhatsCryptanalysis {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int cases=sc.nextInt();
		cases+=1;
		String stra[] = new String[cases] ;
		
		for(int s=0;s<cases;s++) {
			String str= sc.nextLine();
			str=str.toUpperCase();
			stra[s]=str;
		}
		
		for(String kk: stra) {
			System.out.println(kk);
		}
		
		int counter[] = new int[26];
		int position[] =new int[26];
		for(int u=0 ; u<26;u++) {
			position[u]=u;}
		Arrays.fill(counter,0);
		for(String str: stra ) {
			char[] test= str.toCharArray();
			for(char c: test) {
				if('A'-0<=c-0&&c-0<='Z'-0) {
					counter[c-'A'-0]+=1;}
			}
		}
		int key;	// save current element 
		int key1;
		for(int i=0; i<26;i++) {
			int j=i;	 // current position 
			key= counter[j];
			key1= position[j];
			while( j>0&&counter[j-1]<key) {	// compare current element 
				counter[j]=counter[j-1];
				position[j]= position[j-1];	//shift it
				j--;
			}
			counter[j]=key;
			position[j]=key1;
		}
		//println
		for(int y=0; y<26;y++) {
			char cc= (char) (position[y]+'A');
			if(counter[y]==0) {break;}
			else {
				System.out.println(cc+" "+counter[y]);
			}
		}
		sc.close();
	}
}
/*
3
This is a test.
Count me 1 2 3 4 5.
Wow!!!! Is this question easy?
S 7
T 6
I 5
E 4
O 3
A 2
H 2
N 2
U 2
W 2
C 1
M 1
Q 1
Y 1
 */
