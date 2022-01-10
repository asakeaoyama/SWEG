package p1230_1;

public class Client {
	public static void main(String[] args) {
		C obj =  new D();
		obj.m1(); 
		//obj.m2(); //m2不能用 因為只能使用 C 宣告的東西
	}
}
