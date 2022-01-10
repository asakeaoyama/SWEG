import java.util.Scanner;
public class uva_10908_EbAltoSaxophonePlayer {
	static String noteArr[]= {"c0111001111","d0111001110","e0111001100","f0111001000","g0111000000","a0110000000","b0100000000","C0010000000","D1111001110","E1111001100","F1111001000","G1111000000","A1110000000","B1100000000"};
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int cases=Integer.parseInt(sc.nextLine());
		for(int z=0; z<cases;z++) {	
			String str= sc.nextLine();
			int count[]= new int[10];	//紀錄每一個手指按了幾次(output)
			String nowfinger= "0000000000";	//紀錄現在手指位址v
			for(int j=0;j<str.length();j++) {
				String note="";
				//找出目前英文字所需要的鑑
				for(int q=0;q<14;q++ ) {
					if(noteArr[q].charAt(0)==str.charAt(j))  {
					note= noteArr[q].substring(1);
					break ;}
				}
				//判斷指法是否++
				for(int i=0;i<10;i++) {	//10根手指頭
					if(nowfinger.charAt(i)=='0'&&note.charAt(i)=='1') {
						count[i]++;}
				}
				nowfinger=note;
			}
			//output
			for(int y=0;y<10;y++) {
				if(y!=0) {System.out.print(" ");}
				System.out.print(count[y]);
			}
			System.out.println();
		}
		sc.close();
	}
}