import java.util.Scanner;
public class A410977008_2_1_PrimaryArithmetic{
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		while(true) { 
			String aStr=sc.next(); //sc.next()���]�t�ť�
			String bStr=sc.next();
			if (aStr.equals("0")&& bStr.equals("0")) break; //��String�۵�:�ϥ�a.equals(b)
			int aSpace=aStr.length(); //��Ƥ��@�w�P���
			int bSpace=bStr.length();
			int bgSpace,smSpace;
			String smStr,bgStr;
			if (aSpace<bSpace) {bgSpace=bSpace;smSpace=aSpace;bgStr=bStr;smStr=aStr;} //�P�_�j�p
			else {bgSpace=aSpace;smSpace=bSpace;bgStr=aStr; smStr=bStr;}
			smStr=reverse(smStr); //reverse(),�]���[�k�O�ѥk�ӥ��p��
			bgStr=reverse(bgStr);
			String[] smArr=smStr.split("");	//��split�s��array
			String[] bgArr=bgStr.split("");
			int sum=0;	//�榸�[�k�`�M
			int carry=0;	//�i��
			int carrycount=0;	//�@���X���i��
			for(int i=0;i<bgSpace;i++) { //���θ��j��ư��j��(�M�w�n���X���[�k)�A�n�O���p��Ƥ���Ƥ���(if)�A�N��0
				if (i>=smSpace) {	
					int b = Integer.parseInt(bgArr[i]);
					sum= b+carry; 
					if (sum>=10) {carry=1;carrycount+=1;}
					else carry=0;
				} 
				else{
					int b = Integer.parseInt(bgArr[i]); //use Integer.parseInt() �NString�নInt
					int s = Integer.parseInt(smArr[i]);
					sum= b+s+carry;
					if(sum>=10) {carry=1;carrycount+=1;}
					else carry=0;
				}
			}//for()
			if(carrycount==0)System.out.println("No carry operation.");
			else if(carrycount==1)System.out.println("1 carry operation.");
			else System.out.printf("%d carry operations.\n",carrycount);
		} //while true
		sc.close();			
	}
	static String reverse(String str){  //�ŧireverse()����k
	    StringBuilder Str=new StringBuilder(str);  //use StringBuilder(�i�ܰʪ��r���r��)
	    Str.reverse();  
	    return Str.toString();  
	}  

}


