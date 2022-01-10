package p1223_2;
public class Client1223 {

	public static void main(String[] args) {
		System.out.println("R : parent I : parent");
		Super1223 obj1= new Super1223();	//宣告的參考:父代 / 產生實體:父代
		System.out.println(obj1.a);
		obj1.m();
		System.out.println();
		
		System.out.println("R : parent I : child");
		Super1223 obj2 =new Sub1223();
		System.out.println(obj2.a);
		obj2.m();	//多形
		System.out.println();
		/*
		System.out.println("R : child I : parent");
		Sub1223 obj3 =(Sub1223)new Super1223();	
		//可以強制轉型騙過
		System.out.println(obj3.a);
		obj3.m();
		System.out.println();
		*/
		System.out.println("R : child I : child");
		Sub1223 obj4 =new Sub1223();
		System.out.println(obj4.a);
		obj4.m();
		System.out.println();
	}

}
