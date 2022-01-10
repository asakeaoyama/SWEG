import java.util.Scanner;

public class uva_272_TEXQuotes {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		boolean flag= false;	//兩次''   ``
		
		while (sc.hasNext()) {
			String str= sc.nextLine();	//不會讀跳行
			for (int y=0; y<str.length();y++) {		
				if (str.charAt(y)=='"') {
					if (flag==false) {System.out.print("``"); flag= true;}
					else {System.out.print("''"); flag= false;}
				}
				else {
					System.out.print(str.charAt(y));
				}
			}
			System.out.println();	//跳行
		}
		sc.close();
	}
}
