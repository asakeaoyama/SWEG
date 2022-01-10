import java.util.Scanner;

public class A410977008_12_1 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int cases=Integer.parseInt(sc.nextLine());
		for(int z=0;z<cases;z++) {
			String Equations= sc.nextLine();
			calculate(Equations);
		}
		sc.close();
	}
	static void calculate(String Equations) {
		/*計算式格式 ax+b = cx+d，並可以移位成 x=-(d-b)/(c-a)，我們以此式為基底進行運算*/
		//判斷字元 遇到非數字字元就停止加總數字值
		int x=0,constant=0;	//x係數(c-a);常數(d-b)
		int tempSum=0;	//儲存係數或常數
		int carry=1;	//數值進位
		boolean isPluse=true;	//紀錄這個數值是要加還是減
		for(int position=0;position<Equations.length();position++) {
			char cha= Equations.charAt(position);
			//System.out.println("before "+cha+" ;tempSum= "+tempSum+" ; x : "+x+" ; caonstant : "+constant);
			if(cha=='x') {
				if(isPluse) {
					if(position>0&&(Equations.charAt(position-1)!='0')&&tempSum==0) x++;
					else if(position==0&&(tempSum==0))	x++; //省略係數為1
					else	x+=tempSum;
				}
				else {
					if(tempSum==0)	x--; 
					else	{x-=tempSum;}
				}
				carry=1;tempSum=0;
			}
			else if(cha=='+'||cha=='-') {
				if(isPluse) constant+=tempSum;
				else constant-=tempSum;
				
				if(cha=='+')isPluse=true;
				else isPluse= false;
				carry=1;tempSum=0;
			}
			
			else if(cha=='=') {
				if(isPluse) constant+=tempSum;
				else constant-=tempSum;
				x=0-x;	//將一個負號在a總和的前面,製造-a
				constant=0-constant;
				carry=1;tempSum=0;isPluse=true;
			}
			else {	//數字0-9
				tempSum=(tempSum*carry)+(cha-'0');
				carry=10;
			}
			//System.out.println("after: "+cha+" ;tempSum= "+tempSum+" ; x : "+x+" ; caonstant : "+constant);
		}
		if(isPluse)constant+=tempSum;	//最後將剩餘的tempSu加進constant中
		else constant-=tempSum;
		//System.out.println("after: "+" ;tempSum= "+tempSum+" ; x : "+x+" ; caonstant : "+constant);
		if((x==0&&constant==0)) { System.out.println("IDENTITY");return;}
		if(x==0) {System.out.println("IMPOSSIBLE");return;}
		else {
		System.out.println( Math.floorDiv((0-constant),x));	// 因為目前計算的值為(b-d)/(a-c) 需多加一個負號
		}	
	}
}
