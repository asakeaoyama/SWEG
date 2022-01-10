import java.util.Scanner;
import java.util.ArrayList;
public class A410977008_3_1_MutantFlatworldExplorers {

	public static void main(String[] args) {
		//input
		Scanner sc=new Scanner(System.in);
		int xbon= sc.nextInt();	//x 邊界
		int ybon= sc.nextInt();	//y邊界
		ArrayList<String> lostScent= new ArrayList<String>();	//存放Scent 
		
		while(sc.hasNext()) {	
			//*處理input和lst
			int xc=sc.nextInt();	//目前x
			int yc=sc.nextInt();	//目前y
			String faceto=sc.next();	//目前面向
			String ccc=sc.next();
			String[] conset=ccc.split("");	//將指令存成指令array
			//*處理input和lst
			String check="";		//當前check
			String checkPre="";		//前一個check
			int xPre=xc;	//前一個xc
			int yPre=yc;	//前一個yc
			String facetoPre=faceto;	//前一個faceto
			boolean checkbl=true;	//檢測前一個點是不是Scent
			String fina="";	   //最後print的答案

			//******一個一個讀入指令
			for(int k=0; k<conset.length;k++) {	
				String con= conset[k];
						//*機器人實施指令
						if (con.equals("F")) {
							switch(faceto) {
								case "N":	yc+=1;break;
								case "E":	xc+=1;break;
								case "S":	yc-=1;break;
								case "W":	xc-=1;break;	}	}
						else faceto=turn(faceto,con);
						//*機器人實施指令
				check=xc+" "+yc+" ";
				if(lostScent.indexOf(check)!=-1 && faceto.equals("N")) {	//這個點有在lostScent中!
					checkbl =false;}
				if(xc>xbon || yc>ybon ||yc<0||xc<0) {	//超出邊界
					if (checkbl==true) {
						lostScent.add(checkPre);
						fina=checkPre+facetoPre+" "+"LOST";//如果掉下來，輸出上一個的位置，並break a
						break ;}	//代表換下一個機器人
					else {							//如果上一個點在lostScent，並這次要掉下去了!
						xc=xPre;					//就刪除此次指令，並矯正回歸，跳向下一個指令
						yc=yPre;
						faceto=facetoPre;
						check=checkPre;
						checkbl=true;}
				}
				fina=check+faceto;
				checkPre=check;
				xPre=xc;
				yPre=yc;
				facetoPre=faceto;
			}
			//******一個一個讀入指令
			System.out.println(fina);
		}
		sc.close();
	}

	
	public static String turn(String faceto,String con) {	//轉向的method
		switch(con) {
			case "L" :
				switch(faceto) {
					case "N":
						return "W";
					case "E":
						return "N";
					case "S":
						return "E";
					case "W":
						return"S"; }
			case "R" :
				switch(faceto) {
					case "N":
						return"E";
					case "E":
						return "S";
					case "S":
						return "W";
					case "W":
						return "N";}
		}
		return null;
	}
		
}

