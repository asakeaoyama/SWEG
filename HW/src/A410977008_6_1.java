import java.util.Scanner;

public class A410977008_6_1 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		while (true) {
			int cases = sc.nextInt();	//有幾個指令
			if (cases==0) {break;}
			int die[] = {1,6,2,3,5,4};			//上下北西南東位置之點數
			//了解骰子的點數在經過指令後事如何改變的
			for (int i=0 ; i<cases; i++) {
				String commends = sc.next();  
				
				//換位置
				if (commends.equals("north")) {
					int temp1=die[0];
					die[0] = die[4];	//每次指令有四個數字被移動
					die[4] = die[1];
					die[1] = die[2];
					die[2] = temp1;
					//System.out.println("now N: "+die[0]);
				}
				else if (commends.equals("south")) {
					int temp2=die[0];
					die[0] = die[2];
					die[2] = die[1];
					die[1] = die[4];
					die[4] = temp2;
					//System.out.println("now S: "+die[0]);
				}
				else if(commends.equals("east")) {
					int temp3=die[0];
					die[0]= die[3];
					die[3] = die[1];
					die[1] = die[5];
					die[5] = temp3;
					//System.out.println("now E: "+die[0]);
				}
				else {		//west
					int temp4=die[5];
					die[5] = die[1];
					die[1] = die[3];
					die[3] = die[0];
					die[0] = temp4;
					//System.out.println("now W: "+die[0]);
				}
			}
			System.out.println(die[0]);
		}
		sc.close();
	}
}
