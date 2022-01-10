package p1223_1;

public class HumanSub_1 extends Human{
	
	int getB(){
		return b;	//在父類別的variable
	}
	
	void setB(int value) {
		b = value;
	}
	
	protected void m2() {
		System.out.println("this is super m2");
		super.m2();	
	}
}
