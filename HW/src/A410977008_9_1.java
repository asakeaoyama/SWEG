import java.util.Scanner;
public class A410977008_9_1 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		while(sc.hasNextInt()) {
			int king=sc.nextInt();
			int queen=sc.nextInt();
			int queenNow=sc.nextInt();
			if(king==queen) System.out.println("Illegal state");
			else if(isIllegalMove(king,queen ,queenNow))System.out.println("Illegal move");
			else if(isMoveNotAllowed(king, queenNow)) System.out.println("Move not allowed");
			else if(isStop(king, queenNow)) System.out.println("Stop");	
			else  System.out.println("Continue");	
		}
		sc.close();
	}
	//如果兩數/8結果相同>>同一橫排 如果兩數的差為8的倍數>>同一直排
	static boolean isIllegalMove(int king, int queen ,int queenNow) {
		int distance1=Math.abs(queenNow-queen);
		if(queenNow==king||queenNow==queen||(queenNow/8!=queen/8&&distance1%8!=0)) return true;	//兩點相同或是斜線移動
		int distance2=Math.abs(king-queenNow);
		int distance3=Math.abs(king-queen);
		if(((queenNow/8==king/8)&&(king/8==queen/8))||(distance2%8==0&&distance3%8==0)) {	  //如果三點在 同一橫排上 或是 同一條直排
			if((queenNow>king&&king>queen)||(queenNow<king&&king<queen)) return true;	//不能產生queenNow king queen的順序
		}
		return false;
	}
	static boolean isMoveNotAllowed(int king, int queenNow) {	
		int distance1=Math.abs(queenNow-king);
		if((distance1==1&&(king/8==queenNow/8))||distance1==8) return true;	//兩者差一且在同一橫排 || 兩者差8>>同一直排
		return false;
	}
	static boolean isStop(int king, int queenNow){	//queenNow封鎖兩方位 Stop需四方位都被封鎖 所以king要是角落的點
		if((king==0&&queenNow==9)||(king==7&&queenNow==14)||(king==56&&queenNow==49)||(king==63&&queenNow==54))  return true;
		return false;
	}
}
