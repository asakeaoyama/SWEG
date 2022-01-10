package p1223_1;

public class Human {
	
	public int a =1;
	protected int b =2;
	int c =3; //default
	private int d = 4;
	
	void m1(){
		a =10;
		b = 20;
		c = 30;
		d = 40;
	}
	
	public int getd() {	//其他class取得d的遙控器
		return d;
	}
	
	protected void m2() {
		System.out.println("Using m2 of Huamn");
	}
}
